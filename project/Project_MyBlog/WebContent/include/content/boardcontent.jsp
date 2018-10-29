<%-- 게시판 화면 content --%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="org.apache.tomcat.util.codec.binary.StringUtils"%>
<%@page import="kr.or.kosta.blog.common.web.PageBuilder"%>
<%@page import="kr.or.kosta.blog.common.web.Params"%>
<%@page import="kr.or.kosta.blog.article.domain.Article"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.article.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<%@include file="/users/cookie.jsp" %>


<% request.setCharacterEncoding("utf-8");%>
<%
	//페이지당 보여지는 목록수 설정
	int listSize = 10;
	//페이지당 보여지는 페이지수 설정
	int pageSize = 5;

	//선택페이지 수신
	String requestPage = request.getParameter("page");
	if (requestPage == null || requestPage.equals("") || requestPage.equals("null")) {
		requestPage = "1";
	}

	//검색 요청일 경우 파라메터 수신
	String searchType = request.getParameter("searchType");
	String searchValue = request.getParameter("searchValue");
	if (searchType == null || searchType.equals("")) {
		searchType = null;
		searchValue = null;
	}

	//요청파라메터 포장
	Params params = new Params(Integer.parseInt(requestPage), listSize, pageSize, searchType, searchValue);
	DaoFactory factory = (DaoFactory) application.getAttribute("factory");
	ArticleDao dao = factory.getArticleDao();
	List<Article> list = dao.listByPage(params);

	//페이징 처리에 필요한 검색 개수 DB조회
	int rowCount = dao.countBySearch(params);

	//PageBuilder를 이용하여 페이징 계산
	PageBuilder pageBuilder = new PageBuilder(params, rowCount);
	pageBuilder.build();
%>


 <div id="headerwrap">
     <div class="col-lg-12">
     
     <%-- 본문 시작 --%>
<div id="content-categories">자유 게시판</div>


<div id="list-menu">
<h3>게시글 목록(총 <%=rowCount %>개)</h3>
<table class="bbs-table">
<%--  게시판 목록 머리말 --%>
<tr>
    <th id="No">NO</th>
    <th id="title">TITLE</th>
    <th id="writer">WRITER</th>
    <th id="date">DATE</th>
    <th id="ip">IP</th>
    <th id="hit">HIT</th>
</tr>
<tbody>
<%


for(int i=0; i<list.size(); i++){
 Article article = list.get(i);
 int levelNum = Integer.parseInt(article.getLevel_no());
%>
<tr>
     <td><%=(rowCount - listSize * (params.getPage()-1) ) - i %></td>
     <%if(article.getSubject().equals("7000delete")){%>
         <td style="color: #ccc; text-align: left;">[삭제된 게시글입니다.]</td>
     <%}else if(levelNum>0){%>
    	 <td style="text-align: left;">
    	<% for(int j=0; j < levelNum; j++){%>
          &nbsp;&nbsp;
       <% }
    	 %>
   <img alt="" src="/img/reply.png"><a href="/article.jsp?article=<%=article.getArticle_id()%>&page=<%=requestPage%>&searchType=<%=searchType%>&searchValue=<%=searchValue%>"><%=article.getSubject() %></a></td>
     <%}else if(article.getAttach_file() != null){%>
   <td style="text-align: left;"><a href="/article.jsp?article=<%=article.getArticle_id()%>&page=<%=requestPage%>&searchType=<%=searchType%>&searchValue=<%=searchValue%>"><%=article.getSubject() %></a><img src="/image/attach.png"></td>
     <%}else{%>
       <td style="text-align: left;"><a href="/article.jsp?article=<%=article.getArticle_id()%>&page=<%=requestPage%>&searchType=<%=searchType%>&searchValue=<%=searchValue%>"><%=article.getSubject() %></a></td>
     <%}%>
 <td><a href="/sendmessage.jsp?receiver=<%=article.getWriter()%>"><%=article.getWriter()%></a></td>
 <td><%=article.getRegdate() %></td>
 <td><%=article.getIp() %></td>
 <td><%=article.getHitcount() %></td>
 </tr>
<%}
%>
</tbody>           
</table>

<%-- 페이징 처리 --%>
    <div class="pagination">
      <%
      if(pageBuilder.isShowFirst()){
      %>
        <a href="<%=pageBuilder.getQueryString(1)%>">처음으로</a>      
      <%        
      }
      %>
      
      <%
      if(pageBuilder.isShowPrevious()){
      %>
        <a href="<%=pageBuilder.getQueryString(pageBuilder.getPreviousStartPage())%>">&laquo;</a>      
      <%        
      }
      %>
      
      <%
      for(int i=pageBuilder.getStartPage(); i<=pageBuilder.getEndPage(); i++){
        if(i == params.getPage()){
      %>
          <a class="active"><%=i %></a>
      <%          
        }else{
      %>
           <a href="<%=pageBuilder.getQueryString(i)%>"><%=i %></a>
      <%          
        }
      }
      %>
      
      <%
      if(pageBuilder.isShowNext()){
      %>
        <a href="<%=pageBuilder.getQueryString(pageBuilder.getNextStartPage())%>">&raquo;</a>      
      <%        
      }
      %>
      <%
      if(pageBuilder.isShowLast()){
      %>
        <a href="<%=pageBuilder.getQueryString(pageBuilder.getPageCount())%>">끝으로</a>      
      <%        
      }
      %>
</div>
    <input type="button" id="writeboard" value="WRITE" onclick="location.href='/newboard.jsp'"/>
    </div>
<br>
<div id="search">
    <form>
        <div>
        <select name="searchType">
        <option value="">all</option>
        <option value="title">title</option>
        <option value="writer">writer</option>
        <option value="content">content</option>
        </select>
            <input type="text" name="searchValue" size="15" maxlength="30" />
            <input type="submit" id="searchbutton" value="SEARCH" />
        </div>
    </form>
    
</div>
<%--  본문 끝 --%>
      </div>
  </div>
  
  <script>
  <%if(loginId == null){%>
  document.getElementById("writeboard").disabled = true;
  <%}%>
  </script>