<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tickets booking</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
    <input type="hidden" id="status" value = "<%=request.getAttribute("status")%>">    

	<div class="container">
  <h2>Please enter the following details</h2>
  <form method="post" action="buy_tickets">

  <table class="table table-bordered">
    <tbody>
    <tr>
    <%String userid = session.getAttribute("froms").toString(); %>
    Hello<%=userid%>
        <td id="froms" name="froms">From</td>
        <td><%=userid%> </td>
      </tr>
   <tr>
        <td id="tos" name="tos">To</td>
        <td> <input type="hidden" id="tos" name="tos"><%=request.getAttribute("tos")%>  </td>
      </tr>
   <tr>
        <td id="dates" name="dates">Date</td>
        <td><input type="hidden" id="<%=request.getAttribute("dates")%>" name="<%=request.getAttribute("dates")%>"> <%=request.getAttribute("dates")%>  </td>
      </tr>
   
   
      <tr>
        <td>Firstname</td>
        <td> <input type="text" id="fname" name="fname"/> </td>
      </tr>
   
      <tr>
        <td>Lastname</td>
        <td> <input type="text" id="lname" name="lname"/> </td>
      </tr>
      
      <tr>
        <td>E-mail</td>
        <td> <input type="email" id="email" name="email"/> </td>
      </tr>
      
      <tr>
        <td>Phone</td>
        <td> <input type='tel' pattern='^\+?\d{0,13}' title='Phone Number (Format: +9 99999-99999)'/></td>
      </tr>
      
       <tr>
        <td>Type of Class</td>
        <td> <label for="type"></label>
 	   	   <select id="type" name="type">
    	   <option value="A/C Class">A/C Class</option>
    	   <option value="Non A/C class">Non A/C class</option>
    	   </select>
       </td>
      </tr>
      
       <tr>
        <td>No Of Tickets</td>
        <td><input type="number" id="quantity" name="quantity" min="0"/></td>
      </tr>
      
       <tr>
        <td>Address</td>
        <td> <input type="text" id="addr" name="addr"/> </td>
      </tr>
      
      <tr>
        <td id="tname" name="tname">Train Name</td>
        <td> <%=request.getAttribute("train_name")%>    </td>
      </tr>
      
      <tr>
        <td id="tnum" name="tnum">Train Number</td>
        <td> <%=request.getAttribute("train_number")%>    </td>
      </tr>
      
      <tr>
        <td id="departure" name="departure">Departure</td>
        <td> <%=request.getAttribute("departure")%>    </td>
      </tr>
      
    </tbody>
  </table>
  
 <p style="text-align:center"> <input type="submit" value="Book Tickets"/>  </p>
 
 </form>
 </div>
<script type="text/javascript">
		var status = <%=request.getAttribute("bstatus")%>;
		var pnr = <%=request.getAttribute("pnr")%>;
		if (status == "success") {
			alert("Congrats ,Tickets Confirmed");
			alert("Your PNR=",pnr)
			<a href="booking_cancellaton.jsp"></a>
		}
		else{
			alert("Sorry,Coudn't book tickets");
			<a href="tickets_booking.jsp"></a>
		}
	</script>
   
</body>
</html>
	
