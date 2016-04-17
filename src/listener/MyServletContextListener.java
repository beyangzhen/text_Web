package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
	
	//tomcat结束调用
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("servlet context destroyed!");
	}

	//tomcat启动过程中调用
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("servlet context created!");
	}
	
}
