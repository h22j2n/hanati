package pattern;

import java.util.List;
import java.util.Map;

public class UserDaoTest {

	public static void main(String[] args) {
		UserDao dao = new JDBCUserDao();
		User user = new User();
		user.setId("bangry");
		user.setName("희진");
		user.setPasswd("1111");
		user.setEmail("gmlwls008@gmail.com");
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
		
//		try {
//			List<User> list = dao.listAll();
//			Iterator itr = list.iterator();
//			while (itr.hasNext()) {
//				Object object = (Object) itr.next();
//				System.out.println(object);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
		
		List<Map<String, String>> list;
		try {
			list = dao.employeeList();
			for (Map<String, String> map : list) {
				System.out.println(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
