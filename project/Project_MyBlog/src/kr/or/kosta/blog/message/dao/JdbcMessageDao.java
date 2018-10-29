package kr.or.kosta.blog.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.blog.message.domain.Message;

public class JdbcMessageDao implements MessageDao {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Message message) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO message \r\n" + 
				"            (message_no, sender, \r\n" + 
				"             receiver, \r\n" + 
				"             content) \r\n" + 
				"VALUES     (message_no_seq.nextval, ?, \r\n" + 
				"            ?, \r\n" + 
				"            ?)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, message.getSender());
			pstmt.setString(2, message.getReceiver());
			pstmt.setString(3, message.getContent());
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
	public List<Message> listAll() throws Exception {
		List<Message> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from message order by TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI') desc";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Message>();
			while (rs.next()) {
				Message message = new Message();
				message.setSender(rs.getString("sender"));
				message.setReceiver(rs.getString("receiver"));
				message.setContent(rs.getString("content"));
				message.setRegdate(rs.getString("regdate"));
				message.setHitcount(rs.getString("hitcount"));
				message.setMessage_no(rs.getString("message_no"));
				list.add(message);
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
	public void update(String message_no) throws Exception {
		
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql = "update message set hitcount = 1 where message_no =?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, message_no);
			pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		
		
	}


}
