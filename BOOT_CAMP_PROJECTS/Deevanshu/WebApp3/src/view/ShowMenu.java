package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.sql.*;

import javax.naming.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import service.*;
import model.*;
/**
 * Servlet implementation class ServletView1
 */
public class ShowMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String url="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMenu() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config)
    {
    	
    	url=config.getInitParameter("url");
    }
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		PrintWriter pw=response.getWriter();
		MenuService service=new MenuService();
		ArrayList<ItemClass> list=service.menuService(url);
		//Iterator itr=list.iterator();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<ul>");
	//	pw.println("<li>");
		pw.println("<table border=1 style=width:400 >");
		
		//while(itr.hasNext())
		for (int i = 0; i < list.size(); i++) {
			
			pw.println("<tr>");
			pw.println("<td>");
			pw.println(list.get(i).getItemId());
			pw.println("</td>");
			pw.println("<td>");
			pw.println(list.get(i).getItemName());
			pw.println("</td>");
			pw.println("<td>");
			pw.println(list.get(i).getPrice());
			pw.println("</td>");
			pw.println("<td>");
			pw.println(list.get(i).getItemDesc());
			pw.println("</td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
	//	pw.println("</li>");
		pw.println("</ul>");
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
