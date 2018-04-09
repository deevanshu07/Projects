<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="/struts-tags" prefix="s" %>
      <%@ page import="java.util.*" %>
    <%@ page import="com.info.controller.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:select list="#session.oc" listValue="itemName + quantity"></s:select>
<%-- <%= System.out.println("ordercart deleted") %>
<% List list =SaveOrder.ordercart;%>
<% Iterator ite = SaveOrder.ordercart.iterator();
	while(ite.hasNext())
	{
		list.remove(ite);

	}
%> --%>
</body>
</html>