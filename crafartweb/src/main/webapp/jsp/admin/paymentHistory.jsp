<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Payment History</h1>
			</div>
		</div>
		<div class="form-group required">
			<label class="col-sm-2 control-label">Exports</label> <span class="col-sm-2"> <select name="exports" id="exports" placeholder="---please select---" class="form-control">
					<option value="1" selected="selected">Export to Excel</option>
					<option value="2">Export to Pdf</option>
			</select>
			</span>
			<div>
				<button type="button" class="btn btn-success col-md-offset-3">Export</button>
				<button type="button" class="btn btn-primary col-md-offset-1" style="margin-top: 5px">Filter</button>
			</div>
		</div>

		<!-- Table Section-->
		<div class="container-fluid" style="background-color: white;">
			<div class="container">
				<div class="tab-pane" id="tab-payment">
					<div class="table-responsive">
						<table id="shipping" class="table table-striped table-bordered table-hover pull-left">
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Seller Name</td>
									<td>Order Products</td>
									<td>Payment Amount</td>
									<td>Payment Date</td>
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
	setPage("paymentHistoryMenuId");
</script>