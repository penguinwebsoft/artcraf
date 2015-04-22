<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<script src="${context}/resources/ThirdPartyLogin-script/thirdPartyLogin.js"></script>
<script src="https://apis.google.com/js/client:plusone.js?onload=render" async defer></script>
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
<script id="facebook-jssdk" src="//connect.facebook.net/en_US/sdk.js" async defer></script>
</head>

<script type="text/javascript">
    var getUserMail = null;
	var email = "";
	var passwordId = "";
	var fbGetUserMail = null;
	
	$(document).ready(
			function() {
				
				$("#facebookLogin").on("click", function() {
					fb_login();
				});
				
				fbGetUserMail = function(response) {
					facebookUser(response);
				};

				getUserMail = function(resp) {
					googleUser(resp);
				};

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

				$("#createButton").click(function() {
					var customerBO = {};
					var contactBOs = new Array();
					var addressBO = {};
					customerBO.firstName = $("#firstName").val();
					customerBO.lastName = $("#lastName").val();
					customerBO.password = $("#Password").val();
					customerBO.dateOfBirth = $("#dp2").val();
					customerBO.gender = $("#gender").val();
					addressBO.stateId = $("#state").val();
					addressBO.cityId = $("#city").val();

					var contactBO = {};
					contactBO.contactValue = $("#emailId").val();
					contactBO.contactTypeId = 3;
					contactBOs.push(contactBO);
					
					var contactBO1 = {};
					contactBO1.contactValue = $("#mobileNumberId").val();
					contactBO1.contactTypeId = 1;
					contactBOs.push(contactBO1);

					var contactBO2 = {};
					contactBO2.contactValue = $("#alternativeEmailId").val();
					contactBO2.contactTypeId = 4;
					contactBOs.push(contactBO2);
					
					customerBO.contactBOs = contactBOs;
					customerBO.addressBO = addressBO;
					postData = JSON.stringify(customerBO);
					alert(postData);
					$.ajax({
						url : "../customer/addcustomer",
						type : "post",
						data : postData,
						contentType : "application/json",
						dataType : "json",
						success : function(data) {
							if(data.result){
								alert(data.message);
								window.location.replace(data.redirect);
								}
								else
									alert(data.message);
						}
					});
				});

				$("#loginButton").click(
						function() {
							$.ajax({
								url : "../customer/login",
								type : "post",
								cache : false,
								dataType : "json",
								data : "userEMailId=" + $("#loginId").val()
										+ '&userPassword='
										+ $("#userPasswordId").val(),
								success : function(data) {
									alert(data.message);
									window.location.replace("../menu/home");
								}
							});
						});
			});

	/* Google Login code starts here */

	function render() {
		gapi.signin
				.render(
						'googleLogin',
						{
							'callback' : 'signinCallback',
							'clientid' : '172925455807-juqmmm54gqarri202ip62d29r4siu8tf.apps.googleusercontent.com',
							'cookiepolicy' : 'single_host_origin',
							'scope' : 'https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/plus.me email https://www.googleapis.com/auth/plus.login'
						});
	}
	function signinCallback(authResult) {

		//prevent auto google login in start up
		window.onbeforeunload = function(e) {
			gapi.auth.signOut();
		};

		if (authResult['status']['signed_in']
				&& authResult['status']['method'] == 'PROMPT') {

			// Update the app to reflect a signed in user
			// Hide the sign-in button now that the user is authorized, for example:
			document.getElementById('googleLogin').setAttribute('style',
					'display: none');
			gapi.client.load('plus', 'v1', function() {
				var request = gapi.client.plus.people.get({
					'userId' : 'me'
				});
				request.execute(function(resp) {
					if (resp['emails']) {
						for (var i = 0; i < resp['emails'].length; i++) {
							if (resp['emails'][i]['type'] == 'account') {
								email = resp['emails'][i]['value'];
							}
						}
					}
					passwordId = resp.id;
					getUserMail(resp);
				});
			});
		} else {

			// Update the app to reflect a signed out user
			// Possible error values:
			//   "user_signed_out" - User is signed-out
			//   "access_denied" - User denied access to your app
			//   "immediate_failed" - Could not automatically log in the user
			console.log('Sign-in state: ' + authResult['error']);
		}
	}

	/* Google Login code ends here */
	/*  facebook login code start here  */
	window.fbAsyncInit = function() {
		FB.init({
			appId : '860034670723016',
			status : false,
			cookie : true, // enable cookies to allow the server to access 
			xfbml : true, // parse social plugins on this page
			version : 'v2.3' // use version 2.2
		});
	};

	function fb_login() {
			FB.login(function(response) {
					if (response.authResponse) {
						  document.getElementById('facebookLogin').setAttribute('style',	'display: none');
						  FB.api('/me', function(response) {
							fbGetUserMail(response);
						  });
					} else {
						console.log('User cancelled login or did not fully authorize.');
					}
				}, {
					scope : 'public_profile,email',
					return_scopes : true
				});
	}
	/*  facebook login code end here  */

</script>

<body style="width: 100%;">
<div class="container-fluid">
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

							<li><a href="${baseURL}/menu/showcustomerPanel"> <i class="icon-phone pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Contact Us</span></a></li>

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
			<div class="col-lg-5" style="margin-left: 50px;">
				<div class="row">
					<form class="form-horizontal" action="#" id="CustomerRegistrationId">
						<div class="col-sm-5">
							<div class="form-group">
								<label for="firstName" class="control-label">First Name</label> <input type="text" class="form-control" id="firstName" placeholder="First Name">
							</div>
							<div class="form-group">
								<label for="emailId" class="control-label">e-Mail ID</label> <input type="text" class="form-control" id="emailId" placeholder="e-Mail ID">
							</div>

							<div class="form-group">
								<label for="ConfirmPasswordId" class="control-label">Confirm Password</label> <input type="password" id="ConfirmPasswordId" name="Confirm Password" class="form-control"
									placeholder="Confirm Password" />
							</div>

							<div class="form-group">
								<label for="" class="control-label">City</label> <input type="text" id="city" name="city" class="form-control" placeholder="City" />
							</div>

							<div class="form-group">
								<label for="" class="control-label">State</label> <input type="text" id="state" name="state" class="form-control" placeholder="State" />
							</div>

							<div class="form-group">
								<label for="" class="control-label">Country</label> <input type="text" id="states" name="Country" class="form-control" placeholder="Country" />
							</div>

							<br>


						</div>
						<div class="col-sm-5 col-sm-offset-2">

							<div class="form-group">
								<label for="lastName" class="control-label">Last Name</label> <input type="text" class="form-control" id="lastName" placeholder="Last Name">
							</div>

							<div class="form-group">
								<label for="PasswordId" class="control-label">Password</label> <input type="password" id="Password" name="Password" class="form-control" placeholder="Password" />
							</div>


							<div class="form-group">
								<label for="alternativeEmailId" class="control-label">Alternative e-Mail ID</label> <input type="text" class="form-control" id="alternativeEmailId" placeholder="Alternative e-Mail ID">
							</div>

							<div class="form-group">
								<label for="" class="control-label">Gender</label> <select class="form-control" id="gender" placeholder="Gender">
									<option value="1">Male</option>
									<option value="2">Female</option>
								</select>
							</div>


							<div class="form-group">
								<label for="" class="control-label">Date Of Birth</label> <input type="text" class="form-control" placeholder="1990/09/10" value="" data-date-format="mm/dd/yyyy" id="dp2">
							</div>


							<div class="form-group" style="margin-bottom: 20px;">
								<label for="" class="control-label">Mobile No</label> <input type="text" id="mobileNumber" name="mobileNumber" class="form-control" placeholder="Mobile No" />
							</div>
						</div>
					</form>
				</div>
				<div class="form-group">
					<input type="checkbox" /> By clicking Register,you agree that you have read and accepted the <a href="#">Policy for buyer</a>, <a href="#">Terms & Conditions</a>, 
					 <a href="#">Privacy Policy</a>and that you are at least 18 years old.
				</div>
				<br>

				<div class="row">
					<span class="col-sm-offset-5" style="margin-left: 13.50%;"> <a class="btn btn-success" id="createButton" style="border-radius: 0px;">Create Account</a>&nbsp;&nbsp;&nbsp;
					</span>
				</div>
			</div>

			<div class="verticalLine col-sm-1" style="height: 500px; width: 2%; padding-left: 3%;"></div>

			<div class="col-lg-5 col-sm-offset-1">
			
				<br>
				<div class="row">
					<h4>Social login</h4>
				</div>
				<div class="row">
					<div id="googleLogin"  class="col-sm-5" style="margin-bottom: 15px;">
						<a href="#" class="btn btn-block btn-social btn-google-plus" style="border-radius: 0px;"> <i class="icon-google-plus"></i> Sign in with Google
						</a>
					</div>
				</div>

				<div class="row">
					<div id="facebookLogin" class="col-sm-5">
						<a href="#" class="btn btn-block btn-social btn-facebook" style="border-radius: 0px;"> <i class="icon-facebook"></i> Sign in with Facebook
						</a>
					</div>
				</div>
				<br>
				<div class="row">
					<h4>Login to your account</h4>
				</div>

				<div class="row">
					<div class="col-sm-6 col-sm-offset-1">
						<form class="form-horizontal" action="#" id="CustomerRegistrationId">
							<div class="form-group">
								<label for="loginId" class="control-label">Login ID</label>
								<div class="">
									<input type="text" class="form-control" id="loginId" placeholder="Login Name">
								</div>
							</div>

							<div class="form-group">
								<label for="userPasswordId" class="control-label">Password</label>
								<div class="">
									<input type="password" id="userPasswordId" name="Password" class="form-control" placeholder="Password" />
								</div>
							</div>

							<div class="form-group">
								<input type="checkbox" id="staySigninId" name="Signed In" /> <label class="control-label"> Stay Signed In </label>
							</div>
						</form>
					</div>
				</div>
				<br>
				<div class="row">
					<span class="col-sm-4 col-sm-offset-1"> <a class="btn btn-success btn-flat" href="#" id="loginButton" style="border-radius: 0px;">&nbsp;&nbsp;Login&nbsp;&nbsp;</a>
					</span>
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

