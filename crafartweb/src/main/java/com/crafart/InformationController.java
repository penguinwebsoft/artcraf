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

	
	@RequestMapping(value = { "/getInformation" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getInformation(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		List<InformationBO> informationBOs = new ArrayList<>();
		try {
			informationBOs = manageInformationServiceImpl.getInformationDetail();
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
			manageInformationServiceImpl.addInformationDetail(InformationBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}
}