package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Calendar now = Calendar.getInstance();
//		String nowString = String.format("%1$tF %1$tT", now);
		String nowString = null;
		nowString.length();

		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>오늘은 " + nowString + " 입니다.</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
