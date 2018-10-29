package kr.or.kosta.blog.message.dao;

import java.util.List;

import kr.or.kosta.blog.message.domain.Message;

/**
 * MessageDao 패턴 적용을 위한 인터페이스 선언
 * @author 조희진
 *
 */
public interface MessageDao {
	
	public void create(Message message) throws Exception;

	public void update(String message_no) throws Exception;

	public List<Message> listAll() throws Exception;
	
	
	
}
