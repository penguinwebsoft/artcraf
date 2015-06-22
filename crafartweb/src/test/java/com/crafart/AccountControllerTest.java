/**
 * 
 */
package com.crafart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.service.businessobjects.AccountBO;

/**
 * @author Karthi
 * @version 1.0
 *
 */

@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class AccountControllerTest {

	@Autowired
	public AccountController accountController;

	@Test
	@Rollback(true)
	public void testAddBankDetail() {
		AccountBO accountBO = getaccountdetail();
		try {
			accountController.addBankAccountDetail(accountBO, new MockHttpServletRequest());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	private AccountBO getaccountdetail() {
		AccountBO accountBO = new AccountBO();
		accountBO.setAccountName("wewe");
		accountBO.setAccountNumber("000011100");
		accountBO.setBankName("xxx");
		accountBO.setBranchName("yyy");
		accountBO.setIfscCode("101010aaa0");
		accountBO.setMicrCode("111000aaa111");
		accountBO.setType("qq");
		return accountBO;
	}
}
