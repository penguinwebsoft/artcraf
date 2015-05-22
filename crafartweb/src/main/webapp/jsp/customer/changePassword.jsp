<script type="text/javascript">
	$(document).ready(function() {

		var customerBO = {};

		$.ajax({
			url : "../customer/getCustomerDetails",
			type : "post",
			cache : false,
			dataType : "json",
			success : function(data) {
				customerBO = data.customerBO;
			}
		});
		$("#passwordSaveButton")
		.click(
				function() {
					if ($(
							"#newPassword")
							.val() == $(
							"#confirmPassword")
							.val()) {
						$
								.ajax({
									url : "../customer/updatePassword",
									type : "post",
									data : "newPassword="
											+ $(
													"#newPassword")
													.val()
											+ "&presentPassword="
											+ $(
													"#presentPassword")
													.val(),
									dataType : "json",
									success : function(
											data) {
										if (data.message == "empty")
											alert("Present Password is Empty");
										else if (data.message == "failure")
											alert("Present Passowrd is Incorrect");
										else if (data.message == "success")
											alert("Updated Successfully");
									}
								});
					} else {
						alert("Password Mismatch");
					}
				});
	});
	</script>

<div id='customermainBox'>
<div class='form-group' style='margin-left:15%;'>
<label for='presentPassword' class='control-label'>Present Password :</label>
<input type='password' style='width:50%;' class='form-control pull-right' id='presentpassword'/>
</div>
<div class='form-group' style='margin-left:15%'>
<label for='newPassword' class='control-label'>New Password :</label>
<input type='password' class='form-control pull-right' style='width:50%;'  id='newPassword'/>
</div>
<div class='form-group' style='margin-left:15%'>
<label for='confirmPassword' class='control-label'>Confirm Password :</label>
<input type='password' style='width:50%;' class='form-control pull-right' id='confirmPassword'/>
</div>
<div class='form-group' style='margin-left: 25%; margin-top: 10%'>
<button type='button' class='btn btn-primary' id='passwordSaveButton'>SaveChanges</button>
</div>
</div>
