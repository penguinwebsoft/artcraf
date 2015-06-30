/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.OrderStatusBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author 
 * 
 */
@Service
public interface ManageOrderStatusService {

	public void addOrderStatusDetail(OrderStatusBO orderStatusBO) throws CrafartServiceException;

	public List<OrderStatusBO> getOrderStatusDetail() throws CrafartServiceException;
}
