<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Edit Return Status Template</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success">Save</a>
				<button type="button" class="btn btn-default">Cancel</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp;Edit Return Status Template
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="rsm"><span data-toggle="tooltip" title="osm">Return Status Name</span></label>
								<div class="col-sm-10">
									<input type="text" name="rsm" value="" placeholder="orderstatus" id="rsm" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="subjectline"><span data-toggle="tooltip" title="Force a minimum ordered amount">Subject Line</span></label>
								<div class="col-sm-10">
									<input type="text" name="subjectline" value="" placeholder="subjectline" id="subjectline" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-description1">Description</label>
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
