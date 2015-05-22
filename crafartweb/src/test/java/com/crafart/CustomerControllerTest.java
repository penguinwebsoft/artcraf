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
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.ContactBO;
import com.crafart.service.businessobjects.CustomerBO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class CustomerControllerTest {

	@Autowired
	private CustomerController customerController;

	@Test
	@Rollback(true)
	public void testAddCustomer() {
		CustomerBO customerBO = getCustomer();
		try {
			customerController.addCustomer(customerBO, new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
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
		customerBO.setLastName("day");
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
		addressBO.setStreet("2a controller");
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
		contactBO3.setContactValue("controller@iii.com");
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
			customerController.findByEmailId("karthikool12@gmail.com", "null", new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Ignore
	@Rollback(true)
	public void testUpdateCustomerDetails() {
		CustomerBO customerBO = getCustomer();
		try {
			customerController.addCustomer(customerBO, new MockHttpSession());
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
			customerController.updateCustomerDetail(customerBO, new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
