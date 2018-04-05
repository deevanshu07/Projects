package com.info.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServelr
 */
@WebServlet(urlPatterns="/FirstServelr", loadOnStartup=1)
public class FirstServelr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServelr() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("First Servlet");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println(" first Servlet init method");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println(" first Servlet destory method");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GET METHOD");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		System.out.println();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("psot method");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		System.out.println(userName);
		System.out.println(password);
		System.out.println();
		RequestDispatcher rd= request.getRequestDispatcher("SecondServlert");
		rd.forward(request, response);
	}

}
