package com.crafart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.service.businessobjects.SellerBO;

/**
 * Unit test for simple App.
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class SellerControllerTest {

	@Autowired
	private SellerController sellerController;

	@Test
	@Rollback(true)
	public void testAddSeller() {

		SellerBO sellerBO = new SellerBO();
		sellerBO.setApproved(1);
		sellerBO.setGender(1);
		sellerBO.setDateOfBirth("11/02/0000");
		sellerBO.setCommission("www");
		sellerBO.setCompanyLogo("qqq");
		sellerBO.setCompanyName("penguin");
		sellerBO.setCstNo("4444");
		sellerBO.setEpchNo("121212");
		sellerBO.setFirstName("lll");
		sellerBO.setLastName("mmm");
		sellerBO.setStatus(2);
		sellerBO.setTinNo(2);
		sellerBO.setVatNo("asd123");

		try {
			sellerController.addSeller(sellerBO, new MockHttpServletRequest());
		} catch (Exception exp) {
			exp.printStackTrace();
			Assert.fail();
		}

	}
}
