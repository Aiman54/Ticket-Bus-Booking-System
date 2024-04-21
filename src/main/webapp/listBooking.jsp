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
         
         
		<table>
    	<tr>
		<th>Ticket Id </th>
		<th>Customer Id</th>
		<th>Bus Id</th> 
		<th>Action</th>
		</tr>
  
 	<c:forEach items="${books}" var="book" varStatus="books1">
		<tr>
			<td><c:out value="${book.ticket_ID}"/></td>
			<td><c:out value="${book.customer_ID}"/></td>
			<td><c:out value="${book.bus_ID}"/></td>
		    <td><a href="BookingController?action=viewBooking&ticket_ID=<c:out value="${book.ticket_ID}" />" class="button button1">View</a></td>
		    <td><a href="BookingController?action=updateBooking&ticket_ID=<c:out value="${book.ticket_ID}" />" class="button button2">Update</a></td>
		    <td><input type="hidden" id="ticket_ID-${books1.index}" value="<c:out value="${book.ticket_ID}"/>"><button class="button button3" onclick="confirmation('${books1.index}')">Delete</button></td>    
		  </tr>
	
  </c:forEach>
</table>
</div>
</div>
      </div>
      </div>
<script>
		function confirmation(index){
			  var ticket_ID = $("#ticket_ID-" + index).val();			 
			  console.log(ticket_ID);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'BookingController?action=deleteBooking&ticket_ID=' + ticket_ID;
				  alert("Booking successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>	
</body>
</html>