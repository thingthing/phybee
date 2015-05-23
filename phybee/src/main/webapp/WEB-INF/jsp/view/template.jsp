<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 07/05/2015
  Time: 00:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><spring:message code="app.title.home" /></title>
</head>
<body>
  <jsp:include page="header.jsp" />
  <jsp:include page="${partial}" />
  <jsp:include page="footer.jsp" />
</body>
</html>
