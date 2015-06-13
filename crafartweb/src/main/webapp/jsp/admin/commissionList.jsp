<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Commission List</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/commissionPage">Add</a>
				<button type="button" class="btn">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Commission List
				</h3>
			</div>
			<!-- Table Section-->
			<div class="container">
				<div class="tab-pane" id="tab-shipping">
					<div class="table-responsive">
						<table id="shipping" class="table table-striped table-bordered table-hover pull-left">
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Commission Name</td>
									<td>Commission Type</td>
									<td>Seller Name</td>
									<td>Rate</td>
									<td>Sort Order</td>
									<td>Action</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>MP3 Players > test 18</td>
									<td>MP3 Players > test 18</td>
									<td>MP3 Players > test 18</td>
									<td>150.00</td>
									<td>1</td>
									<td><a class="btn btn-warning" href="${baseURL}/menu/editcommission">Edit</a></td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>MP3 Players > test 19</td>
									<td>MP3 Players > test 19</td>
									<td>MP3 Players > test 19</td>
									<td>200.00</td>
									<td>2</td>
									<td><button type="button" class="btn btn-warning">Edit</button></td>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>