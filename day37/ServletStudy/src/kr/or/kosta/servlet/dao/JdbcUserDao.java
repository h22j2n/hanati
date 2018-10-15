package kr.or.kosta.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

public class JdbcUserDao implements UserDao {
	
	
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(User user) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO users \r\n" + 
				"VALUES     (?, \r\n" + 
				"            ?, \r\n" + 
				"            ?, \r\n" + 
				"            ?, \r\n" + 
				"            SYSDATE) ";
		
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPasswd());
		pstmt.setString(4, user.getEmail());
		pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close(); // 아파치 적용하면서 close가 닫아줄뿐아니라 반환까지
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public User read(String id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		
		String sql = "SELECT * \r\n" + 
				"FROM   users \r\n" + 
				"WHERE  id = ?";
		
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,id);
		rs = pstmt.executeQuery();
		if(rs.next()) {
		user.setId(id);
		user.setName(rs.getString("name"));
		user.setPasswd(rs.getString("passwd"));
		user.setEmail(rs.getString("email"));
		user.setRegdate(rs.getString("regdate"));
		
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

		return user;
	}

	@Override
	public void update(User user) throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE users \r\n" + 
				"SET    name = ?, \r\n" + 
				"       passwd = ?, \r\n" + 
				"       email = ? \r\n" + 
				"WHERE  id = ?";
		
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getPasswd());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getId());
		
		pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		

	}

	@Override
	public void delete(String id) throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM users \r\n" + 
				"WHERE  id = ?";
		
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public List<User> listAll() throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		List<User> list = new ArrayList<User>();
		
		String sql = "SELECT * \r\n" + 
				"FROM   users \r\n";
		
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPasswd(rs.getString("passwd"));
			user.setEmail(rs.getString("email"));
			user.setRegdate(rs.getString("regdate"));
			
			list.add(user);
		
		}
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

		return list;
	}

	@Override
	public User certify(String id, String passwd) throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		
		String sql = "SELECT * \r\n" + 
				"FROM   users \r\n" + 
				"WHERE  id = ? AND passwd = ?";
		
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,passwd);
		rs = pstmt.executeQuery();
		if(rs.next()) {
		user.setId(id);
		user.setName(rs.getString("name"));
		user.setPasswd(passwd);
		user.setEmail(rs.getString("email"));
		user.setRegdate(rs.getString("regdate"));
		
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

		return user;
	}


	@Override
	public List<Map<String,String>> employeeList() throws Exception {
		List<Map<String,String>> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT e.employee_id     id, \r\n" + 
				"       e.last_name       name, \r\n" + 
				"       e.salary          salary, \r\n" + 
				"       d.department_name dename, \r\n" + 
				"       l.city            city \r\n" + 
				"FROM   employees e \r\n" + 
				"      left outer join departments d \r\n" + 
				"         ON e.department_id = d.department_id \r\n" + 
				"      left outer join locations l \r\n" + 
				"         ON d.location_id = l.location_id ";
		
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		list = new ArrayList<Map<String,String>>();
		ResultSetMetaData rsd = rs.getMetaData();
		int columnCount = rsd.getColumnCount();
		while(rs.next()) {
			Map<String,String> row = new LinkedHashMap<String,String>();
			for (int i = 1; i <= columnCount; i++) {
				String columnName = rsd.getColumnLabel(i);
				String columnValue = rs.getString(i);
				
				row.put(columnName, columnValue);
			}
			list.add(row);
		
		}
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

		return list;
		
	}

}
