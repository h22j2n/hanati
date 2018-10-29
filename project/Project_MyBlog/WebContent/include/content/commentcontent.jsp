<%-- 답글 화면 content --%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="kr.or.kosta.blog.article.domain.Article"%>
<%@page import="kr.or.kosta.blog.article.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@include file="/users/cookie.jsp"%>

<%
	String title = request.getParameter("title");
	String articleId = request.getParameter("articleId");
%>

<div id="headerwrap">
  <div class="col-lg-12">

    <div class="newcontainer">
      <form action="/users/comment_action.jsp" method="post"
        style="padding-right: 80px;">
        <label style="margin-left: 25%">COMMENT</label>
        <div class="row">
          <div class="col-25">
            <label for="title">Title</label>
          </div>
          <div class="col-75">
            <input type="text" id="commenttitle" name="subject"
              placeholder="title.."> <input type="hidden"
              name="articleId" value="<%=articleId%>">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="commentwriter">Writer</label>
          </div>
          <div class="col-75">
            <input type="text" id="commentwriter" name="writer" readonly
              style="background-color: #ccc;">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="password">Password</label>
          </div>
          <div class="col-75">
            <input type="password" id="commentpasswd" name="passwd"
              maxlength="4">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="subject">Content</label>
          </div>
          <div class="col-75">
            <textarea id="commentcontent" name="content"
              placeholder="Write something.." style="height: 200px"></textarea>
          </div>
        </div>
        <div class="row">
          <input type="submit" value="Submit" id="createcomment"
            disabled="disabled">
        </div>
      </form>
    </div>
  </div>
</div>

<script>
document.getElementById("commentwriter").value = "<%=loginId%>";

document.getElementById("commenttitle").value = "re : <%=title%>";

	function checklen() {
		var titlelen = document.getElementById("commenttitle").value.length;
		var passwdlen = document.getElementById("commentpasswd").value.length;
		var contentlen = document.getElementById("commentcontent").value.length;

		if (titlelen != 0 && passwdlen != 0 && contentlen != 0) {
			document.getElementById("createcomment").disabled = false;
		} else {
			document.getElementById("createcomment").disabled = true;
		}
	}

	document.getElementById("commenttitle").onkeyup = function() {
		checklen();
	}

	document.getElementById("commentpasswd").onkeyup = function() {
		checklen();
	}

	document.getElementById("commentcontent").onkeyup = function() {
		checklen();
	}
</script>



