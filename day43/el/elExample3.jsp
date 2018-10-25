<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL 디폴트 객체(11개)</title>
</head>
<body>
<%
// 테스트를 위한 Scope객체에 데이터 저장
String today = String.format("%1$tF %1$tT", Calendar.getInstance());
request.setAttribute("today", today);

session.setAttribute("id", "bangry");

String[] names = {"김기정", "박기정", "최기정"};
%>

<%= request.getAttribute("today") %><br>
${requestScope.today}<br>
${today}<br>


<%--<%=pageContext.findAttribute("id") --%>
<%-- ${id}<br>--%>

<%--
${names[0]}, ${names[1]}, ${names[2]}<br>
 --%>

<jsp:useBean id="dog" class="kr.or.kosta.jsp.el.Dog" scope="page"/>
<jsp:setProperty property="name" name="dog" value="뽀삐"/>

<jsp:useBean id="student" class="kr.or.kosta.jsp.el.Student" scope="page"/>
<jsp:setProperty property="name" name="student" value="조희진"/>
<jsp:setProperty property="dog" name="student" value="${dog}"/>

<jsp:getProperty property="name" name="student"/>
<jsp:getProperty property="dog" name="student"/>

${student}
${student.dog}
${student.name}


</body>
</html>









