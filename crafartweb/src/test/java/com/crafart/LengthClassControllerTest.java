/**
 * 
 */
package com.crafart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.service.businessobjects.LengthClassBO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class LengthClassControllerTest {

	@Autowired
	private LengthClassController lengthController;

	@Test
	@Rollback(true)
	public void testGetLengthClass() {
		try {
			lengthController.getLengthClass(new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	@Rollback(true)
	public void testAddLengthClass() {
		try {
			LengthClassBO lengthClassBO = getLengthClassdetail();
			lengthController.addLengthClass(lengthClassBO, new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test
	@Rollback(true)
	public void testUpdateLengthClass() {
		try {
			LengthClassBO lengthClassBO = getLengthClassdetail();
			lengthController.addLengthClass(lengthClassBO, new MockHttpSession());
			lengthController.updateLengthClass(lengthClassBO, new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	private LengthClassBO getLengthClassdetail() {
		LengthClassBO lengthClassBO = new LengthClassBO();
		lengthClassBO.setTitle("jj");
		lengthClassBO.setUnit("jnn");
		lengthClassBO.setIsActive(9);
		lengthClassBO.setSortOrder(9);
		
		return lengthClassBO;
	}
}

