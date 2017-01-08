<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='static/css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='static/css/navbar.css'>
</head>
<body>

	<nav class="navbar">
      <div class="container-fluid">
        <ul class="nav navbar-nav">
          <li class="activ"><a href='<c:url value='/home'></c:url>'><span class="glyphicon glyphicon-home"> Home</span></a></li>
          <li><a href="#">About Us</a></li>
          <li><a href="#">Contact Us</a></li>
          <li class="dropdown"><a class="dropbtn" href="#"><span class="pro">Products <span class="caret"></span></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">Product 1</a></li>
              <li><a href="#">Product 2</a></li>
              <li><a href="#">Product 3</a></li>
            </ul>
          </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href='<c:url value='/registration'></c:url>'><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
          <li><a href='<c:url value='/login'/>'><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
      </div>
    </nav>
	
</body>
</html>