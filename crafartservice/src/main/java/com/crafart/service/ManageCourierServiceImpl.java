/**
 * 
 */
package com.crafart.service;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addCourierDetail(CourierBO courierBO) throws CrafartServiceException {
		CourierDO courierDO = beanMapper.mapCourierBOToDO(courierBO, new CourierDO());
		try {
			courierDAOImpl.addCourierDetail(courierDO);
		} catch (CrafartDataException crafartDataException) {
			throw new CrafartServiceException("Error while adding courier detail", crafartDataException);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<CourierBO> getCourierDetail() throws CrafartServiceException {
		List<CourierBO> courierBOs = new ArrayList<>();
		try {
			List<CourierDO> courierDOs = courierDAOImpl.getCourierDetail();
			for (CourierDO courierDO : courierDOs) {
				CourierBO courierBO = beanMapper.mapCourierDOToBO(courierDO, new CourierBO());
				courierBOs.add(courierBO);
			}
		} catch (CrafartDataException crafartDataException) {
			throw new CrafartServiceException("Error while reteriving courier details", crafartDataException);
		}
		return courierBOs;
	}

}
