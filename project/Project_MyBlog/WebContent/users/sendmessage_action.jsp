<%-- 쪽지 보내기 액션 --%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="kr.or.kosta.blog.message.domain.Message"%>
<%@page import="kr.or.kosta.blog.message.dao.MessageDao"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>

<%@include file="/users/cookie.jsp" %>

<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String content = request.getParameter("content");
	String sender = request.getParameter("sender");
	String receiver = request.getParameter("receiver");

DaoFactory factory = (DaoFactory)application.getAttribute("factory");
		MessageDao dao = factory.getMessageDao();
			Message message= new Message();
			message.setContent(content);
            message.setSender(sender);
            message.setReceiver(receiver);
			dao.create(message);
response.sendRedirect("/messagelist.jsp");
%>




