<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="add">
<s:textfield name="iId" label="Enter item Id"/>
<s:select list="#session.category" listValue="itemName" 
label="SELECT ITEM" listKey="itemName" name="itemselected">

<s:textfield name="iprepTime" label="Enter Preparation Time"/>

<s:textfield name="iPrice"  label="Enter Price"/>
<s:submit value="ADDITEM" />
</s:select>
</s:form>
</body>
</html>