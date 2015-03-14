<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

<script type="text/javascript">
	setPage("myAccountMenuId");
</script>

<script type="text/javascript">
	$(document).ready(function() {
		var msg = "SAVED SUCCESSFULLY";

		$("#SaveBtnId").click(function() {
			$("#alertSuccessId").text(msg);
		});

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
<script type="text/javascript">
	/* 
	 * *************Save button************ 
	 *taking values by val() and storing it in sellerBO, then changing that to json and passing to controller by 
	 *ajax
	 *
	 */

	$(document).ready(function() {
			$("#SaveBtnId").click(function() {
			var sellerBO = {};
			var storeBO = {};
			var addressBO = {};
			sellerBO.firstName = $("#firstName").val();
			sellerBO.gender = $("#gender").val();
			sellerBO.companyName = $("#companyName").val();
			sellerBO.tinNo = $("#tinNo").val();
			sellerBO.lastName = $("#lastName").val();
			sellerBO.dateOfBirth = $("#dp2").val();
			sellerBO.epchNo = $("#epchNo").val();
			storeBO.name = $("#storeName").val();
			addressBO.street = $("#streetAddress").val();
			addressBO.stateId = $("#states").val();
			addressBO.cityId = $("#city").val();
			addressBO.pinCode = $("#pinCode").val();
			storeBO.storeDescription = $("#storeDescripton").val();
			sellerBO.storeBO = storeBO;
			sellerBO.addressBO = addressBO;
			var postData = JSON.stringify(sellerBO);
			alert(postData);
			$.ajax({
				url : "../seller/addSeller",
				type : "post",
				data : postData,
				contentType : "application/json",
				dataType : "json",
				success : function(data) {
					alert("Saved Successfully");
				},
				error : function(error) {
					alert(error);
					alert("Details failed to save");
				}
			});
		});

	});
</script>

<div class="inner">
	<div class="row">
		<div class="col-lg-3">
			<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;My Account</h1>
		</div>
		<div class="col-lg-9 text-center" style="padding-top: 20px;">
			<div id="alertSuccessId" class=" col-lg-4 alert alert_success " style="margin-bottom: 5px; color: #FF704D; font-size: 17px;">ACTIVE</div>
			<div class=" col-lg-4 alert alert_success " style="margin-bottom: 5px; color: #FF704D; font-size: 17px;">SELLER APPROVED:YES</div>
			<div class=" col-lg-4 alert alert_success " style="margin-bottom: 5px; color: #FF704D; font-size: 17px;">COMMISSION: 10%</div>
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-lg-12">
			<div class="box">
				<div id="collapseOne" class="accordion-body collapse in body" style="padding-top: 40px; padding-bottom: 30px;">
					<form class="form-horizontal" action="#" id="block-validate">
						<div class="row">
							<div class="col-lg-5" style="margin-left: 50px;">
								<div class="form-group">
									<label for="firstName" class="control-label col-lg-4">First-Name</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="firstName" placeholder="First Name">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-lg-4">Gender</label>
									<div class="col-lg-8">
										<select class="form-control" id="gender" placeholder="Gender">
											<option value="1">Male</option>
											<option value="2">Female</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-lg-4"> Company-Name</label>
									<div class="col-lg-8">
										<input type="text" id="companyName" name="companyName" class="form-control" placeholder="Company Name" />
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-lg-4">Street-Address</label>
									<div class="col-lg-8">
										<input type="text" id="streetAddress" name="streetAddress" class="form-control" placeholder="Street Address" />
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-lg-4">City</label>
									<div class="col-lg-8">
										<input type="text" id="city" name="city" class="form-control" placeholder="City" />
									</div>
								</div>

								<div class="form-group">
									<label for="" class="control-label col-lg-4">Phone-No</label>
									<div class="col-lg-8">
										<input type="text" id="phoneNo" name="phoneNo" class="form-control" placeholder="Phone No" />
									</div>
								</div>


								<div class="form-group">
									<label for="" class="control-label col-lg-4">EPCH-No</label>
									<div class="col-lg-8">
										<input type="text" id="epchNo" name="epchNo" class="form-control" placeholder="EPCH No" />
									</div>
								</div>
							</div>
							<div class="col-lg-5">
								<div class="form-group">
									<label for="lastName" class="control-label col-lg-4">Last-Name</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="lastName" placeholder="Last Name">
									</div>
								</div>

								<div class="form-group">
									<label for="" class="control-label col-lg-4">Date-Of-Birth</label>
									<div class="col-lg-8">

										<input type="text" class="form-control" placeholder="10/09/1990" value="" data-date-format="mm/dd/yyyy" id="dp2">

									</div>
								</div>

								<div class="form-group">
									<label for="" class="control-label col-lg-4">Company-Logo</label>
									<div class="col-lg-8">
										<input type="file" id="companyLogo" name="companyLogo" placeholder="Company Logo" />
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-lg-4">States</label>
									<div class="col-lg-8">
										<input type="text" id="states" name="states" class="form-control" placeholder="States" />
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-lg-4">Pin-Code</label>
									<div class="col-lg-8">
										<input type="text" id="pinCode" name="pinCode" class="form-control" placeholder="Pin Code" />
									</div>
								</div>

								<div class="form-group">
									<label for="" class="control-label col-lg-4">Store-Name</label>
									<div class="col-lg-8">
										<input type="text" id="storeName" name="storeName" class="form-control" placeholder="Store Name" />
									</div>
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-lg-10" style="margin-left: 50px;">
								<div class="form-group">
									<label for="" class="control-label col-lg-2">Store-Descripton</label>
									<div class="col-lg-10">
										<textarea id="storeDescripton" name="storeDescripton" class="form-control" placeholder="Store Descripton" rows="5"></textarea>
									</div>
								</div>
							</div>

						</div>
						<br>

						<div class="row">
							<center>
								<a class="btn btn-success" id="SaveBtnId">&nbsp;&nbsp;SAVE&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp; <a class="btn btn-danger" id="canelbtn" href="#">CANCEL</a>
							</center>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>




