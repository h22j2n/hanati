package kr.or.kosta.spring.common.mapper;

import java.util.List;

import kr.or.kosta.spring.common.domain.BoardVO;
import kr.or.kosta.spring.common.domain.Criteria;

public interface BoardMapper {
	
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	/* insert만 처리되고 생성된 PK값을 알 필요가 없는 경우*/
	public void insert(BoardVO board);
	
	/* insert문이 실행되고 생성된 PK값을 알아야 하는 경우*/
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);

}
