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
 
 System.out.println(request.getParameter("q"));
Client client=ClientBuilder.newClient();
WebTarget webTarget = client.target("http://localhost:8081/SolrApi/services")
.path("/clickThroughService")
.queryParam("linkPosition",request.getParameter("linkPosition"))
.queryParam("title", request.getParameter("title"))
.queryParam("docId",request.getParameter("docId"))
.queryParam("searchId",request.getParameter("searchId"));
System.out.println(webTarget);
Response response2=webTarget.request().get();
String serverResponse=response2.readEntity(String.class);

%>

