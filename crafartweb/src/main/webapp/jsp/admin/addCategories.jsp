<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" /> 
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Add Categories</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" class="btn btn-success">Save</button>
				<button type="button" class="btn btn-warning">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Add New Categories
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
								<li class="active" id="tabGeneral"><a data-toggle="tab" href="#tab-general">General</a></li>
								<li id="tabImage"><a data-toggle="tab" href="#tab-image">Image</a></li>
							</ul>
							<div class="tab-content">
								<!-- General tab-data-->
								<div class="tab-pane fade in active" id="tab-general">
									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-model">Category Name</label>
										<div class="col-sm-10">
											<input type="text" name="name" value="" placeholder="name" id="input-name" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-meta-description1">Description</label>
										<div class="col-sm-10">
											<textarea name="description[1][description]" rows="5" placeholder="description" id="description" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-model">Meta Tag Title</label>
										<div class="col-sm-10">
											<input type="text" name="metatagtitle" value="" placeholder="metatagtitle" id="input-metatagtitle" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-meta-description1">Meta tag Description</label>
										<div class="col-sm-10">
											<textarea name="metatagdescription[1][metatagdescription]" rows="5" placeholder="metatagdescription" id="description" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-metatagkeyword">Meta Tag Keyword</label>
										<div class="col-sm-10">
											<textarea name="metatagkeyword[1][metatagkeyword]" rows="5" placeholder="metatagkeyword" id="metatagkeyword" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">SORTorder</label>
										<div class="col-sm-10">
											<select name="status" id="input-status" placeholder="---please select---" class="form-control">
												<option value="1" selected="selected"></option>
												<option value="0"></option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">Status</label>
										<div class="col-sm-10">
											<select name="status" id="input-status" placeholder="---please select---" class="form-control">
												<option value="1" selected="selected">Enable</option>
												<option value="0">Disable</option>
											</select>
										</div>
									</div>

								</div>

								<!-- Design tab-data-->
								<div class="tab-pane fade" id="tab-image">
									<div class="table-responsive">
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-image">Image</label>
											<div class="col-sm-10">
												<a class="user-link" href="#"> <img class="media-object img-thumbnail user-img" alt="User Picture" src="${context}/resources/img/user.gif"></a>
												<button type="button" class="btn btn-primary" style="margin-top: 1%">Upload Photo</button>
											</div>
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