<%@ include file="header.jsp" %>
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
<div class="container">
	<div class="row">
		<div class="col-md-6">
			<img id="output" alt="profile_pic" src='<c:url value='/static/images/user/${pageContext.request.userPrincipal.name}.png'></c:url>' width="300px" height="350px"/>
		</div>
		<div class="col-md-6">
		<c:choose>
			<c:when test="${edit}">
				<form:form action="updatingAccount/${updateUser.user_id }" method="POST" commandName="updateUser" enctype="multipart/form-data">
					<input type="hidden" name="username" value="${updateUser.username }" readonly>
					<input type="hidden" name="password" value="${updateUser.password }" readonly>
				<div class="row">
	            	<div class="col-md-4">
	                	<div class="form-group">
	                    	<label>Name</label>
	                        	<form:input type="text" path="name" class="form-control" placeholder="name" value="${updateUser.name}"/>
	                     </div>
	                </div>
	                <div class="col-md-8">
	                	<div class="form-group">
	                                                <label>Email Id</label>
	                                                <form:input type="email" path="email" class="form-control" placeholder="Email" value="${updateUser.email}" />
	                    </div>   
	                 </div>
	              </div>
	              <div class="row">
	                                        <div class="col-md-12">
	                                            <div class="form-group">
	                                                <label>Address</label>
	                                                <form:input type="text" path="address" class="form-control" placeholder="Enter Address" value="${updateUser.address }" />
	                                            </div>
	                                        </div>
	              </div>   
	              <div class="row">
	                                        
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>Mobile No</label>
	                                                <form:input type="tel" path="mobile" class="form-control" placeholder="Enter Mobile No" value="${updateUser.mobile }" />
	                                            </div>
	                                        </div>
	                                        <div class="col-md-8">
	                                            <div class="form-group">
	                                                <label>Image</label>
	                                                <form:input type="file" path="user_image" class="form-control" onchange="loadFile(event)"/>
	                                            </div>
	                                        </div>
	              </div>
	
	                                    <div class="row">
	                                    	<button type="submit" class="btn btn-info btn-fill pull-right">Update Profile</button>
	                                    </div>                    
			</form:form>
		</c:when>
		<c:otherwise>
			${user.name}
			<a href='<c:url value='/user/${user.username}/account/edit-details/${user.user_id}'></c:url>'>edit details</a>
		</c:otherwise>
		</c:choose>
		</div>
	</div>
</div>
<%@ include file="footer.jsp" %>