package com.infogain.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Support classes
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Iterator;

public class AddEmployeeFormServlet extends HttpServlet {
    
    /** There are the default department for the US. */
    private static final String DEFAULT_DEPARTMENT = "HR,Finance,Training,Others";
    
    /** This variable holds the set of department. */
    private String[] DEPARTMENT;
    
    /** The init method configures the set of department. */
    public void init() {
        String department_list = getInitParameter("department-list");
        if ( department_list == null ) {
        	department_list = DEFAULT_DEPARTMENT;
        }
        DEPARTMENT = department_list.split(",");
    }
    
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        generateView(request, response);
    }
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        generateView(request, response);
    }
    
    public void generateView(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        
        // Set page title
        String pageTitle = "Infogain's Employee Mangement System: Add a New Employee";
        
        // Retrieve the errorMsgs from the request-scope
        List errorMsgs = (List) request.getAttribute("errorMsgs");
        
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
        
        // Report any errors (if any)
        if ( errorMsgs != null ) {
            out.println("<p>");
            out.println("<font color='red'>Please correct the following errors:");
            out.println("<ul>");
            Iterator items = errorMsgs.iterator();
            while ( items.hasNext() ) {
                String message = (String) items.next();
                out.println("  <li>" + message + "</li>");
            }
            out.println("</ul>");
            out.println("</font>");
            out.println("</p>");
        }
        
        // Generate main body
        out.println("<p>");
        out.println("This form allows you to create a new Employee.");
        out.println("</p>");
        out.println("<form action='add_employee.do' method='POST'>");
        
        // Repopulate the employeeId field
        String employeeId = request.getParameter("employeeId");
        if ( employeeId == null ) {
        	employeeId = "";
        }
        out.println("employeeId: <input type='text' name='employeeId' value='"
                + employeeId + "' /> <br/><br/>");
     // Repopulate the firstName field
        String firstName = request.getParameter("firstName");
        if ( firstName == null ) {
        	firstName = "";
        }
        out.println("firstName: <input type='text' name='firstName' value='"
                + firstName + "' /> <br/><br/>");
     // Repopulate the lastName field
        String lastName = request.getParameter("lastName");
        if ( lastName == null ) {
        	lastName = "";
        }
        out.println("lastName: <input type='text' name='lastName' value='"
                + lastName + "' /> <br/><br/>");
     // Repopulate the email field
        String email = request.getParameter("email");
        if ( email == null ) {
        	email = "";
        }
        out.println("email: <input type='text' name='email' value='"
                + email + "' /> <br/><br/>");
        
        // Repopulate the phoneNumber field
        String phoneNumber = request.getParameter("phoneNumber");
        if ( phoneNumber == null ) {
        	phoneNumber = "";
        }
        out.println("phoneNumber: <input type='text' name='phoneNumber' value='"
                + phoneNumber + "' /> <br/><br/>");
        
        // Repopulate the hireDate field
        String hireDate = request.getParameter("hireDate");
        if ( hireDate == null ) {
        	hireDate = "";
        }
        out.println("hireDate: <input type='text' name='hireDate' value='"
                + hireDate + "' /> <br/><br/>");
        
        // Repopulate the salary field
        String salary = request.getParameter("salary");
        if ( salary == null ) {
        	salary = "";
        }
        out.println("salary: <input type='text' name='salary' value='"
                + salary + "' /> <br/><br/>");
       
        // Repopulate the commissionPerct field
        String commissionPerct = request.getParameter("commissionPerct");
        if ( commissionPerct == null ) {
        	commissionPerct = "";
        }
        out.println("commissionPerct: <input type='text' name='commissionPerct' value='"
                + commissionPerct + "' /> <br/><br/>");
       
        
     // Repopulate the Department drop-down menu
        String department = request.getParameter("department");
        out.println("Department: <select name='department'>");
        if ( (department == null) || department.equals("UNKNOWN") ) {
            out.println("          <option value='UNKNOWN'>select...</option>");
        }
        for ( int i = 0; i < DEPARTMENT.length; i++ ) {
            out.print("          <option value='" + DEPARTMENT[i] + "'");
            if ( DEPARTMENT[i].equals(department) ) {
                out.print(" selected");
            }
            out.println(">" + DEPARTMENT[i] + "</option>");
        }
        out.println("        </select> <br/><br/>");
        
        
        
        out.println("<input type='Submit' value='Add Employee' />");
        out.println("</form>");
        
        out.println("</body>");
        out.println("</html>");
    }
}
