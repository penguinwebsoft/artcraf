<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<script>
	$(document).ready(function() {
		$('#dataTables-example').dataTable();
	});
</script>

<script type="text/javascript">
	setPage("purchaseMenuId");
</script>

<div class="inner">
	<div class="row" style="padding-left: 15px;">
		<div class="col-sm-5">
			<h1 style="color: #333; font-size: 25px;">&nbsp; Products Purchased Report</h1>
		</div>
	</div>
	<hr />

	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="fa fa-list"></i> Products Purchased List
				</h3>
			</div>

			<div class="panel-body">
				<div class="well">
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label class="control-label" for="input-date-start">Date Start</label>
								<div class="input-group ">
								<input type="text" name="filter_date_start" class="form-control" placeholder="Date Start :" value="" data-date-format="mm/dd/yyyy" id="dp2">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="input-date-end">Date End</label>
								<div class="input-group">
									<input type="text" name="filter_date_end" class="form-control" placeholder="Date End:" value="" data-date-format="mm/dd/yyyy" id="dp3">
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label class="control-label" for="input-status">Order Status</label> <select name="filter_order_status_id" id="input-status" class="form-control">
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
							<button type="button" id="button-filter" class="btn btn-primary pull-right">
								<i class="fa fa-search"></i> Filter
							</button>
						</div>
					</div>
				</div>
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<td class="text-left">Product Name</td>
								<td class="text-left">Model</td>
								<td class="text-right">Quantity</td>
								<td class="text-right">Total</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-left">iPhone</td>
								<td class="text-left">product 11</td>
								<td class="text-right">12</td>
								<td class="text-right">$1,630.00</td>
							</tr>
							<tr>
								<td class="text-left">Apple Cinema 30&quot;</td>
								<td class="text-left">n Product 15</td>
								<td class="text-right">5</td>
								<td class="text-right">$1,384.00</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-sm-6 text-left"></div>
					<div class="col-sm-6 text-right">Showing 1 to 2 of 2 (1 Pages)</div>
				</div>
			</div>
		</div>
	</div>
</div>







