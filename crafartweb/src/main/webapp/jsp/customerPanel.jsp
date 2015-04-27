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
<title>CustomerPanel</title>

<link rel="stylesheet" href="${context}/resources/plugins/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${context}/resources/plugins/Font-Awesome/css/font-awesome.css" />
<link rel="stylesheet" href="${context}/resources/css/main.css" />
<link rel="stylesheet" href="${context}/resources/css/login.css" />
<link rel="stylesheet" href="${context}/resources/css/customizeMenuCss.css" />
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

					});
</script>

<!-- BEGIN BODY -->
<body>
	<div class="container-fluid" style="padding-right: 15px; padding-left: 15px; margin-right: auto; margin-left: auto;">
		<div class="row" style="padding-top: 60px; background-color: #332619;"></div>
		<div class="row" style="margin-top: 1%">
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
								<li id="reviewAndRatting" data-toggle="collapse" data-target="#reviewAndRatting" class="collapsed active"><a href="#"> Review And Ratting </a></li>
								<ul class="sub-menu">
									<li id="customerReviewAndRatting"><a href="#">Review</a></li>

								</ul>

								<li id="service" data-toggle="collapse" data-target="#service" class="collapsed active"><a href="#"> Support </a></li>
								<ul class="sub-menu">
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
						<ul class="nav nav-tabs nav_tabs_bottom_border" id="customerCareSection">
							<li class="active" id="tabone"><a data-toggle="tab" href="#tab-one">Need assistance with existing order</a></li>
							<li id="tabtwo"><a data-toggle="tab" href="#tab-two">Any other assistance</a></li>
						</ul>

						<div class="tab-content" style="border: 0px; padding: 0px;">
							<div class="tab-pane fade in active" id="tab-one">
								<div class="table-responsive" style="background-color: white;">
									<div id="customerCare">
										<li role="presentation" class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown" id="sampleLinkId">Perfumes</a> <!-- <div class="" id="addFrame" style="z-index: 0; background-color: black;"> -->
											<div class="div-submenu-container">
												<ul class="dropdown-menu" style="z-index: 1; position: relative;">
													<li><a href="#">Dropdown 12.1</a></li>
													<li><a href="#">Dropdown 12.2</a></li>
													<li><a href="#">Dropdown 12.3</a></li>
													<li><a href="#">Dropdown 12.4</a></li>
												</ul>
											</div></li>
										<ul>
											<li><a href="#">degree</a></li>
											<li><a href="#">degree</a></li>
											<li><a href="#">degree</a></li>
											<li><a href="#">degree</a></li>
											<li><a href="#">degree</a></li>
										</ul>
										<li class=""><a href="#">customer Order</a></li>
										<ul>
											<li><a href="#">college</a></li>
											<li><a href="#">college</a></li>
											<li><a href="#">college</a></li>
											<li><a href="#">college</a></li>
											<li><a href="#">college</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div> 


					</div> 

				</div>
			</div>
		</div>
	</div>
</body>
</html>
