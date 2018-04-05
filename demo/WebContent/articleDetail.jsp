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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
%><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
								box-shadow: 1px 1px 11px -2px rgba(0,0,0,0.22);">
						<div class="row">	
							<!-- For Big Topic Title-->
							<div class="col-md-12" style="border:1px solid black">
								<p id="titleHeading" class="fontstyle" style="color:#0678be;font-weight:normal;font-size:26px;padding:10px"></p>	
							</div>
							<!-- For Left Document ID-->
							<div class="col-md-12" style="border:1px solid black">
								<p id="leftDocumentID" class="fontstyle" style="margin-left:10px;"></p>
							</div>
							<!-- For Document Title-->
							<div class="col-md-12">
								<div class="row">
									<div class="col-md-12" style="height:10px"></div>
									<div class="col-md-12"style="border:1px solid black;background-color:#eff8fd">
										<h4><strong><p class="fontstyle" style="margin-left:10px;">Title</p></strong></h4>
									</div>
									<div class="col-md-12"style="border:1px solid black">
										<p class="fontstyle" id="DocumentTitle" style="font-size: 15px;margin-left:10px;"></p>
									</div>
									<div class="col-md-12" style="height:10px"></div>
								</div>								
							</div>
							
							<!-- For Document Body-->
							<div class="col-md-12">
								<div class="row">
									<div class="col-md-12" style="height:10px"></div>
									<div class="col-md-12"style="border:1px solid black;background-color:#eff8fd">
										<h4><strong><p class="fontstyle" style="margin-left:10px;">Body</p></strong></h4>
									</div>
									<div class="col-md-12"style="border:1px solid black">
										<p class="fontstyle" id="DocumentBody" style="font-size: 15px;margin-left:10px;"></p>
									</div>
									<div class="col-md-12" style="height:10px"></div>
								</div>	
							</div>
							
							<!-- For Document MessageBoard-->
							<div class="col-md-12">
								<div class="row">
									<div class="col-md-12" style="height:10px"></div>
									<div class="col-md-12"style="border:1px solid black;background-color:#eff8fd">
										<h4><strong><p class="fontstyle" style="margin-left:10px;">MessageBoard</p></strong></h4>
									</div>
									<div class="col-md-12"style="border:1px solid black">
										<p class="fontstyle" id="DocumentMessageBoard" style="font-size: 15px;margin-left:10px;"></p>
									</div>
									<div class="col-md-12" style="height:10px"></div>
								</div>	
							</div>
						</div>
					</div>
					<!-- MetaData Section -->
					<div class="col-md-4" style=";height:100%">
						<div class="metadataSection container-fluid">
							<div class="row">
								<div class="col-md-12">
									<div class="panel-group zoomIn" style="1px solid #ddd;border-radius:15px;
								box-shadow: 1px 1px 11px -2px rgba(0,0,0,0.22);">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
													<a data-toggle="collapse" href="#collapse1"><span style="align:center">Document Details</span></a>
												</h4>
											</div>
										<div id="collapse1" class="panel-collapse collapse">
											<ul class="list-group">
												<li class="list-group-item">Document ID: </li>
												<li class="list-group-item">View Count: </li>
												<li class="list-group-item">Post Time: </li>
												<li class="list-group-item">Last Edit Time: </li>
												<li class="list-group-item">Tag: </li>
												<li class="list-group-item">Clicks: </li>
												<li class="list-group-item">Kudos Count: </li>
											</ul>
										</div>
									</div>
								</div>
							</div>
								<div class="col-md-12" style="height:10px"></div>
								<div class="col-md-12 zoomIn" style="background-color:#eff8fd;height:50%;border: 1px solid #ddd;border-radius:15px;
								box-shadow: 1px 1px 11px -2px rgba(0,0,0,0.22);">
									<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
													<a data-toggle="collapse" href="#collapse1"><span style="align:center"></span></a>
												</h4>
											</div>
										<div id="collapse1" class="panel-collapse collapse">
											<ul class="list-group">
												<li class="list-group-item">Document ID: </li>
												<li class="list-group-item">View Count: </li>
												<li class="list-group-item">Post Time: </li>
												<li class="list-group-item">Last Edit Time: </li>
												<li class="list-group-item">Tag: </li>
												<li class="list-group-item">Clicks: </li>
												<li class="list-group-item">Kudos Count: </li>
											</ul>
										</div>
									</div>
								</div>
								</div>
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
	var response = <%=serverResponse%>;
	//alert(response);	
	$.each(response,function(id,obj){
		//alert(id);
		$.each(obj.docs,function(x,docrecords){
		
		/*	$("#doc_title").append("<h1>Title<h1><h2>"+docrecords.topicTitle+"</h2>");
			$("#doc_body").append("<p>"+docrecords.topicBody+"</p>");
			$("#doc_details").append(docrecords.id+"<br />"+docrecords.thread_last_edit_time+"<br />"+docrecords.messageBoard+"<br />"+docrecords.viewsCount+"<br />"+docrecords.thread_post_time+"<br />"+docrecords.post_time+"<br />"+docrecords.kudosCount+"<br />"+docrecords.last_edit_time+"<br />"+docrecords.message_rating+"<br />"+docrecords.clicks+"<br />"+docrecords.threadViewsCount+"<br />"+docrecords.clicks+"<br />"+docrecords.tag+"<br />"+docrecords.threadReply+"<br />"+docrecords.threadReplyBody+"<br />");
		
		*/	
		
		
		
		if(typeof docrecords.topicTitle !== "undefined"){
			$("#titleHeading").append(docrecords.topicTitle);
		}else{
			$("#titleHeading").append("NA");
		}
		
		if(typeof docrecords.id !== "undefined" ){
			$("#leftDocumentID").append("<h4>Document ID: "+docrecords.id+"</h4>");
		}else{
			$("#leftDocumentID").append("NA");
		}
		
		if(typeof docrecords.topicTitle !== "undefined" ){
			$("#DocumentTitle").append(docrecords.topicTitle);
		}else{
				$("#DocumentTitle").append("NA");
		}
		
		if(typeof docrecords.topicBody !== "undefined" ){
			$("#DocumentBody").append(docrecords.topicBody);
		}else{
				$("#DocumentBody").append("NA");
		}
		
		if(typeof docrecords.messageBoard !== "undefined" ){
			$("#DocumentMessageBoard").append(docrecords.messageBoard);
		}else{
				$("#DocumentMessageBoard").append("NA");
		}
		
		if(typeof docrecords.id !== "undefined" ){
			$("#id").append("  "+docrecords.id);
		}else{}
		
		if(typeof docrecords.viewsCount !== "undefined" ){
			$("#views_Count").append("  "+docrecords.viewsCount);
		}else{}
	
		if(typeof docrecords.post_time !== "undefined" ){
			$("#post_time").append("  "+docrecords.post_time);
		}else{}
		
		if(typeof docrecords.last_edit_time !== "undefined" ){
			$("#last_edit_time").append("  "+docrecords.last_edit_time);
		}else{}
		
		if(typeof docrecords.tag !== "undefined" ){
			$("#tag").append("  "+docrecords.tag);
		}else{}
		
		if(typeof docrecords.clicks !== "undefined" ){
			$("#clicks").append("  "+docrecords.clicks);
		}else{}
		
		if(typeof docrecords.kudosCount !== "undefined" ){
			$("#kudosCount").append("  "+docrecords.kudosCount);
		}else{}
		
		if(typeof docrecords.threadReply !== "undefined" ){
			$("#threadReply").append("  "+docrecords.threadReply);
		}else{}
		
		if(typeof docrecords.threadReplyBody !== "undefined" ){
			$("#threadReplyBody").append("  "+docrecords.threadReplyBody);
		}else{}

	
		});
	}); 
});	

</script>