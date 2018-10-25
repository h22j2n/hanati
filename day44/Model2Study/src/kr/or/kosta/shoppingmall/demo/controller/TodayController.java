package kr.or.kosta.shoppingmall.demo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.common.controller.ModelAndView;

/**
 * hello.mall 요청에 대한 처리 클래스
 * 
 * @author 조희진
 *
 */
public class TodayController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException{
		ModelAndView mav = new ModelAndView();
		
		Calendar calendar = Calendar.getInstance();
		String today = String.format("%1$tF %1$tT", calendar);
		
		mav.addObject("today", today);

		mav.setView("/demo/today.jsp");
		
		return mav;
	}

}
