package dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * 请求转发：不同servlet之间的 service调用
 * 
 * 这里的doGet  doPost  等是HttpServlet  重写service方法 之后的调用。
 * 
 * 
 * 不同应用间也可以进行 请求的请求转发、需要设置一个 tomcat中的context元素标签中的crossContext=true设置。
 * 
 * */
public class CheckServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
 

	//GenericServlet唯一没有实现的方法。
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	String username=request.getParameter("username");
	String message=null;
	
	if(username==null){
		message="Please input username";	
	}else{
		message="hello,"+username;
	}
	request.setAttribute("msg", message);	
	//测试执行顺序
	PrintWriter  out=response.getWriter();
	out.println("dispatcher  forward....");
	//源组件的输出不会输出到 前台页面
	System.out.println("dispatcher   +++++");
	
//	RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/outer");//这里只能是绝对路径  
	RequestDispatcher dispatcher=request.getRequestDispatcher("outer");//这里可以是绝对路径或者相对路径  {相对路径：相对于当前源组件的路径}
	dispatcher.forward(request, response);
	
	out.println("dispatcher  -------");
	 //dispatcher.forward()是请求转发方法、在之后的语句也会执行  但是不会将数据输出。
	System.out.println("oooooooooooo");
	out.close(); 
	
	}

}
