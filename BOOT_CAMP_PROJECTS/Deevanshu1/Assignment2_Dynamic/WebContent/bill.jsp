<%@page import="com.soft.login.Product"%>
<%@page import="com.soft.product.ProductSessionBeanRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<div align="center">
<% PrintWriter pw=response.getWriter(); %>
<% String selectedProduct=request.getParameter("selectedProduct");
int quantity=Integer.parseInt(request.getParameter("quantity"));
%>

<%  List <Integer>bill = new ArrayList();%>
<% List <Product> productList; %>
<% int totalBill=0;%>
<% List <Product>orderCart= new ArrayList();%>

<%
InitialContext ic;
ic= new InitialContext();
ProductSessionBeanRemote remote=(ProductSessionBeanRemote)ic.lookup("ProductSessionBean/remote");
productList=remote.allProducts();


List p1= (List)session.getAttribute("bill");
List order=(List)session.getAttribute("orderCart");
if(p1!=null || order!=null)
{
	bill.addAll(p1);
	orderCart.addAll(order);
	

for (Product ite : productList) 
{
	String str=ite.getProductId()+"-"+ite.getProductDesc();
	
	if(selectedProduct.equals(str))
	{
		orderCart.add(new Product(ite.getProductId(),ite.getProductDesc(),
				ite.getQty_on_hand(),ite.getUnit_price()));
			totalBill=totalBill+(ite.getUnit_price()*quantity);
		bill.add(totalBill);
	}
}
}
else
{
	for (Product ite : productList) 
	{
		String str=ite.getProductId()+"-"+ite.getProductDesc();
		
		if(selectedProduct.equals(str))
		{
			orderCart.add(new Product(ite.getProductId(),
					ite.getProductDesc(),ite.getQty_on_hand(),ite.getUnit_price()));
			totalBill=totalBill+(ite.getUnit_price()*quantity);
			bill.add(totalBill);
				
		}
	}

}
	

pw.println(bill); 
pw.println(totalBill);%>
<%session.setAttribute("bill", bill);
session.setAttribute("orderCart", orderCart);
int sum=0;
List <Integer> TotalBill= new ArrayList();
for(Product ite:orderCart)
{
	pw.print(ite.getProductId()+"\t"+ite.getProductDesc()+"\t"+quantity);
}
for(int i=0;i<bill.size();i++)
{
	sum=sum+bill.get(i);
	
}
%>
<h><font size=5px>Your Total Bill<%= sum%></font></h>
<%TotalBill.add(sum);
session.setAttribute("TotalBill", TotalBill);



%> 


<form action="Purchase_product.jsp">
<br/>
Click To Add More<input type="submit" value="Add More"/>
</form>
<form action="ClientServices.jsp">
<input type="submit" value="ClientServices"/>
</form>
</div>
</body>
</html>