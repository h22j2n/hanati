package pattern;

import java.util.Iterator;
import java.util.List;

public class UserDaoTest {

	public static void main(String[] args) {
		UserDao dao = new JDBCUserDao();
//		User user = new User();
//		user.setId("bangry");
//		user.setName("조희진");
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

	}

}
