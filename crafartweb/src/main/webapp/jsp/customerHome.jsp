<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<script>
	$(document).ready(
			function() {

				getImageSizes();
				$(window).resize(function() { //Fires when window is resized
					getImageSizes();
				});

				/**********best seller and best sold products section*****************/
				var clickEvent = false;
				$('#myCarousel').on('click', '.nav a', function() {
					clickEvent = true;
					$('.nav li').removeClass('active');
					$('.nav li').removeClass('arrow_box');
					$(this).parent().addClass('arrow_box');
					$(this).parent().addClass('active');
				}).on(
						'slid.bs.carousel',
						function(e) {
							if (!clickEvent) {
								var count = $('.nav').children().length - 1;
								var current = $('.nav li.active');
								current.removeClass('active').next().addClass(
										'active');
								var id = parseInt(current.data('slide-to'));
								if (count == id) {
									$('.nav li').first().addClass('active');
									$('.nav li').first().addClass('arrow_box');

								}
							}
							clickEvent = false;
						});

				/**********best seller and best sold products section*****************/

				$('#thumbCarousel').carousel({
					interval : 10000
				})

				$('#thumbCarousel1').carousel({
					interval : 10000
				})

				$('#thumbCarousel2').carousel({
					interval : 10000
				})

				$('#thumbCarousel3').carousel({
					interval : 10000
				})

				$('#categoryDropDownId').addClass('open');
				$('#categoryDropDownId #dropdownMenuId').on({
					"click" : function(e) {
						e.stopPropagation();
					}
				});

				$('.nav-tabs > li > a').hover(function() {
					$(this).tab('show');
				});

				var position = $("#dropdownMenuId").position();
				var width = $("#dropdownMenuId").width();
				$("#addFrame").css("margin-top", position.top + "px");
				$("#addFrame").css("margin-right", position.top + "px");

				$("#searchdropdown li a").click(
						function() {
							$("#searchcategory").html(
									$(this).text()
											+ ' <span class="caret"></span>');
							$("#searchcategory").val($(this).text());
						});

			});

	function getImageSizes() {
		$("#carousel-example-generic").each(function() {
			var $height = $(this);
			$('#addFrame').css({
				'height' : $height.height() + 'px'
			});
		});
	}
</script>


<!-- slider banner starts here -->
<div class="container-fluid">
	<div class="row-fluid">
		<nav class="navbar navbar-inverse navbar-static-top marginBottom-0" role="navigation" style="background-color: #332619; min-height: 40px; z-index: 1">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand visible-sm" href="#" target="_blank">Category</a>
			</div>

			<div class="collapse navbar-collapse" id="navbar-collapse-1">
				<ul class="dropdown nav navbar-nav" style="float: inherit; margin-top: 5px; margin-bottom: 0px">
					<li class="col-sm-2"><a href="#"></a></li>
					<li id="categoryDropDownId" class="col-sm-2"><a href="#" class="text-center dropdown-toggle" data-toggle="dropdown">SEE ALL CATEGORY <b class="caret"></b>
					</a>
						<ul id="dropdownMenuId" class="dropdown-menu pull-right" role="menu" style="min-width: 198px; margin-right: 8px; margin-top: 0px; border-radius: 0px;">
							<li role="presentation"><a role="menuitem" href="#">Designer Sarees</a></li>
							<li role="presentation"><a role="menuitem" href="#">Handicrafts</a></li>
							<li role="presentation"><a role="menuitem" href="#">Earthern wares</a></li>
							<li role="presentation"><a role="menuitem" href="#">Nature Products</a></li>
							<li role="presentation"><a role="menuitem" href="#">Color Paintings</a></li>
							<li role="presentation"><a role="menuitem" href="#">Paper Paintings</a></li>
							<li role="presentation"><a role="menuitem" href="#">Kids</a></li>
							<li role="presentation"><a role="menuitem" href="#">Women</a></li>
							<li role="presentation"><a role="menuitem" href="#">Mens Handicrafts</a></li>
							<li role="presentation"><a role="menuitem" href="#">Women Handicrafts</a></li>
							<li role="presentation"><a role="menuitem" href="#">Kides Handicrafts</a></li>
							<li role="presentation" class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown" id="sampleLinkId">Perfumes</a> <!-- <div class="" id="addFrame" style="z-index: 0; background-color: black;"> -->
								<div class="div-submenu-container" style="margin-top: -292px; height: 337px; width: 650px; border-radius: 0px; background-image: url('${context}/resources/img/Fashion.jpg')">
									<ul class="dropdown-menu" style="z-index: 1; position: relative;">
										<li><a href="#">Dropdown 12.1</a></li>
										<li><a href="#">Dropdown 12.2</a></li>
										<li><a href="#">Dropdown 12.3</a></li>
										<li><a href="#">Dropdown 12.4</a></li>
									</ul>
								</div></li>
							<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Khandikraft Products</a>
								<div class="div-submenu-container" style="margin-top: -317px; height: 337px; width: 650px; border-radius: 0px; background-image: url(' . ./ resources/ img/ Fashion.jpg">
									<ul class="dropdown-menu" style="z-index: 1;">
										<li><a href="#">Dropdown 13.1</a></li>
										<li><a href="#">Dropdown 13.2</a></li>
										<li><a href="#">Dropdown 13.3</a></li>
										<li class="divider"></li>
										<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown 13.4</a>
											<ul class="dropdown-menu">
												<li><a href="#">Dropdown 13.4.1</a></li>
												<li><a href="#">Dropdown 13.4.2</a></li>
												<li class="divider"></li>
												<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown 13.4.3</a>
													<ul class="dropdown-menu">
														<li><a href="#">Dropdown 13.4.3.1</a></li>
														<li><a href="#">Dropdown 13.4.3.2</a></li>
														<li><a href="#">Dropdown 13.4.3.3</a></li>
														<li><a href="#">Dropdown 13.4.3.4</a></li>
													</ul></li>
												<li class="dropdown dropdown-submenu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown 13.4.4</a>
													<ul class="dropdown-menu">
														<li><a href="#">Dropdown 13.4.4.1</a></li>
														<li><a href="#">Dropdown 13.4.4.2</a></li>
														<li><a href="#">Dropdown 13.4.4.3</a></li>
														<li><a href="#">Dropdown 13.4.4.4</a></li>
													</ul></li>
											</ul></li>
									</ul>
								</div></li>
							<li><a href="#">SEE ALL CATEGORY</a></li>
						</ul></li>
					<li class="col-sm-1"><a href="#"></a></li>
					<li class="col-sm-1"><a href="#"></a></li>
					<li class="col-sm-1"><a href="#"></a></li>
					<li class="col-sm-1 padding-left padding-right"><a href="#">Exhibition</a></li>
					<li class="col-sm-1 padding-left padding-right"><a href="#">Paintings</a></li>
					<li class="col-sm-1 padding-left padding-right"><a href="#">Antique</a></li>
					<li class="col-sm-1 padding-left padding-right"><a href="#">Handlooms</a></li>
				</ul>
			</div>
		</nav>
	</div>
</div>


<!-- slider banner ends here -->

<!-- slider banner images starts here -->
<div class="container-fluid">
	<div class="row-fluid">
		<div id="carousel-example-generic" class="carousel slide article-slide" data-ride="carousel" style="height: 335px;">
			<!-- Indicators -->

			<ol class="carousel-indicators" style="min-height: 31px;">
				<li data-target="#carousel-example-generic" data-slide-to="0" class="active"><span>FURNITURE</span></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"><span>CLOTHES</span></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"><span>SPORTS-FITNESS</span></li>
				<li data-target="#carousel-example-generic" data-slide-to="3"><span> ELECTRONICS</span></li>
				<li data-target="#carousel-example-generic" data-slide-to="4"><span>CAMERAS</span></li>
				<li data-target="#carousel-example-generic" data-slide-to="5"><span>KITCHEN</span></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="${context}/resources/img/1.jpg" alt="..." class="img-responsive">
				</div>
				<div class="item">
					<img src="${context}/resources/img/2.jpg" alt="..." class="img-responsive">
				</div>

				<div class="item">
					<img src="${context}/resources/img/3.jpg" alt="..." class="img-responsive">
				</div>

				<div class="item">
					<img src="${context}/resources/img/4.jpg" alt="..." class="img-responsive">
				</div>
				<div class="item">
					<img src="${context}/resources/img/1.jpg" alt="..." class="img-responsive">
				</div>

				<div class="item">
					<img src="${context}/resources/img/2.jpg" alt="..." class="img-responsive">
				</div>
			</div>

			<!-- Controls -->

			<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
</div>

<!-- slider banner images ends here -->

<div class="container-fluid">
	<div class="row-fluid">
		<div class="col-sm-12" style="background-color: #e4e4e4; height: 40px;"></div>
	</div>
</div>

<!-- product category wise listing , best seller, sold product sections start here -->
<div class="container-fluid" style="padding-top: 15px">
	<div class="row-fluid">
		<div class="col-sm-9">

			<div class="row">

				<!--  first carousel starts here -->
				<!-- header section  -->
				<div class="col-sm-12">
					<nav class="navbar breadcrumb_cust" role="navigation">
						<div data-toggle="collapse">
							<ul class="nav navbar-nav navbar-left">
								<li><a href="#">HOME AND LIVING</a></li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li><a href="#about">CATEGORY 1</a></li>
								<li><a href="#contact">CATEGORY 2</a></li>
							</ul>
						</div>
					</nav>
				</div>


				<!-- header section  -->

				<!-- multi items carousel container -->
				<div id="thumbCarousel" class="carousel slide col-sm-12">

					<!-- Carousel items -->
					<div class="carousel-inner">
						<div class="col-md-12  item active">
							<div class="row">
								<div class="col-sm-2">
									<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/aprons-potholders.jpg" alt="Image" class="img-responsive"></a>
								</div>
								<div class="col-sm-2">
									<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/baking-dishes.jpg" alt="Image" class="img-responsive"></a>
								</div>
								<div class="col-sm-2">
									<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/canister.jpg" alt="Image" class="img-responsive"></a>
								</div>
								<div class="col-sm-2">
									<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/ceramic-mug.jpg" alt="Image" class="img-responsive"></a>
								</div>
								<div class="col-sm-2">
									<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/kitchen-accessories.jpg" alt="Image" class="img-responsive"></a>
								</div>
								<div class="col-sm-2">
									<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/tea-bags.jpg" alt="Image" class="img-responsive"></a>
								</div>
							</div>
						</div>
						<!--/row-->
						<!--/item-->
						<div class="col-md-12 item">
							<div class="row">
								<div class="col-sm-2">
									<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
								</div>
								<div class="col-sm-2">
									<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp2.jpg" alt="Image" class="img-responsive"></a>
								</div>
								<div class="col-sm-2">
									<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp3.jpg" alt="Image" class="img-responsive"></a>
								</div>
								<div class="col-sm-2">
									<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp4.jpg" alt="Image" class="img-responsive"></a>
								</div>
								<div class="col-sm-2">
									<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp5.jpg" alt="Image" class="img-responsive"></a>
								</div>
								<div class="col-sm-2">
									<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp6.jpg" alt="Image" class="img-responsive"></a>
								</div>
								<!--/row-->
							</div>
						</div>
					</div>
					<!--/carousel-inner-->

					<a class="left carousel-control" href="#carousel-example-product1" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#carousel-example-product1" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
				<!-- multi items carousel container -->
				<!--/thumbCarousel-->
			</div>
			<!--/well-->
			<div class="row-fluid  padding-left" id="Product1_description">
				<div class="row" style="padding-right: 15px">
					<div class="col-md-3 text-center col-sm-3 padding-right">
						<div class="thumbnail product-box">
							<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />
							<div class="caption">
								<h3>
									<a href="#">coffee tea sets</a>
								</h3>
							</div>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-md-3 text-center col-sm-3 padding-right">
						<div class="thumbnail product-box">
							<img src="${context}/resources/img/product2/description/dinner-sets.jpg" alt="" />
							<div class="caption">
								<h3>
									<a href="#">Dinner sets</a>
								</h3>
							</div>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-md-3 text-center col-sm-3 padding-right">
						<div class="thumbnail product-box">
							<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />

							<div class="caption">
								<h3>
									<a href="#">coffee tea sets</a>
								</h3>
							</div>
						</div>
					</div>

					<div class="col-md-3 text-center col-sm-3  padding-right">
						<div class="thumbnail product-box">
							<img src="${context}/resources/img/product2/description/dinner-sets.jpg" alt="" />
							<div class="caption">
								<h3>
									<a href="#">Dinner sets</a>
								</h3>
							</div>
						</div>
					</div>
				</div>

				<!-- best seller and best sold products tabs section starts here -->
				<div class="row">
					<!-- Wrapper for slides -->
					<div class="col-md-12" id="myCarousel">
						<ul class="breadcrumb_cust nav nav-pills nav-tabs  nav_tabs_bottom_border" style="padding: 0px">
							<li data-target="#myCarousel" data-toggle="tab" data-slide-to="0" class="active arrow_box"><a href="#" class="tab">BEST SELLERS</a></li>
							<li data-target="#myCarousel" data-toggle="tab" data-slide-to="1"><a href="#" class="tab">BEST SOLD PRODUCTS</a></li>
						</ul>
					</div>
					<div id="thumbCarousel1" class="carousel slide tabsContainer">
						<div class="carousel-inner">
							<!-- start item 1 -->
							<div class="item active  col-md-12">
								<div class="row">
									<div class="col-sm-3 ">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/baking-dishes.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-3 ">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-3 ">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/kitchen-accessories.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-3 ">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/tea-bags.jpg" alt="Image" class="img-responsive"></a>
									</div>
								</div>
							</div>
							<!-- End Item -->
							<!-- Start Item 2 -->
							<div class="item col-md-12">
								<div class="row">
									<div class="col-sm-3 ">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/baking-dishes.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-3 ">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-3 ">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/kitchen-accessories.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-3 ">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/tea-bags.jpg" alt="Image" class="img-responsive"></a>
									</div>
								</div>
							</div>
							<!--  End Item -->
						</div>
						<!-- End Carousel Inner -->

					</div>
					<!-- End Carousel -->
				</div>
				<!-- best seller and best sold products tabs section ends here -->

				<!--  first carousel ends here -->

				<!--  second carousel starts here -->
				<div class="row-fluid">
					<!-- CATEGORY HEADING -->
					<div>
						<nav class="navbar breadcrumb_cust" role="navigation">
							<div data-toggle="collapse">
								<ul class="nav navbar-nav navbar-left">
									<li><a href="#">HOME AND LIVING</a></li>
								</ul>
								<ul class="nav navbar-nav navbar-right">
									<li><a href="#about">CATEGORY 1</a></li>
									<li><a href="#contact">CATEGORY 2</a></li>
								</ul>
							</div>
						</nav>
					</div>
					<!-- CATEGORY HEADING ENDS -->
					<div id="thumbCarousel2" class="carousel slide ">

						<!-- Carousel items -->
						<div class="carousel-inner">
							<div class="col-md-12 item active">
								<div class="row">
									<div class="col-sm-2">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/aprons-potholders.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-2">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/baking-dishes.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-2">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/canister.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-2">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/ceramic-mug.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-2">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/kitchen-accessories.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-2">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/tea-bags.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<!--/row-->
								</div>
							</div>
							<!--/item-->
							<div class="col-md-12 item">
								<div class="row">
									<div class="col-sm-2">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-2">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp2.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-2">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp3.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-2">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp4.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-2">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp5.jpg" alt="Image" class="img-responsive"></a>
									</div>
									<div class="col-sm-2">
										<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp6.jpg" alt="Image" class="img-responsive"></a>
									</div>
								</div>
							</div>
							<!--/row-->
						</div>
						<!--/carousel-inner-->

						<a class="left carousel-control" href="#carousel-example-product1" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#carousel-example-product1" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
					<!--/thumbCarousel-->
				</div>
				<!--/well-->
				<div class="row-fluid" id="Product1_description">
					<div class="row" style="padding-right: 15px">
						<div class="col-md-3 text-center col-sm-3 padding-right">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />
								<div class="caption">
									<h3>
										<a href="#">coffee tea sets</a>
									</h3>
								</div>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-md-3 text-center col-sm-3 padding-right">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/product2/description/dinner-sets.jpg" alt="" />
								<div class="caption">
									<h3>
										<a href="#">Dinner sets</a>
									</h3>
								</div>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-md-3 text-center col-sm-3 padding-right">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />

								<div class="caption">
									<h3>
										<a href="#">coffee tea sets</a>
									</h3>
								</div>
							</div>
						</div>

						<div class="col-md-3 text-center col-sm-3 padding-right">
							<div class="thumbnail product-box">
								<img src="${context}/resources/img/product2/description/dinner-sets.jpg" alt="" />
								<div class="caption">
									<h3>
										<a href="#">Dinner sets</a>
									</h3>
								</div>
							</div>
						</div>
					</div>
					<!--  second carousel ends here -->

					<!--  thrid carousel starts here -->
					<div class="row-fluid">
						<div>
							<nav class="navbar breadcrumb_cust" role="navigation">
								<div data-toggle="collapse">
									<ul class="nav navbar-nav navbar-left">
										<li><a href="#">HOME AND LIVING</a></li>
									</ul>
									<ul class="nav navbar-nav navbar-right">
										<li><a href="#about">CATEGORY 1</a></li>
										<li><a href="#contact">CATEGORY 2</a></li>
									</ul>
								</div>
							</nav>
						</div>
						<div id="thumbCarousel3" class="carousel slide">

							<!-- Carousel items -->
							<div class="carousel-inner">
								<div class="col-md-12 item active">
									<div class="row">
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/aprons-potholders.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/baking-dishes.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/canister.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/ceramic-mug.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/kitchen-accessories.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/tea-bags.jpg" alt="Image" class="img-responsive"></a>
										</div>
									</div>
									<!--/row-->
								</div>
								<!--/item-->
								<div class="col-md-12 item">
									<div class="row">
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp2.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp3.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp4.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp5.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp6.jpg" alt="Image" class="img-responsive"></a>
										</div>
									</div>
									<!--/row-->
								</div>
							</div>
							<!--/carousel-inner-->

							<a class="left carousel-control" href="#carousel-example-product1" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="right carousel-control" href="#carousel-example-product1" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>
						<!--/thumbCarousel-->
					</div>
					<!--/well-->
					<div class="row-fluid" id="Product1_description">
						<div class="row" style="padding-right: 15px">
							<div class="col-md-3 text-center col-sm-3 padding-right">
								<div class="thumbnail product-box">
									<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />
									<div class="caption">
										<h3>
											<a href="#">coffee tea sets</a>
										</h3>
									</div>
								</div>
							</div>
							<!-- /.col -->
							<div class="col-md-3 text-center col-sm-3 padding-right">
								<div class="thumbnail product-box">
									<img src="${context}/resources/img/product2/description/dinner-sets.jpg" alt="" />
									<div class="caption">
										<h3>
											<a href="#">Dinner sets</a>
										</h3>
									</div>
								</div>
							</div>
							<!-- /.col -->
							<div class="col-md-3 text-center col-sm-3 padding-right">
								<div class="thumbnail product-box">
									<img src="${context}/resources/img/product2/description/coffee-tea-sets.jpg" alt="" />

									<div class="caption">
										<h3>
											<a href="#">coffee tea sets</a>
										</h3>
									</div>
								</div>
							</div>

							<div class="col-md-3 text-center col-sm-3 padding-right">
								<div class="thumbnail product-box">
									<img src="${context}/resources/img/product2/description/dinner-sets.jpg" alt="" />
									<div class="caption">
										<h3>
											<a href="#">Dinner sets</a>
										</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--    third carousel ends here -->
					<!-- All Stores section starts -->

					<div class="row-fluid">
						<!-- CATEGORY HEADING -->
						<div>
							<nav class="navbar breadcrumb_cust" role="navigation">
								<div data-toggle="collapse">
									<ul class="nav navbar-nav navbar-left">
										<li><a href="#">All Other Stores</a></li>
									</ul>
									<ul class="nav navbar-nav navbar-right">
										<li><a href="#about">CATEGORY 1</a></li>
										<li><a href="#contact">CATEGORY 2</a></li>
									</ul>
								</div>
							</nav>
						</div>
						<!-- CATEGORY HEADING ENDS -->
						<div id="thumbCarousel2" class="carousel slide ">

							<!-- Carousel items -->
							<div class="carousel-inner">
								<div class="col-md-12 item active">
									<div class="row">
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/aprons-potholders.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/baking-dishes.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/canister.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/ceramic-mug.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/kitchen-accessories.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product2/tea-bags.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<!--/row-->
									</div>
								</div>
								<!--/item-->
								<div class="col-md-12 item">
									<div class="row">
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp1.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp2.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp3.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp4.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp5.jpg" alt="Image" class="img-responsive"></a>
										</div>
										<div class="col-sm-2">
											<a href="#x" class="thumbnail"><img src="${context}/resources/img/product1/lamp6.jpg" alt="Image" class="img-responsive"></a>
										</div>
									</div>
								</div>
								<!--/row-->
							</div>
							<!--/carousel-inner-->

							<a class="left carousel-control" href="#carousel-example-product1" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="right carousel-control" href="#carousel-example-product1" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>
						<!--/thumbCarousel-->
					</div>


					<!-- All stores section ends -->
				</div>
			</div>


		</div>
	</div>


	<!-- product category wise listing , best seller, sold product sections ends here -->

	<!-- right side advertisement section starts here -->
	<div id="adverstisment" class="row-fluid">
		<div class="col-sm-3 text-center" id="advertishmentId">
			<div class="row margin-left-30-">
				<div class=" col-md-12 col-sm-6 col-xs-push-12">
					<div class="thumbnail">
						<img src="${context}/resources/img/advertisement/add_1.png" alt="" />
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-push-12">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_2.png" alt="" />
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-push-12">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_3.png" alt="" />
					</div>
				</div>

				<div class=" col-md-12 col-sm-6 col-xs-push-12">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_4.png" alt="" />
					</div>
				</div>

				<div class=" col-md-12 col-sm-6 col-xs-push-12">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_5.png" alt="" />
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-push-12">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_6.png" alt="" />
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-push-12">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_7.png" alt="" />
					</div>
				</div>

				<div class=" col-md-12 col-sm-6 col-xs-push-12">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_8.png" alt="" />
					</div>
				</div>

				<div class=" col-md-12 col-sm-6 col-xs-push-12">
					<div class="thumbnail">
						<img src="${context}/resources/img/advertisement/add_1.png" alt="" />
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-push-12">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_2.png" alt="" />
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-push-12">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_3.png" alt="" />
					</div>
				</div>

				<div class=" col-md-12 col-sm-6 col-xs-push-12">
					<div class="thumbnail product-box">
						<img src="${context}/resources/img/advertisement/add_4.png" alt="" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- right side advertisement section ends here -->

</div>