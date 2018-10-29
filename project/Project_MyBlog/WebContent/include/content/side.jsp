<%-- 최근 방문자 목록 content --%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="kr.or.kosta.blog.visitor.domain.Visitor"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.visitor.dao.VisitorDao"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%
DaoFactory factory = (DaoFactory) application.getAttribute("factory");
VisitorDao dao = factory.getVisitorDao();
List<Visitor> list = dao.listAll();
 int count = 0;
 %>
<textarea rows="10" cols="15" id="floatdiv" readonly="readonly">
최근 방문자
--------------
<%for(Visitor visitor : list){
count ++;
if(count < 10){
%>
<%=visitor.getVisitor_id() %>
<% }}%>
</textarea>