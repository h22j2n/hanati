package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifecycleServlet
 */
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int count;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LifecycleServlet() {
		System.out.println("LifecycleServlet() Called....");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig config) Called....");
		super.init(config);
		count = 0;
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() Called...");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy() Called....");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		count++;
		System.out.println("service(request, response) Called....");
		super.service(request, response);
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet(request, response) Called....");
		System.out.println(request);
		System.out.println(response);
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿 카운터</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>당신은 " + count+ "번째 방문자입니다.</h2>");
		out.println("</body>");
		out.println("</html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost(request, response) Called....");
	}

}
