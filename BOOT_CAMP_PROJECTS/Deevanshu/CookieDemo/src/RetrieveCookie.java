import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RetrieveCookie extends HttpServlet
{
PrintWriter pw=null;
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
doPost(req,res);
}

public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException
{
pw=res.getWriter();
String username=null;
Cookie ck[]=request.getCookies();

if(ck!=null)
{
	
	for(int i=0;i<ck.length;i++)
	{
		pw.println("Cookie Value"+ ck[i].getValue());
		if(ck[i].getName().equals("user"))
		username=ck[i].getValue();
	}
	pw.println("Hello ! &nbsp;&nbsp;" +username);
}
else
{
	pw.println("No cookies found");
}

}}

