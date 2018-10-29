package kr.or.kosta.blog.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.blog.visitor.domain.Visitor;

public class JdbcVisitorDao implements VisitorDao {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Visitor visitor) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO visitor (visitor_id) \r\n"
				+ "VALUES (?)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, visitor.getVisitor_id());
			pstmt.executeUpdate();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
	}



	@Override
	public List<Visitor> listAll() throws Exception {
		List<Visitor> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visitor order by TO_CHAR(visit_date, 'YYYY-MM-DD HH24:MI') desc";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Visitor>();
			while (rs.next()) {
				Visitor visitor = new Visitor();
				visitor.setVisitor_id(rs.getString("visitor_id"));
				visitor.setVisit_date(rs.getString("visit_date"));
				list.add(visitor);
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

	@Override
	public void delete(String visitor_id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM visitor \r\n" + 
				"WHERE  visitor_id = ?";
		
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, visitor_id);
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


}
