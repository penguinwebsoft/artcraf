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
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Transaction Page</h1>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Transaction List
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<div class="container">
								<div class="tab-pane" id="tab-shipping">
									<div class="table-responsive">
										<table id="shipping" class="table table-striped table-bordered table-hover pull-left">
											<thead>
												<tr>
													<td>Revenue</td>
													<td>Commission</td>
													<td>Balance</td>
													<td>Shipping</td>
													<td>Coupon</td>
													<td>NetBalance</td>
												</tr>
											</thead>
										</table>
									</div>
								</div>
							</div>
							<!-- Start tab-data-->
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-datestart"><span data-toggle="tooltip" title="Force a minimum ordered amount">Date Start</span></label> <span class="col-sm-2"> <input
									type="text" name="datestart" value="" placeholder="datestart" id="dateStart" class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-dateend"><span data-toggle="tooltip" title="Force a minimum ordered amount">Date End</span></label> <span class="col-sm-2"> <input
									type="text" name="dateend" value="" placeholder="dateend" id="dateEnd" class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-groupby">Group BY</label> <span class="col-sm-2"> <select name="groupby" id="groupby" placeholder="---please select---"
									class="form-control">
										<option value="1" selected="selected">Days</option>
										<option value="2">Weeks</option>
										<option value="3">Month</option>
										<option value="4">Years</option>
								</select>
								</span>
							</div>
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-status">Order Status</label> <span class="col-sm-2"> <select name="status" id="input-status" placeholder="---please select---"
									class="form-control">
										<option value="1" selected="selected">Completed</option>
										<option value="0">Pending</option>
								</select>
								</span> <label class="col-sm-2 control-label">Paid Status</label> <span class="col-sm-2"> <select name="paidstatus" id="paidstatus" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">Yes</option>
										<option value="2">No</option>
								</select>
								</span> <label class="col-sm-2 control-label">Exports</label> <span class="col-sm-2"> <select name="exports" id="exports" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">Export to Excel</option>
										<option value="2">Export to Pdf</option>
								</select>
								</span>
							</div>
							<div class="col-md-offset-10">
								<button type="button" class="btn btn-success">Export</button>
								<button type="button" class="btn btn-primary">Filter</button>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Table Section-->
	<div class="container-fluid" style="background-color: white;">
		<div class="container">
			<div class="tab-pane" id="tab-shipping">
				<div class="table-responsive">
					<table id="shipping" class="table table-striped table-bordered table-hover pull-left">
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td>Order Id</td>
								<td>Product Name</td>
								<td>Date Added</td>
								<td>Status</td>
								<td>Unit Price</td>
								<td>VAT</td>
								<td>GST</td>
								<td>CST</td>
								<td>Total Tax</td>
								<td>Quantity</td>
								<td>Total</td>
								<td>Commission</td>
								<td>NetAmount</td>
								<td>Paid</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td>1</td>
								<td>test21</td>
								<td>2/2/12</td>
								<td>Pending</td>
								<td>2000</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>2</td>
								<td>4000</td>
								<td>100</td>
								<td>20</td>
								<td><button type="button" class="btn btn-warning">PayNow</button></td>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
setPage("transactionPageMenuId");
	$(document).ready(function() {
		$("#dateStart").datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$('#dateStart').on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$('#dateStart').datepicker('hide');
			}
		})

		$("#dateEnd").datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$('#dateEnd').on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$('#dateEnd').datepicker('hide');
			}
		})
	});
</script>
<script type="text/javascript">
	
</script>