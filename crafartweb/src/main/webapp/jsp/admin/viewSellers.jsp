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
								<label class="col-sm-2 control-label" for="input-productname"><span data-toggle="tooltip" title="Force a minimum ordered amount">Product Name</span></label> <span class="col-sm-2"> <input
									type="text" name="productname" value="" placeholder="productname" id="productname" class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-model"><span data-toggle="tooltip" title="Force a minimum ordered amount">Model</span></label> <span class="col-sm-2"> <input
									type="text" name="model" value="" placeholder="model" id="model" class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-status">Status</label> <span class="col-sm-2"> <select name="status" id="status" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">1</option>
										<option value="2">2</option>
								</select>
								</span>
							</div>
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-ventorname">Ventor Name</label> <span class="col-sm-2"> <select name="ventorname" id="input-ventorname"
									placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">Admin</option>
										<option value="0">Admin1</option>
								</select>
								</span> <label class="col-sm-2 control-label" for="input-price"><span data-toggle="tooltip" title="Force a minimum ordered amount">Price</span></label> <span class="col-sm-2"> <input
									type="text" name="price" value="" placeholder="price" id="price" class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-sku"><span data-toggle="tooltip" title="Force a minimum ordered amount">Sku</span></label> <span class="col-sm-2"> <input type="text"
									name="sku" value="" placeholder="sku" id="sku" class="form-control" />
								</span>
							</div>
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-quantity"><span data-toggle="tooltip" title="Force a minimum ordered amount">Quantity</span></label> <span class="col-sm-2"> <input
									type="text" name="quantity" value="" placeholder="quantity" id="quantity" class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-status">Export</label> <span class="col-sm-2"> <select name="status" id="input-status" placeholder="---please select---"
									class="form-control">
										<option value="1" selected="selected">Export to Excel</option>
										<option value="0">Export to pdf</option>
								</select>
								</span>
								<div>
									<button type="button" class="btn btn-success col-md-offset-11">Export</button>
									<button type="button" class="btn btn-primary col-md-offset-11" style="margin-top: 5px">Filter</button>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Table Section-->
	<div class="container" style="background-color: white;">
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