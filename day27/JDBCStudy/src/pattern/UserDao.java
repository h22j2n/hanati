package pattern;

import java.sql.Connection;
import java.util.List;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 조희진
 *
 */
public interface UserDao {
	
	public void create(User user) throws Exception;
	
	public User read(String id) throws Exception;
	
	public void update(User user) throws Exception;

	public void delete(String id) throws Exception;
	
	public List<User> listAll() throws Exception;

	public User certify(String id, String passwd) throws Exception;
	
	public Connection getConnection() throws Exception;

}
