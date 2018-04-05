
<%@page import="org.json.simple.JSONObject"%>
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

<%@page import="java.util.*"%>
<%@page import="org.w3c.dom.*"%>
<%@page import="org.xml.sax.InputSource"%>
<%@page import=" javax.xml.parsers.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Article Details</title>
</head>
<body>


	<%
		//out.println("ID : "+request.getParameter("id"));

		Client client = ClientBuilder.newClient();
		//WebTarget webTarget = client.target("http://bigdata1vm1:8081/AI/articleDetail.jsp?id=201").queryParam("wt", "json").queryParam("indent", "on");
		WebTarget webTarget = client.target("http://localhost:8983/solr/lithium/select").queryParam("q", "id:"+request.getParameter("id")).queryParam("wt","json");
		System.out.println(webTarget);
		Response response2 = webTarget.request().get();
		String serverResponse = response2.readEntity(String.class);
		serverResponse = serverResponse.trim();
	%>


	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">

				

			</div>
			<div class="navbar-collapse collapse" id="navBarToggle">
				<ul class="nav navbar-nav navbar-right">


				</ul>
			</div>

		</div>
		<!--Code Customization starts by Infogain for MD screen size search in second navbar-->
		<div class="navbar hidden-lg hidden-md second-navbar">
			<div class="container">
				<div class="navbar-header1">
					

				</div>
			</div>
		</div>
		<!--Code Customization ends-->
	</div>
	<div class="jumbotron">
		<a name="pageTop" target="_blank"></a>
		<div class="container">
			<h2>
				<div class="page_id"></div>
			</h2>
			<div class="btn-toolbar hidden-print" role="toolbar"
				id="pageControls"></div>
		</div>
	</div>


	<div class="col-lg-10" >

		<h2>
			Topic Title
		</h2>
		<div >
			<div class=" topicTitle">

			</div>

			<p>&nbsp;</p>
		</div>
		<h2>
			<a name="RESTRICTIONS1" target="_blank"></a>Thread Reply
		</h2>
		<div class="threadReply">
			
		</div>

	</div>
		<div class="row col-lg-2">
		<div class="panel panel-default" id="INFO">
			<div class="panel-heading">
				<h3 class="panel-title">Metadata</h3>
			</div>
			<div class="panel-body documentID"></div>
		</div>
	</div>
	<script>
		var data =
	<%=serverResponse%>
		;
		console.log(data);
		var jsonData = [];
		$.each(data, function(key, value) {
			jsonData.push(value);
		});

		$.each(jsonData, function(key, value) {
			$.each(value.docs, function(key, value) {

				console.log(value);
				$('div .documentID').append("<dt>Document ID</dt>").append(
						"<dd>").append(value.id).append("</dd>").append(
						"<dt>Version</dt>").append("<dd>").append(value.clicks)
						.append("</dd>").append("<dt>Post Time</dt>").append(
								"<dd>").append(value.post_time).append("</dd>")
						.append("<dt>Kudos Count</dt>").append("<dd>").append(
								value.kudosCount).append("</dd>").append(
								"<dt>Last Edit Time</dt>").append("<dd>")
						.append(value.last_edit_time).append("</dd>").append(
								"<dt>Version</dt>").append("<dd>").append(
								value._version_).append("</dd>").append(
								"<dt>Last Edit Time</dt>").append("<dd>")
						.append(value.last_edit_time).append("</dd>").append(
								"<dt>Message Rating</dt>").append("<dd>")
						.append(value.message_rating).append("</dd>");
				$('div .page_id').append(value.topicTitle);
				$('div .topicTitle').append(value.topicTitle);
				$('div .threadReply').append(value.threadReply);

			});
		});
	</script>
</body>
</html>