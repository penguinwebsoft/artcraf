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
			<li><a id="informationPageMenuId" href="${baseURL}/menu/informationPage"> <i class="icon-angle-right"></i> Informations
			</a></li>
			<li><a id="bannerPageMenuId" href="${baseURL}/menu/bannerPage"> <i class="icon-angle-right"></i> Banner
			</a></li>
			<li><a id="bannerGroupMenuId" href="${baseURL}/menu/bannerGroup"> <i class="icon-angle-right"></i> Banner Group
			</a></li>
		</ul></li>


	<li class="panel" id="salesMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-sales-navs"> <i class="icon-tasks"> </i> Sales <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-sales-navs">
			<li><a id="orderListMenuId" href="${baseURL}/menu/orderList"> <i class="icon-angle-right"></i> Order
			</a></li>
			<li><a id="returnPageMenuId" href="${baseURL}/menu/returnPage"> <i class="icon-angle-right"></i> Return
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
			<li><a id="transactionPageMenuId" href="${baseURL}/menu/transactionPage"> <i class="icon-angle-right"></i>Transaction
			</a></li>
			<li><a id="paymentHistoryMenuId" href="${baseURL}/menu/paymentHistory"> <i class="icon-angle-right"></i>Payment
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
			<li><a id="orderStatusMenuId" href="${baseURL}/menu/orderStatus"> <i class="icon-angle-right"></i>Order Status
			</a></li>
			<li id="returnMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-return-navs"> <i class="icon-tasks"> </i> Return <span
					class="pull-right"> <i class="icon-angle-left"></i>
				</span> &nbsp;
			</a>
				<ul class="collapse" id="component-return-navs">
					<li><a id="returnActionMenuId" href="${baseURL}/menu/returnAction"> <i class="icon-angle-right"></i> Return Action
					</a></li>
					<li><a id="returnStatusMenuId" href="${baseURL}/menu/returnStatus"> <i class="icon-angle-right"></i> Return Status
					</a></li>
					<li><a id="returnReasonMenuId" href="${baseURL}/menu/returnReason"> <i class="icon-angle-right"></i> Return Reason
					</a></li>
				</ul></li>
			<li id="usersMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-users-navs"> <i class="icon-tasks"> </i> Users <span class="pull-right">
						<i class="icon-angle-left"></i>
				</span> &nbsp;
			</a>
				<ul class="collapse" id="component-users-navs">
					<li><a id="userGroupListMenuId" href="${baseURL}/menu/userGroupList"> <i class="icon-angle-right"></i> User Group List
					</a></li>
					<li><a id="userListPageMenuId" href="${baseURL}/menu/userListPage"> <i class="icon-angle-right"></i> User List Page
					</a></li>
				</ul></li>
			<li id="SettingMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-setting-navs"> <i class="icon-tasks"> </i> Setting <span
					class="pull-right"> <i class="icon-angle-left"></i>
				</span> &nbsp;
			</a>
				<ul class="collapse" id="component-setting-navs">
					<li><a id="smsListMenuId" href="${baseURL}/menu/smsList"> <i class="icon-angle-right"></i> SMS
					</a></li>
					<li><a id="emailListMenuId" href="${baseURL}/menu/emailList"> <i class="icon-angle-right"></i> Email
					</a></li>
					<li><a id="cdnPageMenuId" href="${baseURL}/menu/cdnPage"> <i class="icon-angle-right"></i> CDN
					</a></li>
				</ul></li>
		</ul></li>

	<li class="panel" id="reportMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-reports-navs"> <i class="icon-tasks"> </i> Reports <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-reports-navs">
			<li id="saleMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-sale-navs"> <i class="icon-tasks"> </i> sales <span class="pull-right">
						<i class="icon-angle-left"></i>
				</span> &nbsp;
			</a>
				<ul class="collapse" id="component-sale-navs">
					<li><a id="salesOrderPageMenuId" href="${baseURL}/menu/salesOrder"> <i class="icon-angle-right"></i> Sales Order
					</a></li>
					<li><a id="taxOrderMenuId" href="${baseURL}/menu/taxOrder"> <i class="icon-angle-right"></i> Tax Order
					</a></li>
					<li><a id="shippingReportMenuId" href="${baseURL}/menu/shippingReport"> <i class="icon-angle-right"></i> Shipping Report
					</a></li>
					<li><a id="returnReportMenuId" href="${baseURL}/menu/returnReport"> <i class="icon-angle-right"></i> Return Report
					</a></li>
					<li><a id="couponsReportMenuId" href="${baseURL}/menu/couponsReport"> <i class="icon-angle-right"></i> Coupons Report
					</a></li>
				</ul></li>
			<li id="productsMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-products-navs"> <i class="icon-tasks"> </i> Products <span
					class="pull-right"> <i class="icon-angle-left"></i>
				</span> &nbsp;
			</a>
				<ul class="collapse" id="component-products-navs">
					<li><a id="productPurchaseReportMenuId" href="${baseURL}/menu/productPurchaseReport"> <i class="icon-angle-right"></i> Product Purchase Report
					</a></li>
					<li><a id="productViewReportMenuId" href="${baseURL}/menu/productViewReport"> <i class="icon-angle-right"></i> Product View Report
					</a></li>
				</ul></li>
			<li id="customerMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-customer-navs"> <i class="icon-tasks"> </i> Customer <span
					class="pull-right"> <i class="icon-angle-left"></i>
				</span> &nbsp;
			</a>
				<ul class="collapse" id="component-customer-navs">
					<li><a id="customerOrderReportMenuId" href="${baseURL}/menu/customerOrderReport"> <i class="icon-angle-right"></i> Customer Order Report
					</a></li>
				</ul></li>
			<li><a id="marketingMenuId" href="${baseURL}/menu/marketing"> <i class="icon-angle-right"></i>Marketing
			</a></li>
		</ul></li>


</ul>
