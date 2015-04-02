/**
 * 
 */
package com.crafart;

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

/**
 * @author Karthi
 *
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class AttributeGroupDescControllerTest {
	
	@Autowired
	private AttributeGroupDescController attributeGroupDescController;
	
	@Test
	@Rollback(true)
	public void TestGetAttribteGroupDesc(){
		try{
		ModelMap modelMap = attributeGroupDescController.getAttributeGroupDesc(new MockHttpSession());
		System.out.print(modelMap.get("attributeGroupDescBOs"));
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}

}
