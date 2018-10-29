<%-- 게시글 삭제 완료 화면 content --%>

<%@ page contentType="text/html; charset=utf-8"%>
<script>
	function go_board() {
		location.href = '/board.jsp';
	}
	setTimeout('go_board()', 3000);
</script>

<h2>The Delete was Successful!</h2>
<img src="/img/loading.gif">
<h4>wait a second..</h4>