package kr.or.kosta;

import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.kosta.spring.demo.service.SomeService;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SpringAOPTest {

	@Inject
	private SomeService someService;

	@Test
	public void testSomeService() throws SQLException {
		someService.foo("Hello Spring AOP~~~");
	}
	
	@Test
	public void testSomeService2() throws SQLException {
		String msg = someService.bar();
		log.info(msg);
	}
}







