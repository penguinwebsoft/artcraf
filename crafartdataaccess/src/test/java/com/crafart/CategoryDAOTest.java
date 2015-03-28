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

import com.crafart.data.CategoryDAO;
import com.crafart.dataobjects.CategoryDO;
import com.crafart.exception.CrafartDataException;

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
	 * this test method is to retrive details from category table 
	 */
	@Test
	@Rollback(true)
	public void testGetCategory() {
		try {
			testaddcategory();
			List<CategoryDO> categoryDO = categoryDAOImpl.getCategory();
			/**
			 * it will print the categoryId to system console
			 */
			/*for (CategoryDO categoryDO2 : categoryDO) {
				System.out.print("\n" + categoryDO2.getCategoryId());
			}*/
		} catch (CrafartDataException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	@Rollback(true)
	public void testaddcategory() {
		try {
			CategoryDO categoryDO = new CategoryDO();
			categoryDO.setCategoryColumn(3);
			categoryDO.setImageLocation("jkl");
			categoryDO.setParentId(2);
			categoryDO.setSortOrder(2);
			categoryDO.setStatus(2);
			categoryDAOImpl.addCategory(categoryDO);
		} catch (CrafartDataException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
}
