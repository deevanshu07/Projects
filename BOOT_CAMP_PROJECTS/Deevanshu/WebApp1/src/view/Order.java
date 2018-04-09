package view;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MenuService;

import model.*;
import Deevanhu.*;
/**
 * Servlet implementation class ServletView2
 */
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int orderId=1;
	String url="";
	ArrayList<itemClass> orderCart=new ArrayList<itemClass>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config)
    {
    	
    	url=config.getInitParameter("url");
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
		 List errorMsgs = new LinkedList();
		 request.setAttribute("errorMsgs", errorMsgs);
		PrintWriter pw=response.getWriter();
		
		String userName=request.getParameter("Name");
		
		String quantity=request.getParameter("Quantity");
		String contactNumber=request.getParameter("ContactNumber");
		String[] itemList=request.getParameterValues("itemList");
		try{
		if ( itemList.equals("UNKNOWN") ) {
            errorMsgs.add("Please select an item.");
           
            
        }
        if ( contactNumber.length()==0 ) {
            errorMsgs.add("Please enter your contactNumber.");
        }
        if ( userName.length()==0) {
            errorMsgs.add("Please enter your name.");
        }
            int quantity1=-1 ;       
        try {
        	quantity1=Integer.parseInt(quantity);
        } catch (NumberFormatException nfe) {
            errorMsgs.add("The 'quantity' field must be a positive integer.");
        }
        if ( !errorMsgs.isEmpty() ) 
        {
            RequestDispatcher view = request.getRequestDispatcher("Order");
            view.forward(request, response);
        //	response.sendRedirect("Order");
            return;
        }
        
        
        
        MenuService ms=new MenuService();
        ArrayList<itemClass> itemList1= ms.menuService(url);
       // pw.println(itemList1);
        for (int j = 0; j < itemList.length; j++) 
        {
		for (int i = 0; i < itemList1.size(); i++) 
		{
			
				
			
          if(itemList[j].equals(itemList1.get(i).getItemName()))
          {
        	  orderCart.add(new itemClass(itemList1.get(i).getItemId(),itemList1.get(i).getItemName(),itemList1.get(i).getPrice(),itemList1.get(i).getPrice()));
              
          }
			}
			
			
		}
        //pw.print(orderCart);
		OrderClass ord=new OrderClass( orderId, new Date(),orderCart); 
		
		pw.println(ord);
	
		//Customer cust=new Customer(userName,contactNumber,quantity,itemList);
		
		
	
		RequestDispatcher disp=request.getRequestDispatcher("ShowOrder");
		request.setAttribute("ord", ord);
		//ServletContext context=getServletContext();
		//context.setAttribute("cust", cust);
		disp.forward(request, response);
		return;
		
		}
		// Handle any unusual exceptions
         catch (Exception e) {
            errorMsgs.add(e.getMessage());
            RequestDispatcher disp
                    = request.getRequestDispatcher("Order");
            disp.forward(request, response);
            
            // Log stack trace
            e.printStackTrace(System.err);
            
        } // END of try-catch block
        
    } // END of doPost method
    
} // END of AddLeagueServlet class

