<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.example.model.StudentModel"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script>

			function dispuser() {
				document.getElementById("user").innerHTML = "Username must be a valid email address";
			}

			function verifyuser() {
				const emailPattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
				const user = document.getElementById("username").value;
				if (emailPattern.test(user)) {
					document.getElementById("user").innerHTML = "Valid username";
					document.getElementById("user").style.color = "green";
				} else {
					document.getElementById("user").innerHTML = "Invalid username";
					document.getElementById("user").style.color = "red";
				}
			}

			function disppwd() {
				document.getElementById("pwd").innerHTML = "Password must be upper and lower case characters, digits and special symbols";
			}

			function disprepwd() {
				document.getElementById("repwd").innerHTML = "Password must be upper and lower case characters, digits and special symbols";
			}

			function verifypwd() {
				var pwd = document.getElementById("password").value;
				var repwd = document.getElementById("re-enterpwd").value;
				if (pwd == repwd) {
					document.getElementById("pwd").innerHTML = "Password and Re-password matched";
					document.getElementById("repwd").innerHTML = "Password and Re-password matched";
					document.getElementById("pwd").style.color = "green";
					document.getElementById("repwd").style.color = "green";
				} else {
					document.getElementById("pwd").innerHTML = "Password and Re-password NOT matched";
					document.getElementById("repwd").innerHTML = "Password and Re-password NOT matched";
					document.getElementById("pwd").style.color = "red";
					document.getElementById("repwd").style.color = "red";
				}
			}
			function dispmobile() {
				document.getElementById("mobileMsg").innerHTML = "Mobile number must be a valid 10-digit number";
			}
			function verifymobile(event) {
				const mobilePattern = /^\d{10}$/;
				const mobile = document.getElementById("mobile").value;
				if (mobilePattern.test(mobile)) {
					document.getElementById("mobileMsg").innerHTML = "Valid mobile number";
					document.getElementById("mobileMsg").style.color = "green";
					
				} else {
					document.getElementById("mobileMsg").innerHTML = "Invalid mobile number";
					document.getElementById("mobileMsg").style.color = "red";
					event.preventDefault();
					alert("Please enter a valid mobile number.");
				}
			}
			function validateForm(event) {
				if (!verifymobile()) {
					event.preventDefault();
					alert("Please enter a valid mobile number.");
				}
			}
			document.addEventListener("DOMContentLoaded", function() {
				var mobileInput = document.getElementById("mobile");
				mobileInput.addEventListener("input", function(event) {
					if (mobileInput.value.length > 10) {
						mobileInput.value = mobileInput.value.slice(0, 10);
						event.preventDefault();
					}
				});
			});
		</script>
</head>
<body>
	<%
		List<StudentModel> list = (List<StudentModel>) request.getAttribute("student");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h1>students edit page</h1>
			</div>
			<div class="col-md-6"></div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form class="form-group" name="myform" action="studentedit" method="post">
					<%
					// Assuming you want to populate the form with the first course in the list
					StudentModel student = list != null && !list.isEmpty() ? list.get(0) : null;
					%>

					<!-- Hidden field for the Course ID -->
					<input type="hidden" name="sid"
						value="<%=student != null ? student.getSId() : ""%>" />
					<div class="form-group">
						<label for="firstname">First Name:</label>
						 <input type="text" class="form-control" id="firstname" name="firstname" 
						 value="<%=student != null ? student.getFname() : ""%>" 
						 placeholder="*First name" required>
					</div>
					<div class="form-group">
						<label for="lastname">Last Name:</label> 
						<input type="text" class="form-control" id="lastname" name="lastname" 
						value="<%=student != null ? student.getLname() : ""%>" placeholder="Last name">
					</div>
					<div class="form-group">
						<label for="username">Username:</label> 
						<input type="text" class="form-control" onfocus="dispuser()" onblur="verifyuser()" 
						id="username" name="username" 
						value="<%=student != null ? student.getUsername() : ""%>" 
						placeholder="*Username" required>
						<p id="user"></p>
					</div>
					<div class="form-group">
						<label for="password">Password:</label> 
						<input type="password" onfocus="disppwd()" onblur="verifypwd()" 
						class="form-control" id="password" name="password" placeholder="*Password" required>
				    <!-- Password is generally not pre-filled for security reasons -->
						<p id="pwd"></p>
					</div>
					<div class="form-group">
						<label for="re-enterpwd">Confirm Password:</label> 
						<input
							type="password" onfocus="disprepwd()" onblur="verifypwd()"
							class="form-control" id="re-enterpwd" name="re-enterpwd"
							placeholder="*Confirm Password" required>
						<p id="repwd"></p>
					</div>
					<div class="form-group">
						<label for="mobile_no">Mobile Number:</label> 
						<input type="text"
							onfocus="dispmobile()" onblur="verifymobile(event)"
							class="form-control" id="mobile" name="mobile"  
							value="<%=student != null ? student.getMobile() : ""%>"
							placeholder="*Mobile Number" required>
						<p id="mobileMsg"></p>
					</div>
					<div class="form-group">
						<label for="gender">Gender:</label> 
						<select class="form-control" id="gender" name="gender">
						    <option>Select Gender</option>
						    <option value="Male" <%=student != null && "Male".equals(student.getGender()) ? "selected" : ""%>>Male</option>
						    <option value="Female" <%=student != null && "Female".equals(student.getGender()) ? "selected" : ""%>>Female</option>
						    <option value="Other" <%=student != null && "Other".equals(student.getGender()) ? "selected" : ""%>>Other</option>
						</select>
					</div>
					<div class="form-group">
						<label for="course">Course:</label> 
						<select class="form-control" id="course" name="course" required>
							<option>Select Course</option>
							<%! Connection con; %>
							<%
								try {
									Class.forName("com.mysql.cj.jdbc.Driver");
									con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vcube1", "root", "root");
									PreparedStatement ps = con.prepareStatement("SELECT * FROM courses");
									ResultSet rs1 = ps.executeQuery();
									
									while (rs1.next()) {
								%>
								<option value="<%=rs1.getInt("cId")%>"><%=rs1.getString("courseName")%></option>
								<%
								}
								} catch (Exception e) {
								System.out.println("No courses are Available"); // Log the error in production
								} 
								finally{
									con.close();
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<label for="address">Current Address:</label> 
						<input type="text" class="form-control" id="address" name="address" 
						value="<%=student != null ? student.getAddress() : ""%>" 
						placeholder="*Address" required>
					</div>
					<div class="form-group">
					    <label for="degree">Degree :</label>
					    <select class="form-control" id="degree" name="degree" required>
					        <option>Select degree</option>
					        <option value="B tech" <%=student != null && "B tech".equals(student.getDegree()) ? "selected" : ""%>>B tech</option>
					        <option value="M tech" <%=student != null && "M tech".equals(student.getDegree()) ? "selected" : ""%>>M tech</option>
					        <option value="MCA" <%=student != null && "MCA".equals(student.getDegree()) ? "selected" : ""%>>MCA</option>
					        <option value="B com" <%=student != null && "B com".equals(student.getDegree()) ? "selected" : ""%>>B com</option>
					    </select>
					</div>
						<div class="form-group">
							<label for="specialization">Specialization :</label>
							<input type="text" class="form-control" id="specialization" 
							name="specialization" value="<%=student != null ? student.getSpecialization() : ""%>"  
							placeholder="*specialization" required>
						</div>
						<div class="form-group">
						    <label for="year_of_passed">Year of Passed:</label>
						    <select class="form-control" id="year_of_passed" name="year_of_passed" required>
						        <option>Select year</option>
						        <option value="2024" <%=student != null && "2024".equals(student.getPassingYear()) ? "selected" : ""%>>2024</option>
						        <option value="2023" <%=student != null && "2023".equals(student.getPassingYear()) ? "selected" : ""%>>2023</option>
						        <option value="2022" <%=student != null && "2022".equals(student.getPassingYear()) ? "selected" : ""%>>2022</option>
						        <option value="2021" <%=student != null && "2021".equals(student.getPassingYear()) ? "selected" : ""%>>2021</option>
						        <option value="2020" <%=student != null && "2020".equals(student.getPassingYear()) ? "selected" : ""%>>2020</option>
						    </select>
						</div>
						<div class="form-group">
							<label for="course">Status:</label>
							<select class="form-control" id="status" name="status" required>
								<option >Select status</option>
								<option value="Active" <%=student != null && "Active".equals(student.getStatus()) ? "selected" : ""%>>Active</option>
								<option value="Inactive" <%=student != null && "Inactive".equals(student.getStatus()) ? "selected" : ""%>>Inactive</option>
							</select>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>