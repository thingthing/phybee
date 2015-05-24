<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/phybee/home">Phybee</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/home"/>">Home</a></li>
				<li><a href="<c:url value="/schedule"/>">Schedule</a></li>
				<li><a href="<c:url value="/movie"/>">Movie</a></li>
				<li><a href="<c:url value="/incoming"/>">Incoming</a></li>
				<li><a href="<c:url value="/reservation/movie"/>">Reservation</a></li>
				<li><a href="<c:url value="infos"/>">Infos</a></li>
			</ul>
		</div>
	</div>
</nav>