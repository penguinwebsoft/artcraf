<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
<input type="hidden" id="taxClassId">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Add Tax Details</h1>
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
					<i class="icon-th-list"></i> &nbsp; Add Tax Details
				</h3>
			</div>
			<div class="panel-body">
		 	<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-model">Tax Title</label>
								<div class="col-sm-10">
									<input type="text" id="title"name="taxtitle" value="" placeholder="taxtitle"  class="form-control" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-sku"><span data-toggle="tooltip" title="companyname">Tax Description</span></label>
								<div class="col-sm-10">
									<input type="text" id="description" name="taxdescription" value="" placeholder="TaxDescription" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">SortOrder</span></label>
								<div class="col-sm-10">
									<input type="number" id="sortOrder"name="sortorder" value="" placeholder="sortorder"  class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Status</label>
								<div class="col-sm-10">
									<select name="status" id="status" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">Enable</option>
										<option value="0">Disable</option>
									</select>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
		$("#saveBtn").click(function() {
			var taxClassBO = {};
			taxClassBO.taxClassId = $("#taxClassId").val();
			taxClassBO.title = $("#title").val();
			taxClassBO.description= $("#description").val();
			taxClassBO.sortOrder = $("#sortOrder").val();
			taxClassBO.isActive = $("#status").val();
			postData = JSON.stringify(taxClassBO);
			alert("taxclass object" + postData);
			$.ajax({
				url : "../taxClass/addTaxClass",
				type : "POST",
				data : postData,
				contentType : "application/json",
				dataType : "json",
				success : function(data) {
					if(data.result == true){
						alert("saved succefully");
					    $("input[id=taxClassId]").val(data.taxClassBO.taxClassId);
					}
					else
						alert("Details failed to save");
				}
			});
		});
	});
</script>