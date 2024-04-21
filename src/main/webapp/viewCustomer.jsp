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
        <label for="customer_ID">Customer ID</label>: <c:out value="${cust.customer_ID}"/><br>
        <label for="customer_name">Name</label>: <c:out value="${cust.customer_name}"/><br>
        <label for="customer_phoneNum">Phone Number</label>: <c:out value="${cust.customer_phoneNum}"/><br>
        <label for="customer_email">Email</label>: <c:out value="${cust.customer_email}" /><br>
      	
        </div>
	</div>
	</div>
      </div>
</body>
</html>