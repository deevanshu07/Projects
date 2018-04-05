<%@page import="com.info.model.Employee"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<%List<Employee> employee=(List)request.getAttribute("employees"); 
for(Employee emp:employee){
	%>
	<h3><%=emp %></h3>
<%}
%>
</body>
</html>
