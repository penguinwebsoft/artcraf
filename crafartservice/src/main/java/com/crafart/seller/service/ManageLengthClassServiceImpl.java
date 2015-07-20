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

import com.crafart.dataobjects.LengthClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.LengthClassDAO;
import com.crafart.inter.service.ManageLengthClassService;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("manageLengthClassImpl")
public class ManageLengthClassServiceImpl implements ManageLengthClassService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private LengthClassDAO lengthClassDAOImpl;

	/**
	 * add length class data to persistence, map business object to data object
	 * with identifier as empty or 0 incase of adding new length class data. <li>
	 * incase of update, check whether {@link Long} lengthClassId is greater
	 * than 0, if so call update method to update length class for that
	 * identifier.
	 * 
	 * @param lengthClassBO
	 * @throws CrafartServiceException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addLengthClass(LengthClassBO lengthClassBO) throws CrafartServiceException {
		if (lengthClassBO.getLengthClassId() > 0) {
			updateLengthClass(lengthClassBO);
		} else {
			LengthClassDO lengthClassDO = beanMapper.mapLengthClassBOToDO(lengthClassBO, new LengthClassDO());
			try {
				lengthClassDAOImpl.addLengthClass(lengthClassDO);
				lengthClassBO.setLengthClassId(lengthClassDO.getLengthClassId());
			} catch (CrafartDataException cDExp) {
				throw new CrafartServiceException("Error while adding lengthclass", cDExp);
			}
		}

	}

	/**
	 * get all length class
	 * 
	 * @return {@link List} of {@link LengthClassDO}
	 */
	@Override
	public Map<Long, LengthClassBO> getLengthClass() throws CrafartServiceException {

		Map<Long, LengthClassBO> lengthClassBOs = new HashMap<>();
		try {
			List<LengthClassDO> lengthClassDOs = lengthClassDAOImpl.getLengthClasses();
			for (LengthClassDO lengthClassDO : lengthClassDOs) {

				LengthClassBO lengthClassBO = beanMapper.mapLengthClassDOToBO(lengthClassDO, new LengthClassBO());
				lengthClassBOs.put(lengthClassBO.getLengthClassId(), lengthClassBO);
			}
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Service Error while retriveing all lengthClass details", cDExp);
		}
		return lengthClassBOs;
	}

	/**
	 * update length class data for identifier {@link Long} lengthClassId
	 * 
	 * @param lengthClassBO
	 * @throws CrafartServiceException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateLengthClass(LengthClassBO lengthClassBO) throws CrafartServiceException {
		LengthClassDO lengthClassDO;
		try {
			lengthClassDO = lengthClassDAOImpl.getLengthClass(lengthClassBO.getLengthClassId());
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Error while getting length class details for id = " + lengthClassBO.getLengthClassId(), cDExp);
		}
		lengthClassDO = beanMapper.mapLengthClassBOToDO(lengthClassBO, lengthClassDO);
		try {
			// updating length class data
			lengthClassDAOImpl.addLengthClass(lengthClassDO);
			lengthClassBO.setLengthClassId(lengthClassDO.getLengthClassId());
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Error while updating lengthclass details for length class id = " + lengthClassBO.getLengthClassId(), cDExp);
		}
	}
}
