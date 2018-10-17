<%@ page contentType="text/html; charset=utf-8" %>
<%
String firstName = request.getParameter("firstname");
String lastName = request.getParameter("lastname");
String country = request.getParameter("country");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%= firstName %><br>
<%= lastName %><br>
<%= country %><br>
</body>
</html>