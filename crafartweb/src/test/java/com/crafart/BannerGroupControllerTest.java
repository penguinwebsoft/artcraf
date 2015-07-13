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

import com.crafart.service.businessobjects.BannerGroupBO;

/**
 * @author
 * 
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class BannerGroupControllerTest {

	@Autowired
	private BannerGroupController bannerGroupController;

	@Test
	@Rollback(true)
	public void testGetBannerGroup() {
		try {
			bannerGroupController.getBannerGroup(new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@SuppressWarnings("unused")
	private BannerGroupBO getBannerGroupdetail() {
		BannerGroupBO bannerGroupBO = new BannerGroupBO(0, "banner group name", "banner size", 2);
		return bannerGroupBO;
	}
}
