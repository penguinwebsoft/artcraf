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
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Return Page</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/addReturnPage">Add</a>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Return Page
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group required">
								<label class="col-sm-2 control-label">Return ID</label> <span class="col-sm-2"> <input type="text" name="returnid" value="" placeholder="returnid" id="returnid" class="form-control" />
								</span> <label class="col-sm-2 control-label">Customer Name</label> <span class="col-sm-2"> <input type="text" name="customername" value="" placeholder="customername" id="input-orderid"
									class="form-control" />
								</span> <label class="col-sm-2 control-label">Model</label> <span class="col-sm-2"> <input type="text" name="model" value="" placeholder="model" id="model" class="form-control" />
								</span>

							</div>

							<div class="form-group required">
								<label class="col-sm-2 control-label">Order ID</label> <span class="col-sm-2"> <input type="text" name="orderid" value="" placeholder="orderrid" id="orderid" class="form-control" />
								</span> <label class="col-sm-2 control-label">Products</label> <span class="col-sm-2"> <input type="text" name="products" value="" placeholder="products" id="products" class="form-control" />
								</span> <label class="col-sm-2 control-label">Return Status</label> <span class="col-sm-2"> <select name="returnstatus" id="returnstatus" placeholder="---please select---" class="form-control">
										<option value="0"></option>
										<option value="1" selected="selected">Awaiting Products</option>
										<option value="2">Pending</option>
										<option value="3">Complete</option>
								</select>
								</span>
							</div>
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-dateadded"><span data-toggle="tooltip" title="Force a minimum ordered amount">Date Added</span></label> <span
									class="col-sm-2"> <input type="dateadded" name="dateadded" value="" placeholder="dateadded" id="dateAdded" class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-datemodified" style="margin-left: 10px"><span data-toggle="tooltip" title="Force a minimum ordered amount">Date Modified</span></label> <span
									class="col-sm-2" style="margin-left:-9px"> <input type="datemodified" name="datemodified" value="" placeholder="datemodified" id="dateModified" class="form-control" />
								</span>
							</div>
							<div class="form-group required">
								<div>
									<label class="col-sm-2 control-label" for="input-status">Export</label> <span class="col-sm-2"> <select name="status" id="input-status" placeholder="---please select---"
										class="form-control">
											<option value="1" selected="selected">Export to Excel</option>
											<option value="0">Export to pdf</option>
									</select>
									</span>
								</div>

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
								<td>Return Id</td>
								<td>Order Id</td>
								<td>Customer Name</td>
								<td>Product</td>
								<td>Model</td>
								<td>Status</td>
								<td>Date Added</td>
								<td>Date Modified</td>
								<td>Action</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td>1</td>
								<td>1</td>
								<td>raj</td>
								<td>painting</td>
								<td>god pic</td>
								<td>received</td>
								<td></td>
								<td></td>
								<td><a class="btn btn-warning" href="${baseURL}/menu/editReturnPage">Edit</a></td>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	setPage("returnPageMenuId");
	$(document).ready(function() {
		$("#dateAdded").datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$('#dateAdded').on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$('#dateAdded').datepicker('hide');
			}
		})

		$("#dateModified").datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$('#dateModified').on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$('#dateModified').datepicker('hide');
			}
		})

	});
</script>

