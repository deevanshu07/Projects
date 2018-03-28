<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagination</title>

<spring:url value="/all/" var="pageurl" />
<style type="text/css">
html,body {
	height: 100%;
}

html {
	display: table;
	margin: auto;
	position: relative;
	min-width: 500px;
	min-height: 768px;
	height: 100%;
}

body {
	display: table-cell;
	font: 13px/20px 'Lucida Grande', Tahoma, Verdana, sans-serif;
	color: #404040;
	background: #ffffff;
	text-align: center;
}

div {
	margin-left: 10 px;
	text-align: left;
}

table {
	text-align: center;
	font-family: Arial, Helvetica, sans-serif;
	color: #000;
	font-size: 14px;
	text-shadow: 1px 1px 0px #fff;
	background: #ededed;
	margin: 20px;
	border: #ccc 1px solid;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	-moz-box-shadow: 0 1px 2px #d1d1d1;
	-webkit-box-shadow: 0 1px 2px #d1d1d1;
	box-shadow: 0 1px 2px #d1d1d1;
}

table th {
	padding: 21px 25px 22px 25px;
	border-top: 1px solid #fafafa;
	border-bottom: 1px solid #e0e0e0;
	background: #ededed;
	background: -webkit-gradient(linear, left top, left bottom, from(#ededed),
		to(#ebebeb));
	background: -moz-linear-gradient(top, #ededed, #ebebeb);
}

table a:link {
	color: #666;
	font-weight: bold;
	text-decoration: none;
}

table a:visited {
	color: #999999;
	font-weight: bold;
	text-decoration: none;
}

table a:active,table a:hover {
	color: #bd5a35;
	text-decoration: underline;
}

table tr:first-child th:first-child {
	-moz-border-radius-topleft: 3px;
	-webkit-border-top-left-radius: 3px;
	border-top-left-radius: 3px;
}

table tr:first-child th:last-child {
	-moz-border-radius-topright: 3px;
	-webkit-border-top-right-radius: 3px;
	border-top-right-radius: 3px;
}

table tr {
	text-align: left;
	padding-left: 20px;
}

table td:first-child {
	text-align: left;
	padding-left: 20px;
	border-left: 0;
}

table td {
	padding: 18px;
	border-top: 1px solid #ffffff;
	border-bottom: 1px solid #e0e0e0;
	border-left: 1px solid #e0e0e0;
	background: #ffffff;
	background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb),
		to(#fafafa));
	background: -moz-linear-gradient(top, #fbfbfb, #fafafa);
}

table tr.even td {
	background: #ffffff;
	background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8),
		to(#f6f6f6));
	background: -moz-linear-gradient(top, #f8f8f8, #f6f6f6);
}

table tr:last-child td {
	border-bottom: 0;
}

table tr:last-child td:first-child {
	-moz-border-radius-bottomleft: 3px;
	-webkit-border-bottom-left-radius: 3px;
	border-bottom-left-radius: 3px;
}

table tr:last-child td:last-child {
	-moz-border-radius-bottomright: 3px;
	-webkit-border-bottom-right-radius: 3px;
	border-bottom-right-radius: 3px;
}

table tr:hover td {
	background: #f2f2f2;
	background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2),
		to(#f0f0f0));
	background: -moz-linear-gradient(top, #f2f2f2, #f0f0f0);
}
</style>
</head>
<body>
	<h2>PAGINATION</h2>
	<div style="float: right;">
		<h3>
			<a href="/controller/logout">Logut</a>
		</h3>
	</div>
	<div>
		<c:set var="pageListHolder" value="${pagedList}" scope="session" />
		<table cellspacing="0">
			<thead>
				<tr>
					<th>Name</th>
					<th>Top Level Domain</th>
					<th>Alpha 2 Code</th>
					<th>Alpha 3 Code</th>
					<th>Calling Codes</th>
					<th>Capital</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ph" items="${pageListHolder.pageList}">
					<tr>
						<td>${ph.name}</td>
						<td>${ph.topLevelDomain}</td>
						<td>${ph.alpha2Code}</td>
						<td>${ph.alpha3Code}</td>
						<td>${ph.callingCodes}</td>
						<td>${ph.capital}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<span style="float: left;"> <c:choose>
				<c:when test="${pageListHolder.firstPage}">Prev</c:when>
				<c:otherwise>
					<a href="${pageurl}/prev">Prev</a>
				</c:otherwise>
			</c:choose>
		</span> <span> <c:forEach begin="0"
				end="${pageListHolder.pageCount-1}" varStatus="loop">
    &nbsp;&nbsp;
    <c:choose>
					<c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
					<c:otherwise>
						<a href="${pageurl}/${loop.index}">${loop.index+1}</a>
					</c:otherwise>
				</c:choose>
    &nbsp;&nbsp;
    </c:forEach>
		</span> <span> <c:choose>
				<c:when test="${pageListHolder.lastPage}">Next</c:when>
				<c:otherwise>
					<a href="${pageurl}/next">Next</a>
				</c:otherwise>
			</c:choose>
		</span>
	</div>
</body>
</html>