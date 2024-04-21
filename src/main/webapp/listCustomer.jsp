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
		<th>Customer Id </th>
		<th>Name  </th>
		<th>Phone Number</th>
		<th>Customer Email</th> 
		<th>Action</th>
		</tr>
  
 	<c:forEach items="${users}" var="us" varStatus="customers">
		<tr>
			<td><c:out value="${us.customer.customer_ID}"/></td>
			<td><c:out value="${us.customer.customer_name}"/></td>
			<td><c:out value="${us.customer.customer_phoneNum}"/></td>
			<td><c:out value="${us.customer.customer_email}" /></td>
		    <td><a href="CustomerController?action=viewCustomer&customer_ID=<c:out value="${us.customer.customer_ID}" />" class="button button1">View</a></td>
		    <td><a href="CustomerController?action=updateCustomer&customer_ID=<c:out value="${us.customer.customer_ID}" />" class="button button2">Update</a></td>
		    <td><input type="hidden" id="id-${customers.index}" value="<c:out value="${us.id}"/>"><button class="button button3" onclick="confirmation('${customers.index}')">Delete</button></td>    
		  </tr>
		
  </c:forEach>
</table>
</div>
</div>
      </div>
      </div>
<script>
		function confirmation(index){					  
			  var id = $("#id-" + index).val();			 
			  console.log(id);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'CustomerController?action=deleteCustomer&id=' + id;
				  alert("Customer successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>	
</body>
</html>