<%-- 홈화면 top --%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="kr.or.kosta.blog.message.domain.Message"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.message.dao.MessageDao"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@include file="/users/cookie.jsp" %>
<%
DaoFactory factory = (DaoFactory) application.getAttribute("factory");
MessageDao dao = factory.getMessageDao();
List<Message> list = dao.listAll();
boolean check = false;
if(list != null){
for(Message message : list){
  if(message.getReceiver().equals(loginId)){
 if(message.getHitcount().equals("0")){
	 check = true;
 }}
}}
%>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <%if(loginId != null){
        	  %>
        <a class="navbar-brand">welcome ♥<label style="color: orange;"><%=loginId %></label>♥</a>
          <%}%>
      </div>
      <div class="navbar-collapse collapse navbar-right">
        <ul class="nav navbar-nav">
          <li class="active"><a href="/index.jsp">HOME</a></li>
          <li><a href="/guestbook.jsp">GUEST BOOK</a></li>
          <li><a href="/board.jsp">BULLETIN BOARD</a></li>
              
              <%
  if(flag){%> <li class="dropdown">
   <a href="#" class="dropdown-toggle" data-toggle="dropdown">My<b class="caret"></b></a>
   <ul class="dropdown-menu">
  <li><a href="/messagelist.jsp">Message</a></li>
              <li><a href="/sendmessage.jsp">Send Message</a></li>
      <li><a href="/users/logout_action.jsp" >LOGOUT</a></li>
 <% }else{%>
      <li><a href="/index.jsp" >LOGIN</a></li>
 <%}
 %>
            </ul>
            </li>
             <% if(check){%>
           <li><img alt="" src="/img/alarm.png" style="margin-top:10px;"></li>
  <%}%>
        </ul>
      </div>
    </div>
  </div>