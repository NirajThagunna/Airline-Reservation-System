<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<div class="container text-center text-white bg-dark">
<h1 style="color: red; text-decoration: underline;">Flight Details</h1>
	<h5 style="font-size: 16px;">
		Flight Number :-
		<c:out value="${flightData.getFlightNo() }"></c:out>
	</h5>
	<h5 style="font-size: 16px;">
		Flight Name :-
		<c:out value="${flightData.getFlightName() }"></c:out>
	</h5>
	<h5 style="font-size: 16px;">
		From :-
		<c:out value="${flightData.getFrom() }"></c:out>
	</h5>
	<h5 style="font-size: 16px;">
		To :-
		<c:out value="${flightData.getTo() }"></c:out>
	</h5>
	<h5 style="font-size: 16px;"> 
		Date :-
		<c:out value="${flightData.getDate() }"></c:out>
	</h5>
	<h5 style="font-size: 16px;">
		Time :-
		<c:out value="${flightData.getTime() }"></c:out>
	</h5>
	<h5 style="font-size: 16px;">
		Travel Duration :-
		<c:out value="${flightData.getTravelDuration() }"></c:out>
	</h5>
	<h5 style="font-size: 16px;">
		Airport Name :-
		<c:out value="${flightData.getAirportName() }"></c:out>
	</h5>
	<h5 style="font-size: 16px;">
		Ticket Price :-
		<c:out value="${flightData.getTicketPrice() }"></c:out>
	</h5>
</div>


<div class="container">
	<div id="signupbox" style="margin-top: 10px"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Payment Details</div>
			</div>
			<div>
				<%@ include file="successMsg.jsp"%>
			</div>
			<div class="panel-body">
				<form action="payment" method="post">
				<div id="div_id_username" class="form-group required">
					<label for="id_username"
						class="control-label col-md-4  requiredField"> Card No.<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md  textinput textInput form-control"
							id="id_username" maxlength="30" name="cardNo"
							placeholder="Enter Your Card Number"
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div id="div_id_email" class="form-group required">
					<label for="id_email" class="control-label col-md-4  requiredField">
						Card Holder Name<span class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md emailinput form-control" id="id_email"
							name="cardHolderName" placeholder="Enter Card Holder Name"
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div id="div_id_password1" class="form-group required">
					<label for="id_password1"
						class="control-label col-md-4  requiredField">Month<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control"
							id="id_password1" name="month" placeholder="MM"
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div id="div_id_password2" class="form-group required">
					<label for="id_password2"
						class="control-label col-md-4  requiredField"> Year<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control"
							id="id_password2" name="year" placeholder="YYYY"
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div id="div_id_name" class="form-group required">
					<label for="id_name" class="control-label col-md-4  requiredField">
						CVV No.<span class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control"
							id="id_name" name="cvvNo"
							placeholder="Enter CVV Number"
							style="margin-bottom: 10px" type="text" required/>
					</div>
				</div>
				<div id="div_id_name" class="form-group required">
					<label for="id_name" class="control-label col-md-4  requiredField">
						Amount to Pay<span class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control"
							id="id_name" name="amountToPay"
							value="<c:out value='${flightData.getTicketPrice()}' />"
							style="margin-bottom: 10px" type="text" required/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="aab controls col-md-4 "></div>
					<div class="controls col-md-8 ">

							<input id="btn5" type="submit" name="submit" value="Payment and Book"
								class="btn7" id="submit-id-signup" />
						or <input id="btn5" type="reset" name="reset" value="Cancel"
							class="btn8" id="button-id-signup" />
					</div>
				</div>

				</form>
			</div>
		</div>
	</div>
</div>
