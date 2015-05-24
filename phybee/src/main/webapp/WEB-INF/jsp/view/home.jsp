<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
        <c:forEach var="item-active" items="${movies}">
          <li data-target="#carousel-example-generic" data-slide-to="${item.getmId()}"></li>
          </c:forEach>
        </ol>
        <div class="carousel-inner" role="listbox">
        <c:forEach var="item" items="${movies}">
          <div class="item-active">
            <img src="/resources/poster/${item.getmPoster()}" alt="${item.getmId()}" data-holder-rendered="true">
          </div>
          </c:forEach>
        </div>

        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
</div>
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