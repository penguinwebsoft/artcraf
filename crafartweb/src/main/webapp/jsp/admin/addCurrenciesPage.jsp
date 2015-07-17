<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Add Currencies Page</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" name="saveBtn" id="saveBtn" class="btn btn-success">Save</button>
				<button type="button" class="btn btn-default">Cancel</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp;Add Currencies List
				</h3>
			</div>
			<div class="panel-body">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<form id="form-product" class="form-horizontal" enctype="multipart/form-data" method="post" action="#">
							<!-- Start tab-data-->
							<div class="form-group">
								<div class="form-group">
									<label class="col-sm-2 control-label" style="padding-top: 1px;" for="currencytitle"><span data-toggle="tooltip" title="currencytitle">Currency Title</span></label>
									<div class="col-sm-10">
										<input type="text" id="currencytitle"name="currencytitle" value="" placeholder="currencytitle" id="currencytitle" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="padding-top: 1px;" for="code"><span data-toggle="tooltip" title="code">Code</span></label>
									<div class="col-sm-10">
										<input type="text" id="code" name="code" value="" placeholder="code" id="code" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="padding-top: 1px;" for="symbolleft"><span data-toggle="tooltip" title="symbolleft">Symbol Left</span></label>
									<div class="col-sm-10">
										<input type="text" id="symbolleft"name="symbolleft" value="" placeholder="symbolleft" id="symbolleft" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="padding-top: 1px;" for="symbolright"><span data-toggle="tooltip" title="symbolright">Symbol Right</span></label>
									<div class="col-sm-10">
										<input type="text" id="symbolright"name="symbolright" value="" placeholder="symbolright" id="symbolright" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="padding-top: 1px;" for="decimalplaces"><span data-toggle="tooltip" title="decimalvalues">Decimal Values</span></label>
									<div class="col-sm-10">
										<input type="text" id="decimalplaces"name="decimalplaces" value="" placeholder="decimalplaces" id="decimalplaces" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="padding-top: 1px;" for="input-attributename"><span data-toggle="tooltip" title="Values">Values</span></label>
									<div class="col-sm-10">
										<input type="text" id="values" name="values" value="" placeholder="values" id="values" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="input-status">Status</label>
									<div class="col-sm-10">
										<select id="status" placeholder="---please select---" class="form-control">
											<option value="1" selected="selected">Enable</option>
											<option value="0">Disable</option>
										</select>
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

<script type="text/javascript">
$(document).ready(function() {
		$("#saveBtn").click(function() {
			var currencyBO = {};
			
			currencyBO.title = $("#currencytitle").val();
			currencyBO.code= $("#code").val();
			currencyBO.symbolLeft = $("#symbolleft").val();
			currencyBO.symbolRight = $("#symbolright").val();
			currencyBO.decimalPlace = $("#decimalplaces").val();
			currencyBO.value = $("#values").val();
			currencyBO.status = $("#status").val();
			
			postData = JSON.stringify(currencyBO);
			alert("currencies object" + postData);
			$.ajax({
				url : "../currency/addCurrency",
				type : "post",
				data : postData,
				contentType : "application/json",
				dataType : "json",
				success : function(data) {
					if(data.result == true)
						alert("saved succefully");
					else
						alert("Details failed to save");
				}
			});
		});
	}); 
</script>
<script>
setPage("currenciesPageMenuId");
</script>