/**
 * 
 */
package com.crafart;

import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.inter.service.ManageCouponService;
import com.crafart.service.businessobjects.CouponBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Deepam
 *
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageCouponServiceTest {
	@Autowired
	public ManageCouponService manageCouponServiceImpl;

	@Test
	@Rollback(false)
	public void testAddCoupon() {
		CouponBO couponBO = getCoupon();
		try {
			manageCouponServiceImpl.addCoupon(couponBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Ignore
	@Rollback(true)
	public void testUpdateCoupon() {
		CouponBO couponBO = getCoupon();
		try {
			manageCouponServiceImpl.addCoupon(couponBO);
			couponBO.setType(2);
			manageCouponServiceImpl.updateCoupon(couponBO);
			Assert.assertEquals(2, couponBO.getType());
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}




private CouponBO getCoupon() {
	CouponBO couponBO = new CouponBO();
  
	couponBO.setCode(12);
	couponBO.setType(0);
	couponBO.setUsesPerCoupon(1);
	couponBO.setUsesPerCustomer(2);
	couponBO.setStartDate("11/11/2012");
	couponBO.setEndDate("11/11/2014");
	couponBO.setStatus(0);
	return couponBO;
}


@Ignore
@Rollback(true)
public void testGetCouponDetail() {
	CouponBO couponBO = getCoupon();
	try {
		manageCouponServiceImpl.addCoupon(couponBO);
	} catch (CrafartServiceException csExp) {
		csExp.printStackTrace();
		Assert.fail();
	}
	try {
		Map<Long, CouponBO> couponBOs = manageCouponServiceImpl.getCoupons();
		int count = 0;
		for (Map.Entry<Long,CouponBO> couponBOEntries : couponBOs.entrySet()) {
			if (couponBO.getDiscountId() == couponBOEntries.getValue().getDiscountId()) {
				count = count + 1;
			}
		}
		Assert.assertTrue(count == 1);
	} catch (CrafartServiceException csExp) {
		csExp.printStackTrace();
		Assert.fail();
	}
}
}