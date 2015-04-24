/**
 * 
 */
package com.crafart;

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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.inter.service.ManageSellerService;
import com.crafart.inter.service.ManageStoreService;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.businessobjects.StoreBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageStoreServiceTest {

	@Autowired
	private ManageStoreService manageStoreServiceImpl;

	@Autowired
	private ManageSellerService manageSellerServiceImpl;

	@Test
	@Ignore
	@Rollback(true)
	public void testAddStoreDetail() {

		StoreBO storeBO = getStoreBO();
		try {
			manageStoreServiceImpl.addStoreDetail(storeBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private StoreBO getStoreBO() {
		StoreBO storeBO = new StoreBO();
		storeBO.setName("zzz");
		storeBO.setStoreDescription("aaaa mmmmm nnnn jjjj lll");
		storeBO.setStoreReturn("llll kkkkk jjjj iii oo hhhhh yyyy");
		storeBO.setStoreUrl("www.oooo.ooo");
		storeBO.setSellerBO(getSellerBO(storeBO));
		return storeBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private SellerBO getSellerBO(StoreBO storeBO) {
		SellerBO sellerBO = new SellerBO();
		sellerBO.setStoreBO(storeBO);
		sellerBO.setFirstName("xxxx");
		sellerBO.setLastName("yyyy");
		sellerBO.setGender(1);
		sellerBO.setDateOfBirth("00/00/0000");
		sellerBO.setTinNo(1);
		sellerBO.setCompanyName("penguin");
		sellerBO.setCompanyLogo("pen");
		sellerBO.setEpchNo("123");
		sellerBO.setVatNo("123456a");
		sellerBO.setCstNo("000");
		sellerBO.setCommission("aaaa");
		sellerBO.setStatus(1);
		sellerBO.setApproved(1);
		return sellerBO;

	}

	@Test
	@Rollback(true)
	public void testCheckStoreUrl() {
		try {
			StoreBO storeBO = manageStoreServiceImpl.checkStoreUrl("sam");
			System.out.print(storeBO.getSellerBO().getSellerId());
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

}
