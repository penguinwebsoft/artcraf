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
	if (email == undefined) {
		alertBox("Email is not defined in your account, please login with valid email account.");
	} else
		checkUser(resp);
}

function checkUser(resp) {
	$.ajax({
		url : "../customer/checkUser",
		type : "post",
		cache : false,
		dataType : "json",
		data : "email=" + email,
		success : function(data) {
			if (data.result == false) {
				session();
				window.location.replace("../menu/thirdPartyLogin");
			} else {
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
