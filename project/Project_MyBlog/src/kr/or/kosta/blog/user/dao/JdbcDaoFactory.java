package kr.or.kosta.blog.user.dao;

import java.lang.reflect.Method;
import java.util.Hashtable;

import javax.sql.DataSource;

import kr.or.kosta.blog.article.dao.ArticleDao;
import kr.or.kosta.blog.guestbook.dao.GuestbookDao;
import kr.or.kosta.blog.message.dao.MessageDao;
import kr.or.kosta.blog.visitor.dao.VisitorDao;

public class JdbcDaoFactory extends DaoFactory {

private Hashtable<String, Object> daos;
	
	private String[] daoNames = {"kr.or.kosta.blog.user.dao.JdbcUserDao", "kr.or.kosta.blog.guestbook.dao.JdbcGuestbookDao",
			"kr.or.kosta.blog.article.dao.JdbcArticleDao", "kr.or.kosta.blog.visitor.dao.JdbcVisitorDao", "kr.or.kosta.blog.message.dao.JdbcMessageDao" };
	
	public JdbcDaoFactory() {
		daos = new Hashtable<String, Object>();
		
		for (String className : daoNames) {
			try {
				Object dao = Class.forName(className).newInstance();
				addDataSource(dao);
				daos.put(className, dao);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void addDataSource(Object dao) {
		Class cls = dao.getClass();
		// 동적 메소드호출
		Method method;
		try {
			method = cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public UserDao getUserDao() {
		return (UserDao)daos.get("kr.or.kosta.blog.user.dao.JdbcUserDao");
	}
	
	@Override
	public GuestbookDao getGuestbookDao() {
		return (GuestbookDao)daos.get("kr.or.kosta.blog.guestbook.dao.JdbcGuestbookDao");
	}
	
	@Override
	public ArticleDao getArticleDao() {
		return (ArticleDao)daos.get("kr.or.kosta.blog.article.dao.JdbcArticleDao");
	}

	@Override
	public VisitorDao getVisitorDao() {
		return (VisitorDao)daos.get("kr.or.kosta.blog.visitor.dao.JdbcVisitorDao");
	}
	@Override
	public MessageDao getMessageDao() {
		return (MessageDao)daos.get("kr.or.kosta.blog.message.dao.JdbcMessageDao");	}

}
