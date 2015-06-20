<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#myTab a").click(function(e) {
				e.preventDefault();
				$(this).tab('show');
			});
		});
	</script>
	<link rel="stylesheet"
		  href="<c:url value="/resources/css/bootstrap.css"/>">
	<link rel="stylesheet"
		  href="<c:url value="/resources/css/bootstrap-theme.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/css/phybee.css"/>">
</head>

<body>

<div>
	<h3>
		<img src="<c:url value="/resources/logo/Phybee.png"/>"
			 style="height: 50px; width: auto">Phybee
	</h3>
	<div class="bs-example">
		<ul class="nav nav-tabs" id="myTab">
			<li class="active"><a href="#sectionA"><spring:message code="info.info" /></a></li>
			<li><a href="#sectionB"><spring:message code="info.access" /> <spring:message code="message.and" /> <spring:message code="info.price" /></a></li>
		</ul>
		<div class="tab-content">
			<div id="sectionA" class="tab-pane fade in active">
				<table class="table">
					<thead>
					<tr>
						<th>
							<h2>
										<span class="label label-primary"><spring:message
												code="info.contact" /></span>
							</h2>
						</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td><spring:message code="info.phone" />:</td>
						<td><c:out value="0123456789" /></td>
					</tr>
					<tr>
						<td><spring:message code="info.email" />:</td>
						<td><c:out value="phybee@gmail.com" /></td>
					</tr>
					</tbody>
				</table>
				<table class="table">
					<thead>
					<tr>
						<th>
							<h2>
										<span class="label label-primary"><spring:message
												code="info.address" /></span>
							</h2>
						</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td><c:out value="69 Rue de la Goutte-d'Or, 75018 Paris" /></td>
					</tr>
					</tbody>
				</table>
			</div>
			<div id="sectionB" class="tab-pane fade">
				<br />
				<div class="info-right">
					<h2>
						<span class="label label-primary"><spring:message code="info.price" /></span>
					</h2>
					<c:forEach var="item" items="${tickets}">
						<label><spring:message code="price.${item.getType()}" /> ${item.getFormatPrice()}</label>
						<br />
					</c:forEach>
				</div>
				<div class="info-left">
					<h2>
						<span class="label label-primary"><spring:message code="info.access" /></span>
					</h2>
					<div>
						<label><spring:message code="info.subway" /></label> <br />
						<img src="<c:url value="/resources/logo/ligne2.png" />" style="height: 20px; width: auto">
						<label>La Chapelle <spring:message code="message.or" /> Barbès-Rochechouart</label> <br />
						<img src="<c:url value="/resources/logo/ligne4.png" />"	style="height: 20px; width: auto">
						<label>Barbès-Rochechouart, Château Rouge <spring:message code="message.or" /> Marcadet-Poissoniers</label> <br />
						<img src="<c:url value="/resources/logo/ligne12.png" />"style="height: 20px; width: auto">
						<label>Marcadet-Poissoniers, Marx Dormoy <spring:message code="message.or" /> Porte de la Chapelle</label> <br />
					</div>
					<br />
					<div>
						<label>Bus</label><br />
						<img src="<c:url value="/resources/logo/ligne31.png" />" style="height: 20px; width: auto">
						<img src="<c:url value="/resources/logo/ligne60.png" />" style="height: 20px; width: auto">
						<img src="<c:url value="/resources/logo/ligne302.png" />" style="height: 20px; width: auto">
					</div>
					<br />
					<div>
						<label>RER</label> <br />
						<img src="<c:url value="/resources/logo/ligneb.png" />" style="height: 20px; width: auto">
						<img src="<c:url value="/resources/logo/ligned.png" />" style="height: 20px; width: auto">
						<img src="<c:url value="/resources/logo/lignee.png" />" style="height: 20px; width: auto">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div style="clear: both"/>
<div>
	<br />
	<img src="<c:url value="/resources/poster/golden_drop.png"/>" style="width: 100%; height: auto">
</div>
</body>
</html>
