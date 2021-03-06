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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.crafart.inter.service.ManageTaxClassService;
import com.crafart.service.businessobjects.TaxClassBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Controller("taxClassController")
@SessionAttributes("taxClassProfile")
@RequestMapping("taxClass")
public class TaxClassController {

	private static final Logger log = Logger.getLogger(TaxClassController.class);
	
		@Autowired
		private ManageTaxClassService manageTaxClassServiceImpl;

		
		@RequestMapping(value = { "/getTaxClass" }, method = RequestMethod.POST)
		public @ResponseBody
		ModelMap getTaxClass(HttpSession httpSession) throws CrafartServiceException {
			ModelMap modelMap = new ModelMap();
			List<TaxClassBO> taxClassBOs = new ArrayList<>();
			try {
				taxClassBOs = manageTaxClassServiceImpl.getTaxClassDetail();
				modelMap.addAttribute("taxClassBOs", taxClassBOs);
			} catch (CrafartServiceException crafartServiceException) {
				log.error("Application-error in retrieving details from DB", crafartServiceException);
			}
			return modelMap;

		}

		@RequestMapping(value = { "/addTaxClass" }, method = RequestMethod.POST)
		public @ResponseBody ModelMap addTaxClass(@RequestBody TaxClassBO TaxClassBO, HttpSession session) {
			ModelMap modelMap = new ModelMap();
			try {
				manageTaxClassServiceImpl.addTaxClassDetail(TaxClassBO);
				modelMap.addAttribute("result", true);
			} catch (CrafartServiceException crafartServiceException) {
				log.error("Application-error while adding to DB", crafartServiceException);
				modelMap.addAttribute("result", false);
			}
			return modelMap;

		}

	}


