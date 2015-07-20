<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.servletContext.contextPath}" />
<div class="col-lg-10">
	<input type="hidden" id="informationId">
	<input type="hidden" id="seoId">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Add Information Page</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" name="saveBtn" id="saveBtn" class="btn btn-success">Save</button>
				<button type="button" class="btn btn-warning">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Add Information Page
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
											<input type="text" id="informationtitle" name="informationtitle" value="" placeholder="informationtitle" id="input-informationtitle" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" id="description" for="input-description1">Description</label>
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
									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-model">Meta Tag Title</label>
										<div class="col-sm-10">
											<input type="text" id="metatagtitle" name="metatagtitle" value="" placeholder="metatagtitle" id="input-metatagtitle" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-meta-description1">Meta tag Description</label>
										<div class="col-sm-10">
											<textarea id="metatagdescription" name="metatagdescription[1][metatagdescription]" rows="5" placeholder="metatagdescription" id="description" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-metatagkeyword">Meta Tag Keyword</label>
										<div class="col-sm-10">
											<textarea id="metatagkeyword" name="metatagkeyword[1][metatagkeyword]" rows="5" placeholder="metatagkeyword" id="metatagkeyword" class="form-control"></textarea>
										</div>
									</div>
								</div>

								<!-- Data tab-data-->
								<div class="tab-pane fade" id="tab-data">
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">Status</label>
										<div class="col-sm-10">
											<select name="status" id="status" placeholder="---please select---" class="form-control">
												<option value="1" selected="selected">Enable</option>
												<option value="0">Disable</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">SORT Order</label>
										<div class="col-sm-10">
											<input type="text" id="sortorder" name="sortorder" value="" placeholder="sortorder" id="input-sortorder" class="form-control" />
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
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#saveBtn")
								.click(
										function() {
											var informationBO = {};
											var seoBO = {};
											informationBO.informationId = $(
													"#informationId").val();
											informationBO.informationTitle = $(
													"#informationtitle").val();
											informationBO.description = $(
													"#description").val();
											seoBO.seoId = $("#seoId").val();
											seoBO.metaTitle = $("#metatagtitle")
													.val();
											seoBO.metaDescription = $(
													"#metatagdescription")
													.val();
											seoBO.metaKeyword = $(
													"#metatagkeyword").val();
											informationBO.sortOrder = $(
													"#sortorder").val();
											informationBO.isActive = $(
													"#status").val();
											informationBO.seoBO = seoBO;
											postData = JSON
													.stringify(informationBO);
											alert("information object"
													+ postData);
											$
													.ajax({
														url : "../information/addInformation",
														type : "post",
														data : postData,
														contentType : "application/json",
														dataType : "json",
														success : function(data) {
															if (data.result == true) {
																var informationBO = data.informationBO;
																alert(informationId);
																$("input[id=informationId]").val(informationBO.informationId);
																$("input[id=seoId]").val(informationBO.seoBO.seoId);
																alert("saved succefully");
															} else {
																alert("Details failed to save");
															}
														}
													});
										});
					});
</script>