<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Login Page</h1>
	<h3>${message}</h3>
	<form:errors path="employee1.*"></form:errors>
	<form action="/controller/login" method="post">
		<table>
			<tr>
				<td>User id</td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>
