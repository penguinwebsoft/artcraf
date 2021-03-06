/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.ProductDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
@Repository("productDAO")
public interface ProductDAO {

	public void addProduct(ProductDO productDO) throws CrafartDataException;

	public ProductDO getProductDetail(long productId) throws CrafartDataException;

	public List<ProductDO> getAllProduct() throws CrafartDataException;
}
