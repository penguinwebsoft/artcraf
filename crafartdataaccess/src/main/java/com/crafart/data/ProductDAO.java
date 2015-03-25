/**
 * 
 */
package com.crafart.data;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.ProductDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
@Repository("productDAO")
public interface ProductDAO {

	public int addProduct(ProductDO productDO) throws CrafartDataException;
}
