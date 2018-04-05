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

Client client=ClientBuilder.newClient();
WebTarget webTarget = client.target("http://localhost:8983/solr/lithium/select")
.queryParam("q", "id:"+request.getParameter("id"))
.queryParam("wt","json").queryParam("indent","on");
System.out.println(webTarget);
Response response2=webTarget.request().get();
String serverResponse=response2.readEntity(String.class);
//System.out.println("Response from Response"+serverResponse);
//out.println(serverResponse);
%>
<link href="css/roboto.css"	rel="stylesheet">
<style>

#main_page{
	width: 75%;
	min-height: 90%;
	overflow: hidden;
	float:left;
	margin-top:10px;
	border-radius:10px;
	z-index: -99;
}
#headerLogo{
	width:100%;
	height:10%;
	position:fixed;
	top:0px;
	left:0px;
	right:0px;
	background-image: url("/AI/images/community_inner_bannerbg.jpg");
	
}
.heading{
	width:100%;
	height:30px;
	background-color:#DFD5D3;
	border-radius:5px;
	margin-top:5px;
}
#side_div{
	top:0px;
	border-radius:10px;
	float:right;
	width:23%;
	min-height: 50%;
	overflow: hidden;
	margin-right:5px;
	border: 1px solid #595a5e;
}
.Detail_heading{
	width:100%;
	height:30px;
	background-color:#595a5e;
	border-radius:5px;
}
#additionalDiv{
	margin-top:10px;
	border-radius:10px;
	float:right;
	width:23%;
	min-height: 50%;
	overflow: hidden;
	margin-right:5px;
	border: 1px solid #595a5e;
}
#top_div{
	width: 75%;
	min-height: 20%;
	position:relative;
	overflow: hidden;
	float:left;
	margin-top:50px;
	border-radius:10px;
}
#footer{	
	width:100%;
	min-height:5%;
	overflow: hidden;
	right: 0;
    bottom: 0;
    left: 0;
	padding-top: 10px;
	text-align: center;
	background-color:#595a5e;
	border-radius:3px;
}
.title_text{
	font-weight: bold;
}
#infogainLogo{
	background-image:url("/AI/images/infogain-logo.png");
	float: left;
	padding-top:1px;
	height:90%;
	width:13%;
}
</style>


<div id="headerLogo">
	<div id="infogainLogo"></div>	
</div>

<div id="top_div">
	<div id="BigTitle"></div>
	<h3><div id="big_docid" style="margin-top:10px">Document Id- </div></h3>
</div>

<div id="main_page">
	<div class="heading"><h3 style="padding-top:3px;padding-left:3px">Title</h3></div>
	<div id="doc_title" style="padding-top:3px"></div>
	<br /><br /><br />
	<div class="heading"><h3 style="padding-top:3px;padding-left:3px">Body</h3></div>
	<div id="doc_body" style="padding-top:3px"></div>
	<br /><br /><br />
	<div class="heading"><h3 style="padding-top:3px;padding-left:3px">MessageBoard</h3></div>
	<div id="doc_message" style="padding-top:3px"></div>
</div>
<div id="side_div">
	<div id="Document Details">
		<div id="doc_id" class="Detail_heading" align="center">Document Details</div>
		<br />
		<div id="id" style="margin-left:3px" ><span class="title_text">Document ID: </span> </div>
		<br />
		<div id="views_Count" style="margin-left:3px"><span class="title_text">View Count:</span> </div>
		<br />
		<div id="post_time" style="margin-left:3px" ><span class="title_text">Post Time: </span> </div>
		<br />
		<div id="last_edit_time" style="margin-left:3px"><span class="title_text">Last Edit Time:</span>  </div>
		<br />
		<div id="tag" style="margin-left:3px"><span class="title_text">Tag: </span> </div>
		<br />
		<div id="clicks" style="margin-left:3px"><span class="title_text">Clicks:</span>  </div>
		<br />
		<div id="kudosCount" style="margin-left:3px" ><span class="title_text">kudos Count: </div> </div>
	</div>
</div>

<div id="additionalDiv">
	<div id="additionalDeatils">
	<div id="additionalDeatil" class="Detail_heading" align="center">Additional Details</div>
	<br />
	<div id="threadReply" style="margin-left:3px"><span class="title_text">Thread Reply:</span>  </div>
	<br />
	<div id="threadReplyBody" style="margin-left:3px" ><span class="title_text">Thread Reply Body: </span> </div>
	</div>
</div>
<div id="footer">
	<div align="Center" ><span class="title_text">Copyright@ Infogain</span></div>
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
			$("#BigTitle").append("<h1>"+docrecords.topicTitle+"</h1>");
		}else{
			
		}
		
		if(typeof docrecords.id !== "undefined" ){
			$("#big_docid").append(docrecords.id);
		}else{}
		
		if(typeof docrecords.topicTitle !== "undefined" ){
			$("#doc_title").append(docrecords.topicTitle);
		}else{}
		
		if(typeof docrecords.topicBody !== "undefined" ){
			$("#doc_body").append(docrecords.topicBody);
		}else{}
		
		if(typeof docrecords.messageBoard !== "undefined" ){
			$("#doc_message").append(docrecords.messageBoard);
		}else{}
		
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