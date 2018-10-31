package kr.or.kosta.shoppingmall;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kr.or.kosta.shoppingmall.employee.domain.Employee;

public class MybatisTest {

	private static final String NAMESPACE = "kr.or.kosta.shoppingmall.employee.";
	String resource = "mybatis-config.xml"; // resource 밑에 바로 있으니까~ resource 기준임
	SqlSessionFactory sqlSessionFactory;
	Logger logger = Logger.getLogger(MybatisTest.class);

	@Before
	public void setup() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
		logger.debug("sqlSessionFactory 생성 완료!");
	}

//	@Test
	public void testMybatis() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Employee> list = sqlSession.selectList(NAMESPACE + "selectAll2");
		for (Employee employee : list) {
			logger.debug(employee);
		}
		sqlSession.close();
	}

//	@Test
	public void testSelectList2() {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("min", 3000);
		params.put("max", 4000);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Employee> list = sqlSession.selectList(NAMESPACE + "selectEmployeesBySalary", params);
		for (Employee employee : list) {
			logger.debug(employee);
		}
		sqlSession.close();
	}

//  @Test
	// 매개변수 한개 전달 : 와일드카드 검색 : 전달할 때 %를 포함해서 보내야함
	public void testSelectListLike() {
		String name = "%E%";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Employee> list = sqlSession.selectList(NAMESPACE + "selectEmployeesByLastName", name);
		for (Employee employee : list) {
			logger.debug(employee);
		}
		sqlSession.close();
	}

//	@Test
	public void testSelectListJoin() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Map<String, Object>> list = sqlSession.selectList(NAMESPACE + "selectEmployeesWithDepartment");
		for (Map<String, Object> map : list) {
			BigDecimal id = (BigDecimal) map.get("id"); // int로 받지 않음! BigDecimal로 받음!!
			String lastName = (String) map.get("lastName");
			logger.debug(id + ", " + lastName);

		}
		sqlSession.close();
	}

//	@Test
	public void testUpdate() {
		Employee emp = new Employee();
		emp.setId(100);
		emp.setSalary(777);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.update(NAMESPACE + "updateEmployee", emp);
		sqlSession.commit();
		logger.debug("업데이트 완료!");
		sqlSession.close();
	}

//	@Test
	public void testSelectOne() {
		int num = 100;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Employee employee = sqlSession.selectOne(NAMESPACE + "selectEmployeeById", num);
		logger.debug(employee);
		sqlSession.close();
	}
	
	@Test
	public void testDynamic() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType", "id");
		map.put("searchValue", "160");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Employee> list = sqlSession.selectList(NAMESPACE + "dynamicSQL", map);
		for (Employee employee : list) {
			logger.debug(employee);
		}
		sqlSession.close();
	}

}
