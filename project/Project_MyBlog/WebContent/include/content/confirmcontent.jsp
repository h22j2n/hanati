<%-- 비밀번호 확인 화면 content --%>
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

/* 패스워드 확인하는 창으로 보내기*/
function sendpw(){
	var pw = document.getElementById("inputpw").value;
	<%String type = request.getParameter("type");%>
	location.href='/users/confirmpw_action.jsp?articleId='+'<%=request.getParameter("articleId")%>'+'&passwd='+pw+'&type='+'<%=type%>';
};

</script>
<div id="toast_confirmpw">비밀번호를 다시 확인해주세요.</div>
<div id="headerwrap">
  <div class="col-lg-12">
    <div class="rowpw">
      <form action="/users/confirmpw_action.jsp">
        <label for="password" class="labels">Password</label> <input
          type="password" name="passwd" id="inputpw"> <input
          type="button" value="CONFIRM" id="checkpasswd"
          onclick=sendpw()>
      </form>
    </div>
  </div>
</div>
<%
	if (request.getParameter("result") != null) {
		if (request.getParameter("result").equals("none")) {
%>
<script>
notice('toast_confirmpw');
</script>
<%
	}
	}
%>

