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
<%@ page import="java.io.*"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
<%
String id =request.getParameter("id");
Client client=ClientBuilder.newClient();
WebTarget webTarget = client.target("http://localhost:8983/solr/aiPoc/select")
.queryParam("q", "id:"+request.getParameter("id"))
.queryParam("wt","json").queryParam("indent","on");
System.out.println(webTarget);
Response response2=webTarget.request().get();
String serverResponse=response2.readEntity(String.class);
//System.out.println("Response from Response"+serverResponse);
//out.println(serverResponse);

String nameOfTextFile = "/home/oracle/solr/apache-tomcat-7.0.57/webapps/AI/docJson.json";
try {   
    PrintWriter pw = new PrintWriter(new FileOutputStream(nameOfTextFile));
    pw.println(serverResponse);
    //clean up
    pw.close();
} catch(IOException e) {
   out.println(e.getMessage());
}

%>	
<link href="css/roboto.css"	rel="stylesheet">
<style>
#headerLogo{
	width:100%;
	height:10%;
	position:relative;
	top:0px;
	left:0px;
	right:0px;
	
	border-radius:10px;
	background-image: url("/AI/images/community_inner_bannerbg.jpg");
}
#left_div{
	float: left;
	width: 60%;
	min-height: 80%;
	position:relative;
	
	border-radius:10px;
}
#right_div{
	float: right;
	width: 35%;
	min-height: 80%;
	position:relative;
	border: 1px solid #595a5e;
	border-radius:10px;
}
#title{
	float: left;
	width: 100%;
	
	min-height: 10%;
	position:relative;
	border-radius:10px;
}
#body{
	float: left;
	width: 100%;
	
	min-height: 100%;
	position:relative;
	border-radius:10px;
}
#infogainLogo{
	position:relative;
	background-image:url("/AI/images/infogain-logo.png");
}
.heading{
	width:100%;
	height:30px;
	background-color:#DFD5D3;
	border-radius:5px;
	margin-top:5px;
}
.title_text{
	font-weight: bold;
}
</style>
<div id="headerLogo">
	<div id="infogainLogo"></div>	
</div>
<div id="right_div">
	<h3 class="heading" align="center" >MetaData</h3>
	<div id="metadata"></div>
</div>

<div id="left_div">
	<div id="title"></div>
	<div id="body"></div>
</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" language="javascript">
/*
$.getJSON('docJson.json',function(data){
	//console.log(data);
	
});
*/
	
$.ajax({
	url: 'docJson.json',
	dataType: 'json',
	success: function(data){
	
		// Considering that docs attribute will contain array of length 1 only.  i.e metadata of only one record at a time.
		var Keyarray=Object.keys(data.response.docs[0]);
	
		$(data.response.docs).each(function(index,value){
			//console.log(index+" "+value);
			$(value).each(function(index,value){
				//console.log(value);
				for(var i=0; i < Keyarray.length; i++){
					//var docsKeysarray = Object.keys(data.response.docs[i]);
					var keyName = Keyarray[i];
					//console.log("Key: "+keyName+" "+"Value: "+value[keyName]);	
					
						
						if(keyName == "title"){
							$("#title").append("<h3 class='heading'>"+keyName+"</h3>"+value[keyName]);
						}
						if(keyName == "body"){
							//console.log(keyName.length);
							$("#body").append("<h3 class='heading'>"+keyName+"</h3>"+value[keyName]);
						}
						if(!(keyName == "body" || keyName == "title")){
							$("#metadata").append("<span class='title_text'>"+keyName+"</span>:"+value[keyName]+"<br /><br />");
						}
						
											
				}
			});
		});
		
	/*	$(data.response).each(function(index,value){
			//console.log(index);
		
			var docs = value.docs;
			alert(Object.keys(value.docs));
		
			$(value.docs).each(function(index,value){
				console.log(index+" "+value);
				$.each(value,function(index,value){
					console.log(index+" "+value);	
				}); 
				
			}); 
		}); */
	},
	error: function(){
		alert('Something went wrong!!');
	}
});
</script>
