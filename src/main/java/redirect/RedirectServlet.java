package redirect;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 该请求的的路径及格式
 * 127.0.0.1:8080/servletstudy/redirect?username=cheng
 * 
 * 结果
 * 
 * Hello,cheng
 * 
 * */
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out=response.getWriter();
	    //获得参数  没有username参数的话  就会返回空、而out在重定向的情况下、数据是不会输出到页面的、所以没有
//	    username参数 out也不会输出数据、
	    String username=request.getParameter("username");
	    String message=null;
	    if(username==null){
	    	out.println("please input username");
	    }else{
	    	message="Hello,"+username;
	    	
	    }
	    
	    request.setAttribute("msg", message);
		
	    //重定向   会重新请求另外的数据源
	    response.sendRedirect("/servletstudy/redirectout?msg="+message);
	    out.println("RedirctServlet后面的数据。");
	    //这里的输出同样会执行、这里的RedirectSeervlet类的功能就是一个简单的重定向、返回一个302状态码   告诉浏览器  去访问另外的资源、就是一个简单的输出“302”的 功能。
//	    
	    System.out.println("ResirectServlet=======");
//	    out.close();
	    
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
