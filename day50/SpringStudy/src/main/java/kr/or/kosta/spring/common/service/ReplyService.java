package kr.or.kosta.spring.common.service;

import java.util.List;

import kr.or.kosta.spring.common.domain.Criteria;
import kr.or.kosta.spring.common.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO vo);
	
	public ReplyVO get(Long rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long rno);
	
	public List<ReplyVO> getList(Criteria cri, Long bno);

}
