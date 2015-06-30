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

import com.crafart.dataobjects.AttributeDO;
import com.crafart.dataobjects.CategoryDO;
import com.crafart.dataobjects.SeoDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AttributeDAO;
import com.crafart.inter.data.CategoryDAO;
import com.crafart.inter.data.SeoDAO;


@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class AttributeDAOTest {
	
	@Autowired
	private AttributeDAO attributeDAOImpl;
	
	@Autowired
	private CategoryDAO categoryDAOImpl;
	
	@Autowired
	private SeoDAO seoDAOImpl;
	
	
	@Test
	@Rollback(true)
	public void testAddAttribute(){
		try {
			AttributeDO attributeDO = getAttributeDO();
			attributeDAOImpl.addAttribute(attributeDO);
			System.out.println("attribute id - " + attributeDO.getAttributeId());
		} catch (CrafartDataException cExp) {
			cExp.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test
	@Rollback(true)
	public void testGetAttributes(){
		try {
			// adding attribute 1
			attributeDAOImpl.addAttribute(getAttributeDO());
			// adding attribute 2
			attributeDAOImpl.addAttribute(getAttributeDO());
			List<AttributeDO> attributeDOs = attributeDAOImpl.getAllAttributes();
			Assert.assertEquals(2, attributeDOs.size());
		} catch (CrafartDataException cExp) {
			cExp.printStackTrace();
			Assert.fail();
		}
	}
	
	private AttributeDO getAttributeDO(){
		AttributeDO attributeDO = new AttributeDO();
		attributeDO.setAttributeName("Color");
		attributeDO.setCategoryDO(getCategory());
		attributeDO.setSortOrder(1);
		return attributeDO;
	}
	
	private CategoryDO getCategory() {
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
