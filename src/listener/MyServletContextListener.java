package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *  包括Application、Session、Request对象 初始化和销毁 	   的监听
 *                               对象属性 增加、代替和删除 的监听
 * /
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
