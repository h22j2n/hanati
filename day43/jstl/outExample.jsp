<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String message = "jstl <연습>입니다.";
request.setAttribute("message", message);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
${message }<br>
<c:out value="조희진"/><br>
<c:out value="${messageㅇㅇㅇ}" default="기본 메시지 입니다.."/><br>

</body>
</html>