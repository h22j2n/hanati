<%-- 회원가입 승인하는 화면 content --%>
<%@ page contentType="text/html; charset=utf-8" %>
<jsp:useBean id="user" class="kr.or.kosta.blog.user.domain.User" scope="request"/>
   <div id="headerwrap">
     <div class="col-lg-12">
        <div id="loginForm">
        <h2>congratulations!</h2>
        <img src="/img/cong.gif"><br>
      <h4 class="approvedtag" style="font-size: 35px;">Your Information</h4><br>   
      <p class="approvedtag">ID : <%=user.getId() %></p>
      <p class="approvedtag">NAME : <%=user.getName() %></p>
      <p class="approvedtag">EMAIL : <%=user.getEmail() %></p>
      <br>
      <input type="button" id="toHome" value="GO TO LOGIN" onclick="location.href='<%=application.getContextPath()%>/index.jsp'">
        
      </div>
      </div>
  </div>