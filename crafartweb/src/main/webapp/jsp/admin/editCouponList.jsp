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
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Edit Coupon Page</h1>
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
					<i class="icon-th-list"></i> &nbsp; Edit Coupon Page
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
								<li class="active" id="tabGeneral"><a data-toggle="tab" href="#tab-general">General</a></li>
								<li id="tabHistory"><a data-toggle="tab" href="#tab-history">History</a></li>
							</ul>
							<div class="tab-content">
								<!-- General tab-data-->
								<div class="tab-pane fade in active" id="tab-general">
									<div class="form-group required">
										<label class="col-sm-2 control-label">Product Name</label>
										<div class="col-sm-10">
											<input type="text" name="productname" value="" placeholder="productname" id="productname" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label">Discount Code</label>
										<div class="col-sm-10">
											<input type="number" name="discountcode" value="" placeholder="discountcode" id="discountcode" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label">Discount Type</label>
										<div class="col-sm-10">
											<input type="text" name="discounttype" value="" placeholder="discounttype" id="discountype" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label">Discount Value</label>
										<div class="col-sm-10">
											<input type="number" name="discountvalue" value="" placeholder="discountvalue" id="discountvalue" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label">Uses Per Coupon</label>
										<div class="col-sm-10">
											<input type="text" name="usespercoupon" value="" placeholder="usespercoupon" id="usespercoupon" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label">Uses Per Customer</label>
										<div class="col-sm-10">
											<input type="text" name="usespercustomer" value="" placeholder="usespercustomer" id="usespercustomer" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-datestart"><span data-toggle="tooltip" title="Force a minimum ordered amount">Date Start</span></label> <span class="col-sm-2"> <input
											type="text" name="datestart" value="" placeholder="datestart" id="dateStart" class="form-control" />
										</span>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-dateend"><span data-toggle="tooltip" title="Force a minimum ordered amount">Date End</span></label> <span class="col-sm-2"> <input
											type="text" name="dateend" value="" placeholder="dateend" id="dateEnd" class="form-control" />
										</span>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">Status</label>
										<div class="col-sm-10">
											<select name="status" id="input-status" placeholder="---please select---" class="form-control">
												<option value="1" selected="selected">Enable</option>
												<option value="0">Disable</option>
											</select>
										</div>
									</div>
								</div>
								<!-- History Data -->
								<div class="tab-pane fade" id="tab-history">
									<div class="container">
										<div class="tab-pane" id="tab-history">
											<div class="table-responsive">
												<table id="history" class="table table-striped table-bordered table-hover pull-left">
													<thead>
														<tr>
															<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
															<td>Order Id</td>
															<td>Customer Name</td>
															<td>Discount Code</td>
															<td>Amount</td>
															<td>Date Added</td>
														</tr>
													</thead>
												</table>
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
