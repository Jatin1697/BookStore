<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>RegistationPage</title>
    <link rel='stylesheet' type='text/css' href='static/css/bootstrap.min.css'>
    <link rel='stylesheet' type='text/css' href='static/css/font-awesome.min.css'>
    
</head>
<body>

	<form:form action='/' method='POST' class="form-horizontal">
		
		<div class="input-group input-sm">
                                <label class="input-group-addon" for="Name"></label>
                                <input type="text" class="form-control" id="Name" name="Name" placeholder="Enter Name" required>
        </div>
        <div class="input-group input-sm">
                               	<label class="input-group-addon" for="Contact"><i class="fa fa-lock"></i></label> 
                                <input type="tel" class="form-control" id="contact" name="contact" placeholder="contact number" required>
        </div>
        
        <div class="form-actions">
                                <input type="submit" class="btn btn-block btn-primary btn-default" value="Register">
        </div>
        
	</form:form>
</body>
</html>