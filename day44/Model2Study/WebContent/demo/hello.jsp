<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>메시지 : ${requestScope.message}</h2>

<h2>팀명</h2>
<ul>
  <c:forEach items="${list}" var="team">
  <li>${team}</li>
  </c:forEach>
</ul>

</body>
</html>