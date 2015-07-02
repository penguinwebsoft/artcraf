/**
 * 
 */
package com.crafart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crafart.inter.service.ManageCategoryService;
import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Prabaharan
 * @version 1.0
 * 
 */
@Controller("CategoryController")
@RequestMapping("category")
public class CategoryController {

	private static final Logger log = Logger.getLogger(CategoryController.class);

	@Autowired
	private ManageCategoryService manageCategoryServiceImpl;

	@RequestMapping(value = { "/getCategory" }, method = RequestMethod.GET)
	public @ResponseBody ModelMap getCategories(HttpSession session) {
		ModelMap modelMap = new ModelMap();
		Map<Long, CategoryBO> categoryBOs = new HashMap<>();
		try {
			categoryBOs = manageCategoryServiceImpl.getCategories();
			session.setAttribute("categories", categoryBOs);
			modelMap.addAttribute("categoryBOs", categoryBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application Error while retrieving all category details", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/getAllSubCategories" }, method = RequestMethod.GET)
	public @ResponseBody ModelMap getAllSubCategories(HttpSession session) {
		ModelMap modelMap = new ModelMap();
		List<CategoryBO> categoryBOs = new ArrayList<>();
		try {
			categoryBOs = manageCategoryServiceImpl.getAllSubCategories();
			modelMap.addAttribute("subCategoryBOs", categoryBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application Error while retrieving all sub category details", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/getSubCategory" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap getSubCategory(@RequestParam(value = "categoryId") long categoryId, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		List<CategoryBO> categoryBOs = new ArrayList<>();
		try {
			categoryBOs = manageCategoryServiceImpl.getSubCategory(categoryId);
			modelMap.addAttribute("subCategoryBOs", categoryBOs);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error in retrieving sub category details from db", crafartServiceException);
		}
		return modelMap;

	}

	@RequestMapping(value = { "/addCategory" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap addCategory(@RequestBody CategoryBO categoryBO, HttpSession session) {
		ModelMap modelMap = new ModelMap();
		try {
			manageCategoryServiceImpl.addCategory(categoryBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}
	
	@RequestMapping(value = { "/updateCategory" }, method = RequestMethod.POST)
	public @ResponseBody ModelMap updateCategory(@RequestBody CategoryBO categoryBO) {
		ModelMap modelMap = new ModelMap();
		try {
			manageCategoryServiceImpl.updateCategory(categoryBO);
			modelMap.addAttribute("result", true);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Application-error while adding to DB", crafartServiceException);
			modelMap.addAttribute("result", false);
		}
		return modelMap;

	}
	
	/**
	 * redirects to menu/addCategory controller passing {@link CategoryBO} object as a flash attribute to that controller.
	 * <li> Method gets corresponding {@link CategoryBO} object for {@link Long} categoryId
	 * @param categoryId
	 * @param redirectAttributes
	 * @param session
	 * @return String
	 */
	@RequestMapping(value = { "/editCategory" }, method = RequestMethod.GET)
	public String editCategory(@RequestParam(value="categoryId") long categoryId, RedirectAttributes redirectAttributes, HttpSession session){
		@SuppressWarnings("unchecked")
		Map<Long, CategoryBO> categoryBOs = (Map<Long, CategoryBO>) session.getAttribute("categories");
		CategoryBO categoryBO = categoryBOs.get(categoryId);
		redirectAttributes.addFlashAttribute("categoryBO", categoryBO);
		return "redirect:/menu/addCategory";
	}

}
