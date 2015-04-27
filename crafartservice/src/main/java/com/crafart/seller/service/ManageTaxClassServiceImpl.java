/**
 * 
 */
package com.crafart.seller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public List<TaxClassBO> getTaxClassDetail() throws CrafartServiceException {
		List<TaxClassBO> taxClassBOs = new ArrayList<>();
		try {
			List<TaxClassDO> taxClassDOs = taxClassDAOImpl.getTaxClassDetail();
			for (TaxClassDO taxClassDO : taxClassDOs) {
				TaxClassBO taxClassBO = beanMapper.mapTaxClassDOToBO(taxClassDO, new TaxClassBO());
				taxClassBOs.add(taxClassBO);
			}
		} catch (CrafartDataException e) {
			throw new CrafartServiceException("error while getting tax class details", e);
		}
		return taxClassBOs;
	}

}
