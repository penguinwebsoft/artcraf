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

import com.crafart.dataobjects.CommisionDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CommissionDAO;
import com.crafart.inter.service.ManageCommisionService;
import com.crafart.service.businessobjects.CommisionBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Deepam
 *
 */
@Service("ManageCommissionServiceImpl")
public class ManageCommisionServiceImpl implements ManageCommisionService {

	@Autowired
	private CommissionDAO commissionDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	/**
	 * add commission data to persistence, map business object to data object
	 * with identifier as empty or 0 incase of adding new commission data. <li>
	 * incase of update, check whether {@link Long} commissionId is greater than
	 * 0, if so call update method to update commission for identifier
	 * {@link Long} commissionId
	 * 
	 * @param commissionBO
	 * @throws CrafartServiceException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCommission(CommisionBO commissionBO) throws CrafartServiceException {
		if (commissionBO.getCommissionId() > 0) {
			updateCommission(commissionBO);
		} else {
			CommisionDO commissionDO = beanMapper.mapCommissionBOToDO(commissionBO, new CommisionDO());
			try {
				commissionDAOImpl.addCommision(commissionDO);
				commissionBO.setCommissionId(commissionDO.getCommissionId());
			} catch (CrafartDataException csExp) {
				throw new CrafartServiceException("Error while adding commission in table", csExp);
			}
		}

	}

	/**
	 * get all commissions from persistence layer
	 * 
	 * @return {@link Map} {@link Long} {@link CommisionBO}
	 * @throws CrafartServiceException
	 */
	@Override
	public Map<Long, CommisionBO> getCommisions() throws CrafartServiceException {
		Map<Long, CommisionBO> CommisionBOs = new HashMap<>();
		try {
			List<CommisionDO> CommisionDOs = commissionDAOImpl.getCommisions();
			for (CommisionDO CommisionDO : CommisionDOs) {
				CommisionBO CommisionBO = beanMapper.mapCommissionDOToBO(CommisionDO, new CommisionBO());
				CommisionBOs.put(CommisionBO.getCommissionId(), CommisionBO);
			}
		} catch (CrafartDataException e) {
			throw new CrafartServiceException("error while getting tax class details", e);
		}
		return CommisionBOs;
	}

	/**
	 * update commission data for {@link Long} identifier commissionId
	 * 
	 * @param commissionBO
	 * @throws CrafartServiceException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateCommission(CommisionBO commissionBO) throws CrafartServiceException {
		CommisionDO commissionDO;
		try {
			commissionDO = commissionDAOImpl.getCommision(commissionBO.getCommissionId());
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Error while getting commision data for commision id = " + commissionBO.getCommissionId(), cDExp);
		}
		commissionDO = beanMapper.mapCommissionBOToDO(commissionBO, commissionDO);
		try {
			commissionDAOImpl.addCommision(commissionDO);
		} catch (CrafartDataException csExp) {
			throw new CrafartServiceException("Error while updating commission for id = " + commissionBO.getCommissionId(), csExp);
		}
	}

}
