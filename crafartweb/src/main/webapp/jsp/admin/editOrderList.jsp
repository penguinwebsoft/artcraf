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
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Edit Order</h1>
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
					<i class="icon-th-list"></i> &nbsp; Edit Order
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
								<li class="active" id="tabCustomerDetails"><a data-toggle="tab" href="#tab-customerdetails">Customer Details</a></li>
								<li id="tabProducts"><a data-toggle="tab" href="#tab-products">Products</a></li>
								<li id="tabPaymentDetails"><a data-toggle="tab" href="#tab-paymentdetails">Payment Details</a></li>
								<li id="tabShippingDetails"><a data-toggle="tab" href="#tab-shippingdetails">Shipping Details</a></li>
								<li id="tabTotals"><a data-toggle="tab" href="#tab-totals">Totals</a></li>
							</ul>
							<div class="tab-content">
								<!-- General tab-data-->
								<div class="tab-pane fade in active" id="tab-customerdetails">
									<div class="form-group required">
										<label class="col-sm-2 control-label">Email</label>
										<div class="col-sm-10">
											<input type="text" name="email" value="" placeholder="email" id="email" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label">First Name</label>
										<div class="col-sm-10">
											<input type="text" name="firstname" value="" placeholder="firstname" id="firstname" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label">Last Name</label>
										<div class="col-sm-10">
											<input type="text" name="lastname" value="" placeholder="lastname" id="lastname" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label">Mobile Number</label>
										<div class="col-sm-10">
											<input type="number" name="mobilenumber" value="" placeholder="mobilenumber" id="mobilenumber" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label">Telephone number</label>
										<div class="col-sm-10">
											<input type="number" name="telephonenumber" value="" placeholder="telephonenumber" id="telephonenumber" class="form-control" />
										</div>
									</div>
								</div>
								<!-- Products Section -->
								<div class="tab-pane" id="tab-products">
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-categories">Categories</label>
										<div class="col-sm-10">
											<select name="categories" id="input-categories" class="form-control">
												<option value="1" selected="selected"></option>
												<option value="2"></option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-subcategories">Sub Categories</label>
										<div class="col-sm-10">
											<select name="subcategories" id="input-subcategories" class="form-control">
												<option value="1" selected="selected"></option>
												<option value="2"></option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label"><span data-toggle="tooltip" title="Force a minimum ordered amount">Product Name</span></label>
										<div class="col-sm-10">
											<input type="text" name="productname" value="" placeholder="productname" id="input-productname" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label"><span data-toggle="tooltip" title="Force a minimum ordered amount">Seller Name</span></label>
										<div class="col-sm-10">
											<input type="text" name="sellername" value="" placeholder="sellername" id="input-sellername" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">SKU</span></label>
										<div class="col-sm-10">
											<input type="text" name="sku" value="" placeholder="sku" id="input-sku" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Quantity</span></label>
										<div class="col-sm-10">
											<input type="text" name="quantity" value="" placeholder="quantity" id="input-quantity" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Unit Price</span></label>
										<div class="col-sm-10">
											<input type="text" name="unitprice" value="" placeholder="unitprice" id="input-unitprice" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Total</span></label>
										<div class="col-sm-10">
											<input type="text" name="total" value="" placeholder="total" id="input-total" class="form-control" />
										</div>
									</div>
								</div>
								<!-- Shipping Details Section -->
								<div class="tab-pane" id="tab-shippingdetails">
									<div class="col-lg-6">
										<div class="form-group">
											<label class="col-sm-2 control-label"><span data-toggle="tooltip" title="Force a minimum ordered amount">Street Address</span></label>
											<div class="col-sm-10">
												<input type="text" name="streetaddress" value="" placeholder="streetaddress" id="input-streetaddress" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label"><span data-toggle="tooltip" title="Force a minimum ordered amount">City</span></label>
											<div class="col-sm-10">
												<input type="text" name="city" value="" placeholder="city" id="input-city" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Land Mark</span></label>
											<div class="col-sm-10">
												<input type="text" name="landmark" value="" placeholder="landmark" id="input-landmark" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">State</span></label>
											<div class="col-sm-10">
												<input type="text" name="state" value="" placeholder="state" id="input-state" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Pincode</span></label>
											<div class="col-sm-10">
												<input type="text" name="pincode" value="" placeholder="pincode" id="input-pincode" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-country">Country</label>
											<div class="col-sm-10">
												<select name="country" id="input-country" class="form-control">
													<option value="1" selected="selected">INDIA</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Mobile Number</span></label>
											<div class="col-sm-10">
												<input type="text" name="mobileno" value="" placeholder="mobileno" id="input-mobileno" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">LandLine Number</span></label>
											<div class="col-sm-10">
												<input type="text" name="landlineno" value="" placeholder="landlineno" id="input-landlineno" class="form-control" />
											</div>
										</div>
									</div>
									<div class="col-lg-6">
										<div class="form-group">
											<label class="col-sm-2 control-label">Same Billing Address</label> Yes <input type="radio" onclick="javascript:yesnoCheck();" name="yesno" id="yesCheck"> No <input type="radio"
												onclick="javascript:yesnoCheck();" name="yesno" id="noCheck"><br>
										</div>
										<div id="ifNo" style="display: none">
											<div class="" id='no' name='no'>
												<div class="form-group">
													<label class="col-sm-2 control-label"><span data-toggle="tooltip" title="Force a minimum ordered amount">Street Address</span></label>
													<div class="col-sm-10">
														<input type="text" name="streetaddress" value="" placeholder="streetaddress" id="input-streetaddress" class="form-control" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label"><span data-toggle="tooltip" title="Force a minimum ordered amount">City</span></label>
													<div class="col-sm-10">
														<input type="text" name="city" value="" placeholder="city" id="input-city" class="form-control" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Land Mark</span></label>
													<div class="col-sm-10">
														<input type="text" name="landmark" value="" placeholder="landmark" id="input-landmark" class="form-control" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">State</span></label>
													<div class="col-sm-10">
														<input type="text" name="state" value="" placeholder="state" id="input-state" class="form-control" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Pincode</span></label>
													<div class="col-sm-10">
														<input type="text" name="pincode" value="" placeholder="pincode" id="input-pincode" class="form-control" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label" for="input-country">Country</label>
													<div class="col-sm-10">
														<select name="country" id="input-country" class="form-control">
															<option value="1" selected="selected">INDIA</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Mobile Number</span></label>
													<div class="col-sm-10">
														<input type="text" name="mobileno" value="" placeholder="mobileno" id="input-mobileno" class="form-control" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">LandLine Number</span></label>
													<div class="col-sm-10">
														<input type="text" name="landlineno" value="" placeholder="landlineno" id="input-landlineno" class="form-control" />
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- Total Section -->
								<div class="tab-pane" id="tab-totals">
									<div class="row">
										<div class=col-md-10>
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
															<td class="pull-right"><span>&middot;</span>&nbsp;GST&nbsp;10%&nbsp;included&nbsp;(1234243)</td>
															<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
															<td>$<span>8.00</span>
															</td>
														</tr>
														<tr>
															<td class="pull-right"><span>&middot;</span>&nbsp;CST&nbsp;10%&nbsp;included&nbsp;(1234244)</td>
															<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
															<td>$<span>8.00</span>
															</td>
														</tr>
														<tr>
															<td class="pull-right"><span>&middot;</span>&nbsp;Discount Coupon Code()&nbsp;</td>
															<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
															<td><span></span></td>
														</tr>
														<tr>
															<td class="pull-right"><h4>Total:</h4></td>
															<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
															<td>$<span>972.00</span>
															</td>
														</tr>
													</table>
												</div>
											</div>
											<div class="form-group required">
												<label class="col-sm-2 control-label">Comment</label>
												<div class="col-sm-10">
													<input type="text" name="comment" value="" placeholder="comment" id="comment" class="form-control" aria-hidden="false" />
													<textarea id="comment" class="form-control"></textarea>
												</div>
											</div>
										</div>
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
	function yesnoCheck() {
		if (document.getElementById('noCheck').checked) {
			document.getElementById('ifNo').style.display = 'block';
		} else
			document.getElementById('ifNo').style.display = 'none';
	}
</script>
<!-- <script type="text/javascript">
	$('#input-address').on('change', function() {
		var toType = this.value;
		if (toType == 2) {
			$('.addressNo').show();
		} else {
			$('.addressNo').hide();
		}

	});
</script> -->