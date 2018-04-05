<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="rest/add" method="post">
		<table>
			<tr>
				<td>Number 1</td>
				<td><input type="text" name="number1"></td>
			</tr>
			<tr>
				<td>Number 2</td>
				<td><input type="text" name="number2"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	<a href="MyServlet">Click here</a>
</body>
</html>