<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Admin/Supplier</title>
<style type="text/css">
.for_form {
	/*background-color: white;*/
	padding : 20px 5px 5px 5px;
	border : 2px solid #B22222;
	border-radius: 15px;
	margin-bottom: 15px;
	margin-top : 5px;
}
.results tr[visible='false'],
.no-result{
  display:none;
}

.results tr[visible='true']{
  display:table-row;
}
</style>
</head>
<body>
	<%@ include file = "adminNavbar.jsp" %>
	<div class="container for_form">
	<c:choose>
		<c:when test="${edit }">
			<form:form class="form-horizontal" action="update-supplier/${supplier_id }" commandName="update_supplier"  method="POST">
			<div class="form-group">
			    <label for="supplier_name" class="col-sm-2 control-label">Name</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" value="${update_supplier.supplier_name }" path="supplier_name" placeholder="Enter Name"/>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="supplier_address" class="col-sm-2 control-label">Address</label>
			    <div class="col-sm-10">
			      <form:textarea rows="3" class="form-control" path="supplier_address" placeholder="Enter Address"></form:textarea>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="supplier_email" class="col-sm-2 control-label">Email</label>
			    <div class="col-sm-10">
			      <form:input type="email" class="form-control" value="${update_supplier.supplier_email }" path="supplier_email" placeholder="Email"/>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="supplier_mob_no" class="col-sm-2 control-label">Mobile No</label>
			    <div class="col-sm-10">
			      <form:input type="tel" class="form-control" value="${update_supplier.supplier_mob_no }" path="supplier_mob_no" placeholder="Enter Mobile No"/>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit" class="btn btn-success" value="UPDATE">
			      <input class="btn btn-warning" type="reset">
			    </div>
			  </div>
			 </form:form>
		</c:when>
		<c:otherwise>
			<form:form class="form-horizontal" action="newSupplier" method="POST" commandName="new_supplier">
			<div class="form-group">
			    <label for="supplier_name" class="col-sm-2 control-label">Name</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" path="supplier_name" placeholder="Enter Name"/>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="supplier_address" class="col-sm-2 control-label">Address</label>
			    <div class="col-sm-10">
			      <form:textarea rows="3" class="form-control" path="supplier_address" placeholder="Enter Address"></form:textarea>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="supplier_email" class="col-sm-2 control-label">Email</label>
			    <div class="col-sm-10">
			      <form:input type="email" class="form-control" path="supplier_email" placeholder="Email"/>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="supplier_mob_no" class="col-sm-2 control-label">Mobile No</label>
			    <div class="col-sm-10">
			      <input type="tel" class="form-control" value="${mob_no }" id="supplier_mob_no" name="supplier_mob_no" placeholder="Enter Mobile No">
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
	<div class="panel panel-success">
		<div class="panel-heading">
		<h3 class="panel-title">SUPPLIERS <span class="badge" style="float:right">${no_of_suppliers}</span></h3>
		</div>
		<div class="panel-body ">
			<div class="form-group">
			    <input type="text" class="search form-control" placeholder="Filter Suppliers">
			</div>
			<table border=1 class="table table-striped table-hover table-responsive results">
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
						<td style="text-align: center"><a href='<c:url value='/admin/edit-supplier/${supplier.supplier_id }'></c:url>' class="btn btn-info">Edit</a></td>
						<td style="text-align: center"><a href='<c:url value='/admin/delete-supplier/${supplier.supplier_id }'></c:url>' class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>