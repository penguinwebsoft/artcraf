/**
 * 
 */
package com.crafart;

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

import com.crafart.dataobjects.CurrencyDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CurrencyDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CurrencyDAOTest {

	@Autowired
	private CurrencyDAO currencyDAOImpl;

	/*
	 * Test case to add data in currency table
	 */
	@Test
	@Rollback(true)
	public void testAddCurrency() {
		CurrencyDO currencyDO = getCurrency();
		try {
			currencyDAOImpl.addCurrency(currencyDO);
		} catch (CrafartDataException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}

	}

	/*
	 * Test case is to retrieve details from category table
	 */
	@Test
	@Rollback(true)
	public void testGetCurrency() {
		try {
			/* adding data to table and then retrieving data from table */
			testAddCurrency();
			List<CurrencyDO> currencyDOs = currencyDAOImpl.getCurrencyDetail();
			Assert.assertNotNull(currencyDOs);
		} catch (CrafartDataException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private CurrencyDO getCurrency() {
		CurrencyDO currencyDO = new CurrencyDO();
		currencyDO.setCode("klkl");
		currencyDO.setDecimalPlace(2);
		currencyDO.setStatus("sdsd");
		currencyDO.setSymbolLeft('$');
		currencyDO.setSymbolRight('&');
		currencyDO.setTitle("jkl");
		currencyDO.setValue(15);
		return currencyDO;
	}
}
