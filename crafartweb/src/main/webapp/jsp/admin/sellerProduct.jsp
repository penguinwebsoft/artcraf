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
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Seller Product Page</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/uploadProducts">Add</a>
				<button type="button" class="btn btn-Warning">Delete</button> 
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Seller Product List
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
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-price"><span data-toggle="tooltip" title="companyname">Price</span></label>
								<div class="col-sm-10">
									<input type="number" name="price" value="" placeholder="price" id="input-price" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-model"><span data-toggle="tooltip" title="Force a minimum ordered amount">Model</span></label>
								<div class="col-sm-10">
									<input type="text" name="model" value="" placeholder="model" id="input-model" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Quantity</span></label>
								<div class="col-sm-10">
									<input type="number" name="quantity" value="" placeholder="quantity" id="input-quantity" class="form-control" />
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
								<td>Model</td>
								<td>Price</td>
								<td>Quantity</td>
								<td>Status</td>
								<td>Action</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>ABG murah</td>
								<td>ABG murah</td>
								<td>150.00</td>
								<td>1</td>
								<td>Enable</td>
								<td>
									<button type="button" class="btn btn-warning">Edit</button>
								</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>Apple Cinema 30"</td>
								<td>n Product 15</td>
								<td>350.00</td>
								<td>99</td>
								<td>Enable</td>
								<td>
									<button type="button" class="btn btn-warning">Edit</button>
								</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>Apple Cinema 30"</td>
								<td>n Product 15</td>
								<td>350.00</td>
								<td>99</td>
								<td>Enable</td>
								<td>
									<button type="button" class="btn btn-warning">Edit</button>
										</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>Black Cotton Kurti</td>
								<td>12312</td>
								<td>123123.0000 </td>
								<td>1</td>
								<td>Enable</td>
								<td>
									<button type="button" class="btn btn-warning">Edit</button>
								</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>Calvin Klein Eternity</td>
								<td>dsss</td>
								<td>45.0000</td>
								<td>1</td>
								<td>Enable</td>
								<td>
									<button type="button" class="btn btn-warning">Edit</button>
								</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>iMac</td>
								<td>Product 14</td>
								<td>100.00</td>
								<td>100</td>
								<td>Enable</td>
								<td>
									<button type="button" class="btn btn-warning">Edit</button>
									</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>iPod Nano</td>
								<td>Product 9</td>
								<td>100.00</td>
								<td>100</td>
								<td>Enable</td>
								<td>
									<button type="button" class="btn btn-warning">Edit</button>
								</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>iPod Touch</td>
								<td>Product 19</td>
								<td>150.00</td>
								<td>100</td>
								<td>Enable</td>
								<td>
									<button type="button" class="btn btn-warning">Edit</button>
								</td>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

</div>