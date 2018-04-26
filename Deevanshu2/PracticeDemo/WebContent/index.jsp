<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%List errorMsg=(List) request.getAttribute("errorMsg");
int i=0;
if(errorMsg!=null)
{
	%>
	<p>
	<%=errorMsg.get(i) %></p>
	<%i++; %>

<%}
%>
<center>
<form action="FirstServlet">

Enter Product ID<input type="text" name="pId"/><br>
Enter Name<input type="text" name="pName"/><br>
<input type="submit" value="OK"/>
</form>
</center>
</body>
</html>