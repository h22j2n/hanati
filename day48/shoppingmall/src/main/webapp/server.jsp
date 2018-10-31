<%@ page contentType="text/html; charset=utf-8" %>
<%
String number1 = request.getParameter("num1");
String number2 = request.getParameter("num2");
double  num1 =0;
double  num2 =0;
if(number1 != null){
  num1 =  Integer.parseInt(number1);
}
if(number1 != null){
    num2 =  Integer.parseInt(number2);
  }
String operator = request.getParameter("selector");
double result = 0;
 if(operator.equals("-")){
  result = num1 - num2;
}else if(operator.equals("*")){
 result = num1 * num2; 
}else if(operator.equals("/")){
 result = num1/num2; 
}else{
  result = num1 + num2;
}
out.println(result);
%>