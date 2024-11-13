<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<title>Faculty Registration Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
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
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h3>Faculty Registration Page</h3>
				<form class="form-group" name="myform" method="post"
					action="faculty_register">
					<div class="form-group">
						<label for="firstname">First Name:</label> <input type="text"
							class="form-control" id="firstname" name="firstname"
							placeholder="*First name" required>
					</div>
					<div class="form-group">
						<label for="lastname">Last Name:</label> <input type="text"
							class="form-control" id="lastname" name="lastname"
							placeholder="Last name">
					</div>
					<div class="form-group">
						<label for="username">Username:</label> <input type="text"
							onfocus="dispuser()" onblur="verifyuser()" class="form-control"
							id="username" name="username" placeholder="*Username" required>
						<p id="user"></p>
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							onfocus="disppwd()" onblur="verifypwd()" class="form-control"
							id="password" name="password" placeholder="*Password" required>
						<p id="pwd"></p>
					</div>
					<div class="form-group">
						<label for="re-enterpwd">Confirm Password:</label> <input
							type="password" onfocus="disprepwd()" onblur="verifypwd()"
							class="form-control" id="re-enterpwd" name="re-enterpwd"
							placeholder="*Confirm Password" required>
						<p id="repwd"></p>
					</div>
					<div class="form-group">
						<label for="mobile_no">Mobile Number:</label> <input type="text"
							onfocus="dispmobile()" onblur="verifymobile(event)"
							class="form-control" id="mobile" name="mobile"
							placeholder="*Mobile Number" required>
						<p id="mobileMsg"></p>
					</div>
					<div class="form-group">
						<label for="gender">Gender:</label> <select class="form-control"
							id="gender" name="gender">
							<option>Select Gender</option>
							<option value="Male">Male</option>
							<option value="Female">Female</option>
							<option value="Other">Other</option>
						</select>
					</div>
					<div class="form-group">
						<label for="address">Current Address:</label> <input type="text"
							class="form-control" id="address" name="address"
							placeholder="*address" required>
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
						<label for="year_of_exp">Year of Experience:</label> <input
							type="number" class="form-control" id="year_of_exp"
							name="year_of_exp" placeholder="*Year of Experience" required>
					</div>
					<div class="form-group">
						<label for="course">Status:</label> <select class="form-control"
							id="status" name="status" required>
							<option>Select status</option>
							<option value="Active">Active</option>
							<option value="Inactive">Inactive</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Register</button>

				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>
