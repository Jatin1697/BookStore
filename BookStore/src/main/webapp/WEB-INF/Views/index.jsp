
		  <%@ include file="header.jsp" %>
     <div class="container-fluid">
     	<div class="row">
	      <div id="myCarousel" class="carousel slide" data-ride="carousel">
	        <ol class="carousel-indicators">
	          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	          <li data-target="#myCarousel" data-slide-to="1"></li>
	          <li data-target="#myCarousel" data-slide-to="2"></li>
	          <li data-target="#myCarousel" data-slide-to="3"></li>
	        </ol>
	        <div class="carousel-inner" role="listbox">
	          <div class="item active">
	            <img src="static\images\ShowcaseV3.jpg" alt="offer1" class="img-responsive" style="width:100%">
	          </div>
	          <div class="item">
	            <img src="static\images\ShowcaseV4.png" alt="offer2" class="img-responsive" style="width:100%">
	          </div>
	          <div class="item">
	            <img src="static\images\ShowcaseV5.jpg" alt="offer3" class="img-responsive" style="width:100%">
	          </div>
	          <div class="item">
	            <img src="static\images\ShowcaseV6.jpg" alt="offer4" class="img-responsive" style="width:100%">
	          </div>
	        </div>
	        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	          <span class="sr-only">Previous</span>
	        </a>
	        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	          <span class="sr-only">Next</span>
	        </a>
	      </div>
      </div>
    </div>
	<div class="container-fluid">
		<div class="row">
			<h3>Deals of the Day</h3>
		</div>
		<div class="row">
			<c:forEach items="${products }" var="product">
				<div class="col-md-3 col-sm-4">
				<div class="box">
					<div class="row">
						<div class="col-md-7 col-sm-8 col-xs-6">
							<div class="flip-container" ontouchstart="this.classList.toggle('hover');">
								<div class="flipper">
									<div class="front">
										<img src='<c:url value='/static/images/product/${product.product_name }.png'></c:url>' height='200px' width='150px'/>
									</div>
									<div class="back">
										<div class="btn-group">
											<a href='<c:url value='/addCartItem?book=${product.product_name }'></c:url>'><span id="icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>ADD TO CART</a>
											<a href="#"><span id="icon"><i class="fa fa-heart" aria-hidden="true"></i></span>ADD TO WISHLIST</a>
											<a href="#"><span id="icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>BUY NOW</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-5 col-sm-4 col-xs-6">
							<div class="info">
								<h4>${product.product_name }</h4>
								<p>${product.author }</p>
								<c:if test="${product.discount == 0 }">
									<p>&#x20b9 ${product.price }</p>
								</c:if>
								<c:if test="${product.discount > 0 }">
									<p><s>&#x20b9 ${product.price }</s></p>
									<p style="font-family: 'Pacifico', cursive; color: #888899; font-size: 20px">${product.discount}% off</p>
									<p>&#x20b9 ${product.price - product.discount * product.price / 100}</p>
								</c:if>
								<c:if test="${product.quantity  > 0}">
									<p style="color:green">In stock</p>
								</c:if>
								<c:if test="${product.quantity == 0 }">
									<p style="color:red"><del>Out of stock</del></p>	
								</c:if>	
							</div>
						</div>
					</div>
				</div>
				</div>
			</c:forEach>
		</div>
		<div class="row">
			<h3>Best Sellers</h3>
		</div>
		<div class="row">
			<h3>Latest Books</h3>
		</div>
		<div class="row">
			<h3>Upto 40% off</h3>
		</div>
	</div>
	<br>
    
    <br>
    <%@ include file="footer.jsp" %>