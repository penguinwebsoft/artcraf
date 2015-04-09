<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<html lang="en" style="width: 100%;">
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
<link rel="stylesheet" href="${context}/resources/plugins/social-buttons/social-buttons.css" />
<link rel="stylesheet" href="${context}/resources/plugins/datepicker/css/datepicker.css" />

<!--START SCRIPTS -->
<script src="${context}/resources/javascript/jquery-core/jquery-1.11.0.min.js"></script>
<script src="${context}/resources/javascript/jquery-ui-1.10.3/ui/jquery-ui.min.js"></script>
<script src="${context}/resources/javascript/menuHighlight/highlight.js"></script>
<script src="${context}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${context}/resources/plugins/datepicker/js/bootstrap-datepicker.js"></script>
</head>

<script type="text/javascript">
	$(document).ready(function() {

		$("#dp2").datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$('#dp2').on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$('#dp2').datepicker('hide');
			}
		});
	});
</script>

<body style="width: 100%;">
	<div class="row">
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
										<li><button class="currency-select btn btn-link btn-block" type="button" name="GBP">� Pound Sterling</button></li>
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
				<a href="${baseURL}/menu/home"> <img src="${context}/resources/img/logo2.png" title="" alt="" class="img-responsive" style="margin-top: 10px;" /></a>
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

	<hr style="border-color: #332619; margin-top: 1px;">

	<div class="row">
		<div class="row">
			<div class="col-lg-5" style="margin-left: 8%;">
				<div class="row">
					<h4 style="margin-bottom: 20px;"> Login</h4>
					<h5 style="margin-bottom: 20px;"> What is your e-mail address?</h5>
					<form class="form-horizontal" action="#" id="CustomerRegistrationId" style="margin-bottom: 20px;">
						<div class="form-group">
							<div class="col-sm-4" style="width: 25%; padding-right:0px; margin-left: 7%;"> <label for="loginId" class="control-label">My e-mail address is:</label></div>
							<div class="col-sm-5" style="padding-left:0;">
								<input type="text" class="form-control" id="loginId" placeholder="Login Name">
							</div>
						</div>
					</form>
					<div class="row" style="padding-left: 4%; margin-bottom: 15px;">
						<label for="loginId" class="control-label">Do you have an crafart password?</label>
					</div>
					<div class="row" style="padding-left:8%; margin-bottom: 15px;">
							<input type="radio" name="sex" value="male" style="margin-bottom: 15px;">No, I am a new customer<br> 
							<div class="row" style="margin-bottom: 15px;">
								<div class="col-sm-4" style="width: 28%; padding-right:0px; ">
									<input type="radio" name="sex" value="female">Yes, I have a password: 
								</div>
								<div class="col-sm-5" style="padding-left:0;">
									<input type="password" 	id="userPasswordId" name="Password" class="form-control" placeholder="Password" />
								</div>
							</div>
					</div>
					<div class="row">
						<div class="col-sm-offset-2">
							<a class="btn btn-success btn-flat" href="#" style="border-radius: 0px;">&nbsp;&nbsp;Login&nbsp;&nbsp;</a>
						</div>
					</div>
				</div>
			</div>

			<div class="verticalLine col-sm-1" style="height: 320px; width: 2%;"></div>

			<div class="col-lg-5 col-sm-offset-1" style="margin-left: 6%;">
				<br>
				<div class="row">
					<h4>Social login</h4>
				</div>
				<div class="row">
					<div class="col-sm-5" style="margin-bottom: 15px;">
						<a class="btn btn-block btn-social btn-google-plus" style="border-radius: 0px;"> <i class="icon-google-plus"></i> Sign in with Google
						</a>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-5">
						<a class="btn btn-block btn-social btn-facebook" style="border-radius: 0px;"> <i class="icon-facebook"></i> Sign in with Facebook
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br>

	<!-- FOOTER-->
	<div class="row" id="footers">
		<div class="row">
			<div class="container" style="">
				<div class="col-sm-3">
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

				<div class="col-sm-3">
					<h4 class="line3 center standart-h4title">
						<span>HELP</span>
					</h4>
					<ul class="footer-links">
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Sitemap</a></li>
						<li><a href="#">How to buy</a></li>
					</ul>
				</div>

				<div class="col-sm-3">
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

				<div class="col-sm-3">
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


		<div class="col-md-12 footer-box">
			<div class="row small-box ">
				<strong>Mobiles :</strong> <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
				| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |
				<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | view all items
			</div>
			<div class="row small-box ">
				<strong>Laptops :</strong> <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx Laptops</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
				| <a href="#">Sony Laptops</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a>
				| <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | view all items
			</div>
			<div class="row small-box ">
				<strong>Tablets : </strong><a href="#">samsung</a> | <a href="#">Sony Tablets</a> | <a href="#">Microx</a> | <a href="#">samsung </a>| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
				| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung Tablets</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung Tablets</a> | <a href="#">Sony</a> | <a
					href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx Tablets</a> | view all items

			</div>
			<div class="row small-box pad-botom ">
				<strong>Computers :</strong> <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | <a href="#">samsung Computers</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a
					href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx Computers</a> |<a href="#">samsung Computers</a> | <a
					href="#">Sony</a> | <a href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx Computers</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a>
				| view all items
			</div>
		</div>

		<div class="row text-center">
			<hr>
			<p>Copyright� 2015.Crafart.All Rights Reserved.</p>
		</div>
	</div>
	<!-- /Footer-->
</body>
</html>

