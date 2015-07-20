<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Edit Seller</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" class="btn btn-success">Save</button>
				<button type="button" class="btn btn-warning">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Edit Seller
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
								<li class="active" id="tabMyAccount"><a data-toggle="tab" href="#tab-myaccount">My Account</a></li>
								<li id="BankDetails"><a data-toggle="tab" href="#tab-bankdetails">Bank Details</a></li>
								<li id="tabShipping and Return Policy"><a data-toggle="tab" href="#tab-shipping">Shipping and Return Policy</a></li>
								<li id="tabTaxInformation"><a data-toggle="tab" href="#tab-taxinformation">Tax Information</a></li>
								<li id="tabCommission"><a data-toggle="tab" href="#tab-commission">Commission</a></li>
								<li id="tabSetting"><a data-toggle="tab" href="#tab-setting">Setting</a></li>

							</ul>
							<!-- MYACCOUNT tab-data-->
							<div class="tab-content">
								<div class="tab-pane fade in active" id="tab-myaccount">
									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-model">First Name</label>
										<div class="col-sm-10">
											<input type="text" name="name" value="" placeholder="name" id="input-name" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-model">Last Name</label>
										<div class="col-sm-10">
											<input type="text" name="lastname" value="" placeholder="lastname" id="input-lastname" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">Gender</label>
										<div class="col-sm-10">
											<select name="status" id="input-status" placeholder="---please select---" class="form-control">
												<option value="1" selected="selected">Male</option>
												<option value="0">Female</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-sku"><span data-toggle="tooltip" title="companyname">DateOfBirth</span></label>
										<div class="col-sm-10">
											<input type="text" name="dob" value="" placeholder="dob" id="Dob" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-upc"><span data-toggle="tooltip" title="companyid">companyName</span></label>
										<div class="col-sm-10">
											<input type="text" name="companyname" value="" placeholder="companyname" id="input-companyname" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-location">Street Address</label>
										<div class="col-sm-10">
											<input type="text" name="address" value="" placeholder="address" id="input-address" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="mobile no">Office Number</label>
										<div class="col-sm-10">
											<input type="text" name="officeno" value="" placeholder="officeno" id="officeno" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-price">City</label>
										<div class="col-sm-10">
											<input type="text" name="city" value="" placeholder="city" id="input-city" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-quantity">State</label>
										<div class="col-sm-10">
											<input type="text" name="state" value="" placeholder="state" id="input-state" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-quantity">Pincode</label>
										<div class="col-sm-10">
											<input type="number" name="pincode" value="" placeholder="pincode" id="input-state" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Mobile Number</span></label>
										<div class="col-sm-10">
											<input type="number" name="mobileno" value="" placeholder="mobileno" id="input-mobileno" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Email</label>
										<div class="col-sm-10">
											<input type="text" name="email" value="" placeholder="email" id="input-email" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Pan Number</label>
										<div class="col-sm-10">
											<input type="text" name="panno" value="" placeholder="PanNo" id="input-panno" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Store Name</span></label>
										<div class="col-sm-10">
											<input type="text" name="storename" value="" placeholder="storename" id="input-storename" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">EPCH Number</span></label>
										<div class="col-sm-10">
											<input type="number" name="number" value="" placeholder="number" id="input-number" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-meta-description1">Store Description</label>
										<div class="col-sm-10">
											<textarea name="description[1][description]" rows="5" placeholder="Description" id="Description" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Company LOGO</span></label>
										<div class="col-sm-10">
											<button type="button">Browse</button>
										</div>
									</div>
								</div>
								<!-- BANK DETAILS Section -->

								<div class="tab-pane" id="tab-bankdetails">
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Bank Name</span></label>
										<div class="col-sm-10">
											<input type="text" name="name" value="" placeholder="name" id="input-name" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">Account Type</label>
										<div class="col-sm-10">
											<select name="status" id="input-status" placeholder="---please select---" class="form-control">
												<option value="1" selected="selected">Saving</option>
												<option value="0">Current Account</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label" form="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Account Name</span></label>
										<div class="col-sm-10">
											<input type="text" name="accountname" value="" placeholder="accountname" id="input-accountname" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Account Number</span></label>
										<div class="col-sm-10">
											<input type="number" name="accountno" value="" placeholder="accountno" id="input-accountno" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">IFSC code</span></label>
										<div class="col-sm-10">
											<input type="number" name="ifsccode" value="" placeholder="ifsccode" id="input-ifsccode" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">MICR Number</span></label>
										<div class="col-sm-10">
											<input type="number" name="micrno" value="" placeholder="micrno" id="input-micrno" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Branch Name</span></label>
										<div class="col-sm-10">
											<input type="text" name="branchname" value="" placeholder="branchname" id="input-branchname" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Branch Street Address</span></label>
										<div class="col-sm-10">
											<input type="text" name="branchaddress" value="" placeholder="branchaddress" id="input-branchaddress" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Branch State</span></label>
										<div class="col-sm-10">
											<input type="text" name="branchstate" value="" placeholder="branchstate" id="input-branchstate" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Branch City</span></label>
										<div class="col-sm-10">
											<input type="text" name="branchcity" value="" placeholder="branchcity" id="input-branchcity" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Branch Pincode</span></label>
										<div class="col-sm-10">
											<input type="text" name="branchpincode" value="" placeholder="branchpincode" id="input-branchpincode" class="form-control" />
										</div>
									</div>
								</div>
								<!-- SHIPPING AND RETURN POLICY Section -->
								<div class="tab-pane" id="tab-shipping">
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-meta-description1">Shipping And Return Policy</label>
										<div class="col-sm-10">
											<textarea name="shipping[1][shipping]" rows="5" placeholder="Shippping" id="shipping" class="form-control"></textarea>
										</div>
									</div>
								</div>
								<!-- Tax Information Section -->
								<div class="tab-pane" id="tab-taxinformation">
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">VAT/TIN-NO</span></label>
										<div class="col-sm-10">
											<input type="text" name="vtno" value="" placeholder="vtno" id="input-vtno" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">CST-NO</span></label>
										<div class="col-sm-10">
											<input type="text" name="cstno" value="" placeholder="cstno" id="input-cstno" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">GST-NO</span></label>
										<div class="col-sm-10">
											<input type="text" name="gstno" value="" placeholder="gstno" id="input-gstno" class="form-control" />
										</div>
									</div>
								</div>
								<!-- Commission Section -->
								<div class="tab-pane fade" id="tab-commission">
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">Commission</label>
										<div class="col-sm-10">
											<select name="status" id="input-status" class="form-control">
												<option value="1" selected="selected">Percentage10%</option>

											</select>
										</div>
									</div>
								</div>

								<!-- Setting Section -->
								<div class="tab-pane fade" id="tab-setting">
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">UserName</span></label>
										<div class="col-sm-10">
											<input type="text" name="name" value="" placeholder="name" id="input-sortorder" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">Status</label>
										<div class="col-sm-10">
											<select name="status" id="input-status" class="form-control">
												<option value="1" selected="selected">ENABLE</option>
												<option value="2" selected="selected">DISABLE</option>

											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">password</span></label>
										<div class="col-sm-10">
											<input type="text" name="password" value="" placeholder="password" id="input-sortorder" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Confirm</span></label>
										<div class="col-sm-10">
											<input type="text" name="confirm" value="" placeholder="confirm" id="input-sortorder" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">UserGroup</label>
										<div class="col-sm-10">
											<select name="usergroup" id="input-usergroup" class="form-control">
												<option value="1" selected="selected"></option>
												<option value="2" selected="selected"></option>

											</select>
										</div>
									</div>

								</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	jQuery(document).ready(function($) {
		$('#tabs').tab();
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#Dob").datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$('#Dob').on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$('#Dob').datepicker('hide');
			}
		})

	});
</script>
<script type="text/javascript">
	setPage("manageSellersMenuId");
</script>

