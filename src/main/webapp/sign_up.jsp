<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-Up </title>
<style>
     body{
     background-color:#725b79;}
  </style>
</head>

<body>
	<h2>Create Your Account</h2>
    <form method="post"  action="register">
	<table cellspacing="2" align="center" cellpadding="8" border="2" style="width:80%">
	<tr style="height:100px">
	<td align="right"> Name :</td>
	<td><input type="text" name="name" id="name" placeholder="Enter Name"/></td>
	</tr>
	<tr style="height:100px">
	<td align="right"> Phone Number :</td>
	<td><input type="text" name="phone" id="phone" placeholder="Enter Phone Number "/></td>
	</tr>
	<tr style="height:100px">
	<td align="right"> Email ID  :</td>
	<td><input type="text" name="email" id="email" placeholder="Enter Email ID "/></td>
	</tr>
	<tr style="height:100px">
	<td align="right"> Password :</td>
	<td><input type="password" name="pass1" id="pass1" placeholder="Enter Password "/></td>
	</tr>
	<tr style="height:100px">
	<td align="right"> Confirm Password :</td>
	<td><input type="password" name="pass2" id="pass2" placeholder="Re-Enter Password "/></td>
	</tr>
  </table>
  <pre>
  			   <input type="reset" value="Clear Form" />   		<input type="submit" value="Create Account" />
  </pre>
  </form>
  <script type="text/javascript">
  var status = <%=request.getAttribute("rstatus")%>;
	if (status == "failure") {
		alert("Unable to create an account");
	}
	else if (status == "success")
		{
		alert("Succesfully created an account");
		}
	else if(status == "password mismatch"){
		alert("Password mismatch");
	}
  </script>
</body>
</html>