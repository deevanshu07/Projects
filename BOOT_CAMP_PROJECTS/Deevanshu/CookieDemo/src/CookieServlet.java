import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet
{
PrintWriter pw=null;
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
doPost(request,response);
}

public void doPost(HttpServletRequest req, HttpServletResponse  response) throws ServletException, IOException
{
pw=res.getWriter();
String username=req.getParameter("user");
String password=req.getParameter("password");


Cookie ck=new Cookie("user",username);
response.addCookie(ck);
pw.println("Cookie containing user name is stored in your browser.");
}
}