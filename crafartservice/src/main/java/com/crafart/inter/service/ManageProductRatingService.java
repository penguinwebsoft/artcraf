/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import com.crafart.service.businessobjects.ProductRatingBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
public interface ManageProductRatingService {

	public List<ProductRatingBO> getProductRating(long customerId)
			throws CrafartServiceException;

	public void addProductRatting(ProductRatingBO productRatingBO) throws CrafartServiceException;

}
