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

<link rel="stylesheet" href="styles/index.css" />
<link rel="stylesheet" href="styles/j-theme.css" />
<link rel="stylesheet" href="./styles/loadingspinner.css" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />

<title>ZXV Learning | Index</title>
</head>
<body>
	<!-- navbar goes here -->
	<jsp:include page="navbar.html" />

	<div class="container my-4">

		<!-- search box -->
		<jsp:include page="searchbox.html" />

		<!-- course cards -->
		<div class="row">
			<div class="col-12">
				<div class="card-deck">
					<!-- 4-card row -->
					<%
					List<Course> allCourseList = (ArrayList<Course>) request.getAttribute("courseList");

					if (allCourseList == null) {
						out.println("<div><i class='fa-solid fa-circle-xmark'></i> Unable to load courses. Please try again later.</div>");

					} else {
						Iterator<Course> it = allCourseList.iterator();
						Course c = null;
						while (it.hasNext()) {
							c = it.next();
							out.println("<div id='" + c.getId() + "' class='card'>\r\n" + "<img\r\n"
							+ " src='https://placeimg.com/640/480/tech'\r\n" + "	class='card-img-top img-adjusted'\r\n"
							+ "/> \r\n" + "	<div class='card-body'><b>" + c.getTitle() + "</b><p>" + c.getDateCreated()
							+ "</p></div> </div>");
						}
					}
					%>
				</div>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<script src="scripts/index.js"></script>
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
