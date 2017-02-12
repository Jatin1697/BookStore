<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Admin/Product</title>
<style type="text/css">
.for_form {
	padding : 20px 5px 5px 5px;
	border : 2px solid #B22222;
	border-radius: 15px;
	margin-bottom: 15px;
	margin-top : 5px;
}
.form-control {
	width: 60%;
}
</style>
</head>
<body>
	<%@ include file = "adminNavbar.jsp" %>

	<div class="container for_form">
		<c:choose>
			<c:when test="${edit }">
				<form:form class="form-horizontal" action="edit-product-${supplier_id }" method="POST" commandName="update_product">
					<div class="form-group">
					    <label for="product_name" class="col-sm-2 control-label">Name</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" value="${name }" id="product_name" name="product_name" placeholder="Enter Name">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="author" class="col-sm-2 control-label">Author</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" value="${author }" id="author" name="author" placeholder="Enter Author Name">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="description" class="col-sm-2 control-label">Description</label>
					    <div class="col-sm-10">
					      <textarea rows="3" class="form-control" id="description" name="description" placeholder="Enter Description"><c:out value="${description }"></c:out></textarea>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="price" class="col-sm-2 control-label">Price</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" value="${price }" id="price" name="price" placeholder="Price">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="quantity" class="col-sm-2 control-label">Quantity</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" value="${quantity }" id="quantity" name="quantity" placeholder="Quantity">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="product_image" class="col-sm-2 control-label">Image</label>
					    <div class="col-sm-10">
					      <input type="file" class="form-control" value="" id="product_image" name="product_image">
					    </div>
					  </div>
					  <div class="form-group" class="form-control" >
					  	<label for="category" class="col-sm-2 control-label">Category</label>
						<select name="category">
							<c:forEach items="${category }" var="categories">
								<option value='${categories}'>${categories.category_name}</option>
							</c:forEach>
						</select>
					  </div>
					  <div class="form-group" class="form-control" >
					  	<label for="supplier" class="col-sm-2 control-label">Supplier</label>
					  	<select name="supplier" >
							<c:forEach items="${suppliers }" var="supplier">
								<option value='${supplier}'>${supplier.supplier_name}</option>
							</c:forEach>
						</select>
					  </div>
					  <div class="form-group" >
					    <div class="col-sm-offset-2 col-sm-10">
					      <input type="submit" class="btn btn-success" value="UPDATE">
					      <input class="btn btn-warning" type="reset">
					    </div>
					  </div>
				 </form:form>
			</c:when>
			<c:otherwise>
				<form:form class="form-horizontal" method="POST" action="newProduct" commandName="new_product" enctype="multipart/form-data">
					<div class="form-group">
					    <label for="product_name" class="col-sm-2 control-label col-md-2">Name</label>
					    <div class="col-sm-10 col-md-6">
					      <input type="text" class="form-control" id="product_name" name="product_name" placeholder="Enter Name">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="author" class="col-sm-2 control-label col-md-2">Author</label>
					    <div class="col-sm-10 col-md-6">
					      <input type="text" class="form-control" id="author" name="author" placeholder="Enter Author Name">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="description" class="col-sm-2 control-label col-md-2">Description</label>
					    <div class="col-sm-10 col-md-6">
					      <textarea rows="3" class="form-control" id="description" name="description" placeholder="Enter Description"></textarea>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="price" class="col-sm-2 control-label col-md-2">Price</label>
					    <div class="col-sm-10 col-md-6">
					      <input type="text" class="form-control" id="price" name="price" placeholder="Price">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="quantity" class="col-sm-2 control-label col-md-2">Quantity</label>
					    <div class="col-sm-10 col-md-6">
					      <input type="text" class="form-control" id="quantity" name="quantity" placeholder="Quantity">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="product_image" class="col-sm-2 control-label col-md-2">Image</label>
					    <div class="col-sm-10 col-md-6">
					      <input type="file" class="form-control" id="product_image" name="product_image">
					    </div>
					  </div>
					  <div class="form-group">
					  	<label for="category" class="col-sm-2 control-label">Category</label>
					  	<div class="col-sm-10 col-md-6">
						  	<select name="category">
								<c:forEach items="${category }" var="categories">
									<option value='${categories.category_id}'>${categories.category_name}</option>
								</c:forEach>
							</select>
						</div>
					  </div>
					  <div class="form-group">
					  	<label for="supplier" class="col-sm-2 control-label">Supplier</label>
						<div class="col-sm-10 col-md-6">
							<select name="supplier">
								<c:forEach items="${suppliers }" var="supplier">
									<option value='${supplier.supplier_id}'>${supplier.supplier_name}</option>
								</c:forEach>
							</select>
						</div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <input type="submit" class="btn btn-success" value="ADD">
					    </div>
					  </div>
				</form:form>
			</c:otherwise>
		</c:choose>
	</div>
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