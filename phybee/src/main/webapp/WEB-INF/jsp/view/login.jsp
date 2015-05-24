<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<span style="float: right"> <a href="?lang=en">en</a> | <a
	href="?lang=fr">fr</a>
</span>

<c:if test="${not empty error}">
	<div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
	<div class="msg">${msg}</div>
</c:if>

<sec:authorize access="isAnonymous()">
	<form name="loginForm" action="<c:url value='/auth/login_check' />"
		method='POST'>
		<spring:message code="field.email" />
		: <input type='text' name="email" />
		<spring:message code="field.password" />
		: <input type='password' name="password" /> <input type="submit"
			value="Login" />
	</form>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER')">
	<!-- For login user -->
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm"></form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			${user.firstName} ${user.lastName} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>

</sec:authorize>
