<%-- 신규글 작성 화면 content --%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/users/cookie.jsp" %>

<%
    if (loginId == null) { // 로그인 쿠키가 없을 시 로그인 화면으로 이동
%>
<jsp:forward page="/index.jsp" />
<%
  }
%>


<div id="headerwrap">
  <div class="col-lg-12">


    <div class="newcontainer">
      <form action="/users/newboard_action.jsp" method="post" enctype="multipart/form-data" style="padding-right: 80px;">
              <label style="margin-left: 25%">NEW ARTICLE</label>
        <div class="row">
          <div class="col-25">
            <label for="title">Title</label>
          </div>
          <div class="col-75">
            <input type="text" id="newtitle" name="subject"
              placeholder="title.." maxlength="200">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="writer">Writer</label>
          </div>
          <div class="col-75">
            <input type="text" id="newwriter" name="writer">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="password">Password</label>
          </div>
          <div class="col-75">
            <input type="password" id="newpasswd" name="passwd" maxlength="4">
          </div>
        </div>
        
         <div class="row">
          <div class="col-25">
            <label for="uploadfile">Upload File</label>
          </div>
          <div class="col-75">
          <input type="file" id="upfile" name="upfile" value="select file" accept=".jpg, .gif, .jpeg, .png">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="subject">Content</label>
          </div>
          <div class="col-75">
            <textarea id="newsubject" name="content"
              placeholder="Write something.." style="height: 200px" maxlength="2000">
              </textarea>
          </div>
        </div>
        <div class="row">
          <input type="submit" value="Submit"  id="createarticle" disabled>
        </div>
      </form>
    </div>
  </div>
</div>



<script>
/* 작성자 란에 로그인 아이디 고정 */
document.getElementById("newwriter").value = "<%=loginId%>";
document.getElementById("newwriter").disabled = true;

/* 제목, 비밀번호, 내용 길이 체크*/
function checklen(){
	var titlelen = document.getElementById("newtitle").value.length;
	var passwdlen = document.getElementById("newpasswd").value.length;
	var contentlen = document.getElementById("newsubject").value.length;

	// 길이가 0이 아닐 경우 submit 버튼 활성화
	if(titlelen != 0 && passwdlen != 0 && contentlen != 0){
		document.getElementById("createarticle").disabled =false;
	}else{
		document.getElementById("createarticle").disabled =true;
	}
}


/* 동적으로 텍스트 길이를 체크해 주면서 버튼 활성화 여부 체크 */
 


document.getElementById("newtitle").onkeyup = function(){
	checklen();
}

document.getElementById("newpasswd").onkeyup = function(){
	checklen();
}

document.getElementById("newsubject").onkeyup = function(){
	checklen();
}

</script>


