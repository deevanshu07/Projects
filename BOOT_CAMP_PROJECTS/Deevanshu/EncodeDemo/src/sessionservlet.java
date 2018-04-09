import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class sessionservlet extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("test session attribute<br>");
HttpSession session=req.getSession();
String qs=(req.getQueryString());
String []a=qs.split("");
String []b=a[1].split("=");
if(b[1].equals(session.getId()))
{
	
}
else
{
res.sendRedirect("login.html");	
}
String s=(String)session.getAttribute("new");
out.println(s);
}
}
