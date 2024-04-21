<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form </title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Register</h2>
	<div class="register-form" id="register-form">				
	<form action="RegisterController" method="POST">
		
		<div class="form-group">
		<label for="email"><i class="zmdi zmdi-email"></i></label> 
		<input type="email" name="email" id="email" placeholder="Your Email" />
		</div>
		<div class="form-group">
		<label for="password"><i class="zmdi zmdi-lock"></i></label> 
		<input type="password" name="password" id="password" placeholder="Password" />
		</div>
		
		<div class="form-group">
		<label for="role"><i class="zmdi zmdi-lock"></i></label>  
    	<input type="radio" id="role" name="role" value="staff"> Staff<br>
    	<input type="radio" id="role" name="role" value="customer">Customer
    	</div>
		
		
		<div class="form-group form-button">
		<input type="submit" name="signup" id="signup" class="form-submit" value="Register" />
		</div>
		</form>
		</div>
		</div>
		<div class="signup-image">
		<figure>
		<img src="image/signup-image.jpg" alt="sing up image">
		</figure>
		<a href="login.jsp" class="signup-image-link">I am already member</a>
		</div>
		</div>
		</div>
		</section>


	</div>
	
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>



</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>