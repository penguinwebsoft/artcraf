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

import com.crafart.service.businessobjects.UserGroupBO;


@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class UserGroupControllerTest {

	@Autowired
	private UserGroupController userGroupController;

	@Test
	@Rollback(true)
	public void testGetUserGroup() {
		try {
			userGroupController.getUserGroup(new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@SuppressWarnings("unused")
	private UserGroupBO getUserGroupdetail() {
		UserGroupBO userGroupBO = new UserGroupBO();
		userGroupBO.setUserName("admin");
		userGroupBO.setPermission("allowed");
		userGroupBO.setSortOrder(90);
		return userGroupBO;
	}
}

