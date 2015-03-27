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
	$(document).ready(function() {

		getImageSizes();
		$(window).resize(function() { //Fires when window is resized
			getImageSizes();
		});

		$('.carousel').carousel({
			interval : 2000
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
	<div class="row">
		<nav id="top">
			<div class="container">

				<div id="top-links" class="nav pull-right">
					<ul class="list-inline no_margin">

						<li><a href="${baseURL}/menu/login" title="Sell on Crafart" style="vertical-align: middle;"> <i class="icon-shopping-cart pull-left"></i> <span
								class="hidden-xs hidden-sm hidden-md col-lg-12">Sell on Crafart</span>
						</a></li>

						<li><a href="#" title="Track your Order"> <i class="icon-map-marker pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Track your Order</span>
						</a></li>

						<li><a href="#"> <i class="icon-phone pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Contact Us</span></a></li>

						<li><a href="#" title="Sign Up"> <i class="icon-chevron-sign-up pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Sign Up</span>
						</a></li>

						<li><a href="#" title="Login In"> <i class="icon-signin pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Login</span>
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

	<div class="row">
		<div class="col-sm-3" style="padding-left: 50px; margin-top: -5px;">
			<div id="logo">
				<a href="#"> <img src="${context}/resources/img/logo2.png" title="" alt="" class="img-responsive" style="margin-top: 10px;" /></a>
			</div>
		</div>
		<div class="col-sm-6">
			<div id="search" class="input-group">
				<input type="text" name="search" value="" placeholder="Search" class="form-control input-lg" /> <span class="input-group-btn" style="height: 40px;">
					<button type="button" class="btn btn-default btn-lg no_margin">
						<i class="icon-search"></i>
					</button>
				</span>
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
					<ul class="dropdown-menu font_Size_12" role="menu" aria-labelledby="menu1" style="min-width: 150px;">
						<li role="presentation"><a role="menuitem" tabindex="-1" href="#">If you already<br> have an account, <br>sign in.
						</a></li>
						<li role="presentation" class="divider" style="margin-bottom: 2px;"></li>
						<li role="presentation"><a class="btn btn-warning btn-flat btn-rect" href="#">View Cart</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<nav class="navbar navbar-inverse navbar-static-top marginBottom-0" role="navigation" style="background-color: #172431; min-height: 0px;">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand visible-sm" href="#" target="_blank">Category</a>
			</div>

			<div class="collapse navbar-collapse" id="navbar-collapse-1">
				<ul class="nav navbar-nav" style="float: inherit;">
					<li class="col-sm-2"><a href="#"></a></li>
					<li id="categoryDropDownId" class="dropdown col-sm-2"><a href="#" class="dropdown-toggle text-center">SEE ALL CATEGORY <b class="caret"></b></a>
						<ul id="dropdownMenuId" class="dropdown-menu pull-right" style="min-width: 196px;">
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
							<li class="divider"></li>
							<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" id="sampleLinkId" data-toggle="dropdown">Dropdown Link 12</a>
									<div class="" id="addFrame" style="z-index: 0;">
									<ul class="dropdown-menu" style="margin-top: -310; height: 370px; z-index: 1; position: relative; background-color: #000;">
										<li><a href="#">Dropdown Submenu 12.1</a></li>
										<li><a href="#">Dropdown Submenu 12.2</a></li>
										<li><a href="#">Dropdown Submenu 12.3</a></li>
										<li><a href="#">Dropdown Submenu 12.4</a></li>
									</ul>
								</div></li>
							<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown Link 13</a>
								<ul class="dropdown-menu" style="margin-top: -310; height: 370px; z-index: 1;">
									<li><a href="#">Dropdown Submenu 13.1</a></li>
									<li><a href="#">Dropdown Submenu 13.2</a></li>
									<li><a href="#">Dropdown Submenu 13.3</a></li>
									<li class="divider"></li>
									<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown Submenu Link 13.4</a>
										<ul class="dropdown-menu">
											<li><a href="#">Dropdown Submenu Link 13.4.1</a></li>
											<li><a href="#">Dropdown Submenu Link 13.4.2</a></li>
											<li class="divider"></li>
											<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown Submenu Link 13.4.3</a>
												<ul class="dropdown-menu">
													<li><a href="#">Dropdown Submenu Link 13.4.3.1</a></li>
													<li><a href="#">Dropdown Submenu Link 13.4.3.2</a></li>
													<li><a href="#">Dropdown Submenu Link 13.4.3.3</a></li>
													<li><a href="#">Dropdown Submenu Link 13.4.3.4</a></li>
												</ul></li>
											<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown Submenu Link 13.4.4</a>
												<ul class="dropdown-menu">
													<li><a href="#">Dropdown Submenu Link 13.4.4.1</a></li>
													<li><a href="#">Dropdown Submenu Link 13.4.4.2</a></li>
													<li><a href="#">Dropdown Submenu Link 13.4.4.3</a></li>
													<li><a href="#">Dropdown Submenu Link 13.4.4.4</a></li>
												</ul></li>
										</ul></li>
								</ul></li>
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

	<div class="row">
		<div class="col-sm-12" style="padding-left: 0px; z-index: -1; position: absolute;">
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="${context}/resources/img/1.jpg" alt="...">
						<div class="carousel-caption">...</div>
					</div>
					<div class="item">
						<img src="${context}/resources/img/2.jpg" alt="...">
						<div class="carousel-caption">...</div>
					</div>

					<div class="item">
						<img src="${context}/resources/img/3.jpg" alt="...">
						<div class="carousel-caption">...</div>
					</div>

					<div class="item">
						<img src="${context}/resources/img/4.jpg" alt="...">
						<div class="carousel-caption">...</div>
					</div>
					...
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
			<br />
		</div>
	</div>
</body>
</html>

