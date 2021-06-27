<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Flight</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    
<!-- fontawesome icons -->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />

<!-- Custom CSS -->
<style><%@ include file="css/style.css" %></style>

<style>
body {
	font-family: 'Mukta', sans-serif;
	height: 100vh;
	min-height: 550px;
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
}
</style>

</head>
<body style="background-image: url(https://www.imore.com/sites/imore.com/files/styles/xlarge/public/field/image/2017/02/airplane-flight-sunset.jpg?itok=8iUtkHU-);">

	<!-- header -->
	<div>
		<%@ include file="adminHeader.jsp" %>
	</div>
	
	<!-- body section -->
	<div>
		<%@ include file="addFlightCard.jsp" %>
	</div>
	
	<!-- footer -->
	<div>
		<%@ include file="footer.jsp" %>
	</div>
	
	<!-- JavaScript Code -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>
		
	<script type="text/javascript"><%@ include file="js/addFlightCard.js" %></script>

</body>
</html>



