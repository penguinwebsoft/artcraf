<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Add User Group</h1>
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
					<i class="icon-th-list"></i> &nbsp;Add User Group
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;" for="usergroupname"><span data-toggle="tooltip" title="rrm">User Group Name</span></label>
								<div class="col-sm-10">
									<input type="text" id="usergroupname"name="usergroupname" value="" placeholder="usergroupname" id="rrm" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Permission</label>
								<div class="col-sm-10">
									<select id="permission"multiple class="form-control">
										<option>Dashboard</option>
										<option>Catalog</option>
										<option>Sales</option>
										<option>Sellers</option>
										<option>Marketing</option>
										<option>System</option>
										<option>Reports</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-sortorder"><span data-toggle="tooltip" title="Force a minimum ordered amount">SortOrder</span></label>
								<div class="col-sm-10">
									<input type="number" id="sortorder"name="sortorder" value="" placeholder="sortorder" id="input-sortorder" class="form-control" />
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
			var userGroupBO = {};
			
			userGroupBO. userName= $("#usergroupname").val();
			userGroupBO.permission= $("#permission").val();
			userGroupBO.sortOrder = $("#sortorder").val();
			
			
			postData = JSON.stringify(userGroupBO);
			alert("userGroup object" + postData);
			$.ajax({
				url : "../userGroup/addUserGroup",
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