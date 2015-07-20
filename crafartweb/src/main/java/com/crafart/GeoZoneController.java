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

import com.crafart.inter.service.ManageGeoZoneService;
import com.crafart.service.businessobjects.GeoZoneBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Controller("geoZoneController")
@RequestMapping("geoZone")
public class GeoZoneController {

	private static final Logger log = Logger.getLogger(GeoZoneController.class);

	@Autowired
	private ManageGeoZoneService manageGeoZoneServiceImpl;

	
	/**
	 * get all geozone data by invoking service laye
	 * @param httpSession
	 * @return {@link ModelMap}
	 * @throws CrafartServiceException
	 */
	@RequestMapping(value = { "/getGeoZone" }, method = RequestMethod.GET)
	public @ResponseBody
	ModelMap getGeoZone(HttpSession httpSession) throws CrafartServiceException {
		ModelMap modelMap = new ModelMap();
		Map<Long, GeoZoneBO> geoZoneBOs = new HashMap<>();
		try {
			geoZoneBOs = manageGeoZoneServiceImpl.getGeoZones();
			httpSession.setAttribute("geoZoneBOs", geoZoneBOs);
			modelMap.addAttribute("geoZoneBOs", geoZoneBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}

	/**
	 * add geozone data
	 * @param GeoZoneBO
	 * @param session
	 * @return {@link ModelMap}
	 */
	@RequestMapping(value = { "/addGeoZone" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addGeoZone(@RequestBody GeoZoneBO GeoZoneBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageGeoZoneServiceImpl.addGeoZone(GeoZoneBO);
			modelMap.addAttribute("geoZoneBO", GeoZoneBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}
	
	/**
	 * update geozone data
	 * @param geoZoneBO
	 * @param session
	 * @return {@link ModelMap}
	 */
	@RequestMapping(value = { "/updateGeoZone" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap updateGeoZone(@RequestBody GeoZoneBO geoZoneBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageGeoZoneServiceImpl.updateGeoZone(geoZoneBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while updating length class data", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;
	}

	/**
	 * redirect to edit geozone view to update geozone data
	 * @param geoZoneId
	 * @param session
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = { "/editGeoZone" }, method = RequestMethod.GET)
	public @ResponseBody ModelAndView editGeoZone(@RequestParam(value = "geoZoneId") long geoZoneId, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		@SuppressWarnings("unchecked")
		Map<Long, GeoZoneBO> geoZoneBOs = (Map<Long, GeoZoneBO>) session.getAttribute("geoZoneBOs");
		GeoZoneBO geoZoneBO = geoZoneBOs.get(geoZoneId);
		modelMap.addAttribute("geoZoneBO", geoZoneBO);
		return new ModelAndView("editGeoZone", modelMap);
	}
}