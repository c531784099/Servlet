package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 我们可以修改cookie的作用时间、或者删除cookie
 * 
 * 同样我们可以修稿cookie的作用域
 * 
 * 我们可以通过
 * cookie.setPath("/app2")方法来设置同一个浏览器中的作用域
 * 
 * 这个作用域主要是指：设置哪些资源可以使用 这个cookie  
 *  
 * 设置同一个服务器的不同应用、
 * 不同服务器的不同应用{cookie.setDomain(.cat.com);  cookie.setPath(/app3/);   www.cat.com服务器下的 /app3/ 应用使用   }。
 * 
 * */
public class Cookie1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie=null;
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		
		Cookie[] cookies=request.getCookies();
		
		if(cookies!=null){
			for (int i = 0; i < cookies.length; i++) {
				out.println("cookie name:"+cookies[i].getName());
				out.println("cookie value:"+cookies[i].getValue());
				if(cookies[i].getName().equals("username")){
					
					cookie=cookies[i];
				}
			}
			
		}else{
			
			out.println("No cookie");
		}
		
		if(cookie==null){
			cookie=new Cookie("username","Tom");
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
			
		}else if(cookie.getValue().equals("Tom")){
			cookie.setValue("Jack");
			response.addCookie(cookie);
			
		}else if(cookie.getValue().equals("Jack")){
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		
		//关闭输出流
		out.close();
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
