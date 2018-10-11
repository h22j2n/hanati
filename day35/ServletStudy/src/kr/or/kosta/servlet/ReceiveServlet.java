package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);

	}
	
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		// 요청 파라메타 수신
		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw");
		String team = request.getParameter("teams");
		String[] hobbys = request.getParameterValues("hobby");

		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String name = (String) paramNames.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + "=" + value);
		}

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size:20pt;'>");

		out.println("<h3>아이디: " + userId + "</h3>");
		out.println("<h3>비번: " + userPw + "</h3>");
		out.println("<h3>팀: " + team + "</h3>");

		if (hobbys != null) {
			for (String string : hobbys) {
				out.println("<h3>취미: " + string + "</h3>");
			}

		}

		out.println("</body>");
		out.println("</html>");
	}

}
