package com.crafart;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.AddressDO;
import com.crafart.dataobjects.ContactDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.StoreDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.SellerDAO;

/**
 * Unit test for simple App.
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SellerDAOTest {

	private static final Logger log = Logger.getLogger(SellerDAOTest.class);

	@Autowired
	private SellerDAO sellerDAOImpl;

	/**
	 * test case for addSeller method
	 */
	@Test
	@Rollback(true)
	public void testAddSeller() {
		try {
			SellerDO sellerDO = getSellerDO();
			sellerDAOImpl.addSeller(sellerDO);
			log.info("Seller id is" + sellerDO.getSellerId());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}

	}

	@Test
	@Rollback(true)
	public void testUpdateSeller() {
		try {
			SellerDO sellerDO = getSellerDO();
			sellerDAOImpl.addSeller(sellerDO);
			sellerDO.getStoreDO().setName("update from dao");
			sellerDO.getStoreDO().setStoreReturn("update from dao");
			sellerDO.setVat_no("12");
			sellerDO.setCst_no("13");
			sellerDAOImpl.updateSeller(sellerDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private SellerDO getSellerDO() {
		SellerDO sellerDO = new SellerDO();
		sellerDO.setFirstName("craf");
		sellerDO.setLastName("art");
		sellerDO.setTin_no(1);
		sellerDO.setGender(1);
		sellerDO.setDateOfBirth("00/00/0000");
		sellerDO.setCompanyName("penguin");
		sellerDO.setCompanyLogo("pen");
		sellerDO.setEpch_no("123");
		sellerDO.setVat_no("123456a");
		sellerDO.setCst_no("000");
		sellerDO.setCommission("aaaa");
		sellerDO.setPassword("jbskla");
		sellerDO.setStatus(1);
		sellerDO.setApproved(1);
		sellerDO.setStoreDO(getStoreDOs(sellerDO));
		List<SellerDO> sellerDOs = new ArrayList<>();
		sellerDOs.add(sellerDO);
		sellerDO.setAddressDOs(getAddressDOs(sellerDOs));
		sellerDO.setContactDOs(getContactDOs(sellerDOs));
		return sellerDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<ContactDO> getContactDOs(List<SellerDO> sellerDOs) {
		List<ContactDO> contactDOs = new ArrayList<>();
		ContactDO contactDO = new ContactDO();
		contactDO.setContactTypeId(1);
		contactDO.setContactValue("9999900000");
		contactDO.setSellerDOs(sellerDOs);
		ContactDO contactDO2 = new ContactDO();
		contactDO2.setContactTypeId(2);
		contactDO2.setContactValue("044-505000");
		contactDO2.setSellerDOs(sellerDOs);
		ContactDO contactDO3 = new ContactDO();
		contactDO3.setContactTypeId(3);
		contactDO3.setContactValue("seller@iii.com");
		contactDO3.setSellerDOs(sellerDOs);
		ContactDO contactDO4 = new ContactDO();
		contactDO4.setContactTypeId(4);
		contactDO4.setContactValue("seller@iii.com");
		contactDO4.setSellerDOs(sellerDOs);
		contactDOs.add(contactDO);
		contactDOs.add(contactDO2);
		contactDOs.add(contactDO3);
		contactDOs.add(contactDO4);
		return contactDOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<AddressDO> getAddressDOs(List<SellerDO> sellerDOs) {
		AddressDO addressDO = new AddressDO();
		addressDO.setCityId(1);
		addressDO.setPinCode("001100");
		addressDO.setSellerDOs(sellerDOs);
		addressDO.setStateId(2);
		addressDO.setStreet("qwertyuiop");
		List<AddressDO> addressDOs = new ArrayList<>();
		addressDOs.add(addressDO);
		return addressDOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private StoreDO getStoreDOs(SellerDO sellerDO) {
		StoreDO storeDO = new StoreDO();
		storeDO.setName("store craf");
		storeDO.setStoreDescription("penguin store");
		storeDO.setStoreReturn("test desc");
		storeDO.setStoreUrl("acx");
		storeDO.setSellerDO(sellerDO);
		/*
		 * List<StoreDO> storeDOs = new ArrayList<>(); storeDOs.add(storeDO);
		 */
		return storeDO;
	}

	@Test
	@Rollback(true)
	public void testGetSellerDetail() {
		try {
			SellerDO sellerDO = sellerDAOImpl.getSellerContacts(41681);
			List<AddressDO> addressDOs = sellerDO.getAddressDOs();
			for (AddressDO addressDO : addressDOs) {
				System.out.print("\n" + addressDO.getAddressId());
			}
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

}
