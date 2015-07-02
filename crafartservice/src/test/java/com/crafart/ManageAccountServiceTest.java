/**
 * 
 */
package com.crafart;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.inter.service.ManageAccountService;
import com.crafart.service.businessobjects.AccountBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ManageAccountServiceTest {

	public static final Logger log = Logger.getLogger(ManageAccountServiceTest.class);

	@Autowired
	private ManageAccountService manageAccountServiceImpl;

	@Test
	@Rollback(true)
	public void testAddBankAccountDetail() {
		AccountBO accountBO = getAccountDaetail();
		try {
			manageAccountServiceImpl.addBankAccountDetail(accountBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	private AccountBO getAccountDaetail() {
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
