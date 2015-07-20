<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.servletContext.contextPath}" />
<form:form id="updateInformation" name="updateInformation" cssClass="form-horizontal" commandName="informationBO">
	<form:hidden path="informationId" id="informationId" />
	<form:hidden path="seoBO.seoId" id="seoId" />

	<div class="col-lg-10">
		<div class="container-fluid" style="background-color: white;">
			<div class="row">
				<div class="col-lg-3">
					<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Edit Information Page</h1>
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
						<i class="icon-th-list"></i> &nbsp; Edit Information Page
					</h3>
				</div>
				<div class="panel-body">
					<br>
					<div class="row">
						<div class="col-lg-12">
							<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
								<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
									<li class="active" id="tabGeneral"><a data-toggle="tab" href="#tab-general">General</a></li>
									<li id="tabdata"><a data-toggle="tab" href="#tab-data">Data</a></li>
								</ul>
								<div class="tab-content">
									<!-- General tab-data-->
									<div class="tab-pane fade in active" id="tab-general">
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-informationtitle">Information Title</label>
											<div class="col-sm-10">
												<form:input type="text" path="informationTitle" value="" placeholder="informationtitle" id="informationtitle" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-description1">Description</label>
											<div class="col-lg-10">
												<div class="box">
													<div id="cleditorDiv" class="body collapse in">
														<form:textarea id="descriptionEditor" path="description" class="form-control"/>
															<div class="form-actions no-margin-bottom" id="cleditorForm">
																<br />
															</div>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">Meta Tag Title</label>
											<div class="col-sm-10">
												<form:input type="text" path="seoBO.metaTitle" value="" placeholder="metatagtitle" id="metaTagTiltle" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-meta-description1">Meta tag Description</label>
											<div class="col-sm-10">
												<form:textarea path="seoBO.metaDesc" rows="5" placeholder="metatagdescription" id="metaTagDescription" class="form-control"/>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-metatagkeyword">Meta Tag Keyword</label>
											<div class="col-sm-10">
												<form:textarea path="seoBO.metaKeyword" rows="5" placeholder="metatagkeyword" id="metagKeyword" class="form-control"/>
											</div>
										</div>
									</div>

									<!-- Data tab-data-->
									<div class="tab-pane fade" id="tab-data">
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-status">Status</label>
											<div class="col-sm-10">
												<form:select path="isActive" id="status" placeholder="---please select---" class="form-control">
													<form:option value="1" selected="selected">Enable</form:option>
													<form:option value="0">Disable</form:option>
												</form:select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-status">SORT Order</label>
											<div class="col-sm-10">
												<form:input type="text" path="sortOrder" value="" placeholder="sortorder" id="sortOrder" class="form-control" />
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
</form:form>
<script>
	$(document).ready(function() {
		$("#descriptionEditor").cleditor();
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#saveButton").click(function() {
			var informationBO = {};
			var seoBO = {};
			informationBO.informationId = $("#informationId").val();
			informationBO.informationTitle = $("#informationtitle").val();
			informationBO.description = $("#descriptionEditor").val();
			seoBO.seoId = $("#seoId").val();
			seoBO.metaTitle = $("#metaTagTiltle").val();
			seoBO.metaDescription = $("#metaTagDescription").val();
			seoBO.metaKeyword = $("#metaKeyword").val();
			informationBO.sortOrder = $("#sortOrder").val();
			informationBO.isActive = $("#status").val();
			informationBO.seoBO = seoBO;
			postData = JSON.stringify(informationBO);
			alert("information object" + postData);
			$.ajax({
				url : "../information/updateInformation",
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