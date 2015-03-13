<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />


<script type="text/javascript">
	setPage("TaxInformationMenuId");
</script>

<script type="text/javascript">
	$(document).ready(function() {
		var msg = "SAVED SUCCESSFULLY";

		$("#SaveBtnId").click(function() {
			$("#alertSuccessId").text(msg);
		});

	});
</script>

<div class="inner">
	<div class="row">
		<div class="col-lg-3">
			<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Tax Information</h1>
		</div>
		<div class="col-lg-9 text-center" style="padding-top: 20px;">
			<div id="alertSuccessId" class=" col-lg-4 alert alert_success " style="margin-bottom: 5px; color: #FF704D; font-size: 17px;">ACTIVE</div>
			<div class=" col-lg-4 alert alert_success " style="margin-bottom: 5px; color: #FF704D; font-size: 17px;">SELLER APPROVED:YES</div>
			<div class=" col-lg-4 alert alert_success " style="margin-bottom: 5px; color: #FF704D; font-size: 17px;">COMMISSION: 10%</div>
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-lg-12">
			<div class="box">
				<div id="collapseOne" class="accordion-body collapse in body" style="padding-top: 30px; padding-bottom: 30px;">
					<form class="form-horizontal" action="#" id="block-validate">
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label for="" class="control-label col-lg-4">VAT/TIN-NO</label>
									<div class="col-lg-8">
										<input type="text" id="VatNo" name="VatNo" class="form-control" placeholder="VAT/TIN NO" />
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-lg-4">CST-NO</label>
									<div class="col-lg-8">
										<input type="text" id="cstNo" name="cstNo" class="form-control" placeholder="CST N0" />
									</div>
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-lg-7">
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
