<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<input type="hidden" id="sellerId" value="${sellerprofile.sellerId}" />
<%-- <div class="media user-media well-small" style="margin-top: 1px;">
	<a class="user-link" href="#"> <img class="media-object img-thumbnail user-img" alt="User Picture" src="${context}/resources/img/user.gif">
	</a> <br />
	<div class="media-body">
		<h5 class="media-heading">Joe Romlin</h5>
	</div>
	<br />
</div> --%>
<ul id="menu" class="collapse col-lg-2" id="sampleTabs" style="background-color: #333;">
	<li class="panel"><a id="dashboardMenuId" href="${baseURL}/menu/dashboard"> <i class="icon-table"></i> Dashboard
	</a></li>

	<li class="panel" id="catalogMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-catalog-nav"> <i class="icon-tasks"> </i> Catalog<span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-catalog-nav">
			<li><a id="categoriesMenuId" href="${baseURL}/menu/categories"> <i class="icon-angle-right"></i> Categories
			</a></li>
			<li><a id="productsMenuId" href="${baseURL}/menu/products"> <i class="icon-angle-right"></i> Products
			</a></li>
			<li><a id="recurringprofilesMenuId" href="${baseURL}/menu/recurringprofile"> <i class="icon-angle-right"></i> Recurring Profiles
			</a></li>
			<li><a id="filterMenuId" href="${baseURL}/menu/filter"> <i class="icon-angle-right"></i> Filter
			</a></li>
			<li><a id="attributesMenuId" href="${baseURL}/menu/attributes"> <i class="icon-angle-right"></i> Attributes
			</a></li>
			<li><a id="optionsMenuId" href="${baseURL}/menu/options"> <i class="icon-angle-right"></i> Options
			</a></li>
			<li><a id="manufactorsMenuId" href="${baseURL}/menu/manufactors"> <i class="icon-angle-right"></i> Manufactors
			</a></li>
			<li><a id="downloadsMenuId" href="${baseURL}/menu/downloads"> <i class="icon-angle-right"></i> Downloads
			</a></li>
			<li><a id="reviewersMenuId" href="${baseURL}/menu/reviews"> <i class="icon-angle-right"></i> Reviewers
			</a></li>
			<li><a id="informationsMenuId" href="${baseURL}/menu/information"> <i class="icon-angle-right"></i> Informations
			</a></li>
		</ul></li>


	<li class="panel" id="salesMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-sales-navs"> <i class="icon-tasks"> </i> Sales <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-sales-navs">
			<li><a id="orderMenuId" href="${baseURL}/menu/order"> <i class="icon-angle-right"></i> Order
			</a></li>
			<li><a id="recurringorderMenuId" href="${baseURL}/menu/recurringorder"> <i class="icon-angle-right"></i>Recurring Order
			</a></li>
			<li><a id="returnMenuId" href="${baseURL}/menu/return"> <i class="icon-angle-right"></i>Return
			</a></li>
			<li><a id="giftvoucherMenuId" href="${baseURL}/menu/giftvoucher"> <i class="icon-angle-right"></i>Gift Voucher
			</a></li>
			<li><a id="customerMenuId" href="${baseURL}/menu/customer"> <i class="icon-angle-right"></i>Customer
			</a></li>
			<li><a id="paypalMenuId" href="${baseURL}/menu/paypal"> <i class="icon-angle-right"></i>Paypal
			</a></li>
		</ul></li>

	<li class="panel" id="ventorMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-vendor-navs"> <i class="icon-tasks"> </i> Sellers <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-vendor-navs">
			
			<li><a id="uploadProductsMenuId" href="${baseURL}/menu/uploadProducts"> <i class="icon-angle-right"></i> Upload Products
			</a></li>
			<li><a id="manageSellersMenuId" href="${baseURL}/menu/manageSellers"> <i class="icon-angle-right"></i> Manage Sellers
			</a></li>
			<li><a id="managecouriersMenuId" href="${baseURL}/menu/managecouriers"> <i class="icon-angle-right"></i>Manage couriers
			</a></li>
			<li><a id="catalogMenuId" href="${baseURL}/menu/catalog"> <i class="icon-angle-right"></i>Catalog
			</a></li>
			<li><a id="salesMenuId" href="${baseURL}/menu/sales"> <i class="icon-angle-right"></i>Sales
			</a></li>
			<li><a id="toolsMenuId" href="${baseURL}/menu/tools"> <i class="icon-angle-right"></i>Tools
			</a></li>
			<li><a id="settingMenuId" href="${baseURL}/menu/setting"> <i class="icon-angle-right"></i>Setting
			</a></li>
		</ul></li>

	<li class="panel" id="marketingMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-marketing-navs"> <i class="icon-tasks"> </i> Marketing <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-marketing-navs">
			<li><a id="marketingMenuId" href="${baseURL}/menu/marketing"> <i class="icon-angle-right"></i> Marketing
			</a></li>
			<li><a id="affiliatesMenuId" href="${baseURL}/menu/affiliates"> <i class="icon-angle-right"></i>Affiliates
			</a></li>
			<li><a id="couponsMenuId" href="${baseURL}/menu/coupons"> <i class="icon-angle-right"></i>Coupons
			</a></li>
			<li><a id="mailMenuId" href="${baseURL}/menu/mail"> <i class="icon-angle-right"></i>Mail
			</a></li>
		</ul></li>

	<li class="panel" id="systemMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-system-navs"> <i class="icon-tasks"> </i> System <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-system-navs">
			<li><a id="settingMenuId" href="${baseURL}/menu/setting"> <i class="icon-angle-right"></i> Setting
			</a></li>
			<li><a id="designMenuId" href="${baseURL}/menu/design"> <i class="icon-angle-right"></i>Design
			</a></li>
			<li><a id="userMenuId" href="${baseURL}/menu/user"> <i class="icon-angle-right"></i>User
			</a></li>
			<li><a id="localisationMenuId" href="${baseURL}/menu/localisation"> <i class="icon-angle-right"></i>Localisation
			</a></li>
		</ul></li>

	<li class="panel" id="reportMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-reports-navs"> <i class="icon-tasks"> </i> Reports <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-reports-navs">
			<li><a id="salesMenuId" href="${baseURL}/menu/sales"> <i class="icon-angle-right"></i> Sales
			</a></li>
			<li><a id="productsMenuId" href="${baseURL}/menu/products"> <i class="icon-angle-right"></i>Products
			</a></li>
			<li><a id="customerMenuId" href="${baseURL}/menu/customer"> <i class="icon-angle-right"></i>Customer
			</a></li>
			<li><a id="marketingMenuId" href="${baseURL}/menu/marketing"> <i class="icon-angle-right"></i>Marketing
			</a></li>
		</ul></li>

	
</ul>
