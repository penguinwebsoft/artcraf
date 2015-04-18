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

				/**********best seller and best sold products section*****************/
				var clickEvent = false;
				$('#myCarousel').on('click', '.nav a', function() {
					clickEvent = true;
					$('.nav li').removeClass('active');
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
								}
							}
							clickEvent = false;
						});

				/**********best seller and best sold products section*****************/

				$('#thumbCarousel').carousel({
					interval : 10000
				})

				$('#carousel-example-product1').carousel({
					interval : 1000
				});

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

<body style="background-image: url(${context}/resources/img/background_img.jpg);">
	<div class="container-fluid">
		<nav id="top">
			<div class="container">

				<div id="top-links" class="nav pull-right" style="padding-top: 0px;">
					<ul class="list-inline no_margin">

						<li><a href="${baseURL}/menu/login" title="Sell on Crafart" style="vertical-align: middle;"> <i class="icon-shopping-cart pull-left"></i> <span
								class="hidden-xs hidden-sm hidden-md col-lg-12">Sell on Crafart</span>
						</a></li>

						<li><a href="#" title="Track your Order"> <i class="icon-map-marker pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Track your Order</span>
						</a></li>

						<li><a href="#"> <i class="icon-phone pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Contact Us</span></a></li>

						<li><a href="${baseURL}/menu/registration" title="Sign Up"> <i class="icon-chevron-sign-up pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Sign Up</span>
						</a></li>

						<li><a href="${baseURL}/menu/customerLogIn" title="Login In"> <i class="icon-signin pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Login</span>
						</a></li>

						<li><a href="#" title="Currency"> <i class="icon-inr pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Select Currency</span>
						</a></li>

						<li>
							<form action="#" method="post" enctype="multipart/form-data" id="currency" class="no_margin">
								<div class="btn-group dropdown">
									<button class="btn btn-link dropdown-toggle" data-toggle="dropdown" style="padding: 2px;">
										<strong class="pull-left">$</strong> <span class="hidden-xs hidden-sm hidden-md col-lg-9 pull-left">Currency</span> <i class="icon-caret-down pull-right"></i>
									</button>

									<ul class="dropdown-menu">
										<li><button class="currency-select btn btn-link btn-block" type="button" name="GBP">£ Pound Sterling</button></li>
										<li><button class="currency-select btn btn-link btn-block" type="button" name="USD">$ US Dollar</button></li>
									</ul>
								</div>
								<input type="hidden" name="code" value="" /> <input type="hidden" name="redirect" value="#" />
							</form>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<!-- header section ends -->

	<!-- home page search box  starts  -->
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div id="logo">
					<a href="#"> <img src="${context}/resources/img/logo2.png" title="" alt="" class="img-responsive" style="margin-top: 10px;" /></a>
				</div>
			</div>
			<div class="col-sm-6">
				<div id="search" class="form-group input-group">
					<div class="input-group-btn">
						<button type="button" id="searchcategory" style="border-radius: 0px;" value="BLOG" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
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
					<div class="input-group-btn">
						<button type="button" class="btn btn-success" style="border-radius: 0px; padding-top: 9px;">
							<i class="icon-search"></i>
						</button>
					</div>
				</div>
			</div>
			<div id="headerDropDownId" class="col-sm-3" style="margin-top: -5px;">
				<div class="col-xs-7">
					<div class="dropdown">
						<span class="dropdown-toggle" id="signInDropDownId" data-toggle="dropdown" style="color: #428bca;"> Sign in Your Orders&nbsp;&nbsp; <span class="icon-caret-down"></span>
						</span>
						<ul class="dropdown-menu font_Size_12" role="menu" aria-labelledby="menu1" style="min-width: 150px;">

							<li role="presentation"><a class="btn btn-warning btn-flat btn-rect" href="#">sign in</a></li>
							<li role="presentation" class="divider" style="margin-bottom: 2px;"></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Your Account</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">order Account</a></li>
						</ul>
					</div>
				</div>
				<div class="col-xs-5">
					<div class="dropdown">
						<span class="dropdown-toggle" id="cartDropDownId" data-toggle="dropdown" style="color: #428bca;"> <span class="icon-shopping-cart"></span> &nbsp;&nbsp; Cart
						</span>
						<ul class="dropdown-menu font_Size_12" role="menu" aria-labelledby="menu1" style="min-width: 100px;">
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">sign in </a></li>
							<li role="presentation" class="divider" style="margin-bottom: 2px;"></li>
							<li role="presentation"><a class="btn btn-warning btn-flat btn-rect" href="#">View Cart</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- home page search box ends here -->


	<!-- slider banner starts here -->
	<div class="container-fluid">
		<div class="row-fluid">
			<nav class="navbar navbar-inverse navbar-static-top marginBottom-0" role="navigation" style="background-color: #332619; min-height: 40px;">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand visible-sm" href="#" target="_blank">Category</a>
				</div>

				<div class="collapse navbar-collapse" id="navbar-collapse-1">
					<ul class="nav navbar-nav" style="float: inherit;">
						<li class="col-sm-2"><a href="#"></a></li>
						<li id="categoryDropDownId" class="dropdown col-sm-2"><a href="#" class="dropdown-toggle text-center">SEE ALL CATEGORY <b class="caret"></b>
						</a>
							<ul id="dropdownMenuId" class="dropdown-menu pull-right" style="min-width: 198px; margin-right: 8px; margin-top: 10px; border-radius: 0px">
								<li><a href="#">Dropdown 1</a></li>
								<li><a href="#">Dropdown Link 2</a></li>
								<li><a href="#">Dropdown Link 3</a></li>
								<li><a href="#">Dropdown Link 4</a></li>
								<li><a href="#">Dropdown Link 5</a></li>
								<li><a href="#">Dropdown Link 6</a></li>
								<li><a href="#">Dropdown Link 7</a></li>
								<li><a href="#">Dropdown Link 8</a></li>
								<li><a href="#">Dropdown Link 9</a></li>
								<li><a href="#">Dropdown Link 10</a></li>
								<li><a href="#">Dropdown Link 11</a></li>
								<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown" id="sampleLinkId">Dropdown Link 12</a> <!-- <div class="" id="addFrame" style="z-index: 0; background-color: black;"> -->
									<div class="div-submenu-container" style="margin-top: -292px; height: 337px; width: 650px; border-radius: 0px; background-image: url('resources/img/Fashion.jpg')">
										<ul class="dropdown-menu" style="z-index: 1; position: relative;">
											<li><a href="#">Dropdown 12.1</a></li>
											<li><a href="#">Dropdown 12.2</a></li>
											<li><a href="#">Dropdown 12.3</a></li>
											<li><a href="#">Dropdown 12.4</a></li>
										</ul>
									</div></li>
								<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown 13</a>
									<div class="div-submenu-container" style="margin-top: -317px; height: 337px; width: 650px; border-radius: 0px; background-image: url(' resources/ img/ Fashion.jpg">
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
						<li class="col-sm-1"><a href="#">Link</a></li>
						<li class="col-sm-1"><a href="#">Link</a></li>
						<li class="col-sm-1"><a href="#">Link</a></li>
						<li class="col-sm-1"><a href="#">Link</a></li>
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
						<img src="${context}/resources/img/1.jpg" alt="...">
					</div>
					<div class="item">
						<img src="${context}/resources/img/2.jpg" alt="...">
					</div>

					<div class="item">
						<img src="${context}/resources/img/3.jpg" alt="...">
					</div>

					<div class="item">
						<img src="${context}/resources/img/4.jpg" alt="...">
					</div>
					<div class="item">
						<img src="${context}/resources/img/5.jpg" alt="...">
					</div>

					<div class="item">
						<img src="${context}/resources/img/6.jpg" alt="...">
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

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-sm-9">
				<div class="row">

					<div class="panel panel-default" style="border-radius: 0px; border: 0px; background-color: transparent;">

						<!--  first carousel starts here -->
						<div class="container" style="margin-left: 15px">
							<div class="row">
								<!-- header section  -->
								<div style="margin-bottom: 5px;">
									<ol class="breadcrumb" style="margin-bottom: 0px; border-radius: 0px; background-color: #332619;">
										<li class="active">HOME AND LIVING</li>
									</ol>
								</div>

								<!-- header section  -->

								<!-- multi items carousel container -->
								<div id="thumbCarousel" class="carousel slide">

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
								<!-- multi items carousel container -->
								<!--/thumbCarousel-->
							</div>
							<!--/well-->
							<div class="row" id="Product1_description">
								<div class="col-md-3 text-center col-sm-3">
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
								<div class="col-md-3 text-center col-sm-3">
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
								<div class="col-md-3 text-center col-sm-3">
									<div class="thumbnail product-box">
										<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />

										<div class="caption">
											<h3>
												<a href="#">coffee tea sets</a>
											</h3>
										</div>
									</div>
								</div>

								<div class="col-md-3 text-center col-sm-3">
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
								<div id="myCarousel" class="carousel slide tabsContainer" data-ride="carousel">
									<!-- Wrapper for slides -->
									<ul class="nav nav-pills nav-tabs  nav_tabs_bottom_border">
										<li data-target="#myCarousel" data-toggle="tab" data-slide-to="0" class="active"><a href="#" class="tab">BEST SELLERS</a></li>
										<li data-target="#myCarousel" data-toggle="tab" data-slide-to="1"><a href="#" class="tab">BEST SOLD PRODUCTS</a></li>
									</ul>
									<div class="carousel-inner">
										<!-- start item 1 -->
										<div class="item active">
											<div class="row">
												<div class="col-sm-3 col-xs-6">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/baking-dishes.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-3 col-xs-6">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-3 col-xs-6">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/kitchen-accessories.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-3 col-xs-6">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/tea-bags.jpg" alt="Image" class="img-responsive"></a>
												</div>
											</div>
										</div>
										<!-- End Item -->
										<!-- Start Item 2 -->
										<div class="item">
											<div class="row">
												<div class="col-sm-3 col-xs-6">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/baking-dishes.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-3 col-xs-6">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-3 col-xs-6">
													<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/kitchen-accessories.jpg" alt="Image" class="img-responsive"></a>
												</div>
												<div class="col-sm-3 col-xs-6">
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

						</div>
						<!--  first carousel ends here -->

						<!--  second carousel starts here -->
						<div class="container" style="margin-left: 15px">
							<div class="row">
								<div style="margin-bottom: 5px;">
									<ol class="breadcrumb" style="margin-bottom: 0px; border-radius: 0px; background-color: #332619;">
										<li class="active">HOME AND LIVING</li>
									</ol>
								</div>
								<div id="thumbCarousel" class="carousel slide">

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
							<div class="row" id="Product1_description">
								<div class="col-md-3 text-center col-sm-3">
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
								<div class="col-md-3 text-center col-sm-3">
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
								<div class="col-md-3 text-center col-sm-3">
									<div class="thumbnail product-box">
										<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />

										<div class="caption">
											<h3>
												<a href="#">coffee tea sets</a>
											</h3>
										</div>
									</div>
								</div>

								<div class="col-md-3 text-center col-sm-3">
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
						<!--  second carousel ends here -->

						<!--  thrid carousel starts here -->
						<div class="container" style="margin-left: 15px">
							<div class="row">
								<div style="margin-bottom: 5px;">
									<ol class="breadcrumb" style="margin-bottom: 0px; border-radius: 0px; background-color: #332619;">
										<li class="active">HOME AND LIVING</li>
									</ol>
								</div>
								<div id="thumbCarousel" class="carousel slide">

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
							<div class="row" id="Product1_description">
								<div class="col-md-3 text-center col-sm-3">
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
								<div class="col-md-3 text-center col-sm-3">
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
								<div class="col-md-3 text-center col-sm-3">
									<div class="thumbnail product-box">
										<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />

										<div class="caption">
											<h3>
												<a href="#">coffee tea sets</a>
											</h3>
										</div>
									</div>
								</div>

								<div class="col-md-3 text-center col-sm-3">
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

					</div>
				</div>
			</div>


			<!-- product category wise listing , best seller, sold product sections ends here -->

			<!-- right side advertisement section starts here -->
			<div class="col-sm-3 text-center" id="advertishmentId">
				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="thumbnail">
						<img src="${context}/resources/img/advertisement/add_1.png" alt="" />
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_2.png" alt="" />
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_3.png" alt="" />
					</div>
				</div>

				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_4.png" alt="" />
					</div>
				</div>

				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_5.png" alt="" />
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_6.png" alt="" />
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_7.png" alt="" />
					</div>
				</div>

				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_8.png" alt="" />
					</div>
				</div>

				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="thumbnail">
						<img src="${context}/resources/img/advertisement/add_1.png" alt="" />
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_2.png" alt="" />
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_3.png" alt="" />
					</div>
				</div>

				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_4.png" alt="" />
					</div>
				</div>
			</div>
			<!-- right side advertisement section ends here -->
		</div>
	</div>


	<!-- footer section starts here -->
	<div class="container-fluid" style="margin-left: 25px">
		<div class="row-fluid" id="footers">
			<div class="col-sm-12">
				<div class="col-sm-3">
					<div>
						<h4 class="line3 center standart-h4title">
							<span>CRAFART</span>
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
							<span>HELP</span>
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
							<span>TERMS & POLICY</span>
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

				<div class="col-sm-3">
					<div>
						<h4 class="line3 center standart-h4title">
							<span>SELLER ZONE</span>
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
		</div>
	</div>


	<div class="container-fluid" style="margin-left: 25px">
		<div class="col-sm-12">
			<div class="row">
				<br>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="row">
				<strong>Mobiles :</strong> <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
				| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |
				<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | view all items
			</div>
		</div>
		<div class="col-sm-12">
			<div class="row">
				<strong>Laptops :</strong> <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx Laptops</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
				| <a href="#">Sony Laptops</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a>
				| <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | view all items
			</div>
		</div>
		<div class="col-sm-12">
			<div class="row">
				<strong>Tablets : </strong><a href="#">samsung</a> | <a href="#">Sony Tablets</a> | <a href="#">Microx</a> | <a href="#">samsung </a>| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
				| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung Tablets</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung Tablets</a> | <a href="#">Sony</a> | <a
					href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx Tablets</a> | view all items
			</div>
		</div>
		<div class="col-sm-12">
			<div class="row">
				<strong>Computers :</strong> <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | <a href="#">samsung Computers</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a
					href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx Computers</a> |<a href="#">samsung Computers</a> | <a
					href="#">Sony</a> | <a href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx Computers</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a>
				| view all items
			</div>
		</div>

	</div>


	<div class="container fontSize11px" style="margin-left: 35px">
		<div class="row">
			<p>Launched in February 2010, Snapdeal.com is India's largest e-commerce marketplace. Snapdeal provides a platform for vendors across the country to connect with millions of customers. Our
				online shopping platform has the widest assortment of products from thousands of national, international and regional brands across diverse categories like Mobiles, Laptops, Cameras, Appliances,
				Women's Apparel, Men's Apparel, Watches, Home & Kitchen, Automotive and Health. Grab your favorite products at best prices and save the one thing that matters most to you - "Your Money".</p>
		</div>
	</div>
	<div class="container-fluid colortransparent" style="margin-left: 20px">
		<div class="row-fluid">
			<div class=" col-md-12 col-sm-6 col-xs-6">
				<img src="${context}/resources/img/footer_sprite.jpg" alt="" />

			</div>
		</div>

		<div class="row-fluid text-center">
			<hr>
			<p>Copyright© 2015.Crafart.All Rights Reserved.</p>
		</div>

		<!-- footer section ends here -->
</body>
</html>