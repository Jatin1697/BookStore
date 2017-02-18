
		  <%@ include file="header.jsp" %>
     <div class="container-fluid">
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
    <br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3 col-sm-4">
				<div class="box">
					<div class="row">
						<div class="col-md-7 col-xs-6">
							<div class="flip-container" ontouchstart="this.classList.toggle('hover');">
								<div class="flipper">
									<div class="front">
									</div>
									<div class="back">
										<div class="btn-group">
											<a href="#"><span id="icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>ADD TO CART</a>
											<a href="#"><span id="icon"><i class="fa fa-heart" aria-hidden="true"></i></span>ADD TO WISHLIST</a>
											<a href="#"><span id="icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>BUY NOW</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-5 col-xs-6">
							<div class="info">
								<h4>Harry Potter and the philosophers stone</h4>
								<p>J K Rowling</p>
								<p>Rs 256</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-sm-4">
				<div class="box">
					<div class="row">
						<div class="col-md-7 col-xs-6">
							<div class="flip-container" ontouchstart="this.classList.toggle('hover');">
								<div class="flipper">
									<div class="front">
									</div>
									<div class="back">
										<div class="btn-group">
											<a href="#"><span id="icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>ADD TO CART</a>
											<a href="#"><span id="icon"><i class="fa fa-heart" aria-hidden="true"></i></span>ADD TO WISHLIST</a>
											<a href="#"><span id="icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>BUY NOW</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-5 col-xs-6">
							<div class="info">
								<h4>Harry Potter and the philosophers stone</h4>
								<p>J K Rowling</p>
								<p>Rs 256</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-sm-4">
				<div class="box">
					<div class="row">
						<div class="col-md-7 col-xs-6">
							<div class="flip-container" ontouchstart="this.classList.toggle('hover');">
								<div class="flipper">
									<div class="front">
									</div>
									<div class="back">
										<div class="btn-group">
											<a href="#"><span id="icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>ADD TO CART</a>
											<a href="#"><span id="icon"><i class="fa fa-heart" aria-hidden="true"></i></span>ADD TO WISHLIST</a>
											<a href="#"><span id="icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>BUY NOW</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-5 col-xs-6">
							<div class="info">
								<h4>Harry Potter and the philosophers stone</h4>
								<p>J K Rowling</p>
								<p>Rs 256</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-sm-4">
				<div class="box">
					<div class="row">
						<div class="col-md-7 col-xs-6">
							<div class="flip-container" ontouchstart="this.classList.toggle('hover');">
								<div class="flipper">
									<div class="front">
									</div>
									<div class="back">
										<div class="btn-group">
											<a href="#"><span id="icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>ADD TO CART</a>
											<a href="#"><span id="icon"><i class="fa fa-heart" aria-hidden="true"></i></span>ADD TO WISHLIST</a>
											<a href="#"><span id="icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>BUY NOW</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-5 col-xs-6">
							<div class="info">
								<h4>Harry Potter and the philosophers stone</h4>
								<p>J K Rowling</p>
								<p>Rs 256</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
    <a href='<c:url value='/logout'></c:url>'>logout</a>
    <br>
    <%@ include file="footer.jsp" %>