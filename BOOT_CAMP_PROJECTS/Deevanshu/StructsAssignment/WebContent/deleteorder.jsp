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
<s:select list="#session.oc" listValue="itemName" 
label="Delete an Item from order" listKey="itemName" name="itemselected"/>
<s:submit value="Delete Order" action="deleteitem"/>
</s:form>
</body>
</html>