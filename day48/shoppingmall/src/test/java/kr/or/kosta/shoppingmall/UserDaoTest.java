package kr.or.kosta.shoppingmall;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kr.or.kosta.shoppingmall.employee.domain.Employee;
import kr.or.kosta.shoppingmall.user.dao.MybatisUserDao;
import kr.or.kosta.shoppingmall.user.dao.UserDao;
import kr.or.kosta.shoppingmall.user.domain.User;

public class UserDaoTest {

	private static final String NAMESPACE = "kr.or.kosta.shoppingmall.user.";
	
	String resource = "mybatis-config.xml"; // resource 밑에 바로 있으니까~ resource 기준임
	SqlSessionFactory sqlSessionFactory;
	Logger logger = Logger.getLogger(UserDaoTest.class);

	UserDao userDao;
	
	@Before
	public void setup() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
		logger.debug("sqlSessionFactory 생성 완료!");
		userDao = new MybatisUserDao();
		((MybatisUserDao)userDao).setSqlSessionFactory(sqlSessionFactory);
	}

//	@Test
	public void testCreate() {
		User user = new User("h22j22n", "조희진", "1111", "gmlwls002@naver.co", null);
		try {
			userDao.create(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testRead() {
			try {
				User user = userDao.read("bogum");
				logger.debug(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
//	@Test
	public void testUpdate() {
		User user = new User("h22j22n", "조희진", "2222", "gmlwls0@naver.co", null);
		try {
			userDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("업데이트 완료!");
	}
	
//	@Test
	public void testDelete() {
		String id = "bogum";
		try {
			userDao.delete(id);
			logger.debug("삭제 완료!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testCertify() {
		String id = "gs";
		String passwd = "ggg";
		try {
			User user = userDao.certify(id, passwd);
			logger.debug(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testListByPage1() {
		List<User> list = null;
		try {
			list = userDao.listByPage(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (User user : list) {
			logger.debug(user);
		}
	}
	
//	@Test
	public void testListByPage2() {
		List<User> list = null;
		try {
			list = userDao.listByPage(1, 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (User user : list) {
			logger.debug(user);
		}
	}
	
	@Test
	public void testListByPage3() {
		List<User> list = null;
		try {
			list = userDao.listByPage(1, 5, "name", "용");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (User user : list) {
			logger.debug(user);
		}
	}
	
//	@Test
	public void testCountBySearch() {
		try {
			int count = userDao.countBySearch("id", "sujin");
			logger.debug(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//	@Test
	public void testListAll() {
		try {
			List<User> list = userDao.listAll();
			for (User user : list) {
				logger.debug(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
