package dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该类用来测试   使用Httpservlet  请求转发、效果相同
 * */
public class CheckServlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckServlet_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
//		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/outer");//这里只能是绝对路径  
		RequestDispatcher dispatcher=request.getRequestDispatcher("outer1");//这里可以是绝对路径或者相对路径  {相对路径：相对于当前源组件的路径}
		dispatcher.forward(request, response);
		
		out.println("dispatcher  -------");
		 //dispatcher.forward()是请求转发方法、在之后的语句也会执行  但是不会将数据输出。
		System.out.println("oooooooooooo");
		out.close(); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
