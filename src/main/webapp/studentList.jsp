<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.example.model.StudentModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				<h2>Students List Page</h2>
			</div>
			<div class="col-md-2">
				<a href="adminhome.jsp"><button type="button" class="btn btn-primary">Back</button></a>
			</div>
		</div>
	</div>
	
	<% 
        List<StudentModel> list = (List<StudentModel>) request.getAttribute("student");
    %>


	<table border="1">
		<tr>
			<th>SID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Username</th>
			<th>Password</th>
			<th>Mobile</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Degree</th>
			<th>Specialization</th>
			<th>PassingYear</th>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Student Status</th>
			<th>Modifications</th>
		</tr>
		<% 
            if (list != null) {
                for (StudentModel sm : list) { 
        %>
		<tr>
			<td><%= sm.getSId() %></td>
			<td><%= sm.getFname() %></td>
			<td><%= sm.getLname() %></td>
			<td><%= sm.getUsername() %></td>
			<td><%= sm.getPassword() %></td>
			<td><%= sm.getMobile() %></td>
			<td><%= sm.getGender() %></td>
			<td><%= sm.getAddress() %></td>
			<td><%= sm.getDegree() %></td>
			<td><%= sm.getSpecialization() %></td>
			<td><%= sm.getPassingYear() %></td>
			<td><%= sm.getCid() %></td>
			<td><%= sm.getCourseName() %></td>
			<td><%= sm.getStatus() %>
			<td>
				<p>
					<form action="studentupdating" method="post" style="display: inline;" onsubmit="return confirmUpdation();">
						<input type="hidden" name="sid" value="<%= sm.getSId() %>">
						<button type="submit">Edit</button>
					</form>
					<form action="studentDeleting" method="post" style="display: inline;" onsubmit="return confirmDeletion();">
						<input type="hidden" name="sid" value="<%= sm.getSId() %>">
						<button type="submit" >Delete</button>
					</form>
				</p>
			</td>
			
		</tr>
		<% 
                }
            } else { 
        %>
		<tr>
			<td colspan="4">No students available.</td>
		</tr>
		<% 
            } 
        %>
	</table>
</body>
</html>