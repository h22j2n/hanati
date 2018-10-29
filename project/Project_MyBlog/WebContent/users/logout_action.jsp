<%-- 로그아웃 관련 액션 --%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loginId")) { //로그인 아이디 쿠키 삭제
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);

			}
		}
	}
	response.sendRedirect("/index.jsp");
%>
