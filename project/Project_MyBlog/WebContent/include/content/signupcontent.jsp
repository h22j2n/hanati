<%-- 회원가입 화면 content --%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="kr.or.kosta.blog.user.domain.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@page import="jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory"%>
<%@page import="kr.or.kosta.blog.user.dao.UserDao"%>
<script>

/*아이디 중복확인 버튼 누를 시 실행되는 함수*/
  function confirm() {
    var confirmId = document.getElementById("text-left").value;
    if(confirmId != ''){
		document.getElementById('putId').value = '';
    	location.href = "/users/confirm_action.jsp?confirm=" + confirmId;
  }else{
	    document.getElementById('putId').textContent = '아이디를 입력해주세요.';
	    document.getElementById('putId').style.color = 'red';
  }
  }
  
  /* 알림창 띄우기 */
  function notice(id) {
    var x = document.getElementById(id);
    x.className = "show";
    setTimeout(function() {
      x.className = x.className.replace("show", "");
    }, 3000);
  };
  
 
  
  
</script>

<%-- 알림창 해당하는 문구들 --%>
<div id="overlap">중복된 ID가 존재합니다.</div>
<div id="usable">사용가능한 ID 입니다.</div>
<div id="checkOverlap">ID 중복확인을 해주세요.</div>
<div id="length">비밀번호는 6글자 이상, 16글자 이하만 사용 가능합니다.</div>
<%-- 알림창 해당하는 문구들 끝--%>

<div id="headerwrap">
  <div class="col-lg-12">
    <div id="loginForm">
      <h1>Sign Up</h1>
      <div class="clear-loading spinner">
        <span></span>
      </div>
      <div class="w3ls-login box box--big">
        <form action="/users/signup_action.jsp" id="signupForm"
          method="post">
          <div class="agile-field-txt">
            <label id="label-left"><i class="fa fa-user"
              aria-hidden="true"></i> User Id </label> <input type="text"
              id="text-left" placeholder="Enter User Id"
              required />
              <input type="hidden" name="id" 
              id="hiddenid"/>
              <input type="button" id="confirmId"
              value="Check Id" onclick=confirm() disabled="disabled"><span
              id="putId"></span>
            <%
            	if (request.getParameter("result") != null) { //중복확인버튼을 눌렀을 때
            		if (!request.getParameter("result").equals("none")) { // 중복이 될 때
            %>
            <script type="text/javascript">
            notice('overlap');
            </script>
            <%
            	} else { // 사용 가능 아이디 일 때
            %>
            <script type="text/javascript">
                notice('usable');
                document.getElementById("text-left").value = "<%=request.getParameter("confirm")%>";
                document.getElementById("hiddenid").value = "<%=request.getParameter("confirm")%>";
                document.getElementById("text-left").disabled = true;
                document.getElementById("text-left").style.background = '#dddddd';
                document.getElementById("confirmId").disabled = true;
                </script>
            <%
            	}
            	}
            %>
          </div>
          <div class="agile-field-txt">
            <label><i class="fa fa-user" aria-hidden="true"></i>
              User Name </label> <input type="text" name="name" id="inputname"
              placeholder="Enter User Name" required="" /><span
              id="putname"></span>
          </div>
          <div class="agile-field-txt">
            <label><i class="fa fa-unlock-alt"
              aria-hidden="true"></i> Password </label> <input type="password"
              name="passwd" placeholder="Enter Password" required=""
              id="myInput" /><span id="alertpw"></span>
          </div>
          <div class="agile-field-txt">
            <label><i class="fa fa-unlock-alt"
              aria-hidden="true"></i> Confirm Password </label> <input
              type="password" name="confirmPasswd" id="confirmPw"
              placeholder="Enter Password" required /><span id="same"></span>

          </div>
          <div class="agile-field-txt">
            <label> <i class="fa fa-envelope" aria-hidden="true"></i>
              Email
            </label> <input type="text" name="email" placeholder="Enter email"
              required="" id="inputEmail" /><span id="alertemail"></span>
          </div>
          <input type="submit" value="SIGNUP" id="signup" disabled="disabled">
        </form>
      </div>


    </div>
  </div>
</div>

<script>
var checkpw = 0;
var checkconfirm = 0;
var checkemail = 0;
var checkName = 0;

/** 유효성 검사 함수들 */


document.getElementById('inputname').onkeyup = function() {
	var msg = '',
    val = this.value;
	var regName =  /([가-힣]{2,10}|[a-zA-Z]{2,10})/;

if(!regName.test(val)){
	msg = '이름은 영문, 한글 2~10자내로 입력가능합니다.'
	document.getElementById('putname').style.color = 'red';
	checkName=0;
}else{
    msg = GetAjaxPW(val);
	document.getElementById('putname').style.color = 'blue';
	checkName=1;
}
document.getElementById('putname').textContent = msg;
ableSignup();
}



document.getElementById('myInput').onkeyup = function() {
    var msg = '',
        val = this.value;
    var regPasswd = /^(?=.*[a-zA-Z])(?=.*\d).{5,15}$/;

    if( val.length > 15 || val.lengh < 5 || !regPasswd.test(val)){
    	msg = '패스워드 길이는 영문, 숫자 포함 5~15자 입니다.'
		document.getElementById('alertpw').style.color = 'red';
    	checkpw=0;
    }else{
        msg = GetAjaxPW(val);
		document.getElementById('alertpw').style.color = 'blue';
		checkpw=1;
    }
    document.getElementById('alertpw').textContent = msg;
    
    if(val != document.getElementById('confirmPw')){
    	document.getElementById('same').style.color = 'red';
		checkconfirm =0;
		document.getElementById('same').textContent = '비밀번호와 일치하지 않습니다.';
    }
    
    
    ableSignup();
};

document.getElementById('confirmPw').onkeyup = function() {
    var msg = '',
    val = this.value;
    if(val == document.getElementById('myInput').value){
	    msg = GetAjaxPW(val);
		document.getElementById('same').style.color = 'blue';
		checkconfirm =1;
    }else{
    	msg = '비밀번호와 일치하지 않습니다.';
		document.getElementById('same').style.color = 'red';
		checkconfirm =0;
    }
    document.getElementById('same').textContent = msg;
    ableSignup();

}

document.getElementById('inputEmail').onkeyup = function() {
    var msg = '',
    val = this.value;


var regEmail = /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/;

	   if(!regEmail.test(val)){
			msg = '이메일 형식에 맞게 입력해주세요.'
				document.getElementById('alertemail').style.color = 'red';
			checkemail= 0;
			}else{
			    msg = GetAjaxPW(val);
				document.getElementById('alertemail').style.color = 'blue';
				checkemail=1;
			}
	   <%
	   DaoFactory factory = (DaoFactory) application.getAttribute("factory");
	   UserDao dao = factory.getUserDao();
	   List<User> list = dao.listAll();
      for(User users : list){
        String email = users.getEmail();%>
        if(val == '<%=email%>'){
			msg = '중복된 이메일이 존재합니다.'
				document.getElementById('alertemail').style.color = 'red';
			checkemail= 0;
        }
      <%}
	   %>	
	   
	   document.getElementById('alertemail').textContent = msg;
			ableSignup();
			
}

document.getElementById('text-left').onkeyup = function() {
	 var msg = '',
    val = this.value;
	var regId = /^(?=.*[a-zA-Z])(?=.*\d).{5,15}$/;
	 if(val.length > 15 || val.lengh < 5 || !regId.test(val) ){
	    	msg = '아이디 길이는 영문, 숫자 포함 5~15자 입니다.'
			document.getElementById('putId').style.color = 'red';
	    	document.getElementById('confirmId').disabled = true;
	    }else{
	        msg = ' ';
	        document.getElementById("confirmId").disabled = false;
	    }
	    document.getElementById('putId').textContent = msg;
}


var GetAjaxPW = function(val){
    return ' 사용가능합니다.';
}

function ableSignup(){
	if(checkpw == 1 && checkconfirm == 1 && checkemail == 1 && checkName == 1 && document.getElementById("confirmId").disabled == true){
		document.getElementById("signup").disabled = false;
	}else{
		document.getElementById("signup").disabled = true;
	}
}

</script>

