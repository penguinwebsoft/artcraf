/**
 * 
 */
package com.crafart;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.crafart.inter.service.ManageCustomerService;
import com.crafart.service.businessobjects.ContactBO;
import com.crafart.service.businessobjects.CustomerBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Controller("CustomerController")
@RequestMapping("customer")
@SessionAttributes("customerProfile")
public class CustomerController {

	private static final Logger log = Logger.getLogger(CustomerController.class);

	@Autowired
	private ManageCustomerService manageCustomerServiceImpl;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap addCustomer(@RequestBody CustomerBO customerBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			customerBO.setPassword(bCryptPasswordEncoder.encode(customerBO.getPassword()));
			manageCustomerServiceImpl.addCustomerDetail(customerBO);
			session.setAttribute("customerProfile", customerBO);
			modelMap.addAttribute("result",true);
			modelMap.addAttribute("message", "saved successfully");
			modelMap.addAttribute("redirect", "../menu/home");
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding customer details", crafartServiceException);
			modelMap.addAttribute("result",false);
			modelMap.addAttribute("message", "error while adding");
		}
		return modelMap;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap findByEmailId(@RequestParam(value = "userEMailId") String email, @RequestParam(value = "userPassword") String password, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			if (email.isEmpty() || password.isEmpty()) {
				log.info("not an user, login un-successful" + email + ", " + password);
				modelMap.addAttribute("message", "Username or Password cant be empty.");
				return modelMap;
			}
			ContactBO contactBO = manageCustomerServiceImpl.findByEmailId(email);
			if (contactBO != null && contactBO.getContactValue().equals(email)) {
				if (bCryptPasswordEncoder.matches(password, contactBO.getCustomerBO().getPassword()))
					modelMap.addAttribute("message", "success");
				else
					modelMap.addAttribute("message", "password is mismatch");
			} else {
				modelMap.addAttribute("message", "User not exist");
			}
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application error while checking normal login credentials", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = "/checkUser", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap isUserExist(@RequestParam(value = "email") String email, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			log.info("check user called");
			ContactBO contactBO = manageCustomerServiceImpl.findByEmailId(email);
			if (contactBO != null) {
				modelMap.addAttribute("contact", contactBO);
				modelMap.addAttribute("result", true);
			} else {
				modelMap.addAttribute("result", false);
			}
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application error while checking user email", crafartServiceException);
		}
		return modelMap;

	}
}
