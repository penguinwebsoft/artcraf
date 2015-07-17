<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Add User List</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
			<button type="button" name="saveBtn" id="saveBtn" class="btn btn-success">Save</button>
				<button type="button" class="btn btn-default">Cancel</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp;Add User List
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="username"><span data-toggle="tooltip" title="username">User Name</span></label>
								<div class="col-sm-10">
									<input type="text" id="username"name="username" value="" placeholder="username" id="username" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="firstname"><span data-toggle="tooltip" title="firstname">First Name</span></label>
								<div class="col-sm-10">
									<input type="text" id="firstname"name="firstname" value="" placeholder="firstname" id="firstname" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="lastname"><span data-toggle="tooltip" title="lastname">Last Name</span></label>
								<div class="col-sm-10">
									<input type="text" id="lastname" name="lastname" value="" placeholder="lastname" id="lastname" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="password"><span data-toggle="tooltip" title="password">Password</span></label>
								<div class="col-sm-10">
									<input type="text" id="password" name="password" value="" placeholder="password" id="password" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">User Group</label>
								<div class="col-sm-10">
									<select name="permission" id="permission" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected"></option>
										<option value="0"></option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Status</label>
								<div class="col-sm-10">
									<select name="status" id="status" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">Enable</option>
										<option value="0">Disable</option>
									</select>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function() {
		$("#saveBtn").click(function() {
			var userBO = {};
			
			userBO. userName= $("#username").val();
			userBO.firstName= $("#firstname").val();
			userBO.lastName = $("#lastname").val();
			userBO.password =  $("#password").val();
			userBO.isActive =  $("#status").val();
		
			postData = JSON.stringify(userBO);
			alert("user object" + postData);
			$.ajax({
				url : "../user/addUser",
				type : "post",
				data : postData,
				contentType : "application/json",
				dataType : "json",
				success : function(data) {
					if(data.result == true)
						alert("saved succefully");
					else
						alert("Details failed to save");
				}
			});
		});
	});
</script>
<script type="text/javascript">
	setPage("userListPageMenuId");
	</script>