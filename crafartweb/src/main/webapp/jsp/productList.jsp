<script type="text/javascript">
	var productBOs = {};

	$(document)
			.ready(
					function() {
						$.ajax({
							url : "../product/getAllProduct",
							type : "post",
							contentType : "application/json",
							dataType : "json",
							success : function(data) {
								productBOs = data.productBOs;
								displayProducts();
							}
						});
						function displayProducts() {
							$
									.each(
											productBOs,
											function(key, value) {
												var productBO = value;

												html = '<div class="col-md-3 productBox	" id="productDetailBox'+productBO.productId+'">';
												html += '<div class="style"><img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" /></div>';
												html += '<div><span class="style">&nbsp'
														+ productBO.model
														+ '</span></div>';
												html += '<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span	class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"aria-hidden="true">Ratting</span>';
												html += '<hr>';
												html += '<div><span class="style">Rs.'
														+ productBO.price
														+ '</span></div>';
												html += '<div><span class="style">EMI from Rs. 330</span></div>';
												html += '<div class="style" id="description'+key+'">';
												/* html += '<div id="description1'+key+'"></div>';
												html += '<div id="description1'+key+1+'"></div>'; */
												/*  html += '<div id="description3'+key+'">Dual Sim</div>';
												html += '<div>8 MP Primary Camera</div>'; */
												html += '</div>';
												html += '<hr>';
												html += '<span class="style"><input type="checkbox" />Add to Compare</span>';
												html += '</div>';
												html += '<div style="margin-top: 5%">';
												html += '</div>';
												$('#productList').append(html);
												$
														.grep(
																productBO.productAttributeBOs,
																function(
																		element,
																		index) {
																	$(
																			'#description'
																					+ key
																					+ '')
																			.append(
																					'<span><h6>'
																							+ element.text
																							+ '</h6></span>');
																});
											});
						}
					});
	$(document).on('click', '.productBox', function(e) {
		var id = $(this).prop('id');
		alert($(this).prop('id'));
		var productID = parseInt(/productDetailBox(\d+)/.exec(id)[1]);
		/*var productBOObj = $.grep(productBOs, function(element){
			 return element.productId == productID;
		});
		 alert(JSON.stringify(productBOObj));
		alert(productBOObj.hasOwnProperty(model)); */

		window.location.replace("../menu/productDetails");
	});

	function toggle_visibility(id) {
		var e = document.getElementById(id);
		if (e.style.display == 'block')
			e.style.display = 'none';
		else
			e.style.display = 'block';
	}
</script>
<!-- Left Side -->
<div class="col-md-2" style="margin-top: 3%">
<div class="" style="background-color: #332619">	
<p><font color="white">
		<span><b>REFINE</b></span>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd');"><b>PRICE</b></span>
		</div>
		<div id="dl_sub_dd">
			<ul>
				<div>
					<input id="checkbox" type="checkbox" /><label for="checkbox">Rs.2000 and Below</label>
				</div>
				<li><input type="checkbox" />Rs.2001 and Rs.5000</li>
				<li><input type="checkbox" />Rs.5001 and Rs.10000</li>
				<li><input type="checkbox" />Rs.10001 and Rs.18000</li>
				<li><input type="checkbox" />Rs.18001 and Rs.35000</li>
				<li><input type="checkbox" />Rs.35000 and Above</li>
			</ul>
		</div>
		<hr>
		<div>
			<div class="dl_parent">
				<span onclick="toggle_visibility('dl_sub_dd1');"><b>BRAND</b></span>
				<div id="dl_sub_dd1" class="filter">
					<input type="text1" class="filterText" placeholder="search brand..."  />
					<ul>
						<li><input type="checkbox" />Motorola</li>
						<li><input type="checkbox" />Mi</li>
						<li><input type="checkbox" />Micromax</li>
						<li><input type="checkbox" />Samsung</li>
						<li><input type="checkbox" />Apple</li>
						<li><input type="checkbox" />Lenovo</li>
					</ul>
				</div>
			</div>
			<hr>
		</div>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd2');"><b>OPERATING SYSTEM</b></span>
		</div>
		<div id="dl_sub_dd2">
			<ul>
				<li><input type="checkbox" />Android 6</li>
				<li><input type="checkbox" />Bada</li>
				<li><input type="checkbox" />Blackberry OS</li>
				<li><input type="checkbox" />Brew</li>
				<li><input type="checkbox" />Firebox</li>
				<li><input type="checkbox" />IOS</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd3');"><b>SCREEN SIZE</b></span>
		</div>
		<div id="dl_sub_dd3">
			<ul>
				<li><input type="checkbox" />4 to 4.5</li>
				<li><input type="checkbox" />4.5 to 5</li>
				<li><input type="checkbox" />5 inch & more</li>
				<li><input type="checkbox" />4.5 to 5 inch</li>
				<li><input type="checkbox" />3.5 to 4 inch</li>
				<li><input type="checkbox" />4 to 4.5 inch</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd4');"><b>TYPE</b></span>
		</div>
		<div id="dl_sub_dd4">
			<ul>
				<li><input type="checkbox" />SmartPhone 6</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd5');"><b>RAM</b></span>
		</div>
		<div id="dl_sub_dd5">
			<ul>
				<li><input type="checkbox" />0.5-0.9GB</li>
				<li><input type="checkbox" />0.5GB</li>
				<li><input type="checkbox" />1 GB</li>
				<li><input type="checkbox" />1.5GB</li>
				<li><input type="checkbox" />2 GB</li>
				<li><input type="checkbox" />2 GB & Above</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd6');"><b>INTERNET FEATURE</b></span>
		</div>
		<div id="dl_sub_dd6">
			<ul>
				<li><input type="checkbox" />3G</li>
				<li><input type="checkbox" />4G</li>
				<li><input type="checkbox" />WIFI</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd7');"><b>OPERATING SYSTEM VERSION NAME</b></span>
		</div>
		<div id="dl_sub_dd7">
			<ul>
				<li><input type="checkbox" />Lollipop</li>
				<li><input type="checkbox" />Kitkat</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd8');"><b>SIM TYPE</b></span>
		</div>
		<div id="dl_sub_dd8">
			<ul>
				<li><input type="checkbox" />DualSim</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd9');"><b>PRIMARY CAMERA</b></span>
		</div>
		<div id="dl_sub_dd9">
			<ul>
				<li><input type="checkbox" />2-2.9 MP</li>
				<li><input type="checkbox" />Below 2 MP</li>
				<li><input type="checkbox" />3-4.9 MP</li>
				<li><input type="checkbox" />5-7.9 MP</li>
				<li><input type="checkbox" />8 MP</li>
				<li><input type="checkbox" />8 MP & Above</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd10');"><b>NUMBER OF CORE</b></span>
		</div>
		<div id="dl_sub_dd10">
			<ul>
				<li><input type="checkbox" />Dual Core</li>
				<li><input type="checkbox" />Quad Core</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd11');"><b>RESOLUTION TYPE</b></span>
		</div>
		<div id="dl_sub_dd11">
			<ul>
				<li><input type="checkbox" />Others</li>
				<li><input type="checkbox" />Quarter HD</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd12');"><b>CLOCK SPEED</b></span>
		</div>
		<div id="dl_sub_dd12">
			<ul>
				<li><input type="checkbox" />1-1.5 GHZ</li>
				<li><input type="checkbox" />1.5-1.9 GHZ</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd13');"><b>SECONDARY CAMERA</b></span>
		</div>
		<div id="dl_sub_dd13">
			<ul>
				<li><input type="checkbox" />0-1.9 MP</li>
				<li><input type="checkbox" />2-2.9 MP</li>
				<li><input type="checkbox" />3-4.9 MP</li>
				<li><input type="checkbox" />5-7.9 MP</li>
				<li><input type="checkbox" />8 MP</li>
				<li><input type="checkbox" />8 MP & Above</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd14');"><b>FEATURES</b></span>
		</div>
		<div id="dl_sub_dd14">
			<ul>
				<li><input type="checkbox" />FM Player</li>
				<li><input type="checkbox" />Music Player</li>
				<li><input type="checkbox" />USB</li>
				<li><input type="checkbox" />Bluetooth</li>
				<li><input type="checkbox" />NFC</li>
				<li><input type="checkbox" />HD Recording</li>
			</ul>
		</div>
		<hr>
		<div class="dl_parent">
			<span onclick="toggle_visibility('dl_sub_dd15');"><b>AVAILABILITY</b></span>
		</div>
		<div id="dl_sub_dd15">
			<ul>
				<li><input type="checkbox" />Exclude Out of Stock</li>
			</ul>
		</div>
		<hr>
		</font></p>
	</div>
</div>
<!-- right side -->

<div class="col-md-10 pull-right">
	<div style="background-color: #FBF5F5; margin-left: 1%; margin-right: 1%">
		<div class="text-center">
			<h4>MOBILES</h4>
		</div>
		<hr>
		<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
			<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
				<li class="active" id="tabRelevance"><a data-toggle="tab" href="#tab-relevance">Relevance</a></li>
				<li id="tabPopular"><a data-toggle="tab" href="#tab-popular">Popular</a></li>
				<li id="tabHighPrice"><a data-toggle="tab" href="#tab-highprice">High Price</a></li>
				<li id="tabLowPrice"><a data-toggle="tab" href="#tab-lowprice">Low Price</a></li>
				<li id="tabNewModel"><a data-toggle="tab" href="#tab-newmodel">New Model</a></li>
			</ul>
			<div class="tab-content">
				<hr>
				<!-- 	Seperate Section -->
				<div class="tab-pane fade in active" id="tab-relevance">
					<div style="margin-top: 5%">
						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Samsung Galaxy S3 Neo</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 12,499</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 607</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>

							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>

						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Moto E (2nd Gen) 4G </span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 7,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 388</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>

						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Lenovo A7000 (Black, 8)</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 8,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 488</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>

						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Redmi 2 (White)</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 6,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 330</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>
						</div>
					</div>
					<!-- 	Second Row -->
					<div class="row">
						<div style="margin-top: 10%">
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Redmi 2 (White)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 6,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 330</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Samsung Galaxy S3 Neo</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 12,499</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 607</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Moto E (2nd Gen) 4G</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 7,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 388</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Lenovo A7000 (Black, 8)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 8,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 488</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>
						</div>

					</div>
					<!-- Third Row -->
					<div class="row">
						<div style="margin-top: 10%">
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Redmi 2 (White)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 6,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 330</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Samsung Galaxy S3 Neo</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 12,499</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 607</span>
								</div>

								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Moto E (2nd Gen) 4G</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 7,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 388</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Lenovo A7000 (Black, 8)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 8,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 488</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
									</ul>
									<hr>
									<span class="style"><input type="checkbox" />Add to Compare</span>

								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- popular Page -->
				<!-- 	Seperate Section -->
				<div class="tab-pane" id="tab-popular">
					<div class="col-md-3">
						<div class="style">
							<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
						</div>
						<div>
							<span class="style">Moto E (2nd Gen) 4G </span>
						</div>
						<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
							class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
							aria-hidden="true">Ratting</span>
						<hr>
						<div>
							<span class="style">Rs. 7,999</span>
						</div>
						<div>
							<span class="style">EMI from Rs. 388</span>
						</div>
						<div class="style">
							<div>Super AMOLED Screen</div>
							<div>1.5 GB RAM</div>
							<div>Dual Sim</div>
							<div>8 MP Primary Camera</div>
						</div>
						<hr>
						<span class="style"><input type="checkbox" />Add to Compare</span>

					</div>
					<div style="margin-top: 5%">
						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Samsung Galaxy S3 Neo</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 25,499</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 607</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>

							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>

						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Lenovo A7000 (Black, 8)</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 8,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 488</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>

						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Redmi 2 (White)</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 6,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 330</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>
						</div>
					</div>
					<!-- 	Second Row -->
					<div class="row">
						<div style="margin-top: 10%">
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Redmi 2 (White)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 6,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 330</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Samsung Galaxy S3 Neo</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 12,499</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 607</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Moto E (2nd Gen) 4G</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 7,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 388</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Lenovo A7000 (Black, 8)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 8,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 488</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>
						</div>

					</div>
					<!-- Third Row -->
					<div class="row">
						<div style="margin-top: 10%">
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Redmi 2 (White)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 6,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 330</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Samsung Galaxy S3 Neo</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 12,499</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 607</span>
								</div>

								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Moto E (2nd Gen) 4G</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 7,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 388</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Lenovo A7000 (Black, 8)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 8,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 488</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
									</ul>
									<hr>
									<span class="style"><input type="checkbox" />Add to Compare</span>

								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- high Price page -->

				<!-- 	Seperate Section -->
				<div class="tab-pane" id="tab-highprice">
					<div style="margin-top: 5%">
						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Samsung Galaxy S3 Neo</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 32,499</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 607</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>

							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>

						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Moto E (2nd Gen) 4G </span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 7,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 388</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>

						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Lenovo A7000 (Black, 8)</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 8,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 488</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>

						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Redmi 2 (White)</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 6,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 330</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>
						</div>
					</div>
					<!-- 	Second Row -->
					<div class="row">
						<div style="margin-top: 10%">
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Redmi 2 (White)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 6,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 330</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Samsung Galaxy S3 Neo</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 12,499</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 607</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Moto E (2nd Gen) 4G</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 7,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 388</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Lenovo A7000 (Black, 8)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 8,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 488</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>
						</div>

					</div>
					<!-- Third Row -->
					<div class="row">
						<div style="margin-top: 10%">
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Redmi 2 (White)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 6,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 330</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Samsung Galaxy S3 Neo</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 12,499</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 607</span>
								</div>

								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Moto E (2nd Gen) 4G</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 7,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 388</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Lenovo A7000 (Black, 8)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 8,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 488</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
									</ul>
									<hr>
									<span class="style"><input type="checkbox" />Add to Compare</span>

								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Low price -->

				<!-- 	Seperate Section -->
				<div class="tab-pane" id="tab-lowprice">
					<div style="margin-top: 5%">
						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Samsung Galaxy S3 Neo</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 2,499</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 607</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>

							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>

						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Lenovo A7000 (Black, 8)</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 8,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 488</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>
						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Moto E (2nd Gen) 4G </span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 7,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 388</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>
						</div>
						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Redmi 2 (White)</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 6,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 330</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>
						</div>
					</div>
					<!-- 	Second Row -->
					<div class="row">
						<div style="margin-top: 10%">
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Redmi 2 (White)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 6,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 330</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Samsung Galaxy S3 Neo</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 12,499</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 607</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Moto E (2nd Gen) 4G</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 7,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 388</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Lenovo A7000 (Black, 8)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 8,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 488</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>
						</div>

					</div>
					<!-- Third Row -->
					<div class="row">
						<div style="margin-top: 10%">
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Redmi 2 (White)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 6,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 330</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Samsung Galaxy S3 Neo</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 12,499</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 607</span>
								</div>

								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Moto E (2nd Gen) 4G</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 7,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 388</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Lenovo A7000 (Black, 8)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 8,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 488</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
									</ul>
									<hr>
									<span class="style"><input type="checkbox" />Add to Compare</span>

								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- New Model -->
				<!-- 	Seperate Section -->
				<div class="tab-pane" id="tab-newmodel">
					<div style="margin-top: 5%">
						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Samsung Galaxy S3 Neo</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 3,499</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 607</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>

							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>

						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Moto E (2nd Gen) 4G </span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 7,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 388</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>

						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Lenovo A7000 (Black, 8)</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 8,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 488</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>

						</div>

						<div class="col-md-3">
							<div class="style">
								<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
							</div>
							<div>
								<span class="style">Redmi 2 (White)</span>
							</div>
							<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
								class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
								aria-hidden="true">Ratting</span>
							<hr>
							<div>
								<span class="style">Rs. 6,999</span>
							</div>
							<div>
								<span class="style">EMI from Rs. 330</span>
							</div>
							<div class="style">
								<div>Super AMOLED Screen</div>
								<div>1.5 GB RAM</div>
								<div>Dual Sim</div>
								<div>8 MP Primary Camera</div>
							</div>
							<hr>
							<span class="style"><input type="checkbox" />Add to Compare</span>
						</div>
					</div>
					<!-- 	Second Row -->
					<div class="row">
						<div style="margin-top: 10%">
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Redmi 2 (White)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 6,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 330</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Samsung Galaxy S3 Neo</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 12,499</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 607</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Moto E (2nd Gen) 4G</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 7,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 388</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Lenovo A7000 (Black, 8)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 8,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 488</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>
						</div>

					</div>
					<!-- Third Row -->
					<div class="row">
						<div style="margin-top: 10%">
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m11.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Redmi 2 (White)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 6,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 330</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>
							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m12.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Samsung Galaxy S3 Neo</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 12,499</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 607</span>
								</div>

								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>
							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m13.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Moto E (2nd Gen) 4G</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 7,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 388</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
								</div>
								<hr>
								<span class="style"><input type="checkbox" />Add to Compare</span>

							</div>

							<div class="col-md-3">
								<div class="style">
									<img src="../resources/img/m14.jpg" title="" alt="" class="img-responsive" style="margin-top: 0px; margin-left: 20px" />
								</div>
								<div>
									<span class="style">Lenovo A7000 (Black, 8)</span>
								</div>
								<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left: 20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span
									class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
									aria-hidden="true">Ratting</span>
								<hr>
								<div>
									<span class="style">Rs. 8,999</span>
								</div>
								<div>
									<span class="style">EMI from Rs. 488</span>
								</div>
								<div class="style">
									<div>Super AMOLED Screen</div>
									<div>1.5 GB RAM</div>
									<div>Dual Sim</div>
									<div>8 MP Primary Camera</div>
									</ul>
									<hr>
									<span class="style"><input type="checkbox" />Add to Compare</span>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<script>
	$('.filterText')
			.keyup(
					function() {

						var that = this, $allListElements = $('.filter > ul > li');

						var $matchingListElements = $allListElements
								.filter(function(i, li) {
									var listItemText = $(li).text()
											.toUpperCase(), searchText = that.value
											.toUpperCase();
									return ~listItemText.indexOf(searchText);
								});

						$allListElements.hide();
						$matchingListElements.show();

					});
</script>
