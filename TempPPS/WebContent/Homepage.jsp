<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PPS System</title>
</head>
<body>
<p align = 'right'><a href = 'Index.jsp'>Log out</a></p>
  <%
  //out.println("Login Successful!!!");
	
       	String emailid = (String)request.getSession().getAttribute("emailid");
  		String firstname =(String)request.getSession().getAttribute("firstname");
  		
  		
    %>
    <h5>
        Email ID :
        <%=emailid%>
        <p>
       First Name :<%=firstname %>
        </p>
    </h5>
<h1 align="center">Welcome to PPS Crypto System!!!</h1>



</body>
</html>