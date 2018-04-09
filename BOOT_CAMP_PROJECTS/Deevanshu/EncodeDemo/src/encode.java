import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class encode extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
HttpSession ses=req.getSession();
if(ses.isNew())
{
out.println("New Session");
ses.setAttribute("new","New Session");
}
else{
out.println("Existing Session");
}
//out.println("<a href"+=res.encodeURL("/session")+">click me</a>");
out.println("<a href=\" "+res.encodeURL("/EncodeDemo/session;jsession="+ses.getId())+"\">click me</a>");
}
}