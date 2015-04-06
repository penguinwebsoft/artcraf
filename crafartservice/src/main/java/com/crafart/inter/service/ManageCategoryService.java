/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Deepam
 * 
 */
public interface ManageCategoryService {

	public List<CategoryBO> getCategory() throws CrafartServiceException;

	public void addCategory(CategoryBO categoryBO) throws CrafartServiceException;
}
