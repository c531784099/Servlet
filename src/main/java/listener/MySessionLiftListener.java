package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionLiftListener implements HttpSessionListener, HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("会话中添加一个属性");

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("会话中删除一个属性");

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("会话中的属性值被替换一个");

	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("会话创建");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("会话销毁");

	}

}
