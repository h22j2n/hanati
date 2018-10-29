<%-- 방명록 관련 액션 --%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="sun.nio.cs.HistoricallyNamedCharset"%>
<%@page import="kr.or.kosta.blog.guestbook.domain.Guestbook"%>
<%@page import="kr.or.kosta.blog.guestbook.dao.GuestbookDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@include file="/users/cookie.jsp"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String contents = request.getParameter("contents");
contents = contents.replace("\r\n", "<br>");


	DaoFactory factory = (DaoFactory) application.getAttribute("factory");
	GuestbookDao dao = factory.getGuestbookDao();
	if (loginId != null) {// 로그인 중일 경우
		Guestbook guestbook = new Guestbook();
		guestbook.setContents(contents);
		guestbook.setUser_id(loginId);
		dao.create(guestbook);
		response.sendRedirect("/guestbook.jsp");
	} else {// 로그인 중이 아닐 경우
		response.sendRedirect("/index.jsp");
	}
%>




