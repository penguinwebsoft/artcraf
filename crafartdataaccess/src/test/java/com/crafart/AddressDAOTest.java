/**
 * 
 */
package com.crafart;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.AddressDAO;
import com.crafart.dataobjects.AddressDO;
import com.crafart.exception.CrafartDataException;

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
	private static final Logger log = Logger.getLogger(SellerDAOTest.class);
	
	@Autowired
	private AddressDAO addressDAOImpl;
	
	@Test
	@Rollback(true)
	public void testAddAddress(){
		AddressDO addressDO = getAddress();
		try {
			addressDAOImpl.addAddress(addressDO);
		} catch (CrafartDataException crafartDataException) {
			crafartDataException.printStackTrace();
			Assert.fail();
		}
	}

	private AddressDO getAddress() {

		AddressDO addressDO = new AddressDO();
		addressDO.setCityId(12);
		addressDO.setPinCode("000000");
		addressDO.setStateId(123123);
		addressDO.setStreet("aaaa cccc");
		return addressDO;
	}
}
