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
System.out.println("query  " + request.getParameter("query"));
System.out.println(request.getParameter("filterQuery"));
String question = request.getParameter("query");
String sortField = request.getParameter("sortField");
String rq = "";
if(sortField!=null || !"".equals(sortField))
{
		if("kudosCount".equals(sortField))
		{
		rq = "true";
		//	rq = "{!ltr model=lethiumModel reRankDocs=100 efi.user_query="+question+" }";
			//rq = URLEncoder.encode(rq,"UTF-8");
			System.out.println("*****************************"+rq);
			
		}
}


String fq =  request.getParameter("filterQuery");
 if(fq!=null){
	
	fq = URLEncoder.encode(fq, "UTF-8").replaceAll("\\+", " ");
	System.out.println(fq);
} 
 //http://localhost:38484/SolrSearchRestServices/services
 //http://iomskyapp63v:8080/SolrSearchRestServices/services
Client client=ClientBuilder.newClient();
WebTarget webTarget = client.target("http://localhost:8081/PocApi/services")
.path("/searchService")
.queryParam("sortField", request.getParameter("sortField"))
.queryParam("query", request.getParameter("query"))
.queryParam("sortOrder", request.getParameter("order"))
.queryParam("solrStart", request.getParameter("solrStart"))
.queryParam("searchId", "101")
.queryParam("noOfResults", request.getParameter("noOfResults"))
.queryParam("SAMAccountName", "samAccount")
.queryParam("wwTechSupportID", "wwTechSupportID")
.queryParam("sessionId", "searchId")
.queryParam("dateRangeMappingValue", request.getParameter("dateRangeMappingValue"))
.queryParam("filterQuery", fq)
.queryParam("rq",rq);
System.out.println(webTarget);
Response response2=webTarget.request().get();
String serverResponse=response2.readEntity(String.class);
//System.out.println("Response from Response"+serverResponse);
out.println(serverResponse);
%>




