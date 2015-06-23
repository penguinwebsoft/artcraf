<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />


<script type="text/javascript">
var geoZoneBOs = {};
$(document).ready(function() {
	
	$.ajax({
		url : "../geoZone/getGeoZoneBO",
		type : "post",
		contentType : "application/json",
		dataType : "json",
		success : function(data){
			geoZoneBO = data.geoZoneBO;
			displayGeoZoneList();
		}
	});
	function displayGeoZoneList(){
		 $.each(geoZoneBO, function(key, value) {
			 var geoZoneBO = value;
				html = '<tr>';
				html +='<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>';
				html +='<td>'+geoZoneBO.geoZoneName+'</td>';
				html +='<td>'+geoZoneBO.sortOrder+'</td>';
				html +='<td><button type="button" class="btn btn-warning">Edit</button></td>';
				html +='</tr>';
				$('#shipping tbody').append(html);
			}); 
		}
});
</script>


<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Geo_Zone</h1>
			</div>

			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/addGeoZone">Add</a>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>

		<!-- Table Section-->
		<div class="container-fluid" style="background-color: white;">
			<div class="container">
				<div class="tab-pane" id="tab-shipping">
					<div class="table-responsive">
						<table id="shipping" class="table table-striped table-bordered table-hover pull-left">
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Geo_Zone Title</td>
									<td>Geo_Zone Description</td>
	 								<td>Sort Order</td>
									<td>Action</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>TextTiles</td>
									<td>TextTiles</td>
									<td>0</td>
									<td>
										<a class="btn btn-warning" href="${baseURL}/menu/editGeoZone">Edit</a>
									</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>New Text Tiles</td>
									<td>New Text Tiles</td>
									<td>0</td>
									<td>
										<button type="button" class="btn btn-warning">Edit</button>
									</td>
								</tr>
							</thead>
						</table>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
		$("#saveBtn").click(function() {
			var geoZoneBO = {};
			
			geoZoneBO.Geo_Zone Title = $("#Geo_Zone Title").val();
			geoZoneBO.Geo_Zone Description = $("#Geo_Zone Description").val();
			geoZoneBO.Sort Order = $("#Sort Order").val();
			geoZoneBO.Action = $("#Action").val();
			
			
			postData = JSON.stringify(geoZoneBO);
			$.ajax({
				url : "../geoZone/addgeoZone",
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
<script type="text/javascript">
	setPage("geoZoneMenuId");
</script>


