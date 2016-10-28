package dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class OutputServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
   
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	String message=(String) request.getAttribute("msg");
	PrintWriter  out=response.getWriter();
	out.println(message);
	System.out.println("OutputServlet");
	out.close();
	}
	

}
