/**
 * 
 */
package com.crafart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crafart.inter.service.ManageCurrencyService;
import com.crafart.service.businessobjects.CurrencyBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Controller("currencyController")
@RequestMapping("currency")
public class CurrencyController {

	private static final Logger log = Logger.getLogger(CurrencyController.class);

	@Autowired
	private ManageCurrencyService manageCurrencyServiceImpl;

	
	@RequestMapping(value = { "/getCurrency" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getCurrency(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		List<CurrencyBO> currencyBOs = new ArrayList<>();
		try {
			currencyBOs = manageCurrencyServiceImpl.getCurrencyDetail();
			modelMap.addAttribute("currencyBOs", currencyBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/addCurrency" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addCurrency(@RequestBody CurrencyBO CurrencyBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageCurrencyServiceImpl.addCurrencyDetail(CurrencyBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}

	
}