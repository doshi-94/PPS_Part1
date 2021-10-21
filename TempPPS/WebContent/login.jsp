<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
  width : 50%;
  
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 50%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: blue;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 20%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>

</head>
<body>

	<form action="login" method ="post" >
	 <div class="container">
		<h1>Login</h1>
		 <label for="email">Email ID*:</label><br>
   	 <input type="text" placeholder="Enter Email id" name="emailid" id="email" required><br><br>
		Password* : <br><input type= "password" placeholder="your password" name = "password" required><br><br>
		<p>Forgot password? <a href = "forgotpass.jsp">click here</a></p>
		<input type="submit" name = "submit" class= "registerbtn" value = "Login">
		<br><br>
		<p>Not Yet Registered? <a href = "register.jsp"> Register Here!</a> </p>
		</div>
	</form>
</body>
</html>