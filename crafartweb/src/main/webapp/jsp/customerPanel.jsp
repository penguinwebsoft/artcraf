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
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
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

						$("#customerPersonalDetails")
								.click(
										function() {
											$("#customermainBox").remove();
											$("#mainBox")
													.append(
															"<div id='customermainBox' class='col-md-8'><div class='form-group' style='margin-left:15%;'><label for='first Name' class='control-label'>First Name :</label><input type='text' style='width:45%;margin-right:15%' text-align:'left' class='form-control pull-right' id='first Name' /></div><div class='form-group'><label for='last Name' class='control-label' style='margin-left:15%;'>Last Name :</label><input type='text' style='width:38%;margin-right:13%' class='form-control pull-right' id='last Name' /></div><div class='form-group' style='margin-left:15%;'><label for='dateofBirth' class='control-label'>Date Of Birth :</label><input type='text' style='width:45%;margin-right:15%' class='form-control pull-right' id='dateofBirth' /></div><div class='form-group' style='margin-left:15%;'><label for='mobile Number' class='control-label'>mobile Number :</label><input type='text' style='width:45%;margin-right:15%' class='form-control pull-right' id='mobile Number' /></div><div class='form-group' style='margin-left:15%;'><label for='gender' class='control-label'>Gender :</label><select type='text' id='gender' style='width:45%;margin-right:15%' name='Gender' class='form-control pull-right'><option value='1'>Male</option><option value='2'>Female</option></select></div><div class='form-group' style='margin-left:15%;'><label for='address' class='control-label'>Address :</label><input type='text' style='width:45%;margin-right:15%' class='form-control pull-right' id='address' /></div><div class='form-group' style='margin-left:15%;'><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>SaveChanges</button></div></div>");
										});

						$("#customerAddresses")
								.click(
										function() {
											$("#customermainBox").remove();
											$("#mainBox")
													.append(
															"<div id='customermainBox' class='col-md-8'><div class='form-group' style='margin-left:15%;'><label for='streetaddress' class='control-label'>StreetAddress :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='streetaddress'/></div><div class='form-group' style='margin-left:15%;'><label for='city' class='control-label'>City :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='city'/></div><div class='form-group' style='margin-left:15%;'><label for='landMark' class='control-label'>Land Mark :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='landMark'/></div><div class='form-group' style='margin-left:15%;'><label for='state' class='control-label'>State :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='state'/></div><div class='form-group' style='margin-left:15%;'><label for='pinCode' class='control-label'>PinCode :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='pinCode'/></div><div class='form-group' style='margin-left:15%;'><label for='country' class='control-label'>Country :</label><select type='text' id='country' name='country' style='width:50%;margin-right:15%' class='form-control pull-right'><option value='1'>India</option></select></div><div class='form-group' style='margin-left:15%;'><label for='mobile no' class='control-label'>Mobile no :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='mobile no'/></div><div class='form-group' style='margin-left:15%;'><label for='landlineno' class='control-label'>landLineno :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='landLineno'/></div><div class='form-group'><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>SaveChanges</button></div></div>");

										});

						$("#customerProfileSetting")
								.click(
										function() {
											$("#customermainBox").remove();
											$("#mainBox")
													.append(
															"<div id='customermainBox' class='col-md-8'><div class='form-group' style='margin-left:15%;'><label for='text' class='control-label'>Public Profile Name :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='text'/><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>SaveChanges</button></div></div>")
										});

						$("#CustomerUpdateEmail")
								.click(
										function() {
											$("#customermainBox").remove();
											$("#mainBox")
													.append(
															"<div id='customermainBox' class='col-md-8'><div class='form-group' style='margin-left:15%;'><label for='email' class='control-label'>EMAIL ID :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='email'/></div><div class='form-group'><label for='password' class='control-label'>PASSWORD :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='password'/></div><div class='form-group'><label for='confirmPassword' class='control-label'>CONFIRM PASSWORD :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='confirmPassword'/></div><div class='form-group'><label for='alternativeEmail' class='control-label'>ALTERNATIVE EMAIL :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='alternativeEmail'/></div><div class='form-group'><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>SaveChanges</button></div>");

										});

						$("#CustomerChangePassword")
								.click(
										function() {
											$("#customermainBox").remove();
											$("#mainBox")
													.append(
															"<div id='customermainBox' class='col-md-8'><div class='form-group' style='margin-left:15%;'><label for='presendPassword' class='control-label'>PRESENDPASSWORD :</label><input type='password' style='width:45%;margin-right:1%' class='form-control pull-right' id='presendPassword'/></div><div class='form-group' style='margin-left:15%'><label for='newPassword' class='control-label'>NEWPASSWORD :</label><input type='password' class='form-control pull-right' style='width:45%;margin-right:1%'  id='newPassword'/></div><div class='form-group' style='margin-left:15%'><label for='confirmPassword' class='control-label'>CONFIRMPASSWORD :</label><input type='password' style='width:45%;margin-right:1%' class='form-control pull-right' id='confirmPassword'/></div><div class='form-group'><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>SaveChanges</button></div></div>");

										});

						$("#customerMyOrder")
								.click(
										function() {
											$("#customermainBox").remove();
											$("#mainBox")
													.append(
															"<div id='customermainBox' class='col-md-8'><div class='form-group' style='margin-left:15%;'><ul class='nav nav-tabs nav_tabs_bottom_border' style='margin-bottom: 40px'><li class='active' id='tabPostOrder'><a data-toggle='tab' href='#'>Post Order</a></li><li id='tabPastOrder'><a data-toggle='tab' href='#'>Past Order</a></li><li id='tabRecentOrder'><a data-toggle='tab' href='#'>Recent Order</a></li></ul></div></div>");

										});
						$("#tabPostOrder")
								.click(
										function() {
											$("#customermainBox").remove();
											$("#mainBox")
													.append(
															"<div id='customermainBox' class='col-md-8'><div class='form-group' style='margin-left:15%;'><label for='email' class='control-label'>EMAIL ID :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='email'/></div><div class='form-group'><label for='password' class='control-label'>PASSWORD :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='password'/></div><div class='form-group'><label for='confirmPassword' class='control-label'>CONFIRM PASSWORD :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='confirmPassword'/></div><div class='form-group'><label for='alternativeEmail' class='control-label'>ALTERNATIVE EMAIL :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='alternativeEmail'/></div><div class='form-group'><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>SaveChanges</button></div>");

										});

						$("#tabPastOrder")
								.click(
										function() {
											$("#customermainBox").remove();
											$("#mainBox")
													.append(
															"<div id='customermainBox' class='col-md-8'><div class='form-group' style='margin-left:15%;'><label for='email' class='control-label'>EMAIL ID :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='email'/></div><div class='form-group'><label for='password' class='control-label'>PASSWORD :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='password'/></div><div class='form-group'><label for='confirmPassword' class='control-label'>CONFIRM PASSWORD :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='confirmPassword'/></div><div class='form-group'><label for='alternativeEmail' class='control-label'>ALTERNATIVE EMAIL :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='alternativeEmail'/></div><div class='form-group'><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>SaveChanges</button></div>");

										});

						$("#tabRecentOrder")
								.click(
										function() {
											$("#customermainBox").remove();
											$("#mainBox")
													.append(
															"<div id='customermainBox' class='col-md-8'><div class='form-group' style='margin-left:15%;'><label for='email' class='control-label'>EMAIL ID :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='email'/></div><div class='form-group'><label for='password' class='control-label'>PASSWORD :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='password'/></div><div class='form-group'><label for='confirmPassword' class='control-label'>CONFIRM PASSWORD :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='confirmPassword'/></div><div class='form-group'><label for='alternativeEmail' class='control-label'>ALTERNATIVE EMAIL :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='alternativeEmail'/></div><div class='form-group'><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>SaveChanges</button></div>");

										});

					});
</script>

<!-- BEGIN BODY -->
<body>
	<div class="container-fluid" style="padding-right: 15px; padding-left: 15px; margin-right: auto; margin-left: auto;">
		<div class="row" style="padding-top: 60px; background-color: #332619;"></div>

		<div class="row" style="margin-top: 1%">
			<div class="col-md-9">
				<div class="col-md-3" style="margin-left: -3%">
					<!-- Nav tabs -->
					<div class="nav-side-menu">
						<div class="brand">CustomerPanel</div>
						<i class="brand fa fa-bars fa-1x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
						<div class="menu-list">
							<ul id="menu-content" class="menu-content collapse out">
								<li data-toggle="collapse" data-target="#myAccount" class="collapsed active"><a href="#"><i class="fa fa-gift fa-lg"></i> My Account <span class="arrow"></span></a></li>
								<ul class="sub-menu collapse" id="myAccount">
									<li id="customerPersonalDetails"><a href="#">Personal Details</a></li>
									<li id="customerAddresses"><a href="#">Addresses</a></li>
									<li id="customerProfileSetting"><a href="#">Profile setting</a></li>
									<li id="CustomerUpdateEmail"><a href="#">Update Email</a></li>
									<li id="CustomerChangePassword"><a href="#">Change Password</a></li>
								</ul>


								<li data-toggle="collapse" data-target="#order" class="collapsed"><a href="#"><i class="fa fa-globe fa-lg"></i> Order <span class="arrow"></span></a></li>
								<ul class="sub-menu collapse" id="order">
									<li><a id="customerMyOrder" href="#">My Order</a></li>
								</ul>
								<li data-toggle="collapse" data-target="#reviewAndReporting" class="collapsed"><a href="#"><i class="fa fa-car fa-lg"></i> Review And Reporting <span class="arrow"></span></a></li>
								<ul class="sub-menu collapse" id="reviewAndReporting">
									<li>Review</li>
								</ul>

								<li data-toggle="collapse" data-target="#service" class="collapsed"><a href="#"><i class="fa fa-car fa-lg"></i> Service <span class="arrow"></span></a></li>
								<ul class="sub-menu collapse" id="service">
									<li>Customer Service</li>
									<li>Customer Care</li>
								</ul>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-8" id="mainBox">
					<div id='customermainBox'></div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
