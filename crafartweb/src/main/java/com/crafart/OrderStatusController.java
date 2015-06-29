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

import com.crafart.inter.service.ManageOrderStatusService;
import com.crafart.service.businessobjects.OrderStatusBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author
 * 
 */
@Controller("orderStatusController")
@RequestMapping("orderStatus")
public class OrderStatusController {

	private static final Logger log = Logger.getLogger(OrderStatusController.class);

	@Autowired
	private ManageOrderStatusService manageOrderStatusServiceImpl;

	
	@RequestMapping(value = { "/getOrderStatus" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getOrderStatus(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		List<OrderStatusBO> orderStatusBOs = new ArrayList<>();
		try {
			orderStatusBOs = manageOrderStatusServiceImpl.getOrderStatusDetail();
			modelMap.addAttribute("orderStatusBOs", orderStatusBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/addOrderStatus" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addOrderStatus(@RequestBody OrderStatusBO OrderStatusBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageOrderStatusServiceImpl.addOrderStatusDetail(OrderStatusBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}
}