<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<title>Crafart Third Party Login</title>

<link rel="stylesheet" href="${context}/resources/plugins/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${context}/resources/plugins/Font-Awesome/css/font-awesome.css" />
<link rel="stylesheet" href="${context}/resources/css/main.css" />
<link rel="stylesheet" href="${context}/resources/css/login.css" />
<link rel="stylesheet" href="${context}/resources/plugins/magic/magic.css" />
<link rel="stylesheet" href="${context}/resources/plugins/validationengine/css/validationEngine.jquery.css" />
<link rel="stylesheet" href="${context}/resources/plugins/datepicker/css/datepicker.css" />
<!--START SCRIPTS -->
<script src="${context}/resources/javascript/jquery-core/jquery-1.11.0.min.js"></script>
<script src="${context}/resources/javascript/jquery-ui-1.10.3/ui/jquery-ui.min.js"></script>
<script src="${context}/resources/javascript/menuHighlight/highlight.js"></script>
<script src="${context}/resources/javascript/validationInit.js"></script>
<script src="${context}/resources/javascript/login.js"></script>
<script src="${context}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${context}/resources/plugins/validationengine/js/jquery.validationEngine.js"></script>
<script src="${context}/resources/plugins/validationengine/js/languages/jquery.validationEngine-en.js"></script>
<script src="${context}/resources/plugins/jquery-validation-1.11.1/dist/jquery.validate.min.js"></script>
<script src="${context}/resources/plugins/datepicker/js/bootstrap-datepicker.js"></script>
</head>
<script type="text/javascript">
$(document).ready(
		function() {
	$("#loginButton")
			.click(
					function() {
						var customerBO = {};
						var contactBOs = new Array();
						var contactBO = {};
						var addressBO = {};
						var contactBO1 = {};

						customerBO.firstName = sessionStorage.getItem("firstName");
						customerBO.password = sessionStorage.getItem("id");
						customerBO.gender = ((sessionStorage.getItem("gender") == "male") ? 1 : 0);
						contactBO.contactValue = sessionStorage.getItem("email");
						contactBO.contactTypeId = 3;
						contactBOs.push(contactBO);
						contactBO1.contactValue = $("#mobileNumber").val();
						contactBO1.contactTypeId = 1;
						contactBOs.push(contactBO1);
						customerBO.contactBOs = contactBOs;
						customerBO.addressBO = addressBO;
						postData = JSON.stringify(customerBO);
						alert(postData);
						$.ajax({
							url : "../customer/addcustomer",
							type : "post",
							data : postData,
							contentType : "application/json",
							dataType : "json",
							success : function(data) { 
								if (data.result) {
									alert(data.message);
									window.location.replace(data.redirect);
								} else
									alert(data.message);
							}

						});
					});
		});
</script>


<div class="container-fluid" style="padding-right: 15px; padding-left: 15px; margin-right: auto; margin-left: auto;">
	<div class="row">
		<div class="col-md-3 col-md-offset-4 brdBlack" style="margin-top: 20%">
			<div>
				<h4>social login</h4>
				<div class="form-group">
					<label for="" class="control-label">Mobile No</label> <input type="text" id="mobileNumber" name="mobileNumber" class="form-control" placeholder="Mobile No" />
				</div>
				<span class=""> <a class="btn btn-success btn-flat" href="#" id="loginButton" style="border-radius: 0px;">&nbsp;&nbsp;Login&nbsp;&nbsp;</a>
				</span>

			</div>
		</div>
		<div class="col-md-5" style="margin-top: 20%"></div>
	</div>
</div>
</html>
