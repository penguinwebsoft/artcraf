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

import com.crafart.dataobjects.InformationDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.InformationDAO;

/**
 * 
 * @author
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class InformationDAOTest {

	@Autowired
	private InformationDAO informationDAOImpl;

	/*
	 * Test case to add data in information table
	 */
	@Test
	@Rollback(true)
	public void testAddInformationDetail() {
		InformationDO informationDO = getInformation();
		try {
			informationDAOImpl.addInformationDetail(informationDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private InformationDO getInformation() {
		InformationDO informationDO = new InformationDO();
		informationDO.setInformationTitle("schx");
		informationDO.setDescription("dhfhwhf");
		informationDO.setMetaTitle("fhdhv");
		informationDO.setMetaDescription("hefgh");
		informationDO.setMetaKeyword("fhh");
		informationDO.setIsActive("enable");
		informationDO.setSortOrder(1);
		return informationDO;
	}
	/*
	 * Test case is to retrieve details from information table
	 */
	@Test
	@Rollback(true)
	public void testgetInformationDetail() {
		InformationDO informationDO = getInformation();
		try {
			informationDAOImpl.addInformationDetail(informationDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		try {
			List<InformationDO> informationDOs = informationDAOImpl.getInformationDetail();
			Assert.assertNotNull(informationDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
}
