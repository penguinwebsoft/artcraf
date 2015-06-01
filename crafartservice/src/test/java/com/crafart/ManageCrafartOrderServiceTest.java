/**
 * 
 */
package com.crafart;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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

import com.crafart.inter.service.ManageCrafartOrderService;
import com.crafart.inter.service.ManageCustomerService;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.ContactBO;
import com.crafart.service.businessobjects.CustomerBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml",
		"classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageCrafartOrderServiceTest {

	@Autowired
	private ManageCrafartOrderService manageCrafartOrderServiceImpl;

	@Autowired
	private ManageCustomerService manageCustomerServiceImpl;

	@Test
	@Rollback(true)
	public void testGetCrafartOrder() {
		SellerBO sellerBO = new SellerBO();
		try {
			manageCrafartOrderServiceImpl.getCrafartOrder(sellerBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testGetCustomerOrder() {
		CustomerBO customerBO = getCustomer();
		try {
			manageCrafartOrderServiceImpl.getCustomerOrder(customerBO
					.getCustomerId());
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private CustomerBO getCustomer() {
		CustomerBO customerBO = new CustomerBO();
		AddressBO addressBO = getAddress();
		customerBO.setDateOfBirth("00-00-1000");
		customerBO.setFirstName("satur");
		customerBO.setGender(0);
		customerBO.setLastName("monday");
		customerBO.setIp("120000001200");
		customerBO.setPassword("klklkl");
		customerBO.setStatus(1);
		customerBO.setAddressBO(addressBO);
		List<ContactBO> contactBOs = getContactBOs(customerBO);
		customerBO.setContactBOs(contactBOs);
		try {
			manageCustomerServiceImpl.addCustomerDetail(customerBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		return customerBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private AddressBO getAddress() {
		AddressBO addressBO = new AddressBO();
		addressBO.setCityId(047);
		addressBO.setPinCode("639117");
		addressBO.setStateId(047);
		addressBO.setStreet("2a nagar");
		return addressBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<ContactBO> getContactBOs(CustomerBO customerBO) {
		List<ContactBO> contactBOs = new ArrayList<>();
		ContactBO contactBO = new ContactBO();
		contactBO.setContactTypeId(1);
		contactBO.setContactValue("0000000");
		contactBO.setCustomerBO(customerBO);
		ContactBO contactBO2 = new ContactBO();
		contactBO2.setContactTypeId(2);
		contactBO2.setContactValue("044-202020");
		contactBO2.setCustomerBO(customerBO);
		ContactBO contactBO3 = new ContactBO();
		contactBO3.setContactTypeId(3);
		contactBO3.setContactValue("klklk@iii.com");
		contactBO3.setCustomerBO(customerBO);
		contactBOs.add(contactBO);
		contactBOs.add(contactBO2);
		contactBOs.add(contactBO3);
		return contactBOs;
	}
}
