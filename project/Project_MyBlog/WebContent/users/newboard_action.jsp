<%-- 신규글 등록 action --%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.net.InetAddress"%>
<%@page import="kr.or.kosta.blog.article.domain.Article"%>
<%@page import="kr.or.kosta.blog.article.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@include file="/users/cookie.jsp"%>

<%
	request.setCharacterEncoding("utf-8");
	String fileRepository = "C:\\kosta187\\workspace\\Project_MyBlog\\WebContent\\uploadFiles\\";

	try {
		MultipartRequest multi = new MultipartRequest(request, fileRepository, 50 * 1024 * 1024, "utf-8",
				new DefaultFileRenamePolicy());

		String title = multi.getParameter("subject");
		String passwd = multi.getParameter("passwd");
		String content = multi.getParameter("content");
        content = content.replace("\r\n", "<br>");
		String fileName = multi.getFilesystemName("upfile");
		String writer = loginId;

		DaoFactory factory = (DaoFactory) application.getAttribute("factory");
		ArticleDao dao = factory.getArticleDao();

		Article article = new Article();

		article.setSubject(title);
		article.setWriter(writer);
		article.setPasswd(passwd);
		article.setContent(content);
		article.setIp(InetAddress.getLocalHost().getHostAddress());
		article.setAttach_file(fileName);
		dao.create(article);
		response.sendRedirect("/board.jsp");
	} catch (Exception e) {
	}
%>

