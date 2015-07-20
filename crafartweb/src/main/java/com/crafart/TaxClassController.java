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

import com.crafart.inter.service.ManageTaxClassService;
import com.crafart.service.businessobjects.TaxClassBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Controller("taxClassController")
@RequestMapping("taxClass")
public class TaxClassController {

	private static final Logger log = Logger.getLogger(TaxClassController.class);

	@Autowired
	private ManageTaxClassService manageTaxClassServiceImpl;

	/**
	 * get all taxclasses upon calling service layer
	 * @param session
	 * @return {@link ModelMap}
	 */
	@RequestMapping(value = { "/getTaxClass" }, method = RequestMethod.GET)
	public @ResponseBody ModelMap getTaxClass(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		Map<Long, TaxClassBO> taxClassBOs = new HashMap<>();
		try {
			taxClassBOs = manageTaxClassServiceImpl.getTaxClasses();
			modelMap.addAttribute("taxClassBOs", taxClassBOs);
			httpSession.setAttribute("taxClassBOs", taxClassBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}
	
	
	/**
	 * add taxclass upon calling service layer
	 * @param TaxClassBO
	 * @param session
	 * @return {@link ModelMap}
	 */
	@RequestMapping(value = { "/addTaxClass" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addTaxClass(@RequestBody TaxClassBO taxClassBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageTaxClassServiceImpl.addTaxClass(taxClassBO);
			modelMap.addAttribute("taxClassBO", taxClassBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}
	
	
	/**
	 * update taxClass data
	 * @param taxClassBO
	 * @param session
	 * @return {@link ModelMap}
	 */
	@RequestMapping(value = { "/updateTaxClass" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap updateTaxClass(@RequestBody TaxClassBO taxClassBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageTaxClassServiceImpl.updateTaxClass(taxClassBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while updating length class data", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}

	/**
	 * redirect to edit taxClass view to update taxClass data
	 * @param taxClassId
	 * @param session
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = { "/editTaxClass" }, method = RequestMethod.GET)
	public @ResponseBody ModelAndView editTaxClass(@RequestParam(value = "taxClassId") long taxClassId, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		@SuppressWarnings("unchecked")
		Map<Long, TaxClassBO> taxClassBOs = (Map<Long, TaxClassBO>) session.getAttribute("taxClassBOs");
		TaxClassBO taxClassBO = taxClassBOs.get(taxClassId);
		modelMap.addAttribute("taxClassBO", taxClassBO);
		return new ModelAndView("editTaxClass", modelMap);
	}
}
