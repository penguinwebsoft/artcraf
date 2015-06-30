/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.CategoryDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
@Repository("CategoryDAO")
public interface CategoryDAO {

	public void addCategory(CategoryDO categoryDO) throws CrafartDataException;

	public void updateCategory(CategoryDO categoryDO) throws CrafartDataException;
	
	public List<CategoryDO> getCategories() throws CrafartDataException;

	public List<CategoryDO> getSubCategory(long categoryId) throws CrafartDataException;
	
	public List<CategoryDO> getAllSubCategories()throws CrafartDataException;
 	
	public CategoryDO getCategory(long categoryId) throws CrafartDataException;
	
	public CategoryDO getCategoryeDO(long attributeId) throws CrafartDataException;
}
