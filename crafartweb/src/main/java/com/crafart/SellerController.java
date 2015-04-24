package com.crafart;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.ModelAndView;

import com.crafart.inter.service.ManageSellerService;
import com.crafart.inter.service.ManageStoreService;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.ContactBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.businessobjects.StoreBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Controller("sellerController")
@RequestMapping("seller")
@SessionAttributes("sellerprofile")
public class SellerController {

	private static final Logger log = Logger.getLogger(SellerController.class);

	@Autowired
	private ManageSellerService manageSellerServiceImpl;

	@Autowired
	private ManageStoreService manageStoreServiceImpl;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	/**
	 * controller method responsible to add new seller details, it takes seller
	 * details {@link SellerBO} from the user. Error during the adding process
	 * result in throwing crafart service exception
	 * {@link CrafartServiceException}
	 * 
	 * @param sellerBO
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = { "/addSeller" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap addSeller(@RequestBody SellerBO sellerBO, StoreBO storeBO, AddressBO addressBO, HttpServletRequest httpServletRequest, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			sellerBO.setPassword(bCryptPasswordEncoder.encode(sellerBO.getPassword()));
			manageSellerServiceImpl.addSeller(sellerBO);
			session.setAttribute("sellerprofile", sellerBO);
			modelMap.addAttribute("result", true);
			modelMap.addAttribute("message", "saved successfully");
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-Error while adding seller", crafartServiceException);
			modelMap.addAttribute("result", false);
			modelMap.addAttribute("message", "error while adding");
		}
		return modelMap;

	}

	@RequestMapping(value = { "/updateStore" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap updateStore(@RequestBody SellerBO sellerBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			SellerBO sellerBO2 = (SellerBO) session.getAttribute("sellerprofile");
			sellerBO2.getStoreBO().setStoreReturn(sellerBO.getStoreBO().getStoreReturn());
			manageSellerServiceImpl.updateSeller(sellerBO2);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while updating store", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/updatetax" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap updateSellerTax(@RequestBody SellerBO sellerBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			SellerBO sellerBO2 = (SellerBO) session.getAttribute("sellerprofile");
			sellerBO2.setVatNo(sellerBO.getVatNo());
			sellerBO2.setCstNo(sellerBO.getCstNo());
			manageSellerServiceImpl.updateSeller(sellerBO2);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while updating sellertax", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/checkStoreUrlAvailability" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap checkStoreUrl(@RequestParam(value = "shopUrl") String storeUrl, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			StoreBO storeBO = manageStoreServiceImpl.checkStoreUrl(storeUrl);
			if (storeBO != null) {
				modelMap.addAttribute("return", true);
				modelMap.addAttribute("message", "ShopURL exist try other");
			} else {
				modelMap.addAttribute("message", "ShopURL Available");
			}
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while checking shopurl", crafartServiceException);
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
			ContactBO contactBO = manageSellerServiceImpl.findByEmailId(email);
			if (contactBO != null && contactBO.getContactValue().equals(email)) {
				if (bCryptPasswordEncoder.matches(password, contactBO.getSellerBO().getPassword()))
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
}
