<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="add1">
<s:textfield name="itemId" label="Enter ID"/>
<s:textfield name="itemName" label="Enter Name"/>
<s:submit value="Enter"/>
</s:form>


<s:form action="add2">
<s:textfield name="itemView" label="View Items"/>

<s:submit value="OK"/>
</s:form>

</body>
</html>