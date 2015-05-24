<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<ul class="nav navbar-nav">
	<li><a href="<c:url value="/home"/>"><spring:message
				code="field.home" /></a></li>
	<li><a href="<c:url value="/schedule"/>"><spring:message
				code="field.schedule" /></a></li>
	<li><a href="<c:url value="/movie"/>"><spring:message
				code="field.movie" /></a></li>
	<li><a href="<c:url value="/incoming"/>"><spring:message
				code="field.soon" /></a></li>
	<li><a href="<c:url value="/reservation/movie"/>"><spring:message
				code="field.reservation" /></a></li>
	<li><a href="<c:url value="/infos"/>"><spring:message
				code="field.info" /></a></li>
	<sec:authorize access="isAnonymous()">
		<li><a href="<c:url value="/register"/>"><spring:message
					code="field.subscription" /></a></li>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm"
			style="display: none"></form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<li><a href="javascript:formSubmit()"><spring:message
					code="field.logout" /></a></li>

	</sec:authorize>
</ul>
