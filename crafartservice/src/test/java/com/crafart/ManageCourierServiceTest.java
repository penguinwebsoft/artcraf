/**
 * 
 */
package com.crafart;

import java.util.Map;

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
			manageCourierServiceImpl.addCourier(courierBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testGetCourierDetail() {
		try {
			CourierBO courierBO = getCourier();
			manageCourierServiceImpl.addCourier(courierBO);
			Map<Long, CourierBO> courierBOs = manageCourierServiceImpl.getCouriers();
			int count = 0;
			for (Map.Entry<Long, CourierBO> courierBOEntries : courierBOs.entrySet()) {
				if (courierBO.getCourierId() == courierBOEntries.getValue().getCourierId()) {
					count = count + 1;
				}
			}
			Assert.assertTrue(count == 1);
			Assert.assertNotNull(courierBOs);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	private CourierBO getCourier() {
		CourierBO courierBO = new CourierBO();
		courierBO.setImage("from service");
		courierBO.setCourierName("BlueDart");
		courierBO.setEstimatedDeliveryTime("lfl");
		courierBO.setSortOrder(9);
		return courierBO;
	}
}
