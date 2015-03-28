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

import com.crafart.service.ManageCourierService;
import com.crafart.service.businessobjects.CourierBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author karthi
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageCourierServiceTest {

	@Autowired
	private ManageCourierService manageCourierServiceImpl;

	@Test
	@Rollback(true)
	public void testAddCourierDetail() {
		CourierBO courierBO = getCourier();
		try {
			manageCourierServiceImpl.addCourierDetail(courierBO);
		} catch (CrafartServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	@Rollback(true)
	public void getCourierDetail() {
		CourierBO courierBO = getCourier();
		try {
			manageCourierServiceImpl.addCourierDetail(courierBO);
		} catch (CrafartServiceException crafartServiceException) {
			Assert.fail();
			crafartServiceException.printStackTrace();
		}
		try {
			List<CourierBO> courierBOs = manageCourierServiceImpl.getCourierDetail();
			/*
			 * for (CourierBO courierBO2 : courierBOs) {
			 * System.out.print("\n"+courierBO2.getCourierId()); }
			 */
		} catch (CrafartServiceException crafartServiceException) {
			Assert.fail();
			crafartServiceException.printStackTrace();
		}
	}

	private CourierBO getCourier() {
		CourierBO courierBO = new CourierBO();
		courierBO.setImage("from service");
		courierBO.setName("DTTC");
		courierBO.setProductLimit(4);
		courierBO.setSortOrder(9);
		return courierBO;
	}
}
