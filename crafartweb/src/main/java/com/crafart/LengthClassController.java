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

import com.crafart.inter.service.ManageLengthClassService;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Controller("lengthClassController")
@RequestMapping("lengthClass")
public class LengthClassController {

	private static final Logger log = Logger.getLogger(LengthClassController.class);

	@Autowired
	private ManageLengthClassService manageLengthClassServiceImpl;

	
	@RequestMapping(value = { "/getLengthClasses" }, method = RequestMethod.GET)
	public @ResponseBody
	ModelMap getLengthClass(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		Map<Long, LengthClassBO> lengthClassBOs = new HashMap<>();
		try {
			lengthClassBOs = manageLengthClassServiceImpl.getLengthClass();
			httpSession.setAttribute("lengthClassBOs", lengthClassBOs);
			modelMap.addAttribute("lengthClassBOs", lengthClassBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/addLengthClass" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addLengthClass(@RequestBody LengthClassBO lengthClassBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageLengthClassServiceImpl.addLengthClass(lengthClassBO);
			modelMap.addAttribute("lengthClassBO", lengthClassBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}
	
	@RequestMapping(value = { "/updateLengthClass" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap updateLengthClass(@RequestBody LengthClassBO lengthClassBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageLengthClassServiceImpl.updateLengthClass(lengthClassBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while updating length class data", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}

	@RequestMapping(value = { "/editLengthClass" }, method = RequestMethod.GET)
	public @ResponseBody ModelAndView editLengthClass(@RequestParam(value = "lengthClassId") long lengthClassId, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		@SuppressWarnings("unchecked")
		Map<Long, LengthClassBO> lengthClassBOs = (Map<Long, LengthClassBO>) session.getAttribute("lengthClassBOs");
		LengthClassBO lengthClassBO = lengthClassBOs.get(lengthClassId);
		modelMap.addAttribute("lengthClassBO", lengthClassBO);
		return new ModelAndView("editLengthClass", modelMap);
	}
}