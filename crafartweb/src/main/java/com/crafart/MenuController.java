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
	public ModelAndView showHomePage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("dashboard");
	}

	@RequestMapping("/myAccount")
	public ModelAndView showMyAccount(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("myAccount");
	}

	@RequestMapping("/bankDetails")
	public ModelAndView showbankDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("bankDetails");
	}

	@RequestMapping("/shipping")
	public ModelAndView showshipping(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("shipping");
	}

	@RequestMapping("/taxInformation")
	public ModelAndView showtaxInformation(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("taxInformation");
	}

	@RequestMapping("/product")
	public ModelAndView showProduct(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("product");
	}

	@RequestMapping("/addProduct")
	public ModelAndView showAddProduct(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addProduct");
	}

	@RequestMapping("/orders")
	public ModelAndView showOrders(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("orders");
	}

	@RequestMapping("/orderDetails")
	public ModelAndView showorderDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("orderDetails");
	}

	@RequestMapping("/transactions")
	public ModelAndView showTransactions(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("transactions");
	}

	@RequestMapping("/reportView")
	public ModelAndView showReportView(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("reportView");
	}

	@RequestMapping("/reportPurchase")
	public ModelAndView showReportPurchase(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("reportPurchase");
	}

	@RequestMapping("/login")
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/home")
	public ModelAndView showHome(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("home");
	}
}
