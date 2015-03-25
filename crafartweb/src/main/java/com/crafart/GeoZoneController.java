/**
 * 
 */
package com.crafart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crafart.exception.CrafartDataException;
import com.crafart.service.ManageGeoZoneService;
import com.crafart.service.businessobjects.GeoZoneBO;

/**
 * @author Karthi
 * 
 */
@Controller("geoZoneController")
@RequestMapping("geoZone")
public class GeoZoneController {

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
		} catch (CrafartDataException e) {
			e.printStackTrace();
		}
		return modelMap;

	}
}
