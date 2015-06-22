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
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Add Return Page</h1>
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
					<i class="icon-th-list"></i> &nbsp; Add Return Page
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
								<li class="active" id="tabGeneral"><a data-toggle="tab" href="#tab-general">General</a></li>
							</ul>

							<!-- General tab-data-->
							<div class="tab-pane fade in active " id="tab-general">
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">Order ID</label>
									<div class="col-sm-10">
										<input type="text" name="orderid" value="" placeholder="orderid" id="orderid" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">Order Date</label>
									<div class="col-sm-10">
										<input type="text" name="orderdate" value="" placeholder="orderdate" id="orderDate" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">First Name </label>
									<div class="col-sm-10">
										<input type="text" name="firstname" value="" placeholder="firstname" id="input-firstname" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">Last Name </label>
									<div class="col-sm-10">
										<input type="text" name="lastname" value="" placeholder="lastname" id="input-lastname" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">Email</label>
									<div class="col-sm-10">
										<input type="text" name="email" value="" placeholder="email" id="input-email" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">TelePhone</label>
									<div class="col-sm-10">
										<input type="text" name="telephone" value="" placeholder="telephone" id="input-telephone" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">Mobile Phone</label>
									<div class="col-sm-10">
										<input type="text" name="mobilephone" value="" placeholder="mobilephone" id="input-mobilephone" class="form-control" />
									</div>
								</div>
								<div class="col-md-4">
							<span><b><h4>Product Information & Reason for Return</h4></b></span>
							</div>
							<hr>
								<div class="form-group required col-md-10" style="margin-top:10px">
									<label class="col-sm-2 control-label">Product Name</label>
									<div class="col-sm-10">
										<input type="text" name="productname" placeholder="productname" id="productname" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">Model Name</label>
									<div class="col-sm-10">
										<input type="text" name="modelname" placeholder="modelname" id="modelname" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">Quantity</label>
									<div class="col-sm-10">
										<input type="text" name="quantity" placeholder="quantity" id="quantity" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
								<label class="col-sm-2 control-label">Return Reason</label> <span class="col-sm-10"> <select name="returnreason" id="returnreason" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">select</option>
										<option value="2">Dead on Arrival</option>
										<option value="3">Order Error</option>
								</select></span>
								</div>
								<div class="form-group required col-md-10">
								</span> <label class="col-sm-2 control-label">Opened</label> <span class="col-sm-10"> <select name="opened" id="opened" placeholder="---please select---" class="form-control">
										<option value="0"></option>
										<option value="1" selected="selected">Opened</option>
										<option value="2">Unopened</option>
								</select>
								</span> 
								</div>
								<div class="form-group required col-md-10">
								<label class="col-sm-2 control-label" for="input-meta-description1">Comment</label>
								<div class="col-sm-10">
									<textarea name="command" rows="5" placeholder="comment" id="metaDescription" class="form-control"></textarea>
								</div>
								</div>
								<div class="form-group required col-md-10">
								<label class="col-sm-2 control-label">Return Action</label> <span class="col-sm-10"> <select name="returnaction" id="returnaction" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">Credit Issued</option>
										<option value="2">Refunded</option>
										<option value="3">Replacement Sent</option>
								</select>
								</span> 
								</div>
								<div class="form-group required col-md-10">
								<label class="col-sm-2 control-label">Return Status</label> <span class="col-sm-10"> <select name="returnstatus" id="returnstatus" placeholder="---please select---" class="form-control">
										<option value="0"></option>
										<option value="1" selected="selected">Awaiting Products</option>
										<option value="2">Pending</option>
										<option value="3">Complete</option>
								</select>
								</span>
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
		$("#orderDate").datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$('#orderDate').on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$('#orderDate').datepicker('hide');
			}
		})
		
	});
</script>
