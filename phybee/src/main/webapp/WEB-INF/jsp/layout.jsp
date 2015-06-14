<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="icon" type="image/png"
	href="<c:url value="/resources/logo/Phybee.png"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-theme.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/phybee.css"/>">
<script src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<div id="wrap">
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<tiles:insertAttribute name="header" />
			<div class="navbar-collapse collapse">
				<tiles:insertAttribute name="menu" />
				<tiles:insertAttribute name="menuLoginLayout" />
			</div>
		</div>
	</nav>
	<div class="container">
		<tiles:insertAttribute name="body" />
	</div>
	<div id="push"></div>
</div>
<div id="footer">
	<div class="container">
		<tiles:insertAttribute name="footer" />
	</div>
</div>


