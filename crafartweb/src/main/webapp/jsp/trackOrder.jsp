<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<div class="container-fluid" style="padding-right: 15px; padding-left: 15px; margin-right: auto; margin-left: auto;background-image: url(${context}/resources/img/background_img.jpg);">
	<div style="background-color: #FBF5F5; margin-left: 5%; margin-right: 5%">
		<div id="horizontalTabContentOrder">
			<ul class="nav nav-tabs nav_tabs_bottom_border" id="OrderSection">
				<li class="active" id="tabRecentOrder"><a data-toggle="tab" href="#tab-Recent Order">Recent Order(6 Month)</a></li>
				<li id="tabPastOrder"><a data-toggle="tab" href="#tab-Past Order">Past Order</a></li>
			</ul>
			<div class="col-md-12">
				<button type="button" class="btn btn-warning">0D12345678909</button>
				<hr>
				<div>
					<div class="col-md-2">
						<img src="${context}/resources/img/m22.jpg" class="img-responsive" />
					</div>
					<span class="col-md-2">RED MI</span> <span class="col-md-2">RS:7000</span> <span class="col-md-3">Delivered on Wed, 13th May'15</span>
					<button type="button" class="btn btn-warning glyphicon glyphicon-repeat col-md-offset-1">Return</button>
					<span class="pull-left">Color:Black Size:4.5 Qty:1</span>
				</div>
				<hr>
				<div style="margin-top: 5%">
					<span class="col-md-offset-2">Seller:REDMI</span> <span class="col-md-offset-2">Date: Fri, 8th May'15</span> <span class="col-md-offset-3">Order Total:RS:7000</span>
				</div>
			</div>
			<hr>
			<div class="col-md-12">
				<button type="button" class="btn btn-warning">0d12345678909</button>
				<hr>
				<div>
					<div class="col-md-2">
						<img src="${context}/resources/img/m22.jpg" class="img-responsive" />
					</div>
					<span class="col-md-2">RED MI</span> <span class="col-md-2">RS:7000</span> <span class="col-md-3">Delivered on Wed, 13th May'15</span>
					<button type="button" class="btn btn-warning glyphicon glyphicon-repeat col-md-offset-1">Return</button>
					<span class="pull-left">Color:Black Size:4.5 Qty:1</span>
				</div>
				<hr>
				<div style="margin-top: 5%">
					<span class="col-md-offset-2">Seller:Joymart-Retail</span> <span class="col-md-offset-2">Date: Fri, 8th May'15</span> <span class="col-md-offset-3">Order Total:RS:7000</span>
				</div>
			</div>
			<hr>
			<div class="col-md-12">
				<button type="button" class="btn btn-warning">0d12345678909</button>
				<hr>
				<div>
					<div class="col-md-2">
						<img src="${context}/resources/img/m22.jpg" class="img-responsive" />
					</div>
					<span class="col-md-2">RED MI</span> <span class="col-md-2">RS:7000</span> <span class="col-md-3">Delivered on Wed, 13th May'15</span>
					<button type="button" class="btn btn-warning glyphicon glyphicon-repeat col-md-offset-1">Return</button>
					<span class="pull-left">Color:Black Size:4.5 Qty:1</span>
				</div>
				<hr>
				<div style="margin-top: 5%">
					<span class="col-md-offset-2">Seller:Joymart-Retail</span> <span class="col-md-offset-2">Date: Fri, 8th May'15</span> <span class="col-md-offset-3">Order Total:RS:7000</span>
				</div>
			</div>
		</div>
	</div>
</div>