<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.wyswyg.domain.Course, java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<link rel="stylesheet" href="./styles/j-theme.css" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />

<title>ZXV Learning | Created Courses</title>
</head>
<body>
	<!--  admin navbar goes here -->
	<jsp:include page="adminnavbar.html"></jsp:include>

	<div class="container-fluid">
		<!-- user information -->
		<%
		String adminName = (String) session.getAttribute("admin");
		%>
		<div class="my-3">
			<h5>
				Welcome
				<%=adminName%></h5>
			<a href="logout">Logout</a>
		</div>
		<button type="button" class="btn btn-primary btn-lg my-4">New
			Course</button>
		<div class="m-5">
			<table class="table table-sm">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Title</th>
						<th scope="col">Date Created</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Course> courses = (ArrayList<Course>) session.getAttribute("adminCourses");

					for (Course c : courses) {
						out.println("<tr><th scope='row'> <a href='courseeditor?cid=" + c.getId() + "'>" + c.getId() + "</a></th> <td>"
						+ c.getTitle() + "</td> <td>" + c.getDateCreated()
						+ "</td> <td><button type='button' id='"+c.getId()+"' class='btn btn-danger btn-sm delete-page-btn'>X</button></td></tr>");
					}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<script src="./scripts/courseeditordelete.js"></script>
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>
