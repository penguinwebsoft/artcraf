<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Coupon List</h1>
			</div>

			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/addCouponList">Add</a>
				<button type="button" class="btn btn-danger">Delete</button>
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
									<td>Product Name</td>
									<td>Discount Code</td>
									<td>Discount Value</td>
									<td>Date Start</td>
									<td>Date End</td>
									<td>Status</td>
									<td>Action</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>China Post Air Mail</td>
									<td>2345</td>
									<td>10%</td>
									<td></td>
									<td></td>
									<td>1</td>
									<td><a class="btn btn-warning" href="${baseURL}/menu/editCouponList">Edit</a></td>
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
	setPage("couponListMenuId");
</script>