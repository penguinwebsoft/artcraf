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

import com.crafart.service.businessobjects.BannerBO;
import com.crafart.service.businessobjects.BannerGroupBO;

@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class BannerControllerTest {

	@Autowired
	private BannerController bannerController;

	@Autowired
	private BannerGroupController bannerGroupController;
	
	@Test
	@Rollback(true)
	public void testGetBanner() {
		try {
			bannerController.getBanner(new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	@Rollback(true)
	public void testAddBanner() {
		try {
			BannerGroupBO bannerGroupBO = getBannerGroup();
			bannerGroupController.addBannerGroup(bannerGroupBO, new MockHttpSession());
			BannerBO bannerBO = getBanner();
			bannerBO.setBannerGroupBO(bannerGroupBO);
			bannerController.addBanner(bannerBO, new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@SuppressWarnings("unused")
	private BannerBO getBanner() {
		BannerBO bannerBO = new BannerBO();
		bannerBO.setBannerName("banner name");
		bannerBO.setBannerUrl("sgxshxbsbb");
		bannerBO.setBannerImage("fjdfn");
		bannerBO.setSortOrder(90);
		return bannerBO;
	}
	
	@SuppressWarnings("unused")
	private BannerGroupBO getBannerGroup() {
		BannerGroupBO bannerGroupBO = new BannerGroupBO(0, "banner group name", "banner size", 2);
		return bannerGroupBO;
	}
}

