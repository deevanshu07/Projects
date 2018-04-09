package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MenuService;

/**
 * Servlet implementation class ServletView4
 */
public class RegularCustOffers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   String url="";
    public RegularCustOffers() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config)
    {
    	
    	url=config.getInitParameter("deevanshu");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			PrintWriter pw=response.getWriter();
			MenuService service=new MenuService();
			
			ArrayList itemList=service.menuService(url);
			
			pw.println(itemList);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
