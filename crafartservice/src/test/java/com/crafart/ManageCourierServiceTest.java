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

import com.crafart.inter.service.ManageCourierService;
import com.crafart.service.businessobjects.CourierBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author karthi
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml",
		"classpath:crafartservice-context-test.xml" })
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
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testGetCourierDetail() {
		try {
			List<CourierBO> courierBOs = manageCourierServiceImpl
					.getCourierDetail();
			Assert.assertNotNull(courierBOs);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
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
