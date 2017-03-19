
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
    <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Griffy" rel="stylesheet">
</head>
<body>
	
    <header>
      <div class="container">
        <div class="row">
          <div class="col-md-4 col-xs-12" style="text-align: center">
            <img src='static/images/Bookstore-logo.png' alt='Bookstore' height="100px" width="280px"/>
          </div>
          <div class="col-md-4 col-xs-8" style="padding-top: 40px">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="search"/>
              <span class="input-group-addon">
                <a href="#" style="color:#4CAF50"><i class="fa fa-search"></i></a>
              </span>
            </div>
          </div>
          <div class="col-md-2" style="padding-top: 35px; padding-left:40px">
          	<div class="cart-list">
	            <a href="#"><span class="fa fa-shopping-cart" style="font-size: 25px; color:#585858"></span></a>
	            <span class="item"><b>CART    0</b></span>
	        </div>
          </div>
          <div class="col-md-2" style="padding-top: 35px">
          	<div class="cart-list">
            	<a href="#"><img src='<c:url value='static/images/wishlist-pro-icon.jpg'></c:url>' width='30px' height='30px' /></a>
            	<span class="item"><b>WISHLIST    0</b></span>
            </div>
          </div>
        </div>
      </div>
    </header>
    <nav class="navbar">
    	<div class="container">
        <ul class="nav navbar-nav">
          <li class="${Home}"><a href='<c:url value='/home'></c:url>'><span class="glyphicon glyphicon-home"></span>  Home</a></li>
          <li class="${Aboutus}"><a href='<c:url value="/aboutUs"></c:url>'>About Us</a></li>
          <li class="${Contactus }"><a href='<c:url value="/contactUs"></c:url>'>Contact Us</a></li>
          <li class="dropdown ${genre}"><a class="dropbtn" href='<c:url value='/allProduct'></c:url>'><span class="pro">Genre <span class="caret"></span></span></a>
            <div class="dropdown-menu">
          		<div class="row">
              	<c:forEach items="${categories }" var="category">
	              	<div class="col-md-4 nopadding">
	              		<ul>
	              			<li><a href='<c:url value='displayProduct-${category.category_id }'></c:url>'>${category.category_name }</a></li>
	              		</ul>
	              	</div>
              	</c:forEach>
              	</div>
            </div>
          </li>
          <li class="${DisplayProduct}"><a href='<c:url value="/allProduct"></c:url>'>More Books</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
        <c:if test="${pageContext.request.userPrincipal.name ==null}">
          <li class="${Registration }"><a href='<c:url value='/registration'></c:url>'><span class="glyphicon glyphicon-user"></span>  Sign Up</a></li>
          <li class="${Login }"><a href='<c:url value='/login'/>'><span class="glyphicon glyphicon-log-in"></span>  Login</a></li>
         </c:if>
         <c:if test="${pageContext.request.userPrincipal.name !=null}">
	       <li class="${Contactus } dropdown"><a class="dropbtn" href='<c:url value='/home'></c:url>'>Welcome : ${pageContext.request.userPrincipal.name} <span class="caret"></span></a>
	       	<ul class="dropdown-menu" style="width:150px">
	       		<li><a href='<c:url value='/account?username=${user}'></c:url>'>your account</a></li>
	       		<li><a>your orders</a></li>
	       		<li><a>your cart</a></li>
	       	</ul>
	       </li>
	       <li><a href='<c:url value='/home'></c:url>' style="padding-bottom: 13px; padding-top: 13px"><img src='<c:url value='/static/images/user/${pageContext.request.userPrincipal.name}.png'></c:url>' height='25' width='25' class="img img-rounded"/></a></li>
	       <li><a href='<c:url value='/logout'></c:url>'>Logout</a></li>
         </c:if>
        </ul>
       </div>
    </nav>