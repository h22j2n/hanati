<%@page import="kr.or.kosta.jsp.Account"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
//Account acc = new Account("1111-2222-3333", "조희진", 1111, 100000);
//Class.forName("kr.or.kosta.jsp.Account").newInstance();

%>
<jsp:useBean id="account" class="kr.or.kosta.jsp.Account" scope="session"></jsp:useBean>

<jsp:setProperty name="account" property="accountNum" value="111-222" />
<jsp:setProperty name="account" property="accountOwner" value="조희진" />
<jsp:setProperty name="account" property="passwd" value="1111" />
<jsp:setProperty name="account" property="restMoney" value="1000000" />

<%--<jsp:forward page="useBeanExample2.jsp"/> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
계좌번호 : <%=account.getAccountNum()%><br>
예금주명 : <%=account.getAccountOwner()%><br>
비밀번호 : <%=account.getPasswd() %><br>
잔액 : <%=account.getRestMoney() %><br>
<br>
계좌번호 : <jsp:getProperty property="accountNum" name="account"/><br>
예금주명 : <jsp:getProperty property="accountOwner" name="account"/><br>
비밀번호 : <jsp:getProperty property="passwd" name="account"/><br>
잔액 : <jsp:getProperty property="restMoney" name="account"/>

</body>
</html>