package service;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Order extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       String url="";
   
    public Order() 
    {
        super();
        
    }
    
    public void init(ServletConfig config)
    {
    	
    	url=config.getInitParameter("url");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		MenuService service=new MenuService();
		 // Retrieve the errorMsgs from the request-scope
        List errorMsgs = (List) request.getAttribute("errorMsgs");
		ArrayList<ItemClass> list=service.menuService(url);
		
		
	//	MenuService item=new MenuService();
		pw.println("<html>");
		pw.println("<body bgcolor='pink'>");
		pw.println("<form action='ServletView2' method='post'>");
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
        
		
		pw.println("<input type='submit' value='ADD'/>");
		
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
