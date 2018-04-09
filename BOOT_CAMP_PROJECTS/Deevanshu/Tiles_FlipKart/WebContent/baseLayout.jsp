<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
<title><tiles:getAsString name="title" /></title>
</head>

<body>
    <table border="1" cellpadding="2" cellspacing="2" align="center" bgcolor="yellow">
        <tr>
            <td height="20%" colspan="2">
            	<tiles:insertAttribute name="header"/>
            </td>
        </tr>
        <tr>
            <td width="200" height="250">
            	<tiles:insertAttribute name="navigate"/>
            </td>
            <td>
            	<tiles:insertAttribute name="body"/>
            </td>
        </tr>
        <tr>
            <td height="20%" colspan="2">
            	<tiles:insertAttribute name="footer"/>
            </td>
        </tr>
    </table>
</body>
</html>



<!--<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>

<table width="100%" height="100%">
<tr>
 	<td width="100%" height="25%" bgcolor="red">
 	<tiles:insertAttribute name="header"></tiles:insertAttribute> 	
 	</td>
</tr>
<tr>
	
 	<td width="20%" height="60%" bgcolor="yellow">
 	<tiles:insertAttribute name="navigate"></tiles:insertAttribute>
 	</td>
 	<td width="80%" height="60%" bgcolor="pink">
 	<tiles:insertAttribute name="body"></tiles:insertAttribute>
 	</td>
</tr>
<tr>
 	<td width="100%" height="15%" bgcolor="blue">
 	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
 	</td>
</tr>
</table>
</html>-->