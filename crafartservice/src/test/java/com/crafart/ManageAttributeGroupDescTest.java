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

import com.crafart.inter.service.ManageAttributeGroupDescService;
import com.crafart.service.businessobjects.AttributeGroupDescBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml",
		"classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ManageAttributeGroupDescTest {

	@Autowired
	private ManageAttributeGroupDescService manageAttributeGroupDescServiceImpl;

	@Test
	@Rollback(true)
	public void testgetAttributeGroupDesc() {
		try {
			List<AttributeGroupDescBO> attributeGroupDescBOs = manageAttributeGroupDescServiceImpl
					.getAttributeGroupDesc();
			Assert.assertNotNull(attributeGroupDescBOs);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

}
