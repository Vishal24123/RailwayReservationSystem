<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search/Delete Using PNR </title>
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
	<form action="/action_page.php">
    	<h3>Enter The PNR Number: <input type="text" id="pnr" name="pnr" placeholder="Enter the pnr number"></h3>
    <button class="test" name="delete" type="submit">Cancel The Tickets</button> 
 	<button class="test" name="find" type="submit" >Find the Tickets</button><br>
	</form>
</body>
</html>