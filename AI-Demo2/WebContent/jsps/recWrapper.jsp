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
//sbURL.append("http://50.202.96.113");
sbURL.append("http://172.18.12.61");
sbURL.append(":8081/mahoutr/rest/service/recommend/items/");

if (null!=request.getParameter("userId") && !"".equals(request.getParameter("userId"))) {
	sbURL.append("user/").append(request.getParameter("userId"));
} else if (null!=request.getParameter("itemId") && !"".equals(request.getParameter("itemId"))){
	sbURL.append(request.getParameter("itemId"));
}
java.net.URL url = new java.net.URL(sbURL.toString());

java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(url.openStream(), "UTF8"));
String inputLine;
//StringBuffer response = new StringBuffer();

String strCallback = request.getParameter("callback"); // to add jsonp support
if (null!=strCallback && !"".equals(strCallback)) out.print(strCallback + "(");

while ((inputLine = in.readLine()) != null) out.println(inputLine + "\n");

if (null!=strCallback && !"".equals(strCallback)) out.print(")");
in.close();
%><!-- <%= sbURL %> -->
