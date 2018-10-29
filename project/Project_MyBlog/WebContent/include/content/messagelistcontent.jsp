<%-- 쪽지 리스트를 보여주는 화면 content --%>

<%@page import="kr.or.kosta.blog.message.domain.Message"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.message.dao.MessageDao"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/users/cookie.jsp" %>

<% request.setCharacterEncoding("utf-8");%>
<%
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
MessageDao dao = factory.getMessageDao();
List<Message> list = dao.listAll();
%>
<div id="headerwrap">
  <div class="col-lg-12">
    <div id="writebook">
    <label>Message List</label>
      <table id="booklist" style="margin-top: 50px">
        <tr>
          <th>Sender</th>
          <th style="width: 50%">Content</th>
          <th>Date</th>
          <th>Reply</th>
        </tr>
        <tbody id="guestBody">
       
        <%if(list!=null){
        for(Message message : list){ // 메세지 리스트를 받아옴
          if(message.getReceiver().equals(loginId)){
        	  dao.update(message.getMessage_no());
          %>
            <tr>
          <td><%=message.getSender() %></td>
          <td><%=message.getContent() %></td>
          <td><%=message.getRegdate() %></td>
          <td><button onclick="location.href='/sendmessage.jsp?receiver='+'<%=message.getSender() %>'">Reply</button></td>
          </tr>
          <% }}
         }%>
        </tbody>
      </table>
    </div>
  </div>
</div>
