<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Add Email List</h1>
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
					<i class="icon-th-list"></i> &nbsp;Add Email List
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;"><span data-toggle="tooltip" title="fromemail">From Email</span></label>
								<div class="col-sm-5">
									<input type="text" name="fromemail" value="" placeholder="fromemil" id="input-fromemail" class="form-control" />
								</div>
								Enter your Email address should be Email send from.
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;"><span data-toggle="tooltip" title="fromname">From Name</span></label>
								<div class="col-sm-5">
									<input type="text" name="fromname" value="" placeholder="fromname" id="input-fromname" class="form-control" />
								</div>
								Enter your Name that Email should be send from.
							</div>
							<h2>SMTP Options</h2>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;"><span data-toggle="tooltip" title="smtphost">SMTP Host</span></label>
								<div class="col-sm-5">
									<input type="text" name="smtphost" value="" placeholder="smtphost" id="input-smtphost" class="form-control" />
								</div>
								Enter your SMTP host name,Like for example google smtp host is smtp.gmail.com
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;"><span data-toggle="tooltip" title="smtpport">SMTP Port</span></label>
								<div class="col-sm-5">
									<input type="text" name="smtpport" value="" placeholder="smtpport" id="input-smtpport" class="form-control" />
								</div>
								Enter your SMTP Server port like for example google smtp port is <465>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label" for="encryption">Encryption</label>
								<div class="col-sm-10">
									<select name="encryption" id="input-encryption" placeholder="---please select---" class="form-control">
										<option value="0" selected="selected">No Encryption</option>
										<option value="1">Use SSL encryption</option>
										<option value="2">Use TLS encryption</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="form-group">
									<label class="col-sm-2 control-label" for="authentication">Authentication</label>
								</div>
								<div class="radio col-md-offset-2">
									<label> <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>No:Do Not Use SMTP authentication
									</label>
								</div>
								<div class="radio col-md-offset-2">
									<label> <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" checked>Yes:Use SMTP authentication
									</label>
								</div>
								<div class="col-md-offset-2">If this set to no,the values below are ignored.</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;"><span data-toggle="tooltip" title="username">User Name</span></label>
								<div class="col-sm-5">
									<input type="text" name="username" value="" placeholder="username" id="input-username" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="padding-top: 1px;"><span data-toggle="tooltip" title="password">Password</span></label>
								<div class="col-sm-5">
									<input type="text" name="password" value="" placeholder="password" id="input-password" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="status">Status</label>
								<div class="col-sm-10">
									<select name="encryption" id="input-encryption" placeholder="---please select---" class="form-control">
										<option value="0" selected="selected">Enable</option>
										<option value="1">Disable</option>
									</select>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

