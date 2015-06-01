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

import com.crafart.dataobjects.CategoryDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CategoryDAO;

/**
 * @author karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CategoryDAOTest {

	@Autowired
	private CategoryDAO categoryDAOImpl;

	/**
	 * Test case is to retrieve details from category table
	 */
	@Test
	@Rollback(true)
	public void testGetCategory() {
		try {
			/* adding data in table and then retrieving from table */
			testaddcategory();
			List<CategoryDO> categoryDOs = categoryDAOImpl.getCategory();
			Assert.assertNotNull(categoryDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	/*
	 * Test case to add data in category table
	 */
	@Test
	@Rollback(true)
	public void testaddcategory() {
		try {
			CategoryDO categoryDO = new CategoryDO();
			categoryDO.setCategoryColumn(3);
			categoryDO.setImageLocation("");
			categoryDO.setParentId(2);
			categoryDO.setSortOrder(2);
			categoryDO.setStatus(2);
			categoryDO.setCategoryName("gold");
			categoryDAOImpl.addCategory(categoryDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
}
