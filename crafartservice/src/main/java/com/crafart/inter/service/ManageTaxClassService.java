/**
 * 
 */
package com.crafart.inter.service;

import java.util.Map;

import com.crafart.service.businessobjects.TaxClassBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
public interface ManageTaxClassService {

	public Map<Long, TaxClassBO> getTaxClasses() throws CrafartServiceException;
	
	public void addTaxClass(TaxClassBO taxClassBO) throws CrafartServiceException;
	
	public void updateTaxClass(TaxClassBO taxClassBO) throws CrafartServiceException;

}
