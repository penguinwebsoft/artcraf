/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.ProductReviewDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface ProductReviewDAO {

	public void addProductReview(ProductReviewDO productReviewDO) throws CrafartDataException;

	public List<ProductReviewDO> getProductReview(long customerId) throws CrafartDataException;

	public List<ProductReviewDO> getSingleProductReviews(long productId) throws CrafartDataException;

}
