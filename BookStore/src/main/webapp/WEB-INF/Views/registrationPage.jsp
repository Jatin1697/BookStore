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

	<form:form action='register' method='POST' class="form-horizontal" commandName="addUser">
		
		
                                <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
                                
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                                
                                <input type="email" class="form-control" id="email" name="email" placeholder="Enter E-mail" required>

                                <input type="tel" class="form-control" id="mobile" name="mobile" placeholder="contact number" required>
                                
                                <input type="text" class="form-control" id="address" name="address" placeholder="Enter Address" required>
        
                                <input type="submit" class="btn btn-block btn-primary btn-default" value="Register">
       
        
	</form:form>
</body>
</html>