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

import com.crafart.inter.service.ManageBannerService;
import com.crafart.service.businessobjects.BannerBO;
import com.crafart.service.exception.CrafartServiceException;

@Controller("bannerController")
@RequestMapping("banner")
public class BannerController {

	private static final Logger log = Logger.getLogger(BannerController.class);

	@Autowired
	private ManageBannerService manageBannerServiceImpl;

	@RequestMapping(value = { "/getBanner" }, method = RequestMethod.GET)
	public @ResponseBody ModelMap getBanner(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		Map<Long, BannerBO> bannerBOs = new HashMap<>();
		try {
			bannerBOs = manageBannerServiceImpl.getBanners();
			httpSession.setAttribute("bannerBOs", bannerBOs);
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
			manageBannerServiceImpl.addBanner(BannerBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}

	/**
	 * update banner  for {@link Long} banneId
	 * 
	 * @param bannerBO
	 * @param session
	 * @return {@link ModelMap}
	 */
	@RequestMapping(value = { "/updateBanner" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap updateBanner(@RequestBody BannerBO bannerBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageBannerServiceImpl.updateBanner(bannerBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-Error while updating banner for id = " + bannerBO.getBannerId(), crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}

	/**
	 * request directs to edit for banner id = bannerId
	 * 
	 * @param bannerId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "/editBanner" }, method = RequestMethod.GET)
	public ModelAndView editBanner(@RequestParam(value = "bannerId") long bannerId, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		@SuppressWarnings("unchecked")
		Map<Long, BannerBO> bannerBOs = (Map<Long, BannerBO>) session.getAttribute("bannerBOs");
		BannerBO bannerBO = bannerBOs.get(bannerId);
		modelMap.addAttribute("bannerBO", bannerBO);
		return new ModelAndView("editBanner", modelMap);
	}
}