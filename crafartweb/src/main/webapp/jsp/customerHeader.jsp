<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<!-- header section starts here -->
<nav id="top" class="padding-top" style="padding-bottom: 25px">
	<div class="row-fluid" style="padding-bottom: 15px">
		<div id="top-links" class="nav pull-right">
			<ul class="list-inline no_margin">

				<li><a href="${baseURL}/menu/sellerLogin" title="Sell on Crafart" style="vertical-align: middle;"> <i class="fa fa-shopping-cart pull-left"></i> <span
						class="hidden-xs hidden-sm hidden-md col-lg-12">Sell on Crafart</span>
				</a></li>

				<li><a href="${baseURL}/menu/productDetails" title="Track your Order"> <i class="fa fa-map-marker pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Track your
							Order</span>
				</a></li>

				<li><a href="${baseURL}/menu/customerPanel"> <i class="fa fa-phone pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Contact Us</span></a></li>

				<li><a href="${baseURL}/menu/registration" title="Sign Up"> <i class="fa fa-chevron-circle-up pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Sign Up</span>
				</a></li>

				<li><a href="${baseURL}/menu/customerLogin" title="Login In"> <i class="fa fa-sign-in pull-left"></i> <span class="hidden-xs hidden-sm hidden-md col-lg-12">Login</span>
				</a></li>

				<li>
					<form action="#" method="post" enctype="multipart/form-data" id="currency" class="no_margin">
						<div class="btn-group dropdown">
							<button class="btn btn-link dropdown-toggle" data-toggle="dropdown" style="padding: 2px;">
								<i class="fa fa-inr pull-left"></i><span class="hidden-xs hidden-sm hidden-md col-lg-9 pull-left">Ruppee</span> <i class="fa fa-caret-down pull-right"></i>
							</button>

							<ul class="dropdown-menu pull-left">
								<li><button class="currency-select btn btn-link btn-block" type="button" name="GBP">&#x20b9; Dummy</button></li>
							</ul>
						</div>
						<input type="hidden" name="code" value="" /> <input type="hidden" name="redirect" value="#" />
					</form>
				</li>
				<li><a href="#" title="Login In"></a></li>
			</ul>
		</div>
	</div>
</nav>
<!-- header section ends -->

<!-- home page search box  starts  -->
<div class="row-fluid clearfix">
	<div class="col-sm-3">
		<div id="logo">
			<a href="#"> <img src="${context}/resources/img/logo.png" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" /></a>
		</div>
	</div>
	<div class="col-sm-6">
		<div id="search" class="form-group input-group">
			<div class="input-group-btn">
				<button type="button" id="searchcategory" value="BLOG" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
					BLOG <span class="caret"></span>
				</button>
				<ul id="searchdropdown" class="dropdown-menu" role="menu" style="border-radius: 0px;">
					<li><a href="javascript:void(0)">BLOG</a></li>
					<li><a href="javascript:void(0)">FORUM</a></li>
					<li><a href="javascript:void(0)">DOCS</a></li>
					<li class="divider"></li>
					<li><a href="javascript:void(0)">ANY</a></li>
				</ul>
			</div>
			<input type="text" style="border-radius: 0px;" name="search" value="" placeholder="Search" class="form-control" />
			<div id="searchBtn" class="input-group-btn">
				<button type="button" class="btn btn-success searchPad">Search</button>
			</div>
		</div>
	</div>

	<!-- see in your order starts here -->
	<div id="headerDropDownId" class="col-sm-3">
		<div class="row col-xs-7">
			<!-- Ribbon header -->
			<div class="rectangle rectanle_lg_wd dropdown">
				<h2 class="dropdown-toggle" data-toggle="dropdown">
					See in your orders <b class="caret"></b>
				</h2>
				<ul class="dropdown-menu font_Size_12" role="menu" aria-labelledby="menu1" style="min-width: 150px; color: white;">

					<li role="presentation" style="background-color: white;"><a class="btn btn-warning btn-flat btn-rect" href="#">sign in</a></li>
					<li role="presentation" class="divider" style="margin-bottom: 2px;"></li>
					<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Your Account</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1" href="#">order Account</a></li>
				</ul>
				<!-- Ribbon side-fold (left and right) -->
				<div class="triangle-l triangle-left-pos"></div>
				<div class="triangle-r triangle-right-pos"></div>
			</div>
			<!-- Ribbon header -->
			<!-- see in your order ends here -->
		</div>
		<div class="col-xs-5">
			<div class="dropdown row">
				<div class="rectangle_sm rectangle_sm_wd">
					<h2 class="dropdown-toggle" data-toggle="dropdown">
						Cart <i class="fa fa-shopping-cart"></i> <b class="caret"></b>
					</h2>
					<ul class="dropdown-menu font_Size_12" role="menu" aria-labelledby="menu1" style="min-width: 100px;">
						<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Sign in </a></li>
						<li role="presentation"><a rolw="menuitem" tabindex="-1" href="#">View Cart</a></li>
					</ul>
					<!-- Ribbon side-fold (left and right) -->
					<div class="triangle-l triangle-left-pos"></div>
					<div class="triangle-r triangle-right-pos"></div>
				</div>

			</div>
		</div>
	</div>
</div>

<!-- home page search box ends here -->