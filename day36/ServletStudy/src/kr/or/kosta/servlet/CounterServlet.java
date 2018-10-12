package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// private static int count = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int value = 1;

		//id = URLEncoder.encode(id, "utf-8");



		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");

		String cookieValue = null;
		int count = 0;

		Cookie[] cookies = request.getCookies();
		/*
		 * if (reqcookies != null) { for (Cookie recookie : reqcookies) { cookieValue =
		 * recookie.getValue(); if (cookieValue.equals("bangry")) { Cookie count = new
		 * Cookie("count", ); }
		 * 
		 * } }
		 */
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if (cookieName.equals("count2")) {
					String temp = cookie.getValue();
					value = Integer.parseInt(temp) + 1;
					break;
				}
			}
		}
		
		Cookie cookie2 = new Cookie("count2", String.valueOf(value));
		//cookieValue = URLDecoder.decode(cookieValue, "utf-8");

		response.addCookie(cookie2);

		out.println("<h1>" + value + "</h1>");

		out.println("</body>");
		out.println("</html>");
	}

}
