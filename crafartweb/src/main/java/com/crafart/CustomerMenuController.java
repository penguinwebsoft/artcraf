package com.crafart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ambi
 * @version 1.0
 * 
 */
@Controller("customerMenuController")
@RequestMapping("customer")
public class CustomerMenuController {

	@RequestMapping("/customerDetails")
	public ModelAndView showCustomerDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("customerDetails");
	}
	
	@RequestMapping("/addressContacts")
	public ModelAndView showAddressContacts(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("addressContacts");
	}
	
	@RequestMapping("/profileSettings")
	public ModelAndView showProfileSettings(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("profileSettings");
	}
	
	@RequestMapping("/changePassword")
	public ModelAndView showChangePassword(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("changePassword");
	}
	
	@RequestMapping("/deactivateAccount")
	public ModelAndView showDeactiveAccount(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("deactivateAccount");
	}
	
	@RequestMapping("/manageEmail")
	public ModelAndView showManageEmail(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("manageEmail");
	}
	
	@RequestMapping("/myOrder")
	public ModelAndView showMyOrder(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("myOrder");
	}
	
	@RequestMapping("/orderSection")
	public ModelAndView showorderSection(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("orderSection");
	}
	
	@RequestMapping("/reviewSection")
	public ModelAndView showreviewSection(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("reviewSection");
	}
	
	@RequestMapping("/customerCare")
	public ModelAndView showcustomerCare(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("customerCare");
	}
	@RequestMapping("/paymentGateway")
	public ModelAndView showPaymentGateway(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("paymentGateway");
	}
	
	@RequestMapping("/cart")
	public ModelAndView showCartSection(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("cartSection");
	}
	
}