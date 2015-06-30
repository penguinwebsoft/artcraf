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

import com.crafart.inter.service.ManageBannerService;
import com.crafart.service.businessobjects.BannerBO;
import com.crafart.service.exception.CrafartServiceException;


@Controller("bannerController")
@RequestMapping("banner")
public class BannerController {

	private static final Logger log = Logger.getLogger(BannerController.class);

	@Autowired
	private ManageBannerService manageBannerServiceImpl;

	
	@RequestMapping(value = { "/getBanner" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getBanner(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		List<BannerBO> bannerBOs = new ArrayList<>();
		try {
			bannerBOs = manageBannerServiceImpl.getBannerDetail();
			modelMap.addAttribute("bannerBOs", bannerBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/addBanner" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addBanner(@RequestBody BannerBO BannerBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageBannerServiceImpl.addBannerDetail(BannerBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}
}