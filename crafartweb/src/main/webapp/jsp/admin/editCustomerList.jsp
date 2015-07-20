<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.servletContext.contextPath}" />
<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Edit Customer</h1>
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
					<i class="icon-th-list"></i> &nbsp; Edit Customer
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
								<li class="active" id="tabGeneral"><a data-toggle="tab" href="#tab-general">General</a></li>
							</ul>
							<!-- General tab-data-->
							<div>
								<form id="form-product" class="form-verical" enctype="multipart/form-data" method="post" action="#">
									<ul class="nav nav-pills nav-stacked col-lg-2">
										<li class="active" id="tabGeneral"><a data-toggle="tab" href="#tab-general">General</a></li>
										<li id="tabcustomerListAddress"><a data-toggle="tab" href="#tab-customerListAddress">Address</a></li>
										<li id="tabaddress1"><a data-toggle="tab" href="tab-address1">Add Address1</a></li>
										<li id="tabaddress2"><a data-toggle="tab" href="tab-address2">Add Address2</a></li>
										<li id="tabaddress3"><a data-toggle="tab" href="tab-address3">Add Address3</a></li>
										<li id="tabaddress4"><a data-toggle="tab" href="tab-address4">Add Address4</a></li>
										<li id="tabaddress5"><a data-toggle="tab" href="tab-address5">Add Address5</a></li>
										<li id="tabaddress6"><a data-toggle="tab" href="tab-address6">Add Address6</a></li>
										<li id="tabaddress7"><a data-toggle="tab" href="tab-address7">Add Address7</a></li>
									</ul>
									<div class="tab-content" style="border: 0px; padding: 0px;">
										<!-- General tab content -->
										<div class="tab-pane fade in active " id="tab-general">
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">First Name </label>
												<div class="col-sm-5">
													<input type="text" name="firstname" value="" placeholder="firstname" id="input-firstname" class="form-control" />
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">Last Name </label>
												<div class="col-sm-5">
													<input type="text" name="lastname" value="" placeholder="lastname" id="input-lastname" class="form-control" />
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">Email</label>
												<div class="col-sm-5">
													<input type="text" name="email" value="" placeholder="email" id="input-email" class="form-control" />
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">Password</label>
												<div class="col-sm-5">
													<input type="text" name="password" value="" placeholder="password" id="input-password" class="form-control" />
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">Confirm Password</label>
												<div class="col-sm-5">
													<input type="text" name="cpassword" value="" placeholder="cPassword" id="input-cPassword" class="form-control" />
												</div>
											</div>							
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">TelePhone</label>
												<div class="col-sm-5">
													<input type="text" name="telephone" value="" placeholder="telephone" id="input-telephone" class="form-control" />
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">Mobile Phone</label>
												<div class="col-sm-5">
													<input type="text" name="mobilephone" value="" placeholder="mobilephone" id="input-mobilephone" class="form-control" />
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label" for="input-status">NewsLetters</label>
												<div class="col-sm-5">
													<select name="status" id="newsletters" placeholder="---please select---" class="form-control">
														<option value="1" selected="selected">Enable</option>
														<option value="0">Disable</option>
													</select>
												</div>
											</div>

											<div class="form-group required col-md-10" style="margin-left:163px">
												<label class="col-sm-2 control-label" for="input-status">Status</label>
												<div class="col-sm-5">
													<select name="status" id="input-status" placeholder="---please select---" class="form-control">
														<option value="1" selected="selected">Enable</option>
														<option value="0">Disable</option>
													</select>
												</div>
											</div>
											<div class="form-group required col-md-10" style="margin-left:163px">
												<label class="col-sm-2 control-label" for="input-status">Approved</label>
												<div class="col-sm-5">
													<select name="status" id="input-status" placeholder="---please select---" class="form-control">
														<option value="1" selected="selected">Yes</option>
														<option value="0">No</option>
													</select>
												</div>
											</div>
										</div>
										<!-- General tab ends here -->
										<!-- Address Section tab-data-->
										<div class="tab-pane fade" id="tab-customerListAddress">
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">First Name </label>
												<div class="col-sm-5">
													<input type="text" name="firstname" value="" placeholder="firstname" id="input-firstname" class="form-control" />
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">Last Name </label>
												<div class="col-sm-5">
													<input type="text" name="lastname" value="" placeholder="lastname" id="input-lastname" class="form-control" />
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">Company </label>
												<div class="col-sm-5">
													<input type="text" name="company" value="" placeholder="company" id="company" class="form-control" />
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">Address 1</label>
												<div class="col-sm-5">
													<input type="text" name="address1" value="" placeholder="address1" id="address1" class="form-control" />
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">Address 2</label>
												<div class="col-sm-5">
													<input type="text" name="address2" value="" placeholder="address2" id="address2" class="form-control" />
												</div>
											</div>

											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">City</label>
												<div class="col-sm-5">
													<input type="text" name="city" value="" placeholder="city" id="city" class="form-control" />
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">Postal Code</label>
												<div class="col-sm-5">
													<input type="text" name="postalcode" value="" placeholder="postalcode" id="postalcode" class="form-control" />
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label">Country</label>
												<div class="col-sm-5">
													<select name="country" id="country" placeholder="---please select---" class="form-control">
														<option value="1" selected="selected">India</option>
													</select>
												</div>
											</div>
											<div class="form-group required col-md-10">
												<label class="col-sm-2 control-label" for="input-status">State</label>
												<div class="col-sm-5">
													<select name="state" id="state" placeholder="---please select---" class="form-control">
														<option value="1" selected="selected">TamilNadu</option>
													</select>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>


						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div> 
<script type="text/javascript">
	setPage("customerListMenuId");
</script>