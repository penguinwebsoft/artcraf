/**
 * 
 */
package com.crafart;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CommisionDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.StoreDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CommissionDAO;
import com.crafart.inter.data.SellerDAO;
import com.crafart.inter.data.StoreDAO;

/**
 * @author Karthi
 * @version 1.0
 *
 */
/**
 * Unit test for simple App.
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class StoreDAOTest {

	private static final Logger log = Logger.getLogger(StoreDAOTest.class);

	@Autowired
	private StoreDAO storeDAOImpl;
	
	@Autowired
	private CommissionDAO commissionDAOImpl;

	@Autowired
	private SellerDAO sellerDAOImpl;

	/*
	 * Test case to add data in store table
	 */

	@Test
	@Rollback(true)
	public void testStoreDetail() {

		StoreDO storeDO = getStoreDO();
		try {
			storeDAOImpl.addStoreDetail(storeDO);
			log.info("store_id " + storeDO.getStoreId());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private StoreDO getStoreDO() {
		SellerDO sellerDO = getSellerDO();
		StoreDO storeDO = new StoreDO();
		storeDO.setName("zzz");
		storeDO.setStoreDescription("aaaa mmmmm nnnn jjjj lll");
		storeDO.setStoreReturn("llll kkkkk jjjj iii oo hhhhh yyyy");
		storeDO.setSellerDO(sellerDO);
		storeDO.setStoreUrl("www.oooo.ooo");
		return storeDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private SellerDO getSellerDO() {
		SellerDO sellerDO = new SellerDO();
		sellerDO.setFirstName("xxxx");
		sellerDO.setLastName("yyyy");
		sellerDO.setTin_no(1);
		sellerDO.setGender(1);
		sellerDO.setDateOfBirth("00/00/0012");
		sellerDO.setCompanyName("penguin");
		sellerDO.setCompanyLogo("pen");
		sellerDO.setEpch_no("123");
		sellerDO.setVat_no("123456a");
		sellerDO.setCst_no("000");
		sellerDO.setCommisionDO(getCommission());
		sellerDO.setStatus(1);
		sellerDO.setApproved(1);
		try {
			sellerDAOImpl.addSeller(sellerDO);
			sellerDO.setSellerId(sellerDO.getSellerId());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
		}
		return sellerDO;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	private CommisionDO getCommission() {
		CommisionDO commissionDO = new CommisionDO();
		commissionDO.setName("qwqw");
		commissionDO.setSortOrder(2);
		commissionDO.setType("comm");
		commissionDO.setValue(3.5f);
		try {
			commissionDAOImpl.addCommission(commissionDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return commissionDO;
	}

	/*
	 * Test case to check
	 */
	@Test
	@Ignore
	@Rollback(true)
	public void testCheckStoreUrl() {
		try {
			StoreDO storeDO1 = getStoreDO();
			storeDAOImpl.addStoreDetail(storeDO1);
			StoreDO storeDO = storeDAOImpl.checkStoreUrl(storeDO1.getStoreUrl());
			Assert.assertNotNull(storeDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

}
