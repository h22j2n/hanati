<%-- 로그인 아이디(쿠키) 조회 --%>
<%@ page contentType="text/html; charset=utf-8" %>
<%Cookie[] cookies = request.getCookies();
String loginId = null;
boolean flag = false;
if(cookies != null){
 for(Cookie cookie : cookies){
   if(cookie.getName().equals("loginId")){
  loginId =  cookie.getValue();
  flag = true;
  break;
   }
 }
}
%>