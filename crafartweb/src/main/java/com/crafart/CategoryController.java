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

import com.crafart.service.ManageCategoryService;
import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Deepam
 * 
 */
@Controller("CategoryController")
@RequestMapping("category")
public class CategoryController {

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
		} catch (CrafartServiceException e) {
			e.printStackTrace();
		}
		return modelMap;

	}
}
