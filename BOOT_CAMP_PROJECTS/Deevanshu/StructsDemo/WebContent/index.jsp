<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:actionerror/>
<s:form action="showmenu">
<s:textfield name="name" key="username"></s:textfield>
<s:password name="pass" key="password" ></s:password>

<s:submit align="center" value="ok"></s:submit>
 </s:form>
</body>
</html>