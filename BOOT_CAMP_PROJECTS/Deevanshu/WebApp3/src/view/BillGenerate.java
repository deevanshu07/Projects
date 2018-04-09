package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemClass;
import model.OrderClass;


public class BillGenerate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BillGenerate() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		OrderClass ord =(OrderClass)request.getAttribute("ord");
		
		ArrayList<ItemClass> orderCart=	ord.getAl();
		//pw.print(orderCart.get(i).)
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
