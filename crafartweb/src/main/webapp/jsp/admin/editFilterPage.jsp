<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Edit Filter Page</h1>
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
					<i class="icon-th-list"></i> &nbsp;Edit Filter List
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group">
								<label class="col-sm-2 control-label" for="categories">Categories</label>
								<div class="col-sm-10">
									<select name="categories" id="input-categories" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected"></option>
										<option value="0"></option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="categories">Sub Categories</label>
								<div class="col-sm-10">
									<select name="subcategories" id="input-subcategories" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected"></option>
										<option value="0"></option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-attributename"><span data-toggle="tooltip" title="filtername">Filter Name</span></label>
								<div class="col-sm-10">
									<input type="text" name="filtername" value="" placeholder="filtername" id="input-filtername" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-sortorder"><span data-toggle="tooltip" title="Force a minimum ordered amount">SortOrder</span></label>
								<div class="col-sm-10">
									<input type="number" name="sortorder" value="" placeholder="sortorder" id="input-sortorder" class="form-control" />
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	setPage("filterPageMenuId");
</script>
