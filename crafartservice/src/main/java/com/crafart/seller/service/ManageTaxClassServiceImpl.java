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

import com.crafart.dataobjects.TaxClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.TaxClassDAO;
import com.crafart.inter.service.ManageTaxClassService;
import com.crafart.service.businessobjects.TaxClassBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("manageTaxClassServiceImpl")
public class ManageTaxClassServiceImpl implements ManageTaxClassService {

	@Autowired
	private TaxClassDAO taxClassDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	/**
	 * get all taxclasses from persistence layer
	 * 
	 * @return {@link Map}
	 * @throws CrafartServiceException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<Long, TaxClassBO> getTaxClasses() throws CrafartServiceException {
		Map<Long, TaxClassBO> taxClassBOs = new HashMap<>();
		try {
			List<TaxClassDO> taxClassDOs = taxClassDAOImpl.getTaxClassDetail();
			for (TaxClassDO taxClassDO : taxClassDOs) {
				TaxClassBO taxClassBO = beanMapper.mapTaxClassDOToBO(taxClassDO, new TaxClassBO());
				taxClassBOs.put(taxClassBO.getTaxClassId(), taxClassBO);
			}
		} catch (CrafartDataException e) {
			throw new CrafartServiceException("error while getting tax class details", e);
		}
		return taxClassBOs;
	}

	/**
	 * add taxClass data to persistence, map business object to data object with
	 * identifier as empty or 0 incase of adding new taxClass data. <li>
	 * incase of update, check whether {@link Long} taxClassId is greater than
	 * 0, if so call update method to update taxClass for identifier
	 * {@link Long} taxClassId
	 * 
	 * @param taxClassBO
	 * @throws CrafartServiceException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addTaxClass(TaxClassBO taxClassBO) throws CrafartServiceException {
		// if taxclass id greater than 0, then update since it has got valid
		// identifier
		if (taxClassBO.getTaxClassId() > 0) {
			updateTaxClass(taxClassBO);
		} else {
			TaxClassDO taxClassDO = beanMapper.mapTaxClassBOToDO(taxClassBO, new TaxClassDO());
			try {
				taxClassDAOImpl.addTaxClassDetail(taxClassDO);
				taxClassBO.setTaxClassId(taxClassDO.getTaxClassId());
			} catch (CrafartDataException crafartDataException) {
				throw new CrafartServiceException("Error while adding taxclass detail", crafartDataException);
			}
		}

	}

	/**
	 * update taxClass data for {@link Long} identifier taxClassId
	 * 
	 * @param taxClassBO
	 * @throws CrafartServiceException
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateTaxClass(TaxClassBO taxClassBO) throws CrafartServiceException {
		TaxClassDO taxClassDO;
		try {
			taxClassDO = taxClassDAOImpl.getTaxClass(taxClassBO.getTaxClassId());
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Error while getting taxclass data for id = " + taxClassBO.getTaxClassId(), cDExp);
		}
		try {
			taxClassDO = beanMapper.mapTaxClassBOToDO(taxClassBO, taxClassDO);
			taxClassDAOImpl.addTaxClassDetail(taxClassDO);
		} catch (CrafartDataException crafartDataException) {
			throw new CrafartServiceException("Error while updating taxclass detail for id = " + taxClassBO.getTaxClassId(), crafartDataException);
		}
	}

}