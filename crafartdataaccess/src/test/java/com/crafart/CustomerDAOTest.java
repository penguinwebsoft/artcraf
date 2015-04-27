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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.AddressDO;
import com.crafart.dataobjects.ContactDO;
import com.crafart.dataobjects.CustomerDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AddressDAO;
import com.crafart.inter.data.ContactDAO;
import com.crafart.inter.data.CustomerDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CustomerDAOTest {

	@Autowired
	private CustomerDAO customerDAOImpl;

	@Autowired
	private ContactDAO contactDAOImpl;

	@Autowired
	private AddressDAO addressDAOImpl;

	@Test
	@Rollback(true)
	public void testAddCustomer() {
		CustomerDO customerDO = getCustomer();
		try {
			customerDAOImpl.addCustomer(customerDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private CustomerDO getCustomer() {
		CustomerDO customerDO = new CustomerDO();
		customerDO.setDateOfBirth("00-00-1000");
		customerDO.setFirstName("satur");
		customerDO.setGender(0);
		customerDO.setLastName("day");
		customerDO.setIp("120000001200");
		customerDO.setPassword("klklkl");
		customerDO.setStatus(1);
		List<CustomerDO> customerDOs = new ArrayList<>();
		customerDOs.add(customerDO);
		customerDO.setContactDOs(getContactDOs(customerDOs));
		customerDO.setAddressDOs(getAddressDOs(customerDOs));
		return customerDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<AddressDO> getAddressDOs(List<CustomerDO> customerDOs) {
		List<AddressDO> addressDOs = new ArrayList<>();
		AddressDO addressDO = new AddressDO();
		addressDO.setCityId(047);
		addressDO.setPinCode("639117");
		addressDO.setStateId(047);
		addressDO.setStreet("2a nagar");
		addressDOs.add(addressDO);
		return addressDOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<ContactDO> getContactDOs(List<CustomerDO> customerDOs) {
		List<ContactDO> contactDOs = new ArrayList<>();
		ContactDO contactDO = new ContactDO();
		contactDO.setContactTypeId(1);
		contactDO.setContactValue("9999900000");
		contactDO.setCustomerDOs(customerDOs);
		ContactDO contactDO2 = new ContactDO();
		contactDO2.setContactTypeId(2);
		contactDO2.setContactValue("044-505000");
		contactDO2.setCustomerDOs(customerDOs);
		ContactDO contactDO3 = new ContactDO();
		contactDO3.setContactTypeId(3);
		contactDO3.setContactValue("asass@iii.com");
		contactDO3.setCustomerDOs(customerDOs);
		contactDOs.add(contactDO);
		contactDOs.add(contactDO2);
		contactDOs.add(contactDO3);
		return contactDOs;
	}

}
