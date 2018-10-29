<%-- 팩토리 생성 --%>

<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%!
public void jspInit(){
   DaoFactory factory = new JdbcDaoFactory();
   getServletContext().setAttribute("factory", factory);
}
%>