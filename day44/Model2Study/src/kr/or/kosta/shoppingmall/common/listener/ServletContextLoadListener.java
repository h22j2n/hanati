package kr.or.kosta.shoppingmall.common.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kr.or.kosta.shoppingmall.common.dao.DaoFactory;
import kr.or.kosta.shoppingmall.common.dao.JdbcDaoFactory;
import kr.or.kosta.shoppingmall.common.service.ServiceFactory;


/**
 * ServletContext 생명주기(생성/소멸) 관련 이벤트 리스너
 * @author 김기정
 */
public class ServletContextLoadListener implements ServletContextListener {
	
	/**
	 * ServletContext생성 이벤트 처리
     * ServletContext가 생성되면(서블릿컨테이너 초기화) 웹 애플리케이션내의
     * 모든 Servlet, JSP, Filter 등이 공유할 수 있는 객체 또는 리소스 생성 및 등록(초기화)
	 */
	public void contextInitialized(ServletContextEvent event)  {
		ServletContext servletContext = event.getServletContext();
		String serviceMapperLocaion = servletContext.getInitParameter("serviceMapperLocation");
		String daoMapperLocaion = servletContext.getInitParameter("daoMapperLocation");

		DaoFactory daoFactory = new JdbcDaoFactory(daoMapperLocaion);
		ServiceFactory serviceFactory = new ServiceFactory(serviceMapperLocaion);

		servletContext.setAttribute("serviceFactory", serviceFactory);
		servletContext.setAttribute("daoFactory", daoFactory);
		System.out.println("[debug] : serviceFactory, daoFactory 생성완료!");
	}
	
	
	public void contextDestroyed(ServletContextEvent event)  {
		System.out.println("[Debug] : ServletContext(서블릿컨테이너) 종료됨 >>>");
    }
}
