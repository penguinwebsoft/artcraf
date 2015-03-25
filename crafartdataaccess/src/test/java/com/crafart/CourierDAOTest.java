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

import com.crafart.data.CourierDAO;
import com.crafart.dataobjects.CourierDO;
import com.crafart.exception.CrafartDataException;

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
	
	@Test
	@Rollback(true)
	public void testAddCourierDetail(){
		CourierDO courierDO = getCourier();
		try {
			courierDAOImpl.addCourierDetail(courierDO);
		} catch (CrafartDataException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	private CourierDO getCourier() {
		CourierDO courierDO = new CourierDO();
		courierDO.setImage("asdfgh");
		courierDO.setName("BlueDart");
		courierDO.setProductLimit(1);
		courierDO.setSortOrder(1);
		return courierDO;
	}
	
	@Test 
	@Rollback(true)
	public void testGetCourierDetail(){
		CourierDO courierDO = getCourier();
		try {
			courierDAOImpl.addCourierDetail(courierDO);
		} catch (CrafartDataException e) {
			Assert.fail();
			e.printStackTrace();
		}
		try {
		List<CourierDO> courierDOs = courierDAOImpl.getCourierDetail();
		/**
		 * it will print the courierId to system console
		 */
		/*for(CourierDO courierDO2 : courierDOs){
			System.out.print("\n"+courierDO2.getCourierId());
		}*/
		} catch (CrafartDataException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
}
