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
	<title>Update Bus</title>
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
input[type=text],input[type=time],input[type=date], select, textarea {
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
       <input type="text" id="bus_ID" name="bus_ID" value="<c:out value="${bus.bus_ID}"/>"readonly>
      
         <label for="bus_status"><b>Bus Status</b></label>
      <input type="text"  id="bus_status" name="bus_status"  value="<c:out value="${bus.bus_status}"/>">

      <label for="bus_seatNum"><b>Bus Seat Number</b></label>
      <input type="text" id="bus_seatNum" name="bus_seatNum"  value="<c:out value="${bus.bus_seatNum}"/>">
      
      <label for="departure_date"><b>Departure Date</b></label>
      	<input type="date"  name="departure_date" value="<c:out value="${bus.departure_date}"/>">
      	
       <label for="departure_time"><b>Departure Time</b></label>
      	<input type="time"  name="departure_time"  value="<c:out value="${bus.departure_time}"/>">
      
      	<label for="destination"><b>Destination</b></label>
      	<input type="text" name="destination" value="<c:out value="${bus.destination}"/>">
      	
      	<label for="ticket_price"><b>Ticket Price</b></label>
      	<input type="text" name="ticket_price" value="<c:out value="${bus.ticket_price}"/>">
       
        <input type="submit" value="Submit">
      </form>
        </div>
	</div>
	</div>
      </div>
</body>
</html>