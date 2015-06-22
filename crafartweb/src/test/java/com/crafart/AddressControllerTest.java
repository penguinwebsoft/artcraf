/**
 * 
 */
package com.crafart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.service.businessobjects.AddressBO;

/**
 * @author Karthi
 *
 */

@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class AddressControllerTest {

	@Autowired
	private AddressController addressController;

	@Test
	@Rollback(true)
	public void addAddress() {
		AddressBO addressBO = getAddress();
		try {
			addressController.addAddress(addressBO, new MockHttpServletRequest());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private AddressBO getAddress() {
		AddressBO addressBO = new AddressBO();
		addressBO.setCityId(101);
		addressBO.setPinCode("22222");
		addressBO.setStateId(1);
		addressBO.setStreet("asas dfdff");
		return addressBO;
	}
}
