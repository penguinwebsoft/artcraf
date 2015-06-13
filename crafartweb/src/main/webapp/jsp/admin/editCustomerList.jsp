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
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Edit Customer List</h1>
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
					<i class="icon-th-list"></i> &nbsp; Edit Customer List
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
								<li class="active" id="tabGeneral"><a data-toggle="tab" href="#tab-general">General</a></li>
								<li id="tabHistory"><a data-toggle="tab" href="#tab-history">History</a></li>
								<li id="tabTransaction"><a data-toggle="tab" href="#tab-transaction">Transaction</a></li>
								<li id="tabIP"><a data-toggle="tab" href="#tab-ipaddress">IpAddress</a></li>
							</ul>


							<!-- General tab-data-->
							<div class="tab-content" style="border: 0px; padding: 0px;">
								<div class="tab-pane fade in active" id="tab-general">
									<div>
										<ul class="nav nav-pills nav-stacked col-lg-2">
											<li id="tabgeneral"><a data-toggle="tab" href="tab-general">General</a></li>
											<li id="tabaddress"><a data-toggle="tab" href="tab-address">Add Address</a></li>
											<li id="tabaddress1"><a data-toggle="tab" href="tab-address1">Add Address1</a></li>
											<li id="tabaddress2"><a data-toggle="tab" href="tab-address2">Add Address2</a></li>
											<li id="tabaddress3"><a data-toggle="tab" href="tab-address3">Add Address3</a></li>
											<li id="tabaddress4"><a data-toggle="tab" href="tab-address4">Add Address4</a></li>
											<li id="tabaddress5"><a data-toggle="tab" href="tab-address5">Add Address5</a></li>
											<li id="tabaddress6"><a data-toggle="tab" href="tab-address6">Add Address6</a></li>
											<li id="tabaddress7"><a data-toggle="tab" href="tab-address7">Add Address7</a></li>
										</ul>
									</div>
									<div class="form-group required col-md-10">
										<label class="col-sm-2 control-label">First Name </label>
										<div class="col-sm-5">
											<input type="text" name="firstname" value="" placeholder="firstname" id="input-firstname" class="form-control" />
										</div>
									</div>
									<div class="form-group required col-md-10">
										<label class="col-sm-2 control-label">Last Name </label>
										<div class="col-sm-5">
											<input type="text" name="lastname" value="" placeholder="lastname" id="input-lastname" class="form-control" />
										</div>
									</div>
									<div class="form-group required col-md-10">
										<label class="col-sm-2 control-label">Email</label>
										<div class="col-sm-5">
											<input type="text" name="email" value="" placeholder="email" id="input-email" class="form-control" />
										</div>
									</div>
									<div class="form-group required col-md-10">
										<label class="col-sm-2 control-label">TelePhone</label>
										<div class="col-sm-5">
											<input type="text" name="telephone" value="" placeholder="telephone" id="input-telephone" class="form-control" />
										</div>
									</div>
									<div class="form-group required col-md-10">
										<label class="col-sm-2 control-label">Mobile Phone</label>
										<div class="col-sm-5">
											<input type="text" name="mobilephone" value="" placeholder="mobilephone" id="input-mobilephone" class="form-control" />
										</div>
									</div>
									<div class="form-group required col-md-10">
										<label class="col-sm-2 control-label">NewsLetters</label>
										<div class="col-sm-5">
											<select name="newsletters" id="newsletters" placeholder="---please select---" class="form-control">
												<option value="1" selected="selected">Enable</option>
												<option value="0">Disable</option>
											</select>
										</div>
									</div>

									<div class="form-group required col-md-10">
										<label class="col-sm-2 control-label" for="input-status">Status</label>
										<div class="col-sm-5">
											<select name="status" id="input-status" placeholder="---please select---" class="form-control">
												<option value="1" selected="selected">Enable</option>
												<option value="0">Disable</option>
											</select>
										</div>
									</div>
									<div class="form-group required col-md-10">
										<label class="col-sm-2 control-label" for="input-status">Approved</label>
										<div class="col-sm-5">
											<select name="status" id="input-status" placeholder="---please select---" class="form-control">
												<option value="1" selected="selected">Yes</option>
												<option value="0">No</option>
											</select>
										</div>
									</div>
						</form>
					</div>

					<!-- History tab-data-->
						<div class="tab-pane" id="tab-history">
							<div class="table-responsive">
								<table id="history" class="table table-striped table-bordered table-hover pull-left">
									<thead>
										<tr>
											<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
											<td>Date Added</td>
											<td>Command</td>
										</tr>
									</thead>
								</table>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">Command</label>
								<div class="col-sm-10">
									<textarea name="command" rows="5" placeholder="command" id="command" class="form-control"></textarea>
								</div>
								<button type="button" class="btn btn-warning col-md-offset-10">Add History</button>
							</div>
						</div>
						<!-- Transaction tab-data-->
						<div class="tab-pane" id="tab-transaction">
							<div class="table-responsive">
								<table id="transaction" class="table table-striped table-bordered table-hover pull-left">
									<thead>
										<tr>
											<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
											<td>Date Added</td>
											<td>Command</td>
										</tr>
									</thead>
								</table>
							</div>
							<div class="form-group required col-md-10">
								<label class="col-sm-2 control-label">Description</label>
								<div class="col-sm-5">
									<input type="text" name="mobilephone" value="" placeholder="Description" id="input-mobilephone" class="form-control" />
								</div>
							</div>
							<div class="form-group required col-md-10">
								<label class="col-sm-2 control-label">Amount</label>
								<div class="col-sm-5">
									<input type="text" name="mobilephone" value="" placeholder="Amount" id="input-mobilephone" class="form-control" />
								</div>
							</div>
							<button type="button" class="btn btn-warning col-md-offset-11">Add Transaction</button>
						</div>
						<!-- IpAddress tab-data-->
						<div class="tab-pane fade" id="tab-ipaddress">
							<div class="table-responsive">
								<table id="ipaddress" class="table table-striped table-bordered table-hover pull-left">
									<thead>
										<tr>
											<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
											<td>IP Address</td>
											<td>Total Accounts</td>
											<td>Date Added</td>
											<td>Action</td>
										</tr>
									</thead>
									<thead>
										<tr>
											<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
											<td>172.40.60.100</td>
											<td>1</td>
											<td>2/2/12</td>
											<td><button type="button" class="btn btn-warning">Add Ban Ip</button></td>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
