package com.twc.okm.request;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Enumeration;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Map;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletRequestWrapper;

	
	/**
	 * @version 1.0
	 * @author Infogain this is wrapper class of httpservletrequest this class
	 *         can be used to add header parameters in the request.
	 * 
	 */

	public class InquiraServletRequestWrapper extends HttpServletRequestWrapper {
		/***
		 * 
		 */
		private Map headerMap;

		/**
		 * aad the parameter in the header
		 * 
		 * @param name
		 * @param value
		 */
		public void addHeader(String name, String value) {
			this.headerMap.put(name, value);
		}

		/**
		 * default constructor
		 * 
		 * @param request
		 */
		public InquiraServletRequestWrapper(HttpServletRequest request) {
			super(request);
			this.headerMap = new HashMap();
		}

		/**
		 * @return the Enumeration of headernames
		 */
		public Enumeration getHeaderNames() {
			List list = new ArrayList();
			
			try {
				HttpServletRequest request = (HttpServletRequest) getRequest();

				for (Enumeration e = request.getHeaderNames(); e.hasMoreElements();) {
					list.add(e.nextElement().toString());
				}
				
				for (Iterator itrCount = this.headerMap.keySet().iterator(); itrCount.hasNext();) {
					list.add(itrCount.next());
				}
				
			} catch (Exception exception) {
				System.out.println("A problem ocurred while obtianing the header names"+ exception);
				list = null;
			}

			Enumeration enumeration = null;
			if( list != null) {
				enumeration = Collections.enumeration(list);
			}
			
			return enumeration; 
		}

		/**
		 * @param name
		 * @return the header parameter value
		 */
		public String getHeader(String name) {
			Object value;
			String headerValue = null;
			
			try {
				if ((value = this.headerMap.get(name)) != null) {
					headerValue = value.toString();
				} else {
					headerValue = ((HttpServletRequest) getRequest()).getHeader(name);
				}
			} catch (Exception exception) {
				System.out.println( String.format("An error ocurred while attempting to retrieve [%s] header", name) +  exception);
				headerValue = null;
			}

			return headerValue;
		}

		/**
		 * @param name
		 * @return the enumeration of values for given header name
		 */
		public Enumeration getHeaders(String name) {
			Enumeration headers= null;
			Object value = this.headerMap.get(name);
			try {

				if (value != null) {
					List values = new ArrayList();
					values.add(value);
					headers = Collections.enumeration(values);
				} else {
					headers = super.getHeaders(name);
				}
			} catch (Exception exception) {
				System.out.println(String.format("An error ocurred while attempting to retrieve [%s] header", name) +  exception);
				headers = null;
			}

			return headers;
		} // end of method getHeaders

	} // end of class
