/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;
import java.util.Map;

import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Deepam
 * 
 */
public interface ManageCategoryService {

	public Map<Long, CategoryBO> getCategories() throws CrafartServiceException;

	public void addCategory(CategoryBO categoryBO) throws CrafartServiceException;
	
	public void updateCategory(CategoryBO categoryBO) throws CrafartServiceException;

	public List<CategoryBO> getSubCategory(long categoryId) throws CrafartServiceException;

	public CategoryBO getCategory(long categoryId) throws CrafartServiceException;
	
	public List<CategoryBO> getAllSubCategories() throws CrafartServiceException;

}
