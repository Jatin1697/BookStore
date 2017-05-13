<%@ include file="header.jsp" %>
<style>
.product-list {
	margin: 20px;
}
</style>
	<div class="container">
		<div class="row">
			<c:forEach items="${books }" var="book">
				<div class="product-list">
					<div class="col-md-2">
						<a href='<c:url value='/product?search=${book.product_name }'></c:url>'><img src='<c:url value='static/images/product/${book.product_name }.png'></c:url>' width=150px height=200px /></a>
						<h4>${book.product_name }</h4> by ${book.author }
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
<%@ include file="footer.jsp" %>