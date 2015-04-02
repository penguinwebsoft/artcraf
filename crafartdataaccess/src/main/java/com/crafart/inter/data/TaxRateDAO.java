/**
 * 
 */
package com.crafart.inter.data;

import com.crafart.dataobjects.TaxRateDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface TaxRateDAO {

	public void addTaxRate(TaxRateDO taxRateDO) throws CrafartDataException;
}
