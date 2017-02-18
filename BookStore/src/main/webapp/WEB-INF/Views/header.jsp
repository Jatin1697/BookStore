<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookStore</title>
<meta charset="utf-8">
    <link rel='stylesheet' href='static/css/landing.css'>
    <link rel='stylesheet' href='static/css/header.css'>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
	
    <header>
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-4" style="text-align: center">
            <h1>BOOK STORE</h1>
          </div>
          <div class="col-md-7" style="padding-top: 20px">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="search"/>
              <span class="input-group-addon">
                <a href="#"><i class="fa fa-search"></i></a>
              </span>
            </div>
          </div>
          <div class="col-md-1" style="padding-top: 20px">
            <a href="#"><span class="glyphicon glyphicon-shopping-cart" style="font-size: 24px"></span></a>
          </div>
        </div>
      </div>
    </header>
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