/**
 * 
 */
package com.crafart.inter.service;

import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
public interface ManageProductService {

	public void addProduct(ProductBO productBO) throws CrafartServiceException;

	public ProductBO getProductDetail(long productId) throws CrafartServiceException;

}
