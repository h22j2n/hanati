<%@page import="java.util.Calendar"%>
<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body style="font-size: 20pt;">
<%-- JSP 테스트를 위한 페이지 입니다.--%>
<%
// 여기에 자바코드를 쓰면 됨!!!!!

String message = "이넘이 jsp 실행과정 입니다..";
Calendar today = Calendar.getInstance();
out.println(today.toString()); // out은 jsp에 미리 생성되어 있음
%>
======================<br>
<%out.write("jsp 별거 아니에용~"); %>
<br>
==============<br>
<%out.println("별거 아님쓰~");
%>

<%-- 선언문 --%>
<%!
int counter;
public void printMessage(String message){
  System.out.println(message);
}
%>

<%
String msg = "조금 쉬었다 합시당..";
//out.println(msg); // 서블릿 방식
%>
메시지 : <%=msg%> 입니다..

</body>
</html>