<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />
<<<<<<< HEAD

=======
<script type="text/javascript">
$(document).ready(function() {
		$("#saveBtn").click(function() {
			var geoZoneBO = {};
			
			geoZoneBO. name= $("#geozonetitle").val();
			geoZoneBO.description= $("#geozonedescription").val();
			geoZoneBO.sortOrder = $("#sortorder").val();
			postData = JSON.stringify(geoZoneBO);
			alert("geoZone object" + postData);
			$.ajax({
				url : "../geoZone/addGeoZone",
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
>>>>>>> branch 'crafart_dev' of https://prabaharanit@bitbucket.org/crafart/crafartbundle.git
<div class="col-lg-10">
<input type="hidden" id="geoZoneId">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Add Geo_Zone</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" id="saveBtn" class="btn btn-success">Save</button>
				<button type="button" class="btn">Return</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Add Geo_Zone Details
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
									<input type="text" id="title" name="geozonetitle" value="" placeholder="geozonetitle" id="title" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-class"><span data-toggle="tooltip" title="lengthclassunit">Geo_Zone Description</span></label>
								<div class="col-sm-10">
									<input type="text" id="description" name="geozonedescription" value="" placeholder="geozonedescription" id="description" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">SortOrder</span></label>
								<div class="col-sm-10">
									<input type="number" id="sortOrder" name="sortorder" value="" placeholder="sortorder" id="sortOrder" class="form-control" />
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<<<<<<< HEAD
<script type="text/javascript">
$(document).ready(function() {
		$("#saveBtn").click(function() {
			var geoZoneBO = {};
			geoZoneBO.geoZoneId = $("#geoZoneId").val();
			geoZoneBO.name= $("#title").val();
			geoZoneBO.description= $("#description").val();
			geoZoneBO.sortOrder = $("#sortOrder").val();
			postData = JSON.stringify(geoZoneBO);
			alert("geoZone object" + postData);
			$.ajax({
				url : "../geoZone/addGeoZone",
				type : "post",
				data : postData,
				contentType : "application/json",
				dataType : "json",
				success : function(data) {
					if(data.result == true){
						var geoZoneBO = data.geoZoneBO;
						$("input[id=geoZoneId]").val(geoZoneBO.geoZoneId);
						alert("saved succefully");
					}
					else
						alert("Details failed to save");
				}
			});
		});
	}); 
</script>
=======
>>>>>>> branch 'crafart_dev' of https://prabaharanit@bitbucket.org/crafart/crafartbundle.git
<script>
setPage("geoZoneMenuId");
</script>
