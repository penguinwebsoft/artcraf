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
import org.springframework.transaction.annotation.Transactional;

import com.crafart.service.ManageAddressService;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 *
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ManageAddressServiceTest {

	@Autowired
	private ManageAddressService manageAddressServiceImpl;
	
	@Test
	@Rollback(true)
	public void testAddAddress(){
		AddressBO addressBO = getAddress();
		try {
			manageAddressServiceImpl.addAddress(addressBO);
		} catch (CrafartServiceException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	private AddressBO getAddress() {
		AddressBO addressBO = new AddressBO();
		addressBO.setCityId(1111);
		addressBO.setPinCode("111111");
		addressBO.setStateId(1);
		addressBO.setStreet("asas dfdff");
		return addressBO;
	}
}
