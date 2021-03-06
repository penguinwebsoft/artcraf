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

import com.crafart.inter.data.CategoryDAO;
import com.crafart.inter.service.ManageCategoryService;
import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.businessobjects.SeoBO;
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
				System.out.println(categoryBO.getCategoryName());
			}
			Assert.assertNotNull(categoryBOs);
		} catch (CrafartServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	@Rollback(true)
	public void testaddCategoryBO() {
		CategoryBO categoryBO = new CategoryBO();
		categoryBO.setImageLocation("");
		categoryBO.setCategoryName("bag");
		categoryBO.setSortOrder(12);
		categoryBO.setDescription("its paper bag");
		categoryBO.setStatus(2);
		categoryBO.setSeoBO(getSeo());
		try {
			manageCategoryServiceImpl.addCategory(categoryBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}

	}

	private SeoBO getSeo() {
		SeoBO seoBO = new SeoBO();
		seoBO.setMetaDesc("asdf");
		seoBO.setMetaKeyword("qwert");
		seoBO.setMetaTitle("zxcvbn");
		return seoBO;
	}

}
