/**
 * 
 */
package com.crafart;

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

import com.crafart.dataobjects.CustomerDO;
import com.crafart.exception.CrafartDataException;
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
		customerDO.setFirstName("jkjk");
		customerDO.setGender(0);
		customerDO.setLastName("kjkj");
		customerDO.setIp("120000001200");
		customerDO.setPassword("klklkl");
		customerDO.setStatus(1);
		return customerDO;
	}

}
