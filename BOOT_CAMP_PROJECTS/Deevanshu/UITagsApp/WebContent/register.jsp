<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>

<s:form action="Register">
	<s:textfield name="userName" label="User Name" />
	<s:password name="password" label="Password" />
	<s:radio name="gender" label="Gender" list="{'Male','Female'}" />
	<s:select name="country" list="countryList" label="Select a country" />
	<s:textarea name="about" label="About You" />
	<s:checkboxlist list="technologyList" name="technology" label="Technology" />
	<s:checkbox name="newsLetter"
		label="Would you like to subscribe our news letter?" />
	<s:submit />
</s:form>
</body>
</html>