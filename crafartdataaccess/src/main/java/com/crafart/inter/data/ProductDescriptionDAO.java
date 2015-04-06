/**
 * 
 */
package com.crafart.inter.data;

import com.crafart.dataobjects.ProductDescriptionDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Deepam
 *
 */
public interface ProductDescriptionDAO {

	public void addDescription(ProductDescriptionDO productDescriptionDO)throws CrafartDataException;
}
