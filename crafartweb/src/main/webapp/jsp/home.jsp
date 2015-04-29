<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<title>Crafart Home page</title>

<link rel="stylesheet" href="${context}/resources/plugins/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${context}/resources/plugins/Font-Awesome/css/font-awesome.css" />
<link rel="stylesheet" href="${context}/resources/css/main.css" />
<link rel="stylesheet" href="${context}/resources/css/homeStyle.css" />

<!--START SCRIPTS -->
<script src="${context}/resources/javascript/jquery-core/jquery-1.11.0.min.js"></script>
<script src="${context}/resources/javascript/jquery-ui-1.10.3/ui/jquery-ui.min.js"></script>
<script src="${context}/resources/javascript/menuHighlight/highlight.js"></script>
<script src="${context}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
<script>
	$(document).ready(
			function() {

				getImageSizes();
				$(window).resize(function() { //Fires when window is resized
					getImageSizes();
				});

				/********************Adding body background image on load of document******************/
				
				var imageURL = "url("+$('#bgImage').val()+"/resources/img/background_img.jpg) no-repeat fixed 0 0 / 100% auto";

				$('body').css('background', imageURL);

				/********************Adding body background image on load of document******************/

				/**********best seller and best sold products section*****************/
				var clickEvent = false;
				$('#myCarousel').on('click', '.nav a', function() {
					clickEvent = true;
					$('.nav li').removeClass('active');
					$('.nav li').removeClass('arrow_box');
					$(this).parent().addClass('arrow_box');
					$(this).parent().addClass('active');
				}).on(
						'slid.bs.carousel',
						function(e) {
							if (!clickEvent) {
								var count = $('.nav').children().length - 1;
								var current = $('.nav li.active');
								current.removeClass('active').next().addClass(
										'active');
								var id = parseInt(current.data('slide-to'));
								if (count == id) {
									$('.nav li').first().addClass('active');
									$('.nav li').first().addClass('arrow_box');

								}
							}
							clickEvent = false;
						});

				/**********best seller and best sold products section*****************/

				$('#thumbCarousel').carousel({
					interval : 10000
				})

				$('#thumbCarousel1').carousel({
					interval : 10000
				})

				$('#thumbCarousel2').carousel({
					interval : 10000
				})

				$('#thumbCarousel3').carousel({
					interval : 10000
				})

				$('#categoryDropDownId').addClass('open');
				$('#categoryDropDownId #dropdownMenuId').on({
					"click" : function(e) {
						e.stopPropagation();
					}
				});

				$('.nav-tabs > li > a').hover(function() {
					$(this).tab('show');
				});

				var position = $("#dropdownMenuId").position();
				var width = $("#dropdownMenuId").width();
				$("#addFrame").css("margin-top", position.top + "px");
				$("#addFrame").css("margin-right", position.top + "px");

				$("#searchdropdown li a").click(
						function() {
							$("#searchcategory").html(
									$(this).text()
											+ ' <span class="caret"></span>');
							$("#searchcategory").val($(this).text());
						});

			});

	function getImageSizes() {
		$("#carousel-example-generic").each(function() {
			var $height = $(this);
			$('#addFrame').css({
				'height' : $height.height() + 'px'
			});
		});
	}
</script>
</head>

<body>
	<input type="hidden" id="bgImage" value="${context}" />
	<div class="container-fluid padding-top">
		<nav id="top">
			<div class="row-fluid">
				<div id="top-links" class="nav pull-right" style="padding-top: 0px;">
					<ul class="list-inline no_margin">

						<li><a href="${baseURL}/menu/login" title="Sell on Crafart" style="vertical-align: middle;"> <i class="icon-shopping-cart pull-left"></i> <span
								class="hidden-xs hidden-sm hidden-md col-lg-12">Sell on Crafart</span>
						</a></li>

						<li><a href="${baseURL}/menu/productDetails" title="Track your Order"> <i class="icon-map-marker pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Track your Order</span>
						</a></li> 

						<li><a href="${baseURL}/menu/customerPanel"> <i class="icon-phone pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Contact Us</span></a></li>

						<li><a href="${baseURL}/menu/registration" title="Sign Up"> <i class="icon-chevron-sign-up pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Sign Up</span>
						</a></li>

						<li><a href="${baseURL}/menu/customerLogIn" title="Login In"> <i class="icon-signin pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Login</span>
						</a></li>

						<li>
							<form action="#" method="post" enctype="multipart/form-data" id="currency" class="no_margin">
								<div class="btn-group dropdown">
									<button class="btn btn-link dropdown-toggle" data-toggle="dropdown" style="padding: 2px;">
										<strong class="pull-left">&#x20b9;</strong> <span class="hidden-xs hidden-sm hidden-md col-lg-9 pull-left">Ruppee</span> <i class="icon-caret-down pull-right"></i>
									</button>

									<ul class="dropdown-menu pull-left">
										<li><button class="currency-select btn btn-link btn-block" type="button" name="GBP">&#x20b9; Dummy</button></li>
									</ul>
								</div>
								<input type="hidden" name="code" value="" /> <input type="hidden" name="redirect" value="#" />
							</form>
						</li>
						<li><a href="#" title="Login In"></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<!-- header section ends -->

	<!-- home page search box  starts  -->
	<div class="container-fluid">
		<div class="row" style="width: 95%">
			<div class="col-sm-3">
				<div id="logo">
					<a href="#"> <img src="${context}/resources/img/logo.png" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" /></a>
				</div>
			</div>
			<div class="col-sm-6">
				<div id="search" class="form-group input-group">
					<div class="input-group-btn">
						<button type="button" id="searchcategory" value="BLOG" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
							BLOG <span class="caret"></span>
						</button>
						<ul id="searchdropdown" class="dropdown-menu" role="menu" style="border-radius: 0px;">
							<li><a href="javascript:void(0)">BLOG</a></li>
							<li><a href="javascript:void(0)">FORUM</a></li>
							<li><a href="javascript:void(0)">DOCS</a></li>
							<li class="divider"></li>
							<li><a href="javascript:void(0)">ANY</a></li>
						</ul>
					</div>
					<input type="text" style="border-radius: 0px;" name="search" value="" placeholder="Search" class="form-control" />
					<div id="searchBtn" class="input-group-btn">
						<button type="button" class="btn btn-success searchPad">Search</button>
					</div>
				</div>
			</div>

			<!-- see in your order starts here -->
			<div id="headerDropDownId" class="col-sm-3">
				<div class="row col-xs-7">
					<!-- Ribbon header -->
					<div class="rectangle rectanle_lg_wd dropdown">
						<h2 class="dropdown-toggle" data-toggle="dropdown">
							See in your orders <b class="caret"></b>
						</h2>
						<ul class="dropdown-menu font_Size_12" role="menu" aria-labelledby="menu1" style="min-width: 150px; color: white;">

							<li role="presentation" style="background-color: white;"><a class="btn btn-warning btn-flat btn-rect" href="#">sign in</a></li>
							<li role="presentation" class="divider" style="margin-bottom: 2px;"></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Your Account</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">order Account</a></li>
						</ul>
						<!-- Ribbon side-fold (left and right) -->
						<div class="triangle-l triangle-left-pos"></div>
						<div class="triangle-r triangle-right-pos"></div>
					</div>
					<!-- Ribbon header -->
					<!-- see in your order ends here -->
				</div>
				<div class="col-xs-5">
					<div class="dropdown row">
						<div class="rectangle_sm rectangle_sm_wd">
							<h2 class="dropdown-toggle" data-toggle="dropdown">
								Cart <i class="icon-shopping-cart"></i> <b class="caret"></b>
							</h2>
							<ul class="dropdown-menu font_Size_12" role="menu" aria-labelledby="menu1" style="min-width: 100px;">
								<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Sign in </a></li>
								<li role="presentation"><a rolw="menuitem" tabindex="-1" href="#">View Cart</a></li>
							</ul>
							<!-- Ribbon side-fold (left and right) -->
							<div class="triangle-l triangle-left-pos"></div>
							<div class="triangle-r triangle-right-pos"></div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- home page search box ends here -->


	<!-- slider banner starts here -->
	<div class="container-fluid">
		<div class="row-fluid">
			<nav class="navbar navbar-inverse navbar-static-top marginBottom-0" role="navigation" style="background-color: #332619; min-height: 40px; z-index: 1">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand visible-sm" href="#" target="_blank">Category</a>
				</div>

				<div class="collapse navbar-collapse" id="navbar-collapse-1">
					<ul class="dropdown nav navbar-nav" style="float: inherit; margin-top: 5px; margin-bottom: 0px">
						<li class="col-sm-2"><a href="#"></a></li>
						<li id="categoryDropDownId" class="col-sm-2"><a href="#" class="text-center dropdown-toggle" data-toggle="dropdown">SEE ALL CATEGORY <b class="caret"></b>
						</a>
							<ul id="dropdownMenuId" class="dropdown-menu pull-right" role="menu" style="min-width: 198px; margin-right: 8px; margin-top: 0px; border-radius: 0px;">
								<li role="presentation"><a role="menuitem" href="#">Designer Sarees</a></li>
								<li role="presentation"><a role="menuitem" href="#">Handicrafts</a></li>
								<li role="presentation"><a role="menuitem" href="#">Earthern wares</a></li>
								<li role="presentation"><a role="menuitem" href="#">Nature Products</a></li>
								<li role="presentation"><a role="menuitem" href="#">Color Paintings</a></li>
								<li role="presentation"><a role="menuitem" href="#">Paper Paintings</a></li>
								<li role="presentation"><a role="menuitem" href="#">Kids</a></li>
								<li role="presentation"><a role="menuitem" href="#">Women</a></li>
								<li role="presentation"><a role="menuitem" href="#">Mens Handicrafts</a></li>
								<li role="presentation"><a role="menuitem" href="#">Women Handicrafts</a></li>
								<li role="presentation"><a role="menuitem" href="#">Kides Handicrafts</a></li>
								<li role="presentation" class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown" id="sampleLinkId">Perfumes</a> <!-- <div class="" id="addFrame" style="z-index: 0; background-color: black;"> -->
									<div class="div-submenu-container" style="margin-top: -292px; height: 337px; width: 650px; border-radius: 0px; background-image: url('${context}/resources/img/Fashion.jpg')">
										<ul class="dropdown-menu" style="z-index: 1; position: relative;">
											<li><a href="#">Dropdown 12.1</a></li>
											<li><a href="#">Dropdown 12.2</a></li>
											<li><a href="#">Dropdown 12.3</a></li>
											<li><a href="#">Dropdown 12.4</a></li>
										</ul>
									</div></li>
								<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Khandikraft Products</a>
									<div class="div-submenu-container" style="margin-top: -317px; height: 337px; width: 650px; border-radius: 0px; background-image: url(' . ./ resources/ img/ Fashion.jpg">
										<ul class="dropdown-menu" style="z-index: 1;">
											<li><a href="#">Dropdown 13.1</a></li>
											<li><a href="#">Dropdown 13.2</a></li>
											<li><a href="#">Dropdown 13.3</a></li>
											<li class="divider"></li>
											<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown 13.4</a>
												<ul class="dropdown-menu">
													<li><a href="#">Dropdown 13.4.1</a></li>
													<li><a href="#">Dropdown 13.4.2</a></li>
													<li class="divider"></li>
													<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown 13.4.3</a>
														<ul class="dropdown-menu">
															<li><a href="#">Dropdown 13.4.3.1</a></li>
															<li><a href="#">Dropdown 13.4.3.2</a></li>
															<li><a href="#">Dropdown 13.4.3.3</a></li>
															<li><a href="#">Dropdown 13.4.3.4</a></li>
														</ul></li>
													<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown 13.4.4</a>
														<ul class="dropdown-menu">
															<li><a href="#">Dropdown 13.4.4.1</a></li>
															<li><a href="#">Dropdown 13.4.4.2</a></li>
															<li><a href="#">Dropdown 13.4.4.3</a></li>
															<li><a href="#">Dropdown 13.4.4.4</a></li>
														</ul></li>
												</ul></li>
										</ul>
									</div></li>
								<li><a href="#">SEE ALL CATEGORY</a></li>
							</ul></li>
						<li class="col-sm-1"><a href="#"></a></li>
						<li class="col-sm-1"><a href="#"></a></li>
						<li class="col-sm-1"><a href="#"></a></li>
						<li class="col-sm-1 padding-left padding-right"><a href="#">Exhibition</a></li>
						<li class="col-sm-1 padding-left padding-right"><a href="#">Paintings</a></li>
						<li class="col-sm-1 padding-left padding-right"><a href="#">Antique</a></li>
						<li class="col-sm-1 padding-left padding-right"><a href="#">Handlooms</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>


	<!-- slider banner ends here -->

	<!-- slider banner images starts here -->
	<div class="container-fluid">
		<div class="row-fluid">
			<div id="carousel-example-generic" class="carousel slide article-slide" data-ride="carousel" style="height: 335px;">
				<!-- Indicators -->

				<ol class="carousel-indicators" style="min-height: 31px;">
					<li class="" data-target="#carousel-example-generic" data-slide-to="0" class="active"><span>FURNITURE</span></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"><span>CLOTHES</span></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"><span>SPORTS-FITNESS</span></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"><span> ELECTRONICS</span></li>
					<li data-target="#carousel-example-generic" data-slide-to="4"><span>CAMERAS</span></li>
					<li data-target="#carousel-example-generic" data-slide-to="5"><span>KITCHEN</span></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="${context}/resources/img/1.jpg" alt="..." class="img-responsive">
					</div>
					<div class="item">
						<img src="${context}/resources/img/2.jpg" alt="..." class="img-responsive">
					</div>

					<div class="item">
						<img src="${context}/resources/img/3.jpg" alt="..." class="img-responsive">
					</div>

					<div class="item">
						<img src="${context}/resources/img/4.jpg" alt="..." class="img-responsive">
					</div>
					<div class="item">
						<img src="${context}/resources/img/1.jpg" alt="..." class="img-responsive">
					</div>

					<div class="item">
						<img src="${context}/resources/img/2.jpg" alt="..." class="img-responsive">
					</div>
				</div>

				<!-- Controls -->

				<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>

	<!-- slider banner images ends here -->

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-sm-12" style="background-color: #e4e4e4; height: 40px;"></div>
		</div>
	</div>

	<!-- product category wise listing , best seller, sold product sections start here -->
	<section>
		<div class="container-fluid" style="padding-top: 15px">
			<div class="row-fluid">
				<div class="col-sm-9">

					<div class="row">

						<!--  first carousel starts here -->
						<!-- header section  -->
						<div class="col-sm-12">
							<nav class="navbar breadcrumb_cust" role="navigation">
								<div data-toggle="collapse">
									<ul class="nav navbar-nav navbar-left">
										<li><a href="#">HOME AND LIVING</a></li>
									</ul>
									<ul class="nav navbar-nav navbar-right">
										<li><a href="#about">CATEGORY 1</a></li>
										<li><a href="#contact">CATEGORY 2</a></li>
									</ul>
								</div>
							</nav>
						</div>


						<!-- header section  -->

						<!-- multi items carousel container -->
						<div id="thumbCarousel" class="carousel slide col-sm-12">

							<!-- Carousel items -->
							<div class="carousel-inner">
								<div class="col-md-12  item active">
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
								<!--/row-->
								<!--/item-->
								<div class="col-md-12 item">
									<div class="row">
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp2.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp3.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp4.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp5.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp6.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<!--/row-->
									</div>
								</div>
							</div>
							<!--/carousel-inner-->

							<a class="left carousel-control" href="#carousel-example-product1" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="right carousel-control" href="#carousel-example-product1" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>
						<!-- multi items carousel container -->
						<!--/thumbCarousel-->
					</div>
					<!--/well-->
					<div class="row-fluid  padding-left" id="Product1_description">
						<div class="row" style="padding-right: 15px">
							<div class="col-md-3 text-center col-sm-3 padding-right">
								<div class="thumbnail product-box">
									<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />
									<div class="caption">
										<h3>
											<a href="#">coffee tea sets</a>
										</h3>
									</div>
								</div>
							</div>
							<!-- /.col -->
							<div class="col-md-3 text-center col-sm-3 padding-right">
								<div class="thumbnail product-box">
									<img src="${context}/resources/img/product2/description/dinner-sets.jpg" alt="" />
									<div class="caption">
										<h3>
											<a href="#">Dinner sets</a>
										</h3>
									</div>
								</div>
							</div>
							<!-- /.col -->
							<div class="col-md-3 text-center col-sm-3 padding-right">
								<div class="thumbnail product-box">
									<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />

									<div class="caption">
										<h3>
											<a href="#">coffee tea sets</a>
										</h3>
									</div>
								</div>
							</div>

							<div class="col-md-3 text-center col-sm-3  padding-right">
								<div class="thumbnail product-box">
									<img src="${context}/resources/img/product2/description/dinner-sets.jpg" alt="" />
									<div class="caption">
										<h3>
											<a href="#">Dinner sets</a>
										</h3>
									</div>
								</div>
							</div>
						</div>

						<!-- best seller and best sold products tabs section starts here -->
						<div class="row">
							<!-- Wrapper for slides -->
							<div class="col-md-12" id="myCarousel">
								<ul class="breadcrumb_cust nav nav-pills nav-tabs  nav_tabs_bottom_border" style="padding: 0px">
									<li data-target="#myCarousel" data-toggle="tab" data-slide-to="0" class="active arrow_box"><a href="#" class="tab">BEST SELLERS</a></li>
									<li data-target="#myCarousel" data-toggle="tab" data-slide-to="1"><a href="#" class="tab">BEST SOLD PRODUCTS</a></li>
								</ul>
							</div>
							<div id="thumbCarousel1" class="carousel slide tabsContainer">
								<div class="carousel-inner">
									<!-- start item 1 -->
									<div class="item active  col-md-12">
										<div class="row">
											<div class="col-sm-3 ">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/baking-dishes.jpg" alt="Image" class="img-responsive"></a>
											</div>
											<div class="col-sm-3 ">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
											</div>
											<div class="col-sm-3 ">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/kitchen-accessories.jpg" alt="Image" class="img-responsive"></a>
											</div>
											<div class="col-sm-3 ">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/tea-bags.jpg" alt="Image" class="img-responsive"></a>
											</div>
										</div>
									</div>
									<!-- End Item -->
									<!-- Start Item 2 -->
									<div class="item col-md-12">
										<div class="row">
											<div class="col-sm-3 ">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/baking-dishes.jpg" alt="Image" class="img-responsive"></a>
											</div>
											<div class="col-sm-3 ">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
											</div>
											<div class="col-sm-3 ">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/kitchen-accessories.jpg" alt="Image" class="img-responsive"></a>
											</div>
											<div class="col-sm-3 ">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/tea-bags.jpg" alt="Image" class="img-responsive"></a>
											</div>
										</div>
									</div>
									<!--  End Item -->
								</div>
								<!-- End Carousel Inner -->

							</div>
							<!-- End Carousel -->
						</div>
						<!-- best seller and best sold products tabs section ends here -->

						<!--  first carousel ends here -->

						<!--  second carousel starts here -->
						<div class="row-fluid">
							<!-- CATEGORY HEADING -->
							<div>
								<nav class="navbar breadcrumb_cust" role="navigation">
									<div data-toggle="collapse">
										<ul class="nav navbar-nav navbar-left">
											<li><a href="#">HOME AND LIVING</a></li>
										</ul>
										<ul class="nav navbar-nav navbar-right">
											<li><a href="#about">CATEGORY 1</a></li>
											<li><a href="#contact">CATEGORY 2</a></li>
										</ul>
									</div>
								</nav>
							</div>
							<!-- CATEGORY HEADING ENDS -->
							<div id="thumbCarousel2" class="carousel slide ">

								<!-- Carousel items -->
								<div class="carousel-inner">
									<div class="col-md-12 item active">
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
											<!--/row-->
										</div>
									</div>
									<!--/item-->
									<div class="col-md-12 item">
										<div class="row">
											<div class="col-sm-2">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
											</div>
											<div class="col-sm-2">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp2.jpg" alt="Image" class="img-responsive"></a>
											</div>
											<div class="col-sm-2">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp3.jpg" alt="Image" class="img-responsive"></a>
											</div>
											<div class="col-sm-2">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp4.jpg" alt="Image" class="img-responsive"></a>
											</div>
											<div class="col-sm-2">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp5.jpg" alt="Image" class="img-responsive"></a>
											</div>
											<div class="col-sm-2">
												<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp6.jpg" alt="Image" class="img-responsive"></a>
											</div>
										</div>
									</div>
									<!--/row-->
								</div>
								<!--/carousel-inner-->

								<a class="left carousel-control" href="#carousel-example-product1" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
									class="sr-only">Previous</span>
								</a> <a class="right carousel-control" href="#carousel-example-product1" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
									class="sr-only">Next</span>
								</a>
							</div>
							<!--/thumbCarousel-->
						</div>
						<!--/well-->
						<div class="row-fluid" id="Product1_description">
							<div class="row" style="padding-right: 15px">
								<div class="col-md-3 text-center col-sm-3 padding-right">
									<div class="thumbnail product-box">
										<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />
										<div class="caption">
											<h3>
												<a href="#">coffee tea sets</a>
											</h3>
										</div>
									</div>
								</div>
								<!-- /.col -->
								<div class="col-md-3 text-center col-sm-3 padding-right">
									<div class="thumbnail product-box">
										<img src="${context}/resources/img/product2/description/dinner-sets.jpg" alt="" />
										<div class="caption">
											<h3>
												<a href="#">Dinner sets</a>
											</h3>
										</div>
									</div>
								</div>
								<!-- /.col -->
								<div class="col-md-3 text-center col-sm-3 padding-right">
									<div class="thumbnail product-box">
										<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />

										<div class="caption">
											<h3>
												<a href="#">coffee tea sets</a>
											</h3>
										</div>
									</div>
								</div>

								<div class="col-md-3 text-center col-sm-3 padding-right">
									<div class="thumbnail product-box">
										<img src="${context}/resources/img/product2/description/dinner-sets.jpg" alt="" />
										<div class="caption">
											<h3>
												<a href="#">Dinner sets</a>
											</h3>
										</div>
									</div>
								</div>
							</div>
							<!--  second carousel ends here -->

							<!--  thrid carousel starts here -->
							<div class="row-fluid">
								<div>
									<nav class="navbar breadcrumb_cust" role="navigation">
										<div data-toggle="collapse">
											<ul class="nav navbar-nav navbar-left">
												<li><a href="#">HOME AND LIVING</a></li>
											</ul>
											<ul class="nav navbar-nav navbar-right">
												<li><a href="#about">CATEGORY 1</a></li>
												<li><a href="#contact">CATEGORY 2</a></li>
											</ul>
										</div>
									</nav>
								</div>
								<div id="thumbCarousel3" class="carousel slide">

									<!-- Carousel items -->
									<div class="carousel-inner">
										<div class="col-md-12 item active">
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
										<div class="col-md-12 item">
											<div class="row">
												<div class="col-sm-2">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-2">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp2.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-2">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp3.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-2">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp4.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-2">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp5.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-2">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp6.jpg" alt="Image" class="img-responsive"></a>
												</div>
											</div>
											<!--/row-->
										</div>
									</div>
									<!--/carousel-inner-->

									<a class="left carousel-control" href="#carousel-example-product1" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
										class="sr-only">Previous</span>
									</a> <a class="right carousel-control" href="#carousel-example-product1" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
										class="sr-only">Next</span>
									</a>
								</div>
								<!--/thumbCarousel-->
							</div>
							<!--/well-->
							<div class="row-fluid" id="Product1_description">
								<div class="row" style="padding-right: 15px">
									<div class="col-md-3 text-center col-sm-3 padding-right">
										<div class="thumbnail product-box">
											<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />
											<div class="caption">
												<h3>
													<a href="#">coffee tea sets</a>
												</h3>
											</div>
										</div>
									</div>
									<!-- /.col -->
									<div class="col-md-3 text-center col-sm-3 padding-right">
										<div class="thumbnail product-box">
											<img src="${context}/resources/img/product2/description/dinner-sets.jpg" alt="" />
											<div class="caption">
												<h3>
													<a href="#">Dinner sets</a>
												</h3>
											</div>
										</div>
									</div>
									<!-- /.col -->
									<div class="col-md-3 text-center col-sm-3 padding-right">
										<div class="thumbnail product-box">
											<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />

											<div class="caption">
												<h3>
													<a href="#">coffee tea sets</a>
												</h3>
											</div>
										</div>
									</div>

									<div class="col-md-3 text-center col-sm-3 padding-right">
										<div class="thumbnail product-box">
											<img src="${context}/resources/img/product2/description/dinner-sets.jpg" alt="" />
											<div class="caption">
												<h3>
													<a href="#">Dinner sets</a>
												</h3>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!--    third carousel ends here -->
							<!-- All Stores section starts -->

							<div class="row-fluid">
								<!-- CATEGORY HEADING -->
								<div>
									<nav class="navbar breadcrumb_cust" role="navigation">
										<div data-toggle="collapse">
											<ul class="nav navbar-nav navbar-left">
												<li><a href="#">All Other Stores</a></li>
											</ul>
											<ul class="nav navbar-nav navbar-right">
												<li><a href="#about">CATEGORY 1</a></li>
												<li><a href="#contact">CATEGORY 2</a></li>
											</ul>
										</div>
									</nav>
								</div>
								<!-- CATEGORY HEADING ENDS -->
								<div id="thumbCarousel2" class="carousel slide ">

									<!-- Carousel items -->
									<div class="carousel-inner">
										<div class="col-md-12 item active">
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
												<!--/row-->
											</div>
										</div>
										<!--/item-->
										<div class="col-md-12 item">
											<div class="row">
												<div class="col-sm-2">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-2">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp2.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-2">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp3.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-2">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp4.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-2">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp5.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-2">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp6.jpg" alt="Image" class="img-responsive"></a>
												</div>
											</div>
										</div>
										<!--/row-->
									</div>
									<!--/carousel-inner-->

									<a class="left carousel-control" href="#carousel-example-product1" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
										class="sr-only">Previous</span>
									</a> <a class="right carousel-control" href="#carousel-example-product1" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
										class="sr-only">Next</span>
									</a>
								</div>
								<!--/thumbCarousel-->
							</div>


							<!-- All stores section ends -->
						</div>
					</div>


				</div>
			</div>


			<!-- product category wise listing , best seller, sold product sections ends here -->

			<!-- right side advertisement section starts here -->
			<div id="adverstisment" class="row-fluid">
				<div class="col-sm-3 text-center" id="advertishmentId">
					<div class="row margin-left-30-">
						<div class=" col-md-12 col-sm-6 col-xs-push-12">
							<div class="thumbnail">
								<img src="${context}/resources/img/advertisement/add_1.png" alt="" />
							</div>
						</div>
						<div class=" col-md-12 col-sm-6 col-xs-push-12">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/advertisement/add_2.png" alt="" />
							</div>
						</div>
						<div class=" col-md-12 col-sm-6 col-xs-push-12">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/advertisement/add_3.png" alt="" />
							</div>
						</div>

						<div class=" col-md-12 col-sm-6 col-xs-push-12">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/advertisement/add_4.png" alt="" />
							</div>
						</div>

						<div class=" col-md-12 col-sm-6 col-xs-push-12">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/advertisement/add_5.png" alt="" />
							</div>
						</div>
						<div class=" col-md-12 col-sm-6 col-xs-push-12">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/advertisement/add_6.png" alt="" />
							</div>
						</div>
						<div class=" col-md-12 col-sm-6 col-xs-push-12">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/advertisement/add_7.png" alt="" />
							</div>
						</div>

						<div class=" col-md-12 col-sm-6 col-xs-push-12">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/advertisement/add_8.png" alt="" />
							</div>
						</div>

						<div class=" col-md-12 col-sm-6 col-xs-push-12">
							<div class="thumbnail">
								<img src="${context}/resources/img/advertisement/add_1.png" alt="" />
							</div>
						</div>
						<div class=" col-md-12 col-sm-6 col-xs-push-12">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/advertisement/add_2.png" alt="" />
							</div>
						</div>
						<div class=" col-md-12 col-sm-6 col-xs-push-12">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/advertisement/add_3.png" alt="" />
							</div>
						</div>

						<div class=" col-md-12 col-sm-6 col-xs-push-12">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/advertisement/add_4.png" alt="" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- right side advertisement section ends here -->

		</div>
	</section>

	<!-- footer section starts here -->
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-lg-12 col-xs-12 col-md-3 fk-mainfooter" id="footers">
				<div style="margin-left: 120px; margin-right: 120px">
					<div class="row">
						<div class="col-sm-3 col-xs-6 padding-left">
							<div>
								<h4 class="line3 center standart-h4title">
									<span class="fontCorsiva">CRAFART</span>
								</h4>
								<ul class="footer-links">
									<li><a href="#">Home</a></li>
									<li><a href="#">About Us</a></li>
									<li><a href="#">Contact Us</a></li>
									<li><a href="#">Careers</a></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-3">
							<div>
								<h4 class="line3 center standart-h4title">
									<span class="fontCorsiva">HELP</span>
								</h4>
								<ul class="footer-links">
									<li><a href="#">FAQ</a></li>
									<li><a href="#">Sitemap</a></li>
									<li><a href="#">How to buy</a></li>
								</ul>
							</div>
						</div>

						<div class="col-sm-3">
							<div>
								<h4 class="line3 center standart-h4title">
									<span class="fontCorsiva">TERMS & POLICY</span>
								</h4>
								<ul class="footer-links">
									<li><a href="#">Terms & Conditions</a></li>
									<li><a href="#">Policy for buyers</a></li>
									<li><a href="#">Policy for sellers</a></li>
									<li><a href="#">Privacy Policy</a></li>
									<li><a href="#">Shipping & Return Policies</a></li>
								</ul>
							</div>
						</div>

						<div class="col-sm-3 padding-right">
							<div>
								<h4 class="line3 center standart-h4title">
									<span class="fontCorsiva">SELLER ZONE</span>
								</h4>
								<ul class="footer-links">
									<li><a href="#">Seller Sign Up</a></li>
									<li><a href="#">Seller Login</a></li>
									<li><a href="#">Allowed Products for sale</a></li>
									<li><a href="#">Copyright Policy</a></li>
									<li><a href="#">FAQ for sellers</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12 col-sm-12 col-xs-12  fk-footer-ssa">
							<a class="login-required col-lg-12 col-xs-12  col-sm-12" href="#">
								<ul class="line ssa-block col-xs-12" style="margin: 5px">
									<li class="unit size1of3 ssa-unit col-sm-1 col-xs-push-12"><i style="width: 40%; float: left" class="glyphicon glyphicon-map-marker"></i> <span style="width: 40%; float: left;"
										class="text"> Track your order </span></li>
									<li class="unit size1of3 ssa-unit col-sm-1 col-xs-push-12"><i style="width: 40%; float: left" class="glyphicon glyphicon-map-marker"></i> <span style="width: 40%; float: left;"
										class="text"> Free & easy <br> returns
									</span></li>
									<li class="lastUnit ssa-unit col-sm-1 col-xs-push-12"><i style="width: 40%; float: left" class="glyphicon glyphicon-map-marker"></i><span style="width: 40%; float: left;" class="text">
											Online <br> cancellations
									</span></li>
								</ul>
							</a>
						</div>

						<div class="col-md-12 container-fluid  fontSize11px">
							<div class="row-fluid small-box ">
								<strong>Mobiles :</strong> <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
								| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a>
								| <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | view all items
							</div>
							<div class="row-fluid small-box ">
								<strong>Laptops :</strong> <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx Laptops</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a
									href="#">samsung</a> | <a href="#">Sony Laptops</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a>
								| <a href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | view all items
							</div>
							<div class="row-fluid small-box ">
								<strong>Tablets : </strong><a href="#">samsung</a> | <a href="#">Sony Tablets</a> | <a href="#">Microx</a> | <a href="#">samsung </a>| <a href="#">Sony</a> | <a href="#">Microx</a> |<a
									href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung Tablets</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung Tablets</a> | <a
									href="#">Sony</a> | <a href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx
									Tablets</a> | view all items

							</div>
							<div class="row-fluid small-box pad-botom ">
								<strong>Computers :</strong> <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | <a href="#">samsung Computers</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a
									href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx Computers</a> |<a href="#">samsung Computers</a> | <a
									href="#">Sony</a> | <a href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx Computers</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a>
								| view all items
							</div>
						</div>

						<div class="container-fluid fontSize11px">
							<div class="row-fluid">
								<p>Launched in February 2010, Snapdeal.com is India's largest e-commerce marketplace. Snapdeal provides a platform for vendors across the country to connect with millions of customers. Our
									online shopping platform has the widest assortment of products from thousands of national, international and regional brands across diverse categories like Mobiles, Laptops, Cameras,
									Appliances, Women's Apparel, Men's Apparel, Watches, Home & Kitchen, Automotive and Health. Grab your favorite products at best prices and save the one thing that matters most to you - "Your
									Money".</p>
							</div>
						</div>
						<div class="container-fluid colortransparent">
							<div class="col-md-12 col-sm-6 col-xs-6 padding-left">
								<img src="${context}/resources/img/footer_sprite.jpg" alt="" />

							</div>
						</div>
					</div>
					<div class="row text-center">
						<hr>
						<p>Copyright© 2015.Crafart.All Rights Reserved.</p>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>