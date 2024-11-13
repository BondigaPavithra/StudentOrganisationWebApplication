<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>Courses registration</h1>
				</div>
				<div class="col-md-6"></div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form class="form-group" name="myform" action="course_register" method="post" >
	                    <div class="form-group">
	                        <label for="coursename">Course Name:</label>
	                        <input type="text" class="form-control" id="coursename" name="coursename" placeholder="*course name" required>
	                        
	                    </div>
	                    <div class="form-group">
	                        <label for="coursefee">Course Fee:</label>
	                        <input type="text" class="form-control" id="coursefee" name="coursefee" placeholder="* course fee" required>
	                        
	                    </div>
	                    <div class="form-group">
	                        <label for="courseduration">Course Duration:</label>
	                        <input type="text" class="form-control" id="courseduration" name="courseduration" placeholder="* course duration" required>
	                    </div>
	                    <div class="form-group">
							<label for="course">Status:</label>
							<select class="form-control" id="status" name="status" required>
								<option >Select status</option>
								<option value="Active">Active</option>
								<option value="Inactive">Inactive</option>
							</select>
						</div>
	                    <button type="submit" class="btn btn-success">submit</button>
	                    
	                </form>
				</div>
			</div>
		</div>
	</body>
</html>