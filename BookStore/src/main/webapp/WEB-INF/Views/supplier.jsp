<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Admin/Supplier</title>
</head>
<body>
	<%@ include file = "adminNavbar.jsp" %>
	<div class="container">
	<form class="form-horizontal">
	<div class="form-group">
	    <label for="supplier_name" class="col-sm-2 control-label">Name</label>
	    <div class="col-sm-10">
	      <input type="email" class="form-control" id="supplier_name" name="supplier_name" placeholder="Enter Name">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="supplier_address" class="col-sm-2 control-label">Address</label>
	    <div class="col-sm-10">
	      <textarea rows="3" class="form-control" id="supplier_address" name="supplier_address" placeholder="Enter Address"></textarea>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="supplier_email" class="col-sm-2 control-label">Email</label>
	    <div class="col-sm-10">
	      <input type="email" class="form-control" id="supplier_email" name="supplier_email" placeholder="Email">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="supplier_mob_no" class="col-sm-2 control-label">Mobile No</label>
	    <div class="col-sm-10">
	      <input type="tel" class="form-control" id="supplier_mob_no" name="supplier_mob_no" placeholder="Enter Mobile No">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <input type="submit" class="btn btn-default" value="ADD">
	    </div>
	  </div>
	 </form>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">SUPPLIERS</h3>
		</div>
		<div class="panel-body ">
			<table border=1 class="table table-striped table-hover table-responsive">
				<thead>
				<tr>
					<th style="text-align: center">NAME</th>
					<th style="text-align: center">ADDRESS</th>
					<th style="text-align: center">E-MAIL</th>
					<th style="text-align: center">CONTACT</th>
					<th style="text-align: center" width="100">EDIT</th>
					<th style="text-align: center" width="100">DELETE</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${suppliers }" var="supplier">
						<tr>
						<td><c:out value="${supplier.supplier_name }"></c:out></td>
						<td><c:out value="${supplier.supplier_address }"></c:out></td>
						<td><c:out value="${supplier.supplier_email }"></c:out></td>
						<td><c:out value="${supplier.supplier_mob_no }"></c:out></td>
						<td style="text-align: center"><a href='<c:url value='/edit-supplier-${supplier.supplier_id }'></c:url>' class="btn btn-info">Edit</a></td>
						<td style="text-align: center"><a href='<c:url value='/delete-supplier-${supplier.supplier_id }'></c:url>' class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>