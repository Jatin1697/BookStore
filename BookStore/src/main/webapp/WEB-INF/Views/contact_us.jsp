<link rel="stylesheet" href="static/css/section.css">
<%@ include file = "header.jsp"%>
	<section class="section-base">
		<div class="section-middle">
			<div class="section-inner">
				<h1>
					<b style="font-size: 24px">CONTACT US</b>
					<span>Keep in touch with us</span>
				</h1>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form:form action="contactForm" method="POST">
					<div class="form-horizontal">
						<div class="form-group">
							<label for="name" class="col-sm-4 control-label"> Name</label>
							<input type="text" name="name" placeholder="your name">
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-4 control-label">Email</label>
							<input type="email" name="email" placeholder="e-mail Id">
						</div>
						<div class="form-group">
							<label for="contact" class="col-sm-4 control-label">Contact</label>
							<input type="tel" name="mobile" placeholder="contact number">
						</div>
						<div class="form-group">
						    <label for="message" class="col-sm-4 control-label">Message</label>
						    <textarea rows="5" class="form-control" name="message" placeholder="message"></textarea>    
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-md-6">
			</div>
		</div>
	</div>
	

<%@ include file = "footer.jsp"%>