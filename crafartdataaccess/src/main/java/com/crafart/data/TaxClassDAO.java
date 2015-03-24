/**
 * 
 */
package com.crafart.data;

import java.util.List;

import com.crafart.dataobjects.TaxClassDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 *
 */
public interface TaxClassDAO {

	public void addTaxClassDetail(TaxClassDO taxClassDO) throws CrafartDataException;
	
	public List<TaxClassDO> getTaxClassDetail()throws CrafartDataException;
}
