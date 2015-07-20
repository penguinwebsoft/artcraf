<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Length Details</h1>
			</div>

			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/addLengthDetails">Add</a>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>

		<!-- Table Section-->
		<div class="container-fluid" style="background-color: white;">
			<div class="container">
				<div class="tab-pane" id="tab-shipping">
					<div class="table-responsive">
						<table id="lengthClassList" class="table table-striped table-bordered table-hover pull-left">
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Title</td>
									<td>Unit</td>
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
	setPage("lengthDetailsMenuId");
	$(document)
			.ready(
					function() {
						$.ajax({
							url : "../lengthClass/getLengthClasses",
							type : "get",
							contentType : "application/json",
							dataType : "json",
							success : function(data) {
								displayLengthClassList(data.lengthClassBOs);
							}
						});
						function displayLengthClassList(lengthClassBOs) {
							$
									.each(
											lengthClassBOs,
											function(key, lengthClassBO) {
												var html = '<tr>';
												html += '<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>';
												html += '<td>'
														+ lengthClassBO.title
														+ '</td>';
												html += '<td>'
														+ lengthClassBO.unit
														+ '</td>';
												html += '<td>'
														+ lengthClassBO.sortOrder
														+ '</td>';
												html += "<td><a class='btn btn-warning' href='${baseURL}/lengthClass/editLengthClass?lengthClassId="
														+ lengthClassBO.lengthClassId
														+ "'>Edit</button></td>";
												html += '</tr>';
												$('#lengthClassList').append(
														html);
											});
						}
					});
</script>