package com.crafart;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;





import com.crafart.dataobjects.CouponDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CouponDAO;


/**
 * 
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CouponDAOTest {

	@Autowired
	private CouponDAO couponDAOImpl;

	/*
	 * Test case to add data in discount table
	 */
	@Ignore
	@Rollback(false)
	public void testAddCoupon() {
		CouponDO couponDO = getCoupon();
		try {
			couponDAOImpl.addCoupon(couponDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(false)
	public void testUpdateCoupon() {
		CouponDO couponDO = getCoupon();
		try {
			couponDAOImpl.addCoupon(couponDO);
			couponDO.setType(0);
			couponDAOImpl.addCoupon(couponDO);
			couponDAOImpl.getCoupon(couponDO.getDiscountId());
			Assert.assertEquals("Coupon updated", couponDO.getType());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	/*
	 * Test case is to retrieve details from discount table
	 */
	@Ignore
	@Rollback(true)
	public void testgetCouponDetail() {
		CouponDO couponDO = getCoupon();
		try {
			couponDAOImpl.addCoupon(couponDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		try {
			List<CouponDO> couponDOs = couponDAOImpl.getCouponDetail();
			Assert.assertNotNull(couponDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private CouponDO getCoupon() {
		CouponDO couponDO = new CouponDO();
		couponDO.setCode(10);
		couponDO.setValue(10);
		couponDO.setUsesPerCoupon(1);
		couponDO.setType(1);
		couponDO.setUsesPerCustomer(1);
		couponDO.setStartDate("2001/03/12");
		couponDO.setEndDate("2015/03/12");
		couponDO.setStatus(0);
		return couponDO;
	}
}
