<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
        <head>
          <title>" + pageTitle + "</title>
        </head>
        <body bgcolor='white'>
                
        <!-- Page Heading -->
        <table border='1' cellpadding='5' cellspacing='0' width='400'>
        <tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
          <td><H1>Welcome <s:property value="#session.user"/></H1><h3>Infogain: List of Employees</h3></td>
        </tr>
        <tr><s:a href="logoutaction">Logout</s:a></tr>
        </table>
        <p>
        The set of Employees are:
        </p>
        <s:iterator value="#application.lsEmployee" var="emp">
        <li><s:property value="#emp.firstName"/></li>
        </s:iterator>
        End of list...
        </body>

</body>
</html>