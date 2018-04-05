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
//sbURL.append("http://50.202.96.113:8081/PocApi/services/clickThroughService");
sbURL.append("http://172.18.12.61:8081/SearchAPI/services/clickThroughService");


sbURL.append(fnAddMe("linkPosition",request.getParameter("linkPosition"),fnSep(sbURL)));
sbURL.append(fnAddMe("title",URLEncoder.encode(request.getParameter("title")),fnSep(sbURL)));
sbURL.append(fnAddMe("docId",request.getParameter("docId"),fnSep(sbURL)));
sbURL.append(fnAddMe("searchId",request.getParameter("searchId"),fnSep(sbURL)));

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