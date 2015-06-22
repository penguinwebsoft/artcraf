<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL"
	value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
	$(document).ready(
			function() {
				var subCategories = [];
				$.ajax({
					url : "../category/getCategory",
					type : "post",
					contentType : "application/json",
					dataType : "json",
					success : function(data) {
						var categoryBOs = data.categoryBOs;
						$.each(categoryBOs,
								function(key, value) {
									$("#productCategory").append(
											'<option value='+value.categoryId+'>'
													+ value.categoryName
													+ '</option>');
								});
					}

				});
				$("#productCategory").on(
						'change',
						function() {
							$.ajax({
								url : "../category/getSubCategory",
								type : "post",
								cache : false,
								dataType : "json",
								data : "categoryId=" + $(this).val(),
								success : function(data) {
									var subCategoryBOs = data.subCategoryBOs;
									$("#productSubCategory option").remove();
									$.each(subCategoryBOs, function(key, subCategoryBO) {
										$("#productSubCategory").append(
												'<option value='+subCategoryBO.categoryId+'>'
														+ subCategoryBO.categoryName
														+ '</option>');
									});
								}
							});
						});
				$("#saveButton")
				.click(
						function() {
							var attributeBO = {};
							var categoryBO = {};
							
							categoryBO.categoryId= $("#productSubCategory").val();
							attributeBO.categoryBO = categoryBO;
							attributeBO.attributeName= $("#attributename").val();
							attributeBO.sortOrder = $("#sortorder").val();
							postData = JSON.stringify(attributeBO);
							$.ajax({
								url : "../attribute/addAttribute",
								type : "post",
								data : postData,
								contentType : "application/json",
								dataType : "json",
								success : function(data) {
									if(data.response == "SUCCESS")
										alert("saved succefully");
									else
										alert("Application error- save failed");
								}
							});
							
						});
			});


</script>

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Add
					Attribute Page</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" class="btn btn-success" id="saveButton">Save</button>
				<button type="button" class="btn btn-default">Cancel</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp;Add Attribute List
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal"
							enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-status">Categories</label>
								<div class="col-sm-10">
									<select name="categories" id="productCategory"
										placeholder="---please select---" class="form-control">

									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-status">Sub-Categories</label>
								<div class="col-sm-10">
										<select id="productSubCategory"
												data-placeholder="Choose a Category" class="form-control"
												 tabindex="4">

											</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;"
									for="input-attributename"><span data-toggle="tooltip"
									title="attributename">Attribute Name</span></label>
								<div class="col-sm-10">
									<input type="text" name="attributename" id="attributename" value=""
										placeholder="attributename" 
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-sortorder"><span
									data-toggle="tooltip" title="Force a minimum ordered amount">SortOrder</span></label>
								<div class="col-sm-10">
									<input type="number" name="sortorder" id="sortorder" value=""
										placeholder="sortorder" 
										class="form-control" />
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

