
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * JDBC API를 이용한 DBMS 연동
 * @author 조희진
 *
 */
public class JDBCExample {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 우리가 연결하고자하는 DB URL
		String username = "hr";
		String password = "hr";
		String sql = "Select Employee_Id, Last_Name, Salary From Employees";

		
		// #1. JDBC 드라이버 로딩(객체 생성)
//		Driver driver = new OracleDriver();
		// Class 클래스를 이용한 동적 객체 생성
//		Class.forName(driver).newInstance();
		try {
			Class.forName(driver); // 굳이 .newInstance() 안해줘도 됨
//			System.out.println("JDBC 드라이버 생성완료");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// #2. Driver 연결
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password); // Connection은 인터페이스
//			System.out.println("DBMS 연결 완료.." + con);
			
			// #3. SQL 서버 전송 및 결과집합 수신
			stmt = con.createStatement();
//			System.out.println(stmt);
			rs = stmt.executeQuery(sql);
//			System.out.println(rs);

			// #4. ResultSet에서 데이터 인출(패치)
			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String last_name = rs.getString("last_name");
				int salary = rs.getInt("salary");
				System.out.println(employee_id+"\t"+last_name+"\t"+salary);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (con != null) con.close();
			} catch (Exception e) {}
		}
		

	}

}
