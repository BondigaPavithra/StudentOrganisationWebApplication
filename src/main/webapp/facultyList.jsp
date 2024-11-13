<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.example.model.FacultyModel"%>
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
				<h2>Faculty List Page</h2>
			</div>
			<div class="col-md-2">
				<a href="adminhome.jsp"><button type="button" class="btn btn-primary">Back</button></a>
			</div>
		</div>
	</div>
	<% 
        List<FacultyModel> list = (List<FacultyModel>) request.getAttribute("faculty");
    %>


	<table border="1">
		<tr>
			<th>FID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Username</th>
			<th>Password</th>
			<th>Mobile</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Year of Experience</th>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Faculty Status</th>
			<th>Modifications</th>
		</tr>
		<% 
            if (list != null) {
                for (FacultyModel fm : list) { 
        %>
        <tr>
        	<td><%= fm.getfId() %></td>
        	<td><%= fm.getFname() %></td>
        	<td><%= fm.getLname() %></td>
        	<td><%= fm.getUsername() %></td>
        	<td><%= fm.getPassword() %></td>
        	<td><%= fm.getMobile() %></td>
        	<td><%= fm.getGender() %></td>
        	<td><%= fm.getAddress() %></td>
        	<td><%= fm.getYear_of_exp() %></td>
        	<td><%= fm.getCid() %></td>
        	<td><%= fm.getCourseName() %></td>
        	<td><%= fm.getStatus() %>
        	<td>
				<p>
					<form action="updating" method="post" style="display: inline;" onsubmit="return confirmUpdation();">
						<input type="hidden" name="fid" value="<%= fm.getfId() %>">
						<button type="submit">Edit</button>
					</form>
					<form action="facultydeleting" method="post" style="display: inline;" onsubmit="return confirmDeletion();">
						<input type="hidden" name="fid" value="<%= fm.getfId() %>">
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
			<td colspan="4">No faculty available.</td>
		</tr>
		<% 
            } 
        %>
	</table>
</body>
</html>