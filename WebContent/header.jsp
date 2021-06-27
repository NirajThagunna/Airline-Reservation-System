<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="/AirlineReservationSystem"><i
			class="fas fa-plane-departure" id="icon"></i></a>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/AirlineReservationSystem"><i
						class="fas fa-home text-primary"></i>&nbsp;Home</a></li>
				<li class="nav-item"><a class="nav-link text-white" href="flight"><i
						class="fas fa-plane text-info"></i>&nbsp;Flight</a></li>

				<li class="nav-item"><a class="nav-link text-white"
					href="registration.jsp"><i class="fas fa-sign-in-alt"
						style="color: #70ffff;"></i>&nbsp;Login</a></li>

				<%
				String message = (String) session.getAttribute("username");

				if (message != null) {
					// show the alert msg
				%>

				<li class="nav-item"><a class="nav-link text-white"
					href="/AirlineReservationSystem/logout"><i class="fas fa-sign-out-alt"
						style="color: #70ffff;"></i>&nbsp;Logout</a></li>

				<%
				}
				%>

			</ul>
		</div>
	</div>
</nav>


