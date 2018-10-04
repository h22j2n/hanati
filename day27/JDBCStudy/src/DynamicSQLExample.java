
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DynamicSQLExample {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "hr";
	String password = "hr";
	
	public void executeSQL(String sql) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(sql);
			boolean existRS = pstmt.execute();
			if(existRS) {
				rs = pstmt.getResultSet();
				ResultSetMetaData rsm = rs.getMetaData();
				int count = rsm.getColumnCount();
				
				for (int i = 1; i <= count; i++) {
					String columnName = rsm.getColumnLabel(i);
					System.out.print(columnName + "\t");
				}

				while(rs.next()) {
					for (int i = 1; i <= count; i++) {
						String columnName = rsm.getColumnName(i);
						String columnValue = rs.getString(columnName);
						System.out.print(columnValue + "\t");
					}
					System.out.println();
				}
			}
			else {
				int count = pstmt.getUpdateCount();
				System.out.println(count + "행이 변경되었습니다..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
	DynamicSQLExample dsql = new DynamicSQLExample();
	dsql.executeSQL("Select * from departments");

	}
}
