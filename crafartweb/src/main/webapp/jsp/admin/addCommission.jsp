<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Commission Page</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" class="btn btn-success">Save</button>
				<button type="button" class="btn">Cancel</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Add Commission
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-model">Commission Name</label>
								<div class="col-sm-10">
									<input type="text" name="name" value="" placeholder="name" id="commisionName" class="form-control" />
								</div>
							</div>
							<div class="form-group required" id="percentage">
								<label class="col-sm-3 control-label" for="percentage">Percentage</label>
								<div class="col-sm-3">
									<select name="status" id="type" class="form-control">
										<option value="1" selected="selected">Percentage</option>
										<option value="0">Fixed Rate</option>
									</select>
								</div>
							</div>
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-model">Commission Rate</label>
								<div class="col-sm-10">
									<input type="number" name="rate" value="" placeholder="rate" id="rate" class="form-control" />
								</div>
							</div>
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-model">Sort Order</label>
								<div class="col-sm-10">
									<input type="number" name="sortorder" value="" placeholder="sortorder" id="sortOrder" class="form-control" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#saveBtn").click(function() {
			var commisionBO = {};

			commisionBO.name = $("#commisionName").val();
			commisionBO.type = $("#type").val();
			commisionBO.value = $("#rate").val();
			commisionBO.sortOrder = $("#sortOrder").val();

			postData = JSON.stringify(commisionBO);
			$.ajax({
				url : "../commision/addCommision",
				type : "post",
				data : postData,
				contentType : "application/json",
				dataType : "json",
				success : function(data) {
					if (data.result == true)
						alert("saved succefully");
					else
						alert("Details failed to save");
				}
			});
		});
	});
</script>