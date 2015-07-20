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
import com.crafart.dataobjects.SeoDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.InformationDAO;
import com.crafart.inter.data.SeoDAO;

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

	@Autowired
	private SeoDAO seoDAOImpl;

	/*
	 * Test case to add data in information table
	 */
	@Test
	@Rollback(true)
	public void testAddInformationDetail() {
		InformationDO informationDO = getInformation();
		try {
			informationDAOImpl.addInformation(informationDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testUpdateInformationDetail() {
		InformationDO informationDO = getInformation();
		try {
			informationDAOImpl.addInformation(informationDO);
			informationDO.setInformationTitle("update information");
			informationDAOImpl.updateInformation(informationDO);
			informationDO = informationDAOImpl.getInformation(informationDO.getInformationId());
			Assert.assertEquals("update information", informationDO.getInformationTitle());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private InformationDO getInformation() {
		InformationDO informationDO = new InformationDO();
		informationDO.setInformationTitle("schx");
		informationDO.setDescription("dhfhwhf");
		informationDO.setSeoDO(getSeo());
		informationDO.setIsActive(1);
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
			informationDAOImpl.addInformation(informationDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		try {
			List<InformationDO> informationDOs = informationDAOImpl.getInformations();
			for(InformationDO informationDOLst : informationDOs){
				System.out.println("is active value = "+ informationDOLst.getIsActive());
			}
			Assert.assertTrue(informationDOs.size() >= 1);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
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
