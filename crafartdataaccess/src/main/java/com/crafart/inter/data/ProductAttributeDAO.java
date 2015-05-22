/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.ProductAttributeDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface ProductAttributeDAO {

	public void addProductAttribute(List<ProductAttributeDO> productAttributeDOs) throws CrafartDataException;

	public List<ProductAttributeDO> getProductAttribute(long productId) throws CrafartDataException;

}
