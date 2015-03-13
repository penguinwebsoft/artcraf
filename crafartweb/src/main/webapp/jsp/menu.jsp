<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<div class="media user-media well-small" style="margin-top: 1px;">
	<a class="user-link" href="#"> <img class="media-object img-thumbnail user-img" alt="User Picture" src="${context}/resources/img/user.gif">
	</a> <br />
	<div class="media-body">
		<h5 class="media-heading">Joe Romlin</h5>
	</div>
	<br />
</div>
<ul id="menu" class="collapse" id="sampleTabs" style="background-color: #333;">
	<li class="panel"><a id="dashboardMenuId" href="${baseURL}/menu/dashboard"> <i class="icon-table"></i> Dashboard
	</a></li>
	<li class="panel" id="myprofileMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-nav"> <i class="icon-tasks"> </i> My Profile <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-nav">
			<li><a id="myAccountMenuId" href="${baseURL}/menu/myAccount"> <i class="icon-angle-right"></i> My Account
			</a></li>
			<li><a id="bankDetailsMenuId" href="${baseURL}/menu/bankDetails"> <i class="icon-angle-right"></i> Bank Details
			</a></li>
			<li><a id="shippingMenuId" href="${baseURL}/menu/shipping"> <i class="icon-angle-right"></i> Shipping and Return Policy
			</a></li>
			<li><a id="TaxInformationMenuId" href="${baseURL}/menu/taxInformation"> <i class="icon-angle-right"></i> Tax Information
			</a></li>
		</ul></li>
	<li class="panel"><a id="MyProductMenuId" href="${baseURL}/menu/product"> <i class="icon-signin"> </i> My Products
	</a></li>

	<li class="panel" id="salesMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-navs"> <i class="icon-tasks"> </i> Sales <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-navs">
			<li><a id="MyOrdersMenuId" href="${baseURL}/menu/orders"> <i class="icon-angle-right"></i> Orders
			</a></li>
			<li><a id="transactionsMenuId" href="${baseURL}/menu/transactions"> <i class="icon-angle-right"></i> Transactions
			</a></li>
		</ul></li>
	<li class="panel" id="reportMenuId"><a data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-report-navs"> <i class="icon-tasks"> </i> Reports <span
			class="pull-right"> <i class="icon-angle-left"></i>
		</span> &nbsp;
	</a>
		<ul class="collapse" id="component-report-navs">
			<li><a id="viewedMenuId" href="${baseURL}/menu/reportView"> <i class="icon-angle-right"></i> Viewed
			</a></li>
			<li><a id="purchaseMenuId" href="${baseURL}/menu/reportPurchase"> <i class="icon-angle-right"></i> Purchased
			</a></li>
		</ul></li>
</ul>
