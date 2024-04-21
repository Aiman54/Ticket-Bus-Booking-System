<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
  response.addHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
  response.setDateHeader("Expires", 0);

  if(session.getAttribute("sessionEmail")==null)	  
      response.sendRedirect("/Proposal/login.jsp");
  %>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Side Navigation Bar</title>
	<link rel="stylesheet" type="text/css" href="css/dashboard.css">
		
	<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
	<style>
body{
   background-color: #f3f5f9;
}

* {
  box-sizing: border-box;
}

/* Style inputs */	
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}
input[type=number]{
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4b4276;
  color: white;
  padding: 12px 20px;
  border: none;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

/* Style the container/contact section */
.container {
  border-radius: 5px;
  padding: 50px;
}

</style>
	</head>
	<body>

	<div class="wrapper">
    <div class="sidebar">
       <img src="image/profile.png" style="width:50%; margin-left: 20px">
        <ul>
          <li><a href="BookingController?action=listAll"><i class="fas fa-home"></i>Home</a></li>
            <li><a href="CustomerController?action=listCustomer"><i class="fas fa-user"></i>Customers</a></li>
            <li><a href="BusController?action=listBus"><i class="fa fa-bus"></i>&nbsp;&nbsp;Bus</a></li>
            <li><a href="BookingController?action=listBooking"><i class="fas fa-project-diagram"></i>Bookings</a></li>

        </ul> 
        <div class="social_media">
          <a href="#"><i class="fab fa-facebook-f"></i></a>
          <a href="#"><i class="fab fa-twitter"></i></a>
          <a href="#"><i class="fab fa-instagram"></i></a>
      </div>
    </div>
    <div class="main_content">
        <div class="header">Welcome!! </div> 
        <div class="container"> 
        <div class="info">
        
        <form action="BusController" method="POST">  
        <label for="bus_ID"><b>Bus ID</b></label>
      <input type="number" placeholder="Bus ID..." name="bus_ID">
      
      <label for="bus_status"><b>Bus Status</b></label>
      <input type="text" placeholder="Bas Status.." name="bus_status">

      <label for="bus_seatNum"><b>Bus Seat Number</b></label>
      <input type="text" placeholder="Bus Seat Number..." name="bus_seatNum">
      
       <label for="customer_ID"><b>Customer ID</b></label>
      <input type="number" name="customer_ID" placeholder="Customer Id..">
        

        <input type="submit" value="Submit">
      </form>
        </div>
	</div>
	</div>
      </div>
</body>
</html>