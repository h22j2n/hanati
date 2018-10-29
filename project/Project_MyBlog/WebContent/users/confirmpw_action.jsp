<%-- 게시글 수정시 비밀번호 확인 액션 --%>
<%@page import="kr.or.kosta.blog.article.domain.Article"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.article.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	String articleId = request.getParameter("articleId");
	String passwd = request.getParameter("passwd");
	DaoFactory factory = (DaoFactory) application.getAttribute("factory");
	ArticleDao dao = factory.getArticleDao();
	Article article = dao.read(articleId);
	String result = "none";
	if (article.getPasswd().equals(passwd)) { // 패스워드 일치 시
		if (request.getParameter("type").equals("modi")) { // 게시글 수정일 경우
			response.sendRedirect("/modifyboard.jsp?articleId=" + articleId);
		} else { //게시글 삭제일 경우
			dao.delete(articleId);
			response.sendRedirect("/deletearticle.jsp?articleId=" + articleId);
		}
	} else { // 패스워드 일치하지 않을 시
		response.sendRedirect("/confirmpasswd.jsp?result=" + result + "&articleId=" + articleId);
	}
%>
