/**
 * 
 */
function googleUser(resp) {
	firstName = resp.name.givenName;
	gender = resp.gender;
	birthday = resp.birthday;
	role = 3;
	checkUser(resp);
}

function facebookUser(resp) {
	 email = resp.email;
	 passwordId = resp.id;
	 firstName = resp.first_name;
	 gender = resp.gender;
	 birthday = resp.birthday;
	 role = 4;
	 if(email== undefined ){
		 alertBox("Email is not defined in your account, please login with valid email account.");
	 }
	 else 
	 checkUser(resp);
}

function checkUser(resp) {
	/*var customerBO = {};
	var contactBOs = new Array();
	var contactBO = {};
	var addressBO = {};*/
	$.ajax({
		url : "../customer/checkUser",
		type : "post",
		cache : false,
		dataType : "json",
		data : "email=" + email,
		success : function(data) {
			if(data.result == false){
				session();
				window.location.replace("../menu/thirdPartyLogin");
			/*	customerBO.firstName = sessionStorage.getItem("firstName");
				customerBO.password = sessionStorage.getItem("id");
				customerBO.gender = ((sessionStorage.getItem("gender") == "male") ? 1 : 0 );
				contactBO.contactValue = sessionStorage.getItem("email");
				contactBO.contactTypeId = 3;
				contactBOs.push(contactBO);
				customerBO.contactBOs = contactBOs;
				customerBO.addressBO = addressBO;
				postData = JSON.stringify(customerBO);
				alert(postData);
				$.ajax({
					url : "../customer/addcustomer",
					type : "post",
					data : postData,
					contentType : "application/json",
					dataType : "json",
					success : function(data) {
						if(data.result){
						alert(data.message);
						window.location.replace(data.redirect);
						}
						else
							alert(data.message);
					}
					
				});*/
			}else{
				alert("mail id already in DB");
				window.location.replace("../menu/home");
			}
		}
	});
}
function session() {
	sessionStorage.setItem("email", email);
	sessionStorage.setItem("id", passwordId);
	sessionStorage.setItem("firstName", firstName);
	sessionStorage.setItem("gender", gender);
	sessionStorage.setItem("birthday", birthday);
	sessionStorage.setItem("userRole", role);
}
