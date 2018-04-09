package serv;

import java.io.IOException;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmp
 */
public class AddEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.getWriter().print(request.getQueryString());
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empName=request.getParameter("empName");
		int empAge=Integer.parseInt(request.getParameter("empAge"));
		double empSalary=Double.parseDouble(request.getParameter("empSalary"));
		String depName=request.getParameter("depList");
		Employee emp=new Employee(empName,empAge,empSalary,depName);
		RequestDispatcher disp=request.getRequestDispatcher("ShowEmp");
		request.setAttribute("emp", emp);
		
		disp.forward(request, response);
			
		
	}

}
