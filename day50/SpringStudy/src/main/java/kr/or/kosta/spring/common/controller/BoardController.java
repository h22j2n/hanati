package kr.or.kosta.spring.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import kr.or.kosta.spring.common.domain.BoardVO;
import kr.or.kosta.spring.common.domain.Criteria;
import kr.or.kosta.spring.common.domain.PageDTO;
import kr.or.kosta.spring.common.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list : " +cri);
		model.addAttribute("list",boardService.getList(cri));
		model.addAttribute("pageMaker",new PageDTO(cri, 123));
		
		int total = boardService.getTotal(cri);
		log.info("total : " + total);
		
		model.addAttribute("pageMaker",new PageDTO(cri, total));
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register : " +board);
		boardService.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("board",boardService.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify : "+board);
		
		if(boardService.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		
		return "redirect:/board/list" + cri.getListLink();

	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove.." + bno);
		
		if(boardService.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		
		return "redirect:/board/list"+ cri.getListLink();
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	

	

}
