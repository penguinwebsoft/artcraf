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

	@RequestMapping(value = { "/getCourier" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getCourierDetail(HttpSession httpSession) {
		ModelMap modelMap = new ModelMap();
		List<CourierBO> courierBOs = new ArrayList<>();
		try {
			courierBOs = manageCourierServiceImpl.getCourierDetail();
			modelMap.addAttribute("courierBOs",courierBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-Error while retriving courier detail", crafartServiceException);
		}
		return modelMap;

	}
}
