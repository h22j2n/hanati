<%-- 방명록 내용을 보여주는 화면 content --%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="kr.or.kosta.blog.guestbook.domain.Guestbook"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.guestbook.dao.GuestbookDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<%
	DaoFactory factory = (DaoFactory) application.getAttribute("factory");
	GuestbookDao dao = factory.getGuestbookDao();
	List<Guestbook> list = dao.listAll();
%>
<div id="nonecontents">내용을 입력하세요.</div>
<div id="headerwrap">
  <div class="col-lg-12">
    <div id="writebook">
      <form id="paper" method="get" action="/users/guestbook_action.jsp">
        <div id="write">
          <textarea placeholder="Enter something funny." id="text"
            name="contents" rows="4" maxlength="2000"></textarea>
          <br> <input type="submit" value="Create"
            id="creategusetbook" disabled>
        </div>
      </form>
      <table id="booklist">
        <tr>
          <th>Writer</th>
          <th style="width: 50%">Content</th>
          <th>Date</th>
        </tr>
        <tbody id="guestBody">
          <%
          	for (Guestbook guestbook : list) {
          %>
          <tr>
            <td><%=guestbook.getUser_id()%></td>
            <td><%=guestbook.getContents()%></td>
            <td><%=guestbook.getRegdate()%></td>
          </tr>
          <%
          	}
          %>
        </tbody>
      </table>
      <br><br>
    </div>
  </div>
</div>

<script>
	document.getElementById('text').onkeyup = function() {
		if (document.getElementById('text').value.length != 0) {
			document.getElementById('creategusetbook').disabled = false;
		} else {
			document.getElementById('creategusetbook').disabled = true;

		}
	}
</script>