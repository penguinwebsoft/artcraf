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

import com.crafart.inter.service.ManageUserGroupService;
import com.crafart.service.businessobjects.UserGroupBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author
 * 
 */
@Controller("UserGroupController")
@RequestMapping("userGroup")
public class UserGroupController {

	private static final Logger log = Logger.getLogger(UserGroupController.class);

	@Autowired
	private ManageUserGroupService manageUserGroupServiceImpl;

	
	@RequestMapping(value = { "/getUserGroup" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getUserGroup(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		List<UserGroupBO> userGroupBOs = new ArrayList<>();
		try {
			userGroupBOs = manageUserGroupServiceImpl.getUserGroupDetail();
			modelMap.addAttribute("userGroupBOs", userGroupBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/addUserGroup" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addUserGroup(@RequestBody UserGroupBO UserGroupBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageUserGroupServiceImpl.addUserGroupDetail(UserGroupBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}
}