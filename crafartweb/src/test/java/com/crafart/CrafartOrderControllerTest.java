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
public class CrafartOrderControllerTest {

	@Autowired
	private CrafartOrderController crafartOrderControllerImpl;

	@Test
	@Rollback(true)
	public void testGetCrafartOrder() {
		try {
			ModelMap modelMap = crafartOrderControllerImpl.getCrafartOrder(new MockHttpSession());
			System.out.print(modelMap.toString());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
}
