package pattern3;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class UserDaoTest {
	
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "hr";
	private static final String password = "hr";

	public static void main(String[] args) {
		JdbcUserDao dao = new JdbcUserDao();
		
		
		BasicDataSource dataSource = new BasicDataSource(); //DataSource를 구현한 구현체 => BasicDataSource
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10);
		dataSource.setMaxIdle(7);
		
		dao.setDataSource(dataSource);
		
//		User user = new User();
//		user.setId("bangry");
//		user.setName("희진");
//		user.setPasswd("1111");
//		user.setEmail("gmlwls008@gmail.com");
//		
//		try {
//			dao.create(user);
//			System.out.println("회원가입 완료..");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println();
//			SQLException ex = (SQLException)e;
//			System.out.println(ex.getErrorCode());
//		}
		
//		try {
//			System.out.println(dao.read("bangry"));
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			List<User> list = dao.listAll();
			Iterator itr = list.iterator();
			while (itr.hasNext()) {
				Object object = (Object) itr.next();
				System.out.println(object);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			dao.update(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			System.out.println(dao.certify("bangry", "1111"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		List<Map<String, String>> list;
//		try {
//			list = dao.employeeList();
//			for (Map<String, String> map : list) {
//				System.out.println(map);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}
}

