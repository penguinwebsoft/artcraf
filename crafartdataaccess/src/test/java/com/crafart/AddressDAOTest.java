/**
 * 
 */
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
import com.crafart.dataobjects.SellerDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AddressDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class AddressDAOTest {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(AddressDAOTest.class);

	@Autowired
	private AddressDAO addressDAOImpl;
	
	/*
	 * Test CAse to add address in Address table
	 */
	@Test
	@Rollback(true)
	public void testAddAddress() {
		AddressDO addressDO = addAddress();
		List<SellerDO> sellerDOs = new ArrayList<SellerDO>();
		sellerDOs.add(getSellerDO());
		addressDO.setSellerDOs(sellerDOs);
		try {
			addressDAOImpl.addAddress(addressDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private AddressDO addAddress() {
		AddressDO addressDO = new AddressDO();
		addressDO.setCityId(12);
		addressDO.setPinCode("000000");
		addressDO.setStateId(123123);
		addressDO.setStreet("aaaa cccc");
		return addressDO;
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
		//sellerDO.setCommissionDO(getCommission());
		sellerDO.setPassword("jbskla");
		sellerDO.setStatus(1);
		sellerDO.setApproved(1);
		//sellerDO.setStoreDO(getStoreDOs(sellerDO));
		List<SellerDO> sellerDOs = new ArrayList<>();
		sellerDOs.add(sellerDO);
		//sellerDO.setAddressDOs(getAddressDOs(sellerDOs));
		//sellerDO.setContactDOs(getContactDOs(sellerDOs));
		return sellerDO;
	}
}
