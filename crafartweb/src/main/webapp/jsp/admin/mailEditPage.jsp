<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Edit Mail Page</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" class="btn btn-success">Send</button>
				<button type="button" class="btn">Cancel</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp;Edit Mail Page
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-status">From</label>
								<div class="col-sm-10">
									<select name="from" id="from" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">Default</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-status">To</label>
								<div class="col-sm-10">
									<select name="input-to" id="input-to" placeholder="---please select---" class="form-control">
										<option value="2"  selected="selected">Customer</option>
										<option value="0">All Newsletters Subscribers</option>
										<option value="1">All customers</option>
										<option value="3">All sellers</option>
										<option value="4">Seller</option>
										
									</select>
								</div>
							</div>
							<div class="form-group required toCustomers" id="to-2">
								<label class="col-sm-2 control-label">Customer</label>
								<div class="col-sm-10">
									<input type="text" name="customer" value="" placeholder="customer" id="customerVisible" class="form-control" aria-hidden="false" />
									<textarea id="customer" class="form-control"></textarea>
								</div>
							</div>
							<div class="form-group required toSellers" id="to-4">
								<label class="col-sm-2 control-label">Sellers</label>
								<div class="col-sm-10">
									<input type="text" name="sellers" value="" placeholder="sellers" id="sellersVisible" class="form-control" aria-hidden="false" />
									<textarea id="customer" class="form-control"></textarea>
								</div>
							</div>

							<div class="form-group required">
								<label class="col-sm-2 control-label">Subject</label>
								<div class="col-sm-10">
									<input type="text" name="subject" value="" placeholder="subject" id="subject" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Message</label>
								<div class="col-lg-10">
									<div class="box">
										<div id="cleditorDiv" class="body collapse in">
											<form>
												<textarea id="cleditor" class="form-control"></textarea>
												<div class="form-actions no-margin-bottom" id="cleditorForm">
													<br />
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-status">Status</label>
								<div class="col-sm-10">
									<select name="input-to" id="status" placeholder="---please select---" class="form-control">
										<option value="0" selected="selected">Enable</option>
										<option value="1">Disable</option>
									</select>
								</div>
							</div>
							
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	setPage("mailPageMenuId");

	$('#input-to').on('change', function() {
		var toType = this.value;
		if (toType == 2) {
			$('.toCustomers').show();
		} else {
			$('.toCustomers').hide();
		}

	});
	
	$('#input-to').on('change', function() {
		var toType = this.value;
		if (toType == 4) {
			$('.toSellers').show();
		} else {
			$('.toSellers').hide();
		}
	});
	
	$(document).ready(function() {
		$("#cleditor").cleditor();


		//$('select[name=input-to]').trigger('change');
	});

	
</script>