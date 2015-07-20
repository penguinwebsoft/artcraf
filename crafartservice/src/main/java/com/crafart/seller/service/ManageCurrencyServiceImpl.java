/**
 * 
 */
package com.crafart.seller.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/**
	 * add curreny data to persistence, map business object to data object with
	 * identifier as empty or 0 incase of adding new curreny data. <li>
	 * incase of update, check whether {@link Long} currenyId is greater than 0,
	 * if so call update method to update curreny for identifier {@link Long}
	 * currenyId
	 * 
	 * @param currenyBO
	 * @throws CrafartServiceException
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addCurrency(CurrencyBO currencyBO) throws CrafartServiceException {
		if (currencyBO.getCurrencyId() > 0) {
			updateCurrency(currencyBO);
		} else {
			CurrencyDO currencyDO = beanMapper.mapCurrencyBOToDO(currencyBO, new CurrencyDO());
			try {
				currencyDAOImpl.addCurrency(currencyDO);
				currencyBO.setCurrencyId(currencyDO.getCurrencyId());
			} catch (CrafartDataException cDExp) {
				throw new CrafartServiceException("Service Error while adding Currency details", cDExp);
			}
		}

	}

	/**
	 * update curreny data for {@link Long} identifier currenyId
	 * 
	 * @param currenyBO
	 * @throws CrafartServiceException
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateCurrency(CurrencyBO currencyBO) throws CrafartServiceException {
		CurrencyDO currencyDO;
		try {
			currencyDO = currencyDAOImpl.getCurrency(currencyBO.getCurrencyId());
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Service Error while reteiving Currency for currency id = " + currencyBO.getCurrencyId(), cDExp);
		}
		currencyDO = beanMapper.mapCurrencyBOToDO(currencyBO, currencyDO);
		try {
			currencyDAOImpl.addCurrency(currencyDO);
			currencyBO.setCurrencyId(currencyDO.getCurrencyId());
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Service Error while updating Currency details", cDExp);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Map<Long, CurrencyBO> getCurrencys() throws CrafartServiceException {
		Map<Long, CurrencyBO> currencyBOs = new HashMap<>();
		try {
			List<CurrencyDO> currencyDOs = currencyDAOImpl.getCurrencyDetail();
			for (CurrencyDO currencyDO : currencyDOs) {
				CurrencyBO currencyBO = beanMapper.mapCurrencyDOToBO(currencyDO, new CurrencyBO());
				currencyBOs.put(currencyBO.getCurrencyId(), currencyBO);
			}
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Service Error while retriveing all currency details", cDExp);
		}
		return currencyBOs;
	}

}
