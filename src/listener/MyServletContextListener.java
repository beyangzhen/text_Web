package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
	
	//tomcat��������
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("servlet context destroyed!");
	}

	//tomcat���������е���
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("servlet context created!");
	}
	
}
