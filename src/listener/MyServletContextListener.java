package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *  包括Application：对象初始化/销毁 和 对象属性增加/代替/删除 			    的监听
 *      Session	   ：对象初始化/销毁 和 对象属性增加/代替/删除 和 合并/绑定javaBean 的监听
 *      Request    ：对象初始化/销毁 和 对象属性增加/代替/删除 			    的监听
 *      
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
