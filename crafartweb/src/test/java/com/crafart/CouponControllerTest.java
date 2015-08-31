/**
 * 
 */
package com.crafart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.service.businessobjects.CouponBO;
import com.crafart.service.businessobjects.GeoZoneBO;


/**
 * @author Deepam
 *
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class CouponControllerTest {
	@Autowired
	private CouponController couponController;
	
	@Test
	@Rollback(false)
	public void testAddCoupon() {
		try {
			CouponBO couponBO = getCoupon();
			couponController.addCoupon(couponBO, new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test
	@Rollback(true)
	public void testUpdateCoupon() {
		try {
			CouponBO couponBO = getCoupon();
			couponController.addCoupon(couponBO, new MockHttpSession());
			couponController.updateCoupon(couponBO, new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	private CouponBO getCoupon() {
		CouponBO couponBO = new CouponBO();
		couponBO.setCode(1);
		couponBO.setType(0);
		couponBO.setEndDate("12/01/2010");
		couponBO.setStartDate("13/01/2012");
		couponBO.setStatus(0);
		couponBO.setValue(1);
		couponBO.setUsesPerCoupon(1);
		couponBO.setUsesPerCustomer(2);
		return couponBO;
	}
}
