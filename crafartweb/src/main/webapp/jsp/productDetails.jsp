<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<!-- left side image -->

<div class="container-fluid" style="padding-right: 15px; padding-left: 15px; margin-right: auto; margin-left: auto;background-image: url(${context}/resources/img/background_img.jpg);">
	<div class="col-md-3" style="margin-left: 4%">
		<a href="#"><img src="${context}/resources/img/wood 2.jpg" id="image" title="" alt="" class="img-responsive" style="margin-top: 1%;" /></a>
	</div>

	<!-- right side content -->

	<div style="background-color: #FBF5F5; margin-left: 5%; margin-right: 5%">
		<div class="col-md-8" style="margin-top:2%">
			<div class="col-md-6">
				<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 2%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
					aria-hidden="true">Ratting</span> <span>REVIEWS</span>
				<ul style="margin-top: 1%">
					<li>Android v4.4.4 OS</li>
					<li>Dual Sim (GSM + GSM)</li>
					<li>12.7 cm HD Screen</li>
					<li>8 MP Primary Camera</li>
				</ul>
			</div>
			<div class="col-md-6">
				<span class="glyphicon glyphicon-pencil">Write a REVIEW</span> <span class="glyphicon glyphicon-heart" style="margin-left: 1%">Add WISHLIST</span> <span class="glyphicon glyphicon-list-alt">Add
					COMPARE</span>
				<div>
					<span style="margin-top: 10%"><b>WARRANTY:</b></span> <span> 1 year manufacturer warranty for Phone and 6 months warranty for in the box accessories</span>
				</div>
			</div>
			<div style="margin-top: 10%;">
				<div>
					<span style="margin-left: 3%"><b>SOLD BY</b></span>
				</div>
				<div>
					<span style="margin-left: 3%">WSRetail
						<button type="button" class="btn btn-primary btn-xs"<img src="${context}/resources/img/no_image-100x100.png"/>4/5</button>
					</span>
				</div>
				<div class="col-md-3" style="margin-left: 51%">
					<div>
						<b>Delivered By</b><span class="icon-question-sign"></span>
					</div>
					<div>Usually Delivered in 2-3 business days.</div>
				</div>

			</div>

			<div style="margin-top: 10%; margin-left: 3%">
				<span class="glyphicon glyphicon-share" style="font-size: 130%">Viewing Compability Accessories</span>
				<div>
					<hr>
					<span class="glyphicon glyphicon-map-marker" style="font-size: 130%">Check Availability at</span> <input type="text" placeholder="Enter a pincode" />
					<button type="button" class="btn btn-primary btn-xs">Check</button>
					<hr>
				</div>
			</div>
			<div class="col-md-6">
				<div style="margin-left: 2%">
					<h3>RS.5000</h3>
					<div>
						<span>MRP</span>
					</div>
					<div>
						<span>(Free Delivery)</span>
					</div>
				</div>
				<div>

					<button type="button" class="btn btn-warning" style="margin-top: 5%">ADD TO CART</button>
					<button type="button" class="btn btn-success" style="margin-top: 5%">BUY NOW</button>

				</div>
			</div>
		</div>
	<div>
		<nav class="navbar breadcrumb_cust" role="navigation" style="z-index:-1"></nav>
		</div>	
<!-- Catagory items -->
	<div style="margin-left: 4%; margin-right: 4%;">
		<div>
			<nav class="navbar breadcrumb_cust" role="navigation">
				<div data-toggle="collapse">
					<ul class="nav navbar-nav navbar-left">
						<li><a href="#">ALL CATAGORIES</a></li>
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



	<!-- Catagory items ends -->

	<!-- Feature Section -->
	<div style="margin-left: 4%; margin-right: 4%">
		<div>
			<nav class="navbar breadcrumb_cust" role="navigation">
				<div data-toggle="collapse">
					<ul class="nav navbar-nav navbar-left">
						<li><a href="#">KEY FEATURES</a></li>
					</ul>

				</div>
			</nav>
		</div>
		<ul>
			<li>0.3 MP Secondary Camera</li>
			<li>Wi-Fi Enabled</li>
			<li>Android v5.0 (Lollipop) OS</li>
			<li>Expandable Storage Capacity of 32 GB</li>
			<li>Dual Sim (GSM + LTE)</li>
			<li>5 MP Primary Camera</li>
			<li>1.2 GHz Quad Core Processor</li>
			<li>11.43 cm TFT LCD Touchscreen</li>
			</li>
		</ul>
	</div>
	<!-- Feature Section End-->

	<!-- Customer Viewed Products-->
	<div style="margin-left: 4%; margin-right: 4%">
		<div>
			<nav class="navbar breadcrumb_cust" role="navigation">
				<div data-toggle="collapse">
					<ul class="nav navbar-nav navbar-left">
						<li><a href="#">CUSTOMERS VIEWED THIS PRODUCT</a></li>
					</ul>

				</div>
			</nav>
		</div>
		<!-- Customer Products picture-->
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
			<!--/row-->
		</div>
		<!--/item-->
	</div>


	<!-- Customer View Products ends -->

	<!-- Products View -->
	<div class="col-md-11" style="margin-left: 4%">
		<div>
			<span class="icon-plus-sign" style="font-size: 15">Design</span>
		</div>
		<div>
			<span class="icon-plus-sign" style="font-size: 15">Display</span>
		</div>
		<div>
			<span class="icon-plus-sign" style="font-size: 15">Design And Durability</span>
		</div>
		<div>
			<span class="icon-plus-sign" style="font-size: 15">Durability</span>
		</div>
		<div>
			<span class="icon-plus-sign" style="font-size: 15">Viewing Picture</span>
		</div>

	</div>
	<!-- Customer Review Section-->
	<div class="col-md-12">
		<div id="horizontalTabContentSection" style="margin-left: 4%; margin-right: 4%; margin-top: 3%;">
			<ul class="nav nav-tabs nav_tabs_bottom_border" id="reviewSection">
				<li class="active" id="tabProduct"><a data-toggle="tab" href="#tab-product">Product Reviews</a></li>
			</ul>

			<div class="tab-content" style="border: 0px; padding: 0px;">
				<div class="tab-pane fade in active" id="tab-product">

					<div class="table-responsive" style="background-color: white;">
						<table id="images" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<td class="pull-left" style="padding: 1%">Rattings By User</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><img src="${context}/resources/img/no_image-100x100.png" alt="" title="" data-placeholder="${context}/resources/img/no_image-100x100.png" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- specification section-->
		<div style="margin-left: 4%">
			<span><b>Specifications of Moto G (2nd Gen) (Black, with 16 GB)</b></span>
			<div>
				<span><b>GENERAL FEATURES</b></span>
			</div>
			<hr>
		</div>
		<!-- last section-->
		<div class="row col-md-12">
			<div style="margin-left: 5%">
				<b>TOP REVIEW</b>
			</div>
			<div style="margin-left: 5%">'Top Reviews' lists the most relevant product reviews only. Show ALL instead?</div>
			<div class="col-md-4">
				<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 13%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
					aria-hidden="true"></span>
				<div style="margin-left: 13%">
					<span>RAM</span>
				</div>

				<div class="dropdown" style="margin-top: 2%; margin-left: 13%">
					<div class="rectangle rectanle_lg_wd">
						<h2 class="dropdown-toggle" data-toggle="dropdown">FITST TO REVIEW</h2>
					</div>
					<!-- Ribbon side-fold (left and right) -->
					<div class="triangle-l triangle-l-lg-wd"></div>
					<div class="triangle-r triangle-r-lg-wd"></div>
				</div>

				<div class="dropdown" style="margin-top: 2%; margin-left: 13%">
					<div class="rectangle rectanle_lg_wd">
						<h2 class="dropdown-toggle" data-toggle="dropdown">CERTIFIED BUYER</h2>
					</div>
					<!-- Ribbon side-fold (left and right) -->
					<div class="triangle-l triangle-l-lg-wd"></div>
					<div class="triangle-r triangle-r-lg-wd"></div>
				</div>
			</div>
			<div class="col-md-4">
				<div>
					<b>Simply Superb</b>
				</div>
				<div>
					<span>I am Glad that i am the first person to review this product in Crafart.</span>
				</div>
				<span>was the review helpful?</span> <span class="icon-thumbs-up">Yes</span> <span class=" icon-thumbs-down">No</span>
			</div>
			<div class="col-md-3">
				<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
					aria-hidden="true"></span>
				<div style="margin-left: 2%; margin-left: 20%">
					<span>Shahul</span>
				</div>
				<div class="dropdown" style="margin-top: 2%; margin-left: 20%">
					<div class="rectangle rectanle_lg_wd">
						<h2 class="dropdown-toggle" data-toggle="dropdown">CERTIFIED BUYER</h2>
					</div>
					<!-- Ribbon side-fold (left and right) -->
					<div class="triangle-l triangle-l-lg-wd"></div>
					<div class="triangle-r triangle-r-lg-wd"></div>
				</div>


			</div>

		</div>
	</div>
	
	</div>
	
	</div>
</div>

