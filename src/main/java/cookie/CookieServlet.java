package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * servlet  一旦实例化  就会一直存在 成员变量的值会一直保存
 * 不同的浏览器有不同的cookie
 * 
 * 客户端第一次访问 服务器端  没有cookie 、在响应的时候会 添加cookie 、客户端将添加的cookie  保存在浏览器的进程中。
 * 
 * 客户端再次请求服务端的时候会将所有的cookie发送到服务端。cookie就是一种传递信息的数据结构
 * */

public class CookieServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       int count=0;
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/plain");
	PrintWriter out=response.getWriter();
	
	Cookie[] cookies=request.getCookies();
	if(cookies!=null){
		for (int i = 0; i < cookies.length; i++) {
			out.println("cookie name:"+cookies[i].getName());
			out.println("cookie value:"+cookies[i].getValue());
			out.println("Max Age:"+cookies[i].getMaxAge());
		}
		
	}else{
		out.println("No Cookie");
	}
	//添加不同的cookie到客户端的浏览器中
	response.addCookie(new Cookie("cheng"+count,"wang"+count));
	count++;
	
	out.close();	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
