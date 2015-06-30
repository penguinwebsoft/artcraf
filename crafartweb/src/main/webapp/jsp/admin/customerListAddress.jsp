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
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Customer Address List </h1>
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
					<i class="icon-th-list"></i> &nbsp;Customer Address List
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
								<li class="active" id="tabGeneral"><a data-toggle="tab" href="#tab-general">General</a></li>
							</ul>

							<!-- General tab-data-->
							<div class="tab-pane fade in active " id="tab-general">
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
									<label class="col-sm-2 control-label">Company </label>
									<div class="col-sm-5">
										<input type="text" name="company" value="" placeholder="company" id="company" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">Address 1</label>
									<div class="col-sm-5">
										<input type="text" name="address1" value="" placeholder="address1" id="address1" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">Address 2</label>
									<div class="col-sm-5">
										<input type="text" name="address2" value="" placeholder="address2" id="address2" class="form-control" />
									</div>
								</div>
								
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">City</label>
									<div class="col-sm-5">
										<input type="text" name="city" value="" placeholder="city" id="city" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">Postal Code</label>
									<div class="col-sm-5">
										<input type="text" name="postalcode" value="" placeholder="postalcode" id="postalcode" class="form-control" />
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label">Country</label>
									<div class="col-sm-5">
										<select name="country" id="country" placeholder="---please select---" class="form-control">
											<option value="1" selected="selected">India</option>
										</select>
									</div>
								</div>
								<div class="form-group required col-md-10">
									<label class="col-sm-2 control-label" for="input-status">State</label>
									<div class="col-sm-5">
										<select name="state" id="state" placeholder="---please select---" class="form-control">
											<option value="1" selected="selected">TamilNadu</option>
										</select>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
