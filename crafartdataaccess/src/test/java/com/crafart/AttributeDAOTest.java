package com.crafart;

import java.util.ArrayList;
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
			List<AttributeDO> attributeDOs = new ArrayList<AttributeDO>();
			CategoryDO categoryDO = getAttributeDO().getCategoryDOs().get(0);
			attributeDOs.add(attributeDO);
			categoryDO.setAttributeDOs(attributeDOs);
			attributeDAOImpl.addAttribute(attributeDO);
			System.out.println("attribute id - " + attributeDO.getAttributeId());
		} catch (CrafartDataException cExp) {
			cExp.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	@Rollback(true)
	public void testUpdateAttribute(){
		try {
			AttributeDO attributeDO = getAttributeDO();
			attributeDAOImpl.addAttribute(attributeDO);
			attributeDO.setAttributeName("Color updated");
			attributeDAOImpl.updateAttribute(attributeDO);
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
			AttributeDO attributeDO1 = getAttributeDO();
			attributeDAOImpl.addAttribute(attributeDO1);
			List<AttributeDO> attributeDOs = attributeDAOImpl.getAllAttributes();
			System.out.println("size of attribute list size" + attributeDOs.size());
			for(AttributeDO attributeDO : attributeDOs){
				if(attributeDO.getAttributeId() == attributeDO1.getAttributeId()){
					System.out.println("categoryd id is " + attributeDO.getCategoryDOs().get(0).getCategoryId());
				}
			}
						Assert.assertTrue(attributeDOs.size() >= 2);
		} catch (CrafartDataException cExp) {
			cExp.printStackTrace();
			Assert.fail();
		}
	}
	
	private AttributeDO getAttributeDO(){
		AttributeDO attributeDO = new AttributeDO();
		attributeDO.setAttributeName("Color update");
		List<CategoryDO> categoryDOs = new ArrayList<>();
		categoryDOs.add(getCategory());
		attributeDO.setCategoryDOs(categoryDOs);
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
			categoryDO.setCategoryName("Diamond");
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
