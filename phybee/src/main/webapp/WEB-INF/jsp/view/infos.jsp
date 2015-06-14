<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div>
	<h3>
		<img src="<c:url value="/resources/logo/Phybee.png"/>"
			style="height: 50px; width: auto">Phybee
	</h3>
	<div class="bs-example">
		<ul class="nav nav-tabs" id="myTab">
			<li class="active"><a href="#sectionA" data-toggle="tab"><spring:message
						code="info.info" /></a></li>
			<li><a href="#sectionB" data-toggle="tab"><spring:message code="info.access" /></a></li>
			<li><a href="#sectionC" data-toggle="tab"><spring:message code="info.price" /></a></li>
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
							<td><c:out value="0123456789" /></td>
						</tr>
						<tr>
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
				<div>
					<spring:message code="info.subway" />
					<img src="<c:url value="" />" style="height: 10px; width: auto" />
					<img src="<c:url value="" />" style="height: 10px; width: auto">La
					Chapelle
					<spring:message code="message.or" />
					Barbès-Rochechouart <img src="<c:url value="" />"
						style="height: 10px; width: auto">Barbès-Rochechouart,
					Château Rouge, Marcadet -Poissoniers <img src="<c:url value="" />"
						style="height: 10px; width: auto"> Marx Dormoy, Porte de la
					Chapelle
				</div>
				<div>
					Bus<img src="<c:url value="" />" style="height: 10px; width: auto" />
					<img src="<c:url value="" />" style="height: 10px; width: auto">La
					Chapelle
					<spring:message code="message.or" />
					Barbès-Rochechouart <img src="<c:url value="" />"
						style="height: 10px; width: auto">Barbès-Rochechouart,
					Château Rouge
					<spring:message code="message.or" />
					Marcadet-Poissoniers <img src="<c:url value="" />"
						style="height: 10px; width: auto"> Marx Dormoy
					<spring:message code="message.or" />
					Porte de la Chapelle
				</div>
				<div>
					RER<img src="<c:url value="" />" style="height: 10px; width: auto">
					<img src="<c:url value="" />" style="height: 10px; width: auto">La
					Chapelle
					<spring:message code="message.or" />
					Barbès-Rochechouart <img src="<c:url value="" />"
						style="height: 10px; width: auto">Barbès-Rochechouart,
					Château Rouge
					<spring:message code="message.or" />
					Marcadet-Poissoniers <img src="<c:url value="" />"
						style="height: 10px; width: auto"> Marx Dormoy
					<spring:message code="message.or" />
					Porte de la Chapelle
				</div>
			</div>
			<div id="sectionC" class="tab-pane fade">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Monday</th>
							<th>Tuesday</th>
							<th>Wednesday</th>
							<th>Thursday</th>
							<th>Friday</th>
							<th>Saturday</th>
							<th>Sunday</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
						</tr>
						<tr>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
