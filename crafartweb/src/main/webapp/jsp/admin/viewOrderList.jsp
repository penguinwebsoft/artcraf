<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

<script type="text/javascript">
	$(function() {
		formInit();
	});

	$(document).ready(function() {

		$("#input-order-status").on('change', function(e) {
			var valueSelected = this.value;
			if (valueSelected == 3) {
				$("#selectedCourierNameId").show();
				$("#selectedShippingTrackingNumberId").show();
			} else {
				$("#selectedCourierNameId").hide();
				$("#selectedShippingTrackingNumberId").hide();
			}
		});

	});
</script>

<script type="text/javascript">
	var shipping_row = 0;
	var attribute_row = 0;
	var discount_row = 0;
	var image_row = 0;
	var special_row = 0;

	$(document).ready(function() {

		$("#dateOfBirthId").datepicker({
			viewMode : 'years',
			format : 'dd/mm/yyyy',

		});

		$('#dateOfBirthId').on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$('#dateOfBirthId').datepicker('hide');
			}
		});

		$("#ProductTaxId").on('change', function(e) {
			var valueSelected = this.value;
			if (valueSelected == 0) {
				$("#taxVatId").hide();
				$("#taxCstId").hide();
			} else {
				$("#taxVatId").show();
				$("#taxCstId").show();
			}
		});

		/* 	$.ajax({
				url : "../crafartorder/getOrderBO",
				type : "post",
				contentType : "application/json",
				dataType : "json",
				success : function(data) {
					alert(data);
				}
			}); */

	});
</script>

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; View Order</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" class="btn btn-success">Print Invoice</button>
				<button type="button" class="btn btn-primary">Print Shipping List</button>
				<button><a class="btn btn-warning" href="${baseURL}/menu/editOrderList">Edit</a></button>
				<button type="button" class="btn btn-default">Cancel</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; View Order
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px;">
								<li class="active"><a data-toggle="tab" href="#tab-orderDetails">Order Details</a></li>
								<li><a data-toggle="tab" href="#tab-updateStatusOfOrder">Update Status Of Order</a></li>
							</ul>
							<div class="tab-content" style="border: 0px; padding: 0px;">
								<div class="tab-pane fade in active" id="tab-orderDetails">
									<div class="row">
										<div class="col-lg-3">
											<div class="panel panel-default" style="background-color: #f2f2f2;">
												<div class="panel-heading">Customer information</div>
												<div class="panel-body" style="margin-bottom: 20px;">
													<div class="row">
														<div class="col-sm-2">
															<i class="icon-user" style="font-size: 20px;"></i>
														</div>
														<div class="col-sm-10">
															<a href="#">Customer Customer</a> <br> <a href="#">customer@example.com</a> <br> IP address: 127.0.0.1
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-3">
											<div class="panel panel-default" style="background-color: #f2f2f2;">
												<div class="panel-heading">Shipping address</div>
												<div class="panel-body">
													<div class="row">
														<div class="col-sm-2">
															<i class=" icon-truck" style="font-size: 20px;"></i>
														</div>
														<div class="col-sm-10">
															<address>
																<strong>Twitter, Inc.</strong> <br> 795 Folsom Ave, Suite 600 <br> San Francisco, CA 94107 <br> <abbr title="Phone">P:</abbr> (123) 456-7890
															</address>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-3">
											<div class="panel panel-default" style="background-color: #f2f2f2;">
												<div class="panel-heading">Billing address</div>
												<div class="panel-body">
													<div class="row">
														<div class="col-sm-2">
															<i class="icon-tag" style="font-size: 20px;"></i>
														</div>
														<div class="col-sm-10">
															<address>
																<strong>Twitter, Inc.</strong> <br> 795 Folsom Ave, Suite 600 <br> San Francisco, CA 94107 <br> <abbr title="Phone">P:</abbr> (123) 456-7890
															</address>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class=col-md-8>
											<div class="row">
												<div class="table-responsive">
													<table width="100%" class="table table-middle">
														<thead>
															<tr>
																<th width="50%">Product</th>
																<th width="10%">Price</th>
																<th class="center" width="10%">Quantity</th>
																<th width="10%" class="right">&nbsp;Subtotal</th>
															</tr>
														</thead>
														<tr>
															<td><a href="http://demo.mv.cs-cart.com/vendor.php?dispatch=products.update&amp;product_id=214">ASUS CP6130</a>
																<div class="products-hint">
																	<p>CODE:K02149B2ZX</p>
																	<!-- Hook Reward points start -->
																	<!-- Hook Reward points end -->
																</div></td>
															<td class="nowrap">$<span>972.00</span>
															</td>
															<td class="center">&nbsp;1<br />
															</td>
															<td class="right">&nbsp;<span> $<span>972.00</span>
															</span></td>
														</tr>
													</table>
												</div>
											</div>

											<div class="row">
												<div class="table-responsive pull-right">
													<table class="table borderless">
														<tr class="totals">
															<td>&nbsp;</td>
															<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
															<td><h4>Totals</h4></td>
														</tr>

														<tr>
															<td class="pull-right">Subtotal:</td>&nbsp;&nbsp;
															<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
															<td>$<span>972.00</span>
															</td>
														</tr>
														<tr>
															<td class="pull-right">Taxes:</td>
															<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
															<td>&nbsp;</td>
														</tr>

														<tr>
															<td class="pull-right"><span>&middot;</span>&nbsp;VAT&nbsp;10%&nbsp;included&nbsp;(1234242)</td>
															<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
															<td>$<span>88.36</span>
															</td>
														</tr>

														<tr>
															<td class="pull-right"><h4>Total:</h4></td>
															<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
															<td>$<span>972.00</span>
															</td>
														</tr>
														<tr>
															<td class="pull-right"><h4>Commend:</h4></td>
															<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
														</tr>
													</table>
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="panel panel-default" style="background-color: #f2f2f2; margin-top: 15px;">
												<div class="panel-body">
													<div class="row">
														<div class=" col-sm-5" style="padding-right: 10px;">
															<h4>Status</h4>
														</div>
														<div class="col-sm-6" style="margin-top: 10px;">
															<a id="" class="dropdown-toggle" data-toggle="dropdown"> Open <span class="caret"></span>
															</a>
															<ul class="dropdown-menu">
																<li><a>Backordered</a></li>
																<li><a>Complete</a></li>
																<li><a>Declined</a></li>
																<li><a>Canceled</a></li>
																<li><a>Open</a></li>
																<li><a>Processed</a></li>
																<li><a>Awaiting call</a></li>
															</ul>
														</div>
													</div>
													<div class="row" style="padding: 10px;">
														<h4>Payment information</h4>
														<span class="col-md-4"> Method </span> <span class="col-md-8"> Credit card (Visa Mastercard, etc...)</span>
													</div>
													<div class="row" style="padding: 10px;">
														<h4>Shipping information</h4>
														<span class="col-md-4"> Method </span> <span class="col-md-8">Custom shipping method </span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- Start tab-update Status Of Order-->
								<div class="tab-pane fade" id="tab-updateStatusOfOrder">
									<div id="history">
										<table class="table table-bordered">
											<thead>
												<tr>
													<td class="text-left">Date Added</td>
													<td class="text-left">Comment</td>
													<td class="text-left">Status</td>
													<td class="text-left">Customer Notified</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td class="text-left">26/02/2015</td>
													<td class="text-left"></td>
													<td class="text-left">Pending - Default Store</td>
													<td class="text-left">No</td>
												</tr>
												<tr>
													<td class="text-left">02/03/2015</td>
													<td class="text-left"></td>
													<td class="text-left">Shipped - Default Store</td>
													<td class="text-left">No</td>
												</tr>
												<tr>
													<td class="text-left">02/03/2015</td>
													<td class="text-left">this is a test only</td>
													<td class="text-left">Shipped - Default Store</td>
													<td class="text-left">No</td>
												</tr>
											</tbody>
										</table>
										<div class="row">
											<div class="col-sm-6 text-left"></div>
											<div class="col-sm-6 text-right">Showing 1 to 3 of 3 (1 Pages)</div>
										</div>

									</div>
									<br />
									<fieldset>
										<legend>Update Order Status</legend>
										<form class="form-horizontal">
											<div class="form-group">
												<label class="col-sm-2 control-label" for="input-order-status">Order Status</label>
												<div class="col-sm-10">
													<select name="order_status_id" id="input-order-status" class="form-control">
														<option value="7" selected="selected">Canceled</option>
														<option value="5" selected="selected">Complete</option>
														<option value="1" selected="selected">Pending</option>
														<option value="15" selected="selected">Processed</option>
														<option value="2" selected="selected">Processing</option>
														<option id="shippingId" value="3" selected="selected">Shipped</option>
													</select>
												</div>
											</div>

											<div class="form-group" id="selectedCourierNameId">
												<label class="col-sm-2 control-label" for="courierNameId">Courier Name</label>
												<div class="col-sm-10">
													<select name="courierName" id="courierNameId" class="form-control">
														<option value="1" selected="selected">DHL</option>
														<option value="2" selected="selected">EMS</option>
													</select>
												</div>
											</div>

											<div class="form-group" id="selectedShippingTrackingNumberId">
												<label class="col-sm-2 control-label" for="shippingTrackingNumberId">Tracking Number</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" value="" placeholder="Tracking Number" name="shippingTrackingNumber" id="shippingTrackingNumberId" />
												</div>
											</div>

											<div class="form-group">
												<label class="col-sm-2 control-label" for="input-notify">Notify Customer</label>
												<div class="col-sm-10">
													<input type="checkbox" name="notify" value="1" id="input-notify" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="input-comment">Comment</label>
												<div class="col-sm-10">
													<textarea name="comment" rows="8" id="input-comment" class="form-control"></textarea>
												</div>
											</div>
										</form>
										<div class="text-right">
											<button id="button-history" data-loading-text="Loading..." class="btn btn-primary">
												<i class="fa fa-plus-circle"></i> Update Order
											</button>
										</div>
									</fieldset>
								</div>
							</div>
						</form>
					</div>

					<div class="row">
						<div class="col-sm-6 text-left"></div>
						<div class="col-sm-6 text-right"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


