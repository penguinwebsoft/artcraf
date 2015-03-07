<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

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
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link rel="stylesheet" href="${context}/resources/plugins/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${context}/resources/plugins/Font-Awesome/css/font-awesome.css" />
<link rel="stylesheet" href="${context}/resources/css/main.css" />
<link rel="stylesheet" href="${context}/resources/css/MoneAdmin.css" />
<link rel="stylesheet" href="${context}/resources/css/layout2.css" />
<link rel="stylesheet" href="${context}/resources/css/jquery.cleditor-hack.css" />
<link rel="stylesheet" href="${context}/resources/css/bootstrap-wysihtml5-hack.css" />
<link rel="stylesheet" href="${context}/resources/javascript/jquery-ui-1.10.3/themes/base/jquery-ui.css" type="text/css">
<link rel="stylesheet" href="${context}/resources/javascript/jquery-ui-1.10.3/themes/base/jquery.ui.accordion.css" type="text/css">
<link rel="stylesheet" href="${context}/resources/plugins/flot/examples/examples.css" />
<link rel="stylesheet" href="${context}/resources/plugins/timeline/timeline.css" />
<link rel="stylesheet" href="${context}/resources/plugins/dataTables/dataTables.bootstrap.css" />
<link rel="stylesheet" href="${context}/resources/plugins/datepicker/css/datepicker.css" />
<link rel="stylesheet" href="${context}/resources/plugins/validationengine/css/validationEngine.jquery.css" />
<link rel="stylesheet" href="${context}/resources/plugins/chosen/chosen.min.css" />
<link rel="stylesheet" href="${context}/resources/plugins/wysihtml5/dist/bootstrap-wysihtml5-0.0.2.css" />
<link rel="stylesheet" href="${context}/resources/plugins/CLEditor1_4_3/jquery.cleditor.css" />

<!--START SCRIPTS -->

<script src="${context}/resources/javascript/jquery-core/jquery-1.11.0.min.js"></script>
<script src="${context}/resources/javascript/jquery-ui-1.10.3/ui/jquery-ui.min.js"></script>
<script src="${context}/resources/javascript/menuHighlight/highlight.js"></script>
<script src="${context}/resources/javascript/validationInit.js"></script>
<script src="${context}/resources/javascript/editorInit.js"></script>
<script src="${context}/resources/javascript/formsInit.js"></script>
<script src="${context}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${context}/resources/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="${context}/resources/plugins/dataTables/jquery.dataTables.js"></script>
<script src="${context}/resources/plugins/dataTables/dataTables.bootstrap.js"></script>
<script src="${context}/resources/plugins/datepicker/js/bootstrap-datepicker.js"></script>
<script src="${context}/resources/plugins/validationengine/js/jquery.validationEngine.js"></script>
<script src="${context}/resources/plugins/validationengine/js/languages/jquery.validationEngine-en.js"></script>
<script src="${context}/resources/plugins/jquery-validation-1.11.1/dist/jquery.validate.min.js"></script>
<script src="${context}/resources/plugins/chosen/chosen.jquery.min.js"></script>
<script src="${context}/resources/plugins/wysihtml5/lib/js/wysihtml5-0.3.0.js"></script>
<script src="${context}/resources/plugins/bootstrap-wysihtml5-hack.js"></script>
<script src="${context}/resources/plugins/CLEditor1_4_3/jquery.cleditor.min.js"></script>

<%-- <script src="${context}/resources/plugins/flot/jquery.flot.js"></script> 
<script src="${context}/resources/plugins/flot/jquery.flot.resize.js"></script> 
<script src="${context}/resources/plugins/flot/jquery.flot.time.js"></script> 
<script src="${context}/resources/plugins/flot/jquery.flot.stack.js"></script> 
<script  src="${context}/resources/plugins/flot/jquery.flot.categories.js"></script> --%>

<!-- END SCRIPTS -->

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="padTop53 ">

	<!-- MAIN WRAPPER -->
	<div id="wrap">

		<!-- HEADER SECTION -->
		<div id="top">
			<tiles:insertAttribute name="header" />
		</div>
		<!-- END HEADER SECTION -->

		<!-- MENU SECTION -->
		<div id="left">
			<tiles:insertAttribute name="menu" />
		</div>
		<!--END MENU SECTION -->

		<!--PAGE CONTENT -->
		<div id="content">
			<tiles:insertAttribute name="body" />
		</div>
		<!--END PAGE CONTENT -->

		<!--END MAIN WRAPPER -->

		<!-- FOOTER -->
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
		<!--END FOOTER -->
	</div>

</body>
</html>


