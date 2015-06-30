<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Add Length Details</h1>
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
					<i class="icon-th-list"></i> &nbsp; Add Length Details
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group required">
								<label class="col-sm-2 control-label" for="input-model">Length Class Title</label>
								<div class="col-sm-10">
									<input type="text" name="lengthclasstitle" value="" placeholder="lengthclasstitle" id="lengthclasstitle" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-class"><span data-toggle="tooltip" title="lengthclassunit">Length Class Unit</span></label>
								<div class="col-sm-10">
									<input type="text" name="lengthclassunit" value="" placeholder="lengthclassunit" id="lengthclassunit" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">SortOrder</span></label>
								<div class="col-sm-10">
									<input type="number" name="sortorder" value="" placeholder="sortorder" id="sortorder" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-status">Status</label>
								<div class="col-sm-10">
									<select name="status" id="status" class="form-control">
										<option value="1" selected="selected">ENABLE</option>
										<option value="2" selected="selected">DISABLE</option>

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
			var lengthClassBO = {};
			
			lengthClassBO.title = $("#lengthclasstitle").val();
			lengthClassBO.unit= $("#lengthclassunit").val();
			lengthClassBO.sortorder = $("#sortorder").val();
			lengthClassBO.isActive = $("status").val();
			postData = JSON.stringify(lengthClassBO);
			alert("lengthClass object" + postData);
			$.ajax({
				url : "../lengthClass/addLengthClass",
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