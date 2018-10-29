<%-- 게시글 수정 액션 --%>
<%@page import="kr.or.kosta.blog.article.domain.Article"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.article.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<% 
String article_id =  request.getParameter("articleId");
String title =  request.getParameter("title");
String content =  request.getParameter("content");
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
ArticleDao dao = factory.getArticleDao();
Article article =dao.read(article_id);
article.setContent(content);
article.setSubject(title);
dao.update(article);

response.sendRedirect("/board.jsp");
%>
