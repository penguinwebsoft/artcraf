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

<!-- CSS SCRIPTS -->
<link rel="stylesheet" href="${context}/resources/plugins/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${context}/resources/plugins/Font-Awesome/css/font-awesome.css" />
<link rel="stylesheet" href="${context}/resources/plugins/social-buttons/social-buttons.css" />
<link rel="stylesheet" href="${context}/resources/css/customerStyle.css" />
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

<!-- CSS SCRIPTS -->

<!--START SCRIPTS -->
<script src="${context}/resources/javascript/jquery-core/jquery-1.11.0.min.js"></script>
<script src="${context}/resources/javascript/jquery-ui-1.10.3/ui/jquery-ui.min.js"></script>
<script src="${context}/resources/javascript/menuHighlight/highlight.js"></script>
<script src="${context}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				/********************Adding body background image on load of document******************/

				var imageURL = "url(" + $('#bgImage').val()
						+ "/resources/img/background_img.jpg)";

				$('body').css('background', imageURL);

				/********************Adding body background image on load of document******************/

			});
</script>

<!-- END SCRIPTS -->
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="padTop53 ">
	<input type="hidden" id="bgImage" value="${context}" />
	<!-- MAIN WRAPPER -->
	<div id="wrap" class="container-fluid">

		<!-- HEADER SECTION -->
		<header id="header" class="row-fluid">
			<tiles:insertAttribute name="header" />
		</header>
		<!-- END HEADER SECTION -->

		<!-- MENU SECTION -->
		<%-- 		<div id="left">
			<tiles:insertAttribute name="menu" />
		</div> --%>
		<!--END MENU SECTION -->

		<!--PAGE CONTENT -->
		<section id="content" class="row-fluid clearfix">
			<tiles:insertAttribute name="body" />
		</section>
		<!--END PAGE CONTENT -->

		<!--END MAIN WRAPPER -->

		<!-- FOOTER -->
		<footer id="footers" class="row-fluid clearfix">
			<tiles:insertAttribute name="footer" />
		</footer>
		<!--END FOOTER -->
	</div>

</body>
</html>