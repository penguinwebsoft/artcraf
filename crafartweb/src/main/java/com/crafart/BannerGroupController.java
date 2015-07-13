/**
 * 
 */
package com.crafart;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

	/**
	 * 
	 * @param httpSession
	 * @return
	 * @throws CrafartServiceException
	 */
	@RequestMapping(value = { "/getBannerGroup" }, method = RequestMethod.GET)
	public @ResponseBody ModelMap getBannerGroup(HttpSession session) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		Map<Long, BannerGroupBO> bannerGroupBOs = new HashMap<>();
		try {
			bannerGroupBOs = manageBannerGroupServiceImpl.getBannerGroups();
			session.setAttribute("bannerGroupBOs", bannerGroupBOs);
			modelMap.addAttribute("bannerGroupBOs", bannerGroupBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/addBannerGroup" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addBannerGroup(@RequestBody BannerGroupBO bannerGroupBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageBannerGroupServiceImpl.addBannerGroup(bannerGroupBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}
	
	/**
	 * update banner group for {@link Long} banneGroupId
	 * @param bannerGroupBO
	 * @param session
	 * @return {@link ModelMap}
	 */
	@RequestMapping(value = { "/updateBannerGroup" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap updateBannerGroup(@RequestBody BannerGroupBO bannerGroupBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageBannerGroupServiceImpl.updateBannerGroup(bannerGroupBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-Error while updating banner groupd for id = "+ bannerGroupBO.getBannerGroupId(), crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}
	
	/**
	 * request directs to edit for banner group id = bannerGroupId
	 * @param bannerGroupId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "/editBannerGroup" }, method = RequestMethod.GET)
	public ModelAndView editBannerGroup(@RequestParam(value = "bannerGroupId") long bannerGroupId, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		@SuppressWarnings("unchecked")
		Map<Long, BannerGroupBO> bannerGroupBOs = (Map<Long, BannerGroupBO>) session.getAttribute("bannerGroupBOs");
		BannerGroupBO bannerGroupBO = bannerGroupBOs.get(bannerGroupId);
		modelMap.addAttribute("bannerGroupBO", bannerGroupBO);
		return new ModelAndView("editBannerGroup", modelMap);
	}
}