package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstView
 */
public class FirstView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String[] depList=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstView() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init()
    {
    	
    	depList=getInitParameter("deptList").split(",");
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<form action='addEmp' method='post'>");
		pw.println("Emp Name: <input type='text' name='empName'/>");
		pw.println("Emp Age: <input type='text' name='empAge'/>");
		pw.println("Emp Salary: <input type='text' name='empSalary'/>");
		pw.println("Department:<select name='depList'>");
		for(int i=0;i<depList.length;i++)
		{
			pw.println("<option>");
			pw.println(depList[i]);
			pw.println("</option>");
		}
		pw.println("Department:</select>");
		pw.println("<input type='submit' value='ADD'/>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
