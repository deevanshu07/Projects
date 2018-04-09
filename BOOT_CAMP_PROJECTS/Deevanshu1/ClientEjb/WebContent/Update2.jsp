<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,java.io.IOException,java.io.PrintWriter,javax.naming.Context,
    javax.naming.*,javax.servlet.*,javax.servlet.http.*,com.info.ejb.Item,
    com.soft.ejb.FindItemSessionBeanRemote"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Item> searchList;
InitialContext ic;
PrintWriter pw=response.getWriter();
int Uname=Integer.parseInt(request.getParameter("itemId"));
pw.println("Item Id ="+Uname);
try 
{
	searchList= new ArrayList<Item>();
	ic = new InitialContext();
	FindItemSessionBeanRemote remote=(FindItemSessionBeanRemote)ic.lookup
			("FindItemSessionBean/remote");
	
	searchList=remote.findItem(Uname);
	pw.println("Item Details are:");
	for (Item ite : searchList) 
	{
		pw.print(ite.getItemName()+"\t");
		pw.print(ite.getPrepTime());
		
	}
	
} catch (Exception e) 
{
	
	e.printStackTrace();
}
%>

<form action="Update">
Enter Item Id<input type="text" name="itemId"/>
Enter Item Name<input type="text" name="itemName"/>
Enter Item Preparation Time<input type="text" name="itemPerpTime"/>
<input type="submit" value="Update"/>
</form>
</body>
</html>