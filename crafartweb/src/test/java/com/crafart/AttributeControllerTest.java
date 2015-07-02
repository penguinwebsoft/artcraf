package com.crafart;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.service.businessobjects.AttributeBO;
import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.businessobjects.SeoBO;

/**
 * tests controller methods add/update/retrieve all attributes
 * 
 * @author p.periyasamy
 *
 */

@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class AttributeControllerTest {

	@Autowired
	private AttributeController attributeController;

	@Autowired
	private CategoryController categoryController;

	@Test
	public void testAddAttribute() {
		attributeController.addAttribute(getAttributeBO());
	}
	
	
	@Ignore
	public void testGetAttribute() {
		attributeController.getAttributes(new MockHttpServletResponse(), new MockHttpSession());
	}

	@Test
	public void testUpdateAttribute() {
		AttributeBO attributeBO = getAttributeBO();
		attributeController.addAttribute(attributeBO);
		attributeController.updateAttribute(attributeBO);
	}

	private AttributeBO getAttributeBO() {
		AttributeBO attributeBO = new AttributeBO();
		attributeBO.setAttributeName("Color");
		attributeBO.setSubCategoryBO(getCategoryBO());
		attributeBO.setSortOrder(1);
		return attributeBO;
	}

	private CategoryBO getCategoryBO() {
		CategoryBO categoryBO = new CategoryBO();
		categoryBO.setImageLocation("");
		categoryBO.setSortOrder(2);
		categoryBO.setStatus(2);
		categoryBO.setSeoBO(new SeoBO());
		categoryBO.setDescription("Its gold jwellery");
		categoryBO.setCategoryName("gold");
		categoryController.addCategory(categoryBO, new MockHttpSession());

		return categoryBO;
	}

}
