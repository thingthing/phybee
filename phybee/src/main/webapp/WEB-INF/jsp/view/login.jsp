<%@page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<sec:authorize access="isAnonymous()">
	<div id="contents" align="center"
		class="container row col-sm-6 col-md-4 col-md-offset-4">
		<div class="account-wall">
			<tiles:insertAttribute name="loginForm" />
		</div>
	</div>
	<div class="container row col-sm-6 col-md-4 col-md-offset-4">
		<a href="<c:url value="/register"/>"> <spring:message
				code="field.register" /></a>
	</div>
</sec:authorize>
