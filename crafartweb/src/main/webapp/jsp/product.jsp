<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<script>
	$(document).ready(function() {
		$('#dataTables-example').dataTable();
	});
</script>

<script type="text/javascript">
	setPage("MyProductMenuId");
</script>

<div class="inner">
	<div class="row">
		<div class="col-lg-3">
			<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Product</h1>
		</div>
		<div class="pull-right" style="padding: 25px;">
			<a class="btn btn-primary" title="" data-toggle="tooltip" href="${baseURL}/menu/addProduct.html" data-original-title="Add New"> &nbsp;&nbsp;&nbsp;ADD&nbsp;&nbsp;&nbsp; </a> <a
				class="btn btn-danger" style="font-size: 14px !important" title="" title="" data-toggle="tooltip" type="button" data-original-title="Delete"> DELETE </a>

		</div>
	</div>
	<hr />
	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp;Product List
				</h3>
			</div>
			<div class="panel-body">
				<div class="well">
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label class="control-label" for="input-name">Product Name</label> <input id="input-name" class="form-control" type="text" placeholder="Product Name" value="" name="filter_name"
									autocomplete="off">
								<ul class="dropdown-menu">
								</ul>
							</div>
							<div class="form-group">
								<label class="control-label" for="input-model">Model</label> <input id="input-model" class="form-control" type="text" placeholder="Model" value="" name="filter_model" autocomplete="off">
								<ul class="dropdown-menu">
								</ul>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="control-label" for="input-price">Price</label> <input id="input-price" class="form-control" type="text" placeholder="Price" value="" name="filter_price">
							</div>
							<div class="form-group">
								<label class="control-label" for="input-quantity">Quantity</label> <input id="input-quantity" class="form-control" type="text" placeholder="Quantity" value="" name="filter_quantity">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="control-label" for="input-status">Status</label> <select id="input-status" class="form-control" name="filter_status">
									<option value="*"></option>
									<option value="1">Enabled</option>
									<option value="0">Disabled</option>
									<option value="5">Pending Approval</option>
								</select>
							</div>
							<button id="button-filter" class="btn btn-primary pull-right" type="button">
								<i class="fa fa-search"></i> Filter
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
									<td class="text-center" style="width: 1px;"><input type="checkbox" onclick=""></td>
									<th class="text-center">Image</th>
									<th>Product Name</th>
									<th>Model</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>status</th>
									<th class="text-right">Action</th>
								</tr>
							</thead>
							<tbody>
								<tr class="odd gradeX">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="even gradeC">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="odd gradeA">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="even gradeA">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="odd gradeA">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>

								<tr class="odd gradeX">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="even gradeC">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="odd gradeA">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="even gradeA">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="odd gradeA">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>

								<tr class="odd gradeX">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="even gradeC">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="odd gradeA">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="even gradeA">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="odd gradeA">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>

								<tr class="odd gradeX">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="even gradeC">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="odd gradeA">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="even gradeA">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
								</tr>
								<tr class="odd gradeA">
									<td class="text-center"><input type="checkbox" onclick=""></td>
									<td class="text-center"><img src="${context}/resources/img/macbook_1-40x40.jpg" class="img-thumbnail" alt="macbook.."></td>
									<td>Naya Apple.</td>
									<td>1355</td>
									<td>0.000</td>
									<td>1</td>
									<td>Enabled</td>
									<th class="text-right">
										<button class="btn btn-primary">
											<i class="icon-pencil icon-white"></i> Edit
										</button>
									</th>
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
