package com.twc.okm.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.twc.okm.request.InquiraServletRequestWrapper;

/**
 * @version 1.0
 * @author Infogain this is Servlet Filter implementation class TWCSSOFilter for IC
 * 
 */
public class TwcSSOFilter implements Filter {

	private static Logger logger = Logger.getLogger(TwcSSOFilter.class);

	/**
	 * Default constructor.
	 */
	public TwcSSOFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	String initParamCheck="";
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response; // For SSO ON INDEX PAGE
		HttpSession session = ((HttpServletRequest) request).getSession(true);

		String buildurl ="";
		if(req.getQueryString() !=null ){
			buildurl = req.getRequestURL().toString()+"?"+req.getQueryString().toString();
		}else{
			buildurl = req.getRequestURL().toString();
		}		
		
		if(session.getAttribute("userpagevisit") == null){
			if(buildurl.contains(initParamCheck) &&  (buildurl.toUpperCase().contains("USERNAME=V") || buildurl.toUpperCase().contains("REDIRECT=FALSE"))){	
				session.setAttribute("userpagevisit","indexpage");
				session.setAttribute("Twc_Filter_First","true");				
		    	chain.doFilter(request, response);
		    	return;					
		    }				
			res.sendRedirect("index.jsp?twcurl="+URLEncoder.encode(buildurl, "UTF-8"));
			if(true) return;
		} 
		else {			
			if (session.getAttribute("Twc_Filter_First") == null) { // first
				/*logger.debug("TWC SSO User name from Remote::"
						+ req.getRemoteUser());*/
				InquiraServletRequestWrapper inquiraServeletRequestWrapper = new InquiraServletRequestWrapper(
						req);
				inquiraServeletRequestWrapper.addHeader("username",
						req.getRemoteUser());
				session.setAttribute("Twc_Filter_First", "true");
				chain.doFilter(inquiraServeletRequestWrapper, response);
			} else { // always
				//logger.debug("TWC SSO Filter second time");
				chain.doFilter(request, response);
			}
		} // end of else session !=null
		
	} // end of doFilter

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		initParamCheck= fConfig.getInitParameter("ignoredPages");
	}

}
