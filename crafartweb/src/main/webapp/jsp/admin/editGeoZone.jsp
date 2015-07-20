<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />
<form:form id="updateGeoZone" name="updateGeoZone" cssClass="form-horizontal" commandName="geoZoneBO">
<form:hidden path="geoZoneId" id="geoZoneId"/>
<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Edit Geo_Zone</h1>
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
					<i class="icon-th-list"></i> &nbsp; Edit Geo_Zone Details
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-model">Geo_Zone Title</label>
								<div class="col-sm-10">
									<form:input type="text" path="name" value="" placeholder="geozonetitle" id="name" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-class"><span data-toggle="tooltip" title="lengthclassunit">Geo_Zone Description</span></label>
								<div class="col-sm-10">
									<form:input type="text" path="description" value="" placeholder="geozonedescription" id="description" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">SortOrder</span></label>
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
			var geoZoneBO = {};
			geoZoneBO.geoZoneId = $("#geoZoneId").val();
			geoZoneBO.name = $("#name").val();
			geoZoneBO.description = $("#description").val();
			geoZoneBO.sortOrder = $("#sortOrder").val();
			postData = JSON.stringify(geoZoneBO);
			alert("geozone object" + postData);
			$.ajax({
				url : "../geoZone/updateGeoZone",
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
<script>
setPage("geoZoneMenuId");
</script>