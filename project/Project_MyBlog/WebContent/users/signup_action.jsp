<%-- 회원가입 액션 --%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="sun.nio.cs.HistoricallyNamedCharset"%>
<%@page import="kr.or.kosta.blog.user.domain.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.user.dao.UserDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="user" class="kr.or.kosta.blog.user.domain.User" scope="request"/>
<jsp:setProperty property="*" name="user"/>
<%
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
UserDao dao = factory.getUserDao();
dao.create(user);
%>
<jsp:forward page="../approved.jsp"/>