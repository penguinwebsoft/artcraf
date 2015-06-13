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
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Edit Order</h1>
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
					<i class="icon-th-list"></i> &nbsp; Edit Order
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
								<li class="active" id="tabCustomerDetails"><a data-toggle="tab" href="#tab-customerdetails">Customer Details</a></li>
								<li id="tabProducts"><a data-toggle="tab" href="#tab-products">Products</a></li>
								<li id="tabPaymentDetails"><a data-toggle="tab" href="#tab-paymentdetails">Payment Details</a></li>
								<li id="tabShippingDetails"><a data-toggle="tab" href="#tab-shippingdetails">Shipping Details</a></li>
								<li id="tabTotals"><a data-toggle="tab" href="#tab-totals">Totals</a></li>
							</ul>
							<div class="tab-content">
								<!-- General tab-data-->
								<div class="tab-pane fade in active" id="tab-customerdetails">
									<div class="form-group required">
										<label class="col-sm-2 control-label">First Name</label>
										<div class="col-sm-10">
											<input type="text" name="firstname" value="" placeholder="firstname" id="firstname" class="form-control" />
										</div>
									</div>
								   <div class="form-group required">
										<label class="col-sm-2 control-label">Last Name</label>
										<div class="col-sm-10">
											<input type="text" name="lastname" value="" placeholder="lastname" id="lastname" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label">Email</label>
										<div class="col-sm-10">
											<input type="text" name="email" value="" placeholder="email" id="email" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label">Mobile Number</label>
										<div class="col-sm-10">
											<input type="number" name="mobilenumber" value="" placeholder="mobilenumber" id="mobilenumber" class="form-control" />
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label">Telephone number</label>
										<div class="col-sm-10">
											<input type="number" name="telephonenumber" value="" placeholder="telephonenumber" id="telephonenumber" class="form-control" />
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