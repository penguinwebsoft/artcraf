/**
 * 
 */
package com.crafart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crafart.inter.service.ManageCrafartOrderService;
import com.crafart.service.businessobjects.CrafartOrderBO;
import com.crafart.service.businessobjects.CustomerBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Controller("CrafartOrderController")
@RequestMapping("crafartorder")
public class CrafartOrderController {

	private static final Logger log = Logger.getLogger(CrafartOrderController.class);

	@Autowired
	private ManageCrafartOrderService manageCrafartOrderServiceImpl;

	@RequestMapping(value = { "/getOrder" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getCrafartOrder(HttpSession session) {
		ModelMap modelMap = new ModelMap();
		SellerBO sellerBO = (SellerBO) session.getAttribute("sellerprofile");
		List<CrafartOrderBO> crafartOrderBOs = new ArrayList<>();
		try {
			crafartOrderBOs = manageCrafartOrderServiceImpl.getCrafartOrder(sellerBO);
			Map<Long, CrafartOrderBO> crafartOrderMap = new HashMap<>();
			for (CrafartOrderBO crafartOrdertBO : crafartOrderBOs) {
				crafartOrderMap.put(crafartOrdertBO.getOrderId(), crafartOrdertBO);
			}
			session.setAttribute("orderMap", crafartOrderMap);
			modelMap.addAttribute("crafartOrderBOs", crafartOrderBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while retriving order detail", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/showOrder" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap showOrder(@RequestParam(value = "orderId") long orderId, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		log.info("******showorder*******");
		@SuppressWarnings("unchecked")
		Map<Long, CrafartOrderBO> crafartOrderMap = (Map<Long, CrafartOrderBO>) session.getAttribute("orderMap");
		CrafartOrderBO crafartOrderBO = crafartOrderMap.get(orderId);
		log.info("OUTPUT********////////" + crafartOrderBO.getOrderId() + "\t" + crafartOrderBO.getCustomerBO().getCustomerId());
		session.setAttribute("crafartOrderBO", crafartOrderBO);
		modelMap.addAttribute(crafartOrderBO);
		modelMap.addAttribute("redirect", "orderDetails");
		return modelMap;
	}

	@RequestMapping(value = { "/getOrderBO" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getOrderBO(HttpSession session) {
		log.info("********getorderBO********");
		ModelMap modelMap = new ModelMap();
		CrafartOrderBO crafartOrderBO = (CrafartOrderBO) session.getAttribute("crafartOrderBO");
		modelMap.addAttribute(crafartOrderBO);
		return modelMap;
	}

	@RequestMapping(value = { "/getCustomerOrderBO" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getCustomerOrderBO(HttpSession session) {
		log.info("********getCustomerorderBO********");
		ModelMap modelMap = new ModelMap();
		List<CrafartOrderBO> crafartOrderBOs = new ArrayList<>();
		CustomerBO customerBO = (CustomerBO) session.getAttribute("customerProfile");
		try {
			crafartOrderBOs = manageCrafartOrderServiceImpl.getCustomerOrder(customerBO.getCustomerId());
			log.info(crafartOrderBOs.isEmpty());
			if (crafartOrderBOs.isEmpty()){
				modelMap.addAttribute("result", "empty");
				log.info("empty********");
			}
			modelMap.addAttribute("crafartOrderBOs", crafartOrderBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application error while getting customer order details", crafartServiceException);
		}
		return modelMap;
	}
}
