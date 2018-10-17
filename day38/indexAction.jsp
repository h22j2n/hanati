<%@page import="java.net.URLEncoder"%>
<%@page import="org.apache.tomcat.dbcp.dbcp2.BasicDataSource"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%!
private static final String driver = "oracle.jdbc.OracleDriver";
private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
private static final String username = "hr";
private static final String password = "hr";
%>
<%
JdbcUserDao dao = new JdbcUserDao();


BasicDataSource dataSource = new BasicDataSource(); //DataSource를 구현한 구현체 => BasicDataSource
dataSource.setDriverClassName(driver);
dataSource.setUrl(url);
dataSource.setUsername(username);
dataSource.setPassword(password);
dataSource.setInitialSize(5);
dataSource.setMaxTotal(10);
dataSource.setMaxIdle(7);

dao.setDataSource(dataSource);

	if (request.getParameter("userid") != null) {
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		String userid = URLEncoder.encode(id, "utf-8");
		String userpw = URLEncoder.encode(pw, "utf-8");
		Cookie cookie1 = new Cookie("loginId", userid);
		Cookie cookie2 = new Cookie("loginPw", userpw);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
	} else {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("loginId")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				if (cookie.getName().equals("loginPw")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
	}
	response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>