<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
	<c:if test="${not empty username}">
		<h1>User : ${username}</h1>
	</c:if>

	<sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm"></form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
		<c:url value="/reservation/movie" var="reservation" />
		<a href="${reservation}">reservation</a>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>

	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<c:url value="/login" var="loginUrl" />
		<a href="${loginUrl}">Login</a>
	</sec:authorize>
</body>
</html>