<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index page</title>
</head>
<body>
	<jsp:element name="xmlElement">
<jsp:attribute name="xmlAttribute">
value of attribute
</jsp:attribute>

<jsp:body>
Body of XML element
</jsp:body>

</jsp:element>
	<form action="process.jsp">
		<table>
			<tr>
				<td>Number1</td>
				<td><input type="text" name="number1">
				<td>
			</tr>
			<tr>
				<td>Number2</td>
				<td><input type="text" name="number2">
				<td>
			</tr>
			<tr>
				<td><input type="submit">
				<td>
			</tr>
		</table>
	</form>
</body>
</html>