<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add An Item</title>
</head>
<body>
<% 
String [] Category = getInitParameter("category").split(",");
%>
<form action='post.jsp' method='post'>
Item Name:<input type=text name="itemName"/>
Item Price:<input type=text name="itemPrice"/>
Item Description:<input type=text name="itemDesc"/>

Select Category:
<select name="itemValue">

<%for(int i=0;i<Category.length;i++){%>
<option><%=Category[i] %>
<%} %>
</option>

</select>

<input type='submit' value='add'/>
</body>
</html>