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
import com.crafart.dataobjects.SeoDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CategoryDAO;
import com.crafart.inter.data.SeoDAO;

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

	@Autowired
	private SeoDAO seoDAOImpl;

	/**
	 * Test case is to retrieve details from category table
	 */
	@Test
	@Rollback(true)
	public void testGetCategory() {
		try {
			/* adding data in table and then retrieving from table */
			testaddcategory();
			List<CategoryDO> categoryDOs = categoryDAOImpl.getCategories();
			System.out.println("category list = " + categoryDOs.size());
			Assert.assertNotNull(categoryDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test
	@Rollback(true)
	public void testGetAllSubCategories() {
		try {
			/* adding data in table and then retrieving from table */
			testaddcategory();
			List<CategoryDO> categoryDOs = categoryDAOImpl.getAllSubCategories();
			for(CategoryDO categoryDO : categoryDOs){
				System.out.println(categoryDO.getParentId());
				Assert.assertTrue(categoryDO.getParentId() > 0);
			}
			
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testGetCategoryForCategoryId() {
		try {
			CategoryDO categoryDO = categoryDAOImpl.getCategory(getCategoryDO().getCategoryId());
			Assert.assertNotNull(categoryDO);
		} catch (CrafartDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			categoryDO.setImageLocation("");
			categoryDO.setSortOrder(2);
			categoryDO.setStatus(2);
			categoryDO.setSeoDO(getSeo());
			categoryDO.setDescription("Its gold jwellery");
			categoryDO.setCategoryName("gold");
			categoryDAOImpl.addCategory(categoryDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testUpdatecategory() {
		try {
			CategoryDO categoryDO = new CategoryDO();
			categoryDO.setImageLocation("");
			categoryDO.setSortOrder(2);
			categoryDO.setStatus(2);
			categoryDO.setSeoDO(getSeo());
			categoryDO.setDescription("Its gold jwellery");
			categoryDO.setCategoryName("gold");
			categoryDAOImpl.addCategory(categoryDO);
			//Updating category data
			categoryDO.setCategoryName("Gold Jwellery update");
			categoryDAOImpl.updateCategory(categoryDO);
			categoryDO = categoryDAOImpl.getCategory(categoryDO.getCategoryId());
			Assert.assertEquals("Gold Jwellery update", categoryDO.getCategoryName());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
	
	private CategoryDO getCategoryDO() {
		CategoryDO categoryDO = new CategoryDO();
		try {

			categoryDO.setImageLocation("");
			categoryDO.setSortOrder(2);
			categoryDO.setStatus(2);
			categoryDO.setSeoDO(getSeo());
			categoryDO.setDescription("Its gold jwellery");
			categoryDO.setCategoryName("gold");
			categoryDAOImpl.addCategory(categoryDO);

		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return categoryDO;
	}

	private SeoDO getSeo() {
		SeoDO seoDO = new SeoDO();
		seoDO.setMetaDesc("abc");
		seoDO.setMetaKeyword("cde");
		seoDO.setMetaTitle("jkl");
		try {
			seoDAOImpl.addSeo(seoDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return seoDO;
	}
}
