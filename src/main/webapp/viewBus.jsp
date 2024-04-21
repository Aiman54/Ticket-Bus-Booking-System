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
	<title>View Bus</title>
	<link rel="stylesheet" type="text/css" href="css/dashboard.css">
		<link rel="stylesheet" type="text/css" href="css/button.css">
		
	<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
	
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
        <label for="bus_ID">Bus ID</label>: <c:out value="${bus.bus_ID}"/><br>
        <label for="bus_status">Bus Status</label>: <c:out value="${bus.bus_status}"/><br>
        <label for="bus_seatNum">Bus Seat Number</label>: <c:out value="${bus.bus_seatNum}"/><br>
        <label for="departure_time">Departure Time</label>: <c:out value="${bus.departure_time}"/><br>
    	<label for="departure_date">Departure Date</label>: <c:out value="${bus.departure_date}"/><br>    	
    	<label for="destination">Destination</label>: <c:out value="${bus.destination}"/><br>	
      	<label for="ticket_price">Ticket Price</label>: <c:out value="${bus.ticket_price}" /><br><br>
      	<a href="BusController?action=listBus" class="button button1">Bus List</a>   	
        </div>
	</div>
	</div>
      </div>
</body>
</html>