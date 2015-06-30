<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<hr style="border-color: #332619; margin-top: 1px;">
<!-- BEGIN BODY -->
<div class="col-md-3">
	<!-- Nav tabs -->
	<div class="nav-side-menu" style="background-color:#332619">
	<li data-toggle="collapse" data-target="#customerPanel"><a href="#"> Customer Panel </a></li>
		<i class="brand fa fa-bars fa-1x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
		<div class="menu-list">
			<ul id="menu-content" class="menu-content collapse out">
				<li data-toggle="collapse" data-target="#myAccount" class="tree-toggle nav-header"><a href="#"> My Account </a></li>
				<ul class="nav nav-list tree" id="myAccount">
					<li id="customerDetails"><a href="${baseURL}/customer/customerDetails">Personal Details</a></li>
					<li id="customerAddressContact"><a href="${baseURL}/customer/addressContacts">Addresses</a></li>
					<li id="customerProfileSetting"><a href="${baseURL}/customer/profileSettings">Profile setting</a></li>
					<li id="CustomermanageEmail"><a href="${baseURL}/customer/manageEmail">Update Email</a></li>
					<li id="CustomerChangePassword"><a href="${baseURL}/customer/changePassword">Change Password</a></li>
					<li id="CustomerdeactivateAccount"><a href="${baseURL}/customer/deactivateAccount">Deactivate Account</a></li>
				</ul>
				<li data-toggle="collapse" data-target="#order" class="tree-toggle nav-header"><a href="#"> Order </a></li>
				<ul class="nav nav-list tree" id="order">
					<li id="customerMyOrder"><a href="${baseURL}/customer/orderSection">My Order</a></li>
				</ul>
				<li data-target="#reviewAndRatting" data-toggle="collapse" class="tree-toggle nav-header"><a href="#"> Review And Ratting </a></li>
				<ul class="nav nav-list tree" id="reviewAndRatting">
					<li id="customerReviewAndRating"><a href="${baseURL}/customer/reviewSection">Review</a></li>
				</ul>
				<li data-target="#service" data-toggle="collapse" class="tree-toggle nav-header"><a href="#"> Support </a></li>
				<ul class="nav nav-list tree" id="service">
					<li id="contactSeller"><a href="">Contact Seller</a></li>
					<li id="customerCare"><a href="${baseURL}/customer/customerCareSection">Customer Care</a></li>
				</ul>
			</ul>
		</div>
	</div>
</div>

<!-- put this script for customer care section only, remove this script after adding to customer care jsp -->
<!-- <script type="text/javascript">
	$(document).ready(function() {

		/**********customer care section disable enable tab section*****************/
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