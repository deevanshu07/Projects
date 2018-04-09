package com.infogain.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
// Support classes
import java.io.IOException;
import java.io.PrintWriter;
// Model classes
import java.util.*;
import com.infogain.model.*;


public class AddEmployeeServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        // Keep a set of strings to record form processing errors.
        List errorMsgs = new LinkedList();
        // Store this set in the request scope, in case we need to
        // send the ErrorPage view.
        request.setAttribute("errorMsgs", errorMsgs);
        
        try {
            
            // Retrieve form parameters.
            String employeeId = request.getParameter("employeeId").trim();
            String firstName = request.getParameter("firstName").trim();
            String lastName = request.getParameter("lastName").trim();
            String email = request.getParameter("email").trim();
            String phoneNumber = request.getParameter("phoneNumber").trim();
            Date hireDate = new Date(request.getParameter("hireDate").trim());
            double salary = Double.parseDouble(request.getParameter("salary").trim());
            float commissionPerct = Float.parseFloat(request.getParameter("commissionPerct").trim());
            String department = request.getParameter("department").trim();
            
          
            int employeeId1 = -1;
            try {
            	employeeId1 = Integer.parseInt(employeeId);
            } catch (NumberFormatException nfe) {
                errorMsgs.add("The 'employeeId1' field must be a positive integer.");
            }
            
            // Verify form parameters
            if ( department.equals("UNKNOWN") ) {
                errorMsgs.add("Please select a department.");
            }
            if ( email.length() == 0 ) {
                errorMsgs.add("Please enter the email of the Employee.");
            }
            
            // Send the use back to the form, if there were errors
            if ( ! errorMsgs.isEmpty() ) {
                RequestDispatcher view
                        = request.getRequestDispatcher("add_employee.view");
                view.forward(request, response);
                return;
            }
            
            // Perform business logic
            EmployeeService employeeSvc = new EmployeeService();
            Employee employee = employeeSvc.createEmployee(employeeId1, firstName, lastName,email,phoneNumber,hireDate,salary,commissionPerct,department);
            // Store the new league in the request-scope
            System.out.println("Employee is:"+employee);
            request.setAttribute("employee", employee);
            
            // Send the Success view
            RequestDispatcher view
                    = request.getRequestDispatcher("success.view");
            view.forward(request, response);
            return;
            
            // Handle any unusual exceptions
        } catch (Exception e) {
            errorMsgs.add(e.getMessage());
            RequestDispatcher view
                    = request.getRequestDispatcher("add_employee.view");
            view.forward(request, response);
            
            // Log stack trace
            e.printStackTrace(System.err);
            
        } // END of try-catch block
        
    } // END of doPost method
    
} // END of AddLeagueServlet class
