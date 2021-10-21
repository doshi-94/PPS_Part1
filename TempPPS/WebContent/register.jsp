<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

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
  background-color: red;
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
.required {
  color: red;
}
</style>

<script>  
function matchPassword() {  
	var pw1 = document.getElementById("password").value;
    var pw2 = document.getElementById("confirmpassword").value;
   
 
  
    //check empty password field
    if(pw1 == "") {
      document.getElementById("message1").innerHTML = "**Fill the password please!";
      return false;
    }
  
    //check empty confirm password field
    if(pw2 == "") {
      document.getElementById("message2").innerHTML = "**Enter the password please!";
      return false;
    } 

    if(pw1 != pw2) {
      document.getElementById("message2").innerHTML = "**Passwords are not same";
      return false;
    } else {
      alert ("Your password created successfully");
     
    }
 
}  
</script>  

</head>
<body>
	<!-- <form action="register" method = "post"> -->
	<form onsubmit ="return matchPassword()" action = "register" method="post">
	
	 <div class="container">
		<h1>Registration</h1>
		<p>Already Registered? <a href = "login.jsp"> Login</a> </p>
		<span style="font-size:12px; font-style : italic;">Required fields</span><span class="required">*</span><br><br>
		First Name<span class="required">*</span>:<br> <input type= "text" placeholder="Your first name" name = "firstname" required><br>
		Last Name<span class="required">*</span>: <br><input type= "text" placeholder="Your Last Name" name = "lastname" required><br>
		
		<label for="birthday">Birthday:</label><br>
	  <input type="date" id="birthday" name="birthday"><br><br>
			
		Address<span class="required">*</span>:<br> <input type= "text" placeholder="street number" name = "streetnumber" required><br>
		<input type= "text" placeholder="street name" name = "streetname" required><br>
		<input type= "text" placeholder="city" name = "city" required><br>
		<input type= "text" placeholder="state" name = "state" required><br>
		<input type= "text" placeholder="zipcode" name = "zipcode" required><br>
		 <label for="email">Email ID<span class="required">*</span>:</label><br>
    <input type="text" placeholder="Enter Email" name="emailid" id="email" required><br>
		<!-- Email ID : <input type= "email" placeholder="Enter Email Id" name = "emailid"><br><br> -->
		Password<span class="required">*</span> : <br><input type= "password" placeholder="Your password" name = "password" id = "password" required><br>
		<span id = "message1" style="color:red"> </span>
		Confirm Password<span class="required">*</span> : <br><input type= password placeholder="Confirm your password" name = "confirmpassword" id = "confirmpassword" required><span id = "message2" style="color:red"> </span><br><br>
		
		
		<input type="submit" name = "submit" class="registerbtn" value = "Register" style= "background-color: green;"> 
		<input type = "reset" name = "reset" class="registerbtn" value = "Cancel">
		</div>
		
	</form>
	
</body>
</html>