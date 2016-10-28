package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 这里测试的是 不同的servlet 共用同一个session范围的共享数据。
 * 一个会话：就是一个浏览器进程  和服务器交互完整的一次、从进入到离开为一个会话。
 * 只要浏览器不关闭  就是一个会话、同样可以设置会话过期时间。
 * cookie可以设置作用域、是否被那些服务器可以从浏览器上获得存放的cookie。就是那些cookie可以发往不同的服务器上。
 * 
 * 这里的额cookie和session使用的情况是：浏览器支持cookie。使用cookie来使用session会话机制。
 * */
public class Session_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Session_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession  session=request.getSession();
		session.setAttribute("username", "chengxiangfeng");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
