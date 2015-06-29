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

import com.crafart.dataobjects.LengthClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.LengthClassDAO;

/**
 * 
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class LengthClassDAOTest {

	@Autowired
	private LengthClassDAO lengthClassDAOImpl;

	/*
	 * Test case to add data in LengthClass table
	 */
	@Test
	@Rollback(true)
	public void testAddLengthClassDetail() {
		LengthClassDO lengthClassDO = getLengthClass();
		try {
			lengthClassDAOImpl.addLengthClass(lengthClassDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private LengthClassDO getLengthClass() {
		LengthClassDO lengthClassDO = new LengthClassDO();
		lengthClassDO.setTitle("jj");
		lengthClassDO.setUnit("cm");
		lengthClassDO.setIsActive(1);
		lengthClassDO.setSortorder(1);
		return lengthClassDO;
	}

	/*
	 * Test case is to retrieve details from lengthClass table
	 */
	@Test
	@Rollback(true)
	public void testGetLengthClass() {
		LengthClassDO lengthClassDO = getLengthClass();
		try {
			lengthClassDAOImpl.addLengthClass(lengthClassDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		try {
			List<LengthClassDO> lengthClassDOs = lengthClassDAOImpl.getLengthClass();
			Assert.assertNotNull(lengthClassDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
}
