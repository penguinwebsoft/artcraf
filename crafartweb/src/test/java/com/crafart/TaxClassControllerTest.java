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

import com.crafart.service.businessobjects.TaxClassBO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class TaxClassControllerTest {

	@Autowired
	private TaxClassController taxClassController;

	@Test
	@Rollback(true)
	public void testGetTaxClass() {
		try {
			taxClassController.getTaxClass(new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testAddTaxClass() {
		try {
			taxClassController.addTaxClass(getTaxClass(), new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testUpdateTaxClass() {
		try {
			TaxClassBO taxClassBO = getTaxClass();
			taxClassController.addTaxClass(taxClassBO, new MockHttpSession());
			taxClassController.updateTaxClass(taxClassBO, new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	private TaxClassBO getTaxClass() {
		TaxClassBO taxClassBO = new TaxClassBO();
		taxClassBO.setTitle("jlk");
		taxClassBO.setDescription("kkf");
		taxClassBO.setSortOrder(1);
		return taxClassBO;
	}

}
