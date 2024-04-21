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
        <div class="container"> 
        <div class="info">
        <form action="ForProfileController" method="POST">  
         <i class="fa fa-user" aria-hidden="true" style="font-size:20px;"></i>&nbsp;<label for="customer_name">Name</label><br>
        <input type="text" id="customer_name" name="customer_name" value="<c:out value="${cust.customer_name}"/>"><br>
        <i class="fa fa-phone" aria-hidden="true" style="font-size:20px;"></i>&nbsp;<label for="customer_phoneNum">Phone Number</label><br>
        <input type="text" id="customer_phoneNum" name="customer_phoneNum" value="<c:out value="${cust.customer_phoneNum}"/>"><br>
        <i class="fa fa-address-card" aria-hidden="true" style="font-size:20px;"></i>&nbsp;<label for="customer_email">Email</label><br>
        <input type="text" id="customer_email" name="customer_email"value="<c:out value="${cust.customer_email}"/>"><br>
        <i class="fa fa-users" aria-hidden="true" style="font-size:20px;"></i>&nbsp;<label for="customer_ID">Customer ID</label>
        <input type="number" id="customer_ID" name="customer_ID" value="<c:out value="${cust.customer_ID}"/>" readonly>
        

        <input type="submit" value="Submit">
      </form>
        </div>
	</div>
	</div>
      </div>
</body>
</html>