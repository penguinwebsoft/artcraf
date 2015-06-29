/**
 * 
 */
package com.crafart;

import java.util.ArrayList;
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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.AddressDO;
import com.crafart.dataobjects.CommissionDO;
import com.crafart.dataobjects.CourierDO;
import com.crafart.dataobjects.CrafartOrderDO;
import com.crafart.dataobjects.CrafartUserDO;
import com.crafart.dataobjects.CurrencyDO;
import com.crafart.dataobjects.CustomerDO;
import com.crafart.dataobjects.InvoiceDO;
import com.crafart.dataobjects.LengthClassDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.StoreDO;
import com.crafart.dataobjects.TaxRateDO;
import com.crafart.dataobjects.UserGroupDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CommissionDAO;
import com.crafart.inter.data.CourierDAO;
import com.crafart.inter.data.CrafartOrderDAO;
import com.crafart.inter.data.CrafartUserDAO;
import com.crafart.inter.data.CurrencyDAO;
import com.crafart.inter.data.CustomerDAO;
import com.crafart.inter.data.InvoiceDAO;
import com.crafart.inter.data.LengthClassDAO;
import com.crafart.inter.data.ProductDAO;
import com.crafart.inter.data.SellerDAO;
import com.crafart.inter.data.TaxRateDAO;
import com.crafart.inter.data.UserGroupDAO;
import com.crafart.inter.data.WeightClassDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CrafartOrderDAOTest {

	@Autowired
	private CrafartOrderDAO crafartOrderDAOImpl;

	@Autowired
	private CurrencyDAO currencyDAOImpl;

	@Autowired
	private CommissionDAO commissionDAOImpl;

	@Autowired
	private CrafartUserDAO crafartUserDAOImpl;

	@Autowired
	private CustomerDAO customerDAOImpl;

	@Autowired
	private SellerDAO sellerDAOImpl;

	@Autowired
	private ProductDAO productDAOImpl;

	@Autowired
	private LengthClassDAO lengthClassDAOImpl;

	@Autowired
	private WeightClassDAO weightClassDAOImpl;

	@Autowired
	private TaxRateDAO taxRateDAOImpl;

	@Autowired
	private InvoiceDAO invoiceDAOImpl;

	@Autowired
	private CourierDAO courierDAOImpl;

	@Autowired
	private UserGroupDAO userGroupDAOImpl;

	/*
	 * Test case to add data in crafart_order table
	 */
	@Test
	@Rollback(true)
	public void testAddCrafartOrder() {
		CrafartOrderDO crafartOrderDO = getCrafartOrder();
		try {
			crafartOrderDAOImpl.addCrafartOrder(crafartOrderDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	/*
	 * Test case is to retrieve details from crafart_order table
	 */

	@Test
	@Ignore
	@Rollback(true)
	public void testGetCrafartOrder() {
		/* adding data to table and then retrieving from table */
		try {
			List<CrafartOrderDO> crafartOrderDOs = crafartOrderDAOImpl
					.getCrafartOrder();
			Assert.assertNotNull(crafartOrderDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	/*
	 * Test case to update the crafart_order table
	 */
	@Test
	@Rollback(true)
	public void testUpdateCrafartOrder() {
		CrafartOrderDO crafartOrderDO = getCrafartOrder();
		try {
			crafartOrderDAOImpl.addCrafartOrder(crafartOrderDO);
			crafartOrderDO.getCustomerDO().setFirstName("dhoni");
			crafartOrderDO.getCourierDO().setCourierName("ranchi");
			crafartOrderDO.getProductDO().setModel("abc0001111");
			crafartOrderDAOImpl.updateCrafartOrder(crafartOrderDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	/*
	 * Test case to get single order detail
	 */

	@Test
	@Ignore
	@Rollback(true)
	public void testGetCustomerOrderList() {
		CrafartOrderDO crafartOrderDO = getCrafartOrder();
		try {
			crafartOrderDAOImpl.addCrafartOrder(crafartOrderDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		try {
			List<CrafartOrderDO> crafartOrderDOs = crafartOrderDAOImpl
					.getCustomerOrder(crafartOrderDO.getCustomerDO()
							.getCustomerId());
			Assert.assertNotNull(crafartOrderDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public CrafartOrderDO getCrafartOrder() {
		SellerDO sellerDO = getSeller();
		List<SellerDO> sellerDOs = new ArrayList<>();
		sellerDOs.add(sellerDO);
		ProductDO productDO = getProduct(sellerDOs);
		CurrencyDO currencyDO = getCurrency();
		CommissionDO commissionDO = getCommission();
		CrafartUserDO crafartUserDO = getCrafartUser();
		CustomerDO customerDO = getCustomer();
		InvoiceDO invoiceDO = getInvoice(customerDO, sellerDO);
		CourierDO courierDO = getCourier();
		CrafartOrderDO crafartOrderDO = new CrafartOrderDO();
		crafartOrderDO.setComment("aaaa");
		crafartOrderDO.setForwardedIp("127 127 127 00");
		crafartOrderDO.setOrderIp("127 152 141 152");
		crafartOrderDO.setOrderStatusId(1);
		crafartOrderDO.setTotal(154);
		crafartOrderDO.setCurrencyDO(currencyDO);
		crafartOrderDO.setCommissionDO(commissionDO);
		crafartOrderDO.setCrafartUserDO(crafartUserDO);
		crafartOrderDO.setCustomerDO(invoiceDO.getCustomerDO());
		crafartOrderDO.setInvoiceDO(invoiceDO);
		crafartOrderDO.setTaxRateDO(getTaxRate(productDO, sellerDO));
		crafartOrderDO.setProductDO(productDO);
		crafartOrderDO.setStoreDO(sellerDO.getStoreDO());
		crafartOrderDO.setCourierDO(courierDO);
		return crafartOrderDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private CourierDO getCourier() {
		CourierDO courierDO = new CourierDO();
		courierDO.setImage("asdfgh");
		courierDO.setCourierName("BlueDart");
		courierDO.setEstimatedDeliveryTime("gjtr");
		courierDO.setSortOrder(1);
		try {
			courierDAOImpl.addCourierDetail(courierDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return courierDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private TaxRateDO getTaxRate(ProductDO productDO, SellerDO sellerDO) {
		TaxRateDO taxRateDO = new TaxRateDO();
		taxRateDO.setProductDO(productDO);
		taxRateDO.setSellerId(sellerDO.getSellerId());
		taxRateDO.setName("qqq");
		taxRateDO.setRate(1);
		taxRateDO.setType("nnnn");
		try {
			taxRateDAOImpl.addTaxRate(taxRateDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return taxRateDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private InvoiceDO getInvoice(CustomerDO customerDO, SellerDO sellerDO) {
		InvoiceDO invoiceDO = new InvoiceDO();
		invoiceDO.setInvoiceDate("10-00-0000");
		invoiceDO.setInvoiceNo("100bv002");
		invoiceDO.setInvoicePrefix('$');
		invoiceDO.setCustomerDO(customerDO);
		invoiceDO.setSellerDO(sellerDO);
		try {
			invoiceDAOImpl.addInvoice(invoiceDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return invoiceDO;
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
		sellerDO.setCommissionDO(getCommission());
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
			Assert.fail();
		}
		return customerDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private CurrencyDO getCurrency() {
		CurrencyDO currencyDO = new CurrencyDO();
		currencyDO.setCode("klkl");
		currencyDO.setDecimalPlace(9);
		currencyDO.setStatus("sdsd");
		currencyDO.setSymbolRight("$");
		currencyDO.setSymbolRight("$");
		currencyDO.setTitle("jkl");
		currencyDO.setValue(5);
		try {
			currencyDAOImpl.addCurrency(currencyDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return currencyDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private CommissionDO getCommission() {
		CommissionDO commissionDO = new CommissionDO();
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
		try {
			crafartUserDAOImpl.addCrafartUser(crafartUserDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return crafartUserDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private UserGroupDO getUserGroup() {
		UserGroupDO userGroupDO = new UserGroupDO();
		userGroupDO.setGroupName("Admin");
		userGroupDO.setPermission("Accessed");
		userGroupDO.setSortOrder(787);
		try {
			userGroupDAOImpl.addUserGroup(userGroupDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return userGroupDO;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	private ProductDO getProduct(List<SellerDO> sellerDOs) {
		ProductDO productDO = new ProductDO();
		productDO.setCategoryId(1);
		productDO.setDateAvailable("03-10-1982");
		productDO.setHeight(52);
		productDO.setImage("a15cb5e");
		productDO.setLength(63.2);
		productDO.setLocation("from service");
		productDO.setMinimum(26.00);
		productDO.setModel("service");
		productDO.setPoints(5);
		productDO.setPrice(12.2f);
		productDO.setQuantity("2");
		productDO.setSellerDOs(sellerDOs);
		productDO.setShipping(2);
		productDO.setSku("aqaqaq");
		productDO.setSortOrder("aes");
		productDO.setStatus(1);
		productDO.setStockStatusId("20");
		productDO.setSubtract(20.0001);
		productDO.setUpc("asd");
		productDO.setViewed(2);
		productDO.setWeight("25");
		productDO.setWeightClassDO(getWeightClass());
		productDO.setWidth(12.5);
		try {
			productDAOImpl.addProduct(productDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return productDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private LengthClassDO getLengthClass() {
		LengthClassDO lengthClassDO = new LengthClassDO();
		lengthClassDO.setTitle("from dao");
		lengthClassDO.setIsActive(0);
		try {
			lengthClassDAOImpl.addLengthClass(lengthClassDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return lengthClassDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private WeightClassDO getWeightClass() {
		WeightClassDO weightClassDO = new WeightClassDO();
		weightClassDO.setTitle("from dao");
		weightClassDO.setUnit(12.5);
		weightClassDO.setValue(12.5f);
		try {
			weightClassDAOImpl.addWeightClass(weightClassDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return weightClassDO;
	}

}
