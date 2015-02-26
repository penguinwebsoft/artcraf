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
@Controller("menuController")
@RequestMapping("menu")
public class MenuController {

	@RequestMapping("/dashboard")
	public ModelAndView showHomePage(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("dashboard");
	}
	
	@RequestMapping("/myAccount")
	public ModelAndView showMyAccount(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("myAccount");
	}
	
	@RequestMapping("/bankDetails")
	public ModelAndView showbankDetails(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("bankDetails");
	}

	@RequestMapping("/shipping")
	public ModelAndView showshipping(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("shipping");
	}
	
	@RequestMapping("/taxInformation")
	public ModelAndView taxInformation(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("taxInformation");
	}
}
