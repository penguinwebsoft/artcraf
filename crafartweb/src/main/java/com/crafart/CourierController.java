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

import com.crafart.inter.service.ManageCourierService;
import com.crafart.service.businessobjects.CourierBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Controller("courierController")
@RequestMapping("courier")
public class CourierController {

	private static final Logger log = Logger.getLogger(CourierController.class);

	@Autowired
	private ManageCourierService manageCourierServiceImpl;

	@RequestMapping(value = { "/getCourier" }, method = RequestMethod.GET)
	public @ResponseBody ModelMap getCourierDetail(HttpSession httpSession) {
		ModelMap modelMap = new ModelMap();
		Map<Long, CourierBO> courierBOs = new HashMap<>();
		try {
			courierBOs = manageCourierServiceImpl.getCouriers();
			httpSession.setAttribute("courierBOs", courierBOs);
			modelMap.addAttribute("courierBOs", courierBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-Error while retriving courier detail", crafartServiceException);
		}
		return modelMap;
	}

	@RequestMapping(value = { "/addCourier" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addCourier(@RequestBody CourierBO courierBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageCourierServiceImpl.addCourier(courierBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding courier", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}

	/**
	 * update courier data
	 * 
	 * @param courierBO
	 * @param session
	 * @return {@link ModelMap}
	 */
	@RequestMapping(value = { "/updateCourier" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap updateCourier(@RequestBody CourierBO courierBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageCourierServiceImpl.updateCourier(courierBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while updating length class data", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}

	/**
	 * redirect to edit courier view to update courier data
	 * 
	 * @param courierId
	 * @param session
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = { "/editCourier" }, method = RequestMethod.GET)
	public @ResponseBody ModelAndView editCourier(@RequestParam(value = "courierId") long courierId, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		@SuppressWarnings("unchecked")
		Map<Long, CourierBO> courierBOs = (Map<Long, CourierBO>) session.getAttribute("courierBOs");
		CourierBO courierBO = courierBOs.get(courierId);
		modelMap.addAttribute("courierBO", courierBO);
		return new ModelAndView("editCourier", modelMap);
	}

}
