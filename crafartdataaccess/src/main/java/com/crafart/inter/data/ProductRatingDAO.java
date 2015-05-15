/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.ProductRatingDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface ProductRatingDAO {

	public void addProductRating(ProductRatingDO productRatingDO) throws CrafartDataException;

	public List<ProductRatingDO> getProductRating(long customerId) throws CrafartDataException;

}
