/**
 * 
 */
package com.crafart;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.businessobjects.SeoBO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class CategoryControllerTest {

	@Autowired
	private CategoryController categoryController;

	@Test
	@Rollback(true)
	public void testGetCategories() {
		ModelMap modelMap = categoryController.getCategory(new MockHttpSession());
		System.out.println("CategoryControllerTest.testGetCourierDetail()");
		System.out.print(modelMap.size());
	}

	@Test
	@Rollback(true)
	public void testGetAllSubCategories() {
		ModelMap modelMap = categoryController.getAllSubCategories(new MockHttpSession());
		@SuppressWarnings("unchecked")
		List<CategoryBO> categoryBOs = (List<CategoryBO>) modelMap.get("subCategoryBOs");
		for (CategoryBO categoryBO : categoryBOs) {
			System.out.println("sub category parent id = " + categoryBO.getParentId());
			Assert.assertTrue(categoryBO.getParentId() > 0);
		}
		System.out.println("CategoryControllerTest.testGetCourierDetail()");
		System.out.print(modelMap.size());
	}

	@Test
	@Rollback(true)
	public void testaddCategoryBO() {
		CategoryBO categoryBO = new CategoryBO();
		categoryBO.setImageLocation("");
		categoryBO.setCategoryName("bag");
		categoryBO.setSortOrder(12);
		categoryBO.setStatus(2);
		categoryBO.setSeoBO(getSeo());
		try {
			categoryController.addCategory(categoryBO, new MockHttpSession());
		} catch (Exception exp) {
			exp.printStackTrace();
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
