package kr.or.kosta.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet2 extends HttpServlet {

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("userid");
		System.out.println(id);
		//String pw = request.getParameter("userid");
		id = URLEncoder.encode(id, "utf-8");
		Cookie cookie = new Cookie("id", id);
		response.addCookie(cookie);
		response.sendRedirect("/servlet/index.html");
		
	
	}

}
