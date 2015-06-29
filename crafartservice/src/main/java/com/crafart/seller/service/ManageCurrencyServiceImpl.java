/**
 * 
 */
package com.crafart.seller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CurrencyDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CurrencyDAO;
import com.crafart.inter.service.ManageCurrencyService;
import com.crafart.service.businessobjects.CurrencyBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("manageCurrencyServiceImpl")
public class ManageCurrencyServiceImpl implements ManageCurrencyService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private CurrencyDAO currencyDAOImpl;

	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCurrencyDetail(CurrencyBO currencyBO) throws CrafartServiceException {
		CurrencyDO currencyDO = beanMapper.mapCurrencyBOToDO(currencyBO, new CurrencyDO());
		try {
			currencyDAOImpl.addCurrency(currencyDO);
			currencyBO.setCurrencyId(currencyDO.getCurrencyId());
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Service Error while adding Currency details", cDExp);
		}
	}

	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CurrencyBO> getCurrencyDetail() throws CrafartServiceException {
		List<CurrencyBO> currencyBOs = new ArrayList<>();
		try {
			List<CurrencyDO> currencyDOs = currencyDAOImpl.getCurrencyDetail();
			for (CurrencyDO currencyDO : currencyDOs) {
				CurrencyBO currencyBO = beanMapper.mapCurrencyDOToBO(currencyDO, new CurrencyBO());
				currencyBOs.add(currencyBO);
			}
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Service Error while retriveing all currency details", cDExp);
		}
		return currencyBOs;
	}

}
