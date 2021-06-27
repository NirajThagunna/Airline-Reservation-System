<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<div class="container">
	<div id="signupbox" style="margin-top: 10px"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<c:if test="${flight != null}">
					<div class="panel-title">Update Flight</div>
				</c:if>

				<c:if test="${flight == null}">
					<div class="panel-title">Add Flight</div>
				</c:if>
			</div>
			<div>
				<%@ include file="successMsg.jsp"%>
			</div>
			<div class="panel-body">
				<c:if test="${flight != null }">
					<form action="updateFlight" method="post">
				</c:if>
				<c:if test="${flight == null }">
					<form action="addFlight" method="post">
				</c:if>
				<div id="div_id_username" class="form-group required">
					<label for="id_username"
						class="control-label col-md-4  requiredField"> Flight No.<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md  textinput textInput form-control"
							id="id_username" maxlength="30" name="flightNo"
							placeholder="Enter Flight Number"
							value="<c:out value='${flight.getFlightNo()}' />"
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div id="div_id_email" class="form-group required">
					<label for="id_email" class="control-label col-md-4  requiredField">
						Flight Name<span class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md emailinput form-control" id="id_email"
							name="flightName" placeholder="Enter Flight Name"
							value="<c:out value='${flight.getFlightName()}' />"
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div id="div_id_password1" class="form-group required">
					<label for="id_password1"
						class="control-label col-md-4  requiredField">From<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control"
							id="id_password1" name="from" placeholder="from"
							value="<c:out value='${flight.getFrom()}' />"
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div id="div_id_password2" class="form-group required">
					<label for="id_password2"
						class="control-label col-md-4  requiredField"> To<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control"
							id="id_password2" name="to" placeholder="To"
							value="<c:out value='${flight.getTo()}' />"
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div id="div_id_name" class="form-group required">
					<label for="id_name" class="control-label col-md-4  requiredField">
						Date<span class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control"
							id="id_name" name="date"
							value="<c:out value='${flight.getDate()}' />"
							style="margin-bottom: 10px" type="date" required
							pattern="\d{4}-\d{2}-\d{2}" />
					</div>
				</div>
				<div id="div_id_company" class="form-group required">
					<label for="id_company"
						class="control-label col-md-4  requiredField"> Time<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control"
							id="id_company" name="time" placeholder="Enter Time"
							value="<c:out value='${flight.getTime()}' />"
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div id="div_id_catagory" class="form-group required">
					<label for="id_catagory"
						class="control-label col-md-4  requiredField"> Travel
						Duration<span class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control"
							id="id_catagory" name="duration"
							placeholder="Enter Travel Duration"
							value="<c:out value='${flight.getTravelDuration()}' />"
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div id="div_id_number" class="form-group required">
					<label for="id_number"
						class="control-label col-md-4  requiredField"> Airport
						Name<span class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control"
							id="id_number" name="airportName"
							placeholder="Enter Airport Name"
							value="<c:out value='${flight.getAirportName()}' />"
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div id="div_id_location" class="form-group required">
					<label for="id_location"
						class="control-label col-md-4  requiredField"> Ticket
						Price<span class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control"
							id="id_location" name="price" placeholder="Enter Ticket Price"
							value="<c:out value='${flight.getTicketPrice()}' />"
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div class="form-group">
					<div class="aab controls col-md-4 "></div>
					<div class="controls col-md-8 ">

						<c:if test="${flight != null}">
							<input id="btn5" type="submit" name="submit" value="Update"
								class="btn6" id="submit-id-signup"/>
						</c:if>
						<c:if test="${flight == null}">
							<input id="btn5" type="submit" name="submit" value="Submit"
								class="btn7" id="submit-id-signup" />
						</c:if>
						or <input id="btn5" type="reset" name="reset" value="Reset"
							class="btn8" id="button-id-signup" />
					</div>
				</div>

				</form>
			</div>
		</div>
	</div>
</div>
