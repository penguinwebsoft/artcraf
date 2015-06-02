/**
 * 
 */
package com.crafart;

import java.util.ArrayList;
import java.util.List;

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
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.ContactBO;
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
	@Rollback(true)
	public void testAddStoreDetail() {

		StoreBO storeBO = getStoreBO();
		/*
		 * try { manageStoreServiceImpl.addStoreDetail(storeBO); } catch
		 * (CrafartServiceException csExp) { csExp.printStackTrace();
		 * Assert.fail(); }
		 */
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
		sellerBO.setDateOfBirth("00/00/0000");
		sellerBO.setGender(1);
		sellerBO.setDateOfBirth("00/00/0000");
		sellerBO.setApproved(1);
		sellerBO.setCompanyLogo("service");
		sellerBO.setCompanyName("service");
		sellerBO.setCstNo("4444");
		sellerBO.setEpchNo("121212");
		sellerBO.setFirstName("from service");
		sellerBO.setLastName("service");
		sellerBO.setStatus(2);
		sellerBO.setTinNo(2);
		sellerBO.setVatNo("asd123");
		sellerBO.setPassword("akajsdgh");
		sellerBO.setStoreBO(storeBO);
		sellerBO.setAddressBO(getAddressBO(sellerBO));
		sellerBO.setContactBOs(getContactBOs(sellerBO));
		try {
			manageSellerServiceImpl.addSeller(sellerBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		return sellerBO;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	private AddressBO getAddressBO(SellerBO sellerBO) {
		AddressBO addressBO = new AddressBO();
		addressBO.setCityId(0);
		addressBO.setPinCode("service now");
		addressBO.setStateId(0);
		addressBO.setStreet("testing now");
		addressBO.setSellerBO(sellerBO);
		return addressBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<ContactBO> getContactBOs(SellerBO sellerBO) {
		List<ContactBO> contactBOs = new ArrayList<>();
		ContactBO contactBO = new ContactBO();
		contactBO.setContactTypeId(1);
		contactBO.setContactValue("0000000");
		contactBO.setSellerBO(sellerBO);
		ContactBO contactBO2 = new ContactBO();
		contactBO2.setContactTypeId(2);
		contactBO2.setContactValue("044-202020");
		contactBO.setSellerBO(sellerBO);
		ContactBO contactBO3 = new ContactBO();
		contactBO3.setContactTypeId(3);
		contactBO3.setContactValue("sellerservice@iii.com");
		contactBO.setSellerBO(sellerBO);
		contactBOs.add(contactBO);
		contactBOs.add(contactBO2);
		contactBOs.add(contactBO3);
		return contactBOs;
	}

	@Test
	@Ignore
	@Rollback(true)
	public void testCheckStoreUrl() {
		StoreBO storeBO = getStoreBO();
		try {
			manageStoreServiceImpl.addStoreDetail(storeBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			manageStoreServiceImpl.checkStoreUrl(storeBO.getStoreUrl());
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

}
