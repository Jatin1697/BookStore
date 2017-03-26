<%@ include file="header.jsp" %>
<div class="container">
	<c:forEach items="${products }" var="product">
		<p>${product.product_name }</p>
		<p>${product.price }</p>
		<p>${product.quantity }</p>
	</c:forEach>
</div>
<%@ include file="footer.jsp"  %>