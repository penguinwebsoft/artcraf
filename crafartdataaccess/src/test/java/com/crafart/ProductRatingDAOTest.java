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
import com.crafart.dataobjects.CategoryDO;
import com.crafart.dataobjects.CommisionDO;
import com.crafart.dataobjects.ContactDO;
import com.crafart.dataobjects.CustomerDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.ProductRatingDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.SeoDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CategoryDAO;
import com.crafart.inter.data.CommissionDAO;
import com.crafart.inter.data.CustomerDAO;
import com.crafart.inter.data.ProductDAO;
import com.crafart.inter.data.ProductRatingDAO;
import com.crafart.inter.data.SellerDAO;
import com.crafart.inter.data.SeoDAO;
import com.crafart.inter.data.WeightClassDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ProductRatingDAOTest {

	@Autowired
	private ProductRatingDAO productRatingDAOImpl;
	
	@Autowired
	private CommissionDAO commissionDAOImpl;

	@Autowired
	private ProductDAO productDAOImpl;

	@Autowired
	private SellerDAO sellerDAOImpl;

	@Autowired
	private WeightClassDAO weightClassDAOImpl;

	@Autowired
	private CustomerDAO customerDAOImpl;

	@Autowired
	private CategoryDAO categoryDAOImpl;

	@Autowired
	private SeoDAO seoDAOImpl;
	/*
	 * Test case to add data in product Rating table
	 */

	@Test
	@Rollback(true)
	public void testAddRating() {
		ProductRatingDO productRatingDO = getProductRating();
		try {
			productRatingDAOImpl.addProductRating(productRatingDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private ProductRatingDO getProductRating() {
		ProductRatingDO productRatingDO = new ProductRatingDO();
		ProductDO productDO = getProduct();
		CustomerDO customerDO = getCustomer();
		productRatingDO.setCustomerDO(customerDO);
		productRatingDO.setProductDO(productDO);
		productRatingDO.setPoints(3);
		return productRatingDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private ProductDO getProduct() {
		SellerDO sellerDO = getSellerDO();
		List<SellerDO> sellerDOs = new ArrayList<>();
		sellerDOs.add(sellerDO);
		ProductDO productDO = new ProductDO();
		productDO.setCategoryId(getCategoryDO().getCategoryId());
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

	@Transactional(propagation = Propagation.REQUIRED)
	private CommisionDO getCommission() {
		CommisionDO commissionDO = new CommisionDO();
		commissionDO.setName("qwqw");
		commissionDO.setSortOrder(2);
		commissionDO.setType("comm");
		commissionDO.setValue(3.5f);
		try {
			commissionDAOImpl.addCommision(commissionDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return commissionDO;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	private SellerDO getSellerDO() {
		SellerDO sellerDO = new SellerDO();
		sellerDO.setFirstName("xxxx");
		sellerDO.setLastName("yyyy");
		sellerDO.setTin_no(1);
		sellerDO.setDateOfBirth("00/00/1300");
		sellerDO.setGender(1);
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
	private CustomerDO getCustomer() {
		CustomerDO customerDO = new CustomerDO();
		customerDO.setDateOfBirth("00-00-1000");
		customerDO.setFirstName("satur");
		customerDO.setGender(0);
		customerDO.setLastName("day");
		customerDO.setIp("120000001200");
		customerDO.setPassword("klklkl");
		customerDO.setStatus(1);
		List<CustomerDO> customerDOs = new ArrayList<>();
		customerDOs.add(customerDO);
		customerDO.setContactDOs(getContactDOs(customerDOs));
		customerDO.setAddressDOs(getAddressDOs(customerDOs));
		try {
			customerDAOImpl.addCustomer(customerDO);
			customerDO.setCustomerId(customerDO.getCustomerId());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return customerDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<AddressDO> getAddressDOs(List<CustomerDO> customerDOs) {
		List<AddressDO> addressDOs = new ArrayList<>();
		AddressDO addressDO = new AddressDO();
		addressDO.setCityId(047);
		addressDO.setPinCode("639117");
		addressDO.setStateId(047);
		addressDO.setStreet("2a nagar");
		addressDOs.add(addressDO);
		return addressDOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<ContactDO> getContactDOs(List<CustomerDO> customerDOs) {
		List<ContactDO> contactDOs = new ArrayList<>();
		ContactDO contactDO = new ContactDO();
		contactDO.setContactTypeId(1);
		contactDO.setContactValue("9999900000");
		contactDO.setCustomerDOs(customerDOs);
		ContactDO contactDO2 = new ContactDO();
		contactDO2.setContactTypeId(2);
		contactDO2.setContactValue("044-505000");
		contactDO2.setCustomerDOs(customerDOs);
		ContactDO contactDO3 = new ContactDO();
		contactDO3.setContactTypeId(3);
		contactDO3.setContactValue("asass@iii.com");
		contactDO3.setCustomerDOs(customerDOs);
		contactDOs.add(contactDO);
		contactDOs.add(contactDO2);
		contactDOs.add(contactDO3);
		return contactDOs;
	}
	
	/*
	 * Test case is to retrieve product rating detail from product rating table
	 */

	@Test
	@Rollback(true)
	public void testGetProductRating() {
		ProductRatingDO productRatingDO = getProductRating();
		try {
			productRatingDAOImpl.addProductRating(productRatingDO);
			List<ProductRatingDO> productRatingDOs = productRatingDAOImpl.getProductRating(productRatingDO.getCustomerDO().getCustomerId());
			for (ProductRatingDO productRatingDO2 : productRatingDOs) {
				System.out.print(productRatingDO2.getPoints() + "\t" + productRatingDO2.getProductRatingId());
			}
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
	
	private CategoryDO getCategoryDO() {
		CategoryDO categoryDO = new CategoryDO();
		try {

			categoryDO.setImageLocation("");
			categoryDO.setSortOrder(2);
			categoryDO.setStatus(2);
			categoryDO.setSeoDO(getSeo());
			categoryDO.setDescription("Its gold jwellery");
			categoryDO.setCategoryName("gold");
			categoryDAOImpl.addCategory(categoryDO);

		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return categoryDO;
	}

	private SeoDO getSeo() {
		SeoDO seoDO = new SeoDO();
		seoDO.setMetaDesc("abc");
		seoDO.setMetaKeyword("cde");
		seoDO.setMetaTitle("jkl");
		try {
			seoDAOImpl.addSeo(seoDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return seoDO;
	}
}
