package pattern2;

import java.sql.Connection;
import java.sql.DriverManager;

public class MongoDBJdbcUserDao extends JDBCUserDao {

	@Override
	public Connection getConnection() throws Exception {
		// 커넥션 풀 적용하여 Connection 생성
//		Class.forName(driver).newInstance(); // 드라이버가 오라클메모리 생성
//		return DriverManager.getConnection(url, username, password);
		return null;
		
	}

}
