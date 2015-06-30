<script type="text/javascript">
	setPage("customerPersonalDetails");
	$(document).ready(function() {

		var customerBO = {};

		$.ajax({
			url : "../customer/getCustomerDetails",
			type : "post",
			cache : false,
			dataType : "json",
			success : function(data) {
				customerBO = data.customerBO;
				$("#firstname").val(
						customerBO.firstName);
				$("#lastname").val(
						customerBO.lastName);
				$("#gender").val(customerBO.gender);
				$("#dateofbirth").val(
						customerBO.dateOfBirth);
				$("#address").val(customerBO.addressBO.street);
				$
						.each(
								customerBO.contactBOs,
								function(key, value) {
									if (value.contactTypeId == 1) {
										$(
												"#mobileno")
												.val(
														value.contactValue);
									}
								});
				
			}
		});
	
	
	$("#saveButton").click(function() {
		var contactBOs = new Array();
		customerBO.firstName = $("#firstname").val();
		customerBO.lastName = $("#lastname").val();
		customerBO.gender = $("#gender").val();
		customerBO.dateOfBirth = $("#dateofbirth").val();
		customerBO.addressBO.street = $("#address").val();
	/* 	$.each(customerBO.contactBOs,
				function(key, value) {
					if (value.contactTypeId == 1) {
						customerBO.contactBOs.keys(key).contactValue = $("#mobileno").val();
					}
				}); */
		$.grep(customerBO.contactBOs, function(e){ 
			 if(e.contactTypeId == 1)
				 e.contactValue = $("#mobileno").val();
			});
		
		postData = JSON.stringify(customerBO);
		$.ajax({
			url : "../customer/updateCustomerDetails",
			type : "post",
			data : postData,
			contentType : "application/json",
			dataType : "json",
			success : function(data) {
				if(data.result == true)
					alert("Successfully Updated");
				else
					alert("Not Updated");
			}
		});
	});
	});
</script>
<div id='customermainBox' class="col-lg-6">
	<div class='form-group' style='margin-left: 15%;'>
		<label for='firstname' class='control-label'>First Name :</label><input type='text' style='width: 50%;' class='form-control pull-right' id='firstname' />
	</div>
	<div class='form-group' style='margin-left: 15%;'>
		<label for='lastname' class='control-label'>Last Name:</label><input type='text' style='width: 50%;' class='form-control pull-right' id='lastname' />
	</div>
	<div class='form-group' style='margin-left: 15%;'>
		<label for='gender' class='control-label'>Gender :</label><select type='text' id='gender' style='width: 50%;' name='Gender' class='form-control pull-right'><option value='1'>Male</option>
			<option value='2'>Female</option></select>
	</div>
	<div class='form-group' style='margin-left: 15%;'>
		<label for='address' class='control-label'>Address :</label><input type='text' style='width: 50%;' class='form-control pull-right' id='address' />
	</div>
	<div class='form-group' style='margin-left: 15%;'>
		<label for='dateofbirth' class='control-label'>Date of birth :</label><input type='text' style='width: 50%;' class='form-control pull-right' id='dateofbirth' />
	</div>
	<div class='form-group' style='margin-left: 15%;'>
		<label for='mobileno' class='control-label'>Mobile No :</label><input type='text' style='width: 50%;' class='form-control pull-right' id='mobileno' />
		<div class='form-group' style='margin-left: 25%; margin-top: 10%'>
			<button type='button' class='btn btn-primary' id='saveButton'>Save</button>
		</div>
	</div>
</div>