<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />


<form:form id="updateBannerGroup" name="updateBannerGroup" cssClass="form-horizontal" commandName="bannerGroupBO">
	<form:hidden path="bannerGroupId" id="bannerGroupId" />

	<div class="col-lg-10">
		<div class="container-fluid" style="background-color: white;">
			<div class="row">
				<div class="col-lg-3">
					<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Edit Banner group</h1>
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
						<i class="icon-th-list"></i> &nbsp;Edit Banner Group
					</h3>
				</div>
				<div class="panel-body">
					<br>
					<div class="row">
						<div class="col-lg-12">
							<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
								<!-- Start tab-data-->
								<div class="form-group">
									<label class="col-sm-2 control-label" style="padding-top: 1px;"><span data-toggle="tooltip" title="bannergroupname">Banner Group Name</span></label>
									<div class="col-sm-10">
										<form:input type="text" path="bannerGroupName" value="" placeholder="bannerGroupName" id="bannerGroupName" class="form-control" />
									</div>
								</div>
								<%-- <div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" ><span data-toggle="tooltip" title="bannertitle">Banner Group Title</span></label>
								<div class="col-sm-10">
									<form:input type="text" path="bannertitle" value="" placeholder="bannertitle" id="input-bannertitle" class="form-control" />
								</div>
							</div> --%>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="padding-top: 1px;"><span data-toggle="tooltip" title="bannersize">Banner Size</span></label>
									<div class="col-sm-10">
										<form:input type="text" path="bannerSize" value="" placeholder="bannersize" id="bannerSize" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="input-sortorder"><span data-toggle="tooltip" title="Force a minimum ordered amount">SortOrder</span></label>
									<div class="col-sm-10">
										<form:input type="number" path="sortOrder" value="" placeholder="sortorder" id="sortOrder" class="form-control" />
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
	$(document).ready(function() {

		$("#saveButton").click(function() {
			var bannerGroup = {};
			bannerGroup.bannerGroupId = $("#bannerGroupId").val();
			bannerGroup.bannerGroupName = $("#bannerGroupName").val();
			bannerGroup.bannerSize = $("#bannerSize").val();
			bannerGroup.sortOrder = $("#sortOrder").val();
			postData = JSON.stringify(bannerGroup);
			$.ajax({
				url : "../bannerGroup/updateBannerGroup",
				type : "POST",
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
