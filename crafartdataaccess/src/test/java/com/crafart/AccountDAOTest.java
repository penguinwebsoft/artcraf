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

import com.crafart.dataobjects.AccountDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AccountDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class AccountDAOTest {

	@Autowired
	private AccountDAO accountDAOImpl;

	/**
	 * test case for addBankAccountDetail method using {@link AccountDAO} object
	 * here, calling the method addBankAccountDetail by passing
	 * {@link AccountDO} object
	 */
	@Test
	@Rollback(true)
	public void testAddAccount() {
		AccountDO accountDO = addAccount();
		try {
			accountDAOImpl.addBankAccountDetail(accountDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private AccountDO addAccount() {
		AccountDO accountDO = new AccountDO();
		accountDO.setAccountName("asas");
		accountDO.setAccountNumber("as010101");
		accountDO.setBankName("qqqq");
		accountDO.setBranchName("wwww");
		accountDO.setIfscCode("xxx000xxx0");
		accountDO.setMicrCode("0000qqqq0q");
		accountDO.setType("zz");
		return accountDO;

	}

}
