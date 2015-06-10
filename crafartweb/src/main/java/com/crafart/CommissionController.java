/**
 * 
 */
package com.crafart;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crafart.inter.service.ManageCommissionService;
import com.crafart.service.businessobjects.CommissionBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 *
 */
@Controller("CommissionController")
@RequestMapping("commission")
public class CommissionController {

	private static final Logger log = Logger.getLogger(CommissionController.class);

	@Autowired
	private ManageCommissionService manageCommissionServiceImpl;

	@RequestMapping(value = { "/addCommission" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addCommission(@RequestBody CommissionBO commissionBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageCommissionServiceImpl.addCommission(commissionBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}
}
