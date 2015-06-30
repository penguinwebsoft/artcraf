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

import com.crafart.dataobjects.UserGroupDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.UserGroupDAO;

/**
 * 
 * @author 
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserGroupDAOTest {

	@Autowired
	private UserGroupDAO userGroupDAOImpl;

	/*
	 * Test case to add data in userGroup table
	 */
	@Test
	@Rollback(true)
	public void testAddUserGroupDetail() {
		UserGroupDO userGroupDO = getUserGroup();
		try {
			userGroupDAOImpl.addUserGroup(userGroupDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private UserGroupDO getUserGroup() {
		UserGroupDO userGroupDO = new UserGroupDO();
		userGroupDO.setGroupName("cddscm");
		userGroupDO.setPermission("dcmd");
		userGroupDO.setSortOrder(1);
		return userGroupDO;
	}
	/*
	 * Test case is to retrieve details from userGroup table
	 */
	@Test
	@Rollback(true)
	public void testGetUserGroupDetail() {
		UserGroupDO userGroupDO = getUserGroup();
		try {
			userGroupDAOImpl.addUserGroup(userGroupDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		try {
			List<UserGroupDO> userGroupDOs = userGroupDAOImpl.getUserGroupDetail();
			Assert.assertNotNull(userGroupDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
}
