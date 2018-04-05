<%@page import="javax.ws.rs.core.MediaType"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="javax.ws.rs.core.Response"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>
<%@page import="javax.ws.rs.client.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
 
 
 //http://localhost:8983/solr/Schneider/select
 //http://iomskyapp64v:8984/solr/Schneider/select
Client client=ClientBuilder.newClient();
WebTarget webTarget = client.target("http://localhost:8983/solr/lithium/schema/analysis/stopwords/english");
webTarget.request(MediaType.APPLICATION_JSON);
System.out.println(webTarget);
Response response2=webTarget.request().get();
String serverResponse=response2.readEntity(String.class);
//System.out.println("Response from Response"+serverResponse);
out.println(serverResponse);
%>




