package com.crafart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.crafart.service.ManageSellerService;
import com.crafart.service.businessobjects.AddressBO;
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
			log.info("controller");
			manageSellerServiceImpl.addSeller(sellerBO);
			session.setAttribute("sellerprofile", sellerBO);
			log.info("added successfully");
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-Error while adding seller", crafartServiceException);
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
}
