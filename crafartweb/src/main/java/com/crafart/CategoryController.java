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

import com.crafart.inter.service.ManageCategoryService;
import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Deepam
 * 
 */
@Controller("CategoryController")
@RequestMapping("category")
public class CategoryController {

	private static final Logger log = Logger.getLogger(CategoryController.class);

	@Autowired
	private ManageCategoryService manageCategoryServiceImpl;

	@RequestMapping(value = { "/getCategory" }, method = RequestMethod.POST)
	public @ResponseBody
	ModelMap getCategory(HttpSession session) {
		ModelMap modelMap = new ModelMap();
		List<CategoryBO> categoryBOs = new ArrayList<>();
		try {
			categoryBOs = manageCategoryServiceImpl.getCategory();
			modelMap.addAttribute("categoryBOs", categoryBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving category details from db", crafartServiceException);
		}
		return modelMap;

	}
}
