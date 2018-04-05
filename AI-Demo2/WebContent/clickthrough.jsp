<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="javax.ws.rs.core.Response"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>
<%@page import="javax.ws.rs.client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 
 
 //http://localhost:8983/solr/Schneider/select
 //http://iomskyapp64v:8984/solr/Schneider/select
Client client=ClientBuilder.newClient();
WebTarget webTarget = client.target("http://bigdata1vm1:8081/PocApi/services")
.path("/clickThroughService")
.queryParam("linkPosition",request.getParameter("linkPosition"))
.queryParam("title", request.getParameter("title"))
.queryParam("docId",request.getParameter("docId"))
.queryParam("searchId",request.getParameter("searchId"));
System.out.println("=======================  +>" + webTarget);
Response response2=webTarget.request().get();
String serverResponse=response2.readEntity(String.class);
out.println(serverResponse);
%>

