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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crafart.service.ManageGeoZoneService;
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
	ManageGeoZoneService manageGeoZoneServiceImpl;

	@RequestMapping(value = { "/getGeoZone" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getGeoZone(HttpSession httpSession) {
		ModelMap modelMap = new ModelMap();
		List<GeoZoneBO> geoZoneBOs = new ArrayList<>();
		try {
			geoZoneBOs = manageGeoZoneServiceImpl.getGeoZoneDetail();
			modelMap.addAttribute("geoZoneBOs", geoZoneBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving details from DB", crafartServiceException);
		}
		return modelMap;

	}
}
