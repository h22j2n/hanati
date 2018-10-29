<%-- 홈화면 --%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.visitor.domain.Visitor"%>
<%@page import="kr.or.kosta.blog.visitor.dao.VisitorDao"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>HeeJinny-Blog</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">


<%-- Favicons --%>
<link href="<%=application.getContextPath() %>img/pig.png" rel="icon">
<link href="<%=application.getContextPath() %>img/pig.png" rel="apple-touch-icon">

<%-- Google Fonts --%>
<link
  href="https://fonts.googleapis.com/css?family=Raleway:400,700,900|Lato:400,900"
  rel="stylesheet">

<%-- Bootstrap CSS File --%>
<link href="/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<%-- Libraries CSS Files --%>
<link href="/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="/lib/prettyphoto/css/prettyphoto.css" rel="stylesheet">
<link href="/lib/hover/hoverex-all.css" rel="stylesheet">

<%-- Main Stylesheet File --%>
<link href="/css/style.css" rel="stylesheet">

<%-- 로그인 화면 css --%>
<link href="/css/font-awesome.css" rel="stylesheet">
<link href="/css/login.css" rel='stylesheet' type='text/css' />
<link href="/css/signup.css" rel='stylesheet' type='text/css' />


</head>

<body>

  <%-- 탑메뉴 시작 --%>
  <jsp:include page="/include/top/topnav.jsp"></jsp:include>
  <%-- 탑메뉴 끝 --%>

<%-- 내용 시작 --%>
<%
DaoFactory factory = (DaoFactory) application.getAttribute("factory");
VisitorDao dao = factory.getVisitorDao();
List<Visitor> list = dao.listAll();
Cookie[] cookies = request.getCookies();
boolean flag = false;
String loginId =null;
if(cookies != null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("loginId")){
    loginId = cookie.getValue();
    flag = true;
  %>
  <%-- 로그인 되어 있을 시 --%>
<jsp:include page="/include/content/homecontent.jsp"></jsp:include>
  <% break;
  }
  
}
}

if(!flag){%>
<%-- 로그인 안되있을 시 --%>
  <jsp:include page="/include/content/logincontent.jsp"></jsp:include>
<%}
boolean check = false;
 if(flag){
     Visitor visitor2 = new Visitor();
  for(Visitor visitor : list){
   if(visitor.getVisitor_id().equals(loginId)){
	   dao.delete(loginId);
		 visitor2.setVisitor_id(loginId);
		 dao.create(visitor2); 
      check = true;
   }
    
  }
  
  if(!check){
	  visitor2.setVisitor_id(loginId);
      dao.create(visitor2);
  }
}%>
  <%-- 내용 끝 --%>


<%-- 사이드바 시작 --%>
<%List<Visitor> list2 = dao.listAll();
int count =0;
%>
<textarea rows="10" cols="15" id="floatdiv" readonly="readonly">
최근 방문자
--------------
<%for(Visitor visitor : list2){
  count++;
if(count < 10){
%>
<%=visitor.getVisitor_id() %>
<% }}%>
</textarea>
<%-- 사이드 바 끝 --%>


  <%-- JavaScript Libraries --%>
  <script src="/lib/jquery/jquery.min.js"></script>
  <script src="/lib/bootstrap/js/bootstrap.min.js"></script>
  <script src="/lib/php-mail-form/validate.js"></script>
  <script src="/lib/prettyphoto/js/prettyphoto.js"></script>
  <script src="/lib/isotope/isotope.min.js"></script>
  <script src="/lib/hover/hoverdir.js"></script>
  <script src="/lib/hover/hoverex.min.js"></script>

  <%-- Template Main Javascript File --%>
  <script src="/js/main.js"></script>

</body>
</html>
