<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.example.model.CourseModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<h1>Course Details</h1>

	<% 
		List<CourseModel> list = (List<CourseModel>) request.getAttribute("courses");
	%>


	

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h1>Courses edit page</h1>
			</div>
			<div class="col-md-6"></div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form class="form-group" name="myform" action="edit" method="post">
					<% 
                        // Assuming you want to populate the form with the first course in the list
                        CourseModel course = list != null && !list.isEmpty() ? list.get(0) : null;
                    %>

					<!-- Hidden field for the Course ID -->
					<input type="hidden" name="cid"
						value="<%= course != null ? course.getcId() : "" %>" />
						
						
					<div class="form-group">
						<label for="coursename">Course Name:</label>
						 <input type="text"
							class="form-control" id="coursename" name="coursename"
							value="<%= course != null ? course.getCourseName() : "" %>"
							placeholder="*course name" required>

					</div>
					<div class="form-group">
						<label for="coursefee">Course Fee:</label>
						 <input type="text"
							class="form-control" id="coursefee" name="coursefee"
							value="<%= course != null ? course.getCourseFee() : "" %>"
							placeholder="* course fee" required>

					</div>
					<div class="form-group">
						<label for="courseduration">Course Duration:</label> 
						<input type="text" class="form-control" id="courseduration" name="courseduration"
							value="<%= course != null ? course.getCourseDuration() : "" %>"
							placeholder="* course duration" required>
					</div>
					<div class="form-group">
							<label for="course">Status:</label>
							<select class="form-control" id="status" name="courseStatus" required>
								<option >Select status</option>
								<option value="Active" <%=course != null && "Active".equals(course.getStatus()) ? "selected" : ""%>>Active</option>
								<option value="Inactive" <%=course != null && "Inactive".equals(course.getStatus()) ? "selected" : ""%>>Inactive</option>
							</select>
					</div>
					<button type="submit" class="btn btn-success">submit</button>

				</form>
			</div>
		</div>
	</div>
</body>
</html>
