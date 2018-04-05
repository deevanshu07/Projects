<%@page import="java.net.URLEncoder,java.net.URLDecoder"
%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%!

private String fnSep(StringBuilder sbIn) {
	String strOut = "&";
	if (sbIn.indexOf("?")<1) strOut = "?";
	return strOut;
}
private String fnAddMe(String strParamOut, String strParamIn, String strSep) {
	String strOut = "";
	if (null!=strParamIn && !"".equals(strParamIn)) strOut = strSep + strParamOut + "=" + strParamIn;
	return strOut;
}
%><%

StringBuilder sbURL = new StringBuilder();
//sbURL.append("http://172.18.12.61:8081/SearchAPI/services/searchService");

sbURL.append("http://172.18.12.61");
if (null!=request.getParameter("count")) {
	// this is a regular search
	sbURL.append(":8081/SearchAPI/services/searchService");
	String fq =  request.getParameter("filterQuery");

	if(null!=fq && !"".equals(fq)) {
		//fq = URLEncoder.encode(fq, "UTF-8").replaceAll("\\+", " ");
		fq = URLEncoder.encode(fq, "ISO-8859-1");
		sbURL.append(fnSep(sbURL)).append("filterQuery=").append(fq);
	} else {
		fq = "";
	}

	//sbURL.append(fnAddMe("rq",request.getParameter("ml"),fnSep(sbURL)));
	sbURL.append(fnAddMe("sortField",request.getParameter("sortField"),fnSep(sbURL)));
	sbURL.append(fnAddMe("sortOrder",request.getParameter("sortBy"),fnSep(sbURL)));
	sbURL.append(fnAddMe("solrStart",request.getParameter("start"),fnSep(sbURL)));
	sbURL.append(fnAddMe("noOfResults",request.getParameter("count"),fnSep(sbURL)));
	sbURL.append(fnAddMe("dateRangeMappingValue",request.getParameter("dateRangeMappingValue"),fnSep(sbURL)));
	sbURL.append(fnAddMe("query",URLEncoder.encode(request.getParameter("q")),fnSep(sbURL)));
	// hardcoded bits for Schneider customizations
	sbURL.append(fnAddMe("SAMAccountName","samAccount",fnSep(sbURL)));
	sbURL.append(fnAddMe("searchId",request.getParameter("searchId"),fnSep(sbURL)));
	sbURL.append(fnAddMe("wwTechSupportID","wwTechSupportID",fnSep(sbURL)));
	sbURL.append(fnAddMe("sessionId","searchId",fnSep(sbURL)));
} else if (null!=request.getParameter("recs")) {
	// this is trying to get more information about recommendations
	sbURL.append(":8983/solr/mlDemo/select");
	sbURL.append(fnAddMe("fl","title,id,largeImage,vote_average,release_date,backdrop_path,body",fnSep(sbURL)));
	sbURL.append(fnAddMe("wt","json",fnSep(sbURL)));
	sbURL.append(fnAddMe("q","(" + URLEncoder.encode(request.getParameter("recs")) + ")",fnSep(sbURL)));
} else if (null!=request.getParameter("id")) {
	// this is trying to get a single record
	sbURL.append(":8983/solr/mlDemo/select");
	sbURL.append(fnAddMe("wt","json",fnSep(sbURL)));
	sbURL.append(fnAddMe("q","id:" + request.getParameter("id"),fnSep(sbURL)));
	sbURL.append(fnAddMe("searchId",request.getParameter("searchId"),fnSep(sbURL)));
} else {
	// this is typeahead
	sbURL.append(":8983/solr/mlDemo/select");
	sbURL.append(fnAddMe("q","title:" + URLEncoder.encode(request.getParameter("q")),fnSep(sbURL)));
	sbURL.append(fnAddMe("wt","json",fnSep(sbURL)));
	sbURL.append(fnAddMe("defType","edismax",fnSep(sbURL)));
	sbURL.append(fnAddMe("rows","10",fnSep(sbURL)));
	sbURL.append(fnAddMe("fl","title",fnSep(sbURL)));
}





java.net.URL url = new java.net.URL(sbURL.toString());

java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(url.openStream()));
String inputLine;
//StringBuffer response = new StringBuffer();

String strCallback = request.getParameter("callback"); // to add jsonp support
if (null!=strCallback && !"".equals(strCallback)) out.print(strCallback + "(");

while ((inputLine = in.readLine()) != null) out.println(inputLine + "\n");

if (null!=strCallback && !"".equals(strCallback)) out.print(")");
in.close();
%>
