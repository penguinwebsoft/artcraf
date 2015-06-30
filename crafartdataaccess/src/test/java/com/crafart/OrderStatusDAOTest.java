package com.crafart;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.OrderStatusDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.OrderStatusDAO;

/**
 * 
 * @author 
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class OrderStatusDAOTest {

	@Autowired
	private OrderStatusDAO orderStatusDAOImpl;

	/*
	 * Test case to add data in orderStatus table
	 */
	@Test
	@Rollback(true)
	public void testAddOrderStatusDetail() {
		OrderStatusDO orderStatusDO = getOrderStatus();
		try {
			orderStatusDAOImpl.addOrderStatusDetail(orderStatusDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private OrderStatusDO getOrderStatus() {
		OrderStatusDO orderStatusDO = new OrderStatusDO();
		orderStatusDO.setOrderStatusTitle("hft");
		orderStatusDO.setOrderStatusSubject("gyhjk");
		orderStatusDO.setDescription("hgdhf");
		orderStatusDO.setSortOrder(1);
		return orderStatusDO;
	}
	/*
	 * Test case is to retrieve details from orderStatus table
	 */
	@Test
	@Rollback(true)
	public void testGetOrderStatusDetail() {
		OrderStatusDO orderStatusDO = getOrderStatus();
		try {
			orderStatusDAOImpl.addOrderStatusDetail(orderStatusDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		try {
			List<OrderStatusDO> orderStatusDOs = orderStatusDAOImpl.getOrderStatusDetail();
			Assert.assertNotNull(orderStatusDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
}
