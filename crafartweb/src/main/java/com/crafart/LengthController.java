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

import com.crafart.inter.service.ManageLengthClassService;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Controller("lengthClassController")
@RequestMapping("lengthClass")
public class LengthController {

	private static final Logger log = Logger.getLogger(LengthController.class);

	@Autowired
	private ManageLengthClassService manageLengthClassServiceImpl;

	
	@RequestMapping(value = { "/getLengthClass" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getLengthClass(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		List<LengthClassBO> lengthClassBOs = new ArrayList<>();
		try {
			lengthClassBOs = manageLengthClassServiceImpl.getLengthClassDetail();
			modelMap.addAttribute("lengthClassBOs", lengthClassBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/addLengthClass" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addLengthClass(@RequestBody LengthClassBO LengthClassBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageLengthClassServiceImpl.addLengthClassDetail(LengthClassBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}
}