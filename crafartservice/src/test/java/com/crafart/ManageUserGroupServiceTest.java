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

import com.crafart.inter.service.ManageUserGroupService;
import com.crafart.service.businessobjects.UserGroupBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml",
		"classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageUserGroupServiceTest {

	@Autowired
	private ManageUserGroupService manageUserGroupServiceImpl;

	@Test
	@Rollback(true)
	public void testAddUserGroupDetail() {
		UserGroupBO userGroupBO = getUserGroup();
		try {
			manageUserGroupServiceImpl.addUserGroupDetail(userGroupBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testGetUserGroupDetail() {
		try {
			List<UserGroupBO> userGroupBOs = manageUserGroupServiceImpl.getUserGroupDetail();
			Assert.assertNotNull(userGroupBOs);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	private UserGroupBO getUserGroup() {
		UserGroupBO userGroupBO = new UserGroupBO();
		userGroupBO.setUserName("Admin");
		userGroupBO.setPermission("cbhdd");
		userGroupBO.setSortOrder(9);
		return userGroupBO;
	}
}
