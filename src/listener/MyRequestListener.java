package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 *  包括Application、Session、Request对象 初始化和销毁 	   的监听
 *                               对象属性 增加、代替和删除 的监听
 * /
public class MyRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("requestDestroyed---");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("requestInitialized---");
	}
	
}	
