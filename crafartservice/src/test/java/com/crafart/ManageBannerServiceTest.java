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

import com.crafart.inter.service.ManageBannerGroupService;
import com.crafart.inter.service.ManageBannerService;
import com.crafart.service.businessobjects.BannerBO;
import com.crafart.service.businessobjects.BannerGroupBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageBannerServiceTest {

	@Autowired
	public ManageBannerService manageBannerServiceImpl;

	@Autowired
	public ManageBannerGroupService manageBannerGroupServiceImpl;

	@Test
	@Rollback(true)
	public void testAddBannerDetail() {
		BannerBO bannerBO = getBanner();
		try {
			bannerBO.setBannerGroupBO(getBannerGroupBO());
			manageBannerServiceImpl.addBanner(bannerBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testGtBanners() {
		BannerBO bannerBO = getBanner();
		try {
			bannerBO.setBannerGroupBO(getBannerGroupBO());
			manageBannerServiceImpl.addBanner(bannerBO);
			Map<Long, BannerBO> bannerBOs = manageBannerServiceImpl.getBanners();
			Assert.assertTrue(bannerBOs.size() >= 1);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	@Rollback(true)
	public void testGetBannerDetail() {
		BannerBO bannerBO = getBanner();
		try {
			bannerBO.setBannerGroupBO(getBannerGroupBO());
			manageBannerServiceImpl.addBanner(bannerBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			@SuppressWarnings("unused")
			Map<Long, BannerBO> bannerBOs = manageBannerServiceImpl.getBanners();
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	private BannerBO getBanner() {
		BannerBO bannerBO = new BannerBO();
		bannerBO.setBannerName("vdfv");
		bannerBO.setBannerImage("bvfd");
		bannerBO.setBannerUrl("fvfdv");
		bannerBO.setSortOrder(9);
		return bannerBO;
	}

	private BannerGroupBO getBannerGroupBO() {
		BannerGroupBO bannerGroupBO = new BannerGroupBO(0, "banner group", "size", 2);
		try {
			manageBannerGroupServiceImpl.addBannerGroup(bannerGroupBO);
		} catch (CrafartServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
		return bannerGroupBO;
	}
}
