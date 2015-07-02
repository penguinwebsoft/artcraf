package com.crafart;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.UserDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.UserDAO;

/**
 * 
 * @author
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserDAOTest {

	@Autowired
	private UserDAO userDAOImpl;

	@Test
	public void dummy(){
		
	}
	/*
	 * Test case to add data in user table
	 */
	@Ignore
	@Rollback(true)
	public void testAddUserDetail() {
		UserDO userDO = getUser();
		try {
			userDAOImpl.addUserDetail(userDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private UserDO getUser() {
		UserDO userDO = new UserDO();
		userDO.setUserGroupId(777);
		userDO.setUserName("dcjdj");
		userDO.setFirstName("snd");
		userDO.setLastName("jxas");
		userDO.setPassword("ghh");
		userDO.setIsActive("enable");
		return userDO;
	}
	/*
	 * Test case is to retrieve details from userDetails table
	 */
	@Ignore
	@Rollback(true)
	public void testGetUserDetail() {
		UserDO userDO = getUser();
		try {
			userDAOImpl.addUserDetail(userDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		try {
			List<UserDO> userDOs = userDAOImpl.getUserDetail();
			Assert.assertNotNull(userDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
}
