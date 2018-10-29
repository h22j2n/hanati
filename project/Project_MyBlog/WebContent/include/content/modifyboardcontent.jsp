<%-- 게시글 수정 화면 content --%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="kr.or.kosta.blog.article.domain.Article"%>
<%@page import="kr.or.kosta.blog.article.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@include file="/users/cookie.jsp" %>
<%
String articleId = request.getParameter("articleId");
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
ArticleDao dao = factory.getArticleDao();
Article article =  dao.read(articleId);
%>
<script>
/* 수정버튼 클릭 시 정보를 보내주는 함수*/
function sendinfo(){
	var title = document.getElementById("modititle").value;
	var content = document.getElementById("modicontent").value;
	location.href='/users/modify_action.jsp?articleId='+<%=articleId %>+'&title='+title+'&content='+content;
};
</script>

<div id="headerwrap">
  <div class="col-lg-12">


    <div class="newcontainer">
        <div class="row">
          <div class="col-25">
            <label for="title">Title</label>
          </div>
          <div class="col-75">
            <input type="text" id="modititle" name="subject"
              placeholder="title..">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="writer">Writer</label>
          </div>
          <div class="col-75">
            <input type="text" id="modiwriter" name="writer">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="password">Password</label>
          </div>
          <div class="col-75">
            <input type="password" id="modipasswd" name="passwd">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="subject">Content</label>
          </div>
          <div class="col-75">
            <textarea id="modicontent" name="content"
              placeholder="Write something.." style="height: 200px"></textarea>
          </div>
        </div>
        <div class="row">
          <input type="button" value="Submit" onclick=sendinfo() >
        </div>
    </div>
  </div>
</div>


<script>
/* 작성자 란에 아이디 고정해줌 */
document.getElementById("modiwriter").value = "<%=loginId%>";
document.getElementById("modiwriter").disabled = true;

/* 비밀번호 란에 고정 */
document.getElementById("modipasswd").value = "<%=article.getPasswd()%>";
document.getElementById("modipasswd").disabled = true;

/* 수정하고자 하는 제목, 내용을 화면에 보여줌*/
document.getElementById("modicontent").value = "<%=article.getContent()%>";
document.getElementById("modititle").value = "<%=article.getSubject()%>";
</script>


