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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.SellerDAO;
import com.crafart.dataobjects.SellerDO;

/**
 * Unit test for simple App.
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SellerDAOTest {

	private static final Logger log = Logger.getLogger(SellerDAOTest.class);

	@Autowired
	private SellerDAO sellerDAOImpl;

	/**
	 * test case for addSeller method
	 */
	@Test
	@Rollback(true)
	public void testAddSeller() {
		try {
			SellerDO sellerDO = getSellerDO();
			sellerDAOImpl.addSeller(sellerDO);
			log.info("Seller id is" + sellerDO.getSellerId());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Transactional(propagation = Propagation.REQUIRED)
	private SellerDO getSellerDO() {
		SellerDO sellerDO = new SellerDO();
		sellerDO.setFirstName("xxxx");
		sellerDO.setLastName("yyyy");
		sellerDO.setTin_no(1);
		sellerDO.setGender(1);
		sellerDO.setDateOfBirth("00/00/0000");
		sellerDO.setCompanyName("penguin");
		sellerDO.setCompanyLogo("pen");
		sellerDO.setEpch_no("123");
		sellerDO.setVat_no("123456a");
		sellerDO.setCst_no("000");
		sellerDO.setCommission("aaaa");
		sellerDO.setStatus(1);
		sellerDO.setApproved(1);
		return sellerDO;
	}
}
