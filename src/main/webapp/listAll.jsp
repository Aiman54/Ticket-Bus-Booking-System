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
	<title>List All</title>
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
        <div class="info">
        <div class="container">
	<%	String email = (String)session.getAttribute("sessionEmail");%>
	Welcome <b> <%= email %> </b>
</div>
		<table>
    	<tr>

    	<th>Ticket Id </th>
		<th>Customer ID</th>
		<th></th>
		<th>Bus ID</th>
		<th>Destination</th>
		<th>Departure Date</th>
		<th>Departure Time</th>
		
		
		</tr>
		
		
		
			<c:forEach items="${books}" var="a">
			<tr>
			<td><c:out value="${a.ticket_ID}"/></td>
			<td><c:out value="${a.customer_ID}"/></td>
			<td><c:out value="${a.customer.customer_name}"/></td>
			<td><c:out value="${a.bus_ID}"/></td>
			<td><c:out value="${a.bus.destination}"/></td>
			<td><c:out value="${a.bus.departure_time}"/></td>
			<td><c:out value="${a.bus.departure_date}"/></td>  
			    
			</tr>
   			</c:forEach>
   			
   			
   			
   			

</table>
</div>
</div>
      </div>
<script>
$(document).ready(function() {
    $('#list').DataTable();
} );
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>	
</body>
</html>