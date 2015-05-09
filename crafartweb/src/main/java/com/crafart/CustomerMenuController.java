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
@RequestMapping("customerMenu")
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
	
	
	@RequestMapping("/manageEmail")
	public ModelAndView showManageEmail(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("manageEmail");
	}
	

}
