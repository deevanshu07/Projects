package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ViewEmployee() 
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException	
	{
		PrintWriter pw = response.getWriter();
		List emps=(List)getServletContext().getAttribute("emps");
		System.out.println(emps);
		pw.println(emps);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

}
