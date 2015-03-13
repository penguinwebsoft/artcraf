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
	setPage("MyOrdersMenuId");
</script>

<div class="inner">
	<div class="row">
		<div class="col-lg-3">
			<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Orders</h1>
		</div>
		<div class="pull-right" style="padding: 25px;">

			<button type="submit" id="button-invoice" form="form-order" formaction="#" data-toggle="tooltip" title="Print Invoice" class="btn btn-info">
				<i class="icon-print"></i>
			</button>
			<button type="submit" id="printPackingListBtnId" form="form-order" formaction="#" data-toggle="tooltip" title="Print packing List" class="btn btn-info">
				<i class="icon-truck"></i>
			</button>

		</div>
	</div>
	<hr />

	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Orders List
				</h3>
			</div>
			<div class="panel-body">
				<div class="well">

					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label class="control-label" for="input-order-id">Order ID</label> <input type="text" name="filter_order_id" value="" placeholder="Order ID" id="input-order-id" class="form-control" />
							</div>
							<div class="form-group">
								<label class="control-label" for="input-customer">Customer</label> <input type="text" name="filter_customer" value="" placeholder="Customer" id="input-customer" class="form-control" />
							</div>
						</div>

						<div class="col-sm-4">

							<div class="form-group">
								<label class="control-label" for="input-order-status">Order Status</label> <select name="filter_order_status" id="input-order-status" class="form-control">
									<option value="*"></option>
									<option value="0">Missing Orders</option>
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
							<div class="form-group">
								<label class="control-label" for="input-total">Total</label> <input type="text" name="filter_total" value="" placeholder="Total" id="input-total" class="form-control" />
							</div>
						</div>

						<div class="col-sm-4">

							<div class="form-group">
								<label class="control-label" for="input-date-added">Date Added</label>
								<div class="input-group date">
									<input type="text" class="form-control" placeholder="15/02/2015" placeholder="Date Added" value="" data-date-format="mm/dd/yyyy" id="dp2" " name="filter_date_added">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="input-date-modified">Date Modified</label>
								<div class="input-group date">
									<input type="text" class="form-control" placeholder="20/02/2015" placeholder="Date Modified" value="" data-date-format="mm/dd/yyyy" id="dp3" " name="filter_date_modified">
								</div>
							</div>

							<button type="button" id="button-filter" class="btn btn-primary pull-right">
								<i class="icon-search"></i> Filter
							</button>
						</div>

					</div>
				</div>

				<br>

				<form id="form-product" enctype="multipart/form-data" method="post" action="#">

					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover" id="dataTables-example">
							<thead>
								<tr>
									<td style="width: 1px;" class="text-center"><input type="checkbox" onclick="$('input[name*=\'selected\']').prop('checked', this.checked);" /></td>
									<td class="text-right">Order ID</td>
									<td class="text-left">Customer</td>
									<td class="text-left">Status</td>
									<td class="text-right">Total</td>
									<td class="text-left">Date Added</td>
									<td class="text-left">Date Modified</td>
									<td class="text-right">Action</td>
								</tr>
							</thead>
							<tbody>

								<tr>
									<td class="text-center"><input type="checkbox" name="selected[]" value="39" /> <input type="hidden" name="shipping_code[]" value="flat.flat" /></td>
									<td class="text-right">39</td>
									<td class="text-left">123 123</td>
									<td class="text-left">Shipped</td>
									<td class="text-right">$321.00</td>
									<td class="text-left">26/02/2015</td>
									<td class="text-left">02/03/2015</td>
									<td class="text-right"><a href="${baseURL}/menu/orderDetails.html" data-toggle="tooltip" title="View" class="btn btn-primary"> <i class="icon-pencil icon-white"></i>Edit
									</a></td>
								</tr>

								<tr>
									<td class="text-center"><input type="checkbox" name="selected[]" value="37" /> <input type="hidden" name="shipping_code[]" value="" /></td>
									<td class="text-right">37</td>
									<td class="text-left">fdvasvsd casdfasdf</td>
									<td class="text-left">Complete</td>
									<td class="text-right">$110.00</td>
									<td class="text-left">19/02/2015</td>
									<td class="text-left">19/02/2015</td>
									<td class="text-right"><a href="" data-toggle="tooltip" title="View" class="btn btn-primary"> <i class="icon-pencil icon-white"></i>Edit 
								</tr>
								<tr>
									<td class="text-center"><input type="checkbox" name="selected[]" value="35" /> <input type="hidden" name="shipping_code[]" value="flat.flat" /></td>
									<td class="text-right">35</td>
									<td class="text-left">Max Maximus</td>
									<td class="text-left">Shipped</td>
									<td class="text-right">$321.00</td>
									<td class="text-left">15/02/2015</td>
									<td class="text-left">15/02/2015</td>
									<td class="text-right"><a href="" data-toggle="tooltip" title="View" class="btn btn-primary"> <i class="icon-pencil icon-white"></i>Edit 
								</tr>
								<tr>
									<td class="text-center"><input type="checkbox" name="selected[]" value="27" /> <input type="hidden" name="shipping_code[]" value="flat.flat" /></td>
									<td class="text-right">27</td>
									<td class="text-left">vijay gupta</td>
									<td class="text-left">Processed</td>
									<td class="text-right">$100.00</td>
									<td class="text-left">06/02/2015</td>
									<td class="text-left">08/02/2015</td>
									<td class="text-right"><a href="" data-toggle="tooltip" title="View" class="btn btn-primary"> <i class="icon-pencil icon-white"></i>Edit 
								</tr>

								<tr>
									<td class="text-center"><input type="checkbox" name="selected[]" value="25" /> <input type="hidden" name="shipping_code[]" value="flat.flat" /></td>
									<td class="text-right">25</td>
									<td class="text-left">dfgdf sdfgsdf</td>
									<td class="text-left">Complete</td>
									<td class="text-right">$321.00</td>
									<td class="text-left">06/02/2015</td>
									<td class="text-left">06/02/2015</td>
									<td class="text-right"><a href="" data-toggle="tooltip" title="View" class="btn btn-primary"> <i class="icon-pencil icon-white"></i>Edit
									</a></td>
								</tr>
								<tr>
									<td class="text-center"><input type="checkbox" name="selected[]" value="24" /> <input type="hidden" name="shipping_code[]" value="flat.flat" /></td>
									<td class="text-right">24</td>
									<td class="text-left">Alex Luah</td>
									<td class="text-left">Pending</td>
									<td class="text-right">$200.00</td>
									<td class="text-left">02/02/2015</td>
									<td class="text-left">02/02/2015</td>
									<td class="text-right"><a href="" data-toggle="tooltip" title="View" class="btn btn-primary"> <i class="icon-pencil icon-white"></i>Edit
									</a></td>
								</tr>
								<tr>
									<td class="text-center"><input type="checkbox" name="selected[]" value="20" /> <input type="hidden" name="shipping_code[]" value="flat.flat" /></td>
									<td class="text-right">20</td>
									<td class="text-left">Alex Luah</td>
									<td class="text-left"></td>
									<td class="text-right">$200.00</td>
									<td class="text-left">22/01/2015</td>
									<td class="text-left">22/01/2015</td>
									<td class="text-right"><a href="" data-toggle="tooltip" title="View" class="btn btn-primary"> <i class="icon-pencil icon-white"></i>Edit
									</a></td>
								</tr>
								<tr>
									<td class="text-center"><input type="checkbox" name="selected[]" value="15" /> <input type="hidden" name="shipping_code[]" value="flat.flat" /></td>
									<td class="text-right">15</td>
									<td class="text-left">Ahmad Afiq Salehin Ahmad Supiee</td>
									<td class="text-left">Complete</td>
									<td class="text-right">$100.00</td>
									<td class="text-left">17/01/2015</td>
									<td class="text-left">17/01/2015</td>
									<td class="text-right"><a href="" data-toggle="tooltip" title="View" class="btn btn-primary"> <i class="icon-pencil icon-white"></i>Edit
									</a></td>
								</tr>
								<tr>
									<td class="text-center"><input type="checkbox" name="selected[]" value="14" /> <input type="hidden" name="shipping_code[]" value="mvweight.mvweight" /></td>
									<td class="text-right">14</td>
									<td class="text-left">aaa aaa</td>
									<td class="text-left"></td>
									<td class="text-right">$100.00</td>
									<td class="text-left">14/01/2015</td>
									<td class="text-left">14/01/2015</td>
									<td class="text-right"><a href="" data-toggle="tooltip" title="View" class="btn btn-primary"> <i class="icon-pencil icon-white"></i>Edit
									</a></td>
								</tr>
								<tr>
									<td class="text-center"><input type="checkbox" name="selected[]" value="13" /> <input type="hidden" name="shipping_code[]" value="mvdm_flat.mvdm_flat1" /></td>
									<td class="text-right">13</td>
									<td class="text-left">aaa aaa</td>
									<td class="text-left"></td>
									<td class="text-right">$110.00</td>
									<td class="text-left">14/01/2015</td>
									<td class="text-left">14/01/2015</td>
									<td class="text-right"><a href="" data-toggle="tooltip" title="View" class="btn btn-primary"> <i class="icon-pencil icon-white"></i>Edit
									</a></td>
								</tr>
								
							</tbody>
						</table>
					</div>
				</form>
				<div class="row">
					<div class="col-sm-6 text-left"></div>
					<div class="col-sm-6 text-right"></div>
				</div>
			</div>
		</div>
	</div>
</div>
