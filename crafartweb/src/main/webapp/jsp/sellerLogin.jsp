<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$("#dateOfBirth").datepicker({
							viewMode : 'years',
							format : 'yyyy/mm/dd',
						});

						$('#dateOfBirth').on('changeDate', function(ev) {
							//close when viewMode='0' (days)
							if (ev.viewMode === 'days') {
								$('#dateOfBirth').datepicker('hide');
							}
						});

						$("#createAccontButton").click(
								function() {
									var sellerBO = {};
									var storeBO = {};
									var addressBO = {};
									var contactBOs = new Array();
									sellerBO.firstName = $("#firstName").val();
									sellerBO.lastName = $("#lastName").val();
									sellerBO.gender = $("#gender").val();
									sellerBO.dateOfBirth = $("#dateOfBirth")
											.val();
									sellerBO.password = $("#Password").val();

									var contactBO = {};
									contactBO.contactValue = $("#emailId")
											.val();
									contactBO.contactTypeId = 3;
									contactBOs.push(contactBO);

									var contactBO1 = {};
									contactBO1.contactValue = $("#mobileNo")
											.val();
									contactBO1.contactTypeId = 1;
									contactBOs.push(contactBO1);

									var contactBO2 = {};
									contactBO2.contactValue = $(
											"#alternativeEmailId").val();
									contactBO2.contactTypeId = 4;
									contactBOs.push(contactBO2);

									var contactBO3 = {};
									contactBO3.contactValue = $("#PhoneNo")
											.val();
									contactBO3.contactTypeId = 2;
									contactBOs.push(contactBO3);

									sellerBO.companyName = $("#companyName")
											.val();
									addressBO.street = $("#streetAddress")
											.val();
									addressBO.stateId = $("#state").val();
									addressBO.cityId = $("#city").val();
									addressBO.pinCode = $("#pincode").val();
									storeBO.name = $("#shopName").val();
									storeBO.storeUrl = $("#shopUrl").val();

									sellerBO.storeBO = storeBO;
									sellerBO.addressBO = addressBO;
									sellerBO.contactBOs = contactBOs;
									var postData = JSON.stringify(sellerBO);
									alert(postData);

									if ($("#Password").val() == $(
											"#confirmPassword").val()) {
										$.ajax({
											url : "../seller/addSeller",
											type : "post",
											data : postData,
											contentType : "application/json",
											dataType : "json",
											success : function(data) {
												if (data.result) {
													alert(data.message);
												} else
													alert(data.message);
											}
										});
									} else {
										alert("Password Mismatch");
									}
								});

						$("#checkAvailabilityButton")
								.click(
										function() {

											alert($("#shopUrl").val());
											if ($("#shopUrl").val() != null
													&& $("#shopUrl").val() != undefined) {
												alert($("#shopUrl").val());
												$
														.ajax({
															url : "../seller/checkStoreUrlAvailability",
															type : "post",
															data : "shopUrl="
																	+ $(
																			"#shopUrl")
																			.val(),
															dataType : "json",
															success : function(
																	data) {
																if (data.result) {
																	alert(data.message);
																} else
																	alert(data.message);
															}
														});
											} else
												alert("ShopUrl cannot be empty");
										});

						$("#LoginButton")
								.click(
										function() {
											$
													.ajax({
														url : "../seller/login",
														type : "post",
														cache : false,
														dataType : "json",
														data : "userEMailId="
																+ $(
																		"#login_Email")
																		.val()
																+ '&userPassword='
																+ $(
																		"#login_Password")
																		.val(),
														success : function(data) {
															alert(data.message);
															window.location
																	.replace("../menu/dashboard");
														}
													});
										});

					});
</script>




<div class="row-fluid">
	<div style="margin-top: 1%;" class="row-fluid" class="col-lg-12">
		<div class="col-md-6" id="loginContent">
			<div id="checkListMainBox" style="margin-left: 15%">
				<span><h3>Facilities offered to sale products</h3></span>
				<div id="checkBox1" style="margin-top: 5%">
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
					<label for="firstName" class="control-label">First Name:</label><input type="text" class="form-control" id="firstName" />
				</div>
				<div class="form-group">
					<label for="Gender" class="control-label">Gender:</label><select type="text" id="gender" name="Gender" class="form-control">
						<option value="1">Male</option>
						<option value="2">Female</option>
					</select>
				</div>

				<div class="form-group">
					<label for="emailId" class="control-label">Email id:</label><input type="text" class="form-control" id="emailId" />
				</div>

				<div class="form-group">
					<label for="Password" class="control-label">Password:</label><input type="password" id="Password" name="Password" class="form-control" />
				</div>

				<div class="form-group">
					<label for="PhoneNo" class="control-label">Phone No:</label><input type="text" id="PhoneNo" name="PhoneNo" class="form-control" />
				</div>


				<div class="form-group">
					<label for="CompanyName" class="control-label">Company Name:</label><input type="text" id="companyName" name="CompanyName" class="form-control" />
				</div>

				<div class="form-group">
					<label for="city" class="control-label">City:</label><input type="text" id="city" name="city" class="form-control" />
				</div>

				<div class="form-group">
					<label for="state" class="control-label">State:</label><input type="text" id="state" name="state" class="form-control" />
				</div>
				<div class="form-group">
					<label for="ShopUrl" class="control-label">ShopUrl</label><input type="text" id="shopUrl" name="ShopUrl" class="form-control" /><span class="lfloat" style="margin-top: 3%;"><button
							class="btn btn-small btn-primary" id="checkAvailabilityButton" type="button">CheckAvailability</button> </span> <span class="lfloat" style="margin-top: 5%; margin-left: 2%"><p
							style="color: blue;">http://www.crafart.com/handcrafart</p></span>
				</div>

			</div>
		</div>
		<div class="col-md-3" id="registrationPart2">
			<div id="sellerRegistration2">
				<div class="form-group">
					<label for="LastName" class="control-label">Last Name:</label><input type="text" class="form-control" id="lastName">
				</div>

				<div class="form-group">
					<label for="Dob" class="control-label">Date of Birth:</label><input type="text" id="dateOfBirth" name="dateOfBirth" class="form-control" data-date-format="yyyy/mm/dd" />
				</div>

				<div class="form-group">
					<label for="alternativeEmailId" class="control-label">Alternative Email id:</label><input type="text" id="alternativeEmailId" name="alternativeEmailId" class="form-control" />
				</div>


				<div class="form-group">
					<label for="confirmPassword" class="control-label">Confirm Password:</label><input type="password" id="confirmPassword" name="confirmPassword" class="form-control" />
				</div>


				<div class="form-group">
					<label for="mobileNo" class="control-label">Mobile no:</label><input type="" id="mobileNo" name="mobileNo" class="form-control" />
				</div>

				<div class="form-group">
					<label for="streetAddress" class="control-label">Street Address:</label><input type="text" id="streetAddress" name="streetAddress" class="form-control" />
				</div>


				<div class="form-group">
					<label for="pincode" class="control-label">Pincode:</label><input type="text" id="pincode" name="pincode" class="form-control" />
				</div>

				<div class="form-group">
					<label for="country" class="control-label">Country:</label><select type="text" id="country" name="country" class="form-control">
						<option value="1">India</option>
						<option value="2">Kerala</option>
						<option value="3">Delhi</option>
					</select>
				</div>
				<div class="form-group">
					<label for="shopName" class="control-label">Shop Name:</label><input type="text" id="shopName" name="shopName" class="form-control" />
				</div>
			</div>
		</div>
		<div class="col-md-6 col-md-offset-6">
			<span class="pull-left">Eg: If Shop Name is "handcraft", enter "handcraft" above. Your shop url will be http://www.crafart.com/handcraft</span> <span class="pull-left">Note: Spaces And
				Special characters are not allowed.</span>

		</div>

		<!-- <div class="row">
					<div class="col-md-6 col-md-offset-6" id="loginContent">
						<div style="margin-top: 2%">
							<input type="checkbox"/> By clicking Register,you agree that you have read and accepted the <a href="#">Policy for seller</a>, <a href="#">Terms & Conditions</a>, <a href="#">Privacy
								Policy</a>and that you are at least 18 years old.
						</div>

					</div> -->
	</div>
	<div class="row-fluid">
		<div class="col-md-6 col-md-offset-6" id="loginContent">
			<div style="margin-top: 2%">
				<input type="checkbox" /> By clicking Register,you agree that you have read and accepted the <a href="#">Policy for seller</a>, <a href="#">Terms & Conditions</a>, <a href="#">Privacy Policy</a>and
				that you are at least 18 years old.
			</div>

		</div>
	</div>
	<div class="row-fluid">
		<div class="col-md-2 col-md-offset-8">
			<div id="createAccontButton" style="margin-top: 7%">
				<a class="btn btn-success" id="loginButton" style="border-radius: 0px;">Create Account</a>&nbsp;&nbsp;&nbsp;
			</div>
		</div>
	</div>
</div>

<div class="row-fluid col-lg-12">
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
