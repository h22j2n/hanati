<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/basic.css">
<%
	String loginId = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loginId")) {
				loginId = URLDecoder.decode(cookie.getValue(), "utf-8");
				break;
			}

		}
	}
%>
</head>
<body>
  <div class="header">
  <h1>My Website</h1>
  <p>Resize the browser window to see the effect.</p>
</div>
  <%-- 탑 메뉴 시작 --%>
  <jsp:include page="/include/navigator.jsp"></jsp:include>
  <%-- 탑 메뉴 끝 --%>
  
  
  <div class="row">
    <div class="leftcolumn">
      <div class="card">
        <h2>TITLE HEADING</h2>
        <h5>Title description, Dec 7, 2017</h5>
        <div class="fakeimg" style="height: 200px;">Image</div>
        <p>Some text..</p>
        <p>Sunt in culpa qui officia deserunt mollit anim id est
          laborum consectetur adipiscing elit, sed do eiusmod tempor
          incididunt ut labore et dolore magna aliqua. Ut enim ad minim
          veniam, quis nostrud exercitation ullamco.</p>
      </div>
      <div class="card">
        <h2>TITLE HEADING</h2>
        <h5>Title description, Sep 2, 2017</h5>
        <div class="fakeimg" style="height: 200px;">Image</div>
        <p>Some text..</p>
        <p>Sunt in culpa qui officia deserunt mollit anim id est
          laborum consectetur adipiscing elit, sed do eiusmod tempor
          incididunt ut labore et dolore magna aliqua. Ut enim ad minim
          veniam, quis nostrud exercitation ullamco.</p>
      </div>
    </div>
    <div class="rightcolumn">
      <div class="card">
        <div>
          <%
          	if (loginId == null) {
          %>
          <form action="indexAction.jsp">
            <input type="text" id="userid" name="userid"
              placeholder="Identifier..."> <input
              type="password" id="userpw" name="userpw"
              placeholder="Password..."> <input type="submit"
              value="Login">
          </form>

          <%
          	} else {
          %>
          <%=loginId%><label>님이 로그인 중입니다.</label>
          <input type="button" value="Logout" onclick="location.href='indexAction.jsp'">
          <%
          	}
          %>

        </div>
      </div>
      <div class="card">
        <h3>Popular Post</h3>
        <div class="fakeimg">
          <p>Image</p>
        </div>
        <div class="fakeimg">
          <p>Image</p>
        </div>
        <div class="fakeimg">
          <p>Image</p>
        </div>
      </div>
      <div class="card">
        <h3>Follow Me</h3>
        <p>Some text..</p>
      </div>
    </div>
    
  </div>
  <div class="footer">
    <h2>Footer</h2>
  </div>
</body>
</html>