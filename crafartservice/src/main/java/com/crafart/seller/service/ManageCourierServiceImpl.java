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

import com.crafart.dataobjects.CourierDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CourierDAO;
import com.crafart.inter.service.ManageCourierService;
import com.crafart.service.businessobjects.CourierBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("manageCourierServiceImpl")
public class ManageCourierServiceImpl implements ManageCourierService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private CourierDAO courierDAOImpl;

	/**
	 * add courier data to persistence, map business object to data object with
	 * identifier as empty or 0 incase of adding new courier data. <li>
	 * incase of update, check whether {@link Long} courierId is greater than 0,
	 * if so call update method to update courier for identifier {@link Long}
	 * courierId
	 * 
	 * @param courierBO
	 * @throws CrafartServiceException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCourier(CourierBO courierBO) throws CrafartServiceException {
		if (courierBO.getCourierId() > 0) {
			updateCourier(courierBO);
		} else {
			CourierDO courierDO = beanMapper.mapCourierBOToDO(courierBO, new CourierDO());
			try {
				courierDAOImpl.addCourier(courierDO);
				courierBO.setCourierId(courierDO.getCourierId());
			} catch (CrafartDataException crafartDataException) {
				throw new CrafartServiceException("Error while adding courier detail", crafartDataException);
			}
		}

	}

	/**
	 * update courier data for {@link Long} identifier courierId
	 * 
	 * @param courierBO
	 * @throws CrafartServiceException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateCourier(CourierBO courierBO) throws CrafartServiceException {
		CourierDO courierDO;
		try {
			courierDO = courierDAOImpl.getCourier(courierBO.getCourierId());
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Error while getting courier data for id = " + courierBO.getCourierId(), cDExp);
		}
		courierDO = beanMapper.mapCourierBOToDO(courierBO, courierDO);
		try {
			courierDAOImpl.addCourier(courierDO);
			courierBO.setCourierId(courierDO.getCourierId());
		} catch (CrafartDataException crafartDataException) {
			throw new CrafartServiceException("Error while adding courier detail", crafartDataException);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<Long, CourierBO> getCouriers() throws CrafartServiceException {
		Map<Long, CourierBO> courierBOs = new HashMap<>();
		try {
			List<CourierDO> courierDOs = courierDAOImpl.getCouriers();
			for (CourierDO courierDO : courierDOs) {
				CourierBO courierBO = beanMapper.mapCourierDOToBO(courierDO, new CourierBO());
				courierBOs.put(courierBO.getCourierId(), courierBO);
			}
		} catch (CrafartDataException crafartDataException) {
			throw new CrafartServiceException("Error while reteriving courier details", crafartDataException);
		}
		return courierBOs;
	}

}
