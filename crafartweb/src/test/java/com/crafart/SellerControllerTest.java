package com.crafart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
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
@ContextConfiguration({ "classpath:crafart-context-test.xml",
		"classpath:crafart-datasource-config.xml" })
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
		sellerBO.setCommission("www");
		sellerBO.setCompanyLogo("qqq");
		sellerBO.setCompanyName("penguin");
		sellerBO.setCst_no("4444");
		sellerBO.setEpch_no("121212");
		sellerBO.setFirstName("zzz");
		sellerBO.setLastName("rrr");
		sellerBO.setStatus(2);
		sellerBO.setTin_no(2);
		sellerBO.setVat_no("asd123");

		try {
			sellerController.addSeller(sellerBO, new MockHttpServletRequest(), new MockHttpServletResponse());
		} catch (Exception exp) {
			exp.printStackTrace();
			Assert.fail();
		}

	}
	}


