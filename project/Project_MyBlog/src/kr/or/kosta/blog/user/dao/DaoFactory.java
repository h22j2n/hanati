/**
 * 
 */
package kr.or.kosta.blog.user.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import kr.or.kosta.blog.article.dao.ArticleDao;
import kr.or.kosta.blog.guestbook.dao.GuestbookDao;
import kr.or.kosta.blog.message.dao.MessageDao;
import kr.or.kosta.blog.visitor.dao.VisitorDao;

/**
 * 추상 팩토리 패턴 적용을 위한 DaoFactory
 * 
 * @author 조희진
 */
public abstract class DaoFactory {
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521";
	private static final String USERNAME = "hr";
	private static final String PASSWORD = "hr";
	private static final int INIT_SIZE = 2;
	private static final int MAX_TOTAL = 10;
	private static final int MAX_IDLE = 5;
	
	private BasicDataSource  dataSource;
	
	public DaoFactory() {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		dataSource.setInitialSize(INIT_SIZE);
		dataSource.setMaxTotal(MAX_TOTAL);
		dataSource.setMaxIdle(MAX_IDLE);
	}
	
	public BasicDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public abstract UserDao getUserDao();
	public abstract GuestbookDao getGuestbookDao();
	public abstract ArticleDao getArticleDao();
	public abstract VisitorDao getVisitorDao();
	public abstract MessageDao getMessageDao();
	
	
}
