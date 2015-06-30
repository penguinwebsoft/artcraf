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

import com.crafart.inter.service.ManageBannerGroupService;
import com.crafart.service.businessobjects.BannerGroupBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author 
 * 
 */
@Controller("bannerGroupController")
@RequestMapping("bannerGroup")
public class BannerGroupController {

	private static final Logger log = Logger.getLogger(BannerGroupController.class);

	@Autowired
	private ManageBannerGroupService manageBannerGroupServiceImpl;

	
	@RequestMapping(value = { "/getBannerGroup" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getBannerGroup(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		List<BannerGroupBO> bannerGroupBOs = new ArrayList<>();
		try {
			bannerGroupBOs = manageBannerGroupServiceImpl.getBannerGroupDetail();
			modelMap.addAttribute("bannerGroupBOs", bannerGroupBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/addBannerGroup" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addBannerGroup(@RequestBody BannerGroupBO BannerGroupBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageBannerGroupServiceImpl.addBannerGroupDetail(BannerGroupBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}
}