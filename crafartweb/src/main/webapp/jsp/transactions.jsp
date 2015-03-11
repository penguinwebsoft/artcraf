<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<script>
	$(document).ready(function() {
		$('#dataTables-example').dataTable();

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

		$("#dp3").datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$('#dp3').on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$('#dp3').datepicker('hide');
			}
		});

	});
</script>

<script type="text/javascript">
	setPage("transactionsMenuId");
</script>

<div class="inner">
	<div class="row">
		<div class="col-lg-3">
			<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Sales Report</h1>
		</div>
	</div>
	<hr />

	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="fa fa-list"></i> Sales Report
				</h3>
			</div>
			<div class="panel-body">
				<div class="panel panel-default">
					<form method="post" enctype="multipart/form-data" id="form">
						<div class="row">
							<div class="col-md-3">
								<div class="tile" style="background-color: #FF5C33;">
									<div class="tile_heading">Balance</div>
									<div class="tile_body">
										<i class="icon-shopping-cart"></i>
										<h2 class="pull-right">
											<span class=" icon-inr"></span>&nbsp;10000
										</h2>
									</div>
								</div>
							</div>

							<div class=" col-md-3">
								<div class="tile" style="background-color: #0099FF;">
									<div class="tile_heading">Shipping</div>
									<div class="tile_body">
										<i class="icon-truck"></i>
										<h2 class="pull-right">
											<span class=" icon-inr"></span>&nbsp;1000
										</h2>
									</div>
								</div>
							</div>

							<div class="col-lg-3 col-md-3 col-sm-6">
								<a href="#">
									<div class="tile" style="background-color: #19A347;">
										<div class="tile_heading">Coupon</div>
										<div class="tile_body">
											<i class="icon-signal"></i>
											<h2 class="pull-right">
												<span class=" icon-inr"></span>&nbsp;10000
											</h2>
										</div>
									</div>
								</a>
							</div>

							<div class="col-lg-3 col-md-3 col-sm-6">
								<div class="tile" style="background-color: #FF3333;">
									<div class="tile_heading">Total Revenue</div>
									<div class="tile_body">
										<i class="icon-money"></i>
										<h2 class="pull-right">
											<span class=" icon-inr"></span>&nbsp;100000000
										</h2>
									</div>
								</div>
							</div>
						</div>


						<div class="well">
							<div class="row">
								<div class="col-sm-3">

									<div class="form-group">
										<label class="control-label" for="input-date-start">Date Start :</label>
										<div class="input-group">
											<input type="text" name="filter_date_start" class="form-control" placeholder="Date Start :" value="" data-date-format="mm/dd/yyyy" id="dp2">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label" for="input-date-end">Date End:</label>
										<div class="input-group">
											<input type="text" name="filter_date_end" class="form-control" placeholder="Date End:" value="" data-date-format="mm/dd/yyyy" id="dp3">
										</div>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="form-group">
										<label class="control-label" for="input-vendor-group">Group By :</label> <select name="filter_vendor_group" id="input-vendor-group" class="form-control">
											<option value="3" selected="selected">Apple Pte Ltd</option>
										</select>
									</div>
									<div class="form-group">
										<label class="control-label" for="input-order-status-id">Order Status :</label> <select name="filter_order_status_id" id="input-order-status-id" class="form-control">
											<option value="0">All Statuses</option>
											<option value="7">Canceled</option>
											<option value="9">Canceled Reversal</option>
											<option value="13">Chargeback</option>
											<option value="5">Complete</option>
											<option value="8">Denied</option>
											<option value="14">Expired</option>
											<option value="10">Failed</option>
											<option value="1">Pending</option>
											<option value="15">Processed</option>
											<option value="2">Processing</option>
											<option value="11">Refunded</option>
											<option value="12">Reversed</option>
											<option value="3">Shipped</option>
											<option value="16">Voided</option>
										</select>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="form-group">
										<label class="control-label" for="input-status">Paid Status :</label> <select name="filter_paid_status" id="input-status" class="form-control">
											<option value="0" selected="selected">No</option>
											<option value="1">Yes</option>
										</select>
									</div>
									<button type="button" id="button-filter" class="btn btn-mini btn-primary pull-right">
										<i class="fa fa-search"></i> Filter
									</button>
								</div>
							</div>
						</div>

					</form>
				</div>

				<div class="panel panel-default">
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<td class="text-right">Order ID</td>
									<td class="text-left">Product Name</td>
									<td class="text-left">Date Added</td>
									<td class="text-left">Status</td>
									<td class="text-right">Unit Price (USD)</td>
									<td class="text-right">Quantity</td>
									<td class="text-right">Total (USD)</td>
									<td class="text-right">Commission (USD)</td>
									<td class="text-right">Net Amount (USD)</td>
									<td class="text-left">Paid</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="text-center" colspan="10">No results!</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 text-left"></div>
					<div class="col-sm-6 text-right">Showing 0 to 0 of 0 (0 Pages)</div>
				</div>
			</div>
		</div>
	</div>


	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="fa fa-history"></i> Latest 10 Received Payment History
				</h3>
			</div>
			<div class="panel-body">
				<form method="post" enctype="multipart/form-data" target="_blank" id="form-history">
					<div class="panel panel-default" id="history">
						<div class="table-responsive">
							<table table class="table table-bordered table-hover">
								<thead>
									<tr>
										<td>Vendor Name</td>
										<td>Order Products [Order ID - Product Name]</td>
										<td>Payment Type</td>
										<td>Payment Amount (USD)</td>
										<td>Payment Date</td>
									</tr>
								</thead>
								<tbody>
								<tbody id="history_33">
									<tr>
										<td class="text-left">Apple Pte Ltd</td>
										<td class="text-left">[39 - Apple Cinema 30&quot;]</td>
										<td class="text-left">Paypal Standard</td>
										<td class="text-right">-$224.70</td>
										<td class="text-left">2015-02-28</td>
									</tr>
								</tbody>
								<tbody id="history_29">
									<tr>
										<td class="text-left">Apple Pte Ltd</td>
										<td class="text-left">[37 - iPhone]</td>
										<td class="text-left">Paypal Standard</td>
										<td class="text-right">-$77.00</td>
										<td class="text-left">2015-02-22</td>
									</tr>
								</tbody>
								<tbody id="history_28">
									<tr>
										<td class="text-left">Apple Pte Ltd</td>
										<td class="text-left">[35 - Apple Cinema 30&quot;]</td>
										<td class="text-left">Paypal Standard</td>
										<td class="text-right">-$224.70</td>
										<td class="text-left">2015-02-15</td>
									</tr>
								</tbody>
								<tbody id="history_26">
									<tr>
										<td class="text-left">Apple Pte Ltd</td>
										<td class="text-left">[24 - iPhone]</td>
										<td class="text-left">Paypal Standard</td>
										<td class="text-right">-$140.00</td>
										<td class="text-left">2015-02-14</td>
									</tr>
								</tbody>
								<tbody id="history_19">
									<tr>
										<td class="text-left">Apple Pte Ltd</td>
										<td class="text-left">[27 - iPhone]</td>
										<td class="text-left">Paypal Standard</td>
										<td class="text-right">-$70.00</td>
										<td class="text-left">2015-02-06</td>
									</tr>
								</tbody>
								<tbody id="history_18">
									<tr>
										<td class="text-left">Apple Pte Ltd</td>
										<td class="text-left">[25 - Apple Cinema 30&quot;]</td>
										<td class="text-left">Paypal Standard</td>
										<td class="text-right">-$224.70</td>
										<td class="text-left">2015-02-06</td>
									</tr>
								</tbody>
								<tbody id="history_14">
									<tr>
										<td class="text-left">Apple Pte Ltd</td>
										<td class="text-left">[15 - iPhone]</td>
										<td class="text-left">Paypal Standard</td>
										<td class="text-right">-$95.00</td>
										<td class="text-left">2015-01-20</td>
									</tr>
								</tbody>
								<tbody id="history_13">
									<tr>
										<td class="text-left">Apple Pte Ltd</td>
										<td class="text-left">[11 - iPhone]</td>
										<td class="text-left">Paypal Standard</td>
										<td class="text-right">-$95.00</td>
										<td class="text-left">2015-01-15</td>
									</tr>
								</tbody>
								<tbody id="history_11">
									<tr>
										<td class="text-left">Apple Pte Ltd</td>
										<td class="text-left">[11 - Apple Cinema 30&quot;]</td>
										<td class="text-left">Paypal Standard</td>
										<td class="text-right">-$95.00</td>
										<td class="text-left">2015-01-13</td>
									</tr>
								</tbody>
								<tbody id="history_10">
									<tr>
										<td class="text-left">Apple Pte Ltd</td>
										<td class="text-left">[2 - iPhone]</td>
										<td class="text-left">Paypal Standard</td>
										<td class="text-right">-$95.00</td>
										<td class="text-left">2015-01-08</td>
									</tr>
								</tbody>
								</tbody>
							</table>
						</div>
					</div>
			</div>
			</form>
		</div>
	</div>

</div>




