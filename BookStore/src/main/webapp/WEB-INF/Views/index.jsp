
		  <%@ include file="header.jsp" %>

     <div class="container-fluid">
      <br>
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
          <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <div class="item active">
            <img src="C:\Users\Jatin\Desktop\BS_Pics\ShowcaseV1.png" alt="offer1" class="img-responsive" style="width:100%">
          </div>
          <div class="item">
            <img src="C:\Users\Jatin\Desktop\BS_Pics\ShowcaseV2.jpg" alt="offer2" class="img-responsive" style="width:100%">
          </div>
          <div class="item">
            <img src="C:\Users\Jatin\Desktop\BS_Pics\ShowcaseV3.jpg" alt="offer3" class="img-responsive" style="width:100%">
          </div>
          <div class="item">
            <img src="C:\Users\Jatin\Desktop\BS_Pics\ShowcaseV4.png" alt="offer4" class="img-responsive" style="width:100%">
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
    <%@ include file="footer.jsp" %>