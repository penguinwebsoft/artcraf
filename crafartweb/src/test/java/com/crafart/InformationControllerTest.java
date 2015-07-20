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
import com.crafart.service.businessobjects.SeoBO;

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

	@Test
	@Rollback(true)
	public void testAddInformation() {
		try {
			informationController.addInformation(getInformationdetail(), new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testUpdateInformation() {
		try {
			InformationBO informationBO = getInformationdetail();
			informationController.addInformation(informationBO, new MockHttpSession());
			informationController.updateInformation(informationBO, new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	private InformationBO getInformationdetail() {
		InformationBO informationBO = new InformationBO();
		informationBO.setInformationTitle("yjtyh");
		informationBO.setDescription("fgbf");
		informationBO.setSortOrder(99);
		informationBO.setSeoBO(getSeo());
		informationBO.setIsActive(0);
		return informationBO;
	}

	private SeoBO getSeo() {
		SeoBO seoBO = new SeoBO();
		seoBO.setMetaDesc("asdf");
		seoBO.setMetaKeyword("qwert");
		seoBO.setMetaTitle("zxcvbn");
		return seoBO;
	}
}
