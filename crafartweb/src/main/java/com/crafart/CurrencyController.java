/**
 * 
 */
package com.crafart;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = { "/getCurrencies" }, method = RequestMethod.GET)
	public @ResponseBody ModelMap getCurrencies(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		Map<Long, CurrencyBO> currencyBOs = new HashMap<>();
		try {
			currencyBOs = manageCurrencyServiceImpl.getCurrencys();
			modelMap.addAttribute("currencyBOs", currencyBOs);
			httpSession.setAttribute("currencyBOs", currencyBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/addCurrency" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addCurrency(@RequestBody CurrencyBO currencyBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageCurrencyServiceImpl.addCurrency(currencyBO);
			modelMap.addAttribute("currencyBO", currencyBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}

	/**
	 * update currency data
	 * 
	 * @param currencyBO
	 * @param session
	 * @return {@link ModelMap}
	 */
	@RequestMapping(value = { "/updateCurrency" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap updateCurrency(@RequestBody CurrencyBO currencyBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageCurrencyServiceImpl.updateCurrency(currencyBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while updating length class data", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}

	/**
	 * redirect to edit currency view to update currency data
	 * 
	 * @param currencyId
	 * @param session
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = { "/editCurrency" }, method = RequestMethod.GET)
	public @ResponseBody ModelAndView editCurrency(@RequestParam(value = "currencyId") long currencyId, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		@SuppressWarnings("unchecked")
		Map<Long, CurrencyBO> currencyBOs = (Map<Long, CurrencyBO>) session.getAttribute("currencyBOs");
		CurrencyBO currencyBO = currencyBOs.get(currencyId);
		modelMap.addAttribute("currencyBO", currencyBO);
		return new ModelAndView("editCurrency", modelMap);
	}
}