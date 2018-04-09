<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form >
<s:textfield name="username" label="Enter name"/>
<s:textfield name="contactnumber" label="Enter contact number"/>
<s:textfield name="quantity" label="Quantity" listKey="quantity" name="quantity"/>

<s:select list="#session.category" listValue="itemName" 
label="SELECT ITEM" listKey="itemName" name="itemselected">
</s:select>
<s:submit value="Add Items" action="addmore"/>
<s:submit value="Submit Order" action="submitorder"/>
<s:submit value="Delete an Order" action="deleteorder"/>
</s:form>
</body>
</html>

