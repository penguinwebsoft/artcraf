/**
 * 
 */
package com.crafart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CrafartUserDO;
import com.crafart.dataobjects.UserGroupDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CrafartUserDAO;
import com.crafart.inter.data.UserGroupDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CrafartUserDAOTest {

	@Autowired
	private CrafartUserDAO crafartUserDAOImpl;

	@Autowired
	private UserGroupDAO userGroupDAOImpl;

	/*
	 * Test case to add data in category table
	 */

	@Test
	@Rollback(true)
	public void testAddCrafartUser() {
		CrafartUserDO crafartUserDO = getCrafartUser();
		try {
			crafartUserDAOImpl.addCrafartUser(crafartUserDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private CrafartUserDO getCrafartUser() {
		CrafartUserDO crafartUserDO = new CrafartUserDO();
		UserGroupDO userGroupDO = getUserGroup();
		crafartUserDO.setFirstName("klkl");
		crafartUserDO.setIp("127.127.00.91");
		crafartUserDO.setLastName("jkjk");
		crafartUserDO.setPassword("opopop");
		crafartUserDO.setSellerPermission(1);
		crafartUserDO.setStatus(1);
		crafartUserDO.setUserGroupDO(userGroupDO);
		crafartUserDO.setUserName("klkl jkjk");
		return crafartUserDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private UserGroupDO getUserGroup() {
		UserGroupDO userGroupDO = new UserGroupDO();
		userGroupDO.setName("Admin");
		userGroupDO.setPermission("Accessed");
		try {
			userGroupDAOImpl.addUserGroup(userGroupDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return userGroupDO;

	}
}
