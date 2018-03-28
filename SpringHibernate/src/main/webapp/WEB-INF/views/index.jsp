<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h3>Index Page</h3>
	<div style="float: right;">
		<h3><a href="/controller/logout">Logut</a></h3>
</div>
<div>
	<form action="/controller/all/" method="get">
	<input type="submit" value="Get Json Data"/>
	</form>
	</div>
</body>
</html>
