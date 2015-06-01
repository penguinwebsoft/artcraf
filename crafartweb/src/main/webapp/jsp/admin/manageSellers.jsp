<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Manage Sellers</h1>
			</div>

			<div class="pull-right" style="padding: 25px;">
				<button type="button" class="btn btn-success">Add</button>
				<button type="button" class="btn btn-warning">Delete</button>
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

