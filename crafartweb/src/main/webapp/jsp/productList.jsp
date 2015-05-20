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

												html = '<div class="col-md-3">';
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
												$.grep(productBO.productAttributeBOs, function(
														element, index) {
													$('#description'+key+'').append('<span><h6>'+element.text+'</h6></span>');
												});
											});
						}
					});
</script>
<!-- Left Side -->
<div class="col-md-2" style="margin-top: 3%">

	<span><b>REFINE</b></span>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>PRICE</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />Rs.2000 and Below</li>
			<li><input type="checkbox" />Rs.2001 and Rs.5000</li>
			<li><input type="checkbox" />Rs.5001 and Rs.10000</li>
			<li><input type="checkbox" />Rs.10001 and Rs.18000</li>
			<li><input type="checkbox" />Rs.18001 and Rs.35000</li>
			<li><input type="checkbox" />Rs.35000 and Above</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>BRAND</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />Motorola</li>
			<li><input type="checkbox" />Mi</li>
			<li><input type="checkbox" />Micromax</li>
			<li><input type="checkbox" />Samsung</li>
			<li><input type="checkbox" />Apple</li>
			<li><input type="checkbox" />Lenovo</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>OPERATING SYSTEM</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />Android 6</li>
			<li><input type="checkbox" />Bada</li>
			<li><input type="checkbox" />Blackberry OS</li>
			<li><input type="checkbox" />Brew</li>
			<li><input type="checkbox" />Firebox</li>
			<li><input type="checkbox" />IOS</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>SCREEN SIZE</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />4 to 4.5</li>
			<li><input type="checkbox" />4.5 to 5</li>
			<li><input type="checkbox" />5 inch & more</li>
			<li><input type="checkbox" />4.5 to 5 inch</li>
			<li><input type="checkbox" />3.5 to 4 inch</li>
			<li><input type="checkbox" />4 to 4.5 inch</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>TYPE</b></span>
		<ul class="dropdown-menu"> 
			<li><input type="checkbox" />SmartPhone 6</li>
		</ul>

		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>RAM</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />0.5-0.9GB</li>
			<li><input type="checkbox" />0.5GB</li>
			<li><input type="checkbox" />1 GB</li>
			<li><input type="checkbox" />1.5GB</li>
			<li><input type="checkbox" />2 GB</li>
			<li><input type="checkbox" />2 GB & Above</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>INTERNET FEATURE</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />3G</li>
			<li><input type="checkbox" />4G</li>
			<li><input type="checkbox" />WIFI</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>OPERATING SYSTEM VERSION NAME</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />Lollipop</li>
			<li><input type="checkbox" />Kitkat</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>SIM TYPE</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />DualSim</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>PRIMARY CAMERA</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />2-2.9 MP</li>
			<li><input type="checkbox" />Below 2 MP</li>

			<li><input type="checkbox" />3-4.9 MP</li>
			<li><input type="checkbox" />5-7.9 MP</li>
			<li><input type="checkbox" />8 MP</li>
			<li><input type="checkbox" />8 MP & Above</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>NUMBER OF CORES</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />Dual Core</li>
			<li><input type="checkbox" />Quad Core</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>RESOLUTION TYPE</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />Others</li>
			<li><input type="checkbox" />Quarter HD</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>CLOCK SPEED</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />1-1.5 GHZ</li>
			<li><input type="checkbox" />1.5-1.9 GHZ</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>SECONDARY CAMERA</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />0-1.9 MP</li>
			<li><input type="checkbox" />2-2.9 MP</li>
			<li><input type="checkbox" />3-4.9 MP</li>
			<li><input type="checkbox" />5-7.9 MP</li>
			<li><input type="checkbox" />8 MP</li>
			<li><input type="checkbox" />8 MP & Above</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>FEATURES</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />FM Player</li>
			<li><input type="checkbox" />Music Player</li>
			<li><input type="checkbox" />USB</li>
			<li><input type="checkbox" />Bluetooth</li>
			<li><input type="checkbox" />NFC</li>
			<li><input type="checkbox" />HD Recording</li>
		</ul>
		<hr>
	</div>
	<div class="dropdown">
		<a href="#" data-toggle="dropdown" class="dropdown-toggle pull-right"><b class="caret"></b></a> <span><b>AVAILABIliTY</b></span>
		<ul class="dropdown-menu">
			<li><input type="checkbox" />Exclude Out of Stock</li>
		</ul>
		<hr>
	</div>


 </div>
<!-- right side -->

<div class="col-md-10 pull-right">
	<div style="background-color: #FBF5F5; margin-left: 1%; margin-right: 1%">
		<div class="text-center">
			<h4>MOBILES</h4>
		</div>
		<div class="text-center" style="margin-top: 7%">
			<span>Relevance</span> <span>Popular</span> <span>High Price</span> <span>Low Price</span> <span>New</span>
		</div>
		<!-- 	Seperate Section -->
		<div class="row" id="productList">
			<div style="margin-top: 5%">
				<!-- <div class="col-md-3">
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
					<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left:20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
						aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true">Ratting</span>
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
					<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left:20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
						aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true">Ratting</span>
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

				</div> -->

			</div>
		</div>
 		<!-- 	Second Row -->
		<!--<div class="row">
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
					<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left:20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
						aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true">Ratting</span>
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
					<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left:20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
						aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true">Ratting</span>
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
					<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left:20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
						aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true">Ratting</span>
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
			Third Row
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
					<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left:20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
						aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true">Ratting</span>
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
					<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left:20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
						aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true">Ratting</span>
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
					<span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="margin-left:20%"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty"
						aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> <span class="glyphicon glyphicon-star-empty" aria-hidden="true">Ratting</span>
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

		</div> -->
	</div>
	</div>