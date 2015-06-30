/**
 * 
 */
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

import com.crafart.dataobjects.AttributeGroupDescDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AttributeGroupDescDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class AttributeGroupDescDAOTest {

	@Autowired
	private AttributeGroupDescDAO attributeGroupDescDAOImpl;
	
	@Test
	public void testDummy(){
		
	}
	
	/*
	 * Test case to add attribute group to attribte grop description table
	 */
	@Test
	@Rollback(true)
	public void addAttributeGroupDesc() {
		AttributeGroupDescDO attributeGroupDescDO = new AttributeGroupDescDO();
		attributeGroupDescDO.setAttributeGroupName("model");
		attributeGroupDescDO.setSortOrder(1);
		try {
			attributeGroupDescDAOImpl.addAttributeGroupDesc(attributeGroupDescDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	/*
	 * Test case to retrieve to data from table
	 */
	@Test
	@Rollback(true)
	public void getAttributeGroupDesc() {
		List<AttributeGroupDescDO> attributeGroupDescDOs = new ArrayList<>();
		try {
			/*Adding data to table and then retrieve data from table*/
			addAttributeGroupDesc();
			attributeGroupDescDOs = attributeGroupDescDAOImpl.getAttributeGroupDesc();
			Assert.assertNotNull(attributeGroupDescDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
}
