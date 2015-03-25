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

import com.crafart.data.CategoryDAO;
import com.crafart.service.ManageCategoryService;
import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Deepam
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageCategoryServiceTest {

	@Autowired
	private ManageCategoryService manageCategoryServiceImpl;

	@Autowired
	private CategoryDAO categoryDAOImpl;

	@Test
	@Rollback(true)
	public void testGetCategory() {
		try {
			testaddCategoryBO();
			List<CategoryBO> categoryBOs = manageCategoryServiceImpl.getCategory();
			for (CategoryBO categoryBO : categoryBOs) {
				// System.out.print("\n" + categoryBO.getCategoryId());
			}
		} catch (CrafartServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	@Rollback(true)
	public void testaddCategoryBO() {
		CategoryBO categoryBO = new CategoryBO();
		categoryBO.setCategoryColumn(32);
		categoryBO.setImageLocation("qwerty");
		categoryBO.setParentId(25);
		categoryBO.setSortOrder(12);
		categoryBO.setStatus(2);
		try {
			manageCategoryServiceImpl.addCategory(categoryBO);
		} catch (CrafartServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}

	}
}
