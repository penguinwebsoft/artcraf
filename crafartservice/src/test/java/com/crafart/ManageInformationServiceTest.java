/**
 * 
 */
package com.crafart;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.inter.service.ManageInformationService;
import com.crafart.service.businessobjects.InformationBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author 
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageInformationServiceTest {

	@Autowired
	public ManageInformationService manageInformationServiceImpl;

	@Test
	@Rollback(true)
	public void testAddInformationDetail() {
		InformationBO informationBO = getInformation();
		try {
			manageInformationServiceImpl.addInformation(informationBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	private InformationBO getInformation() {
		InformationBO informationBO = new InformationBO();
		informationBO.setDescription("jlk");
		informationBO.setInformationTitle("h");
		informationBO.setDescription("rthy");
		informationBO.setMetaTitle("h");
		informationBO.setMetaDescription("fghf");
		informationBO.setMetaKeyword("hrt");
		informationBO.setIsActive("fgh");
		informationBO.setSortOrder(889);
		return informationBO;
	}

	@Test
	@Rollback(true)
	public void testGetinformationDetail() {
		InformationBO informationBO = getInformation();
		try {
			manageInformationServiceImpl.addInformation(informationBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			@SuppressWarnings("unused")
			Map<Long, InformationBO> informationBOs = manageInformationServiceImpl.getInformations();
			
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}
}
