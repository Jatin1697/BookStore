<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Admin</title>
</head>
<style>
.results tr[visible='false'],
.no-result{
  display:none;
}

.results tr[visible='true']{
  display:table-row;
}
</style>
<body>
	<%@ include file = "adminNavbar.jsp" %>
	<div class="col-md-8">
		<div class="panel panel-warning">
			<div class="panel-heading">
			<h3 class="panel-title">List of Users<span class="badge" style="float:right">${no_of_active_users}</span></h3>
			</div>
			<div class="panel-body ">
				<table border=1 class="table table-striped table-hover table-responsive">
					<thead>
					<tr>
						<th style="text-align: center">USERNAME</th>
						<th style="text-align: center">E-MAIL</th>
						<th style="text-align: center">CONTACT</th>
						<th style="text-align: center">ACTIVE</th>
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${users }" var="user">
							<tr >
							<td><c:out value="${user.username }"></c:out></td>
							<td><c:out value="${user.email }"></c:out></td>
							<td><c:out value="${user.mobile }"></c:out></td>
							<td style="text-align: center">
								<c:choose>
									<c:when test="${user.isActive() }">
										<c:out value="Yes"></c:out>
									</c:when>
									<c:otherwise>
										<c:out value="No"></c:out>
									</c:otherwise>
								</c:choose>
								<a href='<c:url value='/admin/change-status-user/${user.user_id }'></c:url>' class="btn btn-danger">CHANGE</a>
							</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="panel panel-info">
			<c:choose>
				<c:when test="${edit }">
					<div class="panel-heading">
						<h3 class="panel-title">Update Category</h3>
					</div>
					<div class="panel-body">
						<form:form action="update-category/${category_id}" commandName="update_category" method="POST">
							<div class="input-group">
							<form:input type="text" path="category_name" value="${update_category.category_name }" class="form-control"/><br>
							<span class="input-group-btn"><input type="submit" value="UPDATE" class="btn btn-success"></span>
							</div>
						</form:form>
					</div>
				</c:when>
				<c:otherwise>
					<div class="panel-heading">
						<h3 class="panel-title">Add New Category</h3>
					</div>
					<div class="panel-body">
						<form:form action="admin/newCategory" commandName="new_category" method="POST">
							<div class="input-group">
							<form:input type="text" path="category_name" placeholder="Category Name" class="form-control"/><br>
							<span class="input-group-btn"><input type="submit" value="ADD" class="btn btn-success"></span>
							</div>
						</form:form>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="panel panel-success">
			<div class="panel-heading">
			<h3 class="panel-title">Categories<span class="badge" style="float:right">${no_of_categories}</span></h3>
			</div>
			<div class="panel-body ">
				<div class="form-group">
			    	<input type="text" class="search form-control" placeholder="Filter Categories">
				</div>
				<table border=1 class="table table-striped table-hover table-responsive results">
					<thead>
					<tr>
						<th style="text-align: center">NAME</th>
						<th style="text-align: center">EDIT</th>
						<th style="text-align: center">DELETE</th>
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${categories }" var="category">
							<tr >
							<td><c:out value="${category.category_name }"></c:out></td>
							<td style="text-align: center"><a href='<c:url value='/admin/edit-category/${category.category_id }'></c:url>' class="btn btn-info">Edit</a></td>
							<td style="text-align: center"><a href='<c:url value='/admin/delete-category/${category.category_id }'></c:url>' class="btn btn-danger">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html> 
