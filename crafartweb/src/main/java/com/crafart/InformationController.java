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

import com.crafart.inter.service.ManageInformationService;
import com.crafart.service.businessobjects.InformationBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author
 * 
 */
@Controller("InformationController")
@RequestMapping("Information")
public class InformationController {

	private static final Logger log = Logger.getLogger(InformationController.class);

	@Autowired
	private ManageInformationService manageInformationServiceImpl;

	@RequestMapping(value = { "/getInformation" }, method = RequestMethod.GET)
	public @ResponseBody ModelMap getInformation(HttpSession session) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		Map<Long, InformationBO> informationBOs = new HashMap<>();
		try {
			informationBOs = manageInformationServiceImpl.getInformations();
			session.setAttribute("informationBOs", informationBOs);
			modelMap.addAttribute("informationBOs", informationBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/addInformation" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addInformation(@RequestBody InformationBO InformationBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageInformationServiceImpl.addInformation(InformationBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}

	@RequestMapping(value = { "/updateInformation" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap updateInformation(@RequestBody InformationBO InformationBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageInformationServiceImpl.updateInformation(InformationBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while updating information data", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}

	@RequestMapping(value = { "/editInformation" }, method = RequestMethod.GET)
	public @ResponseBody ModelMap editInformation(@RequestParam(value = "informationId") long informationId, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		@SuppressWarnings("unchecked")
		Map<Long, InformationBO> informationBOs = (Map<Long, InformationBO>) session.getAttribute("informationBOs");
		InformationBO informationBO = informationBOs.get(informationId);
		modelMap.addAttribute("inforatmionBO", informationBO);
		return modelMap;
	}
}