<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<div class="container-fluid" style="padding-right: 15px; padding-left: 15px; margin-right: auto; margin-left: auto;background-image: url(${context}/resources/img/background_img.jpg);">
	<div style="background-color: #FBF5F5; margin-left: 5%; margin-right: 5%">
		<div class="col-md-7 col-md-offset-1">
			<span><b>Order Details</b></span>
			<div>Order Id:0D12345678909</div>
			<div>Seller:REDMI</div>
			<div>Order Date:8 May, 2015 3:23 PM</div>
			<div>Amount Paid: Rs. 7000 through Cash on delivery</div>
		</div>
		<div>
			<div>Prabaharan Periasamy</div>
			<div>121 Villakkethi Post,Sivagir Via Shoba bakery</div>
			<div>638109, Erode</div>
			<div>Tamil Nadu</div>
			<div>9500098854</div>
		</div>
		<hr>
		<div style="background-color: #FBF5F5; margin-left: 5%; margin-right: 5%">
			<div>
				<span>PRODUCT DETAILS</span>
			</div>
			<div class="col-md-2">
				<img src="${context}/resources/img/m22.jpg" class="img-responsive" />
			</div>
			<span class="col-md-1">RED MI</span> <span class="col-md-offset-1">APPROVAL</span><span class="col-md-offset-1">PROCESSING</span> <span class="col-md-offset-1">SHIPPING</span> <span
				class="col-md-offset-1">DELIVERY</span> <span class="col-md-offset-1">SUBTOTAL</span>
			<div>Color:Black Size:4.5 Qty:1</div>

			<span class='form-group'> <a class="btn btn-warning col-md-offset-2" id="Button" data-toggle="modal" data-target="#myModal">APPROVAL</a>
			</span>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12">
										<div class='form-group pull-right col-md-12'>
											<p>
												<font color="green">YOUR ORDER HAS BEEN PLACED</font>
											</p>
											<div>Fri, 8th May</div>
											<div>03:25 pm</div>
											<div>Payment Approved</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<span class='form-group1'> <a class="btn btn-warning col-md-offset-2" id="Button" data-toggle="modal" data-target="#myModal" style="margin-left: 5%">PROCESSING</a>
			</span>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12">
										<div class='form-group pull-right col-md-12'>
											<p>
												<font color="green">YOUR ITEM HAS BEEN CONFIRMED</font>
											</p>
											<div>Fri, 8th May</div>
											<div>03:25 pm</div>
											<div>Your item has been conformed</div>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<span class='form-group'> <a class="btn btn-warning col-md-offset-2" id="Button" data-toggle="modal" data-target="#myModal" style="margin-left: 5%">SHIPPING</a>
			</span>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12">
										<div class='form-group pull-right col-md-12'>
											<p>
												<font color="green">YOUR ITEM HAS BEEN SHIPPING</font>
											</p>
											<div>Fri, 8th May</div>
											<div>03:25 pm</div>
											<div>Your item has been conformed</div>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<span style="margin-left: 3%">on Thu, 14th May </span> <span style="margin-left: 4%">RS.7000</span>
			<div style="margin-top: 2%">
				<button type="button" class="btn btn-primary">Return</button>
				<button type="button" class="btn btn-primary">Review Report</button>

			</div>
			<hr>
			<div class="col-md-offset-11">
				<b>RS.7000</b>
			</div>
			<hr>
			<!-- Catagory items -->
			<div>
				<div>
					<nav class="navbar breadcrumb_cust" role="navigation">
						<div data-toggle="collapse">
							<ul class="nav navbar-nav navbar-left">
								<li><a href="#">Recommendations Based On Your Order</a></li>
							</ul>

						</div>
					</nav>
				</div>

				<!-- Products picture-->
				<div class="col-md-12 item">
					<div class="row">
						<div class="col-sm-2">
							<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/aprons-potholders.jpg" alt="Image" class="img-responsive"></a>
						</div>
						<div class="col-sm-2">
							<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/baking-dishes.jpg" alt="Image" class="img-responsive"></a>
						</div>
						<div class="col-sm-2">
							<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/canister.jpg" alt="Image" class="img-responsive"></a>
						</div>
						<div class="col-sm-2">
							<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/ceramic-mug.jpg" alt="Image" class="img-responsive"></a>
						</div>
						<div class="col-sm-2">
							<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/kitchen-accessories.jpg" alt="Image" class="img-responsive"></a>
						</div>
						<div class="col-sm-2">
							<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/tea-bags.jpg" alt="Image" class="img-responsive"></a>
						</div>
					</div>

				</div>
			</div>


		</div>
	</div>
</div>