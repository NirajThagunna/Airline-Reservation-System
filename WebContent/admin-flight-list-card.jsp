<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!-- Using JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">


<div class="container table-responsive">
	<h3 class="text-center">Flight List</h3>
	<hr>
	<table
		class="table table-bordered table-hover table-info border-success align-middle">
		<thead class="table-warning">
			<tr>
				<th>Flight No</th>
				<th>Flight Name</th>
				<th>From</th>
				<th>To</th>
				<th>Date</th>
				<th>Time</th>
				<th>Travel Duration</th>
				<th>Airport Name</th>
				<th>Ticket Price</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<!--   for (DataType var: collection framework like list etc) {  -->
			<!-- forEach loop in JSTL to iterate all the data from the list -->
			<c:forEach var="flight" items="${listFlight}">
				<tr>
					<td><c:out value="${flight.getFlightNo()}"></c:out></td>
					<td><c:out value="${flight.getFlightName()}"></c:out></td>
					<td><c:out value="${flight.getFrom()}"></c:out></td>
					<td><c:out value="${flight.getTo()}"></c:out></td>
					<td><c:out value="${flight.getDate()}"></c:out></td>
					<td><c:out value="${flight.getTime()}"></c:out></td>
					<td style="text-align: center;"><c:out
							value="${flight.getTravelDuration()}"></c:out></td>
					<td><c:out value="${flight.getAirportName()}"></c:out></td>
					<td><c:out value="${flight.getTicketPrice()}"></c:out></td>
					<td><a style="text-decoration: none; font-size: 18px;"
						href="update?flightNo=<c:out value='${flight.getFlightNo()}'/>">Update |</a>
						<a style="text-decoration: none; font-size: 18px;"
						href="delete?flightNo=<c:out value='${flight.getFlightNo()}'/>">Delete</a></td>
				</tr>
			</c:forEach>
			<!-- } -->
		</tbody>

	</table>
</div>
