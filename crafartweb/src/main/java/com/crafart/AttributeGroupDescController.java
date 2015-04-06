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

import com.crafart.inter.service.ManageAttributeGroupDescService;
import com.crafart.service.businessobjects.AttributeGroupDescBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Controller("AttributeGroupDescController")
@RequestMapping("attributegroupdesc")
public class AttributeGroupDescController {

	private static final Logger log = Logger.getLogger(AttributeGroupDescController.class);

	@Autowired
	private ManageAttributeGroupDescService manageAttributeGroupDescServiceImpl;

	@RequestMapping(value = { "/getAttributeGroupDesc" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getAttributeGroupDesc(HttpSession session) {
		ModelMap modelMap = new ModelMap();
		log.info("AttributeController*****&&&&&^^^^%%%$$##");
		List<AttributeGroupDescBO> attributeGroupDescBOs = new ArrayList<>();
		try {
			attributeGroupDescBOs = manageAttributeGroupDescServiceImpl.getAttributeGroupDesc();
			modelMap.addAttribute("attributeGroupDescBOs", attributeGroupDescBOs);
			log.info("*****&&&&&&^^^^^^^"+attributeGroupDescBOs.size());
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving attribute group description details from db", crafartServiceException);
		}
		return modelMap;

	}
}
