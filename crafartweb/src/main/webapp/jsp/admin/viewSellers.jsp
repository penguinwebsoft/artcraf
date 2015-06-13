<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; View Sellers</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" class="btn btn-success">Save</button>
				<button type="button" class="btn btn-Warning">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; View Seller
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-model">Product Name</label>
								<div class="col-sm-10">
									<input type="text" name="name" value="" placeholder="name" id="input-Name" class="form-control" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-sku"><span data-toggle="tooltip" title="companyname">Model</span></label>
								<div class="col-sm-10">
									<input type="text" name="model" value="" placeholder="model" id="input-model" class="form-control" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-status">Status</label>
								<div class="col-sm-10">
									<select name="status" id="input-status" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">1</option>
										<option value="0">2</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-status">Vendor Name</label>
								<div class="col-sm-10">
									<select name="name" id="input-name" placeholder="please select" class="form-control">
										<option value="1" selected="selected">admin</option>
										<option value="0">admin1</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Price</span></label>
								<div class="col-sm-10">
									<input type="number" name="price" value="" placeholder="price" id="input-price" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">SKU</span></label>
								<div class="col-sm-10">
									<input type="number" name="sku" value="" placeholder="sku" id="input-sku" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Quantity</span></label>
								<div class="col-sm-10">
									<input type="number" name="quantity" value="" placeholder="quantity" id="input-quantity" class="form-control" />
								</div>
							</div>
							<button type="button" class="btn btn-primary col-md-offset-6">
								<span class="glyphicon glyphicon glyphicon-search" aria-hidden="true">Filter</span>
							</button>
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
								<td>Image</td>
								<td>Product Name</td>
								<td>Vendor Name</td>
								<td>Sku</td>
								<td>Model</td>
								<td>Price</td>
								<td>Quantity</td>
								<td>Status</td>
								<td>Action</td>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

</div>