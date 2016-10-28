package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class SFilter implements Filter {

 
    public SFilter() {
    	
      
    }

	
	public void destroy() {
	System.out.println("sfilter==destory");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	System.out.println("SFilter==dofilter");
		chain.doFilter(request, response);
		System.out.println("SFilter is  good");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Sfilter===init");
	}

}
