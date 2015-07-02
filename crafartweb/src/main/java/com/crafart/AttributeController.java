package com.crafart;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crafart.seller.service.ManageAttributeService;
import com.crafart.service.businessobjects.AttributeBO;
import com.crafart.service.exception.CrafartServiceException;

@Controller("attributeController")
@RequestMapping("attribute")
public class AttributeController {

	private static final Logger log = Logger.getLogger(AttributeController.class);

	@Autowired
	private ManageAttributeService manageAttributeServiceImpl;

	@RequestMapping(value = "/addAttribute", method = RequestMethod.POST)
	public @ResponseBody ModelMap addAttribute(@RequestBody AttributeBO attributeBO) {
		ModelMap modelMap = new ModelMap();
		try {
			manageAttributeServiceImpl.addAttribute(attributeBO);
			log.info("******************** category object *****************************" + attributeBO.getSubCategoryBO().getCategoryId());
			return modelMap.addAttribute("response", "SUCCESS");
		} catch (CrafartServiceException csExp) {
			log.error("Error while adding attribute for attribute name - " + attributeBO.getAttributeName(), csExp);
			return modelMap.addAttribute("response", "FAILED");
		} catch (Exception exp) {
			log.error("Error while adding attribute for attribute name - " + attributeBO.getAttributeName(), exp);
			return modelMap.addAttribute("response", "FAILED");
		}
	}

	@RequestMapping(value = "/updateAttribute")
	public @ResponseBody ModelMap updateAttribute(@RequestBody AttributeBO attributeBO) {
		ModelMap modelMap = new ModelMap();
		try {
			manageAttributeServiceImpl.updateAttribute(attributeBO);
			return modelMap.addAttribute("response", "SUCCESS");
		} catch (CrafartServiceException csExp) {
			log.error("Error while updating attribute for attribute id - " + attributeBO.getAttributeId(), csExp);
			return modelMap.addAttribute("response", "FAILED");
		}
	}

	@RequestMapping(value = "/getAttributes", method = RequestMethod.GET)
	public @ResponseBody ModelMap getAttributes(HttpServletResponse response, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			Map<Long, AttributeBO> attributeBOs = manageAttributeServiceImpl.getAttributes();
			session.setAttribute("attributes", attributeBOs);
			return modelMap.addAttribute("attributes", attributeBOs);
		} catch (CrafartServiceException csExp) {
			log.error("Error while retrieving all attributes", csExp);
			try {
				response.sendError(400, "Error while retrieving all attributes");
			} catch (IOException e) {
				log.error("IO Error while retrieving all attributes", csExp);
			}
			return modelMap.addAttribute("response", "FAILED");

		}
	}

	@RequestMapping(value = "/editAttribute", method = RequestMethod.GET)
	public String editAttribute(@RequestParam(value = "attributeId") long attributeId, HttpSession session, final RedirectAttributes redirectAttributes) {
		@SuppressWarnings("unchecked")
		Map<Long, AttributeBO> attributeBOs = (Map<Long, AttributeBO>) session.getAttribute("attributes");
		AttributeBO attributeBO = attributeBOs.get(attributeId);
		log.info("*************attribute object inside edit attribute **************************"+ attributeBO.getAttributeName());
		redirectAttributes.addFlashAttribute("attributeBO", attributeBO);
		return "redirect:/menu/addAttribute"; 
	}
}
