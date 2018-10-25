<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="message" value="jstl <연습>입니다." scope="page"/>


<jsp:useBean id="dog" class="kr.or.kosta.jsp.el.Dog" scope="page"/>
<c:set target="${dog}" value="뽀삐" property="name"/>
<c:remove var="message"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
${message }
<c:out value="조희진"/><br>
<c:out value="${message}" default="기본 메시지 입니다.."/><br>
강아지 이름 : ${dog.name}
</body>
</html>