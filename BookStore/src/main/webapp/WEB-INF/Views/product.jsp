<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Admin|Product</title>

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
.results tr[visible='false'],
.no-result{
  display:none;
}

.results tr[visible='true']{
  display:table-row;
}
.product_img {
	margin: 15px;
	margin-left: 100px;
	margin-top: 0px;
	outline: 2px solid #111111;
	height: 200px;
	width: 150px;
}
</style>
</head>
<script type="text/javascript">
var loadFile = function(event) {
    var reader = new FileReader();
    reader.onload = function(){
      var output = document.getElementById('output');
      output.src = reader.result;
    };
    reader.readAsDataURL(event.target.files[0]);
  };

</script>
<body>
	<%@ include file = "adminNavbar.jsp" %> 
	<div class="container for_form">
		<c:choose>
			<c:when test="${edit}">
				<form:form class="form-horizontal" action="update-product/${product_id }" commandName="update_product" enctype="multipart/form-data"  method="POST">
					<div class="col-md-4">
						<div class="form-group">
						    <label for="product_name" class="col-sm-4 control-label">Name</label>
						    <div class="col-sm-8">
						      <form:input type="text" class="form-control" value="${update_product.product_name }" path="product_name" placeholder="Product"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="author" class="col-sm-4 control-label">Author</label>
						    <div class="col-sm-8">
						      <form:input type="text" class="form-control" value="${update_product.author }" path="author" placeholder="Name"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="description" class="col-sm-4 control-label">Description</label>
						    <div class="col-sm-8">
						      <form:textarea rows="5" class="form-control" path="description" placeholder="Description"></form:textarea>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="price" class="col-sm-4 control-label">Price</label>
						    <div class="col-sm-8">
						      <form:input type="text" class="form-control" value="${update_product.price }" path="price" placeholder="Integer"/>
						    </div>
						  </div>
						</div>
						<div class="col-md-4">
						  <div class="form-group">
						    <label for="quantity" class="col-sm-4 control-label">Quantity</label>
						    <div class="col-sm-8">
						      <form:input type="text" class="form-control" value="${update_product.quantity }" path="quantity" placeholder="Integer"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="discount" class="col-sm-2 control-label col-md-4">Discount</label>
						    <div class="col-sm-10 col-md-8">
						      <form:input type="text" class="form-control" value="${update_product.discount }" path="discount" placeholder="(0-100)%"/>
						    </div>
						  </div>
						  <div class="form-group" class="form-control" >
						  	<label for="category" class="col-sm-4 control-label">Category</label>
						  	<div class="col-sm-10 col-md-8">
						  		<div class="form-control">
									<form:select path="category.category_id">
										<form:options items="${category }" itemValue="category_id" itemLabel="category_name" />
									</form:select>
								</div>
							</div>
						  </div>
						  <div class="form-group" class="form-control" >
						  	<label for="supplier" class="col-sm-4 control-label">Supplier</label>
						  	<div class="col-sm-10 col-md-8">
						  		<div class="form-control">
									<form:select path="supplier.supplier_id">
										<form:options items="${suppliers }" itemValue="supplier_id" itemLabel="supplier_name" />
									</form:select>
								</div>
							</div>
						  </div>
						  <div class="form-group row" >
						    <div class="col-sm-offset-2 col-sm-5">
						      <input type="submit" class="btn btn-success" value="UPDATE">
						    </div>
						    <div class="col-sm-5">
						      <input class="btn btn-warning" type="reset">
						    </div>
						  </div>
					  </div>
					  <div class="col-md-4">
						  	<div class="product_img">
								<img src='<c:url value='/static/images/product/${update_product.product_name }.png'></c:url>' id="output" height="200px" width="150px;"/>
							</div>
							<div class="form-group">
						    <label for="product_image" class="col-sm-4 control-label">Image</label>
						    <div class="col-sm-10 col-md-8">
						      <input type="file" class="form-control" id="product_image" name="product_image" onchange="loadFile(event)">
						    </div>
						  </div>
					  </div>
				 </form:form>
			</c:when>
			<c:otherwise>
				<form:form class="form-horizontal" method="POST" action="newProduct" commandName="new_product" enctype="multipart/form-data">
					<div class="col-md-4">
						<div class="form-group">
						    <label for="product_name" class="col-sm-4 control-label">Name</label>
						    <div class="col-sm-8">
						      <form:input type="text" class="form-control" path="product_name" placeholder="Product" />
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="author" class="col-sm-4 control-label">Author</label>
						    <div class="col-sm-8">
						      <form:input type="text" class="form-control" path="author" placeholder="Name" />
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="description" class="col-sm-4 control-label">Description</label>
						    <div class="col-sm-8">
						      <form:textarea rows="5" class="form-control" path="description" placeholder="Description"></form:textarea>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="price" class="col-sm-4 control-label">Price</label>
						    <div class="col-sm-8">
						      <form:input type="text" class="form-control" path="price" placeholder="Integer" />
						    </div>
						  </div>
						</div>
						<div class="col-md-4">
						  <div class="form-group">
						    <label for="quantity" class="col-sm-4 control-label">Quantity</label>
						    <div class="col-sm-8">
						      <form:input type="text" class="form-control" path="quantity" placeholder="Integer" />
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="discount" class="col-sm-2 control-label col-md-4">Discount</label>
						    <div class="col-sm-10 col-md-8">
						      <form:input type="text" class="form-control" path="discount" placeholder="(0-100)%" />
						    </div>
						  </div>
						  <div class="form-group" class="form-control" >
						  	<label for="category" class="col-sm-4 control-label">Category</label>
						  	<div class="col-sm-10 col-md-8">
						  		<div class="form-control">
									<form:select path="category.category_id">
										<form:options items="${category }" itemValue="category_id" itemLabel="category_name" />
									</form:select>
								</div>
							</div>
						  </div>
						  <div class="form-group" class="form-control" >
						  	<label for="supplier" class="col-sm-4 control-label">Supplier</label>
						  	<div class="col-sm-10 col-md-8">
						  		<div class="form-control">
									<form:select path="supplier.supplier_id">
										<form:options items="${suppliers }" itemValue="supplier_id" itemLabel="supplier_name" />
									</form:select>
								</div>
							</div>
						  </div>
						  <div class="form-group row" >
						    <div class="col-sm-offset-2 col-sm-5">
						      <input type="submit" class="btn btn-success" value="ADD">
						    </div>
						    <div class="col-sm-5">
						      <input class="btn btn-warning" type="reset">
						    </div>
						  </div>
					  </div>
					  <div class="col-md-4">
						  	<div class="product_img">
								<img src="http://placehold.it/150x200" id="output" height="200px" width="150px;"/>
							</div>
							<div class="form-group">
						    <label for="product_image" class="col-sm-4 control-label">Image</label>
						    <div class="col-sm-10 col-md-8">
						      <input type="file" class="form-control" id="product_image" name="product_image" onchange="loadFile(event)">
						    </div>
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
			<div class="form-group">
			    <input type="text" class="search form-control" placeholder="Filter Products">
			</div> 
			<table border=1 class="table table-striped table-hover table-responsive results">
				<thead>
				<tr>
					<th style="text-align: center">NAME</th>
					<th style="text-align: center">AUTHOR</th>
					<th style="text-align: center">DESCRIPTION</th>
					<th style="text-align: center">CATEGORY</th>
					<th style="text-align: center">SUPPLIER</th>
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
						<td><c:out value="${product.getCategory().getCategory_name() }"></c:out></td>
						<td><c:out value="${product.getSupplier().getSupplier_name() }"></c:out></td>
						<td><c:out value="${product.price }"></c:out></td>
						<td><c:out value="${product.quantity }"></c:out></td>
						<td style="text-align: center"><a href='<c:url value='/admin/edit-product/${product.product_id }'></c:url>' class="btn btn-info">Edit</a></td>
						<td style="text-align: center"><a href='<c:url value='/admin/delete-product/${product.product_id }'></c:url>' class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>