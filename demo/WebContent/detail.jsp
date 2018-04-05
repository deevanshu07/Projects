<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="javax.ws.rs.core.Response"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>
<%@page import="javax.ws.rs.client.Client"%>
<%@page import="javax.xml.parsers.DocumentBuilder"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="org.xml.sax.InputSource"%>
<%@page import="java.io.*"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="org.w3c.dom.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
<%
//out.println("ID : "+request.getParameter("id"));
String id = request.getParameter("id");
Client client=ClientBuilder.newClient();
WebTarget webTarget = client.target("http://localhost:8983/solr/talend/select")
.queryParam("q", "id:"+request.getParameter("id"))
.queryParam("wt","json").queryParam("indent","on");
System.out.println(webTarget);
Response response2=webTarget.request().get();
String serverResponse=response2.readEntity(String.class);
//System.out.println("Response from Response"+serverResponse);
//out.println(serverResponse);

	if(id.equals("6468"))
	{
		response.sendRedirect("https://help.talend.com/reader/sSAk2HQITuEIWJdkl3e1Rw/c309CnJ9Q0H8dfYZnQAvAQ");
	}
	else if(id.equals("6469"))
	{
		response.sendRedirect("https://jira.talendforge.org/browse/TUP-5453");
	}
%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
	<link rel="stylesheet" href="Newstyle.css" /> 
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<div class="container-fluid" style=";height:auto">
		<div class="row">
			<!-- For Header image and Logo Image -->
			<div class="col-md-12">
				<img class="header" src="/demo/images/community_inner_bannerbg.jpg" />
				<a href="#"><img class="headerLogo" src="/demo/images/infogain-logo.png" /></a>
			</div>	
			
			<!-- Content Section -->
			<div class="container">
				<div class="contentSection">	
					<div class="col-md-8" style=";height:100%;;border: 1px solid #ddd; border-radius:15px;
								box-shadow: 1px 1px 11px -2px rgba(0,0,0,0.22);"></div>
					<div class="col-md-4" style=";height:100%">
						<div class="metadataSection container-fluid">
							<div class="row">
								<div class="col-md-12 zoomIn" style="background-color:#eff8fd;height:50%;border: 1px solid #ddd;border-radius:15px;
								box-shadow: 1px 1px 11px -2px rgba(0,0,0,0.22);"></div>
								<div class="col-md-12" style="height:10px"></div>
								<div class="col-md-12 zoomIn" style="background-color:#eff8fd;height:50%;border: 1px solid #ddd;border-radius:15px;
								box-shadow: 1px 1px 11px -2px rgba(0,0,0,0.22);"></div>
							</div>
						</div>
					</div>
				</div>
			</div>	
		
			<!-- Footer section -->
			<div class="container-fluid">
				<div class="footer">
					<div class="col-md-12" style="background-color:#595a5e;height:50px;border-radius:5px;">
						<div align="Center"><p style="color:white;padding:15px;">Copyright @2017</p></div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	alert("Test");
	
});



