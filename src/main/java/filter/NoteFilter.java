package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class NoteFilter implements Filter {
private FilterConfig config=null;
private String blacklist=null;
private String blackip=null;
   
    public NoteFilter() {
       
    }

	
	public void destroy() {
	System.out.println("NoteFilter + destory");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String req=request.getParameter("username");
		System.out.println("notefilter==dofilter");
		chain.doFilter(request, response);
		System.out.println("NOteFilter  is good");
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	System.out.println("NoteFilter==init");	
	this.config=fConfig;	
	blackip=config.getInitParameter("ip");
	blacklist=config.getInitParameter("list");
	
	}

}
