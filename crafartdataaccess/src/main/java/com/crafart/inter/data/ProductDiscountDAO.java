/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.ProductDiscountDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface ProductDiscountDAO {

	public void addProductDiscount(List<ProductDiscountDO> productDiscountDO) throws CrafartDataException;
}
