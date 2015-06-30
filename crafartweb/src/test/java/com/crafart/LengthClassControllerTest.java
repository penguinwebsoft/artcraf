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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.crafart.service.businessobjects.CurrencyBO;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.exception.CrafartServiceException;

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
	private LengthController lengthController;

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
	
	@SuppressWarnings("unused")
	private LengthClassBO getLengthClassdetail() {
		LengthClassBO lengthClassBO = new LengthClassBO();
		lengthClassBO.setTitle("jj");
		lengthClassBO.setUnit("jnn");
		lengthClassBO.setIsActive(9);
		lengthClassBO.setSortorder(9);
		
		return lengthClassBO;
	}
}

