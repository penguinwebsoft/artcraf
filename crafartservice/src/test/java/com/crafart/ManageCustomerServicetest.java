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

import com.crafart.inter.service.ManageCustomerService;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.ContactBO;
import com.crafart.service.businessobjects.CustomerBO;
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
public class ManageCustomerServicetest {

	@Autowired
	private ManageCustomerService customerServiceImpl;

	@Test
	@Rollback(true)
	public void testAddCustomer() {
		CustomerBO customerBO = getCustomer();
		try {
			customerServiceImpl.addCustomerDetail(customerBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testUpdateCustomerDetails() {
		CustomerBO customerBO = getCustomer();
		try {
			customerServiceImpl.addCustomerDetail(customerBO);
			// failing test case if the insertion get failed, i.e if customer id
			// is 0
			if (customerBO.getCustomerId() == 0) {
				Assert.fail();
			}
			System.out.print(customerBO.getCustomerId());
			customerBO.setFirstName("update");
			AddressBO addressBO = customerBO.getAddressBO();
			addressBO.setStreet("krishna college");
			List<ContactBO> contactBOs = customerBO.getContactBOs();
			for (ContactBO contactBO : contactBOs) {
				if (contactBO.getContactTypeId() == 1)
					contactBO.setContactValue("15243");
			}
			customerServiceImpl.updateCustomerDetail(customerBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		} catch (Exception exp) {
			exp.printStackTrace();
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

	@Test
	@Rollback(true)
	public void testFindByEmail() {
		try {
			ContactBO contactBO = customerServiceImpl
					.findByEmailId("karthikool12@gmail.com");
			CustomerBO customerBO = contactBO.getCustomerBO();
			for (ContactBO contactBO2 : customerBO.getContactBOs()) {
				System.out.println(contactBO2.getContactValue());
			}
			System.out.println(customerBO.getAddressBO().getAddressId());
			System.out.println(customerBO.getFirstName() + "\t"
					+ customerBO.getCustomerId());
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testGetCustomerDetail() {
		CustomerBO customerBO1 = getCustomer();
		try {
			customerServiceImpl.addCustomerDetail(customerBO1);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			CustomerBO customerBO = customerServiceImpl
					.getCustomerDetails(customerBO1.getCustomerId());
			for (ContactBO contactBO : customerBO.getContactBOs()) {
				System.out.println(contactBO.getContactValue());
			}
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
		}
	}
}
