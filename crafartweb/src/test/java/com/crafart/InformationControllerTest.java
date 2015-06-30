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

import com.crafart.service.businessobjects.InformationBO;

/**
 * @author 
 * 
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class InformationControllerTest {

	@Autowired
	private InformationController informationController;

	@Test
	@Rollback(true)
	public void testGetInformation() {
		try {
			informationController.getInformation(new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@SuppressWarnings("unused")
	private InformationBO getInformationdetail() {
		InformationBO informationBO = new InformationBO();
		informationBO.setInformationTitle("yjtyh");
		informationBO.setDescription("fgbf");
		informationBO.setSortOrder(99);
		informationBO.setMetaTitle("fgb");
		informationBO.setMetaDescription("fhdb");
		informationBO.setMetaKeyword("bhbh");
		informationBO.setIsActive("fds");
		return informationBO;
	}
}

