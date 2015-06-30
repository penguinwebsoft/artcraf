<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />
<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Attribute Page</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/addAttribute">Add</a>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Attribute List
				</h3>
			</div>
			<!-- Table Section-->
			<div class="container-fluid" style="background-color: white;">
				<div class="container">
					<div class="tab-pane" id="tab-shipping">
						<div class="table-responsive">
							<table id="attributeListTbl" class="table table-striped table-bordered table-hover pull-left">
								<thead>
									<tr>
										<td>Select</td>
										<td>Attribute Name</td>
										<td>Categories</td>
										<td>Sub-Categories</td>
										<td>Sort Order</td>
										<td>Action</td>
									</tr>
								</thead>
							</table>
						</div>
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
						$.ajax({
							url : "../attribute/getAttributes",
							type : "get",
							contentType : "application/json",
							dataType : "json",
							success : function(data) {
								attributeBOs = data.attributes;
								displayAttributes(attributeBOs);
							}
						});

						function displayAttributes(attributeBOs) {
							$
									.each(
											attributeBOs,
											function(index, attributeBO) {
												$("#attributeListTbl")
														.append(
																"<tr><td><input type='checkbox' name='myTextEditBox' value='checked' /></td><td>"
																		+ attributeBO.attributeName
																		+ "<\/td><td>"
																		+ attributeBO.categoryBO.categoryName
																		+ "<\/td><td>"
																		+ attributeBO.subCategoryBO.categoryName
																		+ "<\/td><td>"
																		+ attributeBO.sortOrder
																		+ "<\/td> <td><a class='btn btn-warning' href='${baseURL}/attribute/editAttribute?attributeId="+attributeBO.attributeId+"'>Edit</a></td> <\/tr>");
											});
						}
					});

	setPage("attributePageMenuId");
</script>