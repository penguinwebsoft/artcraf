/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.CurrencyBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Service
public interface ManageCurrencyService {

	public void addCurrencyDetail(CurrencyBO currencyBO)throws CrafartServiceException;

	public List<CurrencyBO> getCurrencyDetail() throws CrafartServiceException;
}
