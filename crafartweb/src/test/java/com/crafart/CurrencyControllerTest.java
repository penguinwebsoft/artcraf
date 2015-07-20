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

import com.crafart.service.businessobjects.CurrencyBO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class CurrencyControllerTest {

	@Autowired
	private CurrencyController currencyController;

	@Test
	@Rollback(true)
	public void testGetCurrency() {
		try {
			currencyController.getCurrencies(new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@SuppressWarnings("unused")
	private CurrencyBO getCurrencydetail() {
		CurrencyBO currencyBO = new CurrencyBO();
		currencyBO.setTitle("fg");
		currencyBO.setValue(9);
		currencyBO.setSymbolRight("$");
		currencyBO.setSymbolLeft("$");
		currencyBO.setDecimalPlace(9);
		currencyBO.setStatus("enable");
		currencyBO.setCode("cd");
		return currencyBO;
	}
}

