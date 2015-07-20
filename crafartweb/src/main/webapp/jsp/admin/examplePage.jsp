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

<div class="row-fluid hidden-sm hidden-md hidden-xs">
	<div class="col-sm-12" style="background-color: #e4e4e4; height: 40px; margin-top: -20px"></div>
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

								<span title="Prabaharan Periasamy">Prabaharan Periasamy <span class="glyphicon glyphicon-pencil"></span> <span class="glyphicon glyphicon-trash"></span>
								</span>
								<p class="">121 Villakkethi Post, Sivagir Via Shoba bakery</p>
								<p class="">638109, Erode</p>
								<p class="">Tamil Nadu</p>
								<span class="">9500098854</span>
								<div style="margin-top: 2%">
									<span><input type="checkbox" class="style2"><b>Delivery Address</b></span>
								</div>
							</div>
						</div>
						<!--/row-->
						<!--/item-->
						<div class="col-md-12 item">
							<div class="row">

								<span title="Prabaharan Periasamy">Prabaharan Periasamy <span class="glyphicon glyphicon-pencil"></span> <span class="glyphicon glyphicon-trash"></span>
								</span>
								<p class="">121 Villakkethi Post, Sivagir Via Shoba bakery</p>
								<p class="">638109, Erode</p>
								<p class="">Tamil Nadu</p>
								<span class="">9500098854</span>
								<div style="margin-top: 2%">
									<span><input type="checkbox" class="style2"><b>Delivery Address</b></span>
								</div>
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
			</div>
		</div>
	</div>
	<!-- right side advertisement section ends here -->

