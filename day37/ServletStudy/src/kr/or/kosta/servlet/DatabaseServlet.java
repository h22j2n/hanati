package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 우리가 연결하고자하는 DB URL
	String username = "hr";
	String password = "hr";
	String sql = "Select Employee_Id, Last_Name, Salary From Employees";

	Connection con;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				int employee_id = rs.getInt("employee_id");
//				String last_name = rs.getString("last_name");
//				int salary = rs.getInt("salary");
//				System.out.println(employee_id+"\t"+last_name+"\t"+salary);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size:20pt'>");
		out.println("<body>");
		
		out.println("<table border='1' width='50%'>");
		out.println("<th>employee_id</th>");
		out.println("<th>last_name</th>");
		out.println("<th>salary</th>");
		
		try {
			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String last_name = rs.getString("last_name");
				int salary = rs.getInt("salary");
				out.println("<tr>");
				out.println("<td>"+employee_id+"</td><td>"+last_name+"</td><td>"+salary+"</td>");
				out.println("</tr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		out.println("</table>");
		
		out.println("</body>");
		out.println("</html>");


	}
	@Override
	public void destroy() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
