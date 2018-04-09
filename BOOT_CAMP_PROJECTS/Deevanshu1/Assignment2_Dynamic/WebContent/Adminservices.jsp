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
<%
String userId=request.getParameter("userId");
String password=request.getParameter("password");
PrintWriter pw= response.getWriter();
pw.println(userId+"\t"+password);
%>
<% if(session.getAttribute("userId")!=null)
{%>
<div align="center">
<p><a href="Addproduct.jsp"><font size=4px>Add Product</font></a></p>
<p><a href="Deleteproduct.jsp"><font size=4px>Delete Product</font></a></p>
<p><a href="Listproducts"><font size=4px>List All Products</font></a></p>
<a href="SignOut.jsp"><font size=4px>SignOut</font></a>
</div>
<% }
else
	response.sendRedirect("Login.jsp");
	%>
</body>
</html>