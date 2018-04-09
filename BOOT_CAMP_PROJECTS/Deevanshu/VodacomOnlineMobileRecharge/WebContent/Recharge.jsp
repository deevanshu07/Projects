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

<s:form action="getrecharge">
<s:textfield name="mobileNo" key="mobileno" ></s:textfield>
<s:select list="#session.planList" key="dropdownlist" listValue="planName"  listKey="planId" name="planselected" ></s:select>
Your RechargeID is <s:property value="rechargeId"/><br>
<s:submit value='Recharge'></s:submit>
</s:form>

</body>
</html>
