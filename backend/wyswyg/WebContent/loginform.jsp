<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.wyswyg.domain.Course, java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1" />
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!-- font awesome -->
<script src="https://kit.fontawesome.com/e4d4c44ee2.js"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="./styles/login_form.css" />
<link rel="stylesheet" href="./styles/j-theme.css" />

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />

<title>ZXV Learning | Login</title>
</head>
<body>
	<!-- admin navbar goes here-->
	<jsp:include page="adminnavbar.html"></jsp:include>

	<div class="container-fluid form-container my-5">
		<h1 class="mb-3">Sign In</h1>
		<form id="loginForm" action="login" method="POST">
			<div class="form-group">
				<label for="exampleInputUsername1">Username</label> <input
					type="text" class="form-control" id="exampleInputUsername1"
					placeholder="Enter email" name="user_username" />
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" id="exampleInputPassword1"
					placeholder="Password" name="user_password" />
			</div>
			<div class="form-check">
				<input type="checkbox" class="form-check-input show-password"
					id="exampleCheck1" /> <label class="form-check-label"
					for="exampleCheck1">Show Password</label>
			</div>

			<div class="form-check">
				<input type="checkbox" class="form-check-input remember-me"
					id="exampleCheck2" /> <label class="form-check-label"
					for="exampleCheck2">Remember Me</label>
			</div>

			<a href="http://">Forgot password or username</a><br />
			<button name="submit" type="submit"
				class="btn j-primary float-right mt-3">Login</button>
		</form>
	</div>

	<!-- Optional JavaScript -->
	<script src="./scripts/loginform.js"></script>
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>
