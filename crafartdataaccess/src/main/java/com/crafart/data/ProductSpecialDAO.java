/**
 * 
 */
package com.crafart.data;

import java.util.List;

import com.crafart.dataobjects.ProductSpecialDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface ProductSpecialDAO {

	public void addProductSpecial(List<ProductSpecialDO> productSpecialDO) throws CrafartDataException;
}
