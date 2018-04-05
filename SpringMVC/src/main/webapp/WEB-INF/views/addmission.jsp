<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>${headermessage}</h1>
	<form:errors path="employee1.*" />
	<form action="/model/submitForm.html" method="post">
		<table>
			<tr>
				<td>Employee name</td>
				<td><input type="text" name="employeeName"></td>
			</tr>
			<tr></tr>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="employeeId"></td>
			</tr>
			<tr></tr>

			<tr>
				<td>Employee mobile number</td>
				<td><input type="text" name="employeeMobile"></td>
			</tr>
			<tr></tr>
			<tr>
				<td>Employee D.O.B</td>
				<td><input type="text" name="employeeDOB"></td>
			</tr>
			<tr></tr>
			<tr>
				<td>Employee Skills</td>
				<td><select name="employeeSkills" multiple="multiple">
						<option value="Java">Java</option>
						<option value="Spring">Spring</option>
						<option value="Hibernate">Hibernate</option>
						<option value="Python">Python</option>
				</select></td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>