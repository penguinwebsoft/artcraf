/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.CurrencyDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 *
 */
public interface CurrencyDAO {

	public void addCurrency(CurrencyDO currencyDO) throws CrafartDataException;
	
	public List<CurrencyDO> getCurrencyDetail() throws CrafartDataException;
}
