
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DQLExample {

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "hr";
		String sql = "SELECT E.employee_id     id, \r\n" + "       E.last_name       ename, \r\n"
				+ "       E.salary          salary, \r\n" + "       TO_CHAR(E.hire_date,'YYYY-MM-DD HH24:MI:SS')       hiredate, \r\n"
				+ "       D.department_name dename \r\n" + "FROM   employees E \r\n" + "       join departments D \r\n"
				+ "         ON E.department_id = D.department_id ";

		Class.forName(driver).newInstance();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		con = DriverManager.getConnection(url, username, password);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int id = rs.getInt("id");
			String ename = rs.getString("ename");
			int salary = rs.getInt("salary");
			String hiredate = rs.getString("hiredate");
			String dename = rs.getString("dename");
			System.out.println(id + ", " + ename + ", " + salary + ", " + hiredate + ", " + dename);
		}
		
		rs.close();
		stmt.close();
		con.close();

	}
}
