<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Infogain Employee Management System: Home</title>
</head>
<body>

<!-- Page Heading -->
<table border='1' cellpadding='5' cellspacing='0' width='400'>
<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
  <td><h3>Infogain Employee Management System: Home</h3></td>
</tr>
</table>
<p>
This is the Home page for Infogain Employee Management System.
</p>

<h3>Employee</h3>
<ul>
<s:actionerror/>
<s:form action="/ListEmployees">
<s:textfield name="name" label="User Name"></s:textfield>
<s:password name="pass" label="Password" ></s:password>
<s:submit align="center" value="List all Employee"></s:submit>
 </s:form>
 </ul>
<ul>
<s:form action="/ListDepartment">
<s:textfield name="name" label="User Name"></s:textfield>
<s:password name="pass" label="Password" ></s:password>
<s:submit align="center" value="List all Department"></s:submit>
 </s:form>
</ul>
<h3>Administrator</h3>
<ul>
  <li><a href='addemployee'>Add a new Employee</a></li>
</ul>

</body>
</html>