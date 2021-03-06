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

import com.crafart.dataobjects.CommissionDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CommissionDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CommissionTestDAO {

	@Autowired
	private CommissionDAO commissionDAOImpl;

	/*
	 * Test case to add data in table
	 */
	@Test
	@Rollback(true)
	public void testAddCommission() {
		CommissionDO commissionDO = getCommission();
		try {
			commissionDAOImpl.addCommission(commissionDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	/*
	 * 
	 * Test method is to retrieve details from category table
	 */
	@Test
	@Rollback(true)
	public void getCommissionDetail() {
		try {
			/* adding data to table then retrieve from table */
			testAddCommission();
			List<CommissionDO> commissionDOs = commissionDAOImpl.getCommission();
			Assert.assertNotNull(commissionDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private CommissionDO getCommission() {
		CommissionDO commissionDO = new CommissionDO();
		commissionDO.setName("qwqw");
		commissionDO.setSortOrder(2);
		commissionDO.setType("comm");
		commissionDO.setValue(3.5f);
		return commissionDO;
	}

}
