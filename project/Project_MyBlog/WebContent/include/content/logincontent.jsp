<%-- 로그인 화면 content --%>


<%@ page contentType="text/html; charset=utf-8"%>
<script>
/* 알림창 띄우기 */
function notice(id) {
  var x = document.getElementById(id);
  x.className = "show";
  setTimeout(function() {
    x.className = x.className.replace("show", "");
  }, 3000);
};

</script>

<div id="nomember">아이디와 비밀번호를 확인해주세요.</div>

<%
	if (request.getParameter("member") != null) { // 아이디, 비밀번호가 일치하지 않을 시
		if (request.getParameter("member").equals("no")) {
%>
<script>
    notice('nomember')
    </script>
<%
	}
	}
%>

<div id="headerwrap">
  <div class="col-lg-12">
    <div id="loginForm">
      <h1>Sign In</h1>
      <div class="clear-loading spinner">
        <span></span>
      </div>
      <div class="w3ls-login box box--big">
        <!-- form starts here -->
        <form action="/users/login_action.jsp" method="post">
          <div class="agile-field-txt">
            <label><i class="fa fa-user" aria-hidden="true"></i>
              User Id </label> <input type="text" id="loginuserid" name="userid"
              placeholder="Enter User Id" required="" />
          </div>
          <div class="agile-field-txt">
            <label><i class="fa fa-unlock-alt"
              aria-hidden="true"></i> password </label> <input type="password"
              name="userpw" placeholder="Enter Password" required=""
              id="myInput" />
            <div class="agile_label">
              <input id="check3" name="check3" type="checkbox"
                value="rememberId"> <label class="check"
                for="check3">Keep Id</label>
            </div>
            <div class="agile-right">
              <a href="signup.jsp">New to HeeJinny?</a>
            </div>
          </div>
          <input type="submit" value="LOGIN">
        </form>
      </div>
    </div>
  </div>
</div>

<%
	Cookie[] cookies = request.getCookies();
	boolean flag = false;
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("remember")) {
				String rememberId = cookie.getValue();
				flag = true;
%>
                <script>
				document.getElementById('loginuserid').value = "<%=rememberId%>";
				document.getElementById('check3').checked = true;
				</script>
<%
	}
  }
}
%>