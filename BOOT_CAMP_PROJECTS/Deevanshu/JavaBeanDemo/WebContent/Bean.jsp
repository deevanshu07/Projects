<%@page import="com.sun.org.apache.xerces.internal.xs.ItemPSVI"%>
<%@page import="org.hibernate.engine.ExecuteUpdateResultCheckStyle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.*, javax.naming.* , javax.servlet.* , java.io.*,javax.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="mybean" class="Bean.Item" scope="session"/>
<br>

<jsp:getProperty name="mybean" property="itemName"/>
<br/>
<jsp:getProperty name="mybean" property="itemPrice"/>
<br/>
<jsp:getProperty name="mybean" property="itemDesc"/>
<br/>
<jsp:getProperty name="mybean" property="itemValue"/>
<br/>


<%

String name=mybean.getItemName();
double price = mybean.getItemPrice();
String description= mybean.getItemDesc();
String value= mybean.getItemValue();
PrintWriter pw=response.getWriter();
Context ic = new InitialContext();
DataSource ds = (DataSource) ic.lookup("java:OracleDS");

	String sql = "insert into item1 values(?,?,?,?)";
	Connection con = ds.getConnection();
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.setString(1, name);
	stmt.setDouble(2,price);
	stmt.setString(3,description);
	stmt.setString(4,value);
	
	int update = stmt.executeUpdate();
	if(update>0)
	{
		pw.print("Rows Added Successfully");
	}
%>
</body>
</html>