package pattern2;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbcp2.BasicDataSource;

public class OracleJdbcUserDao extends JDBCUserDao {

	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "hr";
	private static final String password = "hr";
	
	@Override
	public Connection getConnection() throws Exception {
		// 커넥션 풀 적용하여 Connection 생성
//		Class.forName(driver).newInstance(); // 드라이버가 오라클메모리 생성
//		return DriverManager.getConnection(url, username, password);
//		return UserConnectionPool.getInstance().getConnection();
		
		BasicDataSource dataSource = new BasicDataSource(); //DataSource를 구현한 구현체 => BasicDataSource
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10);
		dataSource.setMaxIdle(7);
		
		return dataSource.getConnection();
		
	}

}
