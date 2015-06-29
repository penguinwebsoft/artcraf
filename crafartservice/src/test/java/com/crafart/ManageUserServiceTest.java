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

import com.crafart.inter.service.ManageUserService;
import com.crafart.service.businessobjects.UserBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author 
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageUserServiceTest {

	@Autowired
	public ManageUserService manageUserServiceImpl;

	@Test
	@Rollback(true)
	public void testAddUserDetail() {
		UserBO userBO = getUser();
		try {
			manageUserServiceImpl.addUserDetail(userBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	private UserBO getUser() {
		UserBO userBO = new UserBO();
		userBO.setUserName("admin");
		userBO.setFirstName("sdh");
		userBO.setLastName("jdsa");
		userBO.setPassword("ysggd");
		userBO.setIsActive("enable");
		
		return userBO;
	}

	@Test
	@Rollback(true)
	public void testGetUserDetail() {
		UserBO userBO = getUser();
		try {
			manageUserServiceImpl.addUserDetail(userBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			@SuppressWarnings("unused")
			List<UserBO> userBOs = manageUserServiceImpl.getUserDetail();
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}
}
