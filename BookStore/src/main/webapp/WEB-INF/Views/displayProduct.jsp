<%@ include file="header.jsp" %>
	
	<div class="container">
		<div class="row">
			<c:forEach items="${books }" var="book">
				<div class="col-md-2">
					<a href='#'><img src='<c:url value='static/images/product/${book.product_name }.png'></c:url>' width=150px height=200px /></a>
				</div>
			</c:forEach>
		</div>
	</div>
<%@ include file="footer.jsp" %>