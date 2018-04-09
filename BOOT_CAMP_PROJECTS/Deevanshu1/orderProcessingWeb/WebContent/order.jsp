<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Enter Order Details
<form action="./OrderServlet">
Order Type  <input type="text" name="orderType"/><br/>
Order Date  <input type="text" name="orderDate"/><br/>
Order Amount<input type="text" name="orderAmount"/><br/>
<input type="submit" value="PlaceOrder"/>
</form>
</body>
</html>