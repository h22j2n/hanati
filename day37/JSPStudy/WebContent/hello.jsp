<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.Calendar" %>
<%@ include file="./jspf/common.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
  <h2>구구단</h2>
  <table border="1" width="80%">
    <%
    	for (int i = 2; i <= 9; i++) {
    %>
    <tr>
      <%
      	for (int j = 1; j <= 9; j++) {
      %>
      <td><%=i%> * <%=j%> = <%=i * j%></td>
      <%
      	}
      %>
    </tr>
    <%
    	}
    %>

  </table>

  <h2>
    당신은
    <%=++count%>번째 방문자입니다..
  </h2>

</body>
</html>