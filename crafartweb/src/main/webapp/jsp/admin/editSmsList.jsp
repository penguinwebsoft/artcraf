<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Edit Sms Page</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" class="btn btn-success">Save</button>
				<button type="button" class="btn">Return</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Edit Sms Page
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group required">
								<label class="col-sm-2 control-label">Sender Group Name</label>
								<div class="col-sm-10">
									<input type="text" name="sendergroupname" value="" placeholder="sendergroupname" id="input-sendergroupname" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Send To</label>
								<div class="col-sm-10">
									<select name="sendto" id="input-sendto" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">All Customer</option>
										<option value="2">Customer</option>
										<option value="3">All seller</option>
										<option value="4">Seller</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">User Name</span></label>
								<div class="col-sm-10">
									<input type="text" name="name" value="" placeholder="username" id="input-username" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Password</span></label>
								<div class="col-sm-10">
									<input type="text" name="pwd" value="" placeholder="password" id="input-password" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Sender Name</span></label>
								<div class="col-sm-10">
									<input type="text" name="sendername" value="" placeholder="sendername" id="input-sendername" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Sms API Url</span></label>
								<div class="col-sm-10">
									<input type="text" name="url" value="" placeholder="smsurl" id="input-smsurl" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Mobile Number</span></label>
								<div class="col-sm-10">
									<input type="text" name="mobileno" value="" placeholder="mobileno" id="input-mobileno" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Message</span></label>
								<div class="col-sm-4 well">
									<form accept-charset="UTF-8" action="" method="POST">
										<div class="col-sm-10">
											<textarea class="form-control" id="text" name="text" placeholder="Type in your message" rows="5"></textarea>
											<h6 class="pull-right" id="count_message"></h6>
										</div>
									</form>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Status</label>
								<div class="col-sm-10">
									<select name="text" id="input-status" placeholder="---please select---" class="form-control">
										<option value="1" selected="selected">Enable</option>
										<option value="2">Disable</option>
									</select>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$("#cleditor").cleditor();
	});
</script>

<script>
	var text_max = 200;
	$('#count_message').html(text_max + ' remaining');

	$('#text').keyup(function() {
		var text_length = $('#text').val().length;
		var text_remaining = text_max - text_length;

		$('#count_message').html(text_remaining + ' remaining');
	});
</script>