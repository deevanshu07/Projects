package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import listen.CtxListen;


public class Serv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Serv1() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//PrintWriter pw = response
		HttpSession session=request.getSession();
		session.setAttribute("name 4", "Sunil Arora");
		
		getServletContext().setAttribute("name2", "Amit Arora");
		request.setAttribute("name3", "Nitin Arora");
		CtxListen obj=new CtxListen();
		session.setAttribute("obj", obj);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
