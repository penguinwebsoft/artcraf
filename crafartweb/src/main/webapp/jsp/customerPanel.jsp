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
<title>CustomerPanel</title>

<link rel="stylesheet" href="${context}/resources/plugins/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${context}/resources/plugins/Font-Awesome/css/font-awesome.css" />
<link rel="stylesheet" href="${context}/resources/css/homeStyle.css" />
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
	$(document)
			.ready(
					function() {

						/**********customer care section disbale enable tab section*****************/
						var clickEvent = false;

						$("#customerCareTabs .nav a").click(function(e) {
							e.preventDefault();
							$(this).tab('show');
						});

						/**********customer care section disbale enable tab section*****************/

						/***************need assistance tab enable*****************************************/

						/* $("#tab-one li a").click(function(e) {
							e.preventDefault();
							$("#assistanceTab").show();
						}); */
						/***************need assistance tab enable*****************************************/

						$(document)
								.on(
										'click',
										function(e) {
											if ($(e.target).closest(
													'#tab-one li a').length) {
												$("#assistanceTab").show();
											} else if (!$(e.target).closest(
													'#assistanceTab').length) {
												$('#assistanceTab').hide();
											}
										});

						/***************need assistance tab2 enable*****************************************/
						$(document)
								.on(
										'click',
										function(e) {
											if ($(e.target).closest(
													'#tab-two li a').length) {
												$("#assistanceTab2").show();
											} else if (!$(e.target).closest(
													'#assistanceTab2').length) {
												$('#assistanceTab2').hide();
											}
										});
						$("#horizontalTabContentOrder").hide();
						$("#horizontalTabContentSection").hide();
						$("#horizontalTabContentCustomerCare").hide();

						$("#customerPersonalDetails")
								.click(
										function() {
											$(
													"#horizontalTabContentCustomerCare")
													.hide();
											$("#customermainBox").remove();
											$("#horizontalTabContentSection")
													.hide();
											$("#horizontalTabContentOrder")
													.hide();

											$("#mainBox")
													.append(
															"<div id='customermainBox'><div class='form-group' style='margin-left:15%;'><label for='firstname' class='control-label'>First Name :</label><input type='text' style='width:50%;' class='form-control pull-right' id='firstname'/></div><div class='form-group' style='margin-left:15%;'><label for='lastname' class='control-label'>Last Name:</label><input type='text' style='width:50%;' class='form-control pull-right' id='lastname'/></div><div class='form-group' style='margin-left:15%;'><label for='gender' class='control-label'>Gender :</label><select type='text' id='gender' style='width:50%;' name='Gender' class='form-control pull-right'><option value='1'>Male</option><option value='2'>Female</option></select></div><div class='form-group' style='margin-left:15%;'><label for='address' class='control-label'>Address :</label><input type='text' style='width:50%;' class='form-control pull-right' id='address'/></div><div class='form-group' style='margin-left:15%;'><label for='dateofbirth' class='control-label'>Date of birth :</label><input type='text' style='width:50%;' class='form-control pull-right' id='dateofbirth'/></div><div class='form-group' style='margin-left:15%;'><label for='mobileno' class='control-label'>Mobile No :</label><input type='text' style='width:50%;' class='form-control pull-right' id='mobileno'/><div class='form-group' style='margin-left:25%;margin-top:10%'><button type='button' class='btn btn-primary'>SaveChanges</button></div></div>");
										});

						$("#customerAddresses")
								.click(
										function() {
											$(
													"#horizontalTabContentCustomerCare")
													.hide();
											$("#horizontalTabContentSection")
													.hide();
											$("#customermainBox").remove();
											$("#horizontalTabContent").hide();
											$("#mainBox")
													.append(
															"<div id='customermainBox'><div class='form-group' style='margin-left:15%;'><label for='streetaddress' class='control-label'>Street Address :</label><input type='text' style='width:50%;' class='form-control pull-right' id='streetaddress'/></div><div class='form-group' style='margin-left:15%;'><label for='city' class='control-label'>City :</label><input type='text' style='width:50%;' class='form-control pull-right' id='city'/></div><div class='form-group' style='margin-left:15%;'><label for='landMark' class='control-label'>Land Mark :</label><input type='text' style='width:50%;' class='form-control pull-right' id='landMark'/></div><div class='form-group' style='margin-left:15%;'><label for='state' class='control-label'>State :</label><input type='text' style='width:50%;' class='form-control pull-right' id='state'/></div><div class='form-group' style='margin-left:15%;'><label for='pinCode' class='control-label'>Pin Code :</label><input type='text' style='width:50%;' class='form-control pull-right' id='pinCode'/></div><div class='form-group' style='margin-left:15%;'><label for='country' class='control-label'>Country :</label><select type='text' id='country' name='country' style='width:50%;' class='form-control pull-right'><option value='1'>India</option></select></div><div class='form-group' style='margin-left:15%;'><label for='mobile no' class='control-label'>Mobile No :</label><input type='text' style='width:50%;' class='form-control pull-right' id='mobile no'/></div><div class='form-group' style='margin-left:15%;'><label for='landlineno' class='control-label'>LandLine No :</label><input type='text' style='width:50%;' class='form-control pull-right' id='landlineno'/></div><div class='form-group' style='margin-left: 25%; margin-top: 10%'><button type='button' class='btn btn-primary'>SaveChanges</button></div></div>");

										});

						$("#customerProfileSetting")
								.click(
										function() {
											$(
													"#horizontalTabContentCustomerCare")
													.hide();
											$("#horizontalTabContentSection")
													.hide();
											$("#customermainBox").remove();
											$("#horizontalTabContentOrder")
													.hide();
											$("#mainBox")
													.append(
															"<div id='customermainBox'><div class='form-group' style='margin-left:15%;'><label for='text' class='control-label'>Public Profile Name :</label><input type='text' style='width:50%;' class='form-control pull-right' id='text'/><div ><div class='form-group' style='margin-left:25%;margin-top:10%'><button type='button' class='btn btn-primary'>SaveChanges</button></div></div>");
										});

						$("#CustomerUpdateEmail")
								.click(
										function() {
											$(
													"#horizontalTabContentCustomerCare")
													.hide();
											$("#horizontalTabContentSection")
													.hide();
											$("#customermainBox").remove();
											$("#horizontalTabContentOrder")
													.hide();
											$("#mainBox")
													.append(
															"<div id='customermainBox'><div class='form-group' style='margin-left:15%;'><label for='email' class='control-label'>Email Id :</label><input type='text' style='width:50%;' class='form-control pull-right' id='email'/></div><div class='form-group' style='margin-left:15%;'><label for='alternativeemailid' class='control-label'>Alternative Email Id :</label><input type='text' style='width:50%;' class='form-control pull-right' id='alternativeemailid'/></div><div class='form-group' style='margin-left:25%;margin-top:10%'><button type='button' class='btn btn-primary'>SaveChanges</button></div></div>");

										});

						$("#CustomerChangePassword")
								.click(
										function() {
											$(
													"#horizontalTabContentCustomerCare")
													.hide();
											$("#horizontalTabContentSection")
													.hide();
											$("#customermainBox").remove();
											$("#horizontalTabContentOrder")
													.hide();
											$("#mainBox")
													.append(
															"<div id='customermainBox'><div class='form-group' style='margin-left:15%;'><label for='presentPassword' class='control-label'>Present Password :</label><input type='password' style='width:50%;' class='form-control pull-right' id='presentpassword'/></div><div class='form-group' style='margin-left:15%'><label for='newPassword' class='control-label'>New Password :</label><input type='password' class='form-control pull-right' style='width:50%;'  id='newPassword'/></div><div class='form-group' style='margin-left:15%'><label for='confirmPassword' class='control-label'>Confirm Password :</label><input type='password' style='width:50%;' class='form-control pull-right' id='confirmPassword'/></div><div class='form-group' style='margin-left: 25%; margin-top: 10%'><button type='button' class='btn btn-primary'>SaveChanges</button></div></div>");

										});

						$("#CustomerDeactivateAccount")
								.click(
										function() {
											$(
													"#horizontalTabContentCustomerCare")
													.hide();
											$("#horizontalTabContentSection")
													.hide();
											$("#customermainBox").remove();
											$("#horizontalTabContentOrder")
													.hide();
											$("#mainBox")
													.append(
															"<div id='customermainBox'><div class='form-group' style='margin-left:15%;'><label for='emailaddress' class='control-label'>Email Address :</label><input type='text' style='width:50%;' class='form-control pull-right' id='emailaddress'/></div><div class='form-group' style='margin-left:15%'><label for='password' class='control-label'>Password :</label><input type='password' class='form-control pull-right' style='width:50%;'  id='password'/></div><div class='form-group'><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>Confirm Deactivated</button></div></div>");

										});

						$("#customerMyOrder").click(function() {
							$("#horizontalTabContentCustomerCare").hide();
							$("#horizontalTabContentSection").hide();
							$("#customermainBox").remove();
							$("#horizontalTabContentOrder").show();

						});

						$("#customerReviewAndRatting").click(function() {
							$("#horizontalTabContentCustomerCare").hide();
							$("#customermainBox").remove();
							$("#horizontalTabContentSection").show();
							$("#horizontalTabContentOrder").hide();
						});

						$("#contactSeller").click(function() {
							$("#horizontalTabContentCustomerCare").hide();
							$("#customermainBox").remove();
							$("#horizontalTabContentSection").hide();
							$("#horizontalTabContentOrder").hide();
						});

						$("#customerCare").click(function() {
							$("#horizontalTabContentCustomerCare").show();
							$("#customermainBox").remove();
							$("#horizontalTabContentSection").hide();
							$("#horizontalTabContentOrder").hide();
						});

						/* $("#emailButton").click(function() {
							alert();
							
						});
						 */

					});
</script>

<!-- BEGIN BODY -->
<body>
	<div class="container-fluid" style="padding-right: 15px; padding-left: 15px; margin-right: auto; margin-left: auto;">
		<div class="row-fluid" style="margin-top: 1%">
			<div class="col-md-9">
				<div class="col-md-4" style="margin-left: -3%">
					<!-- Nav tabs -->
					<div class="nav-side-menu">
						<div class="brand">Customer Panel</div>
						<i class="brand fa fa-bars fa-1x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
						<div class="menu-list">
							<ul id="menu-content" class="menu-content collapse out">
								<li data-toggle="collapse" data-target="#myAccount" class="collapsed active"><a href="#"> My Account </a></li>
								<ul class="sub-menu" id="myAccount">
									<li id="customerPersonalDetails"><a href="#">Personal Details</a></li>
									<li id="customerAddresses"><a href="#">Addresses</a></li>
									<li id="customerProfileSetting"><a href="#">Profile setting</a></li>
									<li id="CustomerUpdateEmail"><a href="#">Update Email</a></li>
									<li id="CustomerChangePassword"><a href="#">Change Password</a></li>
									<li id="CustomerDeactivateAccount"><a href="#">Deactivate Account</a></li>
								</ul>
								<li data-toggle="collapse" data-target="#order" class="collapsed active"><a href="#"> Order </a></li>
								<ul class="sub-menu" id="order">
									<li id="customerMyOrder"><a href="#">My Order</a></li>
								</ul>
								<li  data-target="#reviewAndRatting" data-toggle="collapse" class="collapsed active"><a href="#"> Review And Ratting </a></li>
								<ul class="sub-menu" id="reviewAndRatting">
									<li id="customerreviewAndRatting"><a href="#">Review</a></li>
								</ul>
								<li  data-target="#service" data-toggle="collapse"  class="collapsed active"><a href="#"> Support </a></li>
								<ul class="sub-menu" id="service">
									<li id="contactSeller">Contact Seller</li>
									<li id="customerCare">Customer Care</li>
								</ul>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-7" id="mainBox">
					<div id='customermainBox'></div>

					<!-- 	Order section -->
					<div id="horizontalTabContentOrder">
						<ul class="nav nav-tabs nav_tabs_bottom_border" id="OrderSection">
							<li class="active" id="tabGeneral"><a data-toggle="tab" href="#tab-general">Recent Order(6 month)</a></li>
							<li id="tabData"><a data-toggle="tab" href="#tab-data">Past Order</a></li>
						</ul>

						<div class="tab-content" style="border: 0px; padding: 0px;">
							<div class="tab-pane fade in active" id="tab-general">

								<div class="table-responsive" style="background-color: white;">
									<table id="images" class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<td class="pull-left" style="padding: 1%"><button type="button" onclick="" data-toggle="tooltip" title="Add Image" class="btn btn-primary">Id:Order</button></td>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="text-left"><img src="${context}/resources/img/no_image-100x100.png" alt="" title="" data-placeholder="${context}/resources/img/no_image-100x100.png" /></td>

											</tr>
										</tbody>
										<tfoot>
											<tr>
												<td class="text-right"><button type="button" onclick="" data-toggle="tooltip" title="Add Image" class="btn btn-primary">View</button></td>
											</tr>
										</tfoot>
									</table>
								</div>
							</div>

							<div class="tab-pane fade" id="tab-data">

								<div class="table-responsive" style="background-color: white;">
									<table id="images" class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<span class="pull-left" style="padding: 1%"><button type="button" onclick="" data-toggle="tooltip" title="Add Image" class="btn btn-primary">ID:PastOrder</button></span>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="text-left"><img src="${context}/resources/img/no_image-100x100.png" alt="" title="" data-placeholder="${context}/resources/img/no_image-100x100.png" /></td>
											</tr>
										</tbody>
										<tfoot>
											<tr>
												<td class="text-right"><button type="button" onclick="" data-toggle="tooltip" title="Add Image" class="btn btn-primary">View</button></td>
											</tr>
										</tfoot>
									</table>
								</div>

							</div>
						</div>
					</div>
					<!-- 	review section -->
					<div id="horizontalTabContentSection">
						<ul class="nav nav-tabs nav_tabs_bottom_border" id="reviewSection">
							<li class="active" id="tabProduct"><a data-toggle="tab" href="#tab-product">Product Reviews</a></li>
							<li id="tabSeller"><a data-toggle="tab" href="#tab-seller">Seller Reviews</a></li>
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
												<td class="text-left">Rating Distribution</td>
											</tr>
											<tr>
												<td><img src="${context}/resources/img/no_image-100x100.png" alt="" title="" data-placeholder="${context}/resources/img/no_image-100x100.png" /></td>
											</tr>
										</tbody>
										<tfoot>
											<tr>
												<td class="text-left">Recently Rated</td>
											</tr>
											<tr>
												<td><img src="${context}/resources/img/no_image-100x100.png" alt="" title="" data-placeholder="${context}/resources/img/no_image-100x100.png" /></td>
											</tr>
										</tfoot>
									</table>
								</div>
							</div>

							<div class="tab-pane fade" id="tab-seller">

								<div class="table-responsive" style="background-color: white;">
									<table id="images" class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<span class="pull-left" style="padding: 1%">Seller Title </span>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="text-left">Seller content</td>
											</tr>
										</tbody>
										<tfoot>
										</tfoot>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- 	Customer care Section	 -->
					<div id="horizontalTabContentCustomerCare">
						<div id="customerCareTabs">
							<ul class="nav nav-tabs nav_tabs_bottom_border" id="customerCareSection">
								<li data-target="#customerCareTabs" class="active" id="tabone"><a data-toggle="tab" href="#tab-one">Need assistance with existing order</a></li>
								<li data-target="#customerCareTabs" id="tabtwo"><a data-toggle="tab" href="#tab-two">Any other assistance</a></li>
							</ul>
						</div>
						<!--  menus section for tab 1 section starts here -->

						<div class="tab-content col-md-12" style="border: 0px; padding: 0px;">
							<div class="bubble tab-pane fade in active" id="tab-one" style="width: 100%">
								<!-- customer care ribbone section -->
								<p class="rectangle col-md-12" style="position: relative; margin-left: 15px">What seems to be the issue</p>
								<div class="triangle-l triangle-l-lg-CC-wd"></div>
								<div class="triangle-r triangle-r-lg-CC-wd"></div>
								<!-- customer care ribbone section -->

								<div class="table-responsive">
									<ul class="dropdown pull-left nav" role="menu">

										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" role="menuitem">Order Delivery</a>
											<ul class="dropdown-menu" style="z-index: 1; position: absolute;">
												<li><a href="#">I want to know my order status</a></li>
												<li><a href="#">My order is delayed</a></li>
												<li><a href="#">Is it possible to deliver my Order on a given date/time?</a></li>
												<li><a href="#">Other</a></li>
											</ul></li>

										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" role="menuitem">Offer Redemption</a>
											<ul class="dropdown-menu" style="z-index: 1; position: absolute;">
												<li><a href="#">e-Gift Voucher concerns</a></li>
												<li><a href="#">I require a copy of my invoice</a></li>
												<li><a href="#">Need assistance with your order?</a></li>
												<li><a href="#">Other</a></li>
											</ul></li>

										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" role="menuitem">Order Payment/refund</a>
											<ul class="dropdown-menu" style="z-index: 1; position: absolute;">
												<li><a href="#">e-Gift Voucher concerns</a></li>
												<li><a href="#">Need assistance with your order?</a></li>
												<li><a href="#">Other(payment)</a></li>
											</ul></li>

										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" role="menuitem">Problem With Item Received/Return</a>
											<ul class="dropdown-menu" style="z-index: 1; position: absolute;">
												<li><a href="#">Is it possible to deliver my Order on a given date/time?</a></li>
												<li><a href="#">I want to know my order status</a></li>
												<li><a href="#">Other</a></li>

											</ul></li>

										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" role="menuitem">eBooks related</a>
											<ul class="dropdown-menu" style="z-index: 1; position: absolute;">
												<li><a href="#">Is it possible to deliver my Order on a given date/time?</a></li>
												<li><a href="#">Is it possible to deliver my Order on a given date/time?</a></li>
												<li><a href="#">Other</a></li>

											</ul></li>
										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" role="menuitem">Change Order</a>
											<ul class="dropdown-menu" style="z-index: 1; position: absolute;">
												<li><a href="#">I want to cancel an item</a></li>
												<li><a href="#">I want to cancel an item</a></li>

											</ul></li>

									</ul>
								</div>
							</div>


							<!--  menus section for tab 2 section starts here -->

							<div class="bubble tab-pane fade in" id="tab-two" style="width: 100%">
								<!-- customer care ribbone section -->
								<p class="rectangle col-md-12" style="position: relative; margin-left: 15px">What seems to be the issue</p>
								<div class="triangle-l triangle-l-lg-CC-wd"></div>
								<div class="triangle-r triangle-r-lg-CC-wd"></div>
								<!-- customer care ribbone section -->
								<div class="table-responsive" style="background-color: white;">
									<ul class="dropdown pull-left nav" role="menu" style="min-width: 100px;">
										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" role="menuitem">Customer Account</a>
											<ul class="dropdown-menu" style="z-index: 1; position: absolute;">
												<li><a href="#">I want to know my order status</a></li>
												<li><a href="#">My order is delayed</a></li>
												<li><a href="#">Is it possible to deliver my Order on a given date/time?</a></li>
												<li><a href="#">Other</a></li>
											</ul></li>

										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" role="menuitem">Payment Related</a>
											<ul class="dropdown-menu" style="z-index: 1; position: absolute;">
												<li><a href="#">e-Gift Voucher concerns</a></li>
												<li><a href="#">I require a copy of my invoice</a></li>
												<li><a href="#">Need assistance with your order?</a></li>
												<li><a href="#">Other</a></li>
											</ul></li>

										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" role="menuitem">Product Queries</a>
											<ul class="dropdown-menu" style="z-index: 1; position: absolute;">
												<li><a href="#">e-Gift Voucher concerns</a></li>
												<li><a href="#">Need assistance with your order?</a></li>
												<li><a href="#">Other(payment)</a></li>
											</ul></li>

										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" role="menuitem">Service Queries</a>
											<ul class="dropdown-menu" style="z-index: 1; position: absolute;">
												<li><a href="#">Is it possible to deliver my Order on a given date/time?</a></li>
												<li><a href="#">I want to know my order status</a></li>
												<li><a href="#">Other</a></li>

											</ul></li>

										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" role="menuitem">Report an error</a>
											<ul class="dropdown-menu" style="z-index: 1; position: absolute;">
												<li><a href="#">Is it possible to deliver my Order on a given date/time?</a></li>
												<li><a href="#">Is it possible to deliver my Order on a given date/time?</a></li>
												<li><a href="#">Other</a></li>

											</ul></li>
										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" role="menuitem">Others</a>
											<ul class="dropdown-menu" style="z-index: 1; position: absolute;">
												<li><a href="#">I want to cancel an item</a></li>
												<li><a href="#">I want to cancel an item</a></li>

											</ul></li>
									</ul>
								</div>
							</div>
						</div>

						<!-- customer care second section -->
						<div id="horizontalTabContentCustomerCare1" class="form-horizontal col-md-12">
							<div id="customerCareTabs1">
								<!-- customer care ribbone section -->
								<p class="rectangle col-md-12" style="position: relative; margin-left: 15px">Select an item you need assistance with</p>
								<div class="triangle-l triangle-l-lg-CC2S-wd"></div>
								<div class="triangle-r triangle-r-lg-CC2S-wd"></div>
							</div>
							<!-- customer care ribbone section -->
							<div class="col-md-12" id="assistanceTab" style="display: none">
								<div class='form-group pull-right col-md-12'>
									<span> Need assitance with your order?</span> <a class="btn btn-primary" id="loginButton" style="border-radius: 0px;">Login</a>&nbsp;&nbsp;&nbsp;
								</div>
								<div class='form-group pull-right col-md-12'>
									<label for='order' class='control-label'>Order Id :</label><input type='text' style='width: 50%;' class='form-control' id='order' />
								</div>
								<div class='form-group pull-right col-md-12'>
									<label for='email' class='control-label'>Email Id :</label><input type='text' style='width: 50%;' class='form-control' id='email' />
								</div>
								<div class='form-group pull-right col-md-12'>
									<a class="btn btn-default" id="selectButton">SELECT</a>&nbsp;&nbsp;&nbsp;
								</div>
							</div>
						</div>
						<!-- customer care second section over -->

						<!-- customer care third section -->
						<div id="horizontalTabContentCustomerCare2" class="form-horizontal col-md-12">
							<div id="customerCareTabs2">
								<!-- customer care ribbone section -->
								<div class="col-md-12" id="assistanceTab2" style="display: none">
									<p class="rectangle col-md-12" style="position: relative; margin-left: 15px">Get assistance</p>
									<div class="triangle-l triangle-l-lg-CC3S-wd"></div>
									<div class="triangle-r triangle-r-lg-CC3S-wd"></div>
								</div>
								<!-- customer care ribbone section -->
								<div class='form-group pull-right col-md-12'>
									<a class="btn btn-default" id="emailButton" data-toggle="modal" data-target="#myModal">EMAIL</a>&nbsp;&nbsp;&nbsp;
								</div>
								<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel">EMAIL US</h4>
											</div>
											<div class="modal-body">
												<div class="container-fluid">
													<div class="row">
														<div class="col-md-12">
															<div class='form-group pull-right col-md-12'>
																<label for='email' class='control-label'>Email :</label><input type='text' style='width: 50%;' class='form-control' id='email' />
															</div>
															<div class='form-group pull-right col-md-12'>
																<label for='message' class='control-label'>Message :</label>
																<textarea style='width: 50%;' class='form-control' id='message'></textarea>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
												<button type="button" class="btn btn-primary">Send Email</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- customer care third section over-->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
