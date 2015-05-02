<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<script type="text/javascript">
	$(document).ready(function() {

		$("#dp2").datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$('#dp2').on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$('#dp2').datepicker('hide');
			}
		});
	});
</script>


<hr style="border-color: #332619; margin-top: 1px;">

<div class="row-fluid">
	<div class="col-lg-5" style="margin-left: 8%;">
		<div class="row">
			<h4 style="margin-bottom: 20px;">Login</h4>
			<h5 style="margin-bottom: 20px;">What is your e-mail address?</h5>
			<form class="form-horizontal" action="#" id="CustomerRegistrationId" style="margin-bottom: 20px;">
				<div class="form-group">
					<div class="col-sm-4" style="width: 25%; padding-right: 0px; margin-left: 7%;">
						<label for="loginId" class="control-label">My e-mail address is:</label>
					</div>
					<div class="col-sm-5" style="padding-left: 0;">
						<input type="text" class="form-control" id="loginId" placeholder="Login Name">
					</div>
				</div>
			</form>
			<div class="row" style="padding-left: 4%; margin-bottom: 15px;">
				<label for="loginId" class="control-label">Do you have an crafart password?</label>
			</div>
			<div class="row" style="padding-left: 8%; margin-bottom: 15px;">
				<input type="radio" name="sex" value="male" style="margin-bottom: 15px;">No, I am a new customer<br>
				<div class="row" style="margin-bottom: 15px;">
					<div class="col-sm-4" style="width: 28%; padding-right: 0px;">
						<input type="radio" name="sex" value="female">Yes, I have a password:
					</div>
					<div class="col-sm-5" style="padding-left: 0;">
						<input type="password" id="userPasswordId" name="Password" class="form-control" placeholder="Password" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-2">
					<a class="btn btn-success btn-flat" href="#" style="border-radius: 0px;">&nbsp;&nbsp;Login&nbsp;&nbsp;</a>
				</div>
			</div>
		</div>
	</div>

	<div class="verticalLine col-sm-1" style="height: 320px; width: 2%;"></div>

	<div class="col-lg-5 col-sm-offset-1" style="margin-left: 6%;">
		<br>
		<div class="row">
			<h4>Social login</h4>
		</div>
		<div class="row">
			<div class="col-sm-5" style="margin-bottom: 15px;">
				<a class="btn btn-block btn-social btn-google-plus" style="border-radius: 0px;"> <i class="icon-google-plus"></i> Sign in with Google
				</a>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-5">
				<a class="btn btn-block btn-social btn-facebook" style="border-radius: 0px;"> <i class="icon-facebook"></i> Sign in with Facebook
				</a>
			</div>
		</div>
	</div>
</div>