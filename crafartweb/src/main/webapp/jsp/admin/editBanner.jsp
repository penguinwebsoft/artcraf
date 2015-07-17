<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />
<form:form id="updateBanner" name="updateBanner" cssClass="form-horizontal" commandName="bannerBO">
	<form:hidden path="bannerGroupBO.bannerGroupId" id="bannerGroupId" />
	<form:hidden path="bannerId" id="bannerId" />
	<div class="col-lg-10">
		<div class="container-fluid" style="background-color: white;">
			<div class="row">
				<div class="col-lg-3">
					<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Edit Banner Page</h1>
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
						<i class="icon-th-list"></i> &nbsp; Edit Banner Page
					</h3>
				</div>
				<div class="panel-body">
					<br>
					<div class="row">
						<div class="col-lg-12">
							<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
								<!-- Start tab-data-->
								<div class="form-group required">
									<label class="col-sm-2 control-label">Banner Title</label>
									<div class="col-sm-10">
										<form:input type="text" path="bannerName" value="" placeholder="bannertitle" id="bannerName" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="bannerGroups">Banner Group</label>
									<div class="col-sm-10">
										<select name="bannerGroups" id="bannerGroups" placeholder=" select banner group" class="form-control">
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Image</span></label>
									<div class="col-sm-10">
										<img id="image" class="image" src="${context}/resources/img/dhl.png" style="width: 200px; height: 100px;" class="img-responsive">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">BannerURL</span></label>
									<div class="col-sm-10">
										<form:input type="text" id="bannerUrl" path="bannerUrl" value="" placeholder="BannerURL" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">SortOrder</span></label>
									<div class="col-sm-10">
										<form:input type="number" path="sortOrder" value="" placeholder="sortOrder" id="sortOrder" class="form-control" />
									</div>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form:form>
<script type="text/javascript">
	$(document).ready(
			function() {
				var bannerGroupId = $("#bannerGroupId").val();
				$.ajax({
					url : "../bannerGroup/getBannerGroup",
					type : "get",
					contentType : "application/json",
					dataType : "json",
					success : function(data) {
						var bannerGroupBOs = data.bannerGroupBOs;
						$.each(bannerGroupBOs, function(key, bannerGroupBO) {
							if (bannerGroupId == bannerGroupBO.bannerGroupId) {
								$("#bannerGroups").append(
										'<option selected="selected" value='+bannerGroupBO.bannerGroupId+'>'
												+ bannerGroupBO.bannerGroupName
												+ '</option>');
							} else {
								$("#bannerGroups").append(
										'<option value='+bannerGroupBO.bannerGroupId+'>'
												+ bannerGroupBO.bannerGroupName
												+ '</option>');
							}

						});
					}

				});
				$("#saveButton").click(
						function() {
							var bannerBO = {};
							var bannerGroupBO = {};
							bannerBO.bannerId = $("#bannerId").val();
							bannerBO.bannerName = $("#bannerName").val();
							bannerBO.bannerUrl = $("#bannerUrl").val();
							bannerGroupBO.bannerGroupId = $("#bannerGroups").val();
							bannerBO.bannerImage = $("#image").val();
							bannerBO.sortOrder = $("#sortOrder").val();
							bannerBO.bannerGroupBO = bannerGroupBO;
							postData = JSON.stringify(bannerBO);
							$.ajax({
								url : "../banner/updateBanner",
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

