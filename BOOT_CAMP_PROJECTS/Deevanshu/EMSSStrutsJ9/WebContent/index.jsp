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
<s:form>
<s:textfield name="name" key="username"></s:textfield>
<s:password name="pass" key="password" ></s:password>
<s:submit align="center" value="List all Employee" action="getlistEmployee"></s:submit>
<s:submit align="center" value="List all Department" action="getlistDepartment"></s:submit>
 </s:form>
 </ul>
<ul>
<h3>Administrator</h3>
<ul>
  <li><s:a action="populateRegister">Add a new Employee</s:a></li>
</ul>

</body>
</html>