

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class MyFilter
 */
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	private FilterConfig fConfig;
	String []str1;
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		System.out.println("Filter is Running");
		
		System.out.println("Filter init Parameters");
		String str="Deevanshu";
		for (int i = 0; i < str1.length; i++) {
			if(str.contains(str1[i]))
			{
				System.out.println("WAAAAAAAAAAAAAAAAAAAAAAo");
			}
		}
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("Filter is Stopped");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String str=fConfig.getInitParameter("name");
		System.out.println(str);
		str1=str.split(",");
		for (int i = 0; i < str1.length; i++) {
			System.out.println(str1[i]);
		}
	}

}
