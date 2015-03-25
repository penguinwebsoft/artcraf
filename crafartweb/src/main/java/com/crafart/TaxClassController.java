/**
 * 
 */
package com.crafart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.crafart.service.ManageTaxClassService;
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

	@Autowired
	private ManageTaxClassService manageTaxClassServiceImpl;

	@RequestMapping(value = { " /getTaxClass " }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getTaxClassDetail(HttpSession session) {
		ModelMap modelMap = new ModelMap();
		List<TaxClassBO> taxClassBOs = new ArrayList<>();
		try {
			taxClassBOs = manageTaxClassServiceImpl.getTaxClassDetail();
			session.setAttribute("taxClass", taxClassBOs.get(0));
			modelMap.addAttribute("taxClassBOs", taxClassBOs);
		} catch (CrafartServiceException e) {
			e.printStackTrace();
		}
		return modelMap;

	}
}