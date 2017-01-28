<%@ page language="java" contentType="text/html; charset=ISO-8859-8"
    pageEncoding="ISO-8859-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>LoginPage</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    <script src="static/js/index.js"></script>
    <link rel='stylesheet' type='text/css' href="static/css/style.css">
        
</head>
<body>
			<form action="login" method="POST">
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid username and password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
				<div id='login'>
	  			<h1>SIGN IN<span class='orangestop'>.</span></h1>
	  			<span class='input'>
	    			<span class='icon username-icon fontawesome-user'></span>
	    			<input type='text' class='username' id='username' name='username' placeholder='Username'></span>
	  			<span class='input'>
	    			<span class='password-icon-style icon password-icon fontawesome-lock'></span>
	   				<input type='password' class='password' id='password' name='password' placeholder='Password'>
	  			</span>
	  			<div class='forgot'><a href='<c:url value='/forgot_details'></c:url>'>Forgot Details?</a></div>
	 			<div class='divider'></div>
	  			<button>LOG IN</button>
	  			<p>Not Registered <a href='<c:url value='/registration'></c:url>'>REGISTER</a> Here</p>
				</div>			
				<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />	
			</form>
</body>
</html>