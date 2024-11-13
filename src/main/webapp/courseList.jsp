<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.example.model.CourseListsModel"%>
<!DOCTYPE html>
<html>
<head>
    <title>Course Lists</title>
    <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	
	<script type="text/javascript">
	    function confirmDeletion() {
	        return confirm("Are you sure you want to delete?");
	    }
	    function confirmUpdation() {
	        return confirm("Are you sure you want to update?");
	    }
	</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<h2>Welcome to Course List Page</h2>
			</div>
			<div class="col-md-2">
				<a href="adminhome.jsp"><button type="button" class="btn btn-primary">Back</button></a>
			</div>
		</div>
	</div>
    <div class="container">
    	<div class="row ">
    		<div class="col-md-2"></div>
    		<div class="col-md-8">

			    <% 
			        List<CourseListsModel> list = (List<CourseListsModel>) request.getAttribute("courses");
			    %>
			    
			
			    <table border="1">
			        <tr>
			            <th>ID</th>
			            <th>Course Name</th>
			            <th>Course Fee</th>
			            <th>Course Duration</th>
			            <th>Course Status</th>
			            <th>Modifications</th>
			        </tr>
			        <% 
			            if (list != null) {
			                for (CourseListsModel course : list) { 
			        %>
			        <tr>
			            <td><%= course.getcId() %></td>
			            <td><%= course.getCourseName() %></td>
			            <td><%= course.getCourseFee() %></td>
			            <td><%= course.getCourseDuration() %></td>
			            <td><%= course.getStatus() %>
			            <td>
							
							    <form action="coursedelete" method="post" style="display: inline;" onsubmit="return confirmUpdation();">
							        <input type="hidden" name="cid" value="<%=course.getcId() %>">
							    
									<button type="submit" >Edit</button>
								</form>
								
								<form action="deletingCourse" method="post" style="display: inline;" onsubmit="return confirmDeletion();">
									<input type="hidden" name="cid" value="<%=course.getcId() %>">
									<button type="submit">Delete</button>
								</form>
							
						</td>
			        </tr>
			        <% 
			                }
			            } else { 
			        %>
			        <tr>
			            <td colspan="4">No courses available.</td>
			        </tr>
			        <% 
			            } 
			        %>
			    </table>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>
