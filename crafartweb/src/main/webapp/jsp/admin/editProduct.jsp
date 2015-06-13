<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Edit Product List</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" class="btn btn-success">Save</button>
				<button type="button" class="btn btn-warning">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp; Edit Product Page
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<ul class="nav nav-tabs nav_tabs_bottom_border" style="margin-bottom: 40px" id="tabs">
								<li class="active" id="tabGeneral"><a data-toggle="tab" href="#tab-general">General</a></li>
								<li id="tabData"><a data-toggle="tab" href="#tab-data">Data</a></li>
								<li id="tabLinks"><a data-toggle="tab" href="#tab-links">Links</a></li>
								<li id="tabAttributes"><a data-toggle="tab" href="#tab-attributes">Attributes</a></li>
								<li id="tabOptions"><a data-toggle="tab" href="#tab-options">Options</a></li>
								<li id="tabRecurring"><a data-toggle="tab" href="#tab-recurring">Recurring</a></li>
								<li id="tabDiscount"><a data-toggle="tab" href="#tab-discount">Discount</a></li>
								<li id="tabSpecial"><a data-toggle="tab" href="#tab-special">Special</a></li>
								<li id="tabImage"><a data-toggle="tab" href="#tab-image">Image</a></li>
								<li id="tabImage"><a data-toggle="tab" href="#tab-rewardpoints">RewardPoints</a></li>
							</ul>
							<div class="tab-content">
								<!-- General tab-data-->
								<div class="tab-pane fade in active" id="tab-general">
									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-model">Category Name</label>
										<div class="col-sm-10">
											<input type="text" name="name" value="" placeholder="name" id="input-name" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-meta-description1">Description</label>
										<div class="col-sm-10">
											<textarea name="description[1][description]" rows="5" placeholder="description" id="description" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-model">Meta Tag Title</label>
										<div class="col-sm-10">
											<input type="text" name="metatagtitle" value="" placeholder="metatagtitle" id="input-metatagtitle" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-meta-description1">Meta tag Description</label>
										<div class="col-sm-10">
											<textarea name="metatagdescription[1][metatagdescription]" rows="5" placeholder="metatagdescription" id="description" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="input-metatagkeyword">Meta Tag Keyword</label>
										<div class="col-sm-10">
											<textarea name="metatagkeyword[1][metatagkeyword]" rows="5" placeholder="metatagkeyword" id="metatagkeyword" class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group required">
										<label class="col-sm-2 control-label" for="input-model">Product Tags</label>
										<div class="col-sm-10">
											<input type="text" name="producttags" value="" placeholder="producttags" id="input-name" class="form-control" />
										</div>
									</div>
								</div>
								<!-- Data tab-data-->
								<div class="tab-pane fade" id="tab-data">
									<div class="table-responsive">
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-image">Image</label>
											<div class="col-sm-10">
												<a class="user-link" href="#"> <img class="media-object img-thumbnail user-img" alt="User Picture" src="${context}/resources/img/user.gif"></a>
												<button type="button" class="btn btn-primary" style="margin-top: 1%">Upload Photo</button>
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">Model</label>
											<div class="col-sm-10">
												<input type="text" name="model" value="" placeholder="model" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">SKU</label>
											<div class="col-sm-10">
												<input type="text" name="sku" value="" placeholder="sku" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">UPC</label>
											<div class="col-sm-10">
												<input type="text" name="upc" value="" placeholder="upc" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">EAN</label>
											<div class="col-sm-10">
												<input type="text" name="ean" value="" placeholder="ean" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">JAN</label>
											<div class="col-sm-10">
												<input type="text" name="jan" value="" placeholder="jan" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">ISBN</label>
											<div class="col-sm-10">
												<input type="text" name="isbn" value="" placeholder="isbn" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">MPN</label>
											<div class="col-sm-10">
												<input type="text" name="mpn" value="" placeholder="mpn" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">LOCATION</label>
											<div class="col-sm-10">
												<input type="text" name="location" value="" placeholder="location" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">PRICE</label>
											<div class="col-sm-10">
												<input type="text" name="price" value="" placeholder="price" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">MPN</label>
											<div class="col-sm-10">
												<input type="text" name="mpn" value="" placeholder="mpn" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">MPN</label>
											<div class="col-sm-10">
												<input type="text" name="mpn" value="" placeholder="mpn" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-status">Tax Class</label>
											<div class="col-sm-10">
												<select name="status" id="input-status" class="form-control">
													<option value="1" selected="selected">Taxable Good</option>
													<option value="0">Downloadable products</option>
												</select>
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">Quantity</label>
											<div class="col-sm-10">
												<input type="text" name="quantity" value="" placeholder="quantity" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">MaximumQuantity</label>
											<div class="col-sm-10">
												<input type="text" name="mq" value="" placeholder="mq" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-status">SubTrack Stock</label>
											<div class="col-sm-10">
												<select name="status" id="input-status" class="form-control">
													<option value="1" selected="selected">yes</option>
													<option value="0">no</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-status">Outofstock Status</label>
											<div class="col-sm-10">
												<select name="status" id="input-status" class="form-control">
													<option value="1" selected="selected">In-Stock</option>
													<option value="0">Outof Stock</option>
													<option value="0">PreOrder</option>
												</select>
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">SEO keyword</label>
											<div class="col-sm-10">
												<input type="text" name="seo" value="" placeholder="seo" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">DateAvailable</label>
											<div class="col-sm-10">
												<input type="text" name="date" value="" placeholder="date" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">Dimension(LxWxH)</label>
											<div class="col-sm-10">
												<input type="number" name="length" value="" placeholder="length" id="input-name" class="form-control" /> <input type="number" name="width" value="" placeholder="width" id="input-name"
													class="form-control" /> <input type="number" name="height" value="" placeholder="height" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-status">Length Class</label>
											<div class="col-sm-10">
												<select name="status" id="input-status" class="form-control">
													<option value="1" selected="selected">Centimeter</option>
													<option value="0">milimeter</option>
													<option value="0">inch</option>
												</select>
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">Weight</label>
											<div class="col-sm-10">
												<input type="text" name="weight" value="" placeholder="weight" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-status">Weight Class</label>
											<div class="col-sm-10">
												<select name="status" id="input-status" class="form-control">
													<option value="1" selected="selected">Kilogram</option>
													<option value="0">Gram</option>
													<option value="0">Pound</option>
													<option value="0">Ounce</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="input-status">Status</label>
											<div class="col-sm-10">
												<select name="status" id="input-status" class="form-control">
													<option value="1" selected="selected">approved</option>
													<option value="0">Pending Approved</option>
													<option value="0">Rejected</option>
												</select>
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">Sort Order</label>
											<div class="col-sm-10">
												<input type="text" name="sortorder" value="" placeholder="sortorder" id="input-name" class="form-control" />
											</div>
										</div>
									</div>
								</div>
								<!-- Link tab-data-->
								<div class="tab-pane fade" id="tab-links">
									<div class="table-responsive">
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">Manufacturer</label>
											<div class="col-sm-10">
												<input type="text" name="manufacturer" value="" placeholder="manufacturer" id="input-name" class="form-control" />
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">Categories</label>
											<div class="col-sm-10">
												<input type="text" name="categories" value="" placeholder="categories" id="input-name" class="form-control" />
												<textarea name="categories[1][categories]" rows="5" placeholder="categories" id="categories" class="form-control"></textarea>
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">Filter</label>
											<div class="col-sm-10">
												<input type="text" name="filter" value="" placeholder="filter" id="input-name" class="form-control" />
												<textarea name="filter[1][filter]" rows="5" placeholder="filter" id="categories" class="form-control"></textarea>
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">Stores</label>
											<div class="col-sm-10">
												<textarea name="stores[1][stores]" rows="5" placeholder="stores" id="stores" class="form-control"></textarea>
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">Downloads</label>
											<div class="col-sm-10">
												<input type="text" name="downloads" value="" placeholder="downloads" id="input-name" class="form-control" />
												<textarea name="downloads[1][downloads]" rows="5" placeholder="downloads" id="downloads" class="form-control"></textarea>
											</div>
										</div>
										<div class="form-group required">
											<label class="col-sm-2 control-label" for="input-model">Related Products</label>
											<div class="col-sm-10">
												<input type="text" name="rp" value="" placeholder="Related Products" id="input-name" class="form-control" />
												<textarea name="releatedproducts[1][relatedproducts]" rows="5" placeholder="relatedproduts" id="relatedproducts" class="form-control"></textarea>
											</div>
										</div>
									</div>
								</div>
								<!-- Attributes tab-data-->
								<div class="tab-pane fade" id="tab-attributes">
									<div class="container">
										<div class="tab-pane" id="tab-attributes">
											<div class="table-responsive">
												<table id="attributes" class="table table-striped table-bordered table-hover pull-left">
													<thead>
														<tr>
															<td>Attributes</td>
															<td>Text</td>
															
														</tr>
													</thead>
												</table>
												<button type="button" class="btn btn-primary">Add Attributes</button>
											</div>
										</div>
									</div>
								</div>

								<!-- Option tab-data-->
								<div class="tab-pane fade" id="tab-options">
									<div class="table-responsive">
										<input type="text" name="option" value="" placeholder="option" id="input-name" class="form-control" />
									</div>
								</div>
								<!-- Recurring tab-data-->
								<div class="tab-pane fade" id="tab-recurring">
									<div class="container">
										<div class="tab-pane" id="tab-recurring">
											<div class="table-responsive">
												<table id="recurring" class="table table-striped table-bordered table-hover pull-left">
													<thead>
														<tr>
															<td>Recurring Profile</td>
															<td>Customer Group</td>
															
														</tr>
													</thead>
												</table>
												<button type="button" class="btn btn-primary">Add Recurring</button>
											</div>
										</div>
									</div>
								</div>

								<!-- Discount tab-data-->
								<div class="tab-pane fade" id="tab-discount">
									<div class="container">
										<div class="tab-pane" id="tab-discount">
											<div class="table-responsive">
												<table id="discount" class="table table-striped table-bordered table-hover pull-left">
													<thead>
														<tr>
															<td>Customer Group</td>
															<td>Quantity</td>
															<td>Priority</td>
															<td>Price</td>
															<td>Date Start</td>
															<td>Date End</td>
															
														</tr>
													</thead>
												</table>
												<button type="button" class="btn btn-primary">Add Discount</button>
											</div>
										</div>
									</div>
								</div>
								<!-- Special tab-data-->
								<div class="tab-pane fade" id="tab-special">
									<div class="container">
										<div class="tab-pane" id="tab-special">
											<div class="table-responsive">
												<table id="special" class="table table-striped table-bordered table-hover pull-left">
													<thead>
														<tr>
															<td>Customer Group</td>
															<td>Priority</td>
															<td>Price</td>
															<td>Date Start</td>
															<td>Date End</td>
															
														</tr>
													</thead>
												</table>
												<button type="button" class="btn btn-primary">Add Special</button>
											</div>
										</div>
									</div>
								</div>
								<!-- Image tab-data-->
								<div class="tab-pane fade" id="tab-image">
									<div class="container">
										<div class="tab-pane" id="tab-image">
											<div class="table-responsive">
												<table id="image" class="table table-striped table-bordered table-hover pull-left">
													<thead>
														<tr>
															<td>Image</td>
															<td>Sort Order</td>
														</tr>
													</thead>
												</table>
												<button type="button" class="btn btn-primary">Add Image</button>
											</div>
										</div>
									</div>
								</div>
								<!-- Reward Point tab-data-->
								<div class="tab-pane fade" id="tab-rewardpoints">
									<div class="container">
										<div class="tab-pane" id="tab-rewardpoints">
											<div class="table-responsive">
												<table id="rewardpoints" class="table table-striped table-bordered table-hover pull-left">
													<thead>
														<tr>
															<div class="col-sm-10">
																<input type="text" name="points" value="" placeholder="points" id="input-name" class="form-control" />
															</div>
															<td>Customer Group</td>
															<td>Reward Points</td>
														</tr>
													</thead>
												</table>
											</div>
										</div>
									</div>
								</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>