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
			<form:form action="updatingAccount-${updateUser.user_id }" method="POST" commandName="updateUser" enctype="multipart/form-data">
			<input type="hidden" name="username" value="${updateUser.username }" readonly>
			<input type="hidden" name="password" value="${updateUser.password }" readonly>
			<div class="row">
            	<div class="col-md-4">
                	<div class="form-group">
                    	<label>Name</label>
                        	<input type="text" name="name" class="form-control" placeholder="name" value="${updateUser.name}">
                     </div>
                </div>
                <div class="col-md-8">
                	<div class="form-group">
                                                <label>Email Id</label>
                                                <input type="email" name="email" class="form-control" placeholder="Email" value="${updateUser.email}" >
                    </div>   
                 </div>
              </div>
              <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Address</label>
                                                <input type="text" name="address" name="address" class="form-control" placeholder="Enter Address" value="${updateUser.address }" required>
                                            </div>
                                        </div>
              </div>   
              <div class="row">
                                        
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Mobile No</label>
                                                <input type="tel" name="mobile" class="form-control" placeholder="Enter Mobile No" value="${updateUser.mobile }" required>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label>Image</label>
                                                <input type="file" name="user_image" class="form-control" onchange="loadFile(event)">
                                            </div>
                                        </div>
              </div>

                                    <div class="row">
                                    	<button type="submit" class="btn btn-info btn-fill pull-right">Update Profile</button>
                                    </div>                    
		</form:form>
		<p>${msg }</p>
		</div>
	</div>
</div>
<%@ include file="footer.jsp" %>