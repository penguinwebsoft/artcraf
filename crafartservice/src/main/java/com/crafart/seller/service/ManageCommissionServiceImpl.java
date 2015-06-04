/**
 * 
 */
package com.crafart.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CommissionDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CommissionDAO;
import com.crafart.inter.service.ManageCommissionService;
import com.crafart.service.businessobjects.CommissionBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Deepam
 *
 */
@Service("ManageCommissionServiceImpl")
public class ManageCommissionServiceImpl implements ManageCommissionService {

	@Autowired
	private CommissionDAO commissionDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addCommission(CommissionBO commissionBO) throws CrafartServiceException {
		CommissionDO commissionDO = beanMapper.mapCommissionBOToDO(commissionBO, new CommissionDO());
		try {
			commissionDAOImpl.addCommission(commissionDO);
		} catch (CrafartDataException csExp) {
			throw new CrafartServiceException("Error while adding commission in table", csExp);
		}
	}

}
