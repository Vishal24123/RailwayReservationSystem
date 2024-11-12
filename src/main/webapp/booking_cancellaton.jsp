<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking/Cancellation</title>
<style>
    	body {background-color: powderblue;}
		.test{
        	height:50px;
            width:200px;
            background-color: orange;
            font-style:times new roman;
            }
             </style>
</head>
<body>
	<form method="post" action="book_tickets">
		<label for="from">FROM:</label>
 	   	   <select id="from" name="from">
    	   <option value="Bengaluru">Bengaluru</option>
    	   <option value="Delhi">Delhi</option>
    	   <option value="Mumbai">Mumbai</option>
    	   <option value="Chennai">Chennai</option>
    	   <option value="Kolkata">Kolkata</option>
    	   <option value="Lucknow">Lucknow</option>
    	   <option value="Hydrabad">Hydrabad</option>
   	       <option value="Mysore">Mysore</option>
   	       <option value="Mangalore">Mangalore</option>
   	       <option value="Huballi">Hubbali</option>
    	</select><br><br>	
    
        <label for="to">TO:</label>
 			 <select id="to" name="to">
    			<option value="Bengaluru">Bengaluru</option>
    			<option value="Delhi">Delhi</option>
    			<option value="Mumbai">Mumbai</option>
    			<option value="Chennai">Chennai</option>
   			    <option value="Kolkata">Kolkata</option>
    			<option value="Lucknow">Lucknow</option>
    			<option value="Hydrabad">Hydrabad</option>
   			    <option value="Mysore">Mysore</option>
    			<option value="Mangalore">Mangalore</option>
   			    <option value="Huballi">Hubbali</option>
   			 </select><br><br>
    
  		<label for="date">DATE:</label>
  			<input type="date" id="date" name="date"><br><br>
 		 	<input type="submit" value="Submit"> <br> <br>

</form>
<form method="post" action="find_tickets">
		<input type="text" id="pnr" name="pnr">
		<button class="test" name="enquire" type="submit" >Find details using PNR</button><br><br>
		</form>	
<script type="text/javascript">
		var status = <%=request.getAttribute("fstatus")%>;
		if (status == "failed") {
			alert("No details found");
		}
	</script>		

<form method="post" action="delete_tickets">
		<input type="text" id="pnr" name="pnr">	
 		<button class="test" name="enquire" type="submit" >Cancel Tickets using PNR</button><br> <br>
 		</form>	     
<script type="text/javascript">
		var status = <%=request.getAttribute("dstatus")%>;
		if (status == "failure") {
			alert("No details found");
		}
		else (status == "success"){
			alert("Succesfully deleted");
		}
	</script>	

<form method="get" action="logout">
<button name="LogOut" class="test" type="submit">LogOut</button></form>
<script type="text/javascript">
		var status = <%=request.getAttribute("estatus")%>;
		if (status == "failed") {
			alert("No tickets available");
			}
		
	</script>
</body>
</html>