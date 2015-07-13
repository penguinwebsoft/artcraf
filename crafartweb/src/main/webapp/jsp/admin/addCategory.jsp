<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.servletContext.contextPath}" />
<script type="text/javascript">
	$(document).ready(function() {
		// isupdate true or false
		var isUpdate = $("#update").val();

		$("#saveButton").click(function() {
			var categoryBO = {};
			var seoBO = {};
			categoryBO.categoryName = $("#categoryName").val();
			categoryBO.status = $("#status").val();
			categoryBO.description = $("#description").val();
			categoryBO.sortOrder = $("#sortOrder").val();
			seoBO.metaTitle = $("#metaTagTitle").val();
			seoBO.metaDesc = $("#metaDescription").val();
			seoBO.metaKeyword = $("#metaTagKeyword").val();
			categoryBO.seoBO = seoBO;
			//adding category if update is false
			/* if (isUpdate == "false") { */
			postData = JSON.stringify(categoryBO);
			$.ajax({
				url : "../category/addCategory",
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
			// if update is true, then update category for that category id
			/* else if (isUpdate == "true") {
			categoryBO.categoryId = $("#categoryId").val();
			categoryBO.seoBO.seoId = $("#seoId").val();
			postData = JSON.stringify(categoryBO);
			$.ajax({
				url : "../category/updateCategory",
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
			} */
		});

	});
</script>

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Add Categories</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" class="btn btn-success" id="saveButton">Save</button>
				<button type="button" class="btn btn-warning">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Add New Categories
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">

							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
								<li class="active" id="tabGeneral"><a data-toggle="tab" href="#tab-general">General</a></li>
								<li id="tabImage"><a data-toggle="tab" href="#tab-image">Image</a></li>
							</ul>
							<div class="tab-content">
								<!-- General tab-data-->
								<div class="tab-pane fade in active" id="tab-general">
									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-model">Category Name</label>
										<div class="col-sm-10">
											<input type="text" name="categoryName" value="" placeholder="name" id="categoryName" class="form-control" />

										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-meta-description1">Description</label>
										<div class="col-sm-10">
											<textarea name="description" rows="5" placeholder="description" id="description" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-model">Meta Tag Title</label>
										<div class="col-sm-10">
											<input type="text" name="seoBO.metaTitle" value="" placeholder="metatagtitle" id="metaTagTitle" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-meta-description1">Meta tag Description</label>
										<div class="col-sm-10">
											<textarea name="seoBO.metaDesc" rows="5" placeholder="metatagdescription" id="metaDescription" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-metatagkeyword">Meta Tag Keyword</label>
										<div class="col-sm-10">
											<textarea name="seoBO.metaKeyword" rows="5" placeholder="metatagkeyword" id="metaTagKeyword" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">Sort order</label>
										<div class="col-sm-10">
											<input type="text" name="sortOrder" value="" placeholder="Sort Order" id="sortOrder" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">Status</label>
										<div class="col-sm-10">
											<select name="status" id="status" placeholder="---please select---" class="form-control">
												<option value="1" selected="selected">Enable</option> 
												<option value="0">Disable</option>
											</select>
										</div>
									</div>

								</div>

								<!-- Design tab-data-->
								<div class="tab-pane fade" id="tab-image">
									<div class="table-responsive">
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-image">Image</label>
											<div class="col-sm-10">
												<a class="user-link" href="#"> <img class="media-object img-thumbnail user-img" alt="User Picture" src="${context}/resources/img/user.gif"></a>
												<button type="button" class="btn btn-primary" style="margin-top: 1%">Upload Photo</button>
											</div>
										</div>
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
