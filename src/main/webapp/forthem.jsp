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
	<title>List Customer</title>
	<link rel="stylesheet" type="text/css" href="css/dashboard.css">
	<link rel="stylesheet" type="text/css" href="css/button.css">
		
	<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
</head>
<body>

<div class="wrapper">
    <div class="sidebar">
         <img src="image/profile.png" style="width:50%; margin-left: 20px">
        <ul>
             
           
            <li><a href="ForProfileController?action=profile"><i class="fas fa-user"></i>Update Your Profile</a></li>
            
            <li><a href="BusController?action=forthem"><i class="fa fa-bus"></i>&nbsp;&nbsp;Book Your Bus</a></li>
            <li><a href="ForController?action=listbook"><i class="fa fa-bus"></i>&nbsp;&nbsp;View Your Ticket ID/Bus</a></li>
            <li><a href="ForController?action=book"><i class="fa fa-bus"></i>&nbsp;&nbsp;Book Here</a></li>
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
         
         <a href="ForController?action=book" class="button button4" style="float:right">ORDER YOUR TICKET HERE</a><br><br>
		<table>
    	<tr>
		<th>Bus Id </th>
		<th>Bus Status</th>
		<th>Bus Seat Number</th>
		<th>Departure date</th>
		<th>Departure time</th>
		<th>Destination</th>
		<th>Ticket Price</th> 
		
		</tr>
  
 	<c:forEach items="${buss}" var="bus" varStatus="bus1">
		<tr>
			<td><c:out value="${bus.bus_ID}"/></td>
			<td><c:out value="${bus.bus_status}"/></td>
			<td><c:out value="${bus.bus_seatNum}"/></td>
			<td><c:out value="${bus.departure_date}"/></td>
			<td><c:out value="${bus.departure_time}"/></td>
			<td><c:out value="${bus.destination}"/></td>
			<td><c:out value="${bus.ticket_price}"/></td>
		      
		  </tr>
	
  </c:forEach>
</table>
</div>
</div>
      </div>
      </div>
<script>
		function confirmation(index){
			  var bus_ID = $("#bus_ID-" + index).val();			 
			  console.log(bus_ID);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'BusController?action=deleteBus&bus_ID=' + bus_ID;
				  alert("Bus successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>	
</body>
</html>