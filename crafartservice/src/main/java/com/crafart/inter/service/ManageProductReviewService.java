/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import com.crafart.service.businessobjects.ProductReviewBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
public interface ManageProductReviewService {

	public List<ProductReviewBO> getProductReview(long customerId) throws CrafartServiceException;

	public List<ProductReviewBO> getSingleProductReviews(long productId) throws CrafartServiceException;

	public void addProductReview(ProductReviewBO productReviewBO) throws CrafartServiceException;
}
