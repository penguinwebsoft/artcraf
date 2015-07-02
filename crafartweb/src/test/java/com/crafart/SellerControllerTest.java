package com.crafart;

import java.util.ArrayList;
import java.util.List;

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

import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.CommisionBO;
import com.crafart.service.businessobjects.ContactBO;
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

		SellerBO sellerBO = getSellerBO();
		try {
			sellerController.addSeller(sellerBO, null, null, new MockHttpServletRequest(), new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	private AddressBO getAddressBO(SellerBO sellerBO) {
		AddressBO addressBO = new AddressBO();
		addressBO.setCityId(0);
		addressBO.setPinCode("service now");
		addressBO.setStateId(0);
		addressBO.setStreet("testing now");
		addressBO.setSellerBO(sellerBO);
		return addressBO;
	}

	private StoreBO getStoreBO(SellerBO sellerBO) {
		StoreBO storeBO = new StoreBO();
		storeBO.setName("from service add");
		storeBO.setSellerBO(sellerBO);
		storeBO.setStoreDescription(" from service add");
		storeBO.setStoreReturn("serv");
		storeBO.setStoreUrl("www.wwww.com");
		return storeBO;

	}

	private SellerBO getSellerBO() {

		SellerBO sellerBO = new SellerBO();
		sellerBO.setDateOfBirth("00/00/0000");
		sellerBO.setGender(1);
		sellerBO.setDateOfBirth("00/00/0000");
		sellerBO.setApproved(1);
		sellerBO.setCommissionBO(new CommisionBO());
		sellerBO.setCompanyLogo("service");
		sellerBO.setCompanyName("service");
		sellerBO.setCstNo("4444");
		sellerBO.setEpchNo("121212");
		sellerBO.setFirstName("from service");
		sellerBO.setLastName("service");
		sellerBO.setStatus(2);
		sellerBO.setPassword("karthi");
		sellerBO.setTinNo(2);
		sellerBO.setVatNo("asd123");
		sellerBO.setStoreBO(getStoreBO(sellerBO));
		sellerBO.setAddressBO(getAddressBO(sellerBO));
		sellerBO.setContactBOs(getContactBOs(sellerBO));
		return sellerBO;

	}

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
	@Rollback(true)
	public void testFindByEmail() {
		try {
			sellerController.findByEmailId("sam@gmail.com", "null", new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	@Rollback(true)
	public void testCheckShopUrl(){
		try{
		sellerController.checkStoreUrl("sam", new MockHttpSession());
		}catch (Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}

}
