<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<%
String msg = (String) session.getAttribute("successMsg");

if (msg != null) {
	// show the alert msg
%>

<div class="alert alert-success" role="alert">
	<strong><%=msg %></strong>
</div>

<%
//removing the session
//It sets the value of the session as null
session.removeAttribute("successMsg");
}
%>