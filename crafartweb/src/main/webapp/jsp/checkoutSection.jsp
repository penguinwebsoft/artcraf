<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<div style="background-color: #F5FFFA; margin-left: 5%; margin-right: 5%" class="row-fluid">
	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
		<!-- FIRST SECTION -->
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingOne" style="background-color: #361616" style="padding-bottom:2px">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"><p class="col-md-12" style="margin-bottom:2px">
							<font color="white">1. BEFORE YOU PLACE YOUR ORDER !</font>
						</p> </a>
				</h4>
			</div>
		</div>
		<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
			<div class="row">
				<div class="col-md-offset-1 col-md-4" style="margin-top: 1%">
					EMAIL ID :<input type="text" class="form-control" id="emailId" /> PASSWORD :<input type="password" class="form-control" id="password" />
					<div style="margin-top: 2%">
						<button type="button" class="btn btn-warning">LOGIN</button>
					</div>
					<div style="margin-top: 2%">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" class="btn btn-primary">CONTINUE</a>
					</div>
				</div>
				<div class="col-md-offset-2 col-md-5">
					<div class="row-fluid">
						<h4>Social login</h4>
					</div>
					<div class="row">
						<div id="googleLogin" class="col-sm-6" style="margin-bottom: 15px;">
							<a href="#" class="btn btn-block btn-social btn-google-plus"> <i class="fa fa-google-plus"></i> Sign in with Google
							</a>
						</div>
					</div>
					<div class="row">
						<div id="facebookLogin" class="col-sm-6">
							<a href="#" class="btn btn-block btn-social btn-facebook"> <i class="fa fa-facebook"></i> Sign in with Facebook
							</a>
						</div>
					</div>
					<br>
				</div>

			</div>
		</div>
		<!-- FIRST SECTION END -->

		<!-- DELIVERY ADDRESS -->
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingTwo" style="background-color: #361616;padding-bottom:2px">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo"><p class="col-md-12" style="margin-bottom:2px">
							<font color="white">2. DELIVERY ADDRESS</font>
						</p> </a>

				</h4>
			</div>
		</div>
		<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingtwo">
			<div class="col-md-12">
				<div class="col-md-12 clearfix">
					<div class="col-md-4">
						<span title="Prabaharan Periasamy">Prabaharan Periasamy <span class="glyphicon glyphicon-pencil"></span> <span class="glyphicon glyphicon-trash"></span>
						</span>
						<p class="">121 Villakkethi Post, Sivagir Via Shoba bakery</p>
						<p class="">638109, Erode</p>
						<p class="">Tamil Nadu</p>
						<span class="">9500098854</span>
						<div style="margin-top: 2%">
							<input type="radio" name="Delivery Address" value="Delivery Address"><b>DELIVERY ADDRESS</b></br>
						</div>
					</div>

					<div class="col-md-4">
						<span title="Prabaharan Periasamy">Prabaharan Periasamy <span class="glyphicon glyphicon-pencil"></span> <span class="glyphicon glyphicon-trash"></span>
						</span>
						<p class="">121 Villakkethi Post, Sivagir Via Shoba bakery</p>
						<p class="">638109, Erode</p>
						<p class="">Tamil Nadu</p>
						<span class="">9500098854</span>
						<div style="margin-top: 2%">
							<input type="radio" name="Delivery Address" value="Delivery Address"><b>DELIVERY ADDRESS</b></br>
						</div>

					</div>

					<div class="col-md-4">
						<span title="Prabaharan Periasamy">Prabaharan Periasamy <span class="glyphicon glyphicon-pencil"></span> <span class="glyphicon glyphicon-trash"></span>
						</span>
						<p class="">121 Villakkethi Post, Sivagir Via Shoba bakery</p>
						<p class="">638109, Erode</p>
						<p class="">Tamil Nadu</p>
						<span class="">9500098854</span>
						<div style="margin-top: 2%">
							<input type="radio" name="Delivery Address" value="Delivery Address"><b>DELIVERY ADDRESS</b></br>
						</div>

					</div>

				</div>
				<div class='form-group pull-right col-md-12'></div>
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<div class="container-fluid">
									<div class="row">
										<div class="col-md-12">
											<div class='form-group pull-right col-md-12'>
												<label for='text' class='control-label'>NAME :</label><input type='text' style='width: 50%;' class='form-control' id='name' />
											</div>
											<div class='form-group pull-right col-md-12'>
												<label for='text' class='control-label'>ADDRESS :</label><input type='text' style='width: 50%;' class='form-control' id='address' />
											</div>
											<div class='form-group pull-right col-md-12'>
												<label for='number' class='control-label'>PHONE NUMBER :</label><input type='number' style='width: 50%;' class='form-control' id='phonenumber' />
											</div>
											<div class='form-group pull-right col-md-12'>
												<label for='text' class='control-label'>LAND MARK :</label><input type='text' style='width: 50%;' class='form-control' id='text' />
											</div>
											<div class='form-group pull-right col-md-12'>
												<label for='text' class='control-label'>CITY :</label><input type='text' style='width: 50%;' class='form-control' id='text' />
											</div>
											<div class='form-group pull-right col-md-12'>
												<label for='number' class='control-label'>PINCODE :</label><input type='number' style='width: 50%;' class='form-control' id='pincode' />
											</div>
											<div class='form-group pull-right col-md-12'>
												<label for='text' class='control-label'>STATE :</label><input type='text' style='width: 50%;' class='form-control' id='text' />
											</div>

										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-warning data-dismiss="modal">Add</button>
							</div>
						</div>
					</div>
				</div>
				<div>
					<a class="btn btn-primary" id="Button" data-toggle="modal" data-target="#myModal">Add New Address</a>&nbsp;&nbsp;&nbsp;
				</div>
			</div>
		</div>
		<!-- DELIVERY ADDRESS END-->

		<!-- ORDER SUMMARY -->
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingThree" style="background-color: #361616;padding-bottom:2px">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
						<p class="col-md-12" style="margin-bottom:2px">
							<font color="white">3.ORDER SUMMARY</font>
						</p>
					</a>
				</h4>
			</div>
		</div>
		<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
			<div class="col-md-12">
				<div class="col-md-12" style="margin-top: 3%">
					<span>DISTRIBUTION</span> <span style="margin-left: 17%">QUANTITY</span> <span style="margin-left: 10%">UNIT PRICE</span> <span style="margin-left: 10%">DELIVERY INFO</span> <span
						style="margin-left: 10%">SUB TOTAL</span>
					<hr>
				</div>
				<div>
					<span>Infocus M330 Black (Limited Edition)</span> <span style="margin-left: 11%"> <select>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
					</select></span> <span style="margin-left: 10%">Rs 9999</span> <span style="margin-left: 10%">Standard delivery: FREE</span> <span style="margin-left: 11%">Rs 9999</span>
				</div>
				<img src="../resources/img/m16.jpg" title="" alt="" class="img-responsive" style="margin-left: 3%" x />
				<hr>
				<span>Send Order Confirmation SMS alert to +91</span>
				<hr>
				<div">
					<a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour" class="btn btn-primary">CONTINUE</a>
				</div>
				<span style="margin-left: 68%">Amount Payable:RS.9999</span>
			</div>
		</div>
		<!-- ORDER SUMMARY END-->

		<!-- PAYMENT METHOD -->
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingFour" style="background-color: #361616;padding-bottom:2px">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
						<p class="col-md-12" style="margin-bottom:2px">
							<font color="white">4.PAYMENT METHOD</font>
						</p>
					</a>
				</h4>
			</div>
			<div class="col-md-4">
				<!-- Nav tabs -->
				<div class="nav-side-menu">
					<!-- <div class="brand">Customer Panel</div> -->
					<i class="brand fa fa-bars fa-1x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
					<div class="menu-list">
						<ul id="menu-content" class="menu-content collapse in">
							<li id="creditcard" data-toggle="collapse" data-target="#creditcard" class="collapsed"><a href="${baseURL}/img/visacard.gif"> Credit Card </a></li>

							<li id="netbanking" data-toggle="collapse" data-target="#netbanking" class="collapsed"><a href="${baseURL}/img/visacard.gif"> Net Banking </a></li>

							<li id="debitcard" data-target="#debicard" data-toggle="collapse" class="collapsed"><a href="${baseURL}/img/visacard.gif"> Debit Card </a></li>

						</ul>
					</div>
				</div>
			</div>



			<div>
				<div id="creditCard" class="collapse col-md-12">
					<div>
						<a><img src="${context}/resources/img/visacard.gif" id="image" title="" alt="" class="img-responsive" style="margin-top: 1%;" /></a>
					</div>
				</div>
				<div id="netBanking" class="collapse col-md-8">
					<div>
						<span><img src="${context}/resources/img/visa axis-bank-logo1.png" id="image" title="" alt="" class="img-responsive" style="margin-top: 1%;" /></span> <span><img
							src="${context}/resources/img/visa hdfc-logo.jpg" id="image" title="" alt="" class="img-responsive" style="margin-top: 1%;" /></span> <span><img
							src="${context}/resources/img/visaicici-logo.png" id="image" title="" alt="" class="img-responsive" style="margin-top: 1%;" /></span> <span>SELECT BANK <select>
								<option>Select the bank</option>
								<option>Axis Bank</option>
								<option>ICICI Bank</option>
								<option>Kotak Bank</option>
								<option>Syndicate Bank</option>
								<option>Bank of Baroda</option>
								<option>Bank of India</option>
								<option>Bank of Maharashtra</option>
								<option>Canara Bank</option>
								<option>Central Bank of India</option>
								<option>Corporation Bank</option>
								<option>Dena Bank</option>
								<option>Indian Bank</option>
								<option>Indian Overseas Bank</option>
								<option>Oriental Bank of Commerce</option>
								<option>Punjab & Sind Bank</option>
								<option>Punjab National Bank</option>
								<option>Syndicate Bank</option>
								<option>UCO Bank</option>
								<option>Union Bank of India</option>
								<option>United Bank of India</option>
								<option>Vijaya Bank</option>

						</select></span>
						<div>
							<a class="btn btn-warning button" id="Button" data-toggle="modal" data-target="#myModal">MAKE PAYMENT</a>&nbsp;&nbsp;&nbsp;
						</div>

					</div>
				</div>
				<div id="debitCard" class="collapse col-md-6">

					<div class="form-group">
						<input type="number" class="form-control" id="number" placeholder="Card Number">
					</div>
					<div class="form-group">
						<input type="number" class="form-control" id="number" placeholder="MM/YY">
					</div>
					<div class="form-group">
						<input type="number" class="form-control" id="number" placeholder="CVV">
					</div>
					<div class="form-group">
						<input type="number" class="form-control" id="number" placeholder="Name On Number">
					</div>

					<div>
						<a class="btn btn-success button" id="Button" data-toggle="modal" data-target="#myModal">SAVE AND PAY</a>&nbsp;&nbsp;&nbsp;
					</div>

				</div>
			</div>
		</div>
	</div>