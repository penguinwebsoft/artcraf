<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:set var="context" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
var currenciesBOs = {};
$(document).ready(function() {
	
	$.ajax({
		url : "../currencies/getCurrencies",
		type : "post",
		contentType : "application/json",
		dataType : "json",
		success : function(data){
			currenciesBOsn= data.currenciesBOs;
			displayCurrenciesList();
		}
	});
	function displayCurrenciesList(){
		 $.each(currenciesBOs, function(key, value) {
			 var currenciesBO = value;
				html = '<tr>';
				html +='<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>';
				html +='<td>'+currenciesBO.currenciesTitle+'</td>';
				html +='<td>'+currenciesBO.code+'</td>';
				html +='<td>'+currenciesBO.value+'</td>';
				html +='<td>'+currenciesBO.created_dttm+'</td>';
				html +='<td>'+currenciesBO.modified_dttm+'</td>';
				html +='<td>'+currenciesBO.action+'</td>';
				
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
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp; Currencies Page</h1>
			</div>

			<div class="pull-right" style="padding: 25px;">
				<a class="btn btn-success" href="${baseURL}/menu/addCurrenciesPage">Add</a>
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
									<td>Currency title</td>
									<td>Code</td>
									<td>Value</td>
									<td>Last Updates</td>
									<td>Action</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Rupees</td>
									<td>Rs</td>
									<td>$1.00</td>
									<td>11/2/12</td>
									<td>
										<a class="btn btn-warning" href="${baseURL}/menu/editCurrenciesPage">Edit</a>
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

