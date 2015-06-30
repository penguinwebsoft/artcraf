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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.inter.service.ManageCategoryService;
import com.crafart.inter.service.ManageSeoService;
import com.crafart.seller.service.ManageAttributeService;
import com.crafart.service.businessobjects.AttributeBO;
import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.businessobjects.SeoBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * 
 * @author p.periyasamy
 *
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ManageAttributeServiceTest {

	@Autowired
	public ManageAttributeService manageAttributeServiceImpl;

	@Autowired
	public ManageCategoryService manageCategoryServiceImpl;

	@Autowired
	public ManageSeoService manageSeoServiceImpl;

	@Test
	@Rollback(true)
	public void testAddAttribute() {
		try {
			AttributeBO attributeBO = getAttributeBO();
			manageAttributeServiceImpl.addAttribute(attributeBO);
			System.out.println("attribute id - "+ attributeBO.getAttributeId());
			//key identifier should be greater than 0; if it is successfully updated to database.
			Assert.assertTrue(attributeBO.getAttributeId() > 0);
		} catch (CrafartServiceException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test
	@Rollback(false)
	@Transactional(propagation=Propagation.REQUIRED)
	public void testUpdateAttribute() {
		try {
			AttributeBO attributeBO = getAttributeBO();
			manageAttributeServiceImpl.addAttribute(attributeBO);
			System.out.println("sub cateogyr id ************************- "+ attributeBO.getSubCategoryBO().getCategoryId());
			System.out.println("attribute id - "+ attributeBO.getAttributeId());
			// adding new sub category and updating attribute with new subcategory.
			CategoryBO categoryBO = getCategory();
			attributeBO.setSubCategoryBO(categoryBO);
			System.out.println("updated sub cateogyr id ************************- "+ attributeBO.getSubCategoryBO().getCategoryId());

			attributeBO.setAttributeName("update one");
			//key identifier should be greater than 0; if it is successfully updated to database.
			manageAttributeServiceImpl.updateAttribute(attributeBO);
		} catch (CrafartServiceException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	@Transactional(propagation=Propagation.REQUIRED)
	public void testGetAllAttributes() {
		try {
			// inserting 1st attribute
			AttributeBO attributeBO = getAttributeBO();
			// inserting 2nd attribute
			AttributeBO attributeBO1 = getAttributeBO();
			manageAttributeServiceImpl.addAttribute(attributeBO);
			manageAttributeServiceImpl.addAttribute(attributeBO1);
			Map<Long, AttributeBO> attributeBOs = manageAttributeServiceImpl.getAttributes();
			System.out.println("attribute list size - "+ attributeBOs.size());
			for(Map.Entry<Long, AttributeBO> attributeBO2 : attributeBOs.entrySet()){
				if(attributeBO.getAttributeId() == attributeBO2.getKey() || attributeBO1.getAttributeId() == attributeBO2.getKey()){
					System.out.println("categoryd id is " + attributeBO1.getSubCategoryBO().getCategoryId());
				}
			}
			//key identifier should be greater than 0; if it is successfully updated to database.
			Assert.assertTrue(attributeBOs.size() >= 2);
		} catch (CrafartServiceException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testGetAllAttributesDummy() {
		try {
			Map<Long, AttributeBO> attributeBOs = manageAttributeServiceImpl.getAttributes();
			System.out.println("attribute list size - "+ attributeBOs.size());
			//System.out.println("dummy categoryd id is " + attributeBOs.get(0).getCategoryBO().getCategoryName());
			//key identifier should be greater than 0; if it is successfully updated to database.
			//Assert.assertTrue(attributeBOs.size() >= 2);
		} catch (CrafartServiceException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	private AttributeBO getAttributeBO() {
		AttributeBO attributeBO = new AttributeBO();
		attributeBO.setAttributeName("Service attribute");
		attributeBO.setSubCategoryBO(getCategory());
		attributeBO.setSortOrder(1);
		return attributeBO;
	}

	private CategoryBO getCategory() {
		CategoryBO categoryBO = new CategoryBO();
		try {

			categoryBO.setImageLocation("");
			categoryBO.setSortOrder(2);
			categoryBO.setStatus(2);
			categoryBO.setParentId(1);
			categoryBO.setSeoBO(getSeo());
			categoryBO.setDescription("testing from service");
			categoryBO.setCategoryName("gold");
			manageCategoryServiceImpl.addCategory(categoryBO);
		} catch (CrafartServiceException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return categoryBO;
	}

	private SeoBO getSeo() {
		SeoBO seoBO = new SeoBO();
		seoBO.setMetaDesc("abc");
		seoBO.setMetaKeyword("cde");
		seoBO.setMetaTitle("jkl");
		try {
			manageSeoServiceImpl.addSeo(seoBO);
		} catch (CrafartServiceException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return seoBO;
	}
}