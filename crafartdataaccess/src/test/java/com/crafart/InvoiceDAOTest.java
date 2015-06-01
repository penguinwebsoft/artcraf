/**
 * 
 */
package com.crafart;

import java.util.ArrayList;
import java.util.List;

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

import com.crafart.dataobjects.AddressDO;
import com.crafart.dataobjects.CustomerDO;
import com.crafart.dataobjects.InvoiceDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.StoreDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CustomerDAO;
import com.crafart.inter.data.InvoiceDAO;
import com.crafart.inter.data.SellerDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class InvoiceDAOTest {

	@Autowired
	private InvoiceDAO invoiceDAOImpl;

	@Autowired
	private SellerDAO sellerDAOImpl;

	@Autowired
	private CustomerDAO customerDAOImpl;

	/*
	 * Test case to add data in Invoice table
	 */
	@Test
	@Rollback(true)
	public void testAddInvoice() {
		InvoiceDO invoiceDO = getInvoice();
		try {
			invoiceDAOImpl.addInvoice(invoiceDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private InvoiceDO getInvoice() {
		InvoiceDO invoiceDO = new InvoiceDO();
		invoiceDO.setInvoiceDate("10-00-0000");
		invoiceDO.setInvoiceNo("100bv002");
		invoiceDO.setInvoicePrefix('!');
		invoiceDO.setCustomerDO(getCustomer());
		invoiceDO.setSellerDO(getSeller());
		return invoiceDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private CustomerDO getCustomer() {
		CustomerDO customerDO = new CustomerDO();
		customerDO.setDateOfBirth("00-00-1000");
		customerDO.setFirstName("jkjk");
		customerDO.setGender(0);
		customerDO.setLastName("kjkj");
		customerDO.setIp("120000001200");
		customerDO.setPassword("klklkl");
		customerDO.setStatus(1);
		try {
			customerDAOImpl.addCustomer(customerDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			//Assert.fail();
		}
		return customerDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private SellerDO getSeller() {
		SellerDO sellerDO = new SellerDO();
		sellerDO.setFirstName("craf");
		sellerDO.setLastName("art");
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
		sellerDO.setStoreDO(getStoreDOs(sellerDO));
		List<SellerDO> sellerDOs = new ArrayList<>();
		sellerDOs.add(sellerDO);
		sellerDO.setAddressDOs(getAddressDOs(sellerDOs));
		try {
			sellerDAOImpl.addSeller(sellerDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
		}
		return sellerDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<AddressDO> getAddressDOs(List<SellerDO> sellerDOs) {
		AddressDO addressDO = new AddressDO();
		addressDO.setCityId(1);
		addressDO.setPinCode("001100");
		addressDO.setSellerDOs(sellerDOs);
		addressDO.setStateId(2);
		addressDO.setStreet("qwertyuiop");
		List<AddressDO> addressDOs = new ArrayList<>();
		addressDOs.add(addressDO);
		return addressDOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private StoreDO getStoreDOs(SellerDO sellerDO) {
		StoreDO storeDO = new StoreDO();
		storeDO.setName("store craf");
		storeDO.setStoreDescription("penguin store");
		storeDO.setStoreReturn("test desc");
		storeDO.setStoreUrl("acx");
		storeDO.setSellerDO(sellerDO);
		/*
		 * List<StoreDO> storeDOs = new ArrayList<>(); storeDOs.add(storeDO);
		 */
		return storeDO;
	}
}
