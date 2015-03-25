package com.crafart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.businessobjects.StoreBO;

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
		sellerBO.setFirstName("controller");
		sellerBO.setLastName("from");
		sellerBO.setStatus(2);
		sellerBO.setTinNo(2);
		sellerBO.setVatNo("asd123");
		sellerBO.setStoreBO(getStoreBO(sellerBO));

		try {
			sellerController.addSeller(sellerBO, null, null, new MockHttpServletRequest(), new MockHttpSession());
		} catch (Exception exp) {
			exp.printStackTrace();
			Assert.fail();
		}

	}
	
	private StoreBO getStoreBO(SellerBO sellerBO){
		StoreBO storeBO = new StoreBO();
		storeBO.setName("from controller");
		storeBO.setSellerBO(sellerBO);
		storeBO.setStoreDescription(" from controller");
		storeBO.setStoreReturn("cont");
		storeBO.setStoreUrl("www.wwww.com");
		return storeBO;
		
	}
}
