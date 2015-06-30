/**
 * 
 */
package com.crafart;

import java.util.List;

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

import com.crafart.inter.service.ManageBannerService;
import com.crafart.service.businessobjects.BannerBO;
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

	@Test
	@Rollback(true)
	public void testAddBannerDetail() {
		BannerBO bannerBO = getBanner();
		try {
			manageBannerServiceImpl.addBannerDetail(bannerBO);
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

	@Test
	@Rollback(true)
	public void testGetBannerDetail() {
		BannerBO bannerBO = getBanner();
		try {
			manageBannerServiceImpl.addBannerDetail(bannerBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			@SuppressWarnings("unused")
			List<BannerBO> bannerBOs = manageBannerServiceImpl.getBannerDetail();
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}
}
