<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<head>
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> 
	<script type="text/javascript" src="static/js/table_filter.js"></script>
</head>
<style> 
body{padding-top:70px;}
.navbar {
	background-color: #6633CC;
}
.nav.navbar-nav li a {
	color: white;
}
.nav.navbar-nav li a:HOVER {
	color: white;
	font-size: 18px;
}
input[placeholder], [placeholder], *[placeholder] {
    color: green !important;
}
</style>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
  	<div class="navbar-header">
  		<a style="color: white" class="navbar-brand" href='<c:url value='/admin'></c:url>'>Admin</a>
  	</div>
  	<div class="collapse navbar-collapse">
  		<ul class="nav navbar-nav">
  			<li><a href='<c:url value='/handleProduct'></c:url>'>Product</a></li>
  			<li><a href='<c:url value='/handleSupplier'></c:url>'>Supplier</a></li>
  		</ul>
  		<ul class="nav navbar-nav navbar-right">
  			<li><a class="navbar-brand" href='<c:url value='/admin'></c:url>'>Hello, ${user }</a></li>
  			<li><a href='<c:url value='/logout'></c:url>'>Logout</a></li>
  		</ul>
  	</div>
  </div>
</nav>