package kr.or.kosta.shoppingmall.common.dao;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.user.dao.JdbcUserDao;
import kr.or.kosta.shoppingmall.user.dao.UserDao;
import kr.or.kosta.shoppingmall.user.domain.User;

public class JdbcDaoFactory extends DaoFactory {
	
	private HashMap<String, Object> daos;

	public JdbcDaoFactory(String mapperLocation) {
		daos = new HashMap<String, Object>();

		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(mapperLocation);
			prop.load(fis);
			Iterator keyIter = prop.keySet().iterator();
			System.out.println("--- DAO 생성목록 ---");
			while (keyIter.hasNext()) {
				String daoName = (String) keyIter.next();
				String daoClassName = prop.getProperty(daoName);
				Object daoObject = Class.forName(daoClassName).newInstance();
				addDataSource(daoObject);
				daos.put(daoClassName, daoObject);
				System.out.println(daoName + "="+ daoClassName);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Object getDao(String daoName) {
		return daos.get(daoName);
	}

	public Object getDao(Class cls) {
		return getDao(cls.getName());
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
	
	
	public static void main(String[] args) throws Exception {
		String mapperLocation = "C:/KOSTA187/workspace/Model2Study/WebContent/WEB-INF/dao-mapper.properties";
		DaoFactory factory = new JdbcDaoFactory(mapperLocation);
		UserDao dao = (UserDao) factory.getDao(JdbcUserDao.class);
		List<User> list = dao.listAll();
		for (User user : list) {
			System.out.println(user.toString());
		}
		
	}

}
