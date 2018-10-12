package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 디스패치 기술
		//response.sendRedirect(location);
		RequestDispatcher rd = request.getRequestDispatcher("/hello.do"); //path에 자기 컨테이너 안에 있는 애들만 가능! 외부 안됨
		//path자체를 servlet으로 인식함
		//rd.forward(request, response);
		
		
		rd.include(request, response);

	}

}
