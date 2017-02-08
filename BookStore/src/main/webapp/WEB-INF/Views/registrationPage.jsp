<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>RegistationPage</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
    <link rel='stylesheet' href='static/css/registration.css'>
</head>
<body>
	<div class="container">
		<form:form action='register' method='POST' class="form-horizontal" commandName="addUser">
			
			<div class="form-horizontal">
				<div class="form-group">
					<label for="username" class="col-sm-2 control-label">Username</label>
						<div class="col-sm-10">
	                    	<input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
	                    </div>
	            </div>
	            <div class="form-group">
					<label for="Password" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
	                    	<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
	                    </div>
	            </div>
	            <div class="form-group">
					<label for="name" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
	                    	<input type="text" class="form-control" id="name" name="name" placeholder="Enter name" required>
	                    </div>
	            </div>
	            <div class="form-group">
					<label for="email" class="col-sm-2 control-label">E-mail</label>
						<div class="col-sm-10">
	                    	<input type="email" class="form-control" id="email" name="email" placeholder="Enter E-mail" required>
	                    </div>
	            </div>
	            <div class="form-group">
					<label for="mobile" class="col-sm-2 control-label">Mobile No</label>
						<div class="col-sm-10">
	                    	<input type="tel" class="form-control" id="mobile" name="mobile" placeholder="contact number" required>
	                    </div>
	            </div>
	            <div class="form-group">
					<label for="address" class="col-sm-2 control-label">Address</label>
						<div class="col-sm-10">
	                    	<input type="text" class="form-control" id="address" name="address" placeholder="Enter Address" required>
	                    </div>
	            </div>  
	            <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <input type="submit" class="btn btn-success" value="Register">
				    </div>
				</div>                                         
	       	</div>      
		</form:form>
	</div>
</body>
</html>