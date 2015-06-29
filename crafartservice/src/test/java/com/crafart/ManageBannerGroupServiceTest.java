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

import com.crafart.inter.service.ManageBannerGroupService;
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
public class ManageBannerGroupServiceTest {

	@Autowired
	public ManageBannerGroupService manageBannerGroupServiceImpl;

	@Test
	@Rollback(true)
	public void testAddBannerGroupDetail() {
		BannerGroupBO bannerGroupBO = getBannerGroup();
		try {
			manageBannerGroupServiceImpl.addBannerGroupDetail(bannerGroupBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	private BannerGroupBO getBannerGroup() {
		BannerGroupBO bannerGroupBO = new BannerGroupBO();
		bannerGroupBO.setBannerGroupName("ngfn");
		bannerGroupBO.setBannerSize("gfbfgbf");
		bannerGroupBO.setSortOrder(689);
		return bannerGroupBO;
	}

	@Test
	@Rollback(true)
	public void testGetBannerGroupDetail() {
		BannerGroupBO bannerGroupBO = getBannerGroup();
		try {
			manageBannerGroupServiceImpl.addBannerGroupDetail(bannerGroupBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			@SuppressWarnings("unused")
			List<BannerGroupBO> bannerGroupBOs = manageBannerGroupServiceImpl.getBannerGroupDetail();
			
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}
}
