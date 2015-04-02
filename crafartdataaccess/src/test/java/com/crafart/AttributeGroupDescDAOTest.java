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
	@Test
	@Rollback(true)
	public void getAttributeGroupDesc(){
		List<AttributeGroupDescDO> attributeGroupDescDOs = new ArrayList<>();
		try {
			attributeGroupDescDOs = attributeGroupDescDAOImpl.getAttributeGroupDesc();
			for (AttributeGroupDescDO attributeGroupDescDO : attributeGroupDescDOs) {
				System.out.print("\n"+attributeGroupDescDO.getAtrributeGroupDescId());
			}
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
}
