package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttrListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("session attribute" + event.getName() + "has bean added!");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("session attribute" + event.getName() + "has bean removed!");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("session attribute" + event.getName() + "has bean replaced!");
	}
	
}
