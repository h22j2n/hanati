<%@ page contentType="text/html; charset=utf-8" %>
<%
  //request.setCharacterEncoding("utf-8");
String number1 = request.getParameter("num1");
int num1 = Integer.parseInt(number1);
String number2 = request.getParameter("num2");
int num2 = Integer.parseInt(number2);
String operator = request.getParameter("selector");
int result = 0;
if(operator.equals("+")){
	result = num1 + num2;
}else if(operator.equals("-")){
  result = num1 - num2;
}else if(operator.equals("*")){
 result = num1 * num2; 
}else if(operator.equals("/")){
 result = num1/num2; 
}
response.sendRedirect("calculator.html?result="+result);

%>