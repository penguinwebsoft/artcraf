package com.crafart;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crafart.service.ManageSellerService;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Controller("sellerController")
@RequestMapping("seller")
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
	ModelMap addSeller(@RequestBody SellerBO sellerBO, HttpServletRequest httpServletRequest) {
		ModelMap modelMap = new ModelMap();
		try {
			log.info("controller");
			manageSellerServiceImpl.addSeller(sellerBO);
			log.info("added successfully");
		} catch (Exception uExp) {
			log.error("Error while adding seller", uExp);
		}
		return modelMap;

	}
}
