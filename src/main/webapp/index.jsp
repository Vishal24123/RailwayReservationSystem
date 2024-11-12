<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
<style>
body {background-color: powderblue;}
.test{
	height:30px;
    width:100px;
    background-color: orange;
    font-style:times new roman;
    }
</style>  
</head>
<body>
	<p style="text-align:center"> Log In </p><br>
<form method="post" action="login">
<pre>
<b>Email:	  <input type="email"  name="username" id="username" placeholder="Enter the email address"/></b><br>
<b>Password: <input type="password" name="password" id="password" placeholder="Enter the password"/></b><br>
 		<input type="submit" value="Submit" name="submit"/>
<br><br>
</pre>
</form>
<b>If you are a new user please sign-up using</b><br>
<div class="test">
<p style="text-align:center"><a href="sign_up.jsp">Register</a></p><br>
</div>
<script type="text/javascript">
		var status = <%=request.getAttribute("status")%>;
		if (status == "failed") {
			alert("Invalid login credentials");
		}
	</script>
</body>
</html>