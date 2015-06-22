/**
 * 
 */
package com.crafart;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crafart.inter.service.ManageAccountService;
import com.crafart.service.businessobjects.AccountBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Controller("AccountController")
@RequestMapping("account")
public class AccountController {

	public static final Logger log = Logger.getLogger(AccountController.class);

	@Autowired
	public ManageAccountService manageAccountServiceImpl;

	@RequestMapping(value = { "/addAccount" }, method = RequestMethod.POST)
	@ResponseBody
	public ModelMap addBankAccountDetail(@RequestBody AccountBO accountBO, HttpServletRequest httpServletRequest) {
		ModelMap modelMap = new ModelMap();
		try {
			manageAccountServiceImpl.addBankAccountDetail(accountBO);
			return modelMap.addAttribute("response", "SUCCESS");
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Error while adding account detail from controller, AccoundId is " + accountBO.getAccountId(), crafartServiceException);
			return modelMap.addAttribute("response", "FAILED");
		}
	}
}
