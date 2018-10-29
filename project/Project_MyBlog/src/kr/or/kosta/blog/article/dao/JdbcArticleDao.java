package kr.or.kosta.blog.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.blog.article.domain.Article;
import kr.or.kosta.blog.common.web.Params;

public class JdbcArticleDao implements ArticleDao {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Article article) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO article \r\n" + "            (article_id, \r\n" + "             board_id, \r\n"
				+ "             writer, \r\n" + "             subject, \r\n" + "             content, \r\n"
				+ "             ip, \r\n" + "             passwd, \r\n" + "             group_no, \r\n"
				+ "             level_no, \r\n" + "             order_no, ATTACH_FILE) \r\n"
				+ "VALUES     (article_id_seq.nextval, \r\n" + "            1, \r\n" + "            ?, \r\n"
				+ "            ?, \r\n" + " ?, \r\n" + " ?, \r\n" + "  ?, \r\n"
				+ "            article_id_seq.currval, \r\n" + "  0, \r\n" + "  0, ?)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getSubject());
			pstmt.setString(3, article.getContent());
			pstmt.setString(4, article.getIp());
			pstmt.setString(5, article.getPasswd());
			pstmt.setString(6, article.getAttach_file());
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
	public Article read(String article_id) throws Exception {
		Article article = new Article();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT writer, article_id, subject, regdate, ip, hitcount, content, passwd, ATTACH_FILE, group_no, level_no, order_no\r\n"
				+ "FROM   article WHERE  article_id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article.setWriter(rs.getString("writer"));
				article.setArticle_id(rs.getString("article_id"));
				article.setSubject(rs.getString("subject"));
				article.setRegdate(rs.getString("regdate"));
				article.setIp(rs.getString("ip"));
				article.setHitcount(rs.getString("hitcount"));
				article.setContent(rs.getString("content"));
				article.setPasswd(rs.getString("passwd"));
				article.setGroup_no(rs.getString("group_no"));
				article.setLevel_no(rs.getString("level_no"));
				article.setOrder_no(rs.getString("order_no"));
				article.setAttach_file(rs.getString("ATTACH_FILE"));
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
		return article;
	}

	@Override
	public List<Article> listAll() throws Exception {
		List<Article> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT article_id, \r\n" + "       subject, \r\n" + "       writer, \r\n" + "       regdate, \r\n"
				+ "       ip, passwd,  \r\n" + "       hitcount \r\n" + " FROM article ORDER BY regdate DESC";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();
			while (rs.next()) {
				Article article = new Article();
				article.setWriter(rs.getString("writer"));
				article.setArticle_id(rs.getString("article_id"));
				article.setSubject(rs.getString("subject"));
				article.setRegdate(rs.getString("regdate"));
				article.setIp(rs.getString("ip"));
				article.setHitcount(rs.getString("hitcount"));
				article.setPasswd(rs.getString("passwd"));
				list.add(article);
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

	private Article createArticle(ResultSet rs) throws SQLException {
		Article article = new Article();
		article.setWriter(rs.getString("writer"));
		article.setArticle_id(rs.getString("article_id"));
		article.setSubject(rs.getString("subject"));
		article.setRegdate(rs.getString("regdate"));
		article.setIp(rs.getString("ip"));
		article.setHitcount(rs.getString("hitcount"));
		article.setLevel_no(rs.getString("level_no"));
		article.setAttach_file(rs.getString("attach_file"));

		return article;

	}

	@Override
	public List<Article> listByPage(int page) throws Exception {
		List<Article> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT article_id, \r\n" + "       subject, \r\n" + "       writer, \r\n" + "       regdate, \r\n"
				+ "       ip, \r\n" + "       hitcount, level_no \r\n" + "FROM   (SELECT CEIL(rownum / 10) request_page, \r\n"
				+ "               article_id, \r\n" + "               subject, \r\n" + "               writer, \r\n"
				+ "               regdate, \r\n" + "               ip, \r\n" + "               hitcount, level_no, ATTACH_FILE \r\n"
				+ "        FROM   (SELECT article_id, \r\n" + "                       subject, \r\n"
				+ "                       writer, \r\n" + "                       ip, \r\n"
				+ "                       hitcount, level_no, ATTACH_FILE, \r\n"
				+ "                       TO_CHAR(regdate, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') regdate\r\n"
				+ "                FROM   article \r\n" + "order by GROUP_NO desc, order_no asc)) \r\n"
				+ "WHERE  request_page = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();
			while (rs.next()) {
				Article article = createArticle(rs);
				list.add(article);
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
	public List<Article> listByPage(int page, int listSize) throws Exception {
		List<Article> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT article_id, \r\n" + "       subject, \r\n" + "       writer, \r\n" + "       regdate, \r\n"
				+ "       ip, \r\n" + "       hitcount, level_no, ATTACH_FILE \r\n" + "FROM   (SELECT CEIL(rownum / ?) request_page, \r\n"
				+ "               article_id, \r\n" + "               subject, \r\n" + "               writer, \r\n"
				+ "               regdate, \r\n" + "               ip, \r\n" + "               hitcount, level_no, ATTACH_FILE \r\n"
				+ "        FROM   (SELECT article_id, \r\n" + "                       subject, \r\n"
				+ "                       writer, \r\n" + "                       ip, \r\n"
				+ "                       hitcount, level_no, ATTACH_FILE,\r\n"
				+ "                       TO_CHAR(regdate, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') regdate\r\n"
				+ "                FROM   article \r\n" + "order by GROUP_NO desc, order_no asc)) \r\n"
				+ "WHERE  request_page = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, listSize);
			pstmt.setInt(2, page);
			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();
			while (rs.next()) {
				Article article = createArticle(rs);
				list.add(article);
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
	public List<Article> listByPage(int page, int listSize, String searchType, String searchValue) throws Exception {
		List<Article> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT article_id, \r\n" + "       subject, \r\n" + "       writer, \r\n" + "       ip, \r\n"
				+ "       hitcount, level_no, ATTACH_FILE, \r\n" + "       regdate \r\n" + "FROM   (SELECT CEIL(rownum / ?) request_page, \r\n"
				+ "               article_id, \r\n" + "               subject, \r\n" + "               writer, \r\n"
				+ "               ip, \r\n" + "               hitcount,\r\n" + "               regdate, level_no, ATTACH_FILE \r\n"
				+ "        FROM   (SELECT article_id, \r\n" + "                       subject, \r\n"
				+ "                       writer, \r\n" + "                       ip, \r\n"
				+ "                       hitcount, level_no, ATTACH_FILE, \r\n"
				+ "                       TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI') regdate\r\n"
				+ "                FROM   article \r\n";

		// 검색 유형별 WHERE 절 동적 추가
		if (searchType != null) {
			switch (searchType) {
			case "title":
				sql += " WHERE  subject LIKE ? \r\n";
				searchValue = "%" + searchValue + "%";
				break;
			case "writer":
				sql += " WHERE  writer LIKE ? \r\n";
				searchValue = "%" + searchValue + "%";
				break;
			case "content":
				sql += " WHERE  content LIKE ? \r\n";
				searchValue = "%" + searchValue + "%";
				break;
			}
		}
		sql += "order by GROUP_NO desc, order_no asc)) \r\n" + "WHERE  request_page = ?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, listSize);

			// 전체검색이 아닌경우 경우
			if (searchType != null) {
				pstmt.setString(2, searchValue);
				pstmt.setInt(3, page);
			} else {// 전체검색인 경우
				pstmt.setInt(2, page);
			}

			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();
			while (rs.next()) {
				Article article = createArticle(rs);
				list.add(article);
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
	public List<Article> listByPage(Params params) throws Exception {
		return listByPage(params.getPage(), params.getListSize(), params.getSearchType(), params.getSearchValue());
	}

	@Override
	public int countBySearch(String searchType, String searchValue) throws Exception {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT COUNT(article_id) count\r\n" + "FROM   article\r\n";

		// 검색 유형별 WHERE 절 동적 추가
		if (searchType != null) {
			switch (searchType) {
			case "title":
				sql += " WHERE  subject LIKE ? \r\n";
				searchValue = "%" + searchValue + "%";
				break;
			case "writer":
				sql += " WHERE  writer LIKE ? \r\n";
				searchValue = "%" + searchValue + "%";
				break;
			case "content":
				sql += " WHERE  content LIKE ? \r\n";
				searchValue = "%" + searchValue + "%";
				break;
			}
		}

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);

			// 전체검색이 아닌경우 경우
			if (searchType != null) {
				pstmt.setString(1, searchValue);
			}

			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}

	@Override
	public int countBySearch(Params params) throws Exception {
		return countBySearch(params.getSearchType(), params.getSearchValue());

	}

	@Override
	public void addCount(Article article) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE article \r\n" + "SET    hitcount = hitcount + 1 \r\n" + "WHERE  board_id = 1 \r\n"
				+ "       AND article_id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getArticle_id());
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
	public void update(Article article) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE article SET subject=?, content=? WHERE article_id= ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getSubject());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getArticle_id());
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
	public void createReArticle(Article article) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO article \r\n" + 
				"            (article_id, \r\n" + 
				"             board_id, \r\n" + 
				"             writer, \r\n" + 
				"             subject, \r\n" + 
				"             content, \r\n" + 
				"             ip, \r\n" + 
				"             passwd, \r\n" + 
				"             group_no, \r\n" + 
				"             level_no, \r\n" + 
				"             order_no) \r\n" + 
				"VALUES      (article_id_seq.NEXTVAL, \r\n" + 
				"             1, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             (SELECT group_no \r\n" + 
				"              FROM   article \r\n" + 
				"              WHERE  article_id =? ), \r\n" + 
				"             (SELECT level_no + 1 \r\n" + 
				"              FROM   article \r\n" + 
				"              WHERE  article_id =? ), \r\n" + 
				"             (SELECT Max(order_no) + 1 \r\n" + 
				"              FROM   article \r\n" + 
				"              WHERE  group_no = (SELECT group_no \r\n" + 
				"                                 FROM   article \r\n" + 
				"                                 WHERE  article_id =?)))";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getSubject());
			pstmt.setString(3, article.getContent());
			pstmt.setString(4, article.getIp());
			pstmt.setString(5, article.getPasswd());
			pstmt.setString(6, article.getArticle_id());
			pstmt.setString(7, article.getArticle_id());
			pstmt.setString(8, article.getArticle_id());
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
	public void updateOrdernum(Article article) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql2 = "select NVL(min(order_no),0) \r\n" + 
				"        from article \r\n" + 
				"        where group_no = \r\n" + 
				"                  (select group_no \r\n" + 
				"                  from article \r\n" + 
				"                  where article_id = ?)\r\n" + 
				"        and level_no =(select level_no from article where article_id = ?)\r\n" + 
				"        and order_no > (select order_no from article where article_id = ?)";

		
		String sql = "UPDATE article \r\n" + 
				"SET    order_no = order_no + 1 \r\n" + 
				"WHERE  board_id = 1 \r\n"
				+ "and group_no = (select group_no from article where article_id = ?)\r\n" + 
				"       AND order_no >= (SELECT min(order_no) \r\n" + 
				"                        FROM   article \r\n" + 
				"                        WHERE  group_no = (SELECT group_no \r\n" + 
				"                                           FROM   article \r\n" + 
				"                                           WHERE  article_id = ?) \r\n" + 
				"                               AND level_no = (SELECT level_no \r\n" + 
				"                                               FROM   article \r\n" + 
				"                                               WHERE  article_id = ?) \r\n" + 
				"                               AND order_no > (SELECT order_no \r\n" + 
				"                                               FROM   article \r\n" + 
				"                                               WHERE  article_id = ?)) ";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, article.getArticle_id());
			pstmt.setString(2, article.getArticle_id());
			pstmt.setString(3, article.getArticle_id());
			rs = pstmt.executeQuery();
			String orderNum = "1";
			if (rs.next()) {
				orderNum = rs.getString("NVL(min(order_no),0)");
			}
			pstmt.close();
			if(!orderNum.equals("0")) {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getArticle_id());
			pstmt.setString(2, article.getArticle_id());
			pstmt.setString(3, article.getArticle_id());
			pstmt.setString(4, article.getArticle_id());
			pstmt.executeUpdate();}
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
	public void createReReArticle(Article article) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql2 = "select order_no+1 order_no from article where article_id = ?";

		String sql3 = "select nvl(max(order_no) + 1,?) ordNum from article where level_no = (select level_no + 1 from article where article_id = ?)";

		String sql = "INSERT INTO article \r\n" + 
				"            ( \r\n" + 
				"                        article_id, \r\n" + 
				"                        board_id, \r\n" + 
				"                        writer, \r\n" + 
				"                        subject, \r\n" + 
				"                        content, \r\n" + 
				"                        ip, \r\n" + 
				"                        passwd, \r\n" + 
				"                        group_no, \r\n" + 
				"                        level_no, \r\n" + 
				"                        order_no \r\n" + 
				"            ) \r\n" + 
				"            VALUES \r\n" + 
				"            ( \r\n" + 
				"                        article_id_seq.NEXTVAL, \r\n" + 
				"                        1, \r\n" + 
				"                        ?, \r\n" + 
				"                        ?, \r\n" + 
				"                        ?, \r\n" + 
				"                        ?, \r\n" + 
				"                        ?, \r\n" + 
				"                        ( \r\n" + 
				"                               SELECT group_no \r\n" + 
				"                               FROM   article \r\n" + 
				"                               WHERE  article_id=?), \r\n" + 
				"                        ( \r\n" + 
				"                               SELECT level_no + 1 \r\n" + 
				"                               FROM   article \r\n" + 
				"                               WHERE  article_id=?), \r\n" + 
				"                        (select NVL(min(order_no)-1,?) \r\n" + 
				"        from article \r\n" + 
				"        where group_no = \r\n" + 
				"                  (select group_no \r\n" + 
				"                  from article \r\n" + 
				"                  where article_id = ?)\r\n" + 
				"        and level_no =(select level_no from article where article_id = ?)\r\n" + 
				"        and order_no > (select order_no from article where article_id = ?))" + 
				")";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, article.getArticle_id());
			rs = pstmt.executeQuery();
			String nvlNum = "0";
			if (rs.next()) {
				nvlNum = rs.getString("order_no");
			}
			pstmt.close();
			
			pstmt = con.prepareStatement(sql3);
			pstmt.setString(1, nvlNum);
			pstmt.setString(2, article.getArticle_id());
			rs = pstmt.executeQuery();
			String nvlNum2 = "0";
			if (rs.next()) {
				nvlNum2 = rs.getString("ordNum");
			}
			pstmt.close();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getSubject());
			pstmt.setString(3, article.getContent());
			pstmt.setString(4, article.getIp());
			pstmt.setString(5, article.getPasswd());
			pstmt.setString(6, article.getArticle_id());
			pstmt.setString(7, article.getArticle_id());
			pstmt.setString(8, nvlNum2);
			pstmt.setString(9, article.getArticle_id());
			pstmt.setString(10, article.getArticle_id());
			pstmt.setString(11, article.getArticle_id());
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
	public void delete(String article_id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE article \r\n" + 
				"SET    subject = '7000delete' \r\n" + 
				"WHERE  article_id = ? ";
		
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, article_id);
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
