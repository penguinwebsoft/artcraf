/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.ProductShippingDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface ProductShippingDAO {

	public void addProductShipping(List<ProductShippingDO> productShippingDOs) throws CrafartDataException;
}
