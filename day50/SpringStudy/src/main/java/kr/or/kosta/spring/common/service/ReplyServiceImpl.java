package kr.or.kosta.spring.common.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.spring.common.domain.Criteria;
import kr.or.kosta.spring.common.domain.ReplyVO;
import kr.or.kosta.spring.common.mapper.ReplyMapper;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {
		log.info("register............" + vo);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("get............" + rno);

		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("modify............" + vo);
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		log.info("remove.........." + rno);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("get Reply List of a Board " + bno);
		return mapper.getListWithPaging(cri, bno);
	}

}
