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

	public List<CategoryDO> getCategory() throws CrafartDataException;
}
