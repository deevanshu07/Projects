package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
/**
 * Servlet implementation class ShowOrder
 */
public class ShowOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static int tokenId=1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		//pw.println("Hi order is successfully added details are as follows");
	OrderClass ord =(OrderClass)request.getAttribute("ord");
		
	pw.println("<html>");
	pw.println("<body>");
	pw.println("<li>");
	pw.println(ord);
	pw.println("</li>");
	pw.println("<a href='Order'>Click to order again</a>");
	pw.println("<a href='BillGenerate'>Click to generate bill</a>");
	pw.println("</body>");
	pw.println("</html>");
	Map<Integer,Object> queue=new HashMap<Integer,Object>();
	queue.put(tokenId,ord);
	pw.println("your order is successfully placed");
	
	
	
	RequestDispatcher disp
    = request.getRequestDispatcher("BillGenerate");
	request.setAttribute("ord", ord);
disp.include(request, response);


	
	
	
	
	}

}
