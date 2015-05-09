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
	<div class="col-lg-5 col-lg-offset-1">
		<div class="row-fluid">
			<h4 style="margin-bottom: 20px;">Login</h4>
			<h5 style="margin-bottom: 20px;">What is your e-mail address?</h5>
			<form class="form-horizontal" action="#" id="CustomerRegistrationId" style="margin-bottom: 20px;">
				<div class="row">
					<div class="col-sm-4">
						<label for="loginId" class="control-label">My e-mail address is:</label>
					</div>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="loginId" placeholder="Login Name">
					</div>
				</div>
			</form>
			<div class="row-fluid">
				<label for="loginId" class="control-label">Do you have an crafart password?</label>
			</div>
			<div class="row-fluid">
				<input type="radio" name="sex" value="male" style="margin-bottom: 15px;">No, I am a new customer<br>
				<div class="row" style="margin-bottom: 15px;">
					<div class="col-sm-4">
						<input type="radio" name="sex" value="female">Yes, I have a password:
					</div>
					<div class="col-sm-6">
						<input type="password" id="userPasswordId" name="Password" class="form-control" placeholder="Password" />
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="col-sm-offset-8">
					<a class="btn btn-success btn-flat login-btn" href="#">Login</a>
				</div>
			</div>
		</div>
	</div>

	<div class="verticalLine col-sm-1 hidden-xs" style="height: 320px; width: 2%;"></div>

	<div class="col-lg-4 col-sm-offset-1">
		<br>
		<div class="row-fluid">
			<h4>Social login</h4>
		</div>
		<div class="row">
			<div class="col-sm-8" style="margin-bottom: 15px;">
				<a class="btn btn-block btn-social btn-google-plus" style="border-radius: 0px;"> <i class="icon-google-plus"></i> Sign in with Google
				</a>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-8">
				<a class="btn btn-block btn-social btn-facebook" style="border-radius: 0px;"> <i class="icon-facebook"></i> Sign in with Facebook
				</a>
			</div>
		</div>
	</div>
</div>