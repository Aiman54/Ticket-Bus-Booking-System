<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%
  response.addHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
  response.setDateHeader("Expires", 0);
  
  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<style>
body {
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
  
}


* {
  box-sizing: border-box;
}

.topnav {
  margin: auto;
  overflow: hidden;
  background-color: gray;
  
}

.topnav a {
  float: left;
  color: #f2f2f2;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
  margin: auto;
}

.topnav a:hover {
  background-color: #ddd;
  color: white;
  margin: auto;
  
}
.topnav-right {
  float: right;
}


.topnav a.active {
  background-color: orange;
  color: white;
  margin: auto;
  
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 50px;
  box-shadow: 0px 5px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
.bg-img {
  /* The image used */
  background-image: url("image/buscv.jpg");
  padding:10px;
  min-height: 580px;
  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

/* Add styles to the form container */
.container {
  position: absolute;
  left: 520px;
  margin: 0;
  max-width: 400px;
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=email], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit button */
.btn {
  background-color: orange;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}
</style>
</head>
<body>

<div class="topnav">
  <a class="active" href="#home">Home</a>
  <a href="#about">About</a>
  <a href="#services">Services</a>
  <a href="#contact">Contacts</a>
  <div class="topnav-right">
    <div class="dropdown">
    <button class="dropbtn">Sign Up 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
     <button class="open-button" onclick="openForm()" style="width:auto;">Log In</button>
    </div>
  </div> 
  </div>
</div>
<div class="bg-img">
  <h1 style="color:black; text-align:center;" >Ticket Bus Online System</h1>
  
  
  <div class="form-popup" id="myForm">
  <div class =" form-container" >
 <form action="LoginController" method="post">
  <h1>Login</h1>

    <label for="email"><b>Email</b></label>
    <input type="email" id="email" name="email"  placeholder="Enter Email" required>

    <label for="password"><b>Password</b></label>
    <input type="password" id="password" name="password" placeholder="Enter Password"required>

    <button type="submit" class="btn">Login</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button><br><br>
    
     <p style="color:black; text-align:center;">Not Registerd yet?</p>
    <a href="registration.jsp"><center>Register here</center></a>

  </form>
  </div>
  </div>
</div>
<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}

</script>
</body>
</html>
