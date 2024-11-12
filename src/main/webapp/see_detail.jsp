<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details Of PNR</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>


<body>
	
<div class="container">
  <h2>Details of the Jouney</h2>
  <table class="table table-bordered">
    <tbody>
    	<tr>
        <td>From</td>
        <td> <%=request.getAttribute("froms")%> </td>
      </tr>
      <tr>
        <td>To</td>
        <td> <%=request.getAttribute("tos")%> </td>
      </tr>
      <tr>
        <td>Date</td>
        <td> <%=request.getAttribute("dates")%> </td>
      </tr>
      <tr>
        <td>Firstname</td>
        <td> <%=request.getAttribute("fname")%> </td>
      </tr>
   
      <tr>
        <td>Lastname</td>
        <td> <%=request.getAttribute("lname")%> </td>
      </tr>
      
      <tr>
        <td>E-mail</td>
        <td><%=request.getAttribute("email")%> </td>
      </tr>
      
      <tr>
        <td>Phone</td>
        <td> <%=request.getAttribute("phone")%></td>
      </tr>
      
       <tr>
        <td>Type of Class</td>
        <td> <%=request.getAttribute("classtype")%></td>
      </tr>
      
       <tr>
        <td>No Of Tickets</td>
        <td><%=request.getAttribute("ntickets")%></td>
      </tr>
      
       <tr>
        <td>Address</td>
        <td> <%=request.getAttribute("address")%> </td>
      </tr>
      
      <tr>
        <td>PNR</td>
        <td> <%=request.getAttribute("pnr")%> </td>
      </tr>
      
      <tr>
        <td>Train Name</td>
        <td> <%=request.getAttribute("tname")%> </td>
      </tr>
      
      <tr>
        <td>Train Number</td>
        <td> <%=request.getAttribute("tnum")%> </td>
      </tr>
      
      <tr>
        <td>Departure</td>
        <td> <%=request.getAttribute("departure")%> </td>
      </tr>
      
    </tbody>
  </table>
</div>
<p style="text-align:center"> <a href="booking_cancellaton.jsp">Back</a></p>
</body>
</html>