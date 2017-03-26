<%@ include file="header.jsp" %>
<div class="container">
	<div class="row">Shopping Cart  <p>${msg}</p>
	</div>
	<div class="row">
		<div class="col-md-2">
		</div>
	</div>
	<div class="row">
		<c:forEach items="${products }" var="product">
			<p>${product.product_name }</p>
			<p>${product.price }</p>
			<p>${product.quantity }</p>
		</c:forEach>
	</div>
</div>
<%@ include file="footer.jsp"  %>