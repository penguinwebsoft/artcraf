<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Commission List</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/commissionPage">Add</a>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Commission List
				</h3>
			</div>
			<!-- Table Section-->
			<div class="container">
				<div class="tab-pane" id="tab-shipping">
					<div class="table-responsive">
						<table id="shipping" class="table table-striped table-bordered table-hover pull-left">
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Commission Name</td>
									<td>Commission Type</td>
									<td>Seller Name</td>
									<td>Rate</td>
									<td>Sort Order</td>
									<td>Action</td>
								</tr>
							</thead>
							</table>
						<nav>
							<ul class="pagination">
								<li class="disabled"><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
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
				url : "../commission/getCommission",
				type : "get",
				contentType : "application/json",
				dataType : "json",
				success : function(data) {
					commisionBOs = data.commisionBOs;
					displayCommisionList(commisionBOs);
				}
			});
			function displayCommisionList(commisionBOs) {
				$
						.each(commisionBOs,	function(key, value) {
									var commisionBOs = value;
									var html = '<tr>';
									html += '<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>';
									html += '<td>'
											+ categoryBO.name
											+ '</td>';
									html += '<td>'
											+ categoryBO.sortOrder
											+ '</td>';
									html += "<td><a class='btn btn-warning' href='${baseURL}/category/editCategory?categoryId="+categoryBO.categoryId+"'>Edit</button></td>";
									html += '</tr>';
									$('#shipping').append(
											html);
								});
			}
		});
	setPage("commissionListMenuId");
</script>