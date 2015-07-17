<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Add Order Status</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
			<button type="button" name="saveBtn" id="saveBtn" class="btn btn-success">Save</button>
				<button type="button" class="btn btn-default">Cancel</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp;Add Order Status
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="osm"><span data-toggle="tooltip" title="osm">Order Status Name</span></label>
								<div class="col-sm-10">
									<input type="text" name="orderstatus" value="" placeholder="orderstatus" id="orderstatus" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="subjectline"><span data-toggle="tooltip" title="Force a minimum ordered amount">Subject Line</span></label>
								<div class="col-sm-10">
									<input type="text" name="subjectline" value="" placeholder="subjectline" id="subjectline" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" id="description"for="input-description1">Description</label>
								<div class="col-lg-10">
									<div class="box">
										<div id="cleditorDiv" class="body collapse in">
											<form>
												<textarea id="cleditor" class="form-control"></textarea>
												<div class="form-actions no-margin-bottom" id="cleditorForm">
													<br />
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-status">Status</label>
								<div class="col-sm-10">
									<select id="status" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">Enable</option>
										<option value="0">Disable</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="sortorder"><span data-toggle="tooltip" title="Force a minimum ordered amount">Sort Order</span></label>
								<div class="col-sm-10">
									<input type="text" name="sortorder" value="" placeholder="sortorder" id="sortorder" class="form-control" />
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$("#cleditor").cleditor();
	});
</script>
<script type="text/javascript">
$(document).ready(function() {
		$("#saveBtn").click(function() {
			var orderStatusBO = {};
			
			orderStatusBO.orderStatusTitle = $("#orderstatus").val();
			orderStatusBO.orderStatusSubject= $("#subjectline").val();
			orderStatusBO.description = $("#description").val();
			orderStatusBO.sortOrder = $("status").val();
			postData = JSON.stringify(orderStatusBO);
			alert("orderStatus object" + postData);
			$.ajax({
				url : "../orderStatus/addOrderStatus",
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
	setPage("orderStatusMenuId");
	</script>
