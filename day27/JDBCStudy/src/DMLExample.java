
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DMLExample {

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "hr";
	String password = "hr";

	public void create(String departmentName, int managerId, int locationId) {
		String mId = "NULL";
		String lId = "NULL";
		if (managerId != 0) {
			mId = managerId + "";
		}
		if (locationId != 0) {
			lId = locationId + "";
		}

		String sql = "INSERT INTO departments \r\n" + "            (department_id, \r\n"
				+ "             department_name, \r\n" + "             manager_id, \r\n"
				+ "             location_id) \r\n" + "VALUES     (departments_seq.NEXTVAL, \r\n'" + departmentName
				+ "',\r\n" + mId + ", \r\n" + lId + ")";

		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false);
			stmt = con.createStatement();
			int count = stmt.executeUpdate(sql);
			con.commit();
			System.out.println(count + "행이 추가되었습니다.");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void create2(String departmentName, int managerId, int locationId) {
		create2(new Department(0, departmentName, managerId, locationId));
	}

	public void create2(Department department) {

		String sql = "INSERT INTO departments \r\n" + "            (department_id, \r\n"
				+ "             department_name, \r\n" + "             manager_id, \r\n"
				+ "             location_id) \r\n" + "VALUES     (departments_seq.NEXTVAL, \r\n" + "?,\r\n" + "?, \r\n"
				+ "?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false); 

			// SQL 전처리 (서버전송 전에)
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, department.getDepartmentName());
			if (department.getManagerId() != 0) {
				pstmt.setInt(2, department.getManagerId());
			} else {
				pstmt.setNull(2, Types.INTEGER);
			}
			if (department.getLocationId() != 0) {
				pstmt.setInt(3, department.getLocationId());
			} else {
				pstmt.setNull(3, Types.INTEGER);
			}

			int count = pstmt.executeUpdate();
			con.commit();
			System.out.println(count + "행이 추가되었습니다.");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void delete(int departmentId) {
		String sql = "Delete From Departments Where Department_Id = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false); 
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,departmentId);
			int count = pstmt.executeUpdate();
			con.commit();
			System.out.println(count + "행이 삭제되었습니다.");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		DMLExample exam = new DMLExample();
//		exam.create("코스타", 0, 0);
//		exam.create2("코스타2", 0, 0);
		exam.delete(320);

	}
}
