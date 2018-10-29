<%-- 쪽지 보내기 화면 content --%>

<%@page import="kr.or.kosta.blog.user.domain.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.user.dao.UserDao"%>
<%@page import="kr.or.kosta.blog.article.domain.Article"%>
<%@page import="kr.or.kosta.blog.article.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@include file="/users/cookie.jsp" %>

<div id="headerwrap">
  <div class="col-lg-12">

    <div class="newcontainer">
      <form action="/users/sendmessage_action.jsp" method="post" style="padding-right: 80px;">
                    <label style="margin-left: 25%">MESSAGE</label>
        <div class="row">
          <div class="col-25">
            <label for="commentwriter">Sender</label>
          </div>
          <div class="col-75">
          <input type="text" id="messagewriter" name="writer" readonly style="background-color: #ccc;">
           <input type="hidden" name="sender" value="<%=loginId %>">
          </div>
        </div>
        
        <div class="row">
          <div class="col-25">
            <label for="commentwriter">Receiver</label>
          </div>
          <div class="col-75">
          <input type="text" id="receiver" >
          <input type="hidden" id="hiddenreceiver" name="receiver">
          <span id="correctId"></span>
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
          <input type="submit" value="Submit" id="createcomment" disabled="disabled">
        </div>
      </form>
    </div>
  </div>
</div>

<% 
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
UserDao dao = factory.getUserDao();
List<User> list = dao.listAll();%>

<script>
document.getElementById("messagewriter").value = "<%=loginId%>";
var flag = false;

<%
if(request.getParameter("receiver") != null){ // 답장하기 버튼을 누른 경우
  String receiver = request.getParameter("receiver");
%>
	document.getElementById("receiver").value = "<%=receiver%>";
	document.getElementById("receiver").disabled = true;
	document.getElementById("hiddenreceiver").value = "<%=receiver%>";
	flag = true;
<%}%>

/* 공백 시 submit 버튼을 비활성화 시키는 함수 */
function checklen(){
	var titlelen = document.getElementById("receiver").value.length;
	var contentlen = document.getElementById("commentcontent").value.length;

	if(titlelen != 0 && contentlen != 0 && flag == true){
		document.getElementById("createcomment").disabled =false;
	}else{
		document.getElementById("createcomment").disabled =true;
	}
}

document.getElementById("receiver").onkeyup = function(){
	var receiver = this.value;
	<%for(User user : list){%>
	
	//유저 존재여부 체크
    if(receiver == '<%=user.getId()%>'){ 
    	document.getElementById("correctId").textContent = '해당하는 유저가 존재합니다.';
    	document.getElementById('correctId').style.color = 'blue';
    	document.getElementById("hiddenreceiver").value = receiver;
    	flag = true;
    }
    if(!flag){
    	document.getElementById("correctId").textContent = '해당하는 유저가 존재하지 않습니다.';  
    	document.getElementById('correctId').style.color = 'red';
    }
	<%}
	%>
	checklen();
}

document.getElementById("commentcontent").onkeyup = function(){
	checklen();
}
</script>



