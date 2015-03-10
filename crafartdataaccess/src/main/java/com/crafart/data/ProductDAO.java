/**
 * 
 */
package com.crafart.data;

import com.crafart.dataobjects.ProductDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface ProductDAO {

	public int addProduct(ProductDO productDO) throws CrafartDataException;
}
