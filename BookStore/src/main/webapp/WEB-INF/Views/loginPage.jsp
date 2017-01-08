<%@ page language="java" contentType="text/html; charset=ISO-8859-8"
    pageEncoding="ISO-8859-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>LoginPage</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel='stylesheet' type='text/css' href='static/css/bootstrap.min.css'>
    <link rel='stylesheet' type='text/css' href='static/css/font-awesome.min.css'>
    <link rel='stylesheet' type='text/css' href="static/css/loginStyle.css">
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
	
	<div class="wrap">
	<p style="font-size:200%; font-style:oblique;">BOOKSTORE</p>
		<div class="login-box">
			<div class="login-box-form">
				<form action='/login' method='GET' >
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
				
					<table>
						<tr>
						<td>Username : </td>
						<td><input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required></td>
						</tr>
						
						<tr>
						<td>Password : </td>
						<td><input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required></td>
						</tr>
					</table>
					<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
                                 
                            <div class="form-actions">
                                <input type="submit"
                                    class="btn btn-block btn-primary btn-default" value="Log in">
                            </div>
				</form>
			</div>
		</div>
	</div>
	Not Registered <a href='<c:url value='/registration'></c:url>'>REGISTER</a> Here
</body>
</html>