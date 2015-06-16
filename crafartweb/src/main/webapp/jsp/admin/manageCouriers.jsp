<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
var manageCourierBOs = {};
$(document).ready(function() {
	
	$.ajax({
		url : "../manageCourier/getManageCourier",
		type : "post",
		contentType : "application/json",
		dataType : "json",
		success : function(data){
			manageCouriersBOs = data.manageCouriersBOs;
			displayManageCourierList();
		}
	});
	function displaymanageCourierList(){
		 $.each(manageCouriersBOs, function(key, value) {
			 var manageCouriersBOs = value;
				html = '<tr>';
				html +='<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>';
				html +='<td>'+manageCouriersBO.manageCouriersName+'</td>';
				html +='<td>'+manageCouriersBO.sortOrder+'</td>';
				html +='<td>'+manageCouriersBO.estimatedDeliveryTime+'</td>';
				html +='<td>'+manageCouriersBO.totalProducts+'</td>';
				html +='<td>'+manageCouriersBO.action+'</td>';
				
				html +='<td><button type="button" class="btn btn-warning">Edit</button></td>';
				html +='</tr>';
				$('#shipping tbody').append(html);
			}); 
		}
});
</script>

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Manage Couriers</h1>
			</div>

			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/addNewCouriers">Add</a>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>

		<!-- Table Section-->
		<div class="container-fluid" style="background-color: white;">
			<div class="container">
				<div class="tab-pane" id="tab-shipping">
					<div class="table-responsive">
						<table id="shipping" class="table table-striped table-bordered table-hover pull-left">
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Image</td>
									<td>Courier Name</td>
									<td>Estimated Delivery Time</td>
									<td>Total Products</td>
									<td>Sort Order</td>
									<td>Action</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
									<td>China Post Air Mail</td>
									<td>15-30 Days</td>
									<td>0</td>
									<td>0</td>
									<td>
										<a class="btn btn-warning" href="${baseURL}/menu/editCouriers">Edit</a>
									</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
									<td>DHL</td>
									<td>3-7 Days</td>
									<td>0</td>
									<td>0</td>
									<td>
										<button type="button" class="btn btn-warning">Edit</button>
									</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
									<td>EMS</td>
									<td>5-10 Days</td>
									<td>0</td>
									<td>0</td>
									<td>
										<button type="button" class="btn btn-warning">Edit</button>
									</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
									<td>Fedex</td>
									<td>3-7 Days</td>
									<td>0</td>
									<td>0</td>
									<td>
										<button type="button" class="btn btn-warning">Edit</button>
									</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
									<td>Hong Kong Air Mail</td>
									<td>15-30 Days</td>
									<td>0</td>
									<td>0</td>
									<td>
										<button type="button" class="btn btn-warning">Edit</button>
									</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td><img id="image" class="image" src="${context}/resources/img/dhl2.jpg" title="" alt="" class="img-responsive" /></td>
									<td>JNE</td>
									<td>3-7 Days</td>
									<td>0</td>
									<td>0</td>
									<td>
										<button type="button" class="btn btn-warning">Edit</button>
									</td>
								</tr>
							</thead>
						</table>

					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>

