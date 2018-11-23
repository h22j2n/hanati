package kr.or.kosta.spring.demo.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Spring 2.5 이후 세부 컨트롤러(POJO)
 * @author 조희진
 *
 */
@Controller
@RequestMapping(value="/demo")
public class HelloController2{
	
	@RequestMapping(value="/hello")
	public String hello(Model model){
		String message = "Spring MVC 모듈 테스트입니다..";
		model.addAttribute("message",message);
		return "demo/hello";
	}

	@RequestMapping(value="/today")
	public String today(Model model){
		Calendar cal = Calendar.getInstance();
		String type = String.format("%1$tF %1$tT", cal);
		String today = "오늘은 "+ type;
		model.addAttribute("today",today);
		return "demo/today";
	}
	
	@RequestMapping(value="/find", params="admin=true")
	public String admin(Model model){
		model.addAttribute("message","관리자 화면입니다..");
		return "demo/admin";
	}


}
