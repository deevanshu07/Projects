<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>
<title><tiles:getAsString name="title" /></title>
</head>

<body>
    <table border="1" cellpadding="2" cellspacing="2" align="center" bgcolor="yellow">
        <tr>
            <td height="20%" colspan="2">
            	<tiles:insertAttribute name="header"/>
            </td>
        </tr>
        <tr>
          
            <td>
            	<tiles:insertAttribute name="body"/>
            </td>
        </tr>
        <tr>
            <td height="20%" colspan="2">
            	<tiles:insertAttribute name="footer"/>
            </td>
        </tr>
    </table>
</body>
</html>