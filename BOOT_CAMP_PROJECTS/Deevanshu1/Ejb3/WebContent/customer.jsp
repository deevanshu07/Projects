<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
<div align="center">
<form action="PlaceOrderqueue">

<font size=5px>Enter Quantity</font> 
<input type="text" name="no_Of_Products"/><br/>
<font size=5px>Select an Item</font>
<select name="selectedItem">
<option>Pizza</option>
<option>Burger</option>
<option>Maggi</option>
<option>Coffee</option>
<option>Cake</option>
<option>Chicken</option>
</select>
<input type="submit" value="submit"/>
</form>
</div>
</body>
</html>