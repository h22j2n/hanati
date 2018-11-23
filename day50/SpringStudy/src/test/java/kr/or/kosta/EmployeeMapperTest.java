package kr.or.kosta;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.kosta.spring.employee.mapper.EmployeeMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class EmployeeMapperTest {

	@Setter(onMethod_ = { @Autowired })
	private EmployeeMapper employeeMapper;
	
	@Test
	public void testGetTime() {
		log.info("getTime");
		log.info(employeeMapper.getTime());
	}


}