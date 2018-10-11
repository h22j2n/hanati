package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

//		response.setStatus(400);
//		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

		String name = request.getParameter("name");
		if (name != null && name.length() != 0) {

			if (name.equals("bangry")) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				return;
			}

		}

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size:20pt'>");
		out.println("<body>");
		out.println("<ul>");
		out.println("<li>???</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");

	}

}
