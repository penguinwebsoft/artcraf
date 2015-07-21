/**
 * 
 */
package com.crafart;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.inter.service.ManageTaxClassService;
import com.crafart.service.businessobjects.TaxClassBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author karthi
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ManageTaxClassServiceTest {

	@Autowired
	private ManageTaxClassService manageTaxClassServiceImpl;

	@Test
	@Rollback(true)
	public void testGetTaxClassDetail() {
		try {
			TaxClassBO taxClassBO = getTaxClassDetail();
			manageTaxClassServiceImpl.addTaxClass(taxClassBO);
			System.out.println("taxclass id is = " + taxClassBO.getTaxClassId());
			Map<Long, TaxClassBO> taxClassBOs = manageTaxClassServiceImpl.getTaxClasses();
			int count = 0;
			System.out.println("******************************************************************");
			for (Map.Entry<Long, TaxClassBO> taxClassBOEntry : taxClassBOs.entrySet()) {
				System.out.println("list taxclass id is = " + taxClassBOEntry.getValue().getTaxClassId());
				if (taxClassBO.getTaxClassId() == taxClassBOEntry.getValue().getTaxClassId()) {
					count = count + 1;
				}
			}
			Assert.assertTrue(count == 1);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testAddTaxClassDetail() {
		TaxClassBO taxClassBO = getTaxClassDetail();
		try {
			manageTaxClassServiceImpl.addTaxClass(taxClassBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testUpdateTaxClass() {
		TaxClassBO taxClassBO = getTaxClassDetail();
		try {
			manageTaxClassServiceImpl.addTaxClass(taxClassBO);
			// updating taxclass data
			taxClassBO.setTitle("Title update");
			manageTaxClassServiceImpl.updateTaxClass(taxClassBO);
			Assert.assertEquals("Title update", taxClassBO.getTitle());
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	private TaxClassBO getTaxClassDetail() {
		TaxClassBO taxClassBO = new TaxClassBO();
		taxClassBO.setTitle("jlk");
		taxClassBO.setDescription("kkf");
		taxClassBO.setSortOrder(1);
		return taxClassBO;
	}

}
