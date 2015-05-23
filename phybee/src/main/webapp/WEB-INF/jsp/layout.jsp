<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<table border="1" cellpadding="2" cellspacing="2" align="center">
    <tbody><tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="header">
        </tiles:insertAttribute></td>
    </tr>
    <tr>
        <td><tiles:insertAttribute name="body"></tiles:insertAttribute></td>
    </tr>
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="footer">
        </tiles:insertAttribute></td>
    </tr>
</tbody></table>