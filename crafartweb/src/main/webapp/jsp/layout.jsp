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
	<link rel="stylesheet" href="${context}/resources/css/main.css" />
	<link rel="stylesheet" href="${context}/resources/css/theme.css" />
	<link rel="stylesheet" href="${context}/resources/css/MoneAdmin.css" />
	<link rel="stylesheet" href="${context}/resources/plugins/Font-Awesome/css/font-awesome.css" />
	<link rel="stylesheet" href="${context}/resources/plugins/fonts/font-awesome.css" />
	
	<link href="${context}/resources/css/layout2.css" rel="stylesheet" />
	<link href="${context}/resources/plugins/flot/examples/examples.css" rel="stylesheet" />
	<link rel="stylesheet" href="${context}/resources/plugins/timeline/timeline.css" />
			     
	<link rel="stylesheet" href="${context}/resources/plugins/validationengine/css/validationEngine.jquery.css" />
	   
	<!--START SCRIPTS --> 
	<script src="${context}/resources/plugins/jquery-2.0.3.min.js"></script> 
	<script src="${context}/resources/plugins/bootstrap/js/bootstrap.min.js"></script> 
	<script src="${context}/resources/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script> 
	
	<script src="${context}/resources/plugins/flot/jquery.flot.js"></script> 
	<script src="${context}/resources/plugins/flot/jquery.flot.resize.js"></script> 
	<script src="${context}/resources/plugins/flot/jquery.flot.time.js"></script> 
	<script src="${context}/resources/plugins/flot/jquery.flot.stack.js"></script> 
	<script src="${context}/resources/javascript/for_index.js"></script> 
	
	<script  src="${context}/resources/plugins/flot/jquery.flot.categories.js"></script> 
	<script src="${context}/resources/plugins/dataTables/jquery.dataTables.js"></script> 
	<script src="${context}/resources/plugins/dataTables/dataTables.bootstrap.js"></script>	
	
	<script src="${context}/resources/plugins/validationengine/js/jquery.validationEngine.js"></script> 
	<script src="${context}/resources/plugins/validationengine/js/languages/jquery.validationEngine-en.js"></script> 
	<script src="${context}/resources/plugins/jquery-validation-1.11.1/dist/jquery.validate.min.js"></script> 
	<script src="${context}/resources/javascript/validationInit.js"></script>  

	<!-- END SCRIPTS --> 


	<script type="text/javascript">
	$(function () { 
		formValidation(); 
	   	$("ul#sampleTabs li.active");
	});
	</script>
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="padTop53 " >

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
