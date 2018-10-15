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

public class LoginServlet extends HttpServlet {


	// 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		
		// UserDao를 이용한 회원 가입여부 체크
		// 무조건 회원이란 가정
		
		
		Cookie cookie = new Cookie("loginId", id);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		
		response.sendRedirect("index.html"); // sendRedirect는 브라우저를 기준으로 인식함
	
	}
	
	// 로그아웃 처리
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
		     for(Cookie cookie : cookies){
		          String cookieName = cookie.getName();
		          if(cookieName.equals("loginId")){
		        	  cookie.setPath("/");
		               cookie.setMaxAge(0);
		               response.addCookie(cookie);
		               break;
		               
		          }
		     }
		}
		response.sendRedirect("index.html");

	}

}
