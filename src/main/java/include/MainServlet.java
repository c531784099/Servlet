package include;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试包含
 * 
 * 这里需要注意的是  源组件和目标组件使用的request和response是同一个对象、同样这两个对象拥有的资源也是相同的。PrintWriter实例是相同的。
 * */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	out.println("<html><head><title>MainServlet</title></head> <body>");
	ServletContext  context=getServletContext();
	
	//获得RequestDispatcher

	RequestDispatcher  headDispatcher=context.getRequestDispatcher("/staticdata/head.html");
	RequestDispatcher greetDispatcher=context.getRequestDispatcher("/greet");  //这里的 "/greet" 路径是在web.xml中设置的
	RequestDispatcher footerDispacher=context.getRequestDispatcher("/staticdata/footer.html");
	
	//包含资源
	headDispatcher.include(request, response);	
	greetDispatcher.include(request, response);
	footerDispacher.include(request, response);
	
	out.println("</body></html>");
	System.out.println(out);
	//关闭输出流
	out.close();
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
