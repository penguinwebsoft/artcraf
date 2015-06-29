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

import com.crafart.dataobjects.BannerDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.BannerDAO;

/**
 * 
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class BannerDAOTest {

	@Autowired
	private BannerDAO bannerDAOImpl;

	/*
	 * Test case to add data in banner table
	 */
	@Test
	@Rollback(true)
	public void testAddBannerDetail() {
		BannerDO bannerDO = getBanner();
		try {
			bannerDAOImpl.addBannerDetail(bannerDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private BannerDO getBanner() {
		BannerDO bannerDO = new BannerDO();
		bannerDO.setBannerImage("efjj");
		bannerDO.setBannerName("jvfdv");
		bannerDO.setBannerUrl("ndcs");
		bannerDO.setSortOrder(1);
		return bannerDO;
	}
	/*
	 * Test case is to retrieve details from banner table
	 */
	@Test
	@Rollback(true)
	public void testGetBannerDetail() {
		BannerDO bannerDO = getBanner();
		try {
			
			bannerDAOImpl.addBannerDetail(bannerDO);
			List<BannerDO> bannerDOs = bannerDAOImpl.getBannerDetail();
			Assert.assertNotNull(bannerDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
}
}