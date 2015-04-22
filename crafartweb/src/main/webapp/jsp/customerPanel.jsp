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
															"<div id='customermainBox' class='col-md-8'><div class='form-group' style='margin-left:15%;'><label for='first Name' class='control-label'>First Name :</label><input type='text' style='width:45%;margin-right:15%' text-align:'left' class='form-control pull-right' id='first Name' /></div><div class='form-group'><label for='last Name' class='control-label' style='margin-left:15%;'>Last Name :</label><input type='text' style='width:40%;margin-right:15%' class='form-control pull-right' id='last Name' /></div><div class='form-group' style='margin-left:15%;'><label for='dateofBirth' class='control-label'>Date Of Birth :</label><input type='text' style='width:45%;margin-right:15%' class='form-control pull-right' id='dateofBirth' /></div><div class='form-group' style='margin-left:15%;'><label for='mobile Number' class='control-label'>mobile Number :</label><input type='text' style='width:45%;margin-right:15%' class='form-control pull-right' id='mobile Number' /></div><div class='form-group' style='margin-left:15%;'><label for='gender' class='control-label'>Gender :</label><select type='text' id='gender' style='width:45%;margin-right:15%' name='Gender' class='form-control pull-right'><option value='1'>Male</option><option value='2'>Female</option></select></div><div class='form-group' style='margin-left:15%;'><label for='address' class='control-label'>Address :</label><input type='text' style='width:45%;margin-right:15%' class='form-control pull-right' id='address' /></div><div class='form-group' style='margin-left:15%;'><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>SaveChanges</button></div></div>");
										});

						$("#customerAddresses")
								.click(
										function() {
											$("#customermainBox").remove();
											$("#mainBox")
													.append(
															"<div id='customermainBox' class='col-md-8' style='margin-left:15%;'><div class='form-group' style='margin-left:15%;'><label for='streetaddress' class='control-label'>StreetAddress :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='streetaddress'/></div><div class='form-group' style='margin-left:15%;'><label for='city' class='control-label'>City :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='city'/></div><div class='form-group' style='margin-left:15%;'><label for='landMark' class='control-label'>Land Mark :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='landMark'/></div><div class='form-group' style='margin-left:15%;'><label for='state' class='control-label'>State :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='state'/></div><div class='form-group' style='margin-left:15%;'><label for='pinCode' class='control-label'>PinCode :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='pinCode'/></div><div class='form-group' style='margin-left:15%;'><label for='country' class='control-label'>Country :</label><select type='text' id='country' name='country' style='width:50%;margin-right:15%' class='form-control pull-right'><option value='1'>India</option></select></div><div class='form-group' style='margin-left:15%;'><label for='mobile no' class='control-label'>Mobile no :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='mobile no'/></div><div class='form-group' style='margin-left:15%;'><label for='landlineno' class='control-label'>landLineno :</label><input type='text' style='width:50%;margin-right:15%' class='form-control pull-right' id='landLineno'/></div><div class='form-group'><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>SaveChanges</button></div></div>");

										});

						$("#customerProfileSetting")
								.click(
										function() {
											$("#customermainBox").remove();
											$("#mainBox")
													.append(
															"<div id='customermainBox' class='col-md-8'><div class='form-group' style='margin-left:15%;'><label for='text' class='control-label'>Public Profile Name :</label><input type='text' style='width:45%;margin-right:15%' class='form-control pull-right' id='text'/><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>SaveChanges</button></div>")
										});

						$("#CustomerUpdateEmail")
								.click(
										function() {
											$("#customermainBox").remove();
											$("#mainBox")
													.append(
															"<div id='customermainBox' class='col-md-8'><div class='form-group'><label for='email' class='control-label'>EMAIL ID :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='email'/></div><div class='form-group'><label for='password' class='control-label'>PASSWORD :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='password'/></div><div class='form-group'><label for='confirmPassword' class='control-label'>CONFIRM PASSWORD :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='confirmPassword'/></div><div class='form-group'><label for='alternativeEmail' class='control-label'>ALTERNATIVE EMAIL :</label><input type='text' style='width:42%;margin-right:15%' class='form-control pull-right' id='alternativeEmail'/></div><div class='form-group'><button type='button' style='margin-left: 15%; margin-top: 3%' class='btn btn-primary'>SaveChanges</button></div>");

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
													"<div id='customermainBox' class='col-md-8'><div class='form-group' style='margin-left:15%;'><ul class='nav nav-tabs'><li role='presentation' class='active'><a href='#'>Recent Orders</a></li><li role='presentation'><a href='#'>Past Orders</a></li></ul></div></div>");

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
					<ul id="menu" class="collapse" id="sampleTabs" style="background-color: gray;">
						<li class="panel" id="customerPanel"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-nav"> <i class="fa fa-tachometer"> </i> My Profile <span
								class="pull-right"> <i class="icon-angle-down"></i> </span>&nbsp;
						</a>
							<ul class="collapse" id="component-nav">
								<li><a id="customerPersonalDetails" href="#"> <i class="icon-angle-right"></i> Personal Details
								</a></li>
								<li><a id="customerAddresses" href="#"> <i class="icon-angle-right"></i> Address
								</a></li>
								<li><a id=customerProfileSetting href="#"> <i class="icon-angle-right"></i> Customer Profile Setting
								</a></li>
								<li><a id="CustomerUpdateEmail" href="#"> <i class="icon-angle-right"></i> Update Email
								</a></li>
								<li><a id="CustomerChangePassword" href="#"> <i class="icon-angle-right"></i> Change Password
								</a></li>
							</ul></li>
						<li class="panel" id="CustomerOrder"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-navs"> Order <span
								class="pull-right"> <i class="icon-angle-down"></i>
							</span> &nbsp;
						</a>
							<ul class="collapse" id="component-navs">
								<li><a id="customerMyOrder" href="#"> <i class="icon-angle-right"></i> My Orders
								</a></li>
							</ul></li>
						<li class="panel" id="customerReviewAndReporting"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-report-navs1">  ReviewAndReporting<span class="pull-right"> <i class="icon-angle-down"></i>
							</span> &nbsp;
						</a>
							<ul class="collapse" id="component-report-navs1">
								<li><a id="customerReview" href=""> <i class="icon-angle-right"></i> Review
								</a></li>
							</ul></li>
						<li class="panel" id="customerService"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-report-navs2">  Service <span
								class="pull-right"> <i class="icon-angle-down"></i>
							</span> &nbsp;
						</a>
							<ul class="collapse" id="component-report-navs2">
								<li><a id="customerControl" href=""> <i class="icon-angle-right"></i> Customer Control
								</a></li>
								<li><a id="customerCare" href=""> <i class="icon-angle-right"></i> Customer Care
								</a></li>
							</ul></li>
					</ul>
				</div>
				<div class="col-md-8" id="mainBox"></div>
			</div>
		</div>
	</div>

</body>
</html>
