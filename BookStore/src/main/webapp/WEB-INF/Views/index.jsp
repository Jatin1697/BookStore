<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>BookStore.com</title>
  <!-- <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel='stylesheet' href='static/css/landing.css'>
    <link rel='stylesheet' href='static/css/bootstrap.min.css'>
    <link rel='stylesheet' href='static/css/font-awesome.min.css'>
    
    <script type="text/javascript" src='static/js/bootstrap.min.js'></script> --> 
    
    <meta charset="utf-8">
    <link rel='stylesheet' href='static/css/landing.css'>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>

		  <%@ include file="header.jsp" %>
		  <%@ include file="navbar.jsp" %>

     <div class="container-fluid">
      <br>
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
          <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <div class="item active">
            <img src="C:\Users\Jatin\Desktop\ShowcaseV1.png" alt="offer1" class="img-responsive" style="width:100%">
          </div>
          <div class="item">
            <img src="C:\Users\Jatin\Desktop\ShowcaseV2.jpg" alt="offer2" class="img-responsive" style="width:100%">
          </div>
          <div class="item">
            <img src="C:\Users\Jatin\Desktop\ShowcaseV3.jpg" alt="offer3" class="img-responsive" style="width:100%">
          </div>
          <div class="item">
            <img src="C:\Users\Jatin\Desktop\ShowcaseV4.png" alt="offer4" class="img-responsive" style="width:100%">
          </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
    <br>
    <%@ include file="footer.jsp" %>
</body>
</html>