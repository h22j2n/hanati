<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>jsp가 제공하는 4개의 스코프(컨텍스트) 객체들..</h2>
<%
// 지역변수말고 전역변수로 저장하고 싶을 때 
pageContext.setAttribute("message", "pageContext 스코프 객체입니다.");

request.setAttribute("message", "request 스코프 객체입니다.");
//application.getRequestDispatcher("/scopeObject2.jsp").forward(request, response);

// 동일한 브라우저를 사용하는 모든 jsp를 위해~
session.setAttribute("message", "session 스코프 객체입니다.");

// 모든애들이 공유하는 정보를 저장
application.setAttribute("message", "application 스코프 객체입니다.");

%>

현재 페이지 정보 : <%= pageContext.getAttribute("message") %>

<%= pageContext.findAttribute("이름") %>

</body>
</html>