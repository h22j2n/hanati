<%-- 아이디 중복 확인 액션 --%>
<%@page import="kr.or.kosta.blog.user.domain.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.user.dao.UserDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	String confirmId = request.getParameter("confirm");
	DaoFactory factory = (DaoFactory) application.getAttribute("factory");
	UserDao dao = factory.getUserDao();

	List<User> list = dao.listAll();
	String result = "none";
	for (User users : list) {
		if (users.getId().equals(confirmId)) {
			result = users.getId();
			break;
		}
	}

	response.sendRedirect("/signup.jsp?result=" + result + "&confirm=" + confirmId);
%>
