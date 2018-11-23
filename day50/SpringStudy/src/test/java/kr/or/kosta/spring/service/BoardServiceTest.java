package kr.or.kosta.spring.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.kosta.spring.common.domain.BoardVO;
import kr.or.kosta.spring.common.domain.Criteria;
import kr.or.kosta.spring.common.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {

	@Setter(onMethod_ = {@Autowired})
	private BoardService boardService;
	
//	@Test
	public void testExist() {
		log.info(boardService);
	}
	
//	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		boardService.register(board);
		
		log.info("생성된 게시물의 번호 : " + board.getBno());
	}
	
	@Test
	public void testGetList() {
		boardService.getList(new Criteria(2,10)).forEach(board -> log.info(board));
	}
	
//	@Test
	public void testGet() {
		log.info(boardService.get(1L));
	}
	
//	@Test
	public void testDelete() {
		log.info("REMOVE RESULT : " + boardService.remove(2L));
		
	}
	
//	@Test
	public void testeUpdate() {
		BoardVO board = boardService.get(1L);
		
		if (board == null) {
			return;
			
		}
		
		board.setTitle("제목 수정합니다.");
		log.info("MODIFY RESULT : " + boardService.modify(board));
	}
}
