package kr.or.kosta.spring.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.spring.common.domain.BoardVO;
import kr.or.kosta.spring.common.domain.Criteria;
import kr.or.kosta.spring.common.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;

	@Override
	public void register(BoardVO board) {
		log.info("register...." + board);

		boardMapper.insertSelectKey(board);

	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get..."+bno);
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify..." + board);
		
		return boardMapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove..." + bno);
		return boardMapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		log.info("get List with criteria...." + cri);
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return boardMapper.getTotalCount(cri);
	}

}
