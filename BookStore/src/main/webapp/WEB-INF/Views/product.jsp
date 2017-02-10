<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Admin/Product</title>
</head>
<body>
	<%@ include file = "adminNavbar.jsp" %>
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
	<input type="submit" value="Add Product" class="btn btn-success"/>
</form:form>
<br>
	<div class="panel panel-warning">
		<div class="panel-heading">
		<h3 class="panel-title">PRODUCTS<span class="badge" style="float:right">${no_of_products}</span></h3>
		</div>
		<div class="panel-body ">
			<table border=1 class="table table-striped table-hover table-responsive">
				<thead>
				<tr>
					<th style="text-align: center">NAME</th>
					<th style="text-align: center">AUTHOR</th>
					<th style="text-align: center">DESCRIPTION</th>
					<th style="text-align: center">PRICE</th>
					<th style="text-align: center">QUANTITY</th>
					<th style="text-align: center" width="100">EDIT</th>
					<th style="text-align: center" width="100">DELETE</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${products }" var="product">
						<tr >
						<td><c:out value="${product.product_name }"></c:out></td>
						<td><c:out value="${product.author }"></c:out></td>
						<td><c:out value="${product.description }"></c:out></td>
						<td><c:out value="${product.price }"></c:out></td>
						<td><c:out value="${product.quantity }"></c:out></td>
						<td style="text-align: center"><a href='<c:url value='/edit-product-${product.product_id }'></c:url>' class="btn btn-info">Edit</a></td>
						<td style="text-align: center"><a href='<c:url value='/delete-product-${product.product_id }'></c:url>' class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>