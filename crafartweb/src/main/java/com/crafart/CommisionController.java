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

import com.crafart.inter.service.ManageCommisionService;
import com.crafart.service.businessobjects.CommisionBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 *
 */
@Controller("CommissionController")
@RequestMapping("commission")
public class CommisionController {

	private static final Logger log = Logger.getLogger(CommisionController.class);

	@Autowired
	private ManageCommisionService manageCommissionServiceImpl;

	@RequestMapping(value = { "/addCommision" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addCommision(@RequestBody CommisionBO commissionBO, HttpSession session) {
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
