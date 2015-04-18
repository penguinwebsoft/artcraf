<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<title>Crafart Login Page</title>

<link rel="stylesheet" href="${context}/resources/plugins/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${context}/resources/plugins/Font-Awesome/css/font-awesome.css" />
<link rel="stylesheet" href="${context}/resources/css/main.css" />
<link rel="stylesheet" href="${context}/resources/css/login.css" />
<link rel="stylesheet" href="${context}/resources/plugins/magic/magic.css" />
<link rel="stylesheet" href="${context}/resources/plugins/validationengine/css/validationEngine.jquery.css" />
<link rel="stylesheet" href="${context}/resources/plugins/datepicker/css/datepicker.css" />
<!--START SCRIPTS -->
<script src="${context}/resources/javascript/jquery-core/jquery-1.11.0.min.js"></script>
<script src="${context}/resources/javascript/jquery-ui-1.10.3/ui/jquery-ui.min.js"></script>
<script src="${context}/resources/javascript/menuHighlight/highlight.js"></script>
<script src="${context}/resources/javascript/validationInit.js"></script>
<script src="${context}/resources/javascript/login.js"></script>
<script src="${context}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${context}/resources/plugins/validationengine/js/jquery.validationEngine.js"></script>
<script src="${context}/resources/plugins/validationengine/js/languages/jquery.validationEngine-en.js"></script>
<script src="${context}/resources/plugins/jquery-validation-1.11.1/dist/jquery.validate.min.js"></script>
<script src="${context}/resources/plugins/datepicker/js/bootstrap-datepicker.js"></script>
</head>

<script type="text/javascript">
	$(document).ready(function() {

		$("#Dateofbirth").datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$('#Dateofbirth').on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$('#Dateofbirth').datepicker('hide');
			}
		});
	});
</script>

<!-- BEGIN BODY -->
<body style="background-image: url(/crafartweb/resources/img/background_img.jpg);">
	<div class="container-fluid" style="padding-right: 15px; padding-left: 15px; margin-right: auto; margin-left: auto;">
		<div class="row" style="padding-top: 10px; background-color: #332619;">
			<div class="col-lg-5 col-lg-offset-7 pull-right">
				<div class="col-lg-12 blue">
					<div class="form-group pull-left">
						<input type="text" class="form-control" id="login_Email" placeholder="Email">
					</div>
					<div class="form-group pull-left" style="margin-left: 5px;">
						<input type="text" class="form-control" id="login_Password" placeholder="Password">
					</div>
					<div class="form-group pull-left" style="margin-left: 5px;">
						<a class="btn btn-success btn-flat" href="#" style="border-radius: 0px;">Login</a>
					</div>
				</div>
			</div>
		</div>

		<!-- HOME PAGE -->
		<div id="wrapper" class="col-lg-12">
			<div style="margin-top: 1%;" class="row" class="col-lg-12">
				<div class="col-md-6" id="loginContent">
					<div id="checkListMainBox" style="margin-left: 15%">
						<div id="checkBox1" style="margin-top: 10%">
							<span><i class="icon-check icon-2x checkListColor"></i></span> <span>Multiple product images upload facility for each product</span>
						</div>
						<div id="checkBox2" style="margin-top: 5%">
							<span><i class="icon-check icon-2x checkListColor"></i></span><span>All India or State based shipping facility</span>
						</div>
						<div id="checkBox3" style="margin-top: 5%">
							<span><i class="icon-check icon-2x checkListColor"></i></span><span>Add your own discount coupon facility</span>
						</div>
						<div id="checkBox4" style="margin-top: 5%">
							<span><i class="icon-check icon-2x checkListColor"></i></span><span>Add your Special Price for each product</span>
						</div>
						<div id="checkBox5" style="margin-top: 5%">
							<span><i class="icon-check icon-2x checkListColor"></i></span>Fill up registration fields</span>
						</div>
						<div id="checkBox6" style="margin-top: 5%">
							<span><i class="icon-check icon-2x checkListColor"></i></span><span>Add your details in My Account</span>
						</div>
						<div id="checkBox7" style="margin-top: 5%">
							<span><i class="icon-check icon-2x checkListColor"></i></span><span>Upload your Product details</span>
						</div>
						<div id="checkBox8" style="margin-top: 5%">
							<span><i class="icon-check icon-2x checkListColor"></i></span><span>On Approval see your Product live in site</span>
						</div>
					</div>
				</div>
				<div class="col-md-3" id="registrationPart1">
					<div id="sellerRegistration1">
						<div class="form-group">
							<label for="first Name" class="control-label">First Name:</label><input type="text" class="form-control" id="first Name" />
						</div>
						<div class="form-group">
							<label for="Gender" class="control-label">Gender:</label><select type="text" id="Gender" name="Gender" class="form-control">
								<option value="1">Male</option>
								<option value="2">Female</option>
							</select>
						</div>

						<div class="form-group">
							<label for="Emailid" class="control-label">Email id:</label><input type="text" class="form-control" id="email Id" />
						</div>

						<div class="form-group">
							<label for="Password" class="control-label">Password:</label><input type="password" id="PasswordId" name="Password" class="form-control" />
						</div>

						<div class="form-group">
							<label for="Office no" class="control-label">Office No:</label><input type="text" id="Office no" name="Office no" class="form-control" />
						</div>


						<div class="form-group">
							<label for="Company Name" class="control-label">Company Name:</label><input type="text" id="Company Name" name="Company Name" class="form-control" />
						</div>

						<div class="form-group">
							<label for="City" class="control-label">City:</label><input type="text" id="city" name="city" class="form-control" />
						</div>

						<div class="form-group">
							<label for="State" class="control-label">State:</label><input type="text" id="state" name="state" class="form-control" />
						</div>
						<div class="form-group">
							<label for="ShopUrl" class="control-label">ShopUrl</label><input type="text" id="ShopUrl" name="ShopUrl" class="form-control" /><span class="lfloat" style="margin-top: 3%;"><button
									class="btn btn-small btn-primary" type="button">CheckAvailability</button> </span> <span class="lfloat" style="margin-top: 5%; margin-left: 2%"><p style="color: blue;">http://www.crafart.com/handcrafart</p></span>
						</div>

					</div>
				</div>
				<div class="col-md-3" id="registrationPart2">
					<div id="sellerRegistration2">
						<div class="form-group">
							<label for="Last Name" class="control-label">Last Name:</label><input type="text" class="form-control" id="Last Name">
						</div>

						<div class="form-group">
							<label for="Dob" class="control-label">Date of Birth:</label><input type="text" id="Date of birth" name="Date of birth" class="form-control" data-date-format="yyyy/mm/dd" />
						</div>

						<div class="form-group">
							<label for="Alternative Emailid" class="control-label">Alternative Emailid:</label><input type="Alternative Emailid" id="Alternative Emailid" name="Alternative Emailid" class="form-control" />
						</div>


						<div class="form-group">
							<label for="Confirm Password" class="control-label">Confirm Password:</label><input type="Confirm Password" id="Confirm Password" name="Confirm Password" class="form-control" />
						</div>


						<div class="form-group">
							<label for="Mobile no" class="control-label">Mobile no:</label><input type="" id="Mobile no" name="Mobile no" class="form-control" />
						</div>

						<div class="form-group">
							<label for="Address" class="control-label">Address:</label><input type="text" id="Address" name="Address" class="form-control" />
						</div>


						<div class="form-group">
							<label for="Pincode" class="control-label">Pincode:</label><input type="text" id="Pincode" name="Pincode" class="form-control" />
						</div>

						<div class="form-group">
							<label for="firstName" class="control-label">Country:</label><select type="text" id="country" name="Country" class="form-control">
								<option value="1">India</option>
								<option value="2">Kerala</option>
								<option value="3">Delhi</option>
							</select>
						</div>
						<div class="form-group">
							<label for="Shop Name" class="control-label">Shop Name:</label><input type="text" id="Shop Name" name="Shop Name" class="form-control" />
						</div>
					</div>
				</div>
				<div class="col-md-6 col-md-offset-6">
					<span class="pull-left">Eg: If Shop Name is "handcraft", enter "handcraft" above. Your shop url will be http://www.crafart.com/handcraft</span>
					<span class="pull-left">Note: Spaces And Special characters are not allowed.</span>
				
				</div>

				<div class="row">
					<div class="col-md-6 col-md-offset-6" id="loginContent">
						<div style="margin-top: 2%">
							<input type="checkbox" /> By clicking Register,you agree that you have read and accepted the <a href="#">Policy for seller</a>, <a href="#">Terms & Conditions</a>, <a href="#">Privacy
								Policy</a>and that you are at least 18 years old.
						</div>

					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2 col-md-offset-7">
					<div id="loginButtonBox" style="margin-left: 15%; margin-top: 7%">
						<a class="btn btn-success" id="loginButton" style="border-radius: 0px;">Create Account</a>&nbsp;&nbsp;&nbsp;
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div id="checkListMainBox1" style="margin-left: 5%">
					<span><h3>Steps of uploading Product Details</h3></span>
					<div id="checkBoxSec1" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span> <span>Fill up registration fields</span>
					</div>
					<div id="checkBoxSec2" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span><span> Add your details in My Account</span>
					</div>
					<div id="checkBoxSec3" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span><span>Upload your Product details</span>
					</div>
					<div id="checkBoxSec4" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span><span>On Approval see your Product live in site</span>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div id="checkListMainBox2" style="margin-left: 5%">
					<span><h3>Steps of shipping an order</h3></span>
					<div id="checkBoxSec1" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span> <span>Get order details in your mail </span>
					</div>
					<div id="checkBoxSec2" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span><span>Login in seller panel and check for orders</span>
					</div>
					<div id="checkBoxSec3" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span><span>Download invoice and packing slips </span>
					</div>
					<div id="checkBoxSec4" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span><span>Change order status to processing</span>
					</div>

					<div id="checkBoxSec5" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span> <span>Pack the product with care</span>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div id="checkListMainBox2" style="margin-left: 5%; margin-top: 13%">

					<div id="checkBoxSec6" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span><span>Change order status to processed</span>
					</div>
					<div id="checkBoxSec7" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span><span>Ship the product to customer's shipping address</span>
					</div>
					<div id="checkBoxSec8" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span><span>Change order status to shipped and include tracking details</span>
					</div>
					<div id="checkBoxSec9" style="margin-top: 5%">
						<span><i class="icon-check icon-2x checkListColor"></i></span><span>After delivery confirmation,change order status to complete</span>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
