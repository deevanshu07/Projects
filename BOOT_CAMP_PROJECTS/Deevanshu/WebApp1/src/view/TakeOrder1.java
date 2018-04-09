package view;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import Deevanhu.*;

/**
 * Servlet implementation class Order
 */
public class TakeOrder1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public TakeOrder1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		PrintWriter pw=response.getWriter();
		MenuService service=new MenuService();
		String string =getInitParameter("Query");
		ArrayList<itemClass> list=service.menuService(string);
		 List errorMsgs = (List) request.getAttribute("errorMsgs");

		pw.println("<html>");
		pw.println("<body>");
		pw.println("<form action='Order' method='post'>");
		pw.println("Name: <input type='text' name='Name'/>");
		pw.println("ContactNumber: <input type='text' name='ContactNumber'/>");
		pw.println("Quantity: <input type='text' name='Quantity'/>");
		pw.println("ItemName:<select name='itemList'>");
		for(int i=0;i<list.size();i++)
		{
			pw.println("<option>");
			pw.println(list.get(i).getItemName());
			pw.println("</option>");
		}
		pw.println("ItemName:</select>");
		pw.println("<input type='submit' value='ADD'/>");
		pw.println("</form>");
		pw.println("</body>");
		
		if ( errorMsgs != null ) {
            pw.println("<p>");
            pw.println("<font color='red'>Please correct the following errors:");
            pw.println("<ul>");
            Iterator items = errorMsgs.iterator();
            while ( items.hasNext() ) {
                String message = (String) items.next();
                pw.println("  <li>" + message + "</li>");
            }
            pw.println("</ul>");
            pw.println("</font>");
            pw.println("</p>");
        }
		pw.println("</html>");
	}
		
	}

