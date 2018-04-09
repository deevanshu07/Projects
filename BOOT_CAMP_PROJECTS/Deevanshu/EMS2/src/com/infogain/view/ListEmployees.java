package com.infogain.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.infogain.model.*;


/**
 * Servlet implementation class ListEmployees
 */
public class ListEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // Set page title
        String pageTitle = "Infogain: List of Employees";
        
        // Specify the content type is HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Generate the HTML response
        out.println("<html>");
        out.println("<head>");
        out.println("  <title>" + pageTitle + "</title>");
        out.println("</head>");
        out.println("<body bgcolor='white'>");
        
        // Generate page heading
        out.println("<!-- Page Heading -->");
        out.println("<table border='1' cellpadding='5' cellspacing='0' width='400'>");
        out.println("<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>");
        out.println("  <td><h3>" + pageTitle + "</h3></td>");
        out.println("</tr>");
        out.println("</table>");
        
        // Retrieve the set of Employees 
        
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(1,"joseph","Albert","joseph.albert@gmail.com","9999999999",new Date("8-Sep-2010"),10000,(float)5,"HR"));
        employeeList.add(new Employee(2,"Jabi","John","jabi.john@gmail.com","9999999999",new Date("8-Oct-2009"),12000,6f,"Finance"));
        employeeList.add(new Employee(3,"Michael","clark","michael.clark@gmail.com","9999999999",new Date("8-Nov-2007"),15000,5f,"Training"));
        employeeList.add(new Employee(4,"Samual","Johnson","samual.johnson@gmail.com","9999999999",new Date("12-Sep-2011"),20000,6f,"Accounts"));
        // Generate main body
        out.println("<p>");
        out.println("The set of Employees are:");
        out.println("</p>");
        
        out.println("<ul>");
        Iterator items = employeeList.iterator();
        while ( items.hasNext() ) {
            Employee employee = (Employee) items.next();
            out.println("  <li>" + employee.getFirstName()+":"+employee.getLastName() + "</li>");
        }
        out.println("</ul>");
        out.println("End of list...");
        
        out.println("</body>");
        out.println("</html>");
    }

}

