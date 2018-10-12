package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
