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

import com.crafart.inter.service.ManageUserService;
import com.crafart.service.businessobjects.UserBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author
 * 
 */
@Controller("userController")
@RequestMapping("user")
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private ManageUserService manageUserServiceImpl;

	
	@RequestMapping(value = { "/getUser" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getUser(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		List<UserBO> userBOs = new ArrayList<>();
		try {
			userBOs = manageUserServiceImpl.getUserDetail();
			modelMap.addAttribute("userBOs", userBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addGeoZone(@RequestBody UserBO UserBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageUserServiceImpl.addUserDetail(UserBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}
}