<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<s:form action="updateMobile">
<s:textfield name="accountNumber" key="account"></s:textfield>
<s:textfield name="mobileNumber" key="mobile" ></s:textfield>
<s:submit align="center" value="Update"></s:submit>
</s:form>

</body>
</html>