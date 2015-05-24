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
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name}
			</h2>
		</c:if>

	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		You're not connected
	</sec:authorize>
</body>
</html>