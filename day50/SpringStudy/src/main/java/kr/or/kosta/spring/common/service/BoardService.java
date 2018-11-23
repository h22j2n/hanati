package kr.or.kosta.spring.common.service;

import java.util.List;


import kr.or.kosta.spring.common.domain.BoardVO;
import kr.or.kosta.spring.common.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
//	public List<BoardVO> getList();
	
	public List<BoardVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);

}
