/**
 * 
 */
package com.crafart;

import java.util.List;

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
import com.crafart.inter.service.ManageProductRatingService;
import com.crafart.inter.service.ManageProductReviewService;
import com.crafart.service.businessobjects.ContactBO;
import com.crafart.service.businessobjects.CustomerBO;
import com.crafart.service.businessobjects.ProductRatingBO;
import com.crafart.service.businessobjects.ProductReviewBO;
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
	private ManageProductRatingService manageProductRatingServiceImpl;

	@Autowired
	private ManageProductReviewService manageProductReviewServiceImpl;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap addCustomer(@RequestBody CustomerBO customerBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			customerBO.setPassword(bCryptPasswordEncoder.encode(customerBO.getPassword()));
			manageCustomerServiceImpl.addCustomerDetail(customerBO);
			modelMap.addAttribute("result", true);
			modelMap.addAttribute("message", "saved successfully");
			modelMap.addAttribute("redirect", "../menu/home");
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding customer details", crafartServiceException);
			modelMap.addAttribute("result", false);
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
				CustomerBO customerBO = contactBO.getCustomerBO();
				if (bCryptPasswordEncoder.matches(password, contactBO.getCustomerBO().getPassword())) {
					session.setAttribute("customerProfile", customerBO);
					modelMap.addAttribute("message", "success");
				} else
					modelMap.addAttribute("message", "password mismatch");
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

	@RequestMapping(value = "getCustomerDetails", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getCustomerDetails(HttpSession session) {
		ModelMap modelMap = new ModelMap();
		CustomerBO customerBO = (CustomerBO) session.getAttribute("customerProfile");
		modelMap.addAttribute("customerBO", customerBO);
		return modelMap;
	}

	@RequestMapping(value = "updateCustomerDetails", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap updateCustomerDetail(@RequestBody CustomerBO customerBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			CustomerBO customerBO2 = (CustomerBO) session.getAttribute("customerProfile");
			customerBO.setCustomerId(customerBO2.getCustomerId());
			manageCustomerServiceImpl.updateCustomerDetail(customerBO);
			modelMap.addAttribute("result", true);
			session.setAttribute("customerProfile", customerBO);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while updating customer details", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}

	@RequestMapping(value = "updatePassword", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap checkPresentPassword(@RequestParam(value = "newPassword") String newPassword, @RequestParam(value = "presentPassword") String oldPassword, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		if (oldPassword.isEmpty()) {
			modelMap.addAttribute("message", "empty");
			return modelMap;
		}
		CustomerBO customerBO = (CustomerBO) session.getAttribute("customerProfile");
		if ((bCryptPasswordEncoder.matches(oldPassword, customerBO.getPassword()))) {
			customerBO.setPassword(bCryptPasswordEncoder.encode(newPassword));
			try {
				manageCustomerServiceImpl.updateCustomerDetail(customerBO);
				session.setAttribute("customerProfile", customerBO);
				modelMap.addAttribute("message", "success");
			} catch (CrafartServiceException crafartServiceException) {
				log.error("Aplication error while updating password", crafartServiceException);
			} catch (Exception exp) {
				log.error("Exception while updating customer password");
			}
		} else {
			modelMap.addAttribute("message", "failure");
		}
		return modelMap;
	}

	@RequestMapping(value = "getProductRating", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getProductRating(HttpSession session) {
		ModelMap modelMap = new ModelMap();
		CustomerBO customerBO = (CustomerBO) session.getAttribute("customerProfile");
		try {
			List<ProductRatingBO> productRatingBOs = manageProductRatingServiceImpl.getProductRating(customerBO.getCustomerId());
			modelMap.addAttribute("productRatingBOs", productRatingBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application error while getting product rating", crafartServiceException);
		} catch (Exception exp) {
			log.error("Exception while getting rating details");
		}
		return modelMap;
	}

	@RequestMapping(value = "getProductReview", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getProductReview(HttpSession session) {
		ModelMap modelMap = new ModelMap();
		CustomerBO customerBO = (CustomerBO) session.getAttribute("customerProfile");
		try {
			List<ProductReviewBO> productReviewBOs = manageProductReviewServiceImpl.getProductReview(customerBO.getCustomerId());
			modelMap.addAttribute("productReviewBOs", productReviewBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application error while getting product review", crafartServiceException);
		} catch (Exception exp) {
			log.error("Exception while getting review details");
		}
		return modelMap;
	}
}
