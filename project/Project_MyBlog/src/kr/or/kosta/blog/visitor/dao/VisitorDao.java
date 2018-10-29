package kr.or.kosta.blog.visitor.dao;

import java.util.List;

import kr.or.kosta.blog.visitor.domain.Visitor;

/**
 * VisitorDao 패턴 적용을 위한 인터페이스 선언
 * @author 조희진
 *
 */
public interface VisitorDao {
	
	public void create(Visitor visitor) throws Exception;

	public void delete(String visitor_id) throws Exception;

	public List<Visitor> listAll() throws Exception;
	
	
}
