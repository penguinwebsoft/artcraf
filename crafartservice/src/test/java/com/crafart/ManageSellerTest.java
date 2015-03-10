package com.crafart;

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

import com.crafart.service.ManageSellerService;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.exception.CrafartServiceException;

@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageSellerTest {

	@Autowired
	private ManageSellerService manageSellerServiceImpl;

	@Test
	@Rollback(true)
	public void testAddSeller() {

		SellerBO sellerBO = new SellerBO();
		sellerBO.setDateOfBirth("00/00/0000");
		sellerBO.setGender(1);
		sellerBO.setDateOfBirth("00/00/0000");
		sellerBO.setApproved(1);
		sellerBO.setCommission("www");
		sellerBO.setCompanyLogo("qqq");
		sellerBO.setCompanyName("penguin");
		sellerBO.setCstNo("4444");
		sellerBO.setEpchNo("121212");
		sellerBO.setFirstName("zzz");
		sellerBO.setLastName("rrr");
		sellerBO.setStatus(2);
		sellerBO.setTinNo(2);
		sellerBO.setVatNo("asd123");

		try {
			manageSellerServiceImpl.addSeller(sellerBO);
		} catch (CrafartServiceException uExp) {
			uExp.printStackTrace();
			Assert.fail();
		}

	}

}
