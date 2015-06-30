/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import com.crafart.service.businessobjects.TaxClassBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
public interface ManageTaxClassService {

	public List<TaxClassBO> getTaxClassDetail() throws CrafartServiceException;
	
	public void addTaxClassDetail(TaxClassBO taxClassBO) throws CrafartServiceException;
	

}
