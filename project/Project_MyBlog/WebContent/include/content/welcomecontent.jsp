<%-- 로그인 시 보여주는 화면 content --%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@include file="/users/cookie.jsp" %>
<script>

/* 2초 후 홈화면으로*/
function go_home(){
  location.href='/index.jsp';
}
   setTimeout('go_home()',2000);

</script>

   <div id="headerwrap">
     <div class="col-lg-12">
        <div id="loginForm">
        <h2>Welcome <%=loginId%>!</h2>
        <img src="/img/neo.gif"><br>
        <br>
<h4 style="font-size: 20px;">wait a second..</h4>
      </div>
      </div>
  </div>