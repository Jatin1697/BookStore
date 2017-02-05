<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
${user}
<br>
<table border=1>
	<thead>
	<tr style="text-align: center">
		<th>NAME</th>
		<th>AUTHOR</th>
		<th>DESCRIPTION</th>
		<th>PRICE</th>
		<th>QUANTITY</th>
		<th width="100"></th>
		<th width="100"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${products }" var="product">
			<tr style="text-align: center">
			<td><c:out value="${product.product_name }"></c:out></td>
			<td><c:out value="${product.author }"></c:out></td>
			<td><c:out value="${product.description }"></c:out></td>
			<td><c:out value="${product.price }"></c:out></td>
			<td><c:out value="${product.quantity }"></c:out></td>
			<td><a href='<c:url value='/edit-product-${product.product_id }'></c:url>'>Edit</a></td>
			<td><a href='<c:url value='/delete-product-${product.product_id }'></c:url>'>Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>