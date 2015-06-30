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

import com.crafart.dataobjects.OrderStatusDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.OrderStatusDAO;
import com.crafart.inter.service.ManageOrderStatusService;
import com.crafart.service.businessobjects.OrderStatusBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author 
 * 
 */
@Service("manageOrderStatusServiceImpl")
public class ManageOrderStatusServiceImpl implements ManageOrderStatusService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private OrderStatusDAO orderStatusDAOImpl;

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addOrderStatusDetail(OrderStatusBO orderStatusBO) throws CrafartServiceException {
		OrderStatusDO orderStatusDO = beanMapper.mapOrderStatusBOToDO(orderStatusBO, new OrderStatusDO());
		try {
			orderStatusDAOImpl.addOrderStatusDetail(orderStatusDO);
			orderStatusBO.setOrderStatusId(orderStatusDO.getOrderStatusId());
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while adding orderStatus", cdExp);
		}
	}

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<OrderStatusBO> getOrderStatusDetail() throws CrafartServiceException {
		List<OrderStatusBO> orderStatusBOs = new ArrayList<>();
		try {
			List<OrderStatusDO> orderStatusDOs = orderStatusDAOImpl.getOrderStatusDetail();
			for (OrderStatusDO orderStatusDO : orderStatusDOs) {
				OrderStatusBO orderStatusBO = beanMapper.mapOrderStatusDOToBO(orderStatusDO, new OrderStatusBO());
				orderStatusBOs.add(orderStatusBO);
			}
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while retriveing from DB", cdExp);
		}
		return orderStatusBOs;
	}

}
