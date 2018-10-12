package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		String clientIp = request.getRemoteAddr();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String protocol = request.getProtocol();
		String query = request.getQueryString();
		String userName = request.getParameter("name");
		String applicationName = request.getContextPath();
		String servletName = request.getServletPath();
		

		Enumeration<String> headerNames = request.getHeaderNames();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size:20pt'>");
		out.println("<body>");
		out.println("<ul>");
		out.println("<li>" + clientIp + "</li>");
		out.println("<li>" + method + "</li>");
		out.println("<li>" + uri + "</li>");
		out.println("<li>" + protocol + "</li>");

		while (headerNames.hasMoreElements()) {
			String name = (String) headerNames.nextElement();
			String value = request.getHeader(name);
			out.println("<li>" + name + " : " + value + "</li>");
		}
		out.println("<li>" + query + "</li>");
		out.println("<li>" + userName + "</li>");
		
		out.println("<li>" + applicationName + "</li>");
		out.println("<li>" + servletName + "</li>");
		
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");

	}

}
