package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

public class CookieServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = "bangry";
		String pw = "1111";
		
		Cookie cookie1 = new Cookie("loginId", id);
		Cookie cookie2 = new Cookie("passWd", pw);
		//cookie.setMaxAge(60*60*24*30);
		//cookie.setDomain("http://www.naver.com"); //마음대로 하면 안됨
		//cookie.setPath("/");
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		
		response.sendRedirect("hello2"); // sendRedirect는 브라우저를 기준으로 인식함
	
	}

}
