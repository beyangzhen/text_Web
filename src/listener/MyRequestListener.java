package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 *  包括Application：对象初始化/销毁 和 对象属性增加/代替/删除 			    的监听
 *      Session	   ：对象初始化/销毁 和 对象属性增加/代替/删除 和 合并/绑定javaBean 的监听
 *      Request    ：对象初始化/销毁 和 对象属性增加/代替/删除 			    的监听
 *      
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
