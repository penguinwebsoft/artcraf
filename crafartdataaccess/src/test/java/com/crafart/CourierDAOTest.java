/**
 * 
 */
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

import com.crafart.dataobjects.CourierDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CourierDAO;

/**
 * @author Karthi
 * 
 */

@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CourierDAOTest {

	@Autowired
	private CourierDAO courierDAOImpl;

	/*
	 * Test case to add data in courier table
	 */
	@Test
	@Rollback(true)
	public void testAddCourierDetail() {
		CourierDO courierDO = getCourierDetail();
		try {
			courierDAOImpl.addCourier(courierDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testUpdateCourierDetail() {
		CourierDO courierDO = getCourierDetail();
		try {
			courierDAOImpl.addCourier(courierDO);
			courierDO.setCourierName("ekart");
			courierDAOImpl.addCourier(courierDO);
			Assert.assertEquals("ekart", courierDO.getCourierName());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
	
	private CourierDO getCourierDetail() {
		CourierDO courierDO = new CourierDO();
		courierDO.setImage("asdfgh");
		courierDO.setCourierName("lkkkk");
		courierDO.setEstimatedDeliveryTime("jj");
		courierDO.setSortOrder(1);
		return courierDO;
	}

	/**
	 * Test case is to retrieve details from courier table
	 */
	@Test
	@Rollback(true)
	public void testGetCourierDetail() {
		CourierDO courierDO = getCourierDetail();
		try {
			courierDAOImpl.addCourier(courierDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		try {
			List<CourierDO> courierDOs = courierDAOImpl.getCouriers();
			Assert.assertNotNull(courierDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

}
