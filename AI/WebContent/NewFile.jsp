
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
			
			
		}
}


String fq =  request.getParameter("filterQuery");

 if(fq!=null){
	
	 fq=decode(fq);
	 
	fq = URLEncoder.encode(fq, "UTF-8").replaceAll("\\+", " ");
	/* System.out.println(fq); */
} 
 //http://localhost:38484/SolrSearchRestServices/services
 //http://iomskyapp63v:8080/SolrSearchRestServices/services
Client client=ClientBuilder.newClient();
WebTarget webTarget = client.target("http://bigdata1vm1:8081/PocApi/services")
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
<%!

/* static final String stringConversion(final String str)
{
	String newString=StringEscapeUtils.escapeJava(str);
			return newString;
} */
static final String decode(final String in)
{
    String working = in;
    int index;
    index = working.indexOf("\\u");
    while(index > -1)
    {
        int length = working.length();
        if(index > (length-6))break;
        int numStart = index + 2;
        int numFinish = numStart + 4;
        String substring = working.substring(numStart, numFinish);
        int number = Integer.parseInt(substring,16);
        String stringStart = working.substring(0, index);
        String stringEnd   = working.substring(numFinish);
        working = stringStart + ((char)number) + stringEnd;
        index = working.indexOf("\\u");
    }
    return working;
}
%>



