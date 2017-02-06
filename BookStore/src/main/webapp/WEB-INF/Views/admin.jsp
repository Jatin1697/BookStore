<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.left-navbar {
	margin:0
}

.icon-bar {
	padding :10px;
    width: 150px;
    text-align: center;
    background-color: black;
}

.icon-bar a:link,a:visited {
	padding-bottom : 70px;
	padding-top : 70px;
    display: block;
    transition: all 0.3s ease;
    color: white;
	background-color : #f44336;
    font-size: 20px;
	text-decoration : none;
}

.icon-bar a:hover,a:active {
    background-color: red;
	text-decoration : none;
}

.active {
    background-color: #4CAF50 !important;
}
</style>
<body>
	<div class ="left-navbar">
		<div class="icon-bar"> 
		  <a href="#">USERS</a> 
		  <a href='<c:url value='/handleProduct'></c:url>'>PRODUCTS</a> 
		  <a href="#">SUPPLIERS</a> 
		</div>
	</div> 
</body>
</html> 
