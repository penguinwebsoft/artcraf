<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<title>Crafart Login Page</title>

<link rel="stylesheet" href="${context}/resources/plugins/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${context}/resources/plugins/Font-Awesome/css/font-awesome.css" />
<link rel="stylesheet" href="${context}/resources/css/main.css" />
<link rel="stylesheet" href="${context}/resources/css/login.css" />
<link rel="stylesheet" href="${context}/resources/plugins/magic/magic.css" />
<link rel="stylesheet" href="${context}/resources/plugins/validationengine/css/validationEngine.jquery.css" />

<!--START SCRIPTS -->
<script src="${context}/resources/javascript/jquery-core/jquery-1.11.0.min.js"></script>
<script src="${context}/resources/javascript/jquery-ui-1.10.3/ui/jquery-ui.min.js"></script>
<script src="${context}/resources/javascript/menuHighlight/highlight.js"></script>
<script src="${context}/resources/javascript/validationInit.js"></script>
<script src="${context}/resources/javaScript/login.js"></script>
<script src="${context}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${context}/resources/plugins/validationengine/js/jquery.validationEngine.js"></script>
<script src="${context}/resources/plugins/validationengine/js/languages/jquery.validationEngine-en.js"></script>
<script src="${context}/resources/plugins/jquery-validation-1.11.1/dist/jquery.validate.min.js"></script>
</head>

<!-- BEGIN BODY -->
<body>
	<div id="container">
		<header id="header" class="navbar navbar-static-top">
			<div class="navbar-header">
				<a href="#" class="navbar-brand" style="padding: 5px;"><img src="${context}/resources/img/logo1.png" alt="" title="" /></a>
			</div>
		</header>
		<div class="tab-content" style="border: none;">
			<div id="login" class="tab-pane active">

				<div class="row">
					<div class="col-sm-offset-4 col-sm-4">
						<div class="panel panel-default" style="margin-bottom: 1px;">
							<div class="panel-heading">
								<h1 class="panel-title">
									<i class="icon-lock"></i> Please enter your login details.
								</h1>
							</div>
							<div class="panel-body">
								<form action="${baseURL}/menu/dashboard" class="form-signin">
									<div class="form-group">
										<label for="input-username">Username</label>
										<div class="input-group">
											<span class="input-group-addon"><i class="icon-user"></i></span> <input type="text" name="username" value="" placeholder="Username" id="input-username" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label for="input-password">Password</label>
										<div class="input-group">
											<span class="input-group-addon"><i class="icon-lock"></i></span> <input type="password" name="password" value="" placeholder="Password" id="input-password" class="form-control" />
										</div>
									</div>
									<div class="text-right">
										<button type="submit" class="btn btn-primary">
											<i class="icon-key"></i> Sign in
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div id="forgot" class="tab-pane">
				<div class="row">
					<div class="col-sm-offset-4 col-sm-4">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h1 class="panel-title">
									<i class="icon-repeat"></i> Forgot Your Password?
								</h1>
							</div>
							<div class="panel-body">
								<form action="${baseURL}/menu/dashboard" class="form-signin">
									<div class="form-group">
										<label for="input-email">E-Mail Address</label>
										<div class="input-group">
											<span class="input-group-addon"><i class="icon-envelope-alt"></i></span> <input type="email" name="email" value="" placeholder="E-Mail Address" id="input-email" class="form-control" />
										</div>
									</div>

									<div class="text-right">
										<button type="submit" class="btn btn-primary">
											<i class="fa fa-check"></i> Reset
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="text-center">
			<ul class="list-inline">
				<li><a class="text-muted" href="#login" data-toggle="tab">Login</a></li>
				<li><a class="text-muted" href="#forgot" data-toggle="tab">Forgot Password</a></li>
			</ul>
		</div>
	</div>
</body>
</html>


