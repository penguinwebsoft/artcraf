/**
 * 
 */
package com.crafart.inter.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.CurrencyBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Service
public interface ManageCurrencyService {

	public void addCurrency(CurrencyBO currencyBO)throws CrafartServiceException;

	public void updateCurrency(CurrencyBO currencyBO)throws CrafartServiceException;

	public Map<Long, CurrencyBO> getCurrencys() throws CrafartServiceException;
}
