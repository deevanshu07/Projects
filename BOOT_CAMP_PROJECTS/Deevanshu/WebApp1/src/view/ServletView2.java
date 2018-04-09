package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletView2
 */
public class ServletView2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletView2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		try {
			String string =getInitParameter("Query");
			

			
				Context ic = new InitialContext();
				DataSource ds = (DataSource) ic.lookup(string);
				
					String sql = "select * from item";
					Connection con = ds.getConnection();

					Statement st = con.createStatement();
					ResultSet result = st.executeQuery(string);
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<form action='takeorder' method='post'>");
				pw.println("Enter Your Name: <input type='text' name='name'/>");
				pw.println("Enter Contact Number: <input type='text' name='number'/>");
				pw.println("Quantity: <input type='text' name='quantity'/>");
				pw.println("Itemt:<select name='itemlist'>");
				while(result.next())
				{
					pw.println("<option>");
					pw.println(result.getString(2));
					pw.println("</option>");
				}
				pw.println("Item:</select>");
				pw.println("<input type='submit' value='Submit order'/>");
				pw.println("</form>");
				pw.println("</body>");
				pw.println("</html>");
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

}
}