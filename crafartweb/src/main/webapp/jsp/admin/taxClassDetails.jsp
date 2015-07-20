<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Tax Details</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/addTaxClass">Add</a>
				<button type="button" class="btn btn-danger">Cancel</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Tax Details
				</h3>
			</div>
			<!-- Table Section-->
			<div class="container">
				<div class="tab-pane" id="tab-shipping">
					<div class="table-responsive">
						<table id="taxClasses" class="table table-striped table-bordered table-hover pull-left">
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Tax Title</td>
									<td>Tax Description</td>
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

<script type="text/javascript">
	setPage("taxDetailsMenuId");

	$(document)
			.ready(
					function() {
						$.ajax({
							url : "../taxClass/getTaxClass",
							type : "GET",
							contentType : "application/json",
							dataType : "json",
							success : function(data) {
								displaytaxClassList(data.taxClassBOs)
							}
						});
						function displaytaxClassList(taxClassBOs) {
							$
									.each(
											taxClassBOs,
											function(key, value) {
												var taxClassBO = value;
												var html = '<tr>';
												html += '<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>';
												html += '<td>'
														+ taxClassBO.title
														+ '</td>';
												html += '<td>'
														+ taxClassBO.description
														+ '</td>';
												html += '<td>'
														+ taxClassBO.sortOrder
														+ '</td>';
												html += "<td><a class='btn btn-warning' href='${baseURL}/taxClass/editTaxClass?taxClassId="
														+ taxClassBO.taxClassId
														+ "'>Edit</button></td>";
												html += '</tr>';
												$('#taxClasses').append(html);
											});
						}
					});
</script>