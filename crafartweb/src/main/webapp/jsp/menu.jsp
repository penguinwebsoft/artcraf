<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<c:set var="baseURL"
	value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />


<!-- MENU SECTION -->
<div class="media user-media well-small">
	<a class="user-link" href="#"> <img
		class="media-object img-thumbnail user-img" alt="User Picture"
		src="${context}/resources/img/user.gif" />
	</a> <br />
	<div class="media-body">
		<h5 class="media-heading">Joe Romlin</h5>
	</div>
	<br />
</div>
<ul id="menu" class="collapse" id="sampleTabs"
	style="background-color: #333;">
	<li class="panel active" id="dashboardMenuId"><a
		href="${baseURL}/menu/dashboard"> <i class="icon-table"></i>
			Dashboard
	</a></li>
	<li class="panel" id="myprofileMenuId"><a href="#"
		data-parent="#menu" data-toggle="collapse" class="accordion-toggle"
		data-target="#component-nav"> <i class="icon-tasks"> </i> My
			Profile <span class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp; <span class="label label-default"></span>&nbsp;
	</a>
		<ul class="collapse" id="component-nav">
			<li class="" id="myAccountMenuId"><a
				href="${baseURL}/menu/myAccount"><i class="icon-angle-right"></i>
					My Account </a></li>
			<li class="" id="bankDetailsMenuId"><a
				href="${baseURL}/menu/bankDetails"><i class="icon-angle-right"></i>
					Bank Details </a></li>
			<li class="" id="shippingMenuId"><a
				href="${baseURL}/menu/shipping"><i class="icon-angle-right"></i>
					Shipping and Return Policy </a></li>
			<li class="" id="TaxInformationMenuId"><a
				href="${baseURL}/menu/taxInformation"><i
					class="icon-angle-right"></i> Tax Information </a></li>
		</ul></li>
	<li class="panel" id="MyProductMenuId"><a
		href="${baseURL}/menu/product"><i class="icon-signin"> </i> My
			Products </a></li>
</ul>
<!--END MENU SECTION -->