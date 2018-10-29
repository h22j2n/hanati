<%-- 로그인 관련 액션 --%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="kr.or.kosta.blog.user.domain.User"%>
<%@page import="kr.or.kosta.blog.user.dao.UserDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%
	if (request.getParameter("userid") != null) {
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		String check = request.getParameter("check3"); // 아이디 기억하기
		DaoFactory factory = (DaoFactory) application.getAttribute("factory");
		UserDao dao = factory.getUserDao();
		User user = dao.certify(id, pw);
		if (user != null) {
			if (check != null) {//아이디 기억하는 쿠키 생성
				Cookie cookie2 = new Cookie("remember", user.getId());
				cookie2.setPath("/");
				response.addCookie(cookie2);
			} else {
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("remember")) {// 아이디 기억하는 쿠키 삭제
							cookie.setMaxAge(0);
							cookie.setPath("/");
							response.addCookie(cookie);
						}
					}
				}
			}
            // 로그인 아이디 쿠키 생성
			Cookie cookie = new Cookie("loginId", user.getId());
			cookie.setPath("/");
			response.addCookie(cookie);
			response.sendRedirect("/welcome.jsp");
		} else {
			response.sendRedirect("/index.jsp?member=no");
		}
	}
%>