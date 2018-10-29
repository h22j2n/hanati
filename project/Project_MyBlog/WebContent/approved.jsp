<%-- 회원가입 성공시 보여주는 화면 --%>

<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>HeeJinny-Blog</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<%-- Favicons --%>
<link href="/img/pig.png" rel="icon">
<link href="/img/pig.png" rel="apple-touch-icon">

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


</head>

<body>

  <%-- 탑메뉴 시작 --%>
  <jsp:include page="/include/top/topnav.jsp"></jsp:include>
  <%-- 탑메뉴 끝 --%>

  <%-- 내용 시작 --%>
  <jsp:include page="/include/content/approvedcontent.jsp"></jsp:include>
  <%-- 내용 끝 --%>

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
