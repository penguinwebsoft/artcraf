<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Add Courier</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" name="saveBtn" id="saveBtn" class="btn btn-success">Save</button>
				<button type="button" class="btn">Return</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Add New Courier
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-model">Courier Name</label>
								<div class="col-sm-10">
									<input type="text" id="name" name="name" value="" placeholder="name" id="input-Name" class="form-control" />
								</div>
							</div>
					
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-sku"><span data-toggle="tooltip" title="companyname">Estimated Delivery Time</span></label>
								<div class="col-sm-10">
									<input type="text" id="estimatedDeliveryTime" name="estimatedDeliveryTime" value="" placeholder="Time" id="input-Time" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Image</span></label>
								<div class="col-sm-10">
									<img id="image" class="image" src="${context}/resources/img/dhl.png" style="width: 200px; height: 100px;" class="img-responsive">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">SortOrder</span></label>
								<div class="col-sm-10">
									<input type="number" id="sortOrder" name="sortOrder" value="" placeholder="sortorder" id="input-sortorder" class="form-control" />
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<<script type="text/javascript">
$(document).ready(function() {
	$("#saveBtn").click(function() {
		var courierBO = {};
		
		courierBO.courierName = $("#name").val();
		courierBO.image = $("#image").val();
		courierBO.estimatedDeliveryTime = $("#estimatedDeliveryTime").val();
		courierBO.sortOrder = $("#sortOrder").val();
		postData = JSON.stringify(courierBO);
		alert("courier object " + postData);
		$.ajax({
			url : "../courier/addCourier",
			type : "post",
			data : postData,
			contentType : "application/json",
			dataType : "json",
			success : function(data) {
				if(data.result == true)
					alert("saved succefully");
				else
					alert("Details failed to save");
			}
		});
	});
});
</script>
