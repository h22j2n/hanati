package kr.or.kosta.shoppingmall.demo.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.common.controller.ModelAndView;

public class AjaxController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		String number1 = request.getParameter("num1");
		int num1 = Integer.parseInt(number1);
		String number2 = request.getParameter("num2");
		int num2 = Integer.parseInt(number2);
		String operator = request.getParameter("selector");
		int result = 0;
		 if(operator.equals("-")){
		  result = num1 - num2;
		}else if(operator.equals("*")){
		 result = num1 * num2; 
		}else if(operator.equals("/")){
		 result = num1/num2; 
		}else{
			result = num1 + num2;
		}
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(result);
		} catch (IOException e) {
			throw new ServletException(e.getMessage(),e);
		}
		return null;
	}

}






