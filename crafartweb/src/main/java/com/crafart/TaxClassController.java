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

tMapping(value = { " /getTaxClass " }, method = RequestMethod.POST)
	public @ResponseBody
alue = { " /getTaxClass " }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getTaxClassDetail(HttpSession session) {
 @ResponseBody ModelMap getTaxClassDetail(HttpSession session) {
BOs = new ArrayLis			modelMap.addAttribute("taxClassBOs", taxClassBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding taxdetails", crafartServiceException);
log.error("Application-error while adding taxdetails", crafartServiceException);
		}
		return modelMap;

	}
}