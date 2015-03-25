<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<script>
	$(document).ready(function() {
		$('#dataTables-example').dataTable();

	});
</script>

<script type="text/javascript">
	setPage("viewedMenuId");
</script>

<div class="inner">
	<div class="row">
		<div class="col-sm-4">
			<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Products Viewed Report</h1>
		</div>
	</div>
	<hr />

	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="fa fa-list"></i> Products Viewed List
				</h3>
			</div>

			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<td class="text-left">Product Name</td>
								<td class="text-left">Model</td>
								<td class="text-right">Viewed</td>
								<td class="text-right">Percent</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-left">iPhone</td>
								<td class="text-left">product 11</td>
								<td class="text-right">361</td>
								<td class="text-right">9025%</td>
							</tr>
							<tr>
								<td class="text-left">Apple Cinema 30&quot;</td>
								<td class="text-left">n Product 15</td>
								<td class="text-right">191</td>
								<td class="text-right">4775%</td>
							</tr>
							<tr>
								<td class="text-left">MacBook</td>
								<td class="text-left">Product 16</td>
								<td class="text-right">138</td>
								<td class="text-right">3450%</td>
							</tr>
							<tr>
								<td class="text-left">iMac</td>
								<td class="text-left">Product 14</td>
								<td class="text-right">116</td>
								<td class="text-right">2900%</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-sm-6 text-left"></div>
					<div class="col-sm-6 text-right">Showing 1 to 4 of 4 (1 Pages)</div>
				</div>
			</div>
		</div>
	</div>
</div>







