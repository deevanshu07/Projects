<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="javax.ws.rs.core.Response"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>
<%@page import="javax.ws.rs.client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
System.out.println("Solr start"+request.getParameter("solrStart"));
System.out.println("No of result"+request.getParameter("noOfResults"));
System.out.println(request.getParameter("query"));
System.out.println(request.getParameter("filterQuery"));

String fq =  request.getParameter("filterQuery");
 if(fq!=null){
	
	fq = URLEncoder.encode(fq, "UTF-8").replaceAll("\\+", " ");
	System.out.println(fq);
} 
 //http://localhost:8983/solr/mydocs/select?q=*&wt=json&indent=on&facet=on&rows=0&facet.field=product&facet.prefix=In&facet.limit=10&facet.mincount=1
 //http://localhost:8983/solr/Schneider/suggest?wt=json&suggest.q=da
 //http://iomskyapp64v:8984/solr/Schneider/select
Client client=ClientBuilder.newClient();
 if(request.getParameter("q") !=null){
	 String q = request.getParameter("q").toLowerCase();
 }
WebTarget webTarget = client.target("http://localhost:8983/aiPoc/select")
.queryParam("q","*")
.queryParam("facet", "on")
.queryParam("facet.field", "Genre")
.queryParam("facet.mincount", 1)
.queryParam("wt", "json")
.queryParam("rows", 0);

System.out.println(webTarget);
Response response2=webTarget.request().get();
String serverResponse=response2.readEntity(String.class);
System.out.println("Response from Response"+serverResponse);
out.println(serverResponse);
%>




