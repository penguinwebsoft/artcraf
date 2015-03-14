<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

<script type="text/javascript">
	setPage("shippingMenuId");
</script>

<script type="text/javascript">
	$(document).ready(function() {
		var msg = "SAVED SUCCESSFULLY";
		

		$("#SaveBtnId").click(function() {
			var sellerBO = {};
			var storeBO = {};
			storeBO.storeReturn = $("#Shipping").val();
			sellerBO.storeBO = storeBO;
			var postData = JSON.stringify(sellerBO);
			$.ajax({
				url : "../seller/updateStore",
				type : "post",
				data : postData,
				contentType : "application/json",
				dataType : "json",
				success : function(data) {
					alert("Saved Successfully");
				},
				error : function(error) {
					alert(error);
					alert("Details failed to save");
				}
			});
			$("#alertSuccessId").text(msg);
		});

	});
</script>

<div class="inner">
	<div class="row">
		<div class="col-lg-3">
			<h1 style="color: #333; font-size: 30px;"></h1>
		</div>
		<div class="col-lg-9 text-center" style="padding-top: 20px;">
			<div id="alertSuccessId" class=" col-lg-4 alert alert_success " style="margin-bottom: 5px; color: #FF704D; font-size: 17px;">ACTIVE</div>
			<div class=" col-lg-4 alert alert_success" style="margin-bottom: 5px; color: #FF704D; font-size: 17px;">SELLER APPROVED:YES</div>
			<div class=" col-lg-4 alert alert_success" style="margin-bottom: 5px; color: #FF704D; font-size: 17px;">COMMISSION: 10%</div>
		</div>
	</div>

	<hr />
	<div class="row">
		<div class="col-lg-12">
			<div class="box">
				<div id="collapseOne" class="accordion-body collapse in body" style="padding-top: 40px; padding-bottom: 40px;">
					<form class="form-horizontal" action="#" id="block-validate">
						<div class="row">
							<div class="col-lg-11" style="margin-left: 20px;">

								<div class="form-group">
									<label for="" class="control-label col-lg-2" style="font-size: 18px; padding-top: 35px;">Shipping And &nbsp;Return Policy</label>
									<div class="col-lg-10">
										<textarea id="Shipping" name="Shipping" class="form-control" placeholder="Shipping  and  Return Policy" rows="5"></textarea>
									</div>
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-lg-12">
								<center>
									<a id="SaveBtnId" class="btn btn-success" href="#">&nbsp;&nbsp;SAVE&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp; <a class="btn btn-danger" href="#">CANCEL</a>
								</center>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

