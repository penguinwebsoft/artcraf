<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Add Banner Page</h1>
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
					<i class="icon-th-list"></i> &nbsp; Add Banner Page
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
									<input type="text" id="bannerTitle" name="bannertitle" value="" placeholder="bannertitle" id="input-bannertitle" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="bannerGroup">BannerGroup</label>
								<div class="col-sm-10">
									<select name="bannerGroup" id="bannerGroups" placeholder="---please select---" class="form-control">
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
									<input type="text" id="bannerurl" name="bannerurl" value="" placeholder="BannerURL" id="input-bannerurl" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">SortOrder</span></label>
								<div class="col-sm-10">
									<input type="text" id="sortOrder" name="sortorder" value="" placeholder="sortorder" id="input-sortorder" class="form-control" />
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(
			function() {

				$.ajax({
					url : "../bannerGroup/getBannerGroup",
					type : "get",
					contentType : "application/json",
					dataType : "json",
					success : function(data) {
						var bannerGroupBOs = data.bannerGroupBOs;
						$.each(bannerGroupBOs, function(key, bannerGroupBO) {
							$("#bannerGroups").append(
									'<option value='+bannerGroupBO.bannerGroupId+'>'
											+ bannerGroupBO.bannerGroupName
											+ '</option>');
						});
					}

<<<<<<< HEAD:crafartweb/src/main/webapp/jsp/admin/addBannerPage.jsp
</script>

<script>
setPage("bannerPageMenuId");
=======
				});
				$("#saveBtn").click(function() {
					var bannerBO = {};
                    var bannerGroupBO = {};
					bannerBO.bannerName = $("#bannerTitle").val();
					bannerGroupBO.bannerGroupId = $("#bannerGroups").val();
					bannerBO.BannerImage = $("#image").val();
					bannerBO.sortOrder = $("#sortOrder").val();
					bannerBO.bannerGroupBO = bannerGroupBO;
					postData = JSON.stringify(bannerBO);
					alert("banner object" + postData);
					$.ajax({
						url : "../banner/addBanner",
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
>>>>>>> 66f945a6b5c0d2189312b1cfd0d76fa14c14d541:crafartweb/src/main/webapp/jsp/admin/addBanner.jsp
</script>