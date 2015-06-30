/**
 * 
 */
package com.crafart;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.inter.service.ManageCurrencyService;
import com.crafart.service.businessobjects.CurrencyBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageCurrencyServiceTest {

	@Autowired
	public ManageCurrencyService manageCurrencyServiceImpl;

	@Test
	@Rollback(true)
	public void testAddCurrencyDetail() {
		CurrencyBO currencyBO = getCurrencyDetail();
		try {
			manageCurrencyServiceImpl.addCurrencyDetail(currencyBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	
	private CurrencyBO getCurrencyDetail() {
		CurrencyBO currencyBO = new CurrencyBO();
		currencyBO.setTitle("knj");
		currencyBO.setCode("kj");
		currencyBO.setStatus("vje");
		currencyBO.setSymbolLeft("$");
		currencyBO.setSymbolRight("$");
		currencyBO.setValue(9);
		currencyBO.setDecimalPlace(45544);
		return currencyBO;
		}

	@Test
	@Rollback(true)
	public void testGetCurrencyDetail() {
		CurrencyBO currencyBO = getCurrencyDetail();
		
		try {
			manageCurrencyServiceImpl.addCurrencyDetail(currencyBO);
			List<CurrencyBO> currencyBOs = manageCurrencyServiceImpl.getCurrencyDetail();
			Assert.assertNotNull(currencyBOs);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}
}
