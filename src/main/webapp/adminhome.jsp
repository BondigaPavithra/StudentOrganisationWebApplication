<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<a href="course.jsp"><button type="button" class="btn btn-primary">add
									courses</button></a>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-12">
							<a href="student.jsp"><button type="button" class="btn btn-primary">add
									students</button></a>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-12">

							<a href="faculty.jsp"><button type="button" class="btn btn-primary">add
									faculty</button></a>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-12">
							<form action="CourseListsServlet" method="post">
								<button type="submit" class="btn btn-primary">Course
									Lists</button>
							</form>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-12">
							<form action="StudentListsServlet" method="post">
								<button type="submit" class="btn btn-primary">Student
									Lists</button>
							</form>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-12">
							<form action="FacultyListsServlet" method="post">
								<button type="submit" class="btn btn-primary">Faculty
									Lists</button>
							</form>
						</div>
					</div>
					<br>

				</div>
			</div>
			<div class="col-md-8">
				<h3>
					welcome to admin home page:<%= session.getAttribute("username")%></h3>
			</div>
		</div>
	</div>


</body>
</html>