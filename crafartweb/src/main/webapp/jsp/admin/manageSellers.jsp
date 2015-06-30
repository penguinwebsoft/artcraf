<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Manage Sellers</h1>
			</div>

			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/addNewSeller">Add</a>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Customer List
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group required">
								<label class="col-sm-2 control-label">Ventor Name</label> <span class="col-sm-2"> <input type="text" name="customername" value="" placeholder="customername" id="input-orderid"
									class="form-control" />
								</span> <label class="col-sm-2 control-label">Mobile Number</label> <span class="col-sm-2"> <input type="text" name="mobileno" value="" placeholder="mobileno" id="mobileno"
									class="form-control" />
								</span> <label class="col-sm-2 control-label">Status</label> <span class="col-sm-2"> <select name="status" id="status" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">Enable</option>
										<option value="0">disable</option>
								</select>
								</span>
							</div>
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-status">Export</label> <span class="col-sm-2"> <select name="status" id="input-status" placeholder="---please select---"
									class="form-control">
										<option value="1" selected="selected">Export to Excel</option>
										<option value="0">Export to pdf</option>
								</select>
								</span>
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
								<td>Image</td>
								<td>Vendor Name</td>
								<td>Commission Rate</td>
								<td>Total Products</td>
								<td>Status</td>
								<td>Action</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>555</td>
								<td>$1.00/month (USD) - 1 Year ($12.00)</td>
								<td>0</td>
								<td>Pending Approval</td>
								<td><a class="btn btn-success" href="${baseURL}/menu/viewSellers">View</a> <a class="btn btn-warning" href="${baseURL}/menu/editSeller">Edit</a></td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>8Caso</td>
								<td>Percentage (5%)</td>
								<td>0</td>
								<td>Enabled</td>
								<td>
									<button type="button" class="btn btn-success">View</button>
									<button type="button" class="btn btn-warning">Edit</button>
								</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>Apple Pte Ltd</td>
								<td>Percentage(10%)</td>
								<td>13</td>
								<td>Enabled</td>
								<td>
									<button type="button" class="btn btn-success">View</button>
									<button type="button" class="btn btn-warning">Edit</button>
								</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>Hewlett-Packard</td>
								<td>Percentage(20%)</td>
								<td>10</td>
								<td>Enabled</td>
								<td>
									<button type="button" class="btn btn-success">View</button>
									<button type="button" class="btn btn-warning">Edit</button>
								</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>Tab</td>
								<td>FixedRate(30)</td>
								<td>10</td>
								<td>Enabled</td>
								<td>
									<button type="button" class="btn btn-success">View</button>
									<button type="button" class="btn btn-warning">Edit</button>
								</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
								<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
								<td>Phone</td>
								<td>FixedRate(40)</td>
								<td>15</td>
								<td>Enabled</td>
								<td>
									<button type="button" class="btn btn-success">View</button>
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
</div>
<script type="text/javascript">
	setPage("manageSellersMenuId");
</script>
