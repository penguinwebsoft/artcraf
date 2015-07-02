<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
	$(document).ready(
			function() {
				var subCategories = [];
				// if attribute page is loaded on click of edit button from attribute list page
				// then update value is set to true. other case, user clicks "Add" but attribute list 
				// page , then update is false.
				var isUpdate = $("#update").val();
				// incase of update, no need to load categories and its subcategories
				if (isUpdate == "true") {
					var categoryId = $("#categoryId").val();
					loadCategories(categoryId);
					loadSubCategories(categoryId);
				} else {
					// incase of add attribute, category id passed as null
					loadCategories(null);
				}

				// load categories
				function loadCategories(categoryId) {
					$.ajax({
						url : "../category/getCategory",
						type : "get",
						contentType : "application/json",
						dataType : "json",
						success : function(data) {
							var categoryBOs = data.categoryBOs;
							$.each(categoryBOs, function(key, value) {
								if (categoryId == value.categoryId) {
									$("#productCategory").append(
											'<option selected="selected" value='+value.categoryId+'>'
													+ value.categoryName
													+ '</option>');
								} else {
									$("#productCategory").append(
											'<option value='+value.categoryId+'>'
													+ value.categoryName
													+ '</option>');
								}

							});
						}

					});
				}
				
				// load sub categories 
				
				function loadSubCategories(categoryId){
					$.ajax({
						url : "../category/getSubCategory",
						type : "post",
						cache : false,
						dataType : "json",
						data : "categoryId="+ categoryId,
						success : function(data) {
							var subCategoryBOs = data.subCategoryBOs;
							$("#productSubCategory option").remove();
							$.each(subCategoryBOs,function(key, subCategoryBO) {
												$("#productSubCategory").append('<option value='+subCategoryBO.categoryId+'>'
																		+ subCategoryBO.categoryName
																		+ '</option>');
										    	});
						}
					});
				}
				
				$("#productCategory").on('change', function() {
					loadSubCategories($(this).val());

				});
				$("#saveButton").click(function() {
					var attributeBO = {};
					var subCategoryBO = {};
					subCategoryBO.categoryId = $("#productSubCategory").val();
					attributeBO.subCategoryBO = subCategoryBO;
					attributeBO.attributeName = $("#attributename").val();
					attributeBO.sortOrder = $("#sortorder").val();
					
					if (isUpdate == "false") {
						postData = JSON.stringify(attributeBO);
						$.ajax({
							url : "../attribute/addAttribute",
							type : "post",
							data : postData,
							contentType : "application/json",
							dataType : "json",
							success : function(data) {
								if (data.response == "SUCCESS")
									alert("saved succefully");
								else
									alert("Application error- save failed");
							}
						});
					} else if (isUpdate == "true"){
						attributeBO.attributeId =  $("#attributeId").val();
						alert(attributeBO.attributeId);
						postData = JSON.stringify(attributeBO);
						$.ajax({
							url : "../attribute/updateAttribute",
							type : "post",
							data : postData,
							contentType : "application/json",
							dataType : "json",
							success : function(data) {
								if (data.response == "SUCCESS")
									alert("updated succefully");
								else
									alert("Application error- save failed");
							}
						});
					}

				});
			});
</script>
<form:form id="addUpdateAttribute" name="addUpdateAttributeForm" commandName="attribute">
	<form:hidden path="update" id="update" />
	<form:hidden path="attributeId" id="attributeId"/>
	<form:hidden path="categoryBO.categoryId" id="categoryId" />
	<form:hidden path="subCategoryBO.categoryId" id="subCategoryId" />
	<div class="col-lg-10">
		<div class="container-fluid" style="background-color: white;">
			<div class="row">
				<div class="col-lg-3">
					<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Add Attribute Page</h1>
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
							<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
								<!-- Start tab-data-->
								<div class="form-group">
									<label class="col-sm-2 control-label" for="input-status">Categories</label>
									<div class="col-sm-10">
										<select name="categories" id="productCategory" placeholder="---please select---" class="form-control">

										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="input-status">Sub-Categories</label>
									<div class="col-sm-10">
										<select id="productSubCategory" data-placeholder="Choose a Category" class="form-control" tabindex="4">

										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-attributename"><span data-toggle="tooltip" title="attributename">Attribute Name</span></label>
									<div class="col-sm-10">
										<form:input type="text" id="attributename" path="attributeName" placeholder="attributename" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="input-sortorder"><span data-toggle="tooltip" title="Force a minimum ordered amount">Sort order</span></label>
									<div class="col-sm-10">
										<form:input type="number" path="sortOrder" id="sortorder" value="" placeholder="sortorder" class="form-control" />
									</div>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form:form>
