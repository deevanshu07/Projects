<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="javax.ws.rs.core.Response"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>
<%@page import="javax.ws.rs.client.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%


Client client=ClientBuilder.newClient();
WebTarget webTarget = client.target("http://bigdata1vm1:8983/solr/talend/select?indent=on&wt=json&fl=topicTitle,topicBody")
.queryParam("q", request.getParameter("q"));
System.out.println(webTarget);
Response response2=webTarget.request().get();
String serverResponse=response2.readEntity(String.class);

out.println(serverResponse);
%>




