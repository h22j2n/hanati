package kr.or.kosta.spring.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.or.kosta.spring.common.domain.Criteria;
import kr.or.kosta.spring.common.domain.ReplyVO;
import kr.or.kosta.spring.common.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private Long[] bnoArr = {202L, 203L, 204L, 205L, 206L};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replyMapper;
	
//	@Test
	public void testMapper() {
		log.info(replyMapper);
	}
//	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("replyer"+i);
			
			replyMapper.insert(vo);
			
			
		});
	}
	
//	@Test
	public void testRead() {
		Long targetRno = 3L;
		
		ReplyVO vo = replyMapper.read(targetRno);
		log.info(vo);
	}
	
//	@Test
	public void testDelete() {
		Long targetRno = 2L;
		replyMapper.delete(targetRno);
	}
	
//	@Test
	public void testUpdate() {
		Long targetRno = 3L;
		ReplyVO vo = replyMapper.read(targetRno);
		
		vo.setReply("update Reply");
		int count = replyMapper.update(vo);
		
		log.info("update count : " + count);
	}
	
//	@Test
	public void testList() {
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = replyMapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
	}

}
