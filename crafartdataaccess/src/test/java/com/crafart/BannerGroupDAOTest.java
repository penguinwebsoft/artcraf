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

import com.crafart.dataobjects.BannerGroupDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.BannerGroupDAO;

/**
 * 
 * @author
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class BannerGroupDAOTest {

	@Autowired
	private BannerGroupDAO bannerGroupDAOImpl;

	/*
	 * Test case to add data in banner table
	 */
	@Test
	@Rollback(true)
	public void testAddBannerGroupDetail() {
		BannerGroupDO bannerGroupDO = getBannerGroup();
		try {
			bannerGroupDAOImpl.addBannerGroupDetail(bannerGroupDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private BannerGroupDO getBannerGroup() {
		BannerGroupDO bannerGroupDO = new BannerGroupDO();
		bannerGroupDO.setBannerGroupName("gfd");
		bannerGroupDO.setBannerSize("fg");
		bannerGroupDO.setSortOrder(78);
		return bannerGroupDO;
	}
	/*
	 * Test case is to retrieve details from geozone table
	 */
	@Test
	@Rollback(true)
	public void testGetBannerGroupDetail() {
		BannerGroupDO bannerGroupDO = getBannerGroup();
		try {
			bannerGroupDAOImpl.addBannerGroupDetail(bannerGroupDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		try {
			List<BannerGroupDO> bannerGroupDOs = bannerGroupDAOImpl.getBannerGroupDetail();
			Assert.assertNotNull(bannerGroupDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
}
