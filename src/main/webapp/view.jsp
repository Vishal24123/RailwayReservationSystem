<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	if (session.getAttribute("name")==null){
		response.sendRedirect("booking_cancellaton.jsp");
	}
%>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Train Details</title>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
	
</head>
<body>
    <input type="hidden" id="status" value = "<%=request.getAttribute("status")%>">    
    From:<%=request.getAttribute("froms") %>
	To:<%=request.getAttribute("tos") %>  
	DATE:<%=request.getAttribute("dates") %>
	<div class="row">
   <div class="col-sm-2" style="background-color:lavender;">Train Number</div>
   <div class="col-sm-2" style="background-color:lavenderblush;">Train Name</div>
   <div class="col-sm-5" style="background-color:lavender;">Departure</div>
   <div class="col-sm-2" style="background-color:lavenderblush;">Available</div>
   <div class="col-sm-1" style="background-color:lavender;">Book Now</div>
</div> <br>

<div class="row">
		<div class="col-sm-2" style="background-color:lavender;"><%=request.getAttribute("train_number")%></div>
		<div class="col-sm-2" style="background-color:lavenderblush;"><%=request.getAttribute("train_name")%></div>
		<div class="col-sm-5" style="background-color:lavender;"><%=request.getAttribute("departure")%></div>
		<div class="col-sm-2" style="background-color:lavenderblush;"><%=request.getAttribute("available")%></div>
		<form action="tickets_booking.jsp" method="post">
		<% String userid= "Vijay";%>;
		<div class="col-sm-1" style="background-color:lavender;"><input type="submit"
                            value="Book Now">
		<%
    		session.setAttribute("froms", userid);
			session.setAttribute("tos", userid);
			session.setAttribute("dates", userid);
		
        %>
        
		<!--  <a href="tickets_booking.jsp?froms=<%=request.getAttribute("froms") %>">Book Now</a>-->
		
		</div>
		
		
</div><br>
</body>
</html>