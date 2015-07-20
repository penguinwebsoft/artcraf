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
import com.crafart.dataobjects.BannerGroupDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.BannerDAO;
import com.crafart.inter.data.BannerGroupDAO;

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

	@Autowired
	private BannerGroupDAO bannerGroupDAOImpl;

	/*
	 * Test case to add data in banner table
	 */
	@Test
	@Rollback(true)
	public void testAddBannerDetail() {
		BannerDO bannerDO = getBanner();
		try {
			BannerGroupDO bannerGroupDO = getBannerGroupDO();
			bannerGroupDAOImpl.addBannerGroup(bannerGroupDO);
			bannerDO.setBannerGroupDO(bannerGroupDO);
			bannerDAOImpl.addBanner(bannerDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testGetBanners() {
		BannerDO bannerDO = getBanner();
		try {
			BannerGroupDO bannerGroupDO = getBannerGroupDO();
			bannerGroupDAOImpl.addBannerGroup(bannerGroupDO);
			bannerDO.setBannerGroupDO(bannerGroupDO);
			bannerDAOImpl.addBanner(bannerDO);
			List<BannerDO> bannerDOs = bannerDAOImpl.getBannerDetail();
			Assert.assertTrue(bannerDOs.size() >= 1);
			for (BannerDO collectBannerDO : bannerDOs) {
				if (collectBannerDO.getBannerId() == bannerDO.getBannerId()) {
					Assert.assertNotNull(collectBannerDO.getBannerGroupDO());
				}
			}
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testUpdateBanner() {
		BannerDO bannerDO = getBanner();

		try {
			BannerGroupDO bannerGroupDO = getBannerGroupDO();
			bannerGroupDAOImpl.addBannerGroup(bannerGroupDO);
			bannerDO.setBannerGroupDO(bannerGroupDO);
			bannerDAOImpl.addBanner(bannerDO);
			bannerDO.setBannerName("Banner name update");
			bannerDAOImpl.updateBanner(bannerDO);
			BannerDO updateBannerDO = bannerDAOImpl.getBannerDO(bannerDO.getBannerId());
			Assert.assertEquals("Banner name update", updateBannerDO.getBannerName());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private BannerGroupDO getBannerGroupDO() {
		BannerGroupDO bannerGroupDO = new BannerGroupDO();
		bannerGroupDO.setBannerGroupName("BannerGroup");
		bannerGroupDO.setBannerSize("2");
		bannerGroupDO.setSortOrder(1);
		return bannerGroupDO;
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
			BannerGroupDO bannerGroupDO = getBannerGroupDO();
			bannerGroupDAOImpl.addBannerGroup(bannerGroupDO);
			bannerDO.setBannerGroupDO(bannerGroupDO);
			bannerDAOImpl.addBanner(bannerDO);
			List<BannerDO> bannerDOs = bannerDAOImpl.getBannerDetail();
			Assert.assertNotNull(bannerDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
}