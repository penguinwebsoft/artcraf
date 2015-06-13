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
			<li><a id="subCategoriesMenuId" href="${baseURL}/menu/subCategories"> <i class="icon-angle-right"></i>Sub Categories
			</a></li>
			<li><a id="productPageMenuId" href="${baseURL}/menu/productPage"> <i class="icon-angle-right"></i> Product
			</a></li>
			<li><a id="filterPageMenuId" href="${baseURL}/menu/filterPage"> <i class="icon-angle-right"></i> Filter
			</a></li>
			<li><a id="reviewersMenuId" href="${baseURL}/menu/reviews"> <i class="icon-angle-right"></i> Reviewers
			</a></li>
			<li><a id="informationPageMenuId" href="${baseURL}/menu/informationPage"> <i class="icon-angle-right"></i> Informations
			</a></li>
			<li><a id="bannerPageMenuId" href="${baseURL}/menu/bannerPage"> <i class="icon-angle-right"></i> Banner
			</a></li>
		</ul></li>


	<li class="panel" id="salesMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-sales-navs"> <i class="icon-tasks"> </i> Sales <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-sales-navs">
			<li><a id="orderListMenuId" href="${baseURL}/menu/orderList"> <i class="icon-angle-right"></i> Order
			</a></li>
			<li><a id="returnPageMenuId" href="${baseURL}/menu/returnPage"> <i class="icon-angle-right"></i>Return
			</a></li>
			<li><a id="customerListMenuId" href="${baseURL}/menu/customerList"> <i class="icon-angle-right"></i>Customer
			</a></li>
		</ul></li>

	<li class="panel" id="sellersMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-vendor-navs"> <i class="icon-tasks"> </i> Sellers <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-vendor-navs">

			<li><a id="manageSellersMenuId" href="${baseURL}/menu/manageSellers"> <i class="icon-angle-right"></i> Manage Sellers
			</a></li>
			<li><a id="salesMenuId" href="${baseURL}/menu/sales"> <i class="icon-angle-right"></i>Sales
			</a></li>
		</ul></li>

	<li class="panel" id="marketingMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-marketing-navs"> <i class="icon-tasks"> </i> Marketing <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-marketing-navs">
			<li><a id="couponListMenuId" href="${baseURL}/menu/couponList"> <i class="icon-angle-right"></i>Coupons
			</a></li>
			<li><a id="mailPageMenuId" href="${baseURL}/menu/mailPage"> <i class="icon-angle-right"></i>Mail
			</a></li>
		</ul></li>

	<li class="panel" id="systemMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-system-navs"> <i class="icon-tasks"> </i> System <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-system-navs">
			<li><a id="attributePageMenuId" href="${baseURL}/menu/attributePage"> <i class="icon-angle-right"></i> Attributes
			</a></li>
			<li><a id="commissionListMenuId" href="${baseURL}/menu/commissionList"> <i class="icon-angle-right"></i>Commission
			</a></li>
			<li><a id="taxDetailsMenuId" href="${baseURL}/menu/taxDetails"> <i class="icon-angle-right"></i>Tax Details
			</a></li>
			<li><a id="manageCouriersMenuId" href="${baseURL}/menu/manageCouriers"> <i class="icon-angle-right"></i>Manage couriers
			</a></li>
			<li><a id="lengthDetailsMenuId" href="${baseURL}/menu/lengthDetails"> <i class="icon-angle-right"></i>Length Details
			</a></li>
			<li><a id="geoZoneMenuId" href="${baseURL}/menu/geoZone"> <i class="icon-angle-right"></i>Geo_Zone
			</a></li>
			<li><a id="emailtemplateMenuId" href="${baseURL}/menu/emailtemplate"> <i class="icon-angle-right"></i>Email Template
			</a></li>
			<li><a id="currenciesPageMenuId" href="${baseURL}/menu/currenciesPage"> <i class="icon-angle-right"></i>Currencies
			</a></li>
			<li><a id="orderStatusMenuId" href="${baseURL}/menu/orderStatus"> <i class="icon-angle-right"></i>OrderStatus
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
