<%@page import="kr.or.kosta.jsp.dao.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%
List<String> teams = new ArrayList<String>();
teams.add("한화 이글즈");
teams.add("두산 베어스");
teams.add("SK 와이번즈");

request.setAttribute("teams", teams);

List<User> users = new ArrayList<User>();
users.add(new User("heejin1", "조희진", "1111", "gmlwls008@gmail.com", "20181024"));
users.add(new User("heejin2", "조희진", "1111", "gmlwls008@gmail.com", "20181024"));
users.add(new User("heejin3", "조희진", "1111", "gmlwls008@gmail.com", "20181024"));
users.add(new User("heejin4", "조희진", "1111", "gmlwls008@gmail.com", "20181024"));
new User();
request.setAttribute("users", users);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="i" begin="1" end="10" step="1">
${i} : 희진만세<br>
</c:forEach>

<table border="1">
<c:forEach var="i" begin="2" end="9" step="1">
  <tr>
    <c:forEach var="j" begin="1" end="9">
      <td>
        ${i} X ${j} = ${i*j}<br>
      </td>
    </c:forEach>
  </tr>
</c:forEach>
</table>

<select>
<c:forEach var="team" items="${teams}">
  <option>${team}</option>
  </c:forEach>
</select>

<table border="1">
<tr>
<th>번호</th>
<th>아이디</th>
<th>이름</th>
<th>비밀번호</th>
<th>이메일</th>
<th>가입날짜</th>
</tr>

<c:choose>
<c:when test="${not empty users}">
<c:forEach var="user" items="${users }" varStatus="status">
<tr>
  <td>${status.count} </td>
  <td>${user.id}</td>
  <td>${user.name}</td>
  <td>${user.passwd}</td>
  <td>${user.email}</td>
  <td>${user.regdate}</td>
</tr>
</c:forEach>
</c:when>
<c:otherwise>
<tr>
<td colspan="5">회원이 존재하지 않습니다.</td>
</tr>
</c:otherwise>
</c:choose>
</table>

<%
String ssn = "950204-2134567";
request.setAttribute("ssn", ssn);
%>

<c:forTokens var="token" items="${ssn}" delims="-">
${token}
</c:forTokens>

</body>
</html>