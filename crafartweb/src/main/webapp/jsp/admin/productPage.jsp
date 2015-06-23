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
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Product Page</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/uploadProducts">Add</a>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Product List
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-model">Product Name</label> <span class="col-sm-2"> <input type="text" name="productname" value="" placeholder="productname"
									id="productname" class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-startprice">Start Price</label> <span class="col-sm-2"> <input type="text" name="startprice" value="" placeholder="startprice"
									id="startprice" class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-endprice">End Price</label> <span class="col-sm-2"> <input type="text" name="endprice" value="" placeholder="endprice" id="endprice"
									class="form-control" />
								</span>
							</div>
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-model">Model</label> <span class="col-sm-2"> <input type="text" name="model" value="" placeholder="model" id="model"
									class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-quantity">Quantity</label> <span class="col-sm-2"> <input type="text" name="quantity" value="" placeholder="quantity" id="quantity"
									class="form-control" />
								</span> <label class="col-sm-2 control-label" for="input-status">Status</label> <span class="col-sm-2"> <select name="status" id="input-status" placeholder="---please select---"
									class="form-control">
										<option value="1" selected="selected">Enable</option>
										<option value="0">Disable</option>
								</select>
								</span>
							</div>
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-sellername">Seller Name</label> <span class="col-sm-2"> <input type="text" name="sellername" value="" placeholder="sellername"
									id="sellername" class="form-control" />
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
								<td>Seller Name</td>
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
								<td>ABG murah</td>
								<td>150.00</td>
								<td>1</td>
								<td>Enable</td>
								<td><a class="btn btn-warning" href="${baseURL}/menu/editProduct">Edit</a></td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>Apple Cinema 30"</td>
								<td>n Product 15</td>
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
								<td>Black Cotton Kurti</td>
								<td>12312</td>
								<td>123123.0000</td>
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
<script type="text/javascript">
	setPage("productPageMenuId");
</script>