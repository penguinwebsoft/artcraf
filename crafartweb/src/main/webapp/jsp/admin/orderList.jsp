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
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Order List Page</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/addOrderList">Add</a>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Order List
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-model">Order Id</label> <span class="col-sm-2"> <input type="text" name="orderid" value="" placeholder="orderid" id="input-orderid"
									class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-status">Order Status</label> <span class="col-sm-2"> <select name="status" id="input-status" placeholder="---please select---"
									class="form-control">
										<option value="1" selected="selected">1</option>
										<option value="0">2</option>
								</select>
								</span> <label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-customer"><span data-toggle="tooltip" title="customer">Customer Name</span></label> <span class="col-sm-2"> <input
									type="text" name="customer" value="" placeholder="customer" id="input-customer" class="form-control" />
								</span>
							</div>
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-total"><span data-toggle="tooltip" title="Force a minimum ordered amount">Total</span></label> <span class="col-sm-2"> <input
									type="text" name="total" value="" placeholder="Rs" id="input-total" class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-datestart"><span data-toggle="tooltip" title="Force a minimum ordered amount">Date Start</span></label> <span class="col-sm-2"> <input
									type="text" name="datestart" value="" placeholder="datestart" id="dateStart" class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-dateend"><span data-toggle="tooltip" title="Force a minimum ordered amount">Date End</span></label> <span class="col-sm-2"> <input
									type="text" name="dateend" value="" placeholder="dateend" id="dateEnd" class="form-control" />
								</span>
							</div>
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-status">Export</label> <span class="col-sm-2"> <select name="status" id="input-status" placeholder="---please select---"
									class="form-control">
										<option value="1" selected="selected">Export to Excel</option>
										<option value="0">Export to pdf</option>
								</select>
								</span>

							</div>
							<div>
								<button type="button" class="btn btn-success col-md-offset-11">Export</button>
								<button type="button" class="btn btn-primary col-md-offset-11" style="margin-top: 5px">Filter</button>
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
								<td>Customer Name</td>
								<td>Seller Name</td>
								<td>Status</td>
								<td>Total</td>
								<td>Date Added</td>
								<td>Date Modified</td>
								<td>Action</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td>1</td>
								<td>ABG murah</td>
								<td>ABG murah</td>
								<td>Pending</td>
								<td>1000</td>
								<td>05/05/2015</td>
								<td>05/05/2015</td>
								<td><a class="btn btn-warning" href="${baseURL}/menu/viewOrderList">View</a> <a class="btn btn-warning" href="${baseURL}/menu/editOrderList">Edit</a>
									<button type="button" class="btn btn-danger">Delete</button></td>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	setPage("orderListMenuId");
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

