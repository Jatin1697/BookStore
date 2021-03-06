<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>RegistationPage</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link href='//fonts.googleapis.com/css?family=Butcherman' rel='stylesheet'> 
    <link rel='stylesheet' href='static/css/registration.css'>
</head>
<script type="text/javascript">
var loadFile = function(event) {
    var reader = new FileReader();
    reader.onload = function(){
      var output = document.getElementById('output');
      output.src = reader.result;
    };
    reader.readAsDataURL(event.target.files[0]);
  };

</script>
<body>  
	<div style='position:absolute;z-index:0;left:0;top:0;width:100%;height:100%'>
         <img src='static/images/background.jpg' style='width:100%;height:100%;opacity: 0.5;' alt='[]' />
    </div>  
	<div class="container">
		<div class="row">
			<div class="col-md-offset-4 col-md-4 col-sm-offset-4 col-sm-4">
				<p class="sign_up">SIGN UP</p>
			</div>
		</div>
		<p id="demo"><span>${msg}</span></p>
		<div class="forform">
			<form:form action='register' method='POST' class="form-horizontal" commandName="addUser" enctype="multipart/form-data">
				<div class="col-md-7 col-sm-12">
					<div class="form-horizontal">
						<div class="form-group">
							<label for="username" class="col-sm-4 control-label">Username</label>
								<div class="col-sm-8">
			                    	<form:input type="text" class="form-control" path="username" placeholder="Username"></form:input>
			                    </div>
			            </div>
			            <div class="form-group">
							<label for="password" class="col-sm-4 control-label">Password</label>
								<div class="col-sm-8">
			                    	<form:input type="password" class="form-control" path="password" placeholder="Password" />
			                    </div>
			            </div>
			            <div class="form-group">
							<label for="Confirmpassword" class="col-sm-4 control-label">Confirm</label>
								<div class="col-sm-8">
			                    	<input type="password" class="form-control" id="Confirmpassword" placeholder="Re-enter Password" required>
			                    </div>
			            </div>
			            <div class="form-group">
							<label for="name" class="col-sm-4 control-label">Name</label>
								<div class="col-sm-8">
			                    	<form:input type="text" class="form-control" path="name" placeholder="Name" value="${name }" />
			                    </div>
			            </div>
			            <div class="form-group">
							<label for="email" class="col-sm-4 control-label">E-mail</label>
								<div class="col-sm-8">
			                    	<form:input type="email" class="form-control" path="email" placeholder="E-mail" value="${email }" />
			                    </div>
			            </div>
			            <div class="form-group">
							<label for="mobile" class="col-sm-4 control-label">Mobile No</label>
								<div class="col-sm-8">
			                    	<form:input type="tel" class="form-control" path="mobile" placeholder="Contact Number" value="${mobile }" />
			                    </div>
			            </div>
			            <div class="form-group">
							<label for="address" class="col-sm-4 control-label">Address</label>
								<div class="col-sm-8">
			                    	<form:input type="text" class="form-control" path="address" placeholder="Address" value="${address }" />
			                    </div>
			            </div>  
			            <div class="form-group">
			            	<label for="user_image" class="col-sm-4 control-label">Image</label>
			            	<div class="col-sm-8">
			                    	<form:input type="file" path="user_image" onchange="loadFile(event)" accept="image/*"/>
			                    </div>
			            </div>
			            <div class="form-group">
						    <div class="col-sm-offset-4 col-sm-4">
						      <button type="submit" class="btn btn-success">Register</button>
						     </div>
						     <div class="col-sm-4">
						      <button type="reset" class="btn btn-warning">Reset</button>
						    </div>
						</div>   
					</div>	                                      
		       	</div>  
		       	<div class="col-md-5 col-sm-12">
						<div class="user_img">
							<img src="http://placehold.it/250x300" id="output" height="300px" width="250px"/>
						</div>
				</div>    
			</form:form>
		</div>
	</div>
</body>
<script type="text/javascript">
$("#name").click(function(){
    var password = $("#password").val();
    var confirm = $("#Confirmpassword").val();
    if(password != confirm) {
    	$("#demo").text("! Re-enter Password");
    }
    else if(password == confirm) {
    	$("#demo").hide(1000);
    }
});
</script>
</html>