package listener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class MyData implements HttpSessionBindingListener, HttpSessionActivationListener {

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("会话搁置[持久化]==");

	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("会话激活===");

	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("属性与会话绑定===");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("属性与会话解绑===");

	}

}
