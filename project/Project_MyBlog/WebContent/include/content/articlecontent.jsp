<%-- 게시글 상세보기 화면 content --%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="kr.or.kosta.blog.article.domain.Article"%>
<%@page import="kr.or.kosta.blog.article.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@include file="/users/cookie.jsp" %>
<% request.setCharacterEncoding("utf-8");%>
<%
String articleId = request.getParameter("article");
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
ArticleDao dao = factory.getArticleDao();
Article article = dao.read(articleId);
dao.addCount(article);

String requestpage = request.getParameter("page");
String searchType = request.getParameter("searchType");
String searchValue = request.getParameter("searchValue");

%>
<div id="headerwrap">
  <div class="col-lg-12">
    <div class="detail">
    <h3 id="detailboard">게시글 상세</h3>
    <form action="/confirmpasswd.jsp">
      <table id="detailtable">
        <tr>
          <th>title</th>
          <td id="detailtitle" colspan="3"><%=article.getSubject() %></td>
        </tr>
        
        <tr>
          <th>writer</th>
          <td id="detailwriter"><%=article.getWriter() %></td>
          <th>date</th>
          <td id="detaildate" style="width: 30%;"><%=article.getRegdate() %></td>
        </tr>
 
        <tr>
          <th>ip</th>
          <td id="detailip"><%=article.getIp() %></td>
          <th>hits</th>
          <td id="detailhit"><%=article.getHitcount() %></td>
        </tr>
        
        <tr>
        <%
        if(article.getAttach_file() != null){
        	%>
          <td id="detailcontent" colspan="4"><br><img src="/uploadFiles/<%=article.getAttach_file()%>"><br><br><%=article.getContent() %><br><br></td>
        <%}else{%>
                <td id="detailcontent" colspan="4"><%=article.getContent() %></td>
       <%} %>
        </tr>
        
      </table>
      <br>
      <input type="button" value="Modify" id="modifybutton" onclick="location.href='/confirmpasswd.jsp?articleId=<%=articleId%>&type=modi'">
      <input type="button" value="Delete" id="deletebutton" onclick="location.href='/confirmpasswd.jsp?articleId=<%=articleId%>&type=del'">
      <input type="button" value="Comment" id="commentbutton" onclick="location.href='/comment.jsp?articleId=<%=articleId%>&title=<%=article.getSubject()%>'">
      <%if(searchType.equals("null") || searchType.equals("") || searchType == null){%>
      <input type="button" value="List" id="listbutton" onclick="location.href='/board.jsp?page=<%=requestpage%>'">
      <%}else{%>
      <input type="button" value="List" id="listbutton" onclick="location.href='/board.jsp?page=<%=requestpage%>&searchType=<%=searchType%>&searchValue=<%=searchValue%>'">
<%} %>
</form>
    </div>
  </div>
</div>
<%
if(loginId != null){
if(loginId.equals(article.getWriter())){%>
  <script>
  document.getElementById("modifybutton").disabled =false;
  document.getElementById("deletebutton").disabled =false;
  </script>
<%}else{%>
  <script>
  document.getElementById("modifybutton").disabled =true;
  document.getElementById("deletebutton").disabled =true;
  </script>
<%}
}else{%>
  <script>
  document.getElementById("modifybutton").disabled =true;
  document.getElementById("deletebutton").disabled =true;
  document.getElementById("commentbutton").disabled =true;
  </script>
<%}
%>



<script>
/* DB에서 불러와 textarea로 수정 시 <br>이 그대로 노출되는 것을 방지 */
var str = document.getElementById("detailcontent").value;
str = str.replaceAll("<br/>", "\r\n");
document.getElementById("detailcontent").value = str;
</script>