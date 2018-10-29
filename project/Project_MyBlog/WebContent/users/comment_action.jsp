<%-- 답글관련 액션 --%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.InetAddress"%>
<%@page import="kr.or.kosta.blog.article.domain.Article"%>
<%@page import="kr.or.kosta.blog.article.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String retitle = request.getParameter("subject");
	String writer = request.getParameter("writer");
	String passwd = request.getParameter("passwd");
	String content = request.getParameter("content");
	String articleId = request.getParameter("articleId");

	Article article = new Article();
	article.setSubject(retitle);
	article.setWriter(writer);
	article.setPasswd(passwd);
	article.setContent(content);
	article.setArticle_id(articleId);
	article.setIp(InetAddress.getLocalHost().getHostAddress());

	DaoFactory factory = (DaoFactory) application.getAttribute("factory");
	ArticleDao dao = factory.getArticleDao();
	Article article2 = dao.read(articleId);

	if (article2.getLevel_no().equals("0")) { //답글인 경우
		dao.createReArticle(article);
	} else {// 답글 이상인 경우
		dao.updateOrdernum(article);
		dao.createReReArticle(article);
	}
	response.sendRedirect("/board.jsp?");
  
%>

