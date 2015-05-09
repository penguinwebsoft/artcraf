<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<hr style="border-color: #332619; margin-top: 1px;">
<!-- BEGIN BODY -->
<div class="col-md-4">
	<!-- Nav tabs -->
	<div class="nav-side-menu col-lg-offset-2">
		<div class="brand">Customer Panel</div>
		<i class="brand fa fa-bars fa-1x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
		<div class="menu-list">
			<ul id="menu-content" class="menu-content collapse out">
				<li data-toggle="collapse" data-target="#myAccount" class="collapsed active"><a href="#"> My Account </a></li>
				<ul class="sub-menu" id="myAccount">
					<li id="customerPersonalDetails"><a href="${baseURL}/customerMenu/customerDetails">Personal Details</a></li>
					<li id="customerAddresses"><a href="${baseURL}/customerMenu/addressContacts">Addresses</a></li>
					<li id="customerProfileSetting"><a href="${baseURL}/customerMenu/profileSettings">Profile setting</a></li>
					<li id="CustomerUpdateEmail"><a href="${baseURL}/customerMenu/manageEmail">Update Email</a></li>
					<li id="CustomerChangePassword"><a href="#">Change Password</a></li>
					<li id="CustomerDeactivateAccount"><a href="#">Deactivate Account</a></li>
				</ul>
				<li data-toggle="collapse" data-target="#order" class="collapsed active"><a href="#"> Order </a></li>
				<ul class="sub-menu" id="order">
					<li id="customerMyOrder"><a href="#">My Order</a></li>
				</ul>
				<li data-target="#reviewAndRatting" data-toggle="collapse" class="collapsed active"><a href="#"> Review And Ratting </a></li>
				<ul class="sub-menu" id="reviewAndRatting">
					<li id="customerReviewAndRating"><a href="#">Review</a></li>
				</ul>
				<li data-target="#service" data-toggle="collapse" class="collapsed active"><a href="#"> Support </a></li>
				<ul class="sub-menu" id="service">
					<li id="contactSeller">Contact Seller</li>
					<li id="customerCare">Customer Care</li>
				</ul>
			</ul>
		</div>
	</div>
</div>


<!-- put this script for customer care section only, remove this script after adding to customer care jsp -->
<!-- <script type="text/javascript">
	$(document).ready(function() {

		/**********customer care section disbale enable tab section*****************/
		var clickEvent = false;

		$("#customerCareTabs .nav a").click(function(e) {
			e.preventDefault();
			$(this).tab('show');
		});

		/**********customer care section disbale enable tab section*****************/

		/***************need assistance tab enable*****************************************/

		$(document).on('click', function(e) {
			if ($(e.target).closest('#tab-one li a').length) {
				$("#assistanceTab").show();
			} else if (!$(e.target).closest('#assistanceTab').length) {
				$('#assistanceTab').hide();
			}
		});

		/***************need assistance tab2 enable*****************************************/
	});
</script> -->