<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Using JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    
<!-- fontawesome icons -->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />

<!-- Custom CSS -->
<style><%@ include file="css/style.css" %></style>

</head>
<body>

	<!-- Header Section -->
	<% 
	String msg = (String)session.getAttribute("username1");
	String msg1 = (String)session.getAttribute("username");
	
	if (msg != null) {
	%>
	<div>
		<%@ include file="adminHeader.jsp"%>
	</div>
	
	<!-- Body Section -->
	<div>
		<%@ include file="admin-flight-list-card.jsp" %>
	</div>
	
	<%} else if (msg1 != null) { %>
	<div>
		<%@ include file="header.jsp" %>
	</div>
	
	<!-- Body Section -->
	<div>
		<%@ include file="flight-list-card.jsp" %>
	</div>
	
	<%} else {%>
	<div>
		<%@ include file="header.jsp" %>
	</div>
	
	<!-- Body Section -->
	<div>
		<%@ include file="flight-list-card.jsp" %>
	</div>
	<%} %>
	
	<!-- Footer Section -->
	<div id="footer">
		<%@ include file="footer.jsp" %>
	</div>

	<!-- JavaScript Code -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>
	

</body>
</html>



