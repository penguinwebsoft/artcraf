/**
 * 
 */
package com.crafart;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.inter.service.ManageOrderStatusService;
import com.crafart.service.businessobjects.OrderStatusBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author 
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageOrderStatusServiceTest {

	@Autowired
	public ManageOrderStatusService manageOrderStatusServiceImpl;

	@Test
	@Rollback(true)
	public void testAddOrderStatusDetail() {
		OrderStatusBO orderStatusBO = getOrderStatus();
		try {
			manageOrderStatusServiceImpl.addOrderStatusDetail(orderStatusBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	private OrderStatusBO getOrderStatus() {
		OrderStatusBO orderStatusBO = new OrderStatusBO();
		orderStatusBO.setOrderStatusSubject("dhsc");
		orderStatusBO.setOrderStatusTitle("cjdshn");
		orderStatusBO.setDescription("dhfd");
		orderStatusBO.setSortOrder(990);
		return orderStatusBO;
	}

	@Test
	@Rollback(true)
	public void testGetOrderStatusDetail() {
		OrderStatusBO orderStatusBO = getOrderStatus();
		try {
			manageOrderStatusServiceImpl.addOrderStatusDetail(orderStatusBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			@SuppressWarnings("unused")
			List<OrderStatusBO> orderStatusBOs = manageOrderStatusServiceImpl.getOrderStatusDetail();
			
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}
}
