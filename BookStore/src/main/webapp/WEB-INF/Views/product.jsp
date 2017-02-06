<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin/Product</title>
</head>
<body>
${user}
<br>
<form:form action="newProduct" class="form-horizontal" commandName="new_product">
	<b>PRODUCT NAME : </b><input type="text" id="product_name" name="product_name" placeholder="Enter Name" /><BR>
	<b>AUTHOR : </b><input type="text" id="author" name="author" placeholder="Enter Author Name" /><br>
	<B>DESCRIPTION : </B><textarea rows="5" cols="50" id="description" name="description" placeholder="Describe your product please"></textarea><br>
	<B>PRICE : </B><input type="text" id="price" name="price" placeholder="Enter price" /><br>
	<B>QUANTITY : </B><input type="text" id="quantity" name="quantity" placeholder="Enter quantity" /><br>
	<b>CATEGORY : </b><select name="category">
		<c:forEach items="${category }" var="categories">
			<option value='${categories}'>${categories.category_name}</option>
		</c:forEach>
	</select><br>
	<b>SUPPLIER : </b><select name="supplier">
		<c:forEach items="${suppliers }" var="supplier">
			<option value='${supplier}'>${supplier.supplier_name}</option>
		</c:forEach>
	</select><br>
	<input type="submit" value="Add Product" class="btn btn-default"/>
</form:form>
<br>
<table border=1>
	<thead style="text-align: center">
	<tr>
		<th>NAME</th>
		<th>AUTHOR</th>
		<th>DESCRIPTION</th>
		<th>PRICE</th>
		<th>QUANTITY</th>
		<th width="100">EDIT</th>
		<th width="100">DELETE</th>
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
			<td><a href='<c:url value='/edit-product-${product.product_id }'></c:url>' class="btn btn-info">Edit</a></td>
			<td><a href='<c:url value='/delete-product-${product.product_id }'></c:url>' class="btn btn-danger">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>