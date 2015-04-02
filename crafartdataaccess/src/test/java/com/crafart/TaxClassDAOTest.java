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
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.TaxClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.TaxClassDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class TaxClassDAOTest {

	@Autowired
	public TaxClassDAO taxClassDAOImpl;

	/*
	 * @Test
	 * 
	 * @Rollback(true) public void testaddTaxClassDetail(){ TaxClassDO
	 * taxClassDO = getTaxClass(); try {
	 * taxClassDAOImpl.addTaxClassDetail(taxClassDO); } catch
	 * (CrafartDataException e) { e.printStackTrace(); Assert.fail(); } }
	 */

	/*
	 * private TaxClassDO getTaxClass() { TaxClassDO taxClassDO = new
	 * TaxClassDO(); taxClassDO.setDescription("VAT %");
	 * taxClassDO.setTitle("VAT"); return taxClassDO; }
	 */
	@Test
	@Rollback(true)
	public void testGetTaxClassDetail() {
		try {
			List<TaxClassDO> taxClassDOs = taxClassDAOImpl.getTaxClassDetail();
			for (TaxClassDO taxClassDO : taxClassDOs) {
				System.out.print("\n" + taxClassDO.getTaxClassId());
			}
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
}
