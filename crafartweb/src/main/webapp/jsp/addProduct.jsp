<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

<style>
ul.wysihtml5-toolbar>li {
	position: relative;
}
</style>

<script type="text/javascript">
	var shipping_row = 0;
	var attribute_row = 0;
	var discount_row = 0;
	var image_row = 0;
	var special_row = 0;
	var currentSelectedListId = "";
	var postData = null;
	var geoZoneBOs = {};
	var courierBOs = {};

	$(function() {
		formInit();
	});
	
	$(function() {
		formWysiwyg();
	});
	
	$(document).ready(function() {
		
		$("#dateOfBirthId").datepicker({
			viewMode : 'years',
			format : 'dd/mm/yyyy',

		});

		$('#dateOfBirthId').on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$('#dateOfBirthId').datepicker('hide');
			}
		});

		$("#ProductTaxId").on('change', function(e) {
			var valueSelected = this.value;
			if (valueSelected == 0) {
				$("#taxVatId").hide();
				$("#taxCstId").hide();
			} else {
				$("#taxVatId").show();
				$("#taxCstId").show();
			}
		});
		
		$.ajax({
			url : "../category/getCategory",
			type : "post",
			contentType : "application/json",
			dataType : "json",
			success : function(data) {
				var categoryBOs = data.categoryBOs;
				$.each(categoryBOs, function(key, value) {
					$("#productCategory").append(
							'<option value='+value.categoryId+'>'
									+ value.imageLocation
									+ '</option>');
				});
			}

		});
	 	$.ajax({
			url : "../geoZone/getGeoZone",
			type : "post",
			contentType : "application/json",
			dataType : "json",
			success : function(data){
				geoZoneBOs = data.geoZoneBOs;
			}
		}); 
	 	
		$.ajax({
			url : "../courier/getCourier",
			type : "post",
			contentType : "application/json",
			dataType : "json",
			success : function(data){
				courierBOs = data.courierBOs;
			}
		});
	 	
		$.ajax({
			url : "../taxClass/getTaxClass",
			type : "post",
			contentType : "application/json",
			dataType : "json",
			success : function(data) {
				alert("tax class");
			}

		});

		$("#saveButton")
				.click(
						function() {
							if (currentSelectedListId = "tabData") {
								var productBO = {};
								var weightClassBO = {};
								var lengthClassBO = {};
								var productDescriptionBO = {};
								var productDiscountBOs = new Array();
								var productSpecialBOs = new Array();
								for(var i =0;i<discount_row;i++){
									var productDiscountBO = {};
									productDiscountBO.quantity = $("#quantity"+i).val();
									productDiscountBO.price = $("#value"+i).val();
									productDiscountBO.startDate = $("#dp4"+i).val();
									productDiscountBO.endDate = $("#dp5"+i).val();
									productDiscountBOs.push(productDiscountBO);
								}
								for(var i =0;i<special_row;i++){
									var productSpecialBO = {};
									productSpecialBO.price = $("#prices"+i).val();
									productSpecialBO.startDate = $("#dp2"+i).val();
									productSpecialBO.endDate = $("#dp3"+i).val(); 
									productSpecialBOs.push(productSpecialBO);
								}
								productBO.model = $("#input-model").val();
								productBO.categoryId = $("#productCategory").val();
								productBO.status = $("#input-status").val();
								productBO.price = $("#input-price").val();
								productBO.sku = $("#input-sku").val();
								productBO.quantity = $("#input-quantity").val();
								productBO.stockStatusId = $("#input-stock-status").val();
								productBO.quantity = $("#input-quantity").val();
								productBO.minimum = $("#input-minimum").val();
								productBO.dateAvailable = $("#dateOfBirthId").val();
								productBO.length = $("#input-length").val();
								productBO.width = $("#input-width").val();
								productBO.height = $("#input-height").val();
								productBO.weight = $("#input-weight").val();
								productBO.sortOrder = $("#input-sort-order").val();
								weightClassBO.title = $("#input-weight-class").val();
								weightClassBO.value = $("#input-weight").val();
								lengthClassBO.title = $("#input-length-class").val();
								lengthClassBO.value = $("#input-length").val();
								productDescriptionBO.name = $("#productName").val();
								//productDescriptionBO.description = $("#description").val();
								productDescriptionBO.tag = $("#tagTitle").val();
								productDescriptionBO.metaDescription = $("#metaDescription").val();
								productDescriptionBO.metaKeyword = $("#metaTagAndSEOKeyword").val();
								productBO.weightClassBO = weightClassBO;
								productBO.lengthClassBO = lengthClassBO;
								productBO.productDescriptionBO = productDescriptionBO;
								productBO.productDiscountBOs = productDiscountBOs;
								productBO.productSpecialBOs = productSpecialBOs; 
								postData = JSON.stringify(productBO);
								alert(postData);
							}
							$.ajax({
										url : "../product/addProduct",
										type : "post",
										data : postData,
										contentType : "application/json",
										dataType : "json",
										success : function(data) {
											alert("Saved Successfully");
										},
										error : function(error) {
											alert("Details failed to save");
										}
									});
						});
		
		$("#productFieldsTabs li").click(function() {
			currentSelectedListId = $(this).attr('id');
		});

	});

	function addSpecial() {
		html = '<tr id="special-row' + special_row + '">';
		html += '  <td class="text-right"><input type="text" name="product_special[' + special_row + '][price]" value="" placeholder="Price" class="form-control" id="prices' + special_row + '"/></td>';
		html += '  <td class="text-left" style="width: 25%;"><div class="input-group "><input type="text" name="product_special[' + special_row + '][date_start]" value="" placeholder="Date Start" data-date-format="YYYY-MM-DD" class="form-control" id="dp2' + special_row + '"/></div></td>';
		html += '  <td class="text-left" style="width: 25%;"><div class="input-group "><input type="text" name="product_special[' + special_row + '][date_end]" value="" placeholder="Date End" data-date-format="YYYY-MM-DD" class="form-control" id="dp3' + special_row + '"/></div></td>';
		html += '  <td class="text-left"><button type="button" onclick="$(\'#special-row'
				+ special_row
				+ '\').remove();" data-toggle="tooltip" title="Remove" class="btn btn-danger"><i class="icon-minus-sign"></i></button></td>';
		html += '</tr>';

		$('#special tbody').append(html);

		$("#dp2" + special_row).datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$("#dp2" + special_row).on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$("#dp2" + special_row).datepicker('hide');
			}
		});

		$("#dp3" + special_row).datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$("#dp3" + special_row).on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$("#dp3" + special_row).datepicker('hide');
			}
		});

		special_row++;
	}

	function addDiscount() {
		html = '<tr id="discount-row' + discount_row + '">';
		html += '  <td class="text-left"><select name="product_discount[' + discount_row + '][discount_type_id]" class="form-control">';
		html += '    <option value="1">percentage</option>';
		html += '    <option value="1">Direct</option>';
		html += '  </select></td>';
		html += '  <td class="text-right"><input type="text" name="product_discount[' + discount_row + '][quantity]" value="" placeholder="Quantity" class="form-control" id="quantity' + discount_row + '"/></td>';
		html += '  <td class="text-right"><input type="text" name="product_discount[' + discount_row + '][values]" value="" placeholder="values" class="form-control" id="value' + discount_row + '"/></td>';
		html += '  <td class="text-left" style="width: 20%;"><div class="input-group "><input type="text" name="product_discount[' + discount_row + '][date_start]" value="" placeholder="Date Start" data-date-format="YYYY-MM-DD" class="form-control" id="dp4' + discount_row + '"/></div></td>';
		html += '  <td class="text-left" style="width: 20%;"><div class="input-group ">   <input type="text" name="product_discount[' + discount_row + '][date_end]" value="" placeholder="Date End" data-date-format="YYYY-MM-DD" class="form-control" id="dp5' + discount_row + '"/></div></td>';
		html += '  <td class="text-left"><button type="button" onclick="$(\'#discount-row'
				+ discount_row
				+ '\').remove();" data-toggle="tooltip" title="Remove" class="btn btn-danger"><i class="icon-minus-sign"></i></button></td>';
		html += '</tr>';

		$('#discount tbody').append(html);

		$("#dp4" + discount_row).datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$("#dp4" + discount_row).on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$("#dp4" + discount_row).datepicker('hide');
			}
		});

		$("#dp5" + discount_row).datepicker({
			viewMode : 'years',
			format : 'yyyy/mm/dd',
		});

		$("#db5" + discount_row).on('changeDate', function(ev) {
			//close when viewMode='0' (days)
			if (ev.viewMode === 'days') {
				$("#db5" + discount_row).datepicker('hide');
			}
		});

		discount_row++;
	}

	function addAttribute() {
		html = '<tr id="attribute-row' + attribute_row + '">';
		html += ' <td class="text-left" style="width: 20%;"><select name="product_attribute[' + attribute_row + '][attribute_type_id]" class="form-control">';
		html += '    <option value="1">USB 2.0</option>';
		html += '    <option value="1">USB 3.0</option>';
		html += '  </select></td>';
		html += '  <td class="text-left">';
		html += '<div class="input-group"><span class="input-group-addon"></span><textarea name="product_attribute[' + attribute_row + '][product_attribute_description][1][text]" rows="5" placeholder="Text" class="form-control"></textarea></div>';
		html += '  </td>';
		html += '  <td class="text-left"><button type="button" onclick="$(\'#attribute-row'
				+ attribute_row
				+ '\').remove();" data-toggle="tooltip" title="Remove" class="btn btn-danger"><i class="icon-minus-sign"></i></button></td>';
		html += '</tr>';

		$('#attribute tbody').append(html);

		attributeautocomplete(attribute_row);

		attribute_row++;
	}

	function addShipping() {
		html = '<tr id="shipping-row' + shipping_row + '">';
		html += '  <td class="text-left"><select name="product_shipping[' + shipping_row + '][courier_id]" id="productCourier'+shipping_row+'" class="form-control">';
		html += '  </select></td>';
		html += '  <td class="text-right"><input type="text" name="product_shipping[' + shipping_row + '][shipping_rate]" value="" placeholder="Shipping Rate" class="form-control" /></td>';
		html += '  <td class="text-right"><select name="product_shipping[' + shipping_row + '][geo_zone_id]" id="productGeoZone'+shipping_row+'" class="form-control">';
		html += '  </select></td>';
		html += '  <td class="text-left"><button type="button" onclick="$(\'#shipping-row'
				+ shipping_row
				+ '\').remove();" data-toggle="tooltip" title="Remove" class="btn btn-danger"><i class="icon-minus-sign"></i></button></td>';
		html += '</tr>';
		$('#shipping tbody').append(html);
		shipping_row++;
			for(var i =0;i<shipping_row;i++){
				$.each(geoZoneBOs, function(key, value) {
				$("#productGeoZone"+i).append(
						'<option value='+value.geoZoneId+'>'
								+ value.name
								+ '</option>');
				});
				$.each(courierBOs, function(key, value) {
				$("#productCourier"+i).append(
						'<option value='+value.courierId+'>'
						+ value.name
						+ '</option>');
				});
			}
	}

	function addImage() {
		html = '<tr id="image-row' + image_row + '">';
		html += '  <td class="text-left"><a href="" id="thumb-image' + image_row + '"data-toggle="image" class="img-thumbnail"><img src="${context}/resources/img/no_image-100x100.png" alt="" title="" data-placeholder="${context}/resources/img/no_image-100x100.png" /><input type="hidden" name="product_image[' + image_row + '][image]" value="" id="input-image' + image_row + '" /></td>';
		html += '  <td class="text-right"><input type="text" name="product_image[' + image_row + '][sort_order]" value="" placeholder="Sort Order" class="form-control" /></td>';
		html += '  <td class="text-left"><button type="button" onclick="$(\'#image-row'
				+ image_row
				+ '\').remove();" data-toggle="tooltip" title="Remove" class="btn btn-danger"><i class="icon-minus-sign"></i></button></td>';
		html += '</tr>';

		$('#images tbody').append(html);

		image_row++;
	}
</script>

<div class="inner">
	<div class="row">
		<div class="col-lg-3">
			<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Add Product</h1>
		</div>

		<div class="pull-right" style="padding: 25px;">
			<a class="btn btn-primary" title="" data-toggle="tooltip" data-original-title="Add New" id="saveButton"> &nbsp;&nbsp;&nbsp;SAVE&nbsp;&nbsp;&nbsp; </a> <a
				class="btn btn-danger" style="font-size: 14px !important" title="" title="" data-toggle="tooltip" type="button" data-original-title="Delete"> CANCEL </a>
		</div>
	</div>
	<hr />
	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Product Fields
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="productFieldsTabs">
								<li class="active" id="tabGeneral"><a data-toggle="tab" href="#tab-general">General</a></li>
								<li id="tabData"><a data-toggle="tab" href="#tab-data">Values</a></li>
								<li id="tabSEO"><a data-toggle="tab" href="#tab-SEO">SEO</a></li>
								<li id="tabShipping"><a data-toggle="tab" href="#tab-shipping">Shipping</a></li>
								<li id="tabAttribute"><a data-toggle="tab" href="#tab-attribute">Attribute</a></li>
								<li id="tabImage"><a data-toggle="tab" href="#tab-image">Image</a></li>
								<li id="tabDiscount"><a data-toggle="tab" href="#tab-discount">Discount</a></li>
								<li id="tabSpecial"><a data-toggle="tab" href="#tab-special">Special Price</a></li>
								<li id="tabTax"><a data-toggle="tab" href="#tab-Tax"> Tax </a></li>
							</ul>

							<div class="tab-content" style="border: 0px; padding: 0px;">
								<div class="tab-pane fade in active" id="tab-general">

									<div class="form-group">
										<label class="control-label col-sm-2">Product Category</label>
										<div class="col-sm-10">
											<select class="form-control" id="productCategory">

											</select>
										</div>
									</div>


									<div class="form-group">
										<label class="control-label col-sm-2">Product Sub Category</label>

										<div class="col-sm-10">
											<select data-placeholder="Choose a Country" class="form-control chzn-select" multiple="multiple" tabindex="4" style="height: 25px;">
												<option value="United States" selected="selected">United States</option>
												<option value="United Kingdom">United Kingdom</option>
												<option value="Afghanistan">Afghanistan</option>
												<option value="Albania">Albania</option>
												<option value="Algeria">Algeria</option>
												<option value="American Samoa">American Samoa</option>
												<option value="Andorra">Andorra</option>
											</select>
										</div>
									</div>

									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-name1">Product Name</label>
										<div class="col-sm-10">
											<input type="text" name="product_description[1][name]" value="" placeholder="Product Name" id="productName" class="form-control" />
										</div>
									</div>
									<br>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-description1">Description</label>
										<div class="col-lg-10">
											<div class="box">
												<div id="cleditorDiv" class="body collapse in">
													<form>
														<textarea id="cleditor" class="form-control"></textarea>
														<div class="form-actions no-margin-bottom" id="cleditorForm">
															<br />
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- Start tab-data-->
								<div class="tab-pane fade" id="tab-data">

									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-model">Model</label>
										<div class="col-sm-10">
											<input type="text" name="model" value="" placeholder="Model" id="input-model" class="form-control" />
										</div>
									</div>
									<!--mvds-->
									<input type="hidden" name="product_name" size="100" value="" /> <input type="hidden" name="pending_status" size="100" value="1" />
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-status">Status</label>
										<div class="col-sm-10">
											<select name="status" id="input-status" class="form-control">
												<option value="1" selected="selected">Enabled</option>
												<option value="0">Disabled</option>
											</select>
										</div>
									</div>
									<!--mvde-->
									<div class="form-group">
										<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-sku"><span data-toggle="tooltip" title="Stock Keeping Unit">Stock Keeping Unit(SKU)</span></label>
										<div class="col-sm-10">
											<input type="text" name="sku" value="" placeholder="SKU" id="input-sku" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-upc"><span data-toggle="tooltip" title="Universal Product Code">Universal Product Code(UPC)</span></label>
										<div class="col-sm-10">
											<input type="text" name="upc" value="" placeholder="UPC" id="input-upc" class="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-location">Location</label>
										<div class="col-sm-10">
											<input type="text" name="location" value="" placeholder="Location" id="input-location" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-price">Price</label>
										<div class="col-sm-10">
											<input type="text" name="price" value="" placeholder="Price" id="input-price" class="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-quantity">Quantity</label>
										<div class="col-sm-10">
											<input type="text" name="quantity" value="1" placeholder="Quantity" id="input-quantity" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="Force a minimum ordered amount">Minimum Quantity</span></label>
										<div class="col-sm-10">
											<input type="text" name="minimum" value="1" placeholder="Minimum Quantity" id="input-minimum" class="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-stock-status"><span data-toggle="tooltip" title="Status shown when a product is out of stock">Out Of Stock Status</span></label>
										<div class="col-sm-10">
											<select name="stock_status_id" id="input-stock-status" class="form-control">
												<option value="1">2-3 Days</option>
												<option value="2">In Stock</option>
												<option value="3">Out Of Stock</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-date-available">Date Available</label>
										<div class="col-sm-3">

											<input type="text" class="form-control" placeholder="10/09/1990" value="" data-date-format="mm/dd/yy" id="dateOfBirthId"">

										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-length">Dimensions (L x W x H)</label>
										<div class="col-sm-10">
											<div class="row">
												<div class="col-sm-4">
													<input type="text" name="length" value="" placeholder="Length" id="input-length" class="form-control" />
												</div>
												<div class="col-sm-4">
													<input type="text" name="width" value="" placeholder="Width" id="input-width" class="form-control" />
												</div>
												<div class="col-sm-4">
													<input type="text" name="height" value="" placeholder="Height" id="input-height" class="form-control" />
												</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-length-class">Length Class</label>
										<div class="col-sm-10">
											<select name="length_class_id" id="input-length-class" class="form-control">
												<option value="11" selected="selected">Centimeter</option>
												<option value="12">Millimeter</option>
												<option value="13">Inch</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-weight">Weight</label>
										<div class="col-sm-10">
											<input type="text" name="weight" value="" placeholder="Weight" id="input-weight" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-weight-class">Weight Class</label>
										<div class="col-sm-10">
											<select name="weight_class_id" id="input-weight-class" class="form-control">
												<option value="11" selected="selected">Kilogram</option>
												<option value="12">Gram</option>
												<option value="13">Pound</option>
												<option value="14">Ounce</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-sort-order">Sort Order</label>
										<div class="col-sm-10">
											<input type="text" name="sort_order" value="1" placeholder="Sort Order" id="input-sort-order" class="form-control" />
										</div>
									</div>
								</div>

								<div class="tab-pane fade" id="tab-SEO">

									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-meta-title1">Meta Tag Title</label>
										<div class="col-sm-10">
											<input type="text" name="product_description[1][meta_title]" value="" placeholder="Meta Tag Title" id="tagTitle" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-meta-description1">Meta Tag Description</label>
										<div class="col-sm-10">
											<textarea name="product_description[1][meta_description]" rows="5" placeholder="Meta Tag Description" id="metaDescription" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-meta-keyword1">Meta Tag Keywords</label>
										<div class="col-sm-10">
											<textarea name="product_description[1][meta_keyword]" rows="5" placeholder="Meta Tag Keywords" id="metaTagAndSEOKeyword" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-tag1"><span data-toggle="tooltip" title="comma separated">SEO Keyword</span></label>
										<div class="col-sm-10">
											<input type="text" name="SEO Keyword" value="" placeholder="SEO Keyword" id="" class="form-control" />
										</div>
									</div>
								</div>



								<div class="tab-pane" id="tab-shipping">
									<div class="table-responsive">
										<table id="shipping" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<td class="text-left">Shipping Courier</td>
													<td class="text-left">Flat Rate</td>
													<td class="text-left">Geo Zone</td>
													<td></td>
												</tr>
											</thead>
											<tbody>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="3"></td>
													<td class="text-left"><button type="button" id="addshippingBtnId" onclick="addShipping();" data-toggle="tooltip" title="Add Shipping" class="btn btn-primary">
															<i class="icon-plus-sign"></i>
														</button></td>
												</tr>
											</tfoot>
										</table>
									</div>
								</div>

								<div class="tab-pane" id="tab-attribute">
									<div class="table-responsive">
										<table id="attribute" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<td class="text-left">Attribute</td>
													<td class="text-left">Text</td>
													<td></td>
												</tr>
											</thead>
											<tbody>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="2"></td>
													<td class="text-left"><button type="button" onclick="addAttribute();" data-toggle="tooltip" title="Add Attribute" class="btn btn-primary">
															<i class="icon-plus-sign"></i>
														</button></td>
												</tr>
											</tfoot>
										</table>
									</div>
								</div>

								<div class="tab-pane" id="tab-image">
									<div class="table-responsive">
										<table id="images" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<td class="text-left">Image</td>
													<td class="text-right">Sort Order</td>
													<td></td>
												</tr>
											</thead>
											<tbody>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="2"></td>
													<td class="text-left"><button type="button" onclick="addImage();" data-toggle="tooltip" title="Add Image" class="btn btn-primary">
															<i class="icon-plus-sign"></i>
														</button></td>
												</tr>
											</tfoot>
										</table>
									</div>
								</div>

								<div class="tab-pane" id="tab-discount">
									<div class="table-responsive">
										<table id="discount" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<td class="text-left">Discount Type</td>
													<td class="text-right">Quantity</td>
													<td class="text-right">values</td>
													<td class="text-left">Date Start</td>
													<td class="text-left">Date End</td>
													<td></td>
												</tr>
											</thead>
											<tbody>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="6"></td>
													<td class="text-left"><button type="button" onclick="addDiscount();" data-toggle="tooltip" title="Add Discount" class="btn btn-primary">
															<i class="icon-plus-sign"></i>
														</button></td>
												</tr>
											</tfoot>
										</table>
									</div>
								</div>
								<div class="tab-pane" id="tab-special">
									<div class="table-responsive">
										<table id="special" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<td class="text-right">Price</td>
													<td class="text-left">Date Start</td>
													<td class="text-left">Date End</td>
													<td></td>
												</tr>
											</thead>
											<tbody>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="5"></td>
													<td class="text-left"><button type="button" onclick="addSpecial();" data-toggle="tooltip" title="Add Special" class="btn btn-primary">
															<i class="icon-plus-sign"></i>
														</button></td>
												</tr>
											</tfoot>
										</table>
									</div>
								</div>

								<div class="tab-pane fade" id="tab-Tax">
									<div class="form-group">
										<label class="col-sm-3 control-label" for="ProductTaxId">Product Tax Details</label>
										<div class="col-sm-3">
											<select name="ProductTax" id="ProductTaxId" class="form-control">
												<option id="ProductTaxableGoodsId" value="1" selected="selected">Taxable Goods</option>
												<option id="ProductNonTaxableGoodsId" value="0">Non Taxable Goods</option>
											</select>
										</div>
									</div>
									<div class="form-group required" id="taxVatId">
										<label class="col-sm-3 control-label" for="VatId">VAT Rate (%)</label>
										<div class="col-sm-3">
											<input type="text" name="vatId" value="" placeholder="VAT Rate (%)" id="vatId" class="form-control" />
										</div>
									</div>
									<div class="form-group required" id="taxCstId">
										<label class="col-sm-3 control-label" for="cstId">CST Rate (%)</label>
										<div class="col-sm-3">
											<input type="text" name="cstId" value="" placeholder="CST Rate (%)" id="cstId" class="form-control" />
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="row">
						<div class="col-sm-6 text-left"></div>
						<div class="col-sm-6 text-right"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


